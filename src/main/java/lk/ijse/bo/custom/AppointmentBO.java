package lk.ijse.bo.custom;

import lk.ijse.bo.SuperBO;
import lk.ijse.dao.CrudDAO;
import lk.ijse.dto.AppointmentDTO;
import lk.ijse.entity.AppointmentEntity;

import java.sql.SQLException;
import java.util.List;

public interface AppointmentBO extends SuperBO {

    public AppointmentDTO searchById(String id) throws SQLException;

    public  boolean save(AppointmentDTO dto) throws SQLException;

    public  boolean update(AppointmentDTO dto) throws SQLException;

    public  boolean delete(String id) throws SQLException;

    public  List<AppointmentDTO> getAll() throws SQLException;

}
