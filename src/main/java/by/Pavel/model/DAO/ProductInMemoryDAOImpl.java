package by.Pavel.model.DAO;

import by.Pavel.model.entities.Product;
import by.Pavel.model.memory.ProductMemory;

public class ProductInMemoryDAOImpl implements ProductDAO{
    @Override
    public Product getProduct(int id) {
        return ProductMemory.selectByIdProduct(id);
    }
}
