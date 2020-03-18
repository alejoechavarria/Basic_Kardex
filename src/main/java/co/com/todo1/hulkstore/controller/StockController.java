package co.com.todo1.hulkstore.controller;

import co.com.todo1.hulkstore.entity.Stock;
import co.com.todo1.hulkstore.service.StockService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("products")
public class StockController {

    private final StockService stockService;

    public StockController(StockService stockService) {
        this.stockService = stockService;
    }

    @PostMapping("/")
    public void saveProduct(@RequestBody Stock stock) {
        stockService.saveProduct(stock);
    }

    @GetMapping("/{id}")
    public Stock getProductById(@PathVariable Integer id) {
        return stockService.getProductById(id);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable Integer id, @RequestBody Stock stock) {
        stockService.updateProduct(stock, id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Integer id) {
        stockService.deleteProduct(id);
    }

    @GetMapping("/")
    public Iterable<Stock> getAllProducts() {
        return stockService.getAllProducts();
    }
}

