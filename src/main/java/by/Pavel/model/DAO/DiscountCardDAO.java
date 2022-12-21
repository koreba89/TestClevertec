package by.Pavel.model.DAO;

import by.Pavel.model.entities.DiscountCard;
import by.Pavel.model.exeptions.DAOException;

public interface DiscountCardDAO {
    DiscountCard getDiscountCard(int number)throws DAOException;
}
