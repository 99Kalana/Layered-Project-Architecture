package lk.ijse.bo.custom.impl;

import lk.ijse.bo.custom.RegisterBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.RegisterDAO;

import java.sql.SQLException;

public class RegisterBOImpl implements RegisterBO {

    RegisterDAO registerDAO = (RegisterDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.REGISTER);

    @Override
    public boolean saveUser(String userId, String password, String name) throws SQLException{
        return registerDAO.saveUser(userId, password, name);
    }

}
