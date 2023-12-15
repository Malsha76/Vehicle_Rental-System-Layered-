package lk.ijse.vehicle_rental.bo.custom.impl;

import lk.ijse.vehicle_rental.bo.custom.EmployeeBO;
import lk.ijse.vehicle_rental.dao.DAOFactory;
import lk.ijse.vehicle_rental.dao.custom.EmployeeDAO;
import lk.ijse.vehicle_rental.dto.EmployeeDTO;
import lk.ijse.vehicle_rental.entity.Employee;

import java.sql.SQLException;

public class EmployeeBOImpl implements EmployeeBO {

    EmployeeDAO employeeDAO = (EmployeeDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.EMPLOYEE);
    //EmployeeDAO employeeDAO=new EmployeeDAOImpl ();
    @Override
    public Employee searchEmployee(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.search (id);
    }

    @Override
    public boolean addEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return employeeDAO.add (new Employee (dto.getId (),dto.getName (),dto.getRole (),dto.getContact (),dto.getAddress (),dto.getSalary ()));
    }

    @Override
    public boolean deleteEmployee(String id) throws SQLException, ClassNotFoundException {
        return employeeDAO.delete (id);
    }

    @Override
    public boolean updateEmployee(EmployeeDTO dto) throws SQLException, ClassNotFoundException {
        return employeeDAO.update (new Employee (dto.getId (),dto.getName (),dto.getRole (),dto.getContact (),dto.getAddress (),dto.getSalary ()));
    }
}
