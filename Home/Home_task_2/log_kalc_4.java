// 4*. К калькулятору из предыдущего дз добавить логирование.

package Home.Home_task_2;

import java.io.IOException;
import java.util.Scanner;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Logger;

public class log_kalc_4 {
    static Scanner scanner = new Scanner(System.in);

    private static final Logger log = Logger.getLogger(Home.Home_task_2.Bubble_2.class.getName());

    public static void main(String[] args) throws SecurityException, IOException {
        Handler filehandler = new FileHandler("log_kalk.xml");
        log.setUseParentHandlers(false);
        log.addHandler(filehandler);

        log.info("Ввод первого числа");
        int num1 = getInt();
        log.info("Ввод второго числа");
        int num2 = getInt();
        log.info("выбор действия");
        char operation = getOperation();
        int result = calc(num1, num2, operation);
        log.info("вывод результата");
        System.out.println("Результат операции: " + result);

    }

    public static int getInt() {
        System.out.println("Введите число:");
        int num;
        if (scanner.hasNextInt()) {
            num = scanner.nextInt();
        } else {
            System.out.println("Вы допустили ошибку при вводе числа. Попробуйте еще раз.");
            log.warning("Ошибка ввода числа");
            scanner.next();
            num = getInt();
        }
        return num;
    }

    public static char getOperation() {
        System.out.println("Введите операцию из списка: \n/\n*\n+\n-");
        char operation;
        if (scanner.hasNext()) {
            operation = scanner.next().charAt(0);
        } else {
            System.out.println("Ошибка ввода. Попробуйте еще раз.");
            log.warning("Ошибка выбора операции");
            scanner.next();
            operation = getOperation();
        }
        return operation;
    }

    public static int calc(int num1, int num2, char operation) {
        int result;
        switch (operation) {
            case '+':
                result = num1 + num2;
                break;
            case '-':
                result = num1 - num2;
                break;
            case '*':
                result = num1 * num2;
                break;
            case '/':
                result = num1 / num2;
                break;
            default:
                System.out.println("Операция не распознана. Повторите ввод.");
                result = calc(num1, num2, getOperation());
        }
        return result;
    }
}
