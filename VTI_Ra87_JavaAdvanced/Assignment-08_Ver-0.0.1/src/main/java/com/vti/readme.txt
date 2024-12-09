------------------ entity -----------------------------------------------------------------------------

1. Chức năng:

Chứa các lớp mô hình (model classes) đại diện cho các bảng trong cơ sở dữ liệu.
Các lớp này còn được gọi là entities.

2. Vai trò:

Định nghĩa cấu trúc của các đối tượng dữ liệu, với các thuộc tính
tương ứng với các cột trong bảng cơ sở dữ liệu.

3. Đặc điểm:

Các class trong package này thường được đánh dấu bằng annotation @Entity
và có các annotation như @Table, @Column, @Id để ánh xạ với các bảng và cột trong cơ sở dữ liệu.

------------------ repository ------------------------------------------------------------------------

1. Chức năng:

Chứa các interface thực hiện các thao tác truy vấn cơ sở dữ liệu.
Tầng này còn được gọi là Data Access Layer.

2. Vai trò:

Cung cấp các phương thức để tương tác với cơ sở dữ liệu,
như lưu trữ, cập nhật, xóa, và tìm kiếm dữ liệu.

3. Đặc điểm:

Thường sử dụng Spring Data JPA, các interface kế thừa từ JpaRepository hoặc CrudRepository
để tận dụng các phương thức CRUD mặc định hoặc tùy chỉnh.

------------------ service ------------------------------------------------------------------------

1. Chức năng:

Chứa các lớp service chịu trách nhiệm xử lý logic nghiệp vụ của ứng dụng.
Tầng này còn được gọi là Business Logic Layer.

2. Vai trò:

Thực hiện các logic liên quan đến nghiệp vụ trước khi dữ liệu được gửi tới tầng repository
hoặc trước khi phản hồi cho người dùng.
Thường giao tiếp với repository để lấy dữ liệu, xử lý logic và gửi dữ liệu đã xử lý tới controller.

3. Đặc điểm:

Các lớp trong package này thường được đánh dấu bằng annotation @Service.

------------------ controller -----------------------------------------------------------------------

1. Chức năng:

Chứa các lớp controller để xử lý yêu cầu từ người dùng (từ phía frontend hoặc API client).
Tầng này còn được gọi là Presentation Layer.

2. Vai trò:

Nhận và xử lý các yêu cầu HTTP từ client, tương tác với tầng service để lấy hoặc lưu dữ liệu,
sau đó trả kết quả về cho client.

3. Đặc điểm:

Các lớp trong package này thường được đánh dấu bằng annotation @RestController hoặc @Controller.