package br.com.kimae.testecsc;

import java.util.SplittableRandom;
import java.util.function.Supplier;

import br.com.kimae.testecsc.load.Person;
import br.com.kimae.testecsc.load.PersonCreator;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;


@Profile("rabbitmq")
@Configuration
public class RabbitLoadsConfig {
	private final PersonCreator personCreator;

	public RabbitLoadsConfig(PersonCreator personCreator) {
		this.personCreator = personCreator;
	}

	@Bean
	public Supplier<Message<Person>> personLoad(){
		return ()-> {
			final Person person = personCreator.create();
			final String key = person.getProfession().equals(Person.Profession.DEVELOPER) ? "developer.key" : "normal.key";
			return MessageBuilder.withPayload(person)
					.setHeader("routingKey", key)
					.build();
		};
	}
}
