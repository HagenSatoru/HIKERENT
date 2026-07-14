package com.Hikerent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HikerentApplication {

	public static void main(String[] args) {
		SpringApplication.run(HikerentApplication.class, args);

		System.out.println("======================================");
		System.out.println("     HIKERENT BERHASIL DIJALANKAN");
		System.out.println("======================================");
	}

}