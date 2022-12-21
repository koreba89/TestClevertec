package by.Pavel.model.entities;

public class PromotionalProduct extends Product{
    public int discount;
    public String namePromotion;

    public PromotionalProduct() {
    }

    public PromotionalProduct(int id, String nameProduct, String unitProduct, double prise, int discount, String namePromotion) {
        super(id, nameProduct, unitProduct, prise);
        this.discount = discount;
        this.namePromotion = namePromotion;
    }

    public int getDiscount() {
        return discount;
    }

    public void setDiscount(int discount) {
        this.discount = discount;
    }

    public String getNamePromotion() {
        return namePromotion;
    }

    public void setNamePromotion(String namePromotion) {
        this.namePromotion = namePromotion;
    }

    @Override
    public double getSumQuantity(double sum, int quantity) {
        return super.getSumQuantity(sum, quantity);
    }

    @Override
    public double getDiscountPrice(int discount) {
        return super.getDiscountPrice(discount);
    }

    @Override
    public double getSizeDiscount(int discount) {
        return super.getSizeDiscount(discount);
    }
}
