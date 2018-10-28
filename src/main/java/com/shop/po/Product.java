package com.shop.po;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Date;

@Entity
public class Product {

    private int id;
    private String name;
    private BigDecimal price;
    private String pic;
    private String remark;
    private String xremark;
    private Date date;
    private Byte commend;
    private Byte open;
    private  Category category;
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @GenericGenerator(name="identity",strategy = "identity")
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 20)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "price", nullable = true, precision = 2)
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Basic
    @Column(name = "pic", nullable = true, length = 200)
    public String getPic() {
        return pic;
    }

    public void setPic(String pic) {
        this.pic = pic;
    }

    @Basic
    @Column(name = "remark", nullable = true, length = -1)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "xremark", nullable = true, length = -1)
    public String getXremark() {
        return xremark;
    }

    public void setXremark(String xremark) {
        this.xremark = xremark;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Basic
    @Column(name = "commend", nullable = true)
    public Byte getCommend() {
        return commend;
    }

    public void setCommend(Byte commend) {
        this.commend = commend;
    }

    @Basic
    @Column(name = "open", nullable = true)
    public Byte getOpen() {
        return open;
    }

    public void setOpen(Byte open) {
        this.open = open;
    }
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="cid")
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Product product = (Product) o;

        if (id != product.id) return false;
        if (name != null ? !name.equals(product.name) : product.name != null) return false;
        if (price != null ? !price.equals(product.price) : product.price != null) return false;
        if (pic != null ? !pic.equals(product.pic) : product.pic != null) return false;
        if (remark != null ? !remark.equals(product.remark) : product.remark != null) return false;
        if (xremark != null ? !xremark.equals(product.xremark) : product.xremark != null) return false;
        if (date != null ? !date.equals(product.date) : product.date != null) return false;
        if (commend != null ? !commend.equals(product.commend) : product.commend != null) return false;
        if (open != null ? !open.equals(product.open) : product.open != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (pic != null ? pic.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (xremark != null ? xremark.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (commend != null ? commend.hashCode() : 0);
        result = 31 * result + (open != null ? open.hashCode() : 0);
        return result;
    }
}
