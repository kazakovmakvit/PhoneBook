package Home.Home_task_3;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Merge_sort
 */
public class Merge_sort {

    public static int[] mergesort(int[] array1) {
        int[] buffer1 = Arrays.copyOf(array1, array1.length);
        int[] buffer2 = new int[array1.length];
        int[] result = mergesortInner(buffer1, buffer2, 0, array1.length);
        return result;
    }

    public static int[] mergesortInner(int[] buffer1, int[] buffer2,
            int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }

        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergesortInner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergesortInner(buffer1, buffer2, middle, endIndex);

        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++]
                    : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }

    public static Object Mass_rnd(int[] mass_1) {

        for (int i = 0; i < mass_1.length; i++) {
            mass_1[i] = (int) (Math.random() * 100);
            System.out.printf("%s ", mass_1[i]);
        }
        System.out.println();
        return mass_1;
    }

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.printf("\nВведите длинну радномного массива: ");
        int num_1 = scan.nextInt();
        int[] Mass_1 = new int[num_1];
        Mass_rnd(Mass_1);
        scan.close();

        int[] result = mergesort(Mass_1);
        System.out.println(Arrays.toString(result));
    }
 
   
}
