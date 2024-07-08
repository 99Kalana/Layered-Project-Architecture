package lk.ijse.bo.custom.impl;

import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.custom.LoginBO;
import lk.ijse.dao.DAOFactory;
import lk.ijse.dao.custom.LoginDAO;

import java.io.IOException;
import java.sql.SQLException;

public class LoginBOImpl implements LoginBO {

    LoginDAO loginDAO = (LoginDAO) DAOFactory.getDaoFactory().getDao(DAOFactory.DAOTypes.LOGIN);
    @Override
    public void checkCredential(String userId, String password, AnchorPane rootNode) throws SQLException, IOException{
        loginDAO.checkCredential(userId,password,rootNode);
    }

}
