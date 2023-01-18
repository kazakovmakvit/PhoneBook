public class AddEmployee implements Checker {
    public void add(EmployeeBase myBase) {

        System.out.println("Имя ученика: (*new*) : ");
        String newFirstName = new UserInput().input();

        System.out.println("Фамилия ученика: (*new*) : ");
        String newLastName = new UserInput().input();

        int newSalary = 0;
        boolean flag = false;

        while (!flag) {
            System.out.println("Введите класс ученика (*new*) : ");
            String strNewSalary = new UserInput().input();
            if (Checker.isDigit(strNewSalary)) {
                flag = true;
                newSalary = Integer.parseInt(strNewSalary);
            } else {
                new Errors().salaryError();
            }
        }
        myBase.addBase(new Employee(newFirstName, newLastName, newSalary));
        System.out.println("______________________");
        System.out.println("Ученик добавлен");
        new Menu().mainMenu(myBase);
    }
}
