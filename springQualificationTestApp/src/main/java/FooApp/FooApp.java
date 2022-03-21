package FooApp;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class FooApp {

	private final Logger log = LoggerFactory.getLogger(FooApp.class);

	public static void main(String[] args) {
		SpringApplication.run(FooApp.class, args);
	}

	@Bean
	public CommandLineRunner initHashMap(FooService fooService){
		return args -> {
			log.info("init DB");
			for (int i = 0; i <20 ; i++) {
				Thread.sleep(100);
				fooService.save (new Foo(i+"_nameForHm",i+"_descriptionForHm"));
			}
		};
	}
}
