package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dao.CrudDAO;
import lk.ijse.dto.TreatmentsDTO;
import lk.ijse.entity.TreatmentsEntity;

import java.sql.SQLException;
import java.util.List;

public interface TreatmentsBO extends SuperBO {

    public TreatmentsDTO searchById(String id) throws SQLException;

    public  boolean save(TreatmentsDTO dto) throws SQLException;

    public  boolean update(TreatmentsDTO dto) throws SQLException ;

    public  boolean delete(String id) throws SQLException;

    public List<TreatmentsDTO> getAll() throws SQLException;

}
