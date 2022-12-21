import by.Pavel.model.entities.*;
import by.Pavel.model.exeptions.DAOException;

public class Runner {
    public static void main(String[] args) {

//        String[] strings = new String[4];
//        strings[0] = "1-4";
//        strings[1] = "2-5";
//        strings[2] = "5-3";
//        strings[3] = "Card-1234";

        try {
            CashDesk.makePurchase(args);
        } catch (DAOException e) {
            e.printStackTrace();
        }
   }
}
