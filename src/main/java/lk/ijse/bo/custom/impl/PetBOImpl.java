package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.PetBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.PetDAO;
import lk.ijse.dto.PetDTO;
import lk.ijse.entity.BillDetailEntity;
import lk.ijse.entity.PetEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PetBOImpl implements PetBO {

    PetDAO petDAO = (PetDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.PET);

    @Override
    public  boolean save(PetDTO dto) throws SQLException {

        return petDAO.save(new PetEntity(dto.getId(), dto.getName(), dto.getBreed(), dto.getWeight(), dto.getColour()));

    }

    @Override
    public  boolean update(PetDTO dto) throws SQLException {

        return petDAO.update(new PetEntity(dto.getId(), dto.getName(), dto.getBreed(), dto.getWeight(), dto.getColour()));

    }

    @Override
    public  boolean delete(String id) throws SQLException {

        return petDAO.delete(id);

    }


    @Override
    public  PetDTO searchById(String id) throws SQLException {

        PetEntity pet = petDAO.searchById(id);
        return new PetDTO(pet.getId(), pet.getName(), pet.getBreed(), pet.getWeight(), pet.getColour());

    }

    @Override
    public  List<PetDTO> getAll() throws SQLException {

        List<PetDTO>petDTOList=new ArrayList<>();
        List<PetEntity>petEntities=petDAO.getAll();

        for(PetEntity pet:petEntities){
            petDTOList.add(new PetDTO(pet.getId(), pet.getName(), pet.getBreed(), pet.getWeight(), pet.getColour()));
        }

        return petDTOList;

    }

    @Override
    public  List<String> getIds() throws SQLException {


        List<String> idList = new ArrayList<>();
        List<String> petIds = petDAO.getIds();

        for (String id : petIds) {
            idList.add(id);
        }

        return idList;


    }


}
