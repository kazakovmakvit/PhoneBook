package Data.WriterData.WriterTXT;

import Data.DataBase.DataBase;
import Presenter.ViewConsole.Printer;
import UInput.UInputConsole.UInCon;
import UInterface.UIConsole.UInterfaceCon;

import java.io.IOException;
import java.io.Serializable;

/**
 * Сущность, которая предоставляет пользователю выбор формата записи БД в файл,
 * обновляет текущую базу в файле.
 */
public class WriterMain implements Serializable {
	private DataBase dataBase;
	private Writer1 writer1;
	private Writer2 writer2;
	private UInCon uInCon;

	public WriterMain() {
	}

	public WriterMain(DataBase dataBase) {
		this.dataBase = dataBase;
		uInCon = new UInCon();
	}

	/**
	 * метод предлагает на выбор запись базы в файл в 2-х форматах.
	 * 
	 * @throws IOException - ошибки связанные с файлами, или их отсутствием.
	 */
	public void selectWriter() throws IOException {
		while (true) {
			new Printer(new UInterfaceCon().getMenuWriterStart()).print();
			uInCon.UInput(new UInterfaceCon().getInstruction1());
			if (uInCon.getInput().equals("1")) {
				writer1 = new Writer1(this.dataBase);
				writer1.recordMyPhonebook();
			} else if (uInCon.getInput().equals("2")) {
				writer2 = new Writer2(this.dataBase);
				writer2.recordMyPhonebook();
			} else if (uInCon.getInput().equals("3")) {
				new Printer(new UInterfaceCon().getInstruction2()).print();
				break;
			} else {
				new Printer(new UInterfaceCon().getInstruction3()).print();
			}
		}
	}
}
