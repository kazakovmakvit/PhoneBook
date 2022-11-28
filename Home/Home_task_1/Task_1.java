package Home.Home_task_1;
import java.util.Scanner;

public class Task_1 {

    public static Boolean isNumeric(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static long Getfactorial(long n) {
        long factorial = 1;
        if (n >= 0) {
            for (int i = 1; i < n; i++) {
                factorial = factorial * i;
            }
        }
        return factorial;
    }

    private static int Getsum(long number) {
        int sum = 0;
        for (int i = 0; i <= number; i++) {
            sum = sum + i;
        }
        return sum;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String num = "";
        int sum = 0;
        Long op;
        long number = 0;

        System.out.printf("Введите число: ");
        num = scan.nextLine();
        scan.close();       

        if (isNumeric(num) == true) {
            number = Long.parseLong(num);
        } else {
            System.out.println("Ошибка. Введеное значение не является числом");
            return;
            
        }
        if (number > 0) {
            op = Getfactorial(number);
            System.out.printf("Факториал числа %d = %d\n", number, op);
            sum = Getsum(number);
            System.out.printf("сумма чисел от 1 до %d = %d\n", number, sum);

        }
    }
}
