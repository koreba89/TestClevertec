package by.Pavel.model.DAO;

import by.Pavel.model.entities.DiscountCard;
import by.Pavel.model.exeptions.DAOException;
import by.Pavel.model.memory.DiscountCardMemory;

public class DiscountCardMemoryDAOImpl implements DiscountCardDAO{
    @Override
    public DiscountCard getDiscountCard(int number) throws DAOException {
        return DiscountCardMemory.selectByIdDiscountCard(number);
    }
}
