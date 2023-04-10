/*
 * Реализуйте метод, принимающий в качестве аргументов два целочисленных массива,
 * и возвращающий новый массив, каждый элемент которого равен частному элементов двух входящих массивов в той же ячейке.
 * Если длины массивов не равны, необходимо как-то оповестить пользователя. Важно:
 * При выполнении метода единственное исключение, которое пользователь может увидеть - RuntimeException, т.е. ваше.
 */

public class Division_elements_of_array {
	
	
	public double[] div(int[] a, int[]b) throws RuntimeException {
		if (a == null) {  
			throw new RuntimeException("Первый массив = null");
		} else if (b == null) {  
			throw new RuntimeException("Второй массив = null");
		}
		if (a.length != b.length) { 
			throw new RuntimeException("Массивы разной длины!");
		}
		
		
		double[] result = new double[a.length];
 		for (int i = 0; i < a.length; i++) {
		    if (b[i] != 0) {                
			    result[i] = a[i] / b[i];
		    } else {                        
				throw new RuntimeException("Второй массив содержит 0, деление на 0 не возможно!");
		    }
		}
		
		return result;
	}
	
}
