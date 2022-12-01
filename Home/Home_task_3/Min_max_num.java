package Home.Home_task_3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * Min_max_num
 */
public class Min_max_num {


    public static Integer getMax(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return Integer.MIN_VALUE;
        }
        return Collections.max(list);
    }
    public static Integer getMin(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return Integer.MAX_VALUE;
        }
        return Collections.min(list);
    }


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Введите длинну радномного массива");
        int num = scan.nextInt();
        scan.close();

        int average = 0;

        ArrayList<Integer> array_ = new ArrayList<Integer>(num);

        for (int i = 0; i < num; i++) {
            array_.add((int) (Math.random() * 100));
        }
        for (int i = 0; i < array_.size(); i++) {
            average = average + array_.get(i);
        }
        average = average / array_.size();


        System.out.printf("\nСформированный массив:\n%s\n",array_);
        System.out.printf("\nСреднее значение: %s", average);
        System.out.printf("\nМаксимальный элемент массива: %s", getMax(array_));
        System.out.printf("\nМинимальный элемент массива: %s", getMin(array_));

         
    }
}
