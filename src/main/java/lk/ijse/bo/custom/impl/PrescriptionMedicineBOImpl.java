package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.PrescriptionMedicineBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.PrescriptionMedicineDAO;
import lk.ijse.dto.PrescriptionMedicineDTO;
import lk.ijse.entity.BillDetailEntity;
import lk.ijse.entity.PrescriptionMedicineEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionMedicineBOImpl implements PrescriptionMedicineBO {

    PrescriptionMedicineDAO prescriptionMedicineDAO = (PrescriptionMedicineDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.PRESCRIPTION_MEDICINE);

    @Override
    public PrescriptionMedicineDTO searchById(String id) throws SQLException {

        PrescriptionMedicineEntity prescriptionMedicine = prescriptionMedicineDAO.searchById(id);
        return new PrescriptionMedicineDTO(prescriptionMedicine.getId(), prescriptionMedicine.getpId());

    }

    @Override
    public  boolean save(PrescriptionMedicineDTO dto) throws SQLException {

        return prescriptionMedicineDAO.save(new PrescriptionMedicineEntity(dto.getId(), dto.getpId()));

    }

    @Override
    public  boolean update(PrescriptionMedicineDTO dto) throws SQLException {

        return prescriptionMedicineDAO.update(new PrescriptionMedicineEntity(dto.getId(), dto.getpId()));
    }

    @Override
    public  boolean delete(String id) throws SQLException {

        return prescriptionMedicineDAO.delete(id);

    }


    @Override
    public  List<PrescriptionMedicineDTO> getAll() throws SQLException {

        List<PrescriptionMedicineDTO>prescriptionMedicineDTOList=new ArrayList<>();
        List<PrescriptionMedicineEntity>prescriptionMedicineEntities=prescriptionMedicineDAO.getAll();

        for (PrescriptionMedicineEntity prescriptionMedicine:prescriptionMedicineEntities){
            prescriptionMedicineDTOList.add(new PrescriptionMedicineDTO(prescriptionMedicine.getId(),prescriptionMedicine.getpId()));
        }

        return prescriptionMedicineDTOList;

    }


}
