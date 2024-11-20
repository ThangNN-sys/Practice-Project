* Vai trò:

Controller chịu trách nhiệm xử lý các yêu cầu từ phía client (web, mobile, etc.)
và trả về kết quả. Đây thường là các REST API endpoint.

* Cách hoạt động:

Các class trong package này thường được đánh dấu với các annotation như
@RestController hoặc @Controller. Các phương thức thường sử dụng @RequestMapping,
@GetMapping, @PostMapping để định nghĩa endpoint.