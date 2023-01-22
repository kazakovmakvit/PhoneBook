package Data.SaveMode;

import Application.Application;
import Data.ReaderData.ReaderTXT.Reader1;

import java.io.*;

public class ReaderSave extends Reader1 {
	private Application application;
//	private BufferedReader bufferedReader;
//	private ObjectInputStream ois;
	private final String file = "Data/SaveMode/ConditionalBase.txt";
//	private final String file1 = "Data/SaveMode/UI.txt";
	public ReaderSave() throws FileNotFoundException {
		super();
	}
	
//	public ReaderSave(BufferedReader bufferedReader) throws FileNotFoundException {
//		this();
//		this.bufferedReader = bufferedReader;
//	}
	
	public void deSerialize() throws IOException, ClassNotFoundException {
//		try (ByteArrayInputStream bis = new ByteArrayInputStream(this.file.getBytes());
//		     ObjectInputStream ois = new ObjectInputStream(bis)) {
//			this.application = (Application) ois.readObject();
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException(e);
//		}
		FileInputStream fis = new FileInputStream(this.file);
		ObjectInputStream ois = new ObjectInputStream(fis);
		this.application = (Application) ois.readObject();
		
	}
	
	public String getFile() {
		return file;
	}
}
