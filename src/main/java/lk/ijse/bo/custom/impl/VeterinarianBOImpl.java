package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.VeterinarianBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.VeterinarianDAO;
import lk.ijse.dto.VeterinarianDTO;
import lk.ijse.entity.BillDetailEntity;
import lk.ijse.entity.VeterinarianEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VeterinarianBOImpl implements VeterinarianBO {

    VeterinarianDAO veterinarianDAO = (VeterinarianDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.VETERINARIAN);

    @Override
    public VeterinarianDTO searchById(String id) throws SQLException {

        VeterinarianEntity veterinarian = veterinarianDAO.searchById(id);
        return new VeterinarianDTO(veterinarian.getId(), veterinarian.getName(), veterinarian.getContactNo(), veterinarian.getEmail());

    }

    @Override
    public  boolean save(VeterinarianDTO dto) throws SQLException {

        return veterinarianDAO.save(new VeterinarianEntity(dto.getId(), dto.getName(), dto.getContactNo(), dto.getEmail()));
    }

    @Override
    public  boolean update(VeterinarianDTO dto) throws SQLException {

        return veterinarianDAO.update(new VeterinarianEntity(dto.getId(), dto.getName(), dto.getContactNo(), dto.getEmail()));
    }

    @Override
    public  boolean delete(String id) throws SQLException {

        return veterinarianDAO.delete(id);
    }

    @Override
    public  List<VeterinarianDTO> getAll() throws SQLException {

        List<VeterinarianDTO>veterinarianDTOList=new ArrayList<>();
        List<VeterinarianEntity>veterinarianEntities=veterinarianDAO.getAll();

        for (VeterinarianEntity veterinarian:veterinarianEntities){
            veterinarianDTOList.add(new VeterinarianDTO(veterinarian.getId(), veterinarian.getName(), veterinarian.getContactNo(), veterinarian.getEmail()));
        }

        return veterinarianDTOList;

    }

    @Override
    public  List<String> getIds() throws SQLException {

        List<String>idList=new ArrayList<>();
        List<String>veterinarianIds=veterinarianDAO.getIds();

        for (String id:veterinarianIds){
            idList.add(id);
        }

        return idList;

    }



}
