package Abstract.Interface;

import Models.Number;

import java.io.Serializable;

/**
 *  Интерфейс описывает поведение обьектов, которые обладают сбособностью связываться с помощью звонка и имеют контактный номер.
 * @param <T> - обьектный тип
 */
public interface AbleToCall <T> extends Serializable {
	public  <T extends Number> void getCall();
	public <T extends Number> T getNumber();
	public <T extends Number> void setNumber(T num);

}
