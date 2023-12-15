package lk.ijse.vehicle_rental.bo.custom.impl;

import lk.ijse.vehicle_rental.bo.custom.PackageBO;
import lk.ijse.vehicle_rental.dao.DAOFactory;
import lk.ijse.vehicle_rental.dao.custom.PackageDAO;
import lk.ijse.vehicle_rental.dto.PackagesDTO;
import lk.ijse.vehicle_rental.entity.Packages;

import java.sql.SQLException;

public class PacakageBOImpl implements PackageBO {

    //PackageDAO packageDAO=new PacakageDAOImpl ();
    PackageDAO packageDAO = (PackageDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.PACAKAGE);
    @Override
    public Packages search(String id) throws SQLException, ClassNotFoundException {
        return packageDAO.search (id);
    }

    @Override
    public boolean add(PackagesDTO dto) throws SQLException, ClassNotFoundException {
        return packageDAO.add (new Packages (dto.getPackage_id (),dto.getPackage_name (),dto.getPrice ()));
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        return packageDAO.delete (id);
    }

    @Override
    public boolean update(PackagesDTO dto) throws SQLException, ClassNotFoundException {
        return packageDAO.update (new Packages (dto.getPackage_id (),dto.getPackage_name (),dto.getPrice ()));
    }
}
