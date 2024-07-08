package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.ResetPasswordBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.ResetPasswordDAO;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResetPasswordBOImpl implements ResetPasswordBO {

    ResetPasswordDAO resetPasswordDAO = (ResetPasswordDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.RESET_PASSWORD);

    @Override
    public boolean isValidUser(String userId, String name) throws SQLException {

       return resetPasswordDAO.isValidUser(userId, name);

    }
    @Override
    public boolean resetPassword(String userId,String newPassword) throws SQLException {

        return resetPasswordDAO.resetPassword(userId, newPassword);

    }

}
