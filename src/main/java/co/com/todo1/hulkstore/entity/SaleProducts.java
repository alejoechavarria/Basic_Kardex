package co.com.todo1.hulkstore.entity;

import javax.persistence.*;

@Entity
public class SaleProducts {

    @Id
    private Integer id; //document
    @Column
    private Integer refProduct; //id product
    @Column
    private String name;
    @Column
    private Integer quantity;
    @Column
    private Integer cost;
    @Column
    private Integer total;
    @Column
    private String detail;

    public SaleProducts(int id, int refProduct, String name, int quantity, int cost, int total, String detail) {
        this.id = id;
        this.refProduct = refProduct;
        this.name = name;
        this.quantity = quantity;
        this.cost = cost;
        this.total = total;
        this.detail = detail;
    }

    public SaleProducts() {}

    public int getId() {
        return id;
    }

    public int getRefProduct() {
        return refProduct;
    }

    public String getItem() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getCost() {
        return cost;
    }

    public int getTotal() {
        return total;
    }

    public String getDetail() {
        return detail;
    }
}
