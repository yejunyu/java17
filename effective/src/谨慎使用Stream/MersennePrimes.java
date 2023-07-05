package 谨慎使用Stream;

import java.math.BigInteger;
import java.util.stream.Stream;

import static java.math.BigInteger.ONE;
import static java.math.BigInteger.TWO;

/**
 * @Author: yejunyu
 * @Date: Created in 2023/7/4
 * @Description: 2^p-1如果p是一个素数,相应的梅森数字也是素数,那么他就是一个梅森素数
 **/
public class MersennePrimes {

    static Stream<BigInteger> primes() {
        return Stream.iterate(TWO, BigInteger::nextProbablePrime);
    }


    /**
     * public boolean isProbablePrime (int certainty)
     * 参数 certainty 用来设置测量的不确定性容忍度
     * 如果调用返回true，那么这个BigInteger是质数的可能性超过(1 - 1/2 certainty)。
     * <p>
     * 当 certainty=1时，可能性是50%,
     * 当 certainty=2时，可能性是75%,
     * 当 certainty=3时，可能性是87.5%,
     * 当 certainty=4时，可能性是93.75%,
     * 当 certainty=5时，可能性是96.875%,
     * …
     * 当 certainty=10时，可能性是99.9%,
     * <p>
     * 一般取3就足够用了。
     *
     * @param args
     */
    public static void main(String[] args) {
        primes().map(p -> TWO.pow(p.intValueExact()).subtract(ONE))
                .filter(mersenne -> mersenne.isProbablePrime(5))
                .limit(5)
                .forEach(System.out::println);
    }
}
