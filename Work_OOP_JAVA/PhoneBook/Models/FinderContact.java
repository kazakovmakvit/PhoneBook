package Models;

import Presenter.ViewConsole.Printer;
import Presenter.ViewConsole.PrinterContact;
import UInput.UInputConsole.UInCon;
import UInterface.UIConsole.UInterfaceCon;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Сущность ищет контакт из переданной БД по введенным пользователем критериям.
 * В случае успеха выводит найденные контакты в консоль пользователю.
 */
public class FinderContact extends Contact implements Serializable {
	private Contact finder = new Contact();
	private UInCon u = new UInCon();
	private ArrayList<Contact> dataBase;
	private ArrayList<Contact> findContact;

	public UInCon getU() {
		return u;
	}

	public ArrayList<Contact> getDataBase() {
		return dataBase;
	}

	public Contact getFinder() {
		return finder;
	}

	public FinderContact(ArrayList<Contact> dataBase) {
		super();
		this.dataBase = dataBase;
		this.findContact = new ArrayList<>();
	}

	public FinderContact() {
		super();
		this.dataBase = new ArrayList<>();
		this.findContact = new ArrayList<>();
	}

	public void setFinder(Contact finder) {
		this.finder = finder;
	}

	public void setU(UInCon u) {
		this.u = u;
	}

	public void setDataBase(ArrayList<Contact> dataBase) {
		this.dataBase = dataBase;
	}

	public ArrayList<Contact> getFindContact() {
		return findContact;
	}

	public void setFindContact(ArrayList<Contact> findContact) {
		this.findContact = findContact;
	}

	/**
	 * Метод отображения контакта ( или контактов) в консоль
	 * 
	 * @param data Список всех контактов
	 * @param num  - передаваемый флаг для режима поиска( сравнения)
	 */
	public void showContact(ArrayList<Contact> data, int num) {
		for (Contact c : data) {
			if (num == 1) {
				if (this.finder.getName().getFirstName().equals(c.getName().getFirstName().toLowerCase())) {
					new PrinterContact(c).printCtc();
					this.findContact.add(c);
				}
			} else if (num == 2) {
				if (this.finder.getName().getLastName().equals(c.getName().getLastName().toLowerCase())) {
					new PrinterContact(c).printCtc();
					this.findContact.add(c);
				}
			} else if (num == 3) {
				if (c.getNumber().getNumberHome() == this.finder.getNumber().getNumberHome() ||
						c.getNumber().getNumberMobile() == this.finder.getNumber().getNumberHome() ||
						c.getNumber().getNumberWork() == this.finder.getNumber().getNumberHome()) {
					new PrinterContact(c).printCtc();
					this.findContact.add(c);
				}
			}
		}
		if (this.findContact.size() == 0) { // если нет совпадений посика , пишет об этом пользователю в консоль
			new Printer(new UInterfaceCon().getContactNotFound()).print();
		}
	}

	/**
	 * Метод ввода критериев поиска которые прописываются в контакт шаблон finder
	 * для дальнейшего сравнения в базе,
	 * вызывается метод поиска контакта по базе .
	 */
	public void addFindContact() {
		while (true) {
			new Printer(new UInterfaceCon().getMenuFinderStart()).print();
			u.UInput(new UInterfaceCon().getInstruction1());
			if (u.getInput().equals("1")) {
				u.UInput(new UInterfaceCon().getEnterFName());
				finder.getName().setFirstName(u.getInput().toLowerCase());
				this.showContact(dataBase, 1);
				break;
			} else if (u.getInput().equals("2")) {
				u.UInput(new UInterfaceCon().getEnterLName());
				finder.getName().setLastName(u.getInput().toLowerCase());
				showContact(dataBase, 2);
				break;
			} else if (u.getInput().equals("3")) {
				u.UInput(new UInterfaceCon().getEnterNumber());
				if (u.isInteger()) {
					finder.getNumber().setNumberHome(Integer.parseInt(u.getInput().toLowerCase()));
					showContact(dataBase, 3);
					break;
				} else {
					new Printer(new UInterfaceCon().getIsNotNumber()).print();
				}
			} else if (u.getInput().equals("4")) {
				new Printer(new UInterfaceCon().getInstruction2()).print();
				break;
			} else {
				new Printer(new UInterfaceCon().getInstruction3()).print();
			}
		}
	}
}
