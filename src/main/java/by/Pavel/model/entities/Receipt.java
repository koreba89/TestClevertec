package by.Pavel.model.entities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.Map;

public class Receipt {
    public static final String HEADER = "CASH RECEIPT";
    public int id;
    public int numberReceipt;
    public int cashierNumber;
    public String nameShop;
    public String addressShop;
    public String phoneShop;
    public DiscountCard card;
    public Calendar calendar;
    public Map<Product, Integer> products;

    public static class Builder{
        public int id;
        public Calendar calendar;
        public Map<Product, Integer> products;

        public int numberReceipt = 1111;
        public int cashierNumber = 1111;
        public String nameShop = "SomeShop";
        public String addressShop = "SomeAddress";
        public String phoneShop = "+375291112233";
        public DiscountCard card = null;


        public Builder(int id) {
                this.id = id;
            calendar = new GregorianCalendar();
            products = new HashMap<>();
        }

        public Builder numberReceipt (int val) {
            numberReceipt = val;
            return this;
        }

        public Builder cashierNumber (int val) {
            cashierNumber = val;
            return this;
        }

        public Builder nameShop (String val) {
            nameShop = val;
            return this;
        }

        public Builder addressShop (String val) {
            addressShop = val;
            return this;
        }

        public Builder phoneShop (String val) {
            phoneShop = val;
            return this;
        }


        public Receipt build() {
            return new Receipt (this);
        }

    }
    private Receipt(Builder builder){
        numberReceipt = builder.numberReceipt;
        cashierNumber = builder.cashierNumber;
        nameShop = builder.nameShop;
        addressShop = builder.addressShop;
        phoneShop = builder.phoneShop;
        card = builder.card;
        calendar = builder.calendar;
        products = builder.products;
    }



    public void setCard(DiscountCard card) {
        this.card = card;
    }

    public void setProducts(Product product, Integer quantity) {
        products.put(product, quantity);
    }




    private String getDateFormat(Calendar calendar){
        DateFormat df = new SimpleDateFormat("dd MMM yyy");
        return df.format(calendar.getTime());
    }

    private String getTimeFormat(Calendar calendar){
        DateFormat df = new SimpleDateFormat("H : mm");
        return df.format(calendar.getTime());
    }

    private String showDataCard() {
        String result = "";
        if (checkDiscountCard()) {
            result = "№" + Integer.toString(card.getNumber());
        } else {
            result = "Карта не предъявлена.";
        }
        return result;
    }

    private String showAmountOfDiscount() {
        String result = "";
        if (checkDiscountCard()) {
            result = Integer.toString(card.getAmountOfDiscount());
        } else {
            result = "Карта не предъявлена.";
        }
        return result;
    }

    private String roundingAndToString(double value) {
        String result = "";
        result = String.format("%.2f", value);
        return result;
    }



    private boolean checkDiscountCard() {
        boolean isCheck = false;
        if (card != null) {
            isCheck = true;
        }
        return isCheck;
    }

    private boolean isClassPromotionalProduct(Product product) {
        boolean isCheck = false;
        if (product.getClass() == PromotionalProduct.class) {
            isCheck = true;
        }
        return isCheck;
    }

    private boolean isDiscountCondition(Product product, int quantity) {
        boolean isCheck = false;
        if (isClassPromotionalProduct(product) && quantity >= 5) {
            isCheck = true;
        }
        return isCheck;
    }



    public void showReceipt() {
        System.out.println(
                "          " + HEADER +
                        '\n' + "shop:                  " + nameShop +
                        '\n' + "address:               " + addressShop +
                        '\n' + "phone:                 " + phoneShop +
                        '\n' + "                                " +
                        '\n' + "cashier №:             " + cashierNumber +
                        '\n' + "check number:          " + numberReceipt +
                        '\n' + "дата:                  " + getDateFormat(calendar) +
                        '\n' + "время:                 " + getTimeFormat(calendar) +
                        '\n' + "____________________________________________________" +
                        '\n' + "кол-во     " + "наименование   " + "цена    " + "стоимость"
        );
        Product productTmp = null;
        PromotionalProduct promotionalProductTmp = null;

        int quantityTmp = 0;
        double prise, sum, discount = 0, sumWithDiscount, totalDiscount, allSumWithDiscount,
                countSum = 0, countTotalDiscount = 0, countAllSumWithDiscount = 0;
        int quantity, sizeDiscount = 0;

        for (Map.Entry<Product, Integer> entry : products.entrySet()) {
            productTmp = entry.getKey();
            quantityTmp = entry.getValue();


            quantity = quantityTmp;
            prise = productTmp.getPrise();
            sum = productTmp.getSumQuantity(prise, quantityTmp);
//            discount = productTmp.getSizeDiscount(sizeDiscount);
//            sumWithDiscount = productTmp.getDiscountPrice(sizeDiscount);
//            totalDiscount = productTmp.getSumQuantity(discount,quantityTmp);
//            allSumWithDiscount = productTmp.getSumQuantity(sumWithDiscount,quantityTmp);

            if (isDiscountCondition(productTmp, quantityTmp)) {

                promotionalProductTmp = (PromotionalProduct) productTmp;
                sizeDiscount = promotionalProductTmp.getDiscount();
                discount = promotionalProductTmp.getSizeDiscount(sizeDiscount);
                totalDiscount = promotionalProductTmp.getSumQuantity(discount, quantityTmp);
                sumWithDiscount = promotionalProductTmp.getDiscountPrice(sizeDiscount);
                allSumWithDiscount = promotionalProductTmp.getSumQuantity(sumWithDiscount, quantityTmp);

                countSum += sum;
                countTotalDiscount += totalDiscount;
                countAllSumWithDiscount += allSumWithDiscount;

                System.out.println(
                        quantity + "    " + "    " + promotionalProductTmp.getNameProduct() +
                                "              " + prise + "    "
                                + roundingAndToString(sum) +
                                '\n' + "скидка:     " + "акция " + sizeDiscount + "%" +
                                "  сумма скидки: " + roundingAndToString(totalDiscount)
                                + "  итог сумма:  " + roundingAndToString(allSumWithDiscount)
                );
            } else if (checkDiscountCard()) {

                sizeDiscount = card.getAmountOfDiscount();
                discount = productTmp.getSizeDiscount(sizeDiscount);
                totalDiscount = productTmp.getSumQuantity(discount, quantityTmp);
                sumWithDiscount = productTmp.getDiscountPrice(sizeDiscount);
                allSumWithDiscount = productTmp.getSumQuantity(sumWithDiscount, quantityTmp);

                countSum += sum;
                countTotalDiscount += totalDiscount;
                countAllSumWithDiscount += allSumWithDiscount;

                System.out.println(
                        quantity + "    " + "    " + productTmp.getNameProduct() +
                                "              " + prise + "    "
                                + roundingAndToString(sum) +
                                '\n' + "скидка:     " + "дисконт " + sizeDiscount + "%" +
                                "  сумма скидки: " + roundingAndToString(totalDiscount)
                                + "  итог сумма:  " + roundingAndToString(allSumWithDiscount)
                );
            } else {
                totalDiscount = productTmp.getSumQuantity(discount, quantityTmp);
                sumWithDiscount = productTmp.getDiscountPrice(sizeDiscount);
                allSumWithDiscount = productTmp.getSumQuantity(sumWithDiscount, quantityTmp);

                countSum += sum;
                countTotalDiscount += totalDiscount;
                countAllSumWithDiscount += allSumWithDiscount;
                System.out.println(
                        quantity + "    " + "    " + productTmp.getNameProduct() +
                                "              " + prise + "    "
                                + roundingAndToString(sum)
                );
            }
        }
        System.out.println(
                '\n' + "____________________________________________________" +
                        '\n' + "____________________________________________________" +
                        '\n' + "дисконтная карта:                 " + showDataCard() +
                        '\n' + "скидка по карте в %:              " + showAmountOfDiscount() +
                        '\n' + "сумма:                            " + roundingAndToString(countSum) +
                        '\n' + "сумма скидки:                     " + roundingAndToString(countTotalDiscount) +
                        '\n' + "итого:                            " + roundingAndToString(countAllSumWithDiscount)
        );
    }

}
