package Data.ReaderData.ReaderTXT;

import Data.DataBase.DataBase;
import Models.Phonebook;
import Presenter.ViewConsole.Printer;
import UInput.UInputConsole.UInCon;
import UInterface.UIConsole.UInterfaceCon;

import java.io.IOException;
import java.io.Serializable;

/**
 * Сущность, которая предоставляет пользователю выбор формата чтения БД из файла и обновляет текущую базу считанной базой.
 */
public class ReaderMain implements Serializable {
	private UInCon uInCon;
	private DataBase dataBase;
	private Reader1 reader1;
	private Reader2 reader2;
	
	public ReaderMain(DataBase dataBase) {
		this.dataBase = dataBase;
		uInCon = new UInCon();
	}
	
	public ReaderMain() {
		dataBase = new DataBase();
		uInCon = new UInCon();
	}
	
	/**
	 * Программа загрузчик БД из файлов 2-х форматов.
	 * На данном этапе файлы (точнее их имена и местоположение) фиксированы, но в ДЗ н
	 * @throws IOException - ошибки обьектов для чтения файлов.
	 */
	public void downloadPhonebook() throws IOException {
		while (true) {
			new Printer(new UInterfaceCon().getMenuReaderStart()).print();
			uInCon.UInput(new UInterfaceCon().getInstruction1());
			if (uInCon.getInput().equals("1")) {
				reader1 = new Reader1();
				reader1.readFile();
				reader1.ghostData();
				this.dataBase.setDataBase(reader1.getData());
//				phonebook = new Phonebook(reader1.getData());
				new Printer(new UInterfaceCon().getPhonebookUpdate()).print();
				break;
			} else if (uInCon.getInput().equals("2")) {
				Reader2 reader2 = new Reader2();
				reader2.readFile();
				reader2.ghostData();
				this.dataBase.setDataBase(reader2.getData());
//				phonebook = new Phonebook(reader2.getData());
				new Printer(new UInterfaceCon().getPhonebookUpdate()).print();
				break;
			} else if (uInCon.getInput().equals("3")) {
				new Printer(new UInterfaceCon().getInstruction2()).print();
				break;
			} else {
				new Printer(new UInterfaceCon().getInstruction3()).print();
			}
		}
	}
}
