package lk.ijse.vehicle_rental.dao.custom.impl;

import lk.ijse.vehicle_rental.dao.CrudUtil;
import lk.ijse.vehicle_rental.dao.custom.EmployeeDAO;
import lk.ijse.vehicle_rental.entity.Employee;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeDAOImpl implements EmployeeDAO {
    public  boolean add(Employee employee) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO employee VALUES (?,?,?,?,?,?)";
        return CrudUtil.execute(sql, employee.getId(), employee.getName(), employee.getRole(),
                employee.getContact(), employee.getAddress(), employee.getSalary());
    }


    public  boolean delete(String id) throws SQLException, ClassNotFoundException {
        return CrudUtil.execute("DELETE FROM employee WHERE em_id = ?", id);
    }

    public  boolean update(Employee employee) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE employee SET em_name = ? ,em_role  = ? , contact = ? , em_address = ?, salary = ? WHERE em_id = ?";
        return CrudUtil.execute(sql,
                employee.getName(),
                employee.getRole(),
                employee.getContact(),
                employee.getAddress(),
                employee.getSalary(),
                employee.getId());
    }

    public  Employee search(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM employee WHERE em_id = ?";
        ResultSet resultSet = CrudUtil.execute(sql, id);
        if (resultSet.next()) {
            return new Employee(
                    resultSet.getString("em_id"),
                    resultSet.getString("em_name"),
                    resultSet.getString("em_role"),
                    resultSet.getString("contact"),
                    resultSet.getString("em_address"),
                    resultSet.getString("salary"));
        }
        return null;
    }
}
