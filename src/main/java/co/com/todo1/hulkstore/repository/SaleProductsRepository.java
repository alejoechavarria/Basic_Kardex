package co.com.todo1.hulkstore.repository;

import co.com.todo1.hulkstore.entity.SaleProducts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SaleProductsRepository extends CrudRepository<SaleProducts, Integer> {
}
