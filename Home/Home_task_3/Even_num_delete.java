package Home.Home_task_3;

import java.util.ArrayList;
import java.util.Scanner;

public class Even_num_delete {

    public static ArrayList<Integer> Mass_rnd(int num) {
        ArrayList<Integer> a = new ArrayList<Integer>();
        for (int i = 0; i < num; i++) {
            a.add((int) (Math.random() * 100));
        }
        System.out.println();
        return a;
    }

    public static void main(String[] args) {
        ArrayList<Integer> mass = new ArrayList<Integer>();
        Scanner scan = new Scanner(System.in);

        System.out.println("Введите длинну массива");
        int num = scan.nextInt();
        scan.close();

        mass = Mass_rnd(num);
        System.out.printf("Рандомный массив:\n%s \n", mass);

        System.out.printf("Удаленные числа: ");

        for (int j = 0; j < mass.size(); j++) {
            if (mass.get(j) % 2 == 0) {
                System.out.printf("%s ", mass.get(j));
                mass.remove(j);
            }
        }
        System.out.printf("\nПосле удаление четных чисел:\n%s \n", mass);
    }
}