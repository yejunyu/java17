package com.yejunyu.seq;

import java.util.*;
import java.util.function.*;
import java.util.stream.Stream;

/**
 * @Author yjy
 * @Date 2023/4/12
 **/
public interface Seq<T> {
    /**
     * 消费流
     *
     * @param consumer
     */
    void consume(Consumer<T> consumer);

    static <T> Seq<T> unit(T t) {
        return c -> c.accept(t);
    }

    // map
    default <E> Seq<E> map(Function<T, E> function) {
        return c -> consume(t -> c.accept(function.apply(t)));
    }

    default <E> Seq<E> flatMap(Function<T, Seq<E>> function) {
        return c -> consume(t -> function.apply(t).consume(c));
    }

    default Seq<T> filter(Predicate<T> predicate) {
        return c -> consume(t -> {
                    if (predicate.test(t)) {
                        c.accept(t);
                    }
                }
        );
    }

    static <T> T stop() {
        throw StopException.INSTANCE;
    }

    default void consumeTillStop(Consumer<T> consumer) {
        try {
            consume(consumer);
        } catch (StopException ignore) {

        }
    }

    /**
     * 对应stream的limit
     *
     * @param n
     * @return
     */
    default Seq<T> take(int n) {
        return c -> {
            int[] i = {n};
            consumeTillStop(t -> {
                if (i[0]-- > 0) {
                    c.accept(t);
                } else {
                    stop();
                }
            });
        };
    }

    default Seq<T> drop(int n) {
        return c -> {
            int[] a = {n};
            consume(t -> {
                if (a[0] <= 0) {
                    c.accept(t);
                } else {
                    a[0]--;
                }
            });
        };
    }

    /**
     * 对流的某个元素添加一个操作consumer，但是不执行流——对应Stream.peek。
     *
     * @param consumer
     * @return
     */
    default Seq<T> onEach(Consumer<T> consumer) {
        return c -> consume(consumer.andThen(c));
    }

    default <E, R> Seq<R> zip(Iterable<E> iterable, BiFunction<T, E, R> function) {
        return c -> {
            Iterator<E> iterator = iterable.iterator();
            consumeTillStop(t -> {
                if (iterator.hasNext()) {
                    c.accept(function.apply(t, iterator.next()));
                } else {
                    stop();
                }
            });
        };
    }

    /**
     * 终端操作
     *
     * @param separate
     * @return
     */
    default String join(String separate) {
        var joiner = new StringJoiner(separate);
        consume(t -> joiner.add(t.toString()));
        return joiner.toString();
    }

    default List<T> toList() {
        List<T> list = new ArrayList<>();
        consume(list::add);
        return list;
    }

    /**
     * 下划线转驼峰
     *
     * @param str
     * @return
     */
    static String underscoreToCamel(String str) {
        UnaryOperator<String> capitalize = s -> s.substring(0, 1).toUpperCase();
        // 利用生成器构造一个方法的流
        Seq<UnaryOperator<String>> seq = c -> {
            c.accept(String::toLowerCase);
            while (true) {
                c.accept(capitalize);
            }
        };
        List<String> split = Arrays.asList(str.split("_"));
        return seq.zip(split, Function::apply).join("");
    }

    public static void main(String[] args) {
        Stream<Integer> steam = Stream.of(1, 2, 3);
        Seq<Integer> seq = steam::forEach;
        List<Integer> integers = seq.map(m -> m + 1).toList();
        System.out.println(integers);
    }
}
