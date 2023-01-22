package Data.SaveMode;

import Application.Application;
import Data.DataBase.DataBase;
import Data.WriterData.WriterTXT.Writer1;

import java.io.*;

public class WriterSave extends Writer1 {
//	private final String file1 = "Data/SaveMode/UI.txt";
	private final String file2 = "Data/SaveMode/ConditionalBase.txt";
	private Application application;
	
	public Application getApplication() {
		return application;
	}
	
	public String getFile2() {
		return file2;
	}
	
	public void setApplication(Application application) {
		this.application = application;
	}
	
	public WriterSave(DataBase dataBase) throws IOException {
		super(dataBase);
	}
	
	public WriterSave() throws IOException {
	}
	
	@Override
	public void recordMyPhonebook() throws IOException {
		super.setFileWriter(new FileWriter(file2));
		super.recordMyPhonebook();
	}
	
	
	public void serialize() throws IOException {
//		try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
//		     ObjectOutputStream oos = new ObjectOutputStream(bos))   {
//			oos.writeObject(this.application);
//		}
		FileOutputStream fos = new FileOutputStream(this.file2);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(this.application);
		oos.close();
	}
	
//	public void recordUI(String s) throws IOException {
//		super.setFileWriter(new FileWriter(file1));
//		super.getFileWriter().write(s);
//		super.getFileWriter().flush();
//		super.getFileWriter().close();
//	}
}
