public class DelEmployee {
    public void del(EmployeeBase myBase) {
        boolean flag = false;
        while (!flag) {
            System.out.println("Введите ID Студента для удаления ( '*' Возврат в меню ): ");
            String input = new UserInput().input();

            if (input.equals("*")) {
                flag = true;
                new Menu().mainMenu(myBase);

            } else if (Checker.isDigit(input)) {
                int inputInt = Integer.parseInt(input);

                if (myBase.checkID(inputInt)) {
                    flag = true;
                    myBase.delEmployee(inputInt);
                    System.out.println("______________________");
                    System.out.println("Студент удален из списков");
                    new Menu().mainMenu(myBase);

                } else {

                    new Errors().noID();

                }

            } else {

                new Errors().noID();
            }
        }
    }
}