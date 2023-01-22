package Abstract.Class;

import Models.Name;

import java.io.Serializable;

/**
 * Базовый класс людей (имя, фамилия, дата рождения)
 */
public abstract class Human implements Serializable {
	private Name name = new Name();
	private String dateOfBirth;
	
	public Name getName() {
		return name;
	}
	
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
}
