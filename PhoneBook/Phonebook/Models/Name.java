package Models;

import java.io.Serializable;

/**
 * Сущность описывает имена контактов
 */
public class Name implements Serializable {
	private String firstName;
	private String lastName;

	public Name(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public Name(String firstName) {
		this.firstName = firstName;
	}

	public Name() {
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
