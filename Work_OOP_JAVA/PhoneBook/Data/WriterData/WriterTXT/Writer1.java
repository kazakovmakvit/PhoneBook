package Data.WriterData.WriterTXT;

import Data.DataBase.DataBase;
import Models.Contact;
import Presenter.ViewConsole.Printer;
import UInterface.UIConsole.UInterfaceCon;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

/**
 * класс описывает сущность, способную открыть файл .txt и записать файлы базы данных в него, по определенной форме записи информации.
 */
public class Writer1 implements Serializable {
	private DataBase dataBase;
	private FileWriter fileWriter;
	private final String file = "Phonebook/Data/DataFile/DataRow.txt";
	public Writer1(DataBase dataBase) throws IOException {
		this.dataBase = dataBase;
	}
	public Writer1(FileWriter fileWriter) throws IOException {
		this.fileWriter = fileWriter;
	}
	public Writer1() throws IOException {
	
	}
	public DataBase getDataBase() {
		return dataBase;
	}
	public void setDataBase(DataBase dataBase) {
		this.dataBase = dataBase;
	}
	public FileWriter getFileWriter() {
		return fileWriter;
	}
	public void setFileWriter(FileWriter fileWriter) {
		this.fileWriter = fileWriter;
	}
	
 	/**
	 * Данный метод формирует необходимую строку для каждого контакта из базы и прописывает его в указанный файл.
	 * Циклично строка обнуляется и так проходим всю БД ArrayList<Contact>/
	 * @throws IOException - могут возникать в работе с файлом при его открытие fileWriter/
	 */
	public void recordMyPhonebook() throws IOException {
		String temp = "";
		try {
			this.fileWriter = new FileWriter(file);
			for (Contact contact:
			     this.dataBase.getDataBase()) {
				temp = "";
				temp += contact.getName().getFirstName() + ",";
				temp += contact.getName().getLastName() + ",";
				temp += contact.getDateOfBirth() + ",";
				temp += String.valueOf(contact.getNumber().getNumberHome()) + ",";
				if (contact.getNumber().getNumberMobile() != 0) {
					temp += String.valueOf(contact.getNumber().getNumberMobile()) + ",";
				}
				if (contact.getNumber().getNumberWork() != 0) {
					temp += String.valueOf(contact.getNumber().getNumberWork()) + ",";
				}
				temp += contact.getCommentary().getComment();
				fileWriter.write(temp);
				fileWriter.write("\n");
				fileWriter.flush();
			}
			new Printer(new UInterfaceCon().getFileWrite()).print();  //показатель успешной записи файла
		} catch (IOException e){
			new Printer(e.getMessage()).print();
		} finally {
			fileWriter.close();
		}
	}
	
	public void recordMyPhonebook(String file) throws IOException {
		String temp = "";
		try {
			this.fileWriter = new FileWriter(file);
			for (Contact contact:
					this.dataBase.getDataBase()) {
				temp = "";
				temp += contact.getName().getFirstName() + ",";
				temp += contact.getName().getLastName() + ",";
				temp += contact.getDateOfBirth() + ",";
				temp += String.valueOf(contact.getNumber().getNumberHome()) + ",";
				if (contact.getNumber().getNumberMobile() != 0) {
					temp += String.valueOf(contact.getNumber().getNumberMobile()) + ",";
				}
				if (contact.getNumber().getNumberWork() != 0) {
					temp += String.valueOf(contact.getNumber().getNumberWork()) + ",";
				}
				temp += contact.getCommentary().getComment();
				fileWriter.write(temp);
				fileWriter.write("\n");
				fileWriter.flush();
			}
		} catch (IOException e){
			new Printer(e.getMessage()).print();
		} finally {
			fileWriter.close();
		}
	}
}
