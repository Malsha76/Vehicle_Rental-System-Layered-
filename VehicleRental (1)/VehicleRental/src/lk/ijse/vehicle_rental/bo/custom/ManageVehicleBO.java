package lk.ijse.vehicle_rental.bo.custom;

import javafx.collections.ObservableList;
import lk.ijse.vehicle_rental.bo.SuperBO;
import lk.ijse.vehicle_rental.dto.ManagevehicleDTO;
import lk.ijse.vehicle_rental.entity.Managevehicle;

import java.sql.SQLException;

public interface ManageVehicleBO extends SuperBO {
    public Managevehicle search(String id) throws SQLException, ClassNotFoundException;
    public boolean add(ManagevehicleDTO dto) throws SQLException, ClassNotFoundException;
    public boolean delete(String id) throws SQLException, ClassNotFoundException;
    public boolean update(ManagevehicleDTO dto) throws SQLException, ClassNotFoundException;
    boolean updateManagevehicleToNo(String regID) throws SQLException, ClassNotFoundException ;
    boolean updateManagevehicleToYes(String regID) throws SQLException, ClassNotFoundException;
    boolean updateManagevehicle(ManagevehicleDTO dto) throws SQLException, ClassNotFoundException;
    ObservableList<ManagevehicleDTO> getVehiclDetails() throws SQLException, ClassNotFoundException;
}
