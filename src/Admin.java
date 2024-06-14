import java.util.ArrayList;
import java.util.List;

public class Admin extends Employee {
    private List<Employee> employees;

    public Admin(String firstName, String lastName) {
        super(firstName, lastName);
        this.employees = new ArrayList<>();
    }

    public Employee addEmployee(String imie, String nazwisko) {
        Employee employee = new Employee(imie, nazwisko);
        employees.add(employee);
        return employee;
    }

    public void removeEmployee(Employee employee) {
        employees.remove(employee);
    }

    public List<Employee> getEmployees() {
        return employees;
    }
}
