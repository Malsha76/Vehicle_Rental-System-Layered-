package lk.ijse.vehicle_rental.bo.custom;

import lk.ijse.vehicle_rental.bo.SuperBO;
import lk.ijse.vehicle_rental.dto.EmployeeDTO;
import lk.ijse.vehicle_rental.entity.Employee;

import java.sql.SQLException;

public interface EmployeeBO extends SuperBO {
    public Employee searchEmployee(String id) throws SQLException, ClassNotFoundException;
    public boolean addEmployee(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException;
    public boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException;
    public boolean updateEmployee(EmployeeDTO employeeDTO) throws SQLException, ClassNotFoundException;
}
