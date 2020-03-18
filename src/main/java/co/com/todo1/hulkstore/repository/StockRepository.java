package co.com.todo1.hulkstore.repository;

import co.com.todo1.hulkstore.entity.Stock;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StockRepository extends CrudRepository<Stock,Integer> {
    Optional<Stock> findByName(String name);
    Optional<Stock> findByDocument(int document);
}
