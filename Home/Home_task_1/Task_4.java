package Home.Home_task_1;
public class Task_4 {
    public static void main(String[] args) {

        System.out.println("x1 + x2 = Y");
        System.out.println("2* + *5 = 69");
        String str = "2* + *5 = 69";

        String[] array = new String[2];

        array = str.split("[\\+\\-\\=]");

        for (int i = 0; i < array.length; i++) {
            array[i] = array[i].replace("*", "").replace(" ", "");
        }
        int num1 = Integer.parseInt(array[0]);
        int num2 = Integer.parseInt(array[1]);
        int sum = Integer.parseInt(array[2]);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < (sum - num1 - num2) / 10; j++) {
                if (num1 * 10 + i + j * 10 + num2 == sum) {
                    System.out.printf("2%s + %s5 = 69", i, j);
                }
            }
        }
    }
}
