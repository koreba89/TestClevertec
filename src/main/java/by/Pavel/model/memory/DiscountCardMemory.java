package by.Pavel.model.memory;

import by.Pavel.model.entities.DiscountCard;

import java.util.ArrayList;
import java.util.List;

public class DiscountCardMemory {
    private static List<DiscountCard> discountCardList;

    static {
        discountCardList = new ArrayList<>();
        discountCardList.add(new DiscountCard(1, 1234, 10));
        discountCardList.add(new DiscountCard(2, 2345, 12));
        discountCardList.add(new DiscountCard(3, 3456, 15));
        discountCardList.add(new DiscountCard(4, 4567, 5));
        discountCardList.add(new DiscountCard(5, 5678, 3));
    }

    public static DiscountCard selectByIdDiscountCard(int number){
        DiscountCard discountCard = null;
        for (DiscountCard currentDiscountCard: discountCardList) {
            if (currentDiscountCard.getNumber() == number){
                discountCard = currentDiscountCard;
            }
        }
        return discountCard;
    }
}
