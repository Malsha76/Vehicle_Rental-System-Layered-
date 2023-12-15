package lk.ijse.vehicle_rental.dao.custom.impl;

import javafx.scene.control.Alert;
import lk.ijse.vehicle_rental.dao.CrudUtil;
import lk.ijse.vehicle_rental.dao.custom.PaymentDAO;
import lk.ijse.vehicle_rental.entity.Payment;

import java.sql.SQLException;

public class PaymentDAOImpl implements PaymentDAO {
    @Override
    public Payment search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    public  boolean add(Payment payment) {
        try {
            return CrudUtil.execute("INSERT INTO payment VALUES (?,?,?,?,?)",
                    payment.getId(),
                    payment.getDate(),
                    payment.getAdvance(),
                    payment.getPayment(),
                    payment.getCusID()
            );
        } catch (SQLException | ClassNotFoundException e) {
            new Alert (Alert.AlertType.ERROR, e.toString()).show();
        }
        return false;
    }

    public  boolean delete(String text) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM payment WHERE bill_id = '" + text + "'";
        return CrudUtil.execute(sql);
    }

    public  boolean update(Payment payment) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE payment SET  date  = ? ,advance= ? , fee = ?  cus_id = ? , WHERE bill_id = ? ";
        return CrudUtil.execute(sql,
                payment.getDate(),
                payment.getAdvance(),
                payment.getPayment(),
                payment.getCusID(),
                payment.getId());
    }

}
