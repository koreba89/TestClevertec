package by.Pavel.model.memory;

import by.Pavel.model.entities.Product;
import by.Pavel.model.entities.PromotionalProduct;

import java.util.ArrayList;
import java.util.List;

public class ProductMemory {
    private static List<Product> productList;

    static {
        productList = new ArrayList<>();
        productList.add(new Product(1, "Хлеб бородинский", "шт", 1.59));
        productList.add(new PromotionalProduct(2, "Хлеб белый", "шт",
                1.99, 12,"Скидка за 5 ед."));
        productList.add(new Product(3, "Молоко", "уп", 2.5));
        productList.add(new Product(4, "Яйца", "дес", 3.4));
        productList.add(new PromotionalProduct(5, "Шоколад", "шт",
                2.3, 20, "Скидка за 5 ед."));
        productList.add(new Product(6, "Творог", "уп", 3.8));
        productList.add(new Product(7, "Колбаса", "шт", 5.86));
        productList.add(new PromotionalProduct(8, "Печенье", "кг",
                7.4, 5, "Скидка за 5 ед."));
        productList.add(new Product(9, "Чай", "уп", 5.6));
        productList.add(new Product(10, "Кофе", "уп", 11.90));
    }

    public static Product selectByIdProduct(int id){
        Product product = null;
        for (Product currentProduct: productList) {
            if (currentProduct.getId() == id){
                product = currentProduct;
            }
        }
        return product;
    }
}
