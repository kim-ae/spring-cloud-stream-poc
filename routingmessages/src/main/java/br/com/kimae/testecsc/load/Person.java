package br.com.kimae.testecsc.load;

import br.com.kimae.testecsc.TesteCscApplication;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	private String name;
	private Profession profession;

	public enum Profession {
		DEVELOPER,
		NORMAL
	}
}
