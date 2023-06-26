package 避免使用终结方法和清除方法;

import java.lang.ref.Cleaner;

/**
 * @Author: yejunyu
 * @Date: Created in 2023/6/19
 * @Description: 继承autoclose接口实现自动关闭资源
 **/
public class Room implements AutoCloseable {
    /**
     * 创建一个cleaner,作为一个兜底的策略清理房间
     */
    private static final Cleaner CLEANER = Cleaner.create();
    /**
     * room的清理状态，雨cleanable共享状态
     */
    private final State state;
    /**
     * 清理room，当符合gc条件的时候
     */
    private final Cleaner.Cleanable cleanable;

    public Room(int numJunkPiles) {
        state = new State(numJunkPiles);
        // 注册自己，第二个参数是一个runnable，清理的动作
        cleanable = CLEANER.register(this, state);
    }

    private static class State implements Runnable {
        /**
         * 房间垃圾的数量
         */
        int numJunkPiles;

        public State(int numJunkPiles) {
            this.numJunkPiles = numJunkPiles;
        }

        @Override
        public void run() {
            System.out.println("正在清理房间");
            // 清理垃圾，并把垃圾数置为0
            numJunkPiles = 0;
        }
    }

    @Override
    public void close() throws Exception {
        cleanable.clean();
    }

    public static void main(String[] args) {
        try (Room myroom = new Room(10)) {
            System.out.println("goodbye");
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
