package Data.SaveMode;

import Abstract.Interface.Saving;
import Application.Application;
import Models.Contact;

import java.io.*;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

public class SaveCondition implements Saving<ArrayList<Contact>>, Serializable {
	@Serial
	private static final long serialVersionUID = 1L;

	private Application application;
	private ReaderSave readerSave;
	private WriterSave writerSave;
	
	public SaveCondition(Application application) {
		this.application = application;
	}
	
	public SaveCondition() {
	}
	
	public Application getApplication() {
		return application;
	}
	
	public void setApplication(Application application) {
		this.application = application;
	}
	
//	public SaveCondition() {
//		tempCondition = "";
//	}
	
	
	/**
	 * @param <T>
	 * @return
	 */
	@Override
	
	public <T> T getSave() {
		return null;
	}
	
	/**
	 *
	 */
	@Override
	public void getAutoStart() throws InterruptedException {
		while (true) {
			TimeUnit.SECONDS.sleep(15);
			
		}
	}
	
//	public void serialize() throws IOException {
//		try (ByteArrayOutputStream bos = new ByteArrayOutputStream();
//		     ObjectOutputStream oos = new ObjectOutputStream(bos))   {
//			oos.writeObject(this.application);
//		}
//	}
	
//	public void deSerialize(byte[] data) throws IOException {
//		try (ByteArrayInputStream bis = new ByteArrayInputStream(data);
//		     ObjectInputStream ois = new ObjectInputStream(bis)) {
//			this.application = (Application) ois.readObject();
//		} catch (ClassNotFoundException e) {
//			throw new RuntimeException(e);
//		}
//	}
	
//	public DataBase getDataBaseSaving() {
//		return dataBaseSaving;
//	}
//
//	public void setDataBaseSaving(DataBase dataBaseSaving) {
//		this.dataBaseSaving = dataBaseSaving;
//	}
//
//	public String getTempCondition() {
//		return tempCondition;
//	}
//
//	public void setTempCondition(String tempCondition) {
//		this.tempCondition = tempCondition;
//	}
	
	public ReaderSave getReaderSave() {
		return readerSave;
	}
	
	public void setReaderSave(ReaderSave readerSave) {
		this.readerSave = readerSave;
	}
	
	public WriterSave getWriterSave() {
		return writerSave;
	}
	
	public void setWriterSave(WriterSave writerSave) {
		this.writerSave = writerSave;
	}
}
