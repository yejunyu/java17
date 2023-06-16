package 用builder代替构造器;

import java.util.Objects;

/**
 * @Author: yejunyu
 * @Date: Created in 2023/6/13
 * @Description: TODO
 **/
public class NyPizza extends Pizza {
    public enum Size {SMALL, MEDIUM, LARGE}

    private final Size size;

    /**
     * 需要指定尺寸的披萨
     */
    public static class Builder extends Pizza.Builder<Builder> {
        private final Size size;

        public Builder(Size size) {
            this.size = Objects.requireNonNull(size);
        }

        @Override
        NyPizza build() {
            return new NyPizza(this);
        }

        @Override
        protected Builder self() {
            return this;
        }
    }

    private NyPizza(Builder builder) {
        super(builder);
        size = builder.size;
    }
}
