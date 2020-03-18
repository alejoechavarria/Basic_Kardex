import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Injectable } from '@angular/core';
import { Sale } from './sale.model';

@Injectable()
export class SaleService {
    constructor(private http: HttpClient) { }

    public addSale(sale: Sale):Observable<any> {
        console.log(sale);
        return this.http.post('/sale/',sale);
    }
}