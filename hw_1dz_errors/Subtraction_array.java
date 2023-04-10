/*
Реализуйте метод, принимающий в качестве аргументов два целочисленных массива, и возвращающий новый массив,
каждый элемент которого равен разности элементов двух входящих массивов в той же ячейке.
Если длины массивов не равны, необходимо как-то оповестить пользователя.

 */

public class Subtraction_array {
	
	
	
	public int[]sub(int[] array1, int[] array2) throws IllegalArgumentException {
		if (array1 == null) {  //проверка первого массива на null
			throw new IllegalArgumentException("Первый массив = null");
		}
		if (array2 == null) {  //проверка второго массива на null
			throw new IllegalArgumentException("Второй массив = null !");
		}
		if (array1.length == array2.length) {   //если массивы равной длины считаем разность по элементам
			int[] result = new int[array1.length];
			for (int i = 0; i < array1.length; i++) {
				result[i] = array1[i] - array2[i];
			}
			return result;
		} else { //массивы разной длины
			throw new IllegalArgumentException("Получены целочисленные массивы разных размеров");
		}
	}
}


