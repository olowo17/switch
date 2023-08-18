package org.interswitch;

import org.interswitch.repository.SalaryRepository;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.interswitch.model.Salary;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;

@SpringBootApplication
@EnableFeignClients
@OpenAPIDefinition(info =
	@Info(title = "Salary API", version = "1.0", description = "Documentation Salary API v1.0")
)
public class SalaryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SalaryApplication.class, args);
	}

	@Bean
	SalaryRepository repository() {
		SalaryRepository repository = new SalaryRepository();

		LocalDate date1 = getDate("2022-04-13");
		LocalDate date2 = getDate("2022-05-13");
		LocalDate date3 = getDate("2022-06-13");
		LocalDate date4 = getDate("2023-02-13");
		LocalDate date5 = getDate("2023-05-13");
		repository.add(new Salary(1L, BigDecimal.valueOf(678.90), date1));
		repository.add(new Salary(1L, BigDecimal.valueOf(2678.90), date2));
		repository.add(new Salary(1L, BigDecimal.valueOf(3678.90), date3));
		repository.add(new Salary(2L, BigDecimal.valueOf(1678.90), date4));
		repository.add(new Salary(2L, BigDecimal.valueOf(5678.90), date5));
		return repository;
	}

	private LocalDate getDate(String date){
		return LocalDate.parse(date); // Using "yyyy-MM-dd" format

	}


	
}
