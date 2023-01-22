package Presenter.ViewConsole;

import Data.DataBase.DataBase;
import Models.Contact;
import Models.Phonebook;

import java.io.FileNotFoundException;
import java.io.Serializable;

/**
 * класс описывает сущность для представления телефонной книги пользователю через консоль
 */
public class PrinterPhonebook extends Phonebook implements Serializable {
	
	
	public PrinterPhonebook() throws FileNotFoundException {
		super();
	}
	
	/**
	 * Метод описания полученной телефонной книги пользователю через консоль
	 * @param dataBase Полученая БД в которой содержится телефонная книга в формета ArrayList<Contact>
	 */
	public void printPB(DataBase dataBase) {
		new Printer("").print();
		new Printer("Состояние текущей базы: ").print();
		new Printer("__________________ ЗАПУСК ______________").print();
		for (Contact c: dataBase.getDataBase()
		     ) {
			new PrinterContact(c).printCtc();
		}
		new Printer("______________ Конец списка ___________").print();
	}

}
