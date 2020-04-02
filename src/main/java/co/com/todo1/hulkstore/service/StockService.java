package co.com.todo1.hulkstore.service;

import co.com.todo1.hulkstore.entity.Stock;
import co.com.todo1.hulkstore.exceptions.ProductAlreadyExistException;
import co.com.todo1.hulkstore.exceptions.ProductNotFoundException;
import co.com.todo1.hulkstore.exceptions.ProductsInStockException;
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
        Optional<Stock> idStock = repository.findById(stock.getId());
        Optional<Stock> byName = repository.findByName(stock.getName());
        if (idStock.isPresent() || byName.isPresent()){
            if (repository.findByDocument(stock.getDocument()).isPresent()) {
                throw new ProductAlreadyExistException("Product already exist!");
            }
            Stock stockDB = idStock.get();
            stock.setCost((stockDB.getTotal() + stock.getTotal())/(stockDB.getQuantity() + stock.getQuantity()));
            stock.setQuantity(stockDB.getQuantity() + stock.getQuantity());
            stock.setTotal(stock.getQuantity()*stock.getCost());
        }
        repository.save(stock);
    }

    public Stock getProductById(Integer id) {
        if (!repository.findById(id).isPresent()) {
            throw new ProductNotFoundException("Product not found");
        }
        return repository.findById(id).get();
    }

    public void updateProduct(Stock stock, Integer id) {

        Optional<Stock> productById = repository.findById(id);
        if (stock == null || !productById.isPresent()) {
            throw new ProductNotFoundException("Product not found");
        }

        if (repository.findByName(stock.getName()).isPresent() && !stock.getName().equalsIgnoreCase(productById.get().getName())) {
            throw new ProductAlreadyExistException("Product already exist!");
        }
        repository.save(stock);
    }

    public void deleteProduct(Integer id) {
        if (repository.findById(id).get().getQuantity() > 0) {
            throw new ProductsInStockException("Cannot be removed. There are units in stock.");
        }
        repository.deleteById(id);
    }

    public Iterable<Stock> getAllProducts() {
        return repository.findAll();
    }
}