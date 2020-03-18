import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Product } from './stock.model';
import { Injectable } from '@angular/core';

@Injectable()
export class ProductService {
    constructor(private http: HttpClient) { }

    public addProduct(stock: Product):Observable<any> {
        console.log(stock);
        return this.http.post('/products/',stock);
    }

    public updateProduct(id:number, stock:Product):Observable<any> {
        return this.http.put('/products/'+id,stock);
    }

    public deleteProduct(id:number):Observable<any> {
        return this.http.delete('/products/'+id);
    }

    public getProduct(id:number):Observable<Product> {
        return this.http.get<Product>('/products/'+id);
    }

    public listProducts():Observable<Product[]> {
        return this.http.get<Product[]>('/products/');
    }
}
