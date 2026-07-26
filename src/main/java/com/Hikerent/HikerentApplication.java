package com.Hikerent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class HikerentApplication {

	public static void main(String[] args) {
		SpringApplication.run(HikerentApplication.class, args);

		System.out.println("======================================");
		System.out.println("     HIKERENT BERHASIL DIJALANKAN");
		System.out.println("======================================");
	}

	// Tambahkan konfigurasi CORS ini agar tidak diblokir oleh Web / Browser
	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/api/**")
						.allowedOrigins("*")
						.allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
						.allowedHeaders("*");
			}
		};
	}
}