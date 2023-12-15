package lk.ijse.vehicle_rental.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.vehicle_rental.bo.SuperBO;
import lk.ijse.vehicle_rental.dto.BookingDTO;
import lk.ijse.vehicle_rental.entity.Booking;

import java.sql.SQLException;

public interface BookingBO extends SuperBO {
    public Booking searchBooking(String id) throws SQLException, ClassNotFoundException;
    public boolean addBooking(BookingDTO bookingDTO) throws SQLException, ClassNotFoundException;
    public boolean deleteBooking(String id) throws SQLException, ClassNotFoundException;
    public boolean updateBooking(BookingDTO bookingDTO) throws SQLException, ClassNotFoundException;
    public String getAvalibility(String id);
    public ObservableList<BookingDTO> searchAllBooking() throws SQLException, ClassNotFoundException;
}
