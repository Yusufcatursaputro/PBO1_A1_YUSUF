public class Developer extends Employee {
    public Developer(String name, String dateOfBirth, String department) {
        super(name, dateOfBirth, "Developer", department);
        this.salary = calculateSalary();
    }

    @Override
    public int calculateSalary() {
        return 10000000;
    }
}
