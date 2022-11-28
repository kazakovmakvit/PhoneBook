// Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл.

package Home.Home_task_2;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class Bubble_2 {

    private static final Logger log = Logger.getLogger(Home.Home_task_2.Bubble_2.class.getName());
    

    public static Boolean isNumeric(String str) {
        try {
            Long.parseLong(str);
            log.info("Проверка ввода пользователя прошла успешно");
            return true;
        } catch (NumberFormatException e) {
            log.warning("Ошибка ввода");
            return false;
        }
    }

    public static void GetBubble(Integer number) {
        log.info("Заполнение массива рандомными элементами");
        int array[] = new int[number];
        int array_old[] = new int[number];
        for (int i = 0; i < number; i++) {
            array[i] = ((int) (Math.random() * 100));
            array_old[i] = array[i];
        }

        log.info("Перестановка элементов массива методом пузырька");
        int temp = 0;
        for (int c = 1; c < (number - 1); c++) {
            for (int i = 0; i < number-1; i++) {
                if (array[i] > array[i+1]) {
                    temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }
            }
        }
        for (int count = 0; count < number; count++) {
            System.out.printf("%d ", array_old[count]);
        }
        System.out.println("");
        for (int count = 0; count < number; count++) {
            System.out.printf("%d ", array[count]);
        }

    }

    public static void main(String[] args) throws SecurityException, IOException {

        Handler fileHandler = new FileHandler("log.xml");
        log.setUseParentHandlers(false);
        log.addHandler(fileHandler);
        

        String num = "";
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите длинну рандомного массива");
        num = scan.nextLine();
        log.info("Ввод длинны массива от пользователя");
        scan.close();
        int number = 0;

        if (isNumeric(num) == true) {
            number = Integer.parseInt(num);
            GetBubble(number);
        } else {
            System.out.println("Ошибка. Введеное значение не является числом");
        }
    }
}
