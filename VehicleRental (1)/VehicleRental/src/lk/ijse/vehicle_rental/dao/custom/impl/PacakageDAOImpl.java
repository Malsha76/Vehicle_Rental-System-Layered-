package lk.ijse.vehicle_rental.dao.custom.impl;

import lk.ijse.vehicle_rental.dao.CrudUtil;
import lk.ijse.vehicle_rental.dao.custom.PackageDAO;
import lk.ijse.vehicle_rental.entity.Packages;

import java.sql.SQLException;

public class PacakageDAOImpl implements PackageDAO {
    @Override
    public Packages search(String id) throws SQLException, ClassNotFoundException {
        return null;
    }

    public  boolean add(Packages packages) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO package VALUES (?,?,?)";
        return CrudUtil.execute(sql, packages.getPackage_id(), packages.getPackage_name(), packages.getPrice());
    }

    public  boolean delete(String id) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM package WHERE pac_id = ?" ;
        return CrudUtil.execute(sql,id);
    }

    public  boolean update(Packages packages) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE package pac_id SET pac_name = ? , price  = ? WHERE pac_id = ?";
        return CrudUtil.execute(sql,
                packages.getPackage_name(),
                packages.getPrice(),
                packages.getPackage_id());

    }
}
