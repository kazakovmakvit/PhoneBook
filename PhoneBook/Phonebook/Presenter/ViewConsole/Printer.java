package Presenter.ViewConsole;

import java.io.Serializable;

/**
 * Экземпляр предоставляет пользоваьелю информацию, переданную ему в виде строки, в консоль.
 */
public class Printer implements Serializable {
	private String string;
	
	public Printer(String string) {
		this.string = string;
	}
	
	/**
	 * метод песати в консоль.
	 */
	public void print(){
		System.out.println(this.string);
	}
	
	public String getString() {
		return string;
	}
	
	public void setString(String string) {
		this.string = string;
	}
}
