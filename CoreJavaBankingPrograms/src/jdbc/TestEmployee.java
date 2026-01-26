package jdbc;

public class TestEmployee {
    static void main() {
        EmployeeDB employeeDB = new EmployeeDB();
//        employeeDB.addEmployee(new Employee(1,"Shalini","1212121212"));
//        employeeDB.addEmployee(new Employee(2,"Chirag","2323232323"));
        System.out.println(employeeDB.getEmployeeById(1));
        for(Employee employee: employeeDB.getEmployees())
            System.out.println(employee);
    }
}
