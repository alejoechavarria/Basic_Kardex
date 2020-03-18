export class Product {

    id: number;
    document: number;
    name: string;
    quantity: number;
    cost: number;
    total: number;
    detail: string;

    constructor (id?:number, document?: number, name?:string, quantity?:number, cost?:number, total?:number, detail?:string) {
        this.id=id;
        this.document=document;
        this.name=name;
        this.quantity=quantity;
        this.cost=cost;
        this.total=total;
        this.detail=detail;
    }    
}