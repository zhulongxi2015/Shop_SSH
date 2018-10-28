package com.shop.po;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.ManyToAny;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Category {
    private int id;
    private String type;
    private Byte hot;
    private Account account;
    private Set<Product> products=new HashSet<Product>();
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @GenericGenerator(name ="identity",strategy ="identity")
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "type", nullable = true, length = 20)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "hot", nullable = true)
    public Byte getHot() {
        return hot;
    }

    public void setHot(Byte hot) {
        this.hot = hot;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="account_id")
    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @OneToMany(cascade =CascadeType.ALL,fetch = FetchType.LAZY,mappedBy = "category")
    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;

        if (id != category.id) return false;
        if (type != null ? !type.equals(category.type) : category.type != null) return false;
        if (hot != null ? !hot.equals(category.hot) : category.hot != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (type != null ? type.hashCode() : 0);
        result = 31 * result + (hot != null ? hot.hashCode() : 0);
        return result;
    }
}
