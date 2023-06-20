package 通过私有构造器强化不可实例化的能力;

/**
 * @Author: yejunyu
 * @Date: Created in 2023/6/16
 * @Description: 工具类，不希望实例化，可以私有化构造函数
 **/
public final class UtilityClass {
    private UtilityClass() {
        throw new AssertionError();
    }

    public static String tool() {
        System.out.println("这是一个工具类，不希望实例化，也不希望被继承");
        return "";
    }
}
