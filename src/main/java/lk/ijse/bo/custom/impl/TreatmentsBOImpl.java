package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.TreatmentsBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.TreatmentsDAO;
import lk.ijse.dto.TreatmentsDTO;
import lk.ijse.entity.BillDetailEntity;
import lk.ijse.entity.TreatmentsEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TreatmentsBOImpl implements TreatmentsBO {

    TreatmentsDAO treatmentsDAO = (TreatmentsDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.TREATMENTS);

    @Override
    public TreatmentsDTO searchById(String id) throws SQLException {

        TreatmentsEntity treatments = treatmentsDAO.searchById(id);
        return new TreatmentsDTO(treatments.getId(),treatments.getType(),treatments.getDescription());

    }

   @Override
    public  boolean save(TreatmentsDTO dto) throws SQLException {

        return treatmentsDAO.save(new TreatmentsEntity(dto.getId(), dto.getType(), dto.getDescription()));

    }

    @Override
    public  boolean update(TreatmentsDTO dto) throws SQLException {

        return treatmentsDAO.update(new TreatmentsEntity(dto.getId(), dto.getType(), dto.getDescription()));
    }

    @Override
    public  boolean delete(String id) throws SQLException {

        return treatmentsDAO.delete(id);

    }

    @Override
    public  List<TreatmentsDTO> getAll() throws SQLException {

        List<TreatmentsDTO>treatmentsDTOList=new ArrayList<>();
        List<TreatmentsEntity>treatmentsEntities=treatmentsDAO.getAll();

        for (TreatmentsEntity treatments:treatmentsEntities){
            treatmentsDTOList.add(new TreatmentsDTO(treatments.getId(),treatments.getType(),treatments.getDescription()));
        }

        return treatmentsDTOList;

    }



}
