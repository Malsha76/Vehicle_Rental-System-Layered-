package lk.ijse.vehicle_rental.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.vehicle_rental.dao.CrudDAO;
import lk.ijse.vehicle_rental.entity.Customer;

import java.sql.SQLException;

public interface CustomerDAO extends CrudDAO<Customer> {
    ObservableList<Customer> searchAllCustomer() throws SQLException, ClassNotFoundException;
}
