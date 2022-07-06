package com.simplilearn.hibernate.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="product")
public class ProductDetails {

    @Id
    @Column(name = "id")
    private int userId;

    @Column(name = "code")
    private String code;

    @Column(name = "name")
    private String name;

    @Column(name = "brand")
    private String brand;

    @Column(name = "description")
    private String description;

    @Column(name = "unit_price")
    private String unitPrice;

    @Column(name = "quantity")
    private String quantity;

    @Column(name = "is_active")
    private String isActive;

    @Column(name = "category_id")
    private String categoryId;

    @Column(name = "supplier_id")
    private String supplierId;

    @Column(name = "purchases")
    private String purchases;

    @Column(name = "views")
    private String views;

    public ProductDetails(){

    }

    public int getUserId() {
        return userId;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getBrand() {
        return brand;
    }

    public String getDescription() {
        return description;
    }

    public String getUnitPrice() {
        return unitPrice;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getIsActive() {
        return isActive;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public String getSupplierId() {
        return supplierId;
    }

    public String getPurchases() {
        return purchases;
    }

    public String getViews() {
        return views;
    }
}
