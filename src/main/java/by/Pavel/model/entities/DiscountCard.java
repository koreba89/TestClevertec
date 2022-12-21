package by.Pavel.model.entities;

public class DiscountCard {
    private int id;
    private int number;
    private int amountOfDiscount;

    public DiscountCard() {
    }

    public DiscountCard(int id, int number, int amountOfDiscount) {
        this.id = id;
        this.number = number;
        this.amountOfDiscount = amountOfDiscount;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getAmountOfDiscount() {
        return amountOfDiscount;
    }

    public void setAmountOfDiscount(int amountOfDiscount) {
        this.amountOfDiscount = amountOfDiscount;
    }
}
