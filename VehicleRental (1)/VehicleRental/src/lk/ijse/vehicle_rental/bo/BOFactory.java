package lk.ijse.vehicle_rental.bo;

import lk.ijse.vehicle_rental.bo.custom.impl.*;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){
    }
    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory=new BOFactory() : boFactory;
    }

    public enum BOTypes{
        BOOKING,CUSTOMER,EMPLOYEE,MANAGE_VEHICLE,PACAKAGE,PAYMENT
    }

    //Object creation logic for BO objects
    public SuperBO getBO(BOTypes types){
        switch (types){
            case BOOKING:
                return new BookingBOImpl ();
            case CUSTOMER:
                return new CustomerBOImpl ();
            case EMPLOYEE:
                return new EmployeeBOImpl ();
            case MANAGE_VEHICLE:
                return new ManageVehicleBOImpl ();
            case PACAKAGE:
                return new PacakageBOImpl ();
            case PAYMENT:
                return new PaymentBOImpl ();
            default:
                return null;
        }
    }
}
