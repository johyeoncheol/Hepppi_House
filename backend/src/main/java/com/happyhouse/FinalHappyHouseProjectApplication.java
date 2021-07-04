package com.happyhouse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = {"com.*.dao", "com.happyhouse.Location.dao", "com.happyhouse.Favorite.dao"})
public class FinalHappyHouseProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinalHappyHouseProjectApplication.class, args);
	}

}
