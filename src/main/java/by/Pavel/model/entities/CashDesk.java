package by.Pavel.model.entities;

import by.Pavel.model.DAO.DiscountCardDAO;
import by.Pavel.model.DAO.DiscountCardMemoryDAOImpl;
import by.Pavel.model.DAO.ProductDAO;
import by.Pavel.model.DAO.ProductInMemoryDAOImpl;
import by.Pavel.model.exeptions.DAOException;

import java.util.regex.Pattern;

public class CashDesk {

    public static void readProductParameter(String[] args, Receipt receipt) throws DAOException {
        ProductDAO productDAO = new ProductInMemoryDAOImpl();
        DiscountCardDAO discountCard = new DiscountCardMemoryDAOImpl();
        String str = "";
        String strTmp = "";
        String delimeter = "-";
        String[] strings;
        String subStr = "Card";
        for (int i = 0; i < args.length; i++) {
            str = args[i];
            if (!str.contains(subStr)){
                strings = str.split(delimeter);
                receipt.setProducts(productDAO.getProduct(Integer.parseInt(strings[0])),
                        Integer.parseInt(strings[1]));
            }else {
                strTmp = str.replaceAll("[^0-9]", "");
                receipt.setCard(discountCard.getDiscountCard(Integer.parseInt(strTmp)));
            }
        }
    }

    public static void makePurchase(String[] args) throws DAOException {

        Receipt receipt1 = new Receipt.Builder(1).build();

        readProductParameter(args, receipt1);

        receipt1.showReceipt();

    }


}
