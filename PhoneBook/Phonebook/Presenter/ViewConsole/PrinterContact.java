package Presenter.ViewConsole;

import Models.Contact;

import java.io.Serializable;

/**
 * Класс описывает отображение переданного экземпляру контакта в консоли
 */
public class PrinterContact extends Contact implements Serializable {
	private Contact contact;

	public void setContact(Contact contact) {
		this.contact = contact;
	}

	public PrinterContact(Contact contact) {
		this.contact = contact;
	}

	/**
	 * Метод форматированного отображения контакта в консоли.
	 * Пример:
	 * Имя : Галина
	 * Фамилия : Максакова
	 * Дата : 13.10.1985
	 * Домашний телефон : 4444
	 * Мобильный телефон : 44444
	 * Рабочий телефон : 444444
	 * Комментарий : ноготочки
	 */
	public void printCtc() {
		for (int i = 0; i < 5; i++) {
			if (i == 0) {
				new Printer("Имя: " + contact.getName().getFirstName()).print();
			} else if (i == 1) {
				new Printer("Фамилия: " + contact.getName().getLastName()).print();
			} else if (i == 2) {
				new Printer("Дата рождения: " + contact.getDateOfBirth()).print();
			} else if (i == 3) {
				if (contact.getNumber().getNumberHome() != 0) {
					new Printer("Домашний номер: " + contact.getNumber().getNumberHome()).print();
				}
				if (contact.getNumber().getNumberMobile() != 0) {
					new Printer("Мобильный номер: " + contact.getNumber().getNumberMobile()).print();
				}
				if (contact.getNumber().getNumberWork() != 0) {
					new Printer("Рабочий номер: " + contact.getNumber().getNumberWork()).print();
				}
			} else {
				new Printer("Коментарий: " + contact.getCommentary().getComment()).print();
			}
		}
		new Printer("").print();
	}
}
