package br.com.kimae.testecsc;

import java.util.SplittableRandom;
import java.util.function.Consumer;

import br.com.kimae.testecsc.load.Person;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TesteCscApplication {

	private final SplittableRandom random = new SplittableRandom();

	public static void main(String[] args) {
		SpringApplication.run(TesteCscApplication.class, args);
	}

	@Bean
	public Consumer<Person> developerConsumer() {
		return person -> {
			//fails 10% of the times
			if(random.nextInt(0,100) <= 10){
				System.out.println("err");
				throw new RuntimeException();
			}
			person.getName();
			System.out.println("Developer: " + person);
		};
	}

	@Bean
	public Consumer<Person> normalConsumer() {
		return person -> {
			System.out.println("Normal: " + person);
		};
	}
}
