package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.AppointmentBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.AppointmentDAO;
import lk.ijse.dto.AppointmentDTO;
import lk.ijse.entity.AppointmentEntity;
import lk.ijse.entity.BillDetailEntity;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AppointmentBOImpl implements AppointmentBO {

    AppointmentDAO appointmentDAO = (AppointmentDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.APPOINTMENT);

    @Override
    public AppointmentDTO searchById(String id) throws SQLException {

        AppointmentEntity appointment = appointmentDAO.searchById(id);
        return new AppointmentDTO(appointment.getId(), appointment.getClientId(), appointment.getNo(), appointment.getDate(), appointment.getTime());

    }

    @Override
    public boolean save(AppointmentDTO dto) throws SQLException {

        return appointmentDAO.save(new AppointmentEntity(dto.getId(), dto.getClientId(), dto.getNo(), dto.getDate(), dto.getTime()));

    }
    @Override
    public boolean update(AppointmentDTO dto) throws SQLException {

        return appointmentDAO.update(new AppointmentEntity(dto.getId(), dto.getClientId(), dto.getNo(), dto.getDate(), dto.getTime()));

    }
    @Override
    public boolean delete(String id) throws SQLException {

        return appointmentDAO.delete(id);

    }
    @Override
    public List<AppointmentDTO> getAll() throws SQLException {


        List<AppointmentDTO>appointmentDTOList=new ArrayList<>();
        List<AppointmentEntity>appointmentEntities=appointmentDAO.getAll();
        for(AppointmentEntity appointment:appointmentEntities){
            appointmentDTOList.add(new AppointmentDTO(appointment.getId(), appointment.getClientId(), appointment.getNo(), appointment.getDate(), appointment.getTime()));
        }
        
        return appointmentDTOList;

    }




}
