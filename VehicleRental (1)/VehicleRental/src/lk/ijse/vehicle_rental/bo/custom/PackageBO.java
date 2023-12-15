package lk.ijse.vehicle_rental.bo.custom;

import lk.ijse.vehicle_rental.bo.SuperBO;
import lk.ijse.vehicle_rental.dto.PackagesDTO;
import lk.ijse.vehicle_rental.entity.Packages;

import java.sql.SQLException;

public interface PackageBO extends SuperBO {
    public Packages search(String id) throws SQLException, ClassNotFoundException;
    public boolean add(PackagesDTO dto) throws SQLException, ClassNotFoundException;
    public boolean delete(String id) throws SQLException, ClassNotFoundException;
    public boolean update(PackagesDTO dto) throws SQLException, ClassNotFoundException;
}
