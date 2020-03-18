import { Component } from '@angular/core';
import { Product } from './stock.model';
import { ProductService } from './stock.service';

@Component({
  selector: 'app-stock',
  templateUrl: './stock.component.html',
  styleUrls: ['./stock.component.css']
})
export class ProductComponent {

  id: number;
  document: number;
  name: string;
  quantity: number;
  cost: number;
  total: number;
  detail: string;
  message: string;
  products: Product[];

  constructor(private stockService: ProductService) {
    this.listProducts();
  }

  addProduct() {
    this.message=""
    const stock = new Product(this.id, this.document, this.name, this.quantity, this.cost, this.total, this.detail);
    if (stock.total==undefined) {
      stock.total = stock.quantity*stock.cost;
    }

    if (stock.cost==undefined) {
      stock.cost = stock.total/stock.quantity;
    }

    this.stockService.addProduct(stock).subscribe(() => {
      this.message= "Registered purchase";
      this.listProducts();      
    },
    (error) => {this.message = error.error.message});
  }

  updateProduct() {
    this.message="";
    const stock = new Product(this.id, this.document, this.name, this.quantity, this.cost, this.total, this.detail);
    this.stockService.updateProduct(this.id,stock).subscribe(() => {
      this.listProducts();
    },
    (error) => {this.message = error.error.message});
  }

  deleteProduct() {
    this.message="";
    this.stockService.deleteProduct(this.id).subscribe(() => {
      this.listProducts();
    },
    (error) => {this.message = error.error.message});
  }

  listProducts() {
    this.message="";
    this.stockService.listProducts().subscribe((products) => {this.products=products},
    (error) => {this.message = error.error.message});
  }

  calculateCost() {
    this.cost = this.total/this.quantity;
  }
}
