package UInput.UInputConsole;

import java.io.Serializable;
import java.util.Scanner;

/**
 * Экземпляр данного класса получает текстовую информацию , введенную пользователем через консоль,
 * хранит и передает ее для дальнйшей обработки.
 */
public class UInCon implements Serializable {
	private Scanner scanner = new Scanner(System.in);
	private String input = null;
	
	public UInCon(String input) {
		this.input = input;
	}
	
	public UInCon() {
	}
	
	public void setInput(String input) {
		this.input = input;
	}
	
	public void setScanner(Scanner scanner) {
		this.scanner = scanner;
	}
	
	public String getInput() {
		return input;
	}
	/**
	 * Метод принимает строку, выводя ее как подсказку пользователю, что от него требуется, в данный момент, на ввод.
	 */
	public void UInput (String s){
		System.out.printf("%s ", s);
		setInput(scanner.nextLine());
	}
	/**
	 * Метод проверки строки на принадлежность к целым числам
	 * @return true если принадлежит/false
	 */
	public boolean isInteger() {
		return this.getInput().matches("^[0-9]+$");
	}
	
	/**
	 * Метод проверки строки на принадлежность к формату записи даты
	 * @return true - если принадлежит/false
	 */
	public boolean isDate() {
		return this.getInput().matches("^\\d{1,2}\\.\\d{2}\\.\\d{4}");
	}
}
