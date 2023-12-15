package lk.ijse.vehicle_rental.bo.custom;

import lk.ijse.vehicle_rental.bo.SuperBO;
import lk.ijse.vehicle_rental.dto.PaymentDTO;
import lk.ijse.vehicle_rental.entity.Payment;

import java.sql.SQLException;

public interface PaymentBO extends SuperBO {
    public Payment searchPayment(String id) throws SQLException, ClassNotFoundException;
    public boolean addPayment(PaymentDTO dto) throws SQLException, ClassNotFoundException;
    public boolean deletePayment(String id) throws SQLException, ClassNotFoundException;
    public boolean updatePayment(PaymentDTO dto) throws SQLException, ClassNotFoundException;
}
