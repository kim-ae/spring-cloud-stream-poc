package br.com.kimae.testecsc.load;

import java.util.SplittableRandom;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

@Service
public class PersonCreator {

	private final SplittableRandom random = new SplittableRandom();

	public Person create(){
		//try to creates 50% of each type
		final boolean isDeveloper = random.nextInt(0,100) >= 50;
		final Person.Profession profession = isDeveloper ? Person.Profession.DEVELOPER : Person.Profession.NORMAL;
		return Person.builder().name(RandomStringUtils.randomAlphabetic(50)).profession(profession).build();
	}
}
