package Home.Home_task_5;


// Реализуйте структуру телефонной книги с помощью HashMap,
// учитывая, что 1 человек может иметь несколько телефонов.



import java.util.*;

public class task_1 {

    private static Map<String,String> get_User_Number(Scanner scanner,ArrayList<String> category){
        Map<String, String> userNumber = new HashMap<>();
        String temp;
        for (int i = 0; i < category.size(); i++) {
            if (i == 0) {
                System.out.println("Введите Домашний телефон: ");
                temp = scanner.nextLine();
                if (!(temp.equalsIgnoreCase("нет") || temp.equalsIgnoreCase("n") || temp.equalsIgnoreCase("no"))) {
                    userNumber.put(category.get(i), temp);
                }
            } else if (i == 1) {
                System.out.println("Введите Рабочий телефон: ");
                temp = scanner.nextLine();
                if (!(temp.equalsIgnoreCase("нет") || temp.equalsIgnoreCase("n") || temp.equalsIgnoreCase("no"))) {
                    userNumber.put(category.get(i), temp);
                }
            } else if (i == 2) {
                System.out.println("Введите мобильный телефон: ");
                temp = scanner.nextLine();
                if (!(temp.equalsIgnoreCase("нет") || temp.equalsIgnoreCase("n") || temp.equalsIgnoreCase("no"))) {
                    userNumber.put(category.get(i), temp);
                }
            }
        }
        return userNumber ;
    }


    public static void main(String[] args) {
        Map<String, Map<String, String>> phoneBook = new HashMap<>();
        ArrayList<String> category = new ArrayList<>((Arrays.asList("Домашний Т-Ф"," Рабочий Т-Ф", "Мобильный Т-Ф")));
        Scanner scanner = new Scanner(System.in);
        String name;
        while (true) {
            System.out.println("\n1.Телефонная книга \n2.Новый контакт \n3.Редактирование контакта \n4.Выход");

            String scan = scanner.nextLine();

            if (scan.replace(" ", "").equals("1")) {
                System.out.println(phoneBook);

            } else if (scan.replace(" ", "").equals("2")) {
                System.out.println("Введите имя: ");
                name = scanner.nextLine();
                phoneBook.put(name, get_User_Number(scanner, category));

            } else if (scan.replace(" ", "").equals("3")) {
                System.out.print("Введите имя для удаления: ");
                String remove = scanner.nextLine();

                if (phoneBook.containsKey(remove)){
                    phoneBook.remove(remove);
                } else System.out.println("Контакта нет!");

            } else if (scan.replace(" ", "").equals("4")) {
                scanner.close();
                break;
            }
        }
        
        System.out.println("Выход из приложения");
    }

}