package lk.ijse.vehicle_rental.dao.custom.impl;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;
import lk.ijse.vehicle_rental.dao.CrudUtil;
import lk.ijse.vehicle_rental.dao.custom.ManageVehicleDAO;
import lk.ijse.vehicle_rental.entity.Managevehicle;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ManageVehicleDAOImpl implements ManageVehicleDAO {
    public  boolean add(Managevehicle managevehicle2) {
        try {
            //register_id, model, colour, avalibility, veh_name, insurance, transmission
            return CrudUtil.execute("INSERT INTO vehicledetail VALUES (?,?,?,?,?,?,?)",
                    managevehicle2.getResigter_id(),
                    managevehicle2.getModel(),
                    managevehicle2.getColour(),
                    managevehicle2.getAvailability(),
                    managevehicle2.getVeh_name(),
                    managevehicle2.getInsurance(),
                    managevehicle2.getTransmission());
        } catch (SQLException | ClassNotFoundException e) {
            new Alert (Alert.AlertType.ERROR, e.toString()).show();
        }
        return false;
    }

    public  boolean delete(String text) {
        String sql = "DELETE FROM vehicledetail WHERE reg_id = '" + text + "'";
        try {
            return CrudUtil.execute(sql);
        } catch (SQLException | ClassNotFoundException e) {
            new Alert(Alert.AlertType.ERROR, e.toString()).show();
        }
        return false;
    }

    @Override
    public boolean update(Managevehicle entity) throws SQLException, ClassNotFoundException {
        return false;
    }


    public boolean updateManagevehicleToNo(String regID) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE vehicleDetail SET availability = 'no' where reg_id = ?";
        return CrudUtil.execute(sql, regID);
    }

    public  boolean updateManagevehicleToYes(String regID) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE vehicleDetail SET availability = 'yes' where reg_id = ?";
        return CrudUtil.execute(sql, regID);
    }

    public  boolean updateManagevehicle(Managevehicle managevehicle) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE vehicleDetail SET model = ? , colour  = ? ,veh_name = ? ,availability = ?,insurance = ?, transmission = ? WHERE reg_id = ?";
        //register_id, model, colour, avalibility, veh_name, insurance, transmission
        return CrudUtil.execute(sql,
                managevehicle.getModel(),
                managevehicle.getColour(),
                managevehicle.getVeh_name(),
                managevehicle.getAvailability(),
                managevehicle.getInsurance(),
                managevehicle.getTransmission(),
                managevehicle.getResigter_id());
    }

    public  Managevehicle search(String id) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM vehicleDetail WHERE reg_id =?";
        ResultSet resultSet = CrudUtil.execute(sql, id);
        if (resultSet.next()) {
            return new Managevehicle(
                    resultSet.getString("reg_id"),
                    resultSet.getString("model"),
                    resultSet.getString("colour"),
                    resultSet.getString("veh_name"),
                    resultSet.getString("availability"),
                    resultSet.getString("insurance"),
                    resultSet.getString("transmission")
            );
        }
        return null;
    }

    public  ObservableList<Managevehicle> getVehiclDetails() throws SQLException, ClassNotFoundException {
        ObservableList<Managevehicle> list = FXCollections.observableArrayList();
        String sql = "SELECT * FROM vehicledetail";
        ResultSet resultSet = CrudUtil.execute(sql);
        while (resultSet.next()) {
            Managevehicle managevehicle = new Managevehicle(
                    resultSet.getString("reg_id"),
                    resultSet.getString("model"),
                    resultSet.getString("colour"),
                    resultSet.getString("veh_name"),
                    resultSet.getString("availability"),
                    resultSet.getString("insurance"),
                    resultSet.getString("transmission"));

            list.add(managevehicle);
        }
        return list;
    }
}
