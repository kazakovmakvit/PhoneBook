package Data.ReaderData.ReaderTXT;

import java.io.*;
import java.util.ArrayList;

/**
 * Класс расширяет Reader1.
 * Парсер БД файла фотмата .txt для приведения данных к удобному виду для манипуляций.
 * Данные считываются построчно и в конечном итоге приобретают вид ArrayList<Contact>.
 */
public class Reader2 extends Reader1 implements Serializable {
	private String line;
	private String temp;
	private String[] tempArray;
	private ArrayList<String[]> base;
	private final String file2 = "Phonebook/Data/DataFile/Data.txt";
	
	public Reader2() throws FileNotFoundException {
		super();
		super.setReader(new BufferedReader(new FileReader(file2)));
		this.temp = "";
	}
	
	/**
	 * Метод читает .txt файл, данные в котором записаны в формате 1 строка = 1 контакт, и имеют запись вида
	 * 	 "Name : FirstName\n
	 * 	 LastName : LastName\n
	 * 	 Date : dd.mm.yyyy\n
	 * 	 NumberHome : Number1\n
	 * 	 NumberMobile : Number2\n
	 * 	 NumberWork : Number3\n
	 * 	 Comment : Comment\n"
	 * 	 Types:
	 * 	 FirstName - type String
	 * 	 LastName - type String
	 * 	 dd.mm.yyyy - type String
	 * 	 Number 1 /2 /3 - type int
	 * 	 Comment - type String
	 * 	 Info:   dd.mm.yyyy - date Birth.
	 * @throws IOException - ошибка при отсутствие файла или неверном формате записи БД в файле.
	 */
	@Override
	public void readFile() throws IOException {
		try{
			while((line = super.getReader().readLine()) != null){
				if (line.length() > 1) {
					line = line.replace(" ", "");
					tempArray = line.split(":");
					temp += tempArray[1] + ",";
				} else {
					super.getBase().add(temp.split(","));
					temp = "";
				}
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		} finally {
			super.getReader().close();
		}
	}
	@Override
	public void ghostData() {
		super.ghostData();
	}
}
