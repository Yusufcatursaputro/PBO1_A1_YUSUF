public class HRStaff extends Employee {
    public HRStaff(String name, String dateOfBirth, String department) {
        super(name, dateOfBirth, "HR Staff", department);
        this.salary = calculateSalary();
    }

    @Override
    public int calculateSalary() {
        return 5000000;
    }
}
