package Models;

import Presenter.ViewConsole.Printer;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Сущность, расширяя экземпляр поиска контакта по полученно БД, может удалить
 * его из этой БД.
 */
public class DeleterContact extends FinderContact implements Serializable {
	/**
	 * Конструктор
	 * 
	 * @param dataBase получаемая БД
	 */
	public DeleterContact(ArrayList<Contact> dataBase) {
		super(dataBase);
	}

	/**
	 * Метод удаления найденных результатом поиска контатков
	 * 
	 * @param findContact - список найденных контатков( или 1 контатка при случае)
	 */
	public void deleteContact(ArrayList<Contact> findContact) {
		for (Contact c : findContact) {
			this.getDataBase().remove(c);
			new Printer(c.getName().getFirstName() + " " + c.getName().getLastName() + "удалён!").print();
		}
	}
}
