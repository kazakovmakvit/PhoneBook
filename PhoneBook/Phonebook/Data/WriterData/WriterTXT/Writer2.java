package Data.WriterData.WriterTXT;

import Data.DataBase.DataBase;
import Models.Contact;
import Presenter.ViewConsole.Printer;
import UInterface.UIConsole.UInterfaceCon;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

/**
 * класс описывает сущность, способную открыть файл .txt и записать файлы базы
 * данных в него, по определенной форме записи информации.
 */
public class Writer2 extends Writer1 implements Serializable {
	private final String file2 = "Data/DataFile/Data.txt";

	public Writer2(DataBase dataBase) throws IOException {
		super(dataBase);
		super.setFileWriter(new FileWriter(file2));
	}

	public Writer2(FileWriter fileWriter) throws IOException {
		super(fileWriter);
		super.setFileWriter(new FileWriter(file2));
	}

	public Writer2() throws IOException {
		super();
		super.setFileWriter(new FileWriter(file2));
	}

	/**
	 * Данный метод формирует необходимую строку для каждого контакта из базы и
	 * прописывает его в указанный файл.
	 * Циклично строка обнуляется и так проходим всю БД ArrayList<Contact>/
	 *
	 */
	@Override
	public void recordMyPhonebook() throws IOException {
		String temp = "";
		try {
			for (Contact c : this.getDataBase().getDataBase()) {
				temp += "Имя : " + c.getName().getFirstName() + "\n";
				temp += "Фамилия : " + c.getName().getLastName() + "\n";
				temp += "Дата : " + c.getDateOfBirth() + "\n";
				temp += "Домашний телефон : " + c.getNumber().getNumberHome() + "\n";
				if (c.getNumber().getNumberMobile() != 0) {
					temp += "Мобильный телефон : " + c.getNumber().getNumberMobile() + "\n";
				}
				if (c.getNumber().getNumberWork() != 0) {
					temp += "Рабочий телефон : " + c.getNumber().getNumberWork() + "\n";
				}
				temp += "Комментарий : " + c.getCommentary().getComment() + "\n";
				temp += "\n";
				super.getFileWriter().write(temp);
				super.getFileWriter().flush();
				temp = "";
			}
			new Printer(new UInterfaceCon().getFileWrite()).print();
		} catch (IOException e) {
			new Printer(e.getMessage()).print();
		} finally {
			super.getFileWriter().close();
		}
	}
}
