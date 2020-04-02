package co.com.todo1.hulkstore.service;

import co.com.todo1.hulkstore.entity.Stock;
import co.com.todo1.hulkstore.exceptions.ProductAlreadyExistException;
import co.com.todo1.hulkstore.exceptions.ProductNotFoundException;
import co.com.todo1.hulkstore.exceptions.ProductsInStockException;
import co.com.todo1.hulkstore.repository.StockRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public class StockServiceTest {

    @Test
    public void save_product_is_correct() {
        //Arrange
        Stock stock = new Stock(1,1,"vasos",50,5000,250000,"compra");
        StockRepository stockRepository = Mockito.mock(StockRepository.class);
        Mockito.when(stockRepository.save(Mockito.any(Stock.class))).thenReturn(stock);
        Mockito.when(stockRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(stock));
        Mockito.when(stockRepository.findByName(Mockito.anyString())).thenReturn(Optional.of(stock));
        Mockito.when(stockRepository.findByDocument(Mockito.anyInt())).thenReturn(Optional.empty());
        StockService stockService = new StockService(stockRepository);
        //Act
        stockService.saveProduct(stock);
        //Assert
        Mockito.verify(stockRepository).save(Mockito.any(Stock.class));
        Mockito.verify(stockRepository).findById(Mockito.anyInt());
        Mockito.verify(stockRepository).findByDocument(Mockito.anyInt());
    }

    @Test
    public void save_product_return_product_already_exist() {
        //Arrange
        Stock stock = new Stock(1,1,"vasos",50,5000,250000,"compra");
        StockRepository stockRepository = Mockito.mock(StockRepository.class);
        Mockito.when(stockRepository.save(Mockito.any(Stock.class))).thenReturn(stock);
        Mockito.when(stockRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(stock));
        Mockito.when(stockRepository.findByName(Mockito.anyString())).thenReturn(Optional.of(stock));
        Mockito.when(stockRepository.findByDocument(Mockito.anyInt())).thenReturn(Optional.of(stock));
        StockService stockService = new StockService(stockRepository);

        try {
            //Act
            stockService.saveProduct(stock);
            fail();
        } catch (ProductAlreadyExistException e) {
            //Assert
            assertEquals("Product already exist!", e.getMessage());
        }
    }

    @Test
    public void get_product_by_id_is_correct() {
        //Arrange
        Stock stockExpected = new Stock(1,1,"vasos",50,5000,250000,"compra");
        StockRepository stockRepository = Mockito.mock(StockRepository.class);
        Mockito.when(stockRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(stockExpected));
        StockService stockService = new StockService(stockRepository);

        //Act
        Stock stockActual=stockService.getProductById(stockExpected.getId());

        //Assert
        assertEquals(stockExpected.getId(),stockActual.getId());
        assertEquals(stockExpected.getName(),stockActual.getName());
        assertEquals(stockExpected.getDetail(),stockActual.getDetail());
    }

    @Test
    public void get_product_by_id_not_found() {
        //Arrange
        Stock stockExpected = new Stock(1,1,"vasos",50,5000,250000,"compra");
        StockRepository stockRepository = Mockito.mock(StockRepository.class);
        Mockito.when(stockRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());
        StockService stockService = new StockService(stockRepository);

        try {
            //Act
            stockService.getProductById(stockExpected.getId());
            fail();
        } catch (ProductNotFoundException e) {
            //Assert
            assertEquals("Product not found", e.getMessage());
        }
        Mockito.verify(stockRepository).findById(Mockito.anyInt());
    }

    @Test
    public void update_product_is_correct() {
        //Arrange
        Stock stock = new Stock(1,1,"vasos",50,5000,250000,"compra");
        Stock newStock = new Stock(1,1,"vasos",50,5000,250000,"compra");
        StockRepository stockRepository = Mockito.mock(StockRepository.class);
        Mockito.when(stockRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(stock));
        Mockito.when(stockRepository.findByName(Mockito.anyString())).thenReturn(Optional.empty());
        Mockito.when(stockRepository.save(Mockito.any(Stock.class))).thenReturn(stock);
        StockService stockService = new StockService(stockRepository);
        //Act
        stockService.updateProduct(newStock,stock.getId());
        //Assert
        Mockito.verify(stockRepository).findById(Mockito.anyInt());
        Mockito.verify(stockRepository).findByName(Mockito.anyString());
        Mockito.verify(stockRepository).save(Mockito.any(Stock.class));
    }

    @Test
    public void update_product_is_incorrect_because_object_is_null() {
        //Arrange
        Stock stock = new Stock(1,1,"vasos",50,5000,250000,"compra");
        Stock nullStock = null;
        StockRepository stockRepository = Mockito.mock(StockRepository.class);
        Mockito.when(stockRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(stock));
        StockService stockService = new StockService(stockRepository);

        try {
            //Act
            stockService.updateProduct(nullStock,stock.getId());
            fail();
        } catch (ProductNotFoundException e) {
            //Assert
            assertEquals("Product not found", e.getMessage());
        }
        //Assert
        Mockito.verify(stockRepository).findById(Mockito.anyInt());
    }

    @Test
    public void update_product_is_incorrect_because_id_does_not_exist() {
        //Arrange
        Stock stock = new Stock(1,1,"vasos",50,5000,250000,"compra");
        Stock newStock = new Stock(1,1,"vasos spiderman",50,5000,250000,"compra");
        StockRepository stockRepository = Mockito.mock(StockRepository.class);
        Mockito.when(stockRepository.findById(Mockito.anyInt())).thenReturn(Optional.empty());
        StockService stockService = new StockService(stockRepository);

        try {
            //Act
            stockService.updateProduct(newStock, stock.getId());
            fail();
        } catch (ProductNotFoundException e) {
            //Assert
            assertEquals("Product not found", e.getMessage());
        }
        //Assert
        Mockito.verify(stockRepository).findById(Mockito.anyInt());
    }

    @Test
    public void update_product_is_incorrect_because_productName_equals_other_product() {
        //Arrange
        Stock stock1 = new Stock(1,1,"vasos",50,5000,250000,"compra");
        Stock stock2 = new Stock(2,2,"vasos spiderman",50,5000,250000,"compra");
        Stock newNameStock1 = new Stock(1,1,"vasos spiderman",50,5000,250000,"compra");
        StockRepository stockRepository = Mockito.mock(StockRepository.class);
        Mockito.when(stockRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(stock1));
        Mockito.when(stockRepository.findByName(Mockito.anyString())).thenReturn(Optional.of(stock2));
        StockService stockService = new StockService(stockRepository);

        try {
            //Act
            stockService.updateProduct(newNameStock1,stock1.getId());
            fail();
        } catch (ProductAlreadyExistException e) {
            //Assert
            assertEquals("Product already exist!", e.getMessage());
        }
        //Assert
        Mockito.verify(stockRepository).findById(Mockito.anyInt());
        Mockito.verify(stockRepository).findByName(Mockito.anyString());
    }

    @Test
    public void delete_product_is_correct() {
        //Arrange
        Stock stock = new Stock(1,1,"vasos",0,5000,250000,"compra");
        StockRepository stockRepository = Mockito.mock(StockRepository.class);
        Mockito.when(stockRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(stock));
        Mockito.doNothing().when(stockRepository).deleteById(Mockito.anyInt());
        StockService stockService = new StockService(stockRepository);
        //Act
        stockService.deleteProduct(stock.getId());
        //Assert
        Mockito.verify(stockRepository).findById(Mockito.anyInt());
        Mockito.verify(stockRepository).deleteById(Mockito.anyInt());
    }

    @Test
    public void delete_product_is_incorrect() {
        //Arrange
        Stock stock = new Stock(1,1,"vasos",50,5000,250000,"compra");
        StockRepository stockRepository = Mockito.mock(StockRepository.class);
        Mockito.when(stockRepository.findById(Mockito.anyInt())).thenReturn(Optional.of(stock));
        StockService stockService = new StockService(stockRepository);

        try {
            //Act
            stockService.deleteProduct(stock.getId());
            fail();
        } catch (ProductsInStockException e) {
            //Assert
            assertEquals("Cannot be removed. There are units in stock.", e.getMessage());
        }

        //Assert
        Mockito.verify(stockRepository).findById(Mockito.anyInt());
    }

    @Test
    public void get_all_products_is_correct() {
        //Arrange
        Stock stock1 = new Stock(1,1,"vasos",50,5000,250000,"compra");
        Stock stock2 = new Stock(2,2,"camisetas",50,5000,250000,"compra");
        Stock stock3 = new Stock(3,3,"juguetes",50,5000,250000,"compra");
        List<Stock> stockList = Arrays.asList(stock1,stock2,stock3);
        StockRepository stockRepository = Mockito.mock(StockRepository.class);
        Mockito.when(stockRepository.findAll()).thenReturn(stockList);
        StockService stockService = new StockService(stockRepository);
        //Act
        Iterable<Stock> stockListActual = stockService.getAllProducts();
        //Assert
        assertEquals(stockList, stockListActual);
        Mockito.verify(stockRepository).findAll();
    }
}