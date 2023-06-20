package 用静态工厂方法代替构造器;

/**
 * @Author: yejunyu
 * @Date: Created in 2023/6/16
 * @Description: TODO
 **/
public class XxDo {

    public static XxDo valueOf(){
        return new XxDo();
    }
}
