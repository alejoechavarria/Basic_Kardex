import { Component } from '@angular/core';
import { SaleService } from './sale.service';
import { Sale } from './sale.model';
import { ProductService } from '../stock/stock.service';
import { Product } from '../stock/stock.model';

@Component({
  selector: 'app-sale',
  templateUrl: './sale.component.html',
  styleUrls: ['./sale.component.css'],
  providers: [SaleService]
})
export class SaleComponent{

  id: number;
  refProduct: number;
  name: string;
  detail: string;
  quantity: number;
  cost: number;
  total: number;  
  message:string;
  product = new Product();
  stockMessage: String;

  constructor(private saleService: SaleService, private stockService: ProductService) { }

  addSale() {
    this.message="";
    const sale = new Sale(this.id, this.refProduct, this.name, this.detail, this.quantity, this.cost, this.total);
    this.saleService.addSale(sale).subscribe(() => {
      this.message= "Registered sale" 
    }, 
    (error) => {this.message = error.error.message});
  }

  calculateTotal() {
    this.total = this.cost*this.quantity;
  }

  search() {
    console.log(this.refProduct);
    this.stockService.getProduct(this.refProduct).subscribe((product) => {
      this.product=product;
      console.log(product); 
      this.name=product.name;
      this.stockMessage = ": " + product.quantity + " in stock";
    },
    (error) => {this.message = error.error.message});
  }
}
