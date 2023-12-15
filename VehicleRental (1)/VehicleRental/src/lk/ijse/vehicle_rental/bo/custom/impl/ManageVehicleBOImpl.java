package lk.ijse.vehicle_rental.bo.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lk.ijse.vehicle_rental.bo.custom.ManageVehicleBO;
import lk.ijse.vehicle_rental.dao.DAOFactory;
import lk.ijse.vehicle_rental.dao.custom.ManageVehicleDAO;
import lk.ijse.vehicle_rental.dto.ManagevehicleDTO;
import lk.ijse.vehicle_rental.entity.Managevehicle;

import java.sql.SQLException;

public class ManageVehicleBOImpl implements ManageVehicleBO {

    //ManageVehicleDAO manageVehicleDAO=new ManageVehicleDAOImpl ();
    ManageVehicleDAO manageVehicleDAO = (ManageVehicleDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.MANAGE_VEHICLE);
    @Override
    public Managevehicle search(String id) throws SQLException, ClassNotFoundException {
        return manageVehicleDAO.search (id);
    }

    @Override
    public boolean add(ManagevehicleDTO dto) throws SQLException, ClassNotFoundException {
        return manageVehicleDAO.add (new Managevehicle (dto.getResigter_id (),dto.getModel (),dto.getColour (),dto.getVeh_name (),dto.getAvailability (),dto.getInsurance (),dto.getTransmission ()));
        //String resigter_id, String model, String colour, String veh_name, String availability, String insurance, String transmission
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return manageVehicleDAO.delete (id);
    }

    @Override
    public boolean update(ManagevehicleDTO dto) throws SQLException, ClassNotFoundException {
        return manageVehicleDAO.update (new Managevehicle (dto.getResigter_id (),dto.getModel (),dto.getColour (),dto.getVeh_name (),dto.getAvailability (),dto.getInsurance (),dto.getTransmission ()));
    }

    @Override
    public boolean updateManagevehicleToNo(String regID) throws SQLException, ClassNotFoundException {
        return manageVehicleDAO.updateManagevehicleToNo (regID);
    }

    @Override
    public boolean updateManagevehicleToYes(String regID) throws SQLException, ClassNotFoundException {
        return manageVehicleDAO.updateManagevehicleToYes (regID);
    }

    @Override
    public boolean updateManagevehicle(ManagevehicleDTO dto) throws SQLException, ClassNotFoundException {
        return manageVehicleDAO.updateManagevehicle (new Managevehicle (dto.getResigter_id (),dto.getModel (),dto.getColour (),dto.getVeh_name (),dto.getAvailability (),dto.getInsurance (),dto.getTransmission ()));
    }

    @Override
    public ObservableList<ManagevehicleDTO> getVehiclDetails() throws SQLException, ClassNotFoundException {
        ObservableList<Managevehicle> list= manageVehicleDAO.getVehiclDetails ();
        ObservableList<ManagevehicleDTO> allvehicle= FXCollections.observableArrayList ();
        for (Managevehicle m : list) {
            allvehicle.add (new ManagevehicleDTO (m.getResigter_id (),m.getModel (),m.getColour (),m.getVeh_name (),m.getAvailability (),m.getInsurance (),m.getTransmission ()));
        }
        return allvehicle;
    }
}
