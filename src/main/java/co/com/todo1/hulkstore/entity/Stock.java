package co.com.todo1.hulkstore.entity;

import javax.persistence.*;

@Entity
public class Stock {

    @Id
    private Integer id;
    @Column
    private int document;
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

    public Integer getId() {
        return id;
    }

    public int getDocument() {
        return document;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getDetail() {
        return detail;
    }
}
