package Home.Home_task_1;
import java.util.Scanner;

// Вывести все простые числа от 1 до 1000

public class Task_2 {

    public static Boolean isNumeric(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static void main(String[] args) {
        String num = "";
        int number = 0;

        Scanner scan = new Scanner(System.in);
        System.out.printf("Введите число: ");
        num = scan.nextLine();
        scan.close();                          

        if (isNumeric(num) == true) {
            number = Integer.parseInt(num);
            if (number != 0) {
                for (int i = 1; i <= number; i++) {
                    for (int j = 2; j <= i; j++) {
                        if (i % j == 0 && j < i) {
                            break;
                        } else if (j == i) {
                            System.out.printf("%d ", i);
                        }

                    }
                }
            }
            if (number == 0) {
                System.out.println(
                        "0 Не является простым либо составным числом.\nЗапустите программу и попробуйте снова");
            }
        } else {
            System.out.println("Ошибка. Введеное значение не является числом");
            return;
        }
    }
}
