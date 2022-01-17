package study.Board_JPA;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.web.filter.HiddenHttpMethodFilter;

@SpringBootApplication
public class BoardJpaApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(BoardJpaApplication.class, args);
	}


}
