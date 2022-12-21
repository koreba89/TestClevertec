package by.Pavel.model.DAO;

import by.Pavel.model.entities.Product;
import by.Pavel.model.exeptions.DAOException;

public interface ProductDAO {
    Product getProduct(int id) throws DAOException;
}
