public class Manager extends Employee {
    public Manager(String name, String dateOfBirth, String department) {
        super(name, dateOfBirth, "Manager", department);
        this.salary = calculateSalary();
    }

    @Override
    public int calculateSalary() {
        return 20000000;
    }
}
