export class Sale {

    id: number;
    refProduct: number;
    name: string;
    detail: string;
    quantity: number;
    cost: number;
    total: number;    

    constructor (id:number, refProduct:number, name:string, detail:string, quantity:number, cost:number, total:number) {
        this.id=id;
        this.refProduct=refProduct;
        this.name=name;
        this.quantity=quantity;
        this.cost=cost;
        this.total=total;
        this.detail=detail;
    }    
}