package by.Pavel.model.entities;

import by.Pavel.model.interfases.Purchase;

public class Product implements Purchase {
    private int id;
    private String nameProduct;
    private String unitProduct;
    private double prise;

    public Product() {
    }

    public Product(int id, String nameProduct, String unitProduct, double prise) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.unitProduct = unitProduct;
        this.prise = prise;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getUnitProduct() {
        return unitProduct;
    }

    public void setUnitProduct(String unitProduct) {
        this.unitProduct = unitProduct;
    }

    public double getPrise() {
        return prise;
    }

    public void setPrise(double prise) {
        this.prise = prise;
    }

    @Override
    public double getSumQuantity(double sum, int quantity) {
        double result;
        result = sum * quantity;
        return result;
    }

    @Override
    public double getDiscountPrice(int discount) {
        double result;
        result = prise - getSizeDiscount(discount);
        return result;
    }

    @Override
    public double getSizeDiscount(int discount) {
        double result;
        result = prise * discount / 100;
        return result;
    }

}
