package com.javaproject.store.repositories;

import com.javaproject.store.dtos.ProductSummary;
import com.javaproject.store.dtos.ProductSummaryDTO;
import com.javaproject.store.entities.Category;
import com.javaproject.store.entities.Product;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Long> {

    //String
    List<Product> findByName(String name);
    List<Product> findByNameLike(String name);
    List<Product> findByNameNotLike(String name);
    List<Product> findByNameContaining(String name);
    List<Product> findByNameStartingWith(String name);
    List<Product> findByNameEndsWith(String name);
    List<Product> findByNameEndsWithIgnoreCase(String name);

    List<Product> findByPrice(BigDecimal price);
    List<Product> findByPriceGreaterThan(BigDecimal price);
    List<Product> findByPriceLessThan(BigDecimal price);
    List<Product> findByPriceBetween(BigDecimal min, BigDecimal max);
    List<Product> findByPriceGreaterThanEqual(BigDecimal price);
    List<Product> findByPriceLessThanEqual(BigDecimal price);

    //Null

    List<Product> findByDescriptionNull();
    List<Product> findByDescriptionNotNull();

    //Multiple conditions
    List<Product> findByDescriptionNullAndNameNull();
    List<Product> findByDescriptionNullAndNameNotNull();

    //Sort
    List<Product> findByNameOrderByPriceDesc(String name);
    List<Product> findByNameOrderByPriceAsc(String name);

    //Limit
    List<Product> findTop5ByNameOrderByPriceAsc(String name);
    List<Product> findFirst5ByNameOrderByPriceAsc(String name);

    //Find products whose prices are in a given range and sort by name

    @Query("select p from Product p join p.category where p.price between :min and :max order by p.name")
    List<Product> findProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max);


    @Query("select count(*) from Product p where p.price between :min and :max")
    long countProducts(@Param("min") BigDecimal min, @Param("max") BigDecimal max);

    @Modifying
    @Query("update Product p set p.price= :newPrice where p.category.id= :categoryId")
    void updatePriceByCategory(BigDecimal newPrice, Byte categoryId);

    @Query("select p.id, p.name from Product p where p.category = :category")
    List<ProductSummaryDTO> findByCategory(@Param("category") Category category);

}
