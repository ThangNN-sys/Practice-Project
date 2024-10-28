package com.vti.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.Formula;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "`Account`")
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "AccountID")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short id; // Maps to TINYINT UNSIGNED AUTO_INCREMENT

    // Maps to VARCHAR(50) NOT NULL UNIQUE, UPDATEABLE quy định tại đây do MySQL không có từ khóa trực tiếp
    @Column(name = "Email", length = 50, nullable = false, unique = true, updatable = false)
    private String email;

    // Maps to VARCHAR(50) NOT NULL UNIQUE, UPDATEABLE quy định tại đây do MySQL không có từ khóa trực tiếp
    @Column(name = "Username", length = 50, nullable = false, unique = true, updatable = false)
    private String username;

    @Column(name = "FirstName", length = 50, nullable = false)
    private String firstName; // Maps to NVARCHAR(50) NOT NULL

    @Column(name = "LastName", length = 50, nullable = false)
    private String lastName; // Maps to NVARCHAR(50) NOT NULL

    /* @Formula: Là chú thích đặc biệt của Hibernate, cho phép khai báo một trường tạm thời (derived field) trong lớp
    * Entity mà không cần ánh xạ trực tiếp đến một cột cụ thể trong bảng cơ sở dữ liệu.
    * "concat(FirstName, ' ', LastName)": Đây là câu lệnh SQL dùng để kết hợp (concatenate) giá trị của hai cột FirstName
    * và LastName thành một chuỗi, có thêm khoảng trắng ở giữa để tạo thành tên đầy đủ.
    * Hibernate sẽ tính toán giá trị của fullName bằng cách chạy câu SQL này mỗi khi lấy đối tượng từ cơ sở dữ liệu.
    */
    @Formula(" concat(FirstName, ' ', LastName) ")
    private String fullName; // Make fake column fullName = firstName + lastName

    // Xác định rằng thuộc tính createDate sẽ ánh xạ tới cột CreateDate trong bảng của cơ sở dữ liệu.
    // Nếu không chỉ định name, tên của cột sẽ tự động khớp với tên của trường dữ liệu (ở đây là createDate).
    @Column(name = "CreateDate")

    // Chỉ định kiểu dữ liệu thời gian (temporal) của trường createDate.
    // TemporalType.TIMESTAMP: Ánh xạ kiểu dữ liệu Java Date thành TIMESTAMP trong cơ sở dữ liệu, lưu trữ cả ngày và giờ.
    @Temporal(TemporalType.TIMESTAMP)

    // Được cung cấp bởi Hibernate, chú thích này tự động gán thời điểm tạo của bản ghi cho
    // trường createDate khi bản ghi được lưu vào cơ sở dữ liệu.
    // Giá trị sẽ được thiết lập một lần duy nhất khi bản ghi được tạo và không thay đổi trong các lần cập nhật sau.
    @CreationTimestamp

    private Date createDate;

    public Account() {
    }

    public short getId() {
        return id;
    }

    public void setId(short id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
