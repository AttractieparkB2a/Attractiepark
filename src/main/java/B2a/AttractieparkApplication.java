package B2a;

import B2a.domain.AttractionPark;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

@SpringBootApplication
public class AttractieparkApplication extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(AttractieparkApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(AttractieparkApplication.class, args);

		AttractionPark attractionPark = AttractionPark.getInstance();
		attractionPark.setName("Attractiepark B2a");
		attractionPark.setAddress("Breda");

		System.out.println(attractionPark.getName() + "" + attractionPark.getAddress());
	}
}
