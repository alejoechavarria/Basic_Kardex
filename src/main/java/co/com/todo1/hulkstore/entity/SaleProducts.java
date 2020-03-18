package co.com.todo1.hulkstore.entity;

import javax.persistence.*;

@Entity
public class SaleProducts {

    @Id
    private int id; //document
    @Column
    private int refProduct; //id product
    @Column
    private String name;
    @Column
    private int quantity;
    @Column
    private int cost;
    @Column
    private int total;
    @Column
    private String detail;

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
