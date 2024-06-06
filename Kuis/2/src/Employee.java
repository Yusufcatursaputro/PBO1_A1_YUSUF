import java.util.Random;

abstract class Employee {
    protected String id;
    protected String name;
    protected String dateOfBirth;
    protected String position;
    protected String department;
    protected int salary;

    public Employee(String name, String dateOfBirth, String position, String department) {
        this.name = name;
        this.dateOfBirth = dateOfBirth;
        this.position = position;
        this.department = department;
        this.id = generateID(department, dateOfBirth);
    }

    private String generateID(String department, String dateOfBirth) {
        String departmentCode = department.equals("Product") ? "PROD" : "HR";
        Random rand = new Random();
        int randomNumber = rand.nextInt(900) + 100; // random 3 digit number
        return "000" + departmentCode + dateOfBirth.replace("-", "") + randomNumber;
    }

    public abstract int calculateSalary();

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public String getPosition() {
        return position;
    }


    public int getSalary() {
        return salary;
    }

    public static String[] getDepartment() {
        return new String[]{"Product", "Human Resources"};
    }
}
