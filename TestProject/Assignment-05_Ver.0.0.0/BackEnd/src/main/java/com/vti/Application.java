package com.vti;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurerAdapter() {
			@Override			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/products").allowedOrigins("http://localhost:8080");
			}
		};
	}
}

/**
 * Cách các thành phần tương tác với nhau
 * 1. Client gửi yêu cầu đến Controller.
 * 2. Controller nhận yêu cầu và gọi các phương thức từ Service để xử lý nghiệp vụ.
 * 3. Service tương tác với Repository để thực hiện các thao tác dữ liệu.
 * 4. Repository truy vấn cơ sở dữ liệu dựa trên các yêu cầu từ Service.
 * 5. Entity được sử dụng để ánh xạ dữ liệu từ database về các object trong Java.
 * 6. Utils hỗ trợ với các công việc tiện ích cần thiết.
 * 7. Kết quả xử lý được trả về Controller và gửi lại cho Client.
 * Mô hình này giúp chia nhỏ trách nhiệm của từng thành phần, tạo ra code rõ ràng, dễ bảo trì và mở rộng.
 */
