public class Menu {
    public void initMenu() {
        System.out.println("______________________");
        System.out.println(" Журнал Студентов ");
        EmployeeBase myBase = new EmployeeBaseInit().init();
        mainMenu(myBase);
    }

    public void mainMenu(EmployeeBase myBase) {
        boolean flag = false;
        while (!flag) {
            System.out.print("""
                    ______________________
                    1. Вывести информацию о Студентах
                    2. Редактирование информации о студентах
                    3. Исключить Студента
                    4. Добавить Студента
                    5. Закрыть базу
                    ______________________
                    """);
            System.out.println("Выберите пункт меню: ");

            switch (new UserInput().input()) {
                case "1" -> myBase.getBase();
                case "2" -> {

                    flag = true;
                    new Spotter().changeEmployee(myBase);
                }

                case "3" -> {
                    flag = true;
                    new DelEmployee().del(myBase);
                }

                case "4" -> {
                    flag = true;
                    new AddEmployee().add(myBase);
                }

                case "5" -> {
                    flag = true;
                    new CloseApp().close();
                }

                default -> new Errors().noMenuItem();
            }
        }
    }
}
