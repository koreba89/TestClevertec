package by.Pavel.model.interfases;

public interface Purchase {

    double getDiscountPrice(int discount);

    double getSizeDiscount(int discount);

    double getSumQuantity(double sum,int quantity);

}
