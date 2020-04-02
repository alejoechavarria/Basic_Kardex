package co.com.todo1.hulkstore.service;

import co.com.todo1.hulkstore.entity.Stock;
import co.com.todo1.hulkstore.entity.SaleProducts;
import co.com.todo1.hulkstore.exceptions.NoProductsInStockException;
import co.com.todo1.hulkstore.exceptions.ProductNotFoundException;
import co.com.todo1.hulkstore.repository.StockRepository;
import co.com.todo1.hulkstore.repository.SaleProductsRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SaleProductsService {

    private final SaleProductsRepository saleProductsRepository;
    private final StockRepository stockRepository;

    public  SaleProductsService(SaleProductsRepository saleProductsRepository, StockRepository stockRepository) {
        this.saleProductsRepository = saleProductsRepository;
        this.stockRepository = stockRepository;
    }

    public void saveSale(SaleProducts saleProducts) {
        Optional<Stock> product = stockRepository.findById(saleProducts.getRefProduct());
        if (!product.isPresent()) {
            throw new ProductNotFoundException("Stock not found");
        }

        if (product.get().getQuantity() < saleProducts.getQuantity()) {
            throw new NoProductsInStockException("There are not enough products in stock");
        }

        saleProductsRepository.save(saleProducts);
        product.get().setQuantity(product.get().getQuantity() - saleProducts.getQuantity());
        product.get().setTotal(product.get().getQuantity()*product.get().getCost());
        stockRepository.save(product.get());
    }
}
