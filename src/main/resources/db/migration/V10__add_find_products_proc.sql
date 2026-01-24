DELIMITER $$

CREATE PROCEDURE findProductsByPrice(
    minPrice DECIMAL(10,2),
    maxPrice DECIMAL(10,2)
)

BEGIN
    select id, name, description, price, category_id
    from products
    where price BETWEEN minPrice and maxPrice
    order by name;

END $$

DELIMITER ;