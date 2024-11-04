package com.vti.entity;

import com.vti.entity.enumerate.PositionName;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "Position")
public class Position implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "PositionID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    @Column(name = "PositionName", nullable = false, unique = true)
    // @Convert: Annotation này được sử dụng để chỉ định một converter cho thuộc tính.
    // Converter sẽ chuyển đổi giữa kiểu dữ liệu của thuộc tính trong Java
    // và kiểu dữ liệu tương ứng trong cơ sở dữ liệu.
    // converter = PositionNameConvert.class: Đây là lớp chuyển đổi (converter)
    // được sử dụng để chuyển đổi giá trị của thuộc tính name.
    @Convert(converter = PositionName.class)
    private PositionName name;

    @OneToMany(mappedBy = "Position")
    private List<Account> accounts;

    public Position() {
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public PositionName getName() {
        return name;
    }

    public void setName(PositionName name) {
        this.name = name;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }

    @Override
    public String toString() {
        return "Position{" +
                "id=" + id +
                ", name=" + name +
                ", accounts=" + accounts +
                '}';
    }
}
