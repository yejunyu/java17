package 用接口模拟可扩展枚举;

/**
 * @Author: yejunyu
 * @Date: Created in 2023/6/26
 * @Description: TODO
 **/
public enum BasicOperation implements Operation {
    PLUS("+") {
        @Override
        public double apply(double x, double y) {
            return x + y;
        }
    },
    MINUS("-") {
        @Override
        public double apply(double x, double y) {
            return x - y;
        }
    },
    TIMES("*") {
        @Override
        public double apply(double x, double y) {
            return x * y;
        }
    },
    DIVIDE("/") {
        @Override
        public double apply(double x, double y) {
            return x / y;
        }
    },
    ;
    private final String symbol;

    BasicOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return "BasicOperation{" +
                "symbol='" + symbol + '\'' +
                '}';
    }
}
