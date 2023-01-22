package Models;

import Abstract.Class.Human;
import Abstract.Interface.AbleToCall;
import Presenter.ViewConsole.Printer;

import java.io.Serializable;

/**
 * Класс описывает сущность контакт, которая содержит в себе, имя, номера и
 * комментарий для контакта
 */
public class Contact extends Human implements AbleToCall<Number>, Serializable {
	private Number number = new Number();
	private Commentary commentary = new Commentary();

	public Contact(Number number) {
		this.number = number;
	}

	public Contact(String firstName, String lastName, String date, int number, String commentary) {
		super.getName().setFirstName(firstName);
		super.getName().setLastName(lastName);
		super.setDateOfBirth(date);
		this.number.setNumberHome(number);
		this.commentary.setComment(commentary);
	}

	/**
	 * Конструктор
	 * 
	 * @param firstName  имя
	 * @param lastName   фамилия
	 * @param date       дата рождения
	 * @param number     номер дом
	 * @param number2    номер моб.
	 * @param number3    номер раб.
	 * @param commentary комментарий
	 */
	public Contact(String firstName, String lastName, String date, int number, int number2, int number3,
			String commentary) {
		this(firstName, lastName, date, number, number2, commentary);
		this.number.setNumberWork(number3);
	}

	public Contact(String firstName, String lastName, String date, int number, int number2, String commentary) {
		this(firstName, lastName, date, number, commentary);
		this.number.setNumberMobile(number2);

	}

	public Contact() {

	}

	public Commentary getCommentary() {
		return commentary;
	}

	@Override
	public void getCall() {
		new Printer("Пока не доработан вызов! ( " + getNumber() + " )\n").print();
		new Printer("представим что пошел вызов ....").print();
	}

	/**
	 * Передает телефон контакта
	 * 
	 * @return
	 */
	@Override
	public Number getNumber() {
		return this.number;
	}

	/**
	 * изменяет номер контакта
	 * 
	 * @param number
	 */
	@Override
	public void setNumber(Number number) {
		this.number.setNumberHome(number.getNumberHome());
	}
}
