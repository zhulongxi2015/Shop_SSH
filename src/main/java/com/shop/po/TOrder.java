package com.shop.po;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;

@Entity
@Table(name = "t_order", schema = "shop", catalog = "")
public class TOrder {
    private int id;
    private String name;
    private String phone;
    private String remark;
    private Timestamp date;
    private BigDecimal total;
    private String post;
    private String address;

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
    @Column(name = "phone", nullable = true, length = 20)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "remark", nullable = true, length = 20)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Basic
    @Column(name = "date", nullable = false)
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Basic
    @Column(name = "total", nullable = true, precision = 2)
    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Basic
    @Column(name = "post", nullable = true, length = 20)
    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    @Basic
    @Column(name = "address", nullable = true, length = 200)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        TOrder tOrder = (TOrder) o;

        if (id != tOrder.id) return false;
        if (name != null ? !name.equals(tOrder.name) : tOrder.name != null) return false;
        if (phone != null ? !phone.equals(tOrder.phone) : tOrder.phone != null) return false;
        if (remark != null ? !remark.equals(tOrder.remark) : tOrder.remark != null) return false;
        if (date != null ? !date.equals(tOrder.date) : tOrder.date != null) return false;
        if (total != null ? !total.equals(tOrder.total) : tOrder.total != null) return false;
        if (post != null ? !post.equals(tOrder.post) : tOrder.post != null) return false;
        if (address != null ? !address.equals(tOrder.address) : tOrder.address != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (phone != null ? phone.hashCode() : 0);
        result = 31 * result + (remark != null ? remark.hashCode() : 0);
        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (total != null ? total.hashCode() : 0);
        result = 31 * result + (post != null ? post.hashCode() : 0);
        result = 31 * result + (address != null ? address.hashCode() : 0);
        return result;
    }
}
