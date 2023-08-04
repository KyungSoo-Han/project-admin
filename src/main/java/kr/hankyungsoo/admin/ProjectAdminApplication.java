package kr.hankyungsoo.admin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class ProjectAdminApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectAdminApplication.class, args);
	}

}
