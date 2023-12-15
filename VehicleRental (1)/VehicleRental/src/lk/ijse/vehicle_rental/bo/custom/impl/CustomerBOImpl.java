package lk.ijse.vehicle_rental.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.vehicle_rental.bo.custom.CustomerBO;
import lk.ijse.vehicle_rental.dao.DAOFactory;
import lk.ijse.vehicle_rental.dao.custom.CustomerDAO;
import lk.ijse.vehicle_rental.dto.CustomerDTO;
import lk.ijse.vehicle_rental.entity.Customer;

import java.sql.SQLException;

public class CustomerBOImpl implements CustomerBO {

    //CustomerDAO customerDAO=new CustomerDAOImpl ();
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    @Override
    public ObservableList<CustomerDTO> searchAllCustomer() throws SQLException, ClassNotFoundException {
        ObservableList<Customer> list=customerDAO.searchAllCustomer ();
        ObservableList<CustomerDTO> allcustomer= FXCollections.observableArrayList ();

        for (Customer c : list) {
            allcustomer.add (new CustomerDTO (c.getId (),c.getName (),c.getAddress (),c.getEmail (),c.getContact ()));
        }
        return allcustomer;
    }

    @Override
    public Customer searchCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.search (id);
    }

    @Override
    public boolean addCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.add (new Customer (dto.getId (),dto.getName (),dto.getAddress (),dto.getEmail (),dto.getContact ()));
    }

    @Override
    public boolean deleteCustomer(String id) throws SQLException, ClassNotFoundException {
        return customerDAO.delete (id);
    }

    @Override
    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return customerDAO.update (new Customer (dto.getId (),dto.getName (),dto.getAddress (),dto.getEmail (),dto.getContact ()));
    }
}
