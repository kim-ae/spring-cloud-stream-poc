package br.com.kimae.testecsc;

import br.com.kimae.testecsc.load.Person;
import br.com.kimae.testecsc.load.PersonCreator;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

@Profile({"kafka"})
@Configuration
@EnableScheduling
public class KafkaLoadsConfig {

	private final StreamBridge streamBridge;

	private final PersonCreator personCreator;

	public KafkaLoadsConfig(StreamBridge streamBridge, PersonCreator personCreator) {
		this.streamBridge = streamBridge;
		this.personCreator = personCreator;
	}

	@Scheduled(fixedDelay = 1000)
	public void normalLoad(){
		final Person person = personCreator.create();
		final String topic = person.getProfession().equals(Person.Profession.DEVELOPER) ? "developerConsumer-in-0" : "normalConsumer-in-0";
		streamBridge.send(topic, person);
	}
}
