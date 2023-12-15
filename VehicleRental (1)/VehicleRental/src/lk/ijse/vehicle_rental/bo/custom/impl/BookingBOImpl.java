package lk.ijse.vehicle_rental.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.vehicle_rental.bo.custom.BookingBO;
import lk.ijse.vehicle_rental.dao.DAOFactory;
import lk.ijse.vehicle_rental.dao.custom.BookingDAO;
import lk.ijse.vehicle_rental.dto.BookingDTO;
import lk.ijse.vehicle_rental.entity.Booking;

import java.sql.SQLException;

public class BookingBOImpl implements BookingBO {

   // BookingDAO bookingDAO=new BookingDAOImpl ();
   BookingDAO bookingDAO = (BookingDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.BOOKING);
    @Override
    public Booking searchBooking(String id) throws SQLException, ClassNotFoundException {
        return bookingDAO.search (id);
    }

    @Override
    public boolean addBooking(BookingDTO dto) throws SQLException, ClassNotFoundException {
        return bookingDAO.add (new Booking (dto.getBook_id (),dto.getReg_id (),dto.getCus_id (),dto.getBook_date (),dto.getReturn_date ()));
        //String book_id, String reg_id, String cus_id, String book_date, String return_date) {
    }

    @Override
    public boolean deleteBooking(String id) throws SQLException, ClassNotFoundException {
        return bookingDAO.delete (id);
    }

    @Override
    public boolean updateBooking(BookingDTO dto) throws SQLException, ClassNotFoundException {
        return bookingDAO.update (new Booking (dto.getBook_id (),dto.getReg_id (),dto.getCus_id (),dto.getBook_date (),dto.getReturn_date ()));
    }

    @Override
    public String getAvalibility(String id) {
        return bookingDAO.getAvalibility (id);
    }

    @Override
    public ObservableList<BookingDTO> searchAllBooking() throws SQLException, ClassNotFoundException {
        ObservableList<Booking> all=bookingDAO.searchAllBooking ();
        ObservableList<BookingDTO> allbooking= FXCollections.observableArrayList ();

        for (Booking b : all) {
            allbooking.add (new BookingDTO (b.getBook_id (),b.getReg_id (),b.getCus_id (),b.getBook_date (),b.getReturn_date ()));
        }
        return allbooking;
    }
}
