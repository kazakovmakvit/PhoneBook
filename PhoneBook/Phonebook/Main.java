import Application.Application;
import Data.SaveMode.SaveCondition;

import java.io.IOException;
import java.io.Serializable;

public class Main implements Serializable {
	public static void main(String[] args) throws IOException {
		SaveCondition saveCondition = new SaveCondition();
		saveCondition.setApplication(new Application());
		saveCondition.getApplication().runApp();  //запуск проекта.
	}
}