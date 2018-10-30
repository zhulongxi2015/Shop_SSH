package com.shop.po;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
public class Status {
    private int id;
    private String status;

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
    @Column(name = "status", nullable = true, length = 10)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Status status1 = (Status) o;

        if (id != status1.id) return false;
        if (status != null ? !status.equals(status1.status) : status1.status != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (status != null ? status.hashCode() : 0);
        return result;
    }
}
