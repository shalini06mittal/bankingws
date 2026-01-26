package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDB {

    private static Connection con ;

    public EmployeeDB(){
        try {
            con = MyConnection.connect();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
    //create table employee(id int primary key auto_increment, name varchar(50) not null, phone varchar(50) not null);
    public boolean addEmployee(Employee employee){
        String sql = "insert into employee values(?,?,?)";
        try {
            PreparedStatement statement = con.prepareStatement(sql);
            statement.setInt(1, employee.getId());
            statement.setString(2, employee.getName());
            statement.setString(3, employee.getPhone());
           if( statement.execute())
                return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    public Employee getEmployeeById(int id){
        Employee employee =  null;
        String sql = "select * from employee where id=?";
        try {
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            if(rs.next()){
                employee = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return employee;
    }
    public List<Employee> getEmployees(){
        List<Employee> employeeList =  new ArrayList<>();
        String sql = "select * from employee";
        try {
            PreparedStatement statement = con.prepareStatement(sql);


            ResultSet rs = statement.executeQuery();
            while (rs.next()){
              Employee  employee = new Employee(rs.getInt(1), rs.getString(2), rs.getString(3));
              employeeList.add(employee);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return employeeList;
    }
}
