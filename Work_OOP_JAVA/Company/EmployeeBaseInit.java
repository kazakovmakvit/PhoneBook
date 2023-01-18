public class EmployeeBaseInit {
    public EmployeeBase init() {
        Employee e1 = new Employee("Марат", "Игнатьев", 20);
        Employee e2 = new Employee("Илья", "Кусуев", 19);
        Employee e3 = new Employee("Олег", "Фоменко", 21);
        Employee e4 = new Employee("Артур", "Игнатьев", 23);
        Employee e5 = new Employee("Алексей", "Колачев", 21);
        Employee e6 = new Employee("Адель", "Замалов", 24);
        Employee e7 = new Employee("Сергей", "Лавра", 25);
        Employee e8 = new Employee("Евгений", "Зубков", 22);
        Employee e9 = new Employee("Дмитрий", "Егоров", 21);
        Employee e10 = new Employee("Булат", "Витальевич", 20);

        EmployeeBase base = new EmployeeBase();

        base.addBase(e1);
        base.addBase(e2);
        base.addBase(e3);
        base.addBase(e4);
        base.addBase(e5);
        base.addBase(e6);
        base.addBase(e7);
        base.addBase(e8);
        base.addBase(e9);
        base.addBase(e10);
        return base;
    }
}
