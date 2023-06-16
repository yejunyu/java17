package 用builder代替构造器;

import java.util.EnumSet;
import java.util.Set;

/**
 * @Author: yejunyu
 * @Date: Created in 2023/6/13
 * @Description: TODO
 **/
public abstract class Pizza {
    public enum Topping {
        HAM, MUSHROOM, ONION, PEPPER, SAUSAGE
    }

    final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {
        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(Topping topping) {
            toppings.add(topping);
            return self();
        }

        abstract Pizza build();

        protected abstract T self();
    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }

    public static void main(String[] args) {
        Pizza pizza = new NyPizza.Builder(NyPizza.Size.SMALL).addTopping(Topping.MUSHROOM).build();
    }
}
