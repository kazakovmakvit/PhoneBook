public class Employee {
    private final int id;
    private String firstName;
    private String lastName;
    private int yers;
    static private int currentId = 1;

    public Employee(String argFirstName, String argLastName, int argYers) {
        this.firstName = argFirstName;
        this.lastName = argLastName;
        this.yers = argYers;
        this.id = currentId;
        currentId++;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastNameName(String newLastName) {
        this.lastName = newLastName;
    }

    public int getYers() {
        return yers;
    }

    public void setYers(int newSalary) {
        this.yers = newSalary;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String newFirstName) {
        this.firstName = newFirstName;
    }

   
}