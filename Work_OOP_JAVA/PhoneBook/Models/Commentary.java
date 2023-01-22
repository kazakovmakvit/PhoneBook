package Models;

import java.io.Serializable;
import java.util.Date;

public class Commentary implements Serializable {
	String comment = null; // Комментарий
	Date date = null; // дата последнего изменения

	public Commentary(String comment) {
		this.comment = comment;
		this.date = new Date();
	}

	/**
	 * Экземпляр для хранения комментария для контакта.
	 * Может хранить любое строковое значение.
	 */
	public Commentary() {
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
		this.date = new Date();
	}

	public Date getDate() {
		return date;
	}
}
