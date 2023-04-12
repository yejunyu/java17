package com.yejunyu.seq;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

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
        return c->{

        }
    }
}
