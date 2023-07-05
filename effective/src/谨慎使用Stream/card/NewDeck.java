package 谨慎使用Stream.card;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: yejunyu
 * @Date: Created in 2023/7/4
 * @Description: 初始化牌堆
 **/
public class NewDeck {
    static List<Card> newDeck1() {
        List<Card> result = new ArrayList<>();
        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                Card card = new Card(suit, rank);
                result.add(card);
            }
        }
        return result;
    }

    static List<Card> newDeck2() {
        return Stream.of(Suit.values())
                .flatMap(s ->
                        Stream.of(Rank.values()).map(r ->
                                new Card(s, r)))
                .collect(Collectors.toList());
    }
}
