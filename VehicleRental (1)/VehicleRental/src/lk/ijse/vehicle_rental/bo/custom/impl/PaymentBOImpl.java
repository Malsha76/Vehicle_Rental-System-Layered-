package lk.ijse.vehicle_rental.bo.custom.impl;

import lk.ijse.vehicle_rental.bo.custom.PaymentBO;
import lk.ijse.vehicle_rental.dao.DAOFactory;
import lk.ijse.vehicle_rental.dao.custom.PaymentDAO;
import lk.ijse.vehicle_rental.dto.PaymentDTO;
import lk.ijse.vehicle_rental.entity.Payment;

import java.sql.SQLException;

public class PaymentBOImpl implements PaymentBO {

   // PaymentDAO paymentDAO=new PaymentDAOImpl ();
   PaymentDAO paymentDAO = (PaymentDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PAYMENT);
    @Override
    public Payment searchPayment(String id) throws SQLException, ClassNotFoundException {
        return paymentDAO.search (id);
    }

    @Override
    public boolean addPayment(PaymentDTO dto) throws SQLException, ClassNotFoundException {
        return paymentDAO.add (new Payment (dto.getId (),dto.getDate (),dto.getAdvance (),dto.getPayment (),dto.getCusID ()));
        //String id, String date, String advance, String payment, String cusID
    }

    @Override
    public boolean deletePayment(String id) throws SQLException, ClassNotFoundException {
        return paymentDAO.delete (id);
    }

    @Override
    public boolean updatePayment(PaymentDTO dto) throws SQLException, ClassNotFoundException {
        return paymentDAO.update (new Payment (dto.getId (),dto.getDate (),dto.getAdvance (),dto.getPayment (),dto.getCusID ()));
    }
}
