package Models;

import Presenter.ViewConsole.Printer;
import UInput.UInputConsole.UInCon;
import UInterface.UIConsole.UInterfaceCon;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Класс описывает сущность, способную создать новую объектную переменную type
 * <Contact>
 * и добавить ее в переданную базу данных type ArrayList<Contact>/
 */
public class AddNewContact extends Contact implements Serializable {
	private UInCon uInCon;

	public UInCon getuInCon() {
		return uInCon;
	}

	public void setuInCon(UInCon uInCon) {
		this.uInCon = uInCon;
	}

	public AddNewContact(String firstName, String lastName, String date, int number, String commentary) {
		super(firstName, lastName, date, number, commentary);
		this.uInCon = new UInCon();
	}

	/**
	 * Конструктор ( самый расширенной версии объектной переменной)
	 * 
	 * @param firstName  имя
	 * @param lastName   фамилия
	 * @param date       дата рождения
	 * @param number1    номер домашнего телефона
	 * @param number2    номер мобильного
	 * @param number3    рабочий номер телефона
	 * @param commentary комментарий
	 */
	public AddNewContact(String firstName, String lastName, String date, int number1, int number2, int number3,
			String commentary) {
		super(firstName, lastName, date, number1, number2, number3, commentary);
		this.uInCon = new UInCon();
	}

	public AddNewContact(String firstName, String lastName, String date, int number1, int number2, String commentary) {
		super(firstName, lastName, date, number1, number2, commentary);
		this.uInCon = new UInCon();
	}

	public AddNewContact() {
		this.uInCon = new UInCon();
	}

	public void add(ArrayList<Contact> data) {
		data.add(this);
	}

	/**
	 * Метод заполнения полей объектной перемнной нового контакта
	 */
	public void enterNewContact() {
		uInCon.UInput(new UInterfaceCon().getEnterFName());
		super.getName().setFirstName(uInCon.getInput());
		uInCon.UInput(new UInterfaceCon().getEnterLName());
		super.getName().setLastName(uInCon.getInput());
		while (true) {
			uInCon.UInput(new UInterfaceCon().getEnterDateBtsd());
			if (uInCon.isDate()) {
				super.setDateOfBirth(uInCon.getInput());
				break;
			} else {
				new Printer(new UInterfaceCon().getIsNotDate()).print();
			}
		}
		while (true) {
			uInCon.UInput(new UInterfaceCon().getEnterNumber());
			if (uInCon.isInteger()) {
				super.getNumber().setNumberHome(Integer.parseInt(uInCon.getInput()));
				break;
			} else {
				new Printer(new UInterfaceCon().getIsNotNumber()).print();
			}
		}
		// Не будем мучать пользователя вводом.
		// uInCon.UInput(new UInterfaceCon().getEnterNumberwork());
		// super.getNumber().setNumberWork(Integer.parseInt(uInCon.getInput()));
		// uInCon.UInput(new UInterfaceCon().getEnterNumberMob());
		// super.getNumber().setNumberMobile(Integer.parseInt(uInCon.getInput()));
		uInCon.UInput(new UInterfaceCon().getEnterComment());
		super.getCommentary().setComment(uInCon.getInput());
	}
}
