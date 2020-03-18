package co.com.todo1.hulkstore.service;

import co.com.todo1.hulkstore.entity.SaleProducts;
import co.com.todo1.hulkstore.entity.Stock;
import co.com.todo1.hulkstore.exceptions.ProductAlreadyExistException;
import co.com.todo1.hulkstore.repository.SaleProductsRepository;
import co.com.todo1.hulkstore.repository.StockRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StockService {

    private final StockRepository repository;

    public StockService(StockRepository repository) {
        this.repository = repository;
    }

    public void saveProduct(Stock stock) {
        if (repository.findById(stock.getId()).isPresent() || repository.findByName(stock.getName()).isPresent()){
            if (repository.findByDocument(stock.getDocument()).isPresent()) {
                throw new ProductAlreadyExistException("Product already exist!");
            }
            Stock stockDB = repository.findById(stock.getId()).get();
            stock.setCost((stockDB.getTotal() + stock.getTotal())/(stockDB.getQuantity() + stock.getQuantity()));
            stock.setQuantity(stockDB.getQuantity() + stock.getQuantity());
            stock.setTotal(stock.getQuantity()*stock.getCost());
            repository.save(stock);
        }
        repository.save(stock);
    }

    public Stock getProductById(Integer id) {
        return repository.findById(id).get();
    }

    public void updateProduct(Stock stock, Integer id) {

        Optional<Stock> productById = repository.findById(id);
        if (stock ==null || !productById.isPresent()) {
            throw new IllegalStateException("Illegal product!");
        }

        if (repository.findByName(stock.getName()).isPresent() && !stock.getName().equalsIgnoreCase(productById.get().getName())) {
            throw new IllegalStateException("Illegal product!");
        }
        repository.save(stock);
    }

    public void deleteProduct(Integer id) {
        repository.deleteById(id);
    }

    public Iterable<Stock> getAllProducts() {
        return repository.findAll();
    }
}
