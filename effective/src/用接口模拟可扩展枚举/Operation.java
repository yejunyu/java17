package 用接口模拟可扩展枚举;

/**
 * @Author: yejunyu
 * @Date: Created in 2023/6/26
 * @Description: TODO
 **/
@FunctionalInterface
public interface Operation {
    double apply(double x, double y);
}
