package Home.Home_task_6;

import java.util.HashSet;
import java.util.Scanner;

public class Main {

    static HashSet<GET_CREATE_NOTEBOOK> set = new HashSet<>();
    static boolean flag = true;
    static Scanner scan = new Scanner(System.in);

    public static void createNote() {
        creator cr = new creator();

        GET_CREATE_NOTEBOOK note1 = new GET_CREATE_NOTEBOOK();
        cr.makeNote(note1);
        set.add(note1);
        GET_CREATE_NOTEBOOK note2 = new GET_CREATE_NOTEBOOK();
        cr.makeNote(note2);
        set.add(note2);
        GET_CREATE_NOTEBOOK note3 = new GET_CREATE_NOTEBOOK();
        cr.makeNote(note3);
        set.add(note3);
        GET_CREATE_NOTEBOOK note4 = new GET_CREATE_NOTEBOOK();
        cr.makeNote(note4);
        set.add(note4);
        GET_CREATE_NOTEBOOK note5 = new GET_CREATE_NOTEBOOK();
        cr.makeNote(note5);
        set.add(note5);
        GET_CREATE_NOTEBOOK note6 = new GET_CREATE_NOTEBOOK();
        cr.makeNote(note6);
        set.add(note6);
        GET_CREATE_NOTEBOOK note7 = new GET_CREATE_NOTEBOOK();
        cr.makeNote(note7);
        set.add(note7);
        GET_CREATE_NOTEBOOK note8 = new GET_CREATE_NOTEBOOK();
        cr.makeNote(note8);
        set.add(note8);
        GET_CREATE_NOTEBOOK note9 = new GET_CREATE_NOTEBOOK();
        cr.makeNote(note9);
        set.add(note9);
        GET_CREATE_NOTEBOOK note10 = new GET_CREATE_NOTEBOOK();
        cr.makeNote(note10);
        set.add(note10);
        GET_CREATE_NOTEBOOK note11 = new GET_CREATE_NOTEBOOK();
        cr.makeNote(note11);
        set.add(note11);
    }

    public static void main(String[] args) {

        createNote();
        while (flag) {
            menu();
        }
    }

    public static void menu() {

        System.out.println();
        System.out.println("Выберите меню 'Ноутбуков':");
        System.out.println("1. Каталог");
        System.out.println("2. Фильтр");
        System.out.println("3. Выход");
        System.out.println("Ввод: ");
        String number = scan.nextLine();
        switch (number) {
            case "1" -> {
                for (GET_CREATE_NOTEBOOK nb : set) {
                    nb.info();
                }
            }
            case "2" -> getParameters();
            case "3" -> flag = false;
            default -> {
                System.out.println("Ошибка ввода");
                menu();
            }
        }

    }

    public static void getParameters() {
        System.out.println("\n");
        System.out.println(
                "Введите параметр фильтрации:\n1. Модель\n2. ОС\n3. RAM\n4. SSD\n5. В предыдущее меню\n");
        System.out.println("Ввод: ");
        String num = scan.nextLine();
        switch (num) {
            case "1" -> {
                System.out.println("Введите марку ноутбука(lenovo, asus, dell, acer, msi, hp): ");
                String mark = scan.nextLine().toLowerCase();
                Filter_methods_notebook.FILTER_MARK_buy(set, mark);
                getParameters();
            }
            case "2" -> {
                System.out.println("Введите название OS: (windows, linux)");
                String os = scan.nextLine().toLowerCase();
                Filter_methods_notebook.FILTER_OS_buy(set, os);
                getParameters();
            }
            case "3" -> {
                System.out.println("Введите количество ОЗУ: ");
                String input = scan.nextLine();
                if (input.matches("-?\\d+(\\.\\d+)?")) {
                    int ram = Integer.parseInt(input);
                    Filter_methods_notebook.GET_FILTER_RAM(set, ram);
                    getParameters();
                } else {
                    System.out.println("Ошибка ввода");
                    getParameters();
                }
            }
            case "4" -> {
                System.out.println("Введите ПЗУ: ");
                String input = scan.nextLine();
                if (input.matches("-?\\d+(\\.\\d+)?")) {
                    int rom = Integer.parseInt(input);
                    Filter_methods_notebook.GET_FILTER_ROM_buy(set, rom);
                    getParameters();
                } else {
                    System.out.println("Ошибка ввода");
                    getParameters();
                }
            }
            case "5" -> menu();
            default -> System.out.println("Ошибка ввода");
        }
    }

}