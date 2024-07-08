package lk.ijse.bo;

import lk.ijse.bo.custom.impl.*;
import lk.ijse.dao.custom.impl.*;

public class BOFactory {

    private static BOFactory boFactory;

    private BOFactory(){}

    public static BOFactory getBoFactory(){
        return (boFactory==null)? boFactory = new BOFactory():boFactory;
    }

    public enum BOTypes{
        APPOINTMENT,BILL,BILL_DETAIL,BILL_RECORD,BILL_DETAILS,CLIENT,MEDICINE,MEDICINE_SUPPLIER,PET,PLACE_BILL,PRESCRIPTION,PRESCRIPTION_MEDICINE,PRESCRIPTION_TREATMENT,SUPPLIER,TREATMENTS,VETERINARIAN,LOGIN,REGISTER,RESET_PASSWORD
    }

    public SuperBO getBo(BOTypes types){
        switch (types){

            case APPOINTMENT:
                return new AppointmentBOImpl();

            case BILL:
                return new BillBOImpl();

            case BILL_DETAIL:
                return new BillDetailBOImpl();

            case BILL_RECORD:
                return new BillRecordBOImpl();

            case BILL_DETAILS:
                return new BillsDetailsBOImpl();

            case CLIENT:
                return new ClientBOImpl();

            case MEDICINE:
                return new MedicineBOImpl();

            case MEDICINE_SUPPLIER:
                return new MedicineSupplierBOImpl();

            case PET:
                return new PetBOImpl();

            case PLACE_BILL:
                return new PlaceBillBOImpl();

            case PRESCRIPTION:
                return new PrescriptionBOImpl();

            case PRESCRIPTION_MEDICINE:
                return new PrescriptionMedicineBOImpl();

            case PRESCRIPTION_TREATMENT:
                return new PrescriptionTreatmentBOImpl();

            case SUPPLIER:
                return new SupplierBOImpl();

            case TREATMENTS:
                return new TreatmentsBOImpl();

            case VETERINARIAN:
                return new VeterinarianBOImpl();

            case LOGIN:
                return new LoginBOImpl();

            case REGISTER:
                return new RegisterBOImpl();


            case RESET_PASSWORD:
                return new ResetPasswordBOImpl();

            default:
                return null;
        }
    }

}
