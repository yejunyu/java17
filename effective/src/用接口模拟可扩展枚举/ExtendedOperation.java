package 用接口模拟可扩展枚举;

/**
 * @Author: yejunyu
 * @Date: Created in 2023/6/26
 * @Description: TODO
 **/
public enum ExtendedOperation implements Operation {
    EXP("^") {
        @Override
        public double apply(double x, double y) {
            return Math.pow(x, y);
        }
    },
    REMAINDER("%") {
        @Override
        public double apply(double x, double y) {
            return x % y;
        }
    },
    ;

    private final String symbol;

    ExtendedOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "ExtendedOperation{" +
                "symbol='" + symbol + '\'' +
                '}';
    }


    private static <T extends Enum<T> & Operation> void test(Class<T> opEnum, double x, double y) {
        for (Operation operation : opEnum.getEnumConstants()) {
            System.out.printf("%f %s %f = %f%n",
                    x, operation, y, operation.apply(x, y));
        }
    }

    public static void main(String[] args) {
        double x = 9;
        double y = 3;
        test(ExtendedOperation.class, x, y);
    }
}
