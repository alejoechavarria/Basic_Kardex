package co.com.todo1.hulkstore.controller;

import co.com.todo1.hulkstore.entity.SaleProducts;
import co.com.todo1.hulkstore.service.SaleProductsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("sale")
public class SaleProductsController {

    private final SaleProductsService saleProductsService;

    public SaleProductsController(SaleProductsService saleProductsService) {
        this.saleProductsService = saleProductsService;
    }

    @PostMapping("/")
    public void saveSale(@RequestBody SaleProducts saleProducts) {
        saleProductsService.saveSale(saleProducts);
    }
}
