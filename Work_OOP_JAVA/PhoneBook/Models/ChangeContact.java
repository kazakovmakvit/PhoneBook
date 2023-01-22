package Models;

import Presenter.ViewConsole.Printer;
import Presenter.ViewConsole.PrinterContact;
import UInterface.UIConsole.UInterfaceCon;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Экземпляр данного класса , расширяя FinderContact умеет находить определенный
 * контакт ( или контакты) из переданной
 * БД ArrayList<Contact> и может изменять значения полей у данного контакта с
 * последующим сохранением изменений.
 * Не удаляет контакт.
 */
public class ChangeContact extends FinderContact implements Serializable {

	public ChangeContact(ArrayList<Contact> dataBase) {
		super(dataBase);
	}

	public ChangeContact() {
		super();
	}

	/**
	 * Метод описывает взаимодействие человека в полями найденного контакта, через
	 * консоль.
	 * Позволяет изменять поля контакта или группы найденных контактов
	 */
	public void changeContact() {
		for (Contact c : getFindContact()) {
			while (true) {
				new Printer(new UInterfaceCon().getCurrentField()).print();
				new PrinterContact(c).printCtc();
				new Printer(new UInterfaceCon().getMenuChange()).print();
				super.getU().UInput(new UInterfaceCon().getInstruction1());
				if (super.getU().getInput().equals("1")) {
					super.getU().UInput(new UInterfaceCon().getInputNewFName());
					c.getName().setFirstName(super.getU().getInput());
				} else if (super.getU().getInput().equals("2")) {
					super.getU().UInput(new UInterfaceCon().getInputNewLName());
					c.getName().setLastName(super.getU().getInput());
				} else if (super.getU().getInput().equals("3")) {
					while (true) {
						super.getU().UInput(new UInterfaceCon().getInputNewDBirthDay());
						if (super.getU().isDate()) {
							c.setDateOfBirth(super.getU().getInput());
							break;
						} else {
							new Printer(new UInterfaceCon().getIsNotDate()).print();
						}
					}
				} else if (super.getU().getInput().equals("4")) {
					while (true) {
						super.getU().UInput(new UInterfaceCon().getInputNewHomeNumber());
						if (super.getU().isInteger()) {
							c.getNumber().setNumberHome(Integer.parseInt(super.getU().getInput()));
							break;
						} else {
							new Printer(new UInterfaceCon().getIsNotNumber()).print();
						}
					}
				} else if (super.getU().getInput().equals("5")) {
					while (true) {
						super.getU().UInput(new UInterfaceCon().getInputNewMobileNumber());
						if (super.getU().isInteger()) {
							c.getNumber().setNumberMobile(Integer.parseInt(super.getU().getInput()));
							break;
						} else {
							new Printer(new UInterfaceCon().getIsNotNumber()).print();
						}
					}
				} else if (super.getU().getInput().equals("6")) {
					while (true) {
						super.getU().UInput(new UInterfaceCon().getInputNewWorkNumber());
						if (super.getU().isInteger()) {
							c.getNumber().setNumberWork(Integer.parseInt(super.getU().getInput()));
							break;
						}
					}
				} else if (super.getU().getInput().equals("7")) {
					super.getU().UInput(new UInterfaceCon().getInputNewComment());
					c.getCommentary().setComment(super.getU().getInput());
				} else if (super.getU().getInput().equals("8")) {
					new Printer(new UInterfaceCon().getInstruction2()).print();
					break;
				} else {
					new Printer(new UInterfaceCon().getInstruction3()).print();
				}
			}
		}
	}
}
