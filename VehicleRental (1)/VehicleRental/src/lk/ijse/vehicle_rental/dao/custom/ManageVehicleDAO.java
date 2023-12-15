package lk.ijse.vehicle_rental.dao.custom;

import javafx.collections.ObservableList;
import lk.ijse.vehicle_rental.dao.CrudDAO;
import lk.ijse.vehicle_rental.entity.Managevehicle;

import java.sql.SQLException;

public interface ManageVehicleDAO extends CrudDAO<Managevehicle> {
    boolean updateManagevehicleToNo(String regID) throws SQLException, ClassNotFoundException ;
    boolean updateManagevehicleToYes(String regID) throws SQLException, ClassNotFoundException;
    boolean updateManagevehicle(Managevehicle managevehicle) throws SQLException, ClassNotFoundException;
    ObservableList<Managevehicle> getVehiclDetails() throws SQLException, ClassNotFoundException;
}
