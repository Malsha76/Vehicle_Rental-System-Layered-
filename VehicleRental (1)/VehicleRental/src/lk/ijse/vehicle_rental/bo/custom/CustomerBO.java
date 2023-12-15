package lk.ijse.vehicle_rental.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.vehicle_rental.bo.SuperBO;
import lk.ijse.vehicle_rental.dto.CustomerDTO;
import lk.ijse.vehicle_rental.entity.Customer;

import java.sql.SQLException;

public interface CustomerBO extends SuperBO {
    ObservableList<CustomerDTO> searchAllCustomer() throws SQLException, ClassNotFoundException;
    public Customer searchCustomer(String id) throws SQLException, ClassNotFoundException;
    public boolean addCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException;
    public boolean updateCustomer(CustomerDTO customerDTO) throws SQLException, ClassNotFoundException;
}
