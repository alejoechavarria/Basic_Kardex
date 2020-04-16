package co.com.todo1.hulkstore.service;

import co.com.todo1.hulkstore.entity.SaleProducts;
import co.com.todo1.hulkstore.entity.Stock;
import co.com.todo1.hulkstore.exceptions.NoProductsInStockException;
import co.com.todo1.hulkstore.exceptions.ProductNotFoundException;
import co.com.todo1.hulkstore.repository.SaleProductsRepository;
import co.com.todo1.hulkstore.repository.StockRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class SaleProductsServiceTest {

    @Test
    public void save_sale_is_correct() {
        //Arrange
        Stock stock = new Stock(1,1,"vasos",100,5000,500000,"Compra");
        SaleProducts saleProducts = new SaleProducts(1,1,"vasos",50,5000,250000,"venta");
        SaleProductsRepository saleProductsRepository = Mockito.mock(SaleProductsRepository.class);
        StockRepository stockRepository = Mockito.mock(StockRepository.class);
        Mockito.when(stockRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(stock));
        Mockito.when(saleProductsRepository.save(Mockito.any(SaleProducts.class))).thenReturn(saleProducts);
        Mockito.when(stockRepository.save(Mockito.any(Stock.class))).thenReturn(stock);
        SaleProductsService saleProductsService = new SaleProductsService(saleProductsRepository,stockRepository);
        //Act
        saleProductsService.saveSale(saleProducts);
        //Assert
        Mockito.verify(stockRepository).findById(Mockito.anyInt());
        Mockito.verify(saleProductsRepository).save(Mockito.any(SaleProducts.class));
        Mockito.verify(stockRepository).save(Mockito.any(Stock.class));
    }

    @Test
    public void save_sale_is_incorrect_because_product_not_found() {
        //Arrange
        SaleProducts saleProducts = new SaleProducts(1,1,"vasos",50,5000,250000,"venta");
        SaleProductsRepository saleProductsRepository = Mockito.mock(SaleProductsRepository.class);
        StockRepository stockRepository = Mockito.mock(StockRepository.class);
        Mockito.when(stockRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());
        SaleProductsService saleProductsService = new SaleProductsService(saleProductsRepository,stockRepository);

        try {
            //Act
            saleProductsService.saveSale(saleProducts);
            fail();
        } catch (ProductNotFoundException e) {
            //Assert
            assertEquals("Stock not found", e.getMessage());
        }
        //Assert
        Mockito.verify(stockRepository).findById(Mockito.anyInt());
    }

    @Test
    public void save_sale_is_incorrect_because_no_stock_available() {
        //Arrange
        Stock stock = new Stock(1,1,"vasos",100,5000,500000,"Compra");
        SaleProducts saleProducts = new SaleProducts(1,1,"vasos",200,5000,1000000,"venta");
        SaleProductsRepository saleProductsRepository = Mockito.mock(SaleProductsRepository.class);
        StockRepository stockRepository = Mockito.mock(StockRepository.class);
        Mockito.when(stockRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(stock));
        SaleProductsService saleProductsService = new SaleProductsService(saleProductsRepository,stockRepository);

        try {
            //Act
            saleProductsService.saveSale(saleProducts);
            fail();
        } catch (NoProductsInStockException e) {
            //Assert
            assertEquals("There are not enough products in stock", e.getMessage());
        }

        //Assert
        Mockito.verify(stockRepository).findById(Mockito.anyInt());
    }
}