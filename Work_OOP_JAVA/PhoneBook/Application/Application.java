package Application;

import Data.ReaderData.ReaderTXT.Reader1;
import Data.ReaderData.ReaderTXT.ReaderMain;
import Data.WriterData.WriterTXT.Writer1;
import Data.WriterData.WriterTXT.WriterMain;
import Models.*;
import Presenter.ViewConsole.Printer;
import Presenter.ViewConsole.PrinterPhonebook;
import UInput.UInputConsole.UInCon;
import UInterface.UIConsole.UInterfaceCon;

import java.io.IOException;
import java.io.Serializable;

/**
 * Приложение
 */
public class Application implements Serializable {
	/**
	 * Метод запуска
	 * 
	 * @throws IOException - возможны ошибки работы с файлами.
	 */
	public void runApp() throws IOException {
		UInCon uInCon = new UInCon();
		Reader1 reader1 = new Reader1();
		Writer1 writer1;
		new Printer("Продолжить с последнего сеанса ?").print();
		uInCon.UInput("да/нет : ");
		String fileLastCondition = "Phonebook/Data/SaveMode/ConditionalBase.txt";
		if (uInCon.getInput().toLowerCase().replace(" ", "").equals("да")) {
			reader1.readFile(fileLastCondition);
		} else {
			reader1.readFile();
		}
		reader1.ghostData();
		Phonebook phonebook = new Phonebook(reader1.getData());
		new Printer(new UInterfaceCon().getGreeting()).print();
		while (true) {
			writer1 = new Writer1(phonebook.getDataBase());
			writer1.recordMyPhonebook(fileLastCondition);
			new Printer(new UInterfaceCon().getMenuStart()).print();
			uInCon.UInput(new UInterfaceCon().getInstruction1());
			if (uInCon.getInput().equals("1")) { // загрузка данных из файлов
				ReaderMain readerMain = new ReaderMain(phonebook.getDataBase());
				readerMain.downloadPhonebook();
			} else if (uInCon.getInput().equals("2")) { // просмотр книги
				new PrinterPhonebook().printPB(phonebook.getDataBase());
			} else if (uInCon.getInput().equals("3")) { // поиск контакта
				FinderContact finderContact = new FinderContact(phonebook.getDataBase().getDataBase());
				finderContact.addFindContact();
			} else if (uInCon.getInput().equals("4")) { // удалить контакт
				DeleterContact deleterContact = new DeleterContact(phonebook.getDataBase().getDataBase());
				deleterContact.addFindContact();
				deleterContact.deleteContact(deleterContact.getFindContact());
			} else if (uInCon.getInput().equals("5")) { // добавить контакт
				AddNewContact newContact = new AddNewContact();
				newContact.enterNewContact();
				newContact = new AddNewContact(newContact.getName().getFirstName(), newContact.getName().getLastName(),
						newContact.getDateOfBirth(), newContact.getNumber().getNumberHome(),
						newContact.getCommentary().getComment());
				newContact.add(phonebook.getDataBase().getDataBase());
			} else if (uInCon.getInput().equals("6")) { // изменить контакт
				ChangeContact changeContact = new ChangeContact(phonebook.getDataBase().getDataBase());
				changeContact.addFindContact();
				changeContact.changeContact();
			} else if (uInCon.getInput().equals("7")) { // записать книгу в файл
				WriterMain writerMain = new WriterMain(phonebook.getDataBase());
				writerMain.selectWriter();
			} else if (uInCon.getInput().equals("8")) { // выход
				new Printer(UInterfaceCon.getCloseApplication()).print();
				break;
			} else { // ошибка ввода юзера
				new Printer(new UInterfaceCon().getInstruction3()).print();
			}
		}
	}
}
