package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.PrescriptionBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.PrescriptionDAO;
import lk.ijse.dto.PrescriptionDTO;
import lk.ijse.entity.BillDetailEntity;
import lk.ijse.entity.PrescriptionEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PrescriptionBOImpl implements PrescriptionBO {

    PrescriptionDAO prescriptionDAO = (PrescriptionDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.PRESCRIPTION);

    @Override
    public PrescriptionDTO searchById(String id) throws SQLException {

        PrescriptionEntity prescription = prescriptionDAO.searchById(id);
        return new PrescriptionDTO(prescription.getId(), prescription.getType(), prescription.getVeterinarianId());

    }

    @Override
    public  boolean save(PrescriptionDTO dto) throws SQLException {

        return prescriptionDAO.save(new PrescriptionEntity(dto.getId(), dto.getType(), dto.getVeterinarianId()));
    }

    @Override
    public  boolean update(PrescriptionDTO dto) throws SQLException {

        return prescriptionDAO.update(new PrescriptionEntity(dto.getId(), dto.getType(), dto.getVeterinarianId()));
    }

    @Override
    public  boolean delete(String id) throws SQLException {

        return prescriptionDAO.delete(id);

    }

    @Override
    public  List<PrescriptionDTO> getAll() throws SQLException {

        List<PrescriptionDTO>prescriptionDTOList=new ArrayList<>();
        List<PrescriptionEntity>prescriptionEntities=prescriptionDAO.getAll();

        for (PrescriptionEntity prescription:prescriptionEntities){
            prescriptionDTOList.add(new PrescriptionDTO(prescription.getId(), prescription.getType(), prescription.getVeterinarianId()));
        }

        return prescriptionDTOList;

    }


}
