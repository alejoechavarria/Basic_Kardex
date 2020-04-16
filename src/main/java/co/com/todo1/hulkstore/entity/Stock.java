package co.com.todo1.hulkstore.entity;

import javax.persistence.*;

@Entity
public class Stock {

    @Id
    private Integer id;
    @Column
    private Integer document;
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

    public Stock(Integer id, int document, String name, int quantity, int cost, int total, String detail) {
        this.id = id;
        this.document = document;
        this.name = name;
        this.quantity = quantity;
        this.cost = cost;
        this.total = total;
        this.detail = detail;
    }

    public Stock() {}

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
