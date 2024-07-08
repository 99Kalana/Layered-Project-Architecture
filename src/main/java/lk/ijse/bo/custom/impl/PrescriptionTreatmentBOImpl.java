package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.PrescriptionTreatmentBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.PrescriptionTreatmentDAO;
import lk.ijse.dto.PrescriptionTreatmentDTO;
import lk.ijse.entity.BillDetailEntity;
import lk.ijse.entity.PrescriptionTreatmentEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionTreatmentBOImpl implements PrescriptionTreatmentBO {


    PrescriptionTreatmentDAO prescriptionTreatmentDAO=(PrescriptionTreatmentDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.PRESCRIPTION_TREATMENT);

    @Override
    public PrescriptionTreatmentDTO searchById(String id) throws SQLException {

        PrescriptionTreatmentEntity prescriptionTreatment=prescriptionTreatmentDAO.searchById(id);
        return new PrescriptionTreatmentDTO(prescriptionTreatment.getpId(), prescriptionTreatment.gettId(), prescriptionTreatment.getPrice(), prescriptionTreatment.getDate(), prescriptionTreatment.getTime());

    }

    @Override
    public  boolean save(PrescriptionTreatmentDTO dto) throws SQLException {

        return prescriptionTreatmentDAO.save(new PrescriptionTreatmentEntity(dto.getpId(), dto.gettId(), dto.getPrice(), dto.getDate(), dto.getTime()));

    }

    @Override
    public  boolean update(PrescriptionTreatmentDTO dto) throws SQLException {

        return prescriptionTreatmentDAO.update(new PrescriptionTreatmentEntity(dto.getpId(), dto.gettId(), dto.getPrice(), dto.getDate(), dto.getTime()));

    }

    @Override
    public  boolean delete(String id) throws SQLException {

        return prescriptionTreatmentDAO.delete(id);
    }

    @Override
    public  List<PrescriptionTreatmentDTO> getAll() throws SQLException {

        List<PrescriptionTreatmentDTO>prescriptionTreatmentDTOList=new ArrayList<>();
        List<PrescriptionTreatmentEntity>prescriptionTreatmentEntities=prescriptionTreatmentDAO.getAll();

        for (PrescriptionTreatmentEntity prescriptionTreatment:prescriptionTreatmentEntities){
            prescriptionTreatmentDTOList.add(new PrescriptionTreatmentDTO(prescriptionTreatment.getpId(), prescriptionTreatment.gettId(), prescriptionTreatment.getPrice(), prescriptionTreatment.getDate(), prescriptionTreatment.getTime()));
        }

        return prescriptionTreatmentDTOList;

    }



}
