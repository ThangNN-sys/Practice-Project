package com.vti.entity;

import jakarta.persistence.*;

@Entity
// mapping bảng này với bảng department ở DB mySQL
// catalog viết cho chắc, có thể không cần
@Table(name = "department", catalog = "testing_system")
public class Department implements java.io.Serializable { // bắt buộc phải có implements này
    // mapping biến id này tới cột department_id
    @Column(name = "department_id")
    // mapping các thuộc tính của biến id với cột department_id
    // khai báo rằng đây là ID
    @Id
    // khai báo thuộc tính giá trị tự động tăng 123 <auto increment>
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id;

    // mapping biến id này tới cột department_name, thuộc tính not null, thuộc tính unique
    @Column(name = "department_name", nullable = false, unique = true)
    private String name;

    // hàm tạo không tham số (bắt buộc)
    public Department() {
    }

    // hàm getter setter tương ứng (bắt buộc)
    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
