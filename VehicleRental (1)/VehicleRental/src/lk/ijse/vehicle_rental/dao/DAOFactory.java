package lk.ijse.vehicle_rental.dao;

import lk.ijse.vehicle_rental.dao.custom.impl.*;

public class DAOFactory {
    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        BOOKING,CUSTOMER,EMPLOYEE,MANAGE_VEHICLE,PACAKAGE,PAYMENT
    }

    public SuperDAO getDAO(DAOTypes types){
        switch (types) {
            case BOOKING:
                return new BookingDAOImpl ();
            case CUSTOMER:
                return new CustomerDAOImpl ();
            case EMPLOYEE:
                return new EmployeeDAOImpl ();
            case MANAGE_VEHICLE:
                return new ManageVehicleDAOImpl ();
            case PACAKAGE:
                return new PacakageDAOImpl ();
            case PAYMENT:
                return new PaymentDAOImpl ();
            default:
                return null;
        }
    }


}
