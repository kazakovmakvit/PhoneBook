package Data.DataBase;

import Models.Contact;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

/**
 * База данных. для хранения контактов с возможностями ArrayList
 */
public class DataBase extends ArrayList<Contact> implements Serializable {
	private ArrayList<Contact> dataBase = new ArrayList<Contact>();
	
	/**
	 * Constructs an empty list with the specified initial capacity.
	 *
	 * @param initialCapacity the initial capacity of the list
	 * @throws IllegalArgumentException if the specified initial capacity
	 *                                  is negative
	 */
	public DataBase(int initialCapacity, ArrayList<Contact> dataBase) {
		super(initialCapacity);
		this.dataBase = dataBase;
	}
	
	/**
	 * Constructs an empty list with an initial capacity of ten.
	 */
	public DataBase(ArrayList<Contact> dataBase) {
		this.dataBase = dataBase;
	}
	
	/**
	 * Constructs a list containing the elements of the specified
	 * collection, in the order they are returned by the collection's
	 * iterator.
	 *
	 * @param c the collection whose elements are to be placed into this list
	 * @throws NullPointerException if the specified collection is null
	 */
	public DataBase(Collection<? extends Contact> c, ArrayList<Contact> dataBase) {
		super(c);
		this.dataBase = dataBase;
	}
	
	public ArrayList<Contact> getDataBase() {
		return dataBase;
	}
	
	public void setDataBase(ArrayList<Contact> dataBase) {
		this.dataBase = dataBase;
	}
	public DataBase(){

	}
	
}
