package 用私有构造器或者枚举类型强化Singleton属性;

import java.io.Serial;
import java.io.Serializable;

/**
 * @Author: yejunyu
 * @Date: Created in 2023/6/16
 * @Description: TODO
 **/
public class Elvis implements Serializable {
    private static final Elvis INSTANCE = new Elvis();

    private Elvis() {
    }

    public static Elvis getInstance() {
        return INSTANCE;
    }

    public void leaveTheBuilding() {
    }

    /**
     * 仅仅在声明中加上 implements Serializable 是不够的 。 为了维护并保证 S ingl eton,
     * 必须声 明所有实例域都是瞬时（ transient ）的，并提供一个 readRe solve 方法（详见
     * 第四条） 。 否则 ，每次反序列化一个序列化的实例时＼都会创建一个新的实例，比如，在我
     * 们的例子中，会导致“假冒的 Elvis ” c 为了防止发生这种情况，要在 Elvis 类中加入如
     * 下 readResolve 方法：
     * @return
     */
    @Serial
    private Object readResolve(){
        return INSTANCE;
    }
}
