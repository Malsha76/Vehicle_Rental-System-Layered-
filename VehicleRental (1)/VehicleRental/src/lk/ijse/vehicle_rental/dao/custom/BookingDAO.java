package lk.ijse.vehicle_rental.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.vehicle_rental.dao.CrudDAO;
import lk.ijse.vehicle_rental.entity.Booking;

import java.sql.SQLException;

public interface BookingDAO extends CrudDAO<Booking> {
    public String getAvalibility(String id);
    public ObservableList<Booking> searchAllBooking() throws SQLException, ClassNotFoundException;
}
