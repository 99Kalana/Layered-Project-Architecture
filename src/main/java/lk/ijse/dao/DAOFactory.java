package lk.ijse.dao;

import lk.ijse.dao.custom.impl.*;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory(){}

    public static DAOFactory getDaoFactory(){
        return (daoFactory==null)? daoFactory = new DAOFactory(): daoFactory;
    }

    public enum DAOTypes{
        APPOINTMENT,BILL,BILL_DETAIL,BILL_RECORD,BILL_DETAILS,CLIENT,MEDICINE,MEDICINE_SUPPLIER,PET,PRESCRIPTION,PRESCRIPTION_MEDICINE,PRESCRIPTION_TREATMENT,SUPPLIER,TREATMENTS,VETERINARIAN,LOGIN,REGISTER,RESET_PASSWORD
    }

    public SuperDAO getDao(DAOTypes types){
        switch (types){
            case APPOINTMENT:
                return new AppointmentDAOImpl();

            case BILL:
                return new BillDAOImpl();

            case BILL_DETAIL:
                return new BillDetailDAOImpl();

            case BILL_RECORD:
                return new BillRecordDAOImpl();

            case BILL_DETAILS:
                return new BillsDetailsDAOImpl();

            case CLIENT:
                return new ClientDAOImpl();

            case MEDICINE:
                return new MedicineDAOImpl();

            case MEDICINE_SUPPLIER:
                return new MedicineSupplierDAOImpl();

            case PET:
                return new PetDAOImpl();

            case PRESCRIPTION:
                return new PrescriptionDAOImpl();

            case PRESCRIPTION_MEDICINE:
                return new PrescriptionMedicineDAOImpl();

            case PRESCRIPTION_TREATMENT:
                return new PrescriptionTreatmentDAOImpl();

            case SUPPLIER:
                return new SupplierDAOImpl();

            case TREATMENTS:
                return new TreatmentsDAOImpl();

            case VETERINARIAN:
                return new VeterinarianDAOImpl();

            case LOGIN:
                return new LoginDAOImpl();

            case REGISTER:
                return new RegisterDAOImpl();

            case RESET_PASSWORD:
                return new ResetPasswordDAOImpl();

            default:
                return null;
        }
    }


}
