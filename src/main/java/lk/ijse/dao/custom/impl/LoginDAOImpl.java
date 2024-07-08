package lk.ijse.dao.custom.impl;


import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.controller.HomePageFormController;
import lk.ijse.controller.LoginFormController;
import lk.ijse.dao.SQLUtil;
import lk.ijse.dao.custom.LoginDAO;
import lk.ijse.db.DbConnectionPET;
import lk.ijse.entity.LoginEntity;


import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class LoginDAOImpl implements LoginDAO {



    @Override
    public void checkCredential(String userId, String password,AnchorPane rootNode) throws SQLException, IOException {

        /*String sql = "SELECT user_id, password FROM user WHERE user_id = ?";

        Connection connection = DbConnectionPET.getInstance().getConnection();
        PreparedStatement pstm = connection.prepareStatement(sql);

        pstm.setObject(1,userId);

        ResultSet resultSet = pstm.executeQuery();*/

        ResultSet resultSet = SQLUtil.execute("SELECT user_id, password FROM user WHERE user_id = ?",userId);

        if (resultSet.next()){
            String dbPassword = resultSet.getString("password");

            if (password.equals(dbPassword)){

                navigateToTheDashboard(userId,rootNode);

            }else{
                new Alert(Alert.AlertType.ERROR,"Sorry! Entered password is incorrect!").show();
            }
        }else{
            new Alert(Alert.AlertType.INFORMATION, "Sorry! Entered user ID can't be find!").show();
        }

    }

    private void navigateToTheDashboard(String userId,AnchorPane rootNode) throws IOException, SQLException {

        //AnchorPane rootNode = FXMLLoader.load(this.getClass().getResource("/view/home_page_form.fxml"));

        FXMLLoader loader = new FXMLLoader(this.getClass().getResource("/view/home_page_form.fxml"));
        AnchorPane newRootNode = loader.load();
        HomePageFormController controller = loader.getController();
        controller.setUserId(userId);

        /*Scene scene = new Scene(rootNode);

        Stage stage = (Stage) this.rootNode.getScene().getWindow();*/

        Scene scene = new Scene(newRootNode);

        // Get the current stage (window)
        Stage stage = (Stage) rootNode.getScene().getWindow();

        stage.setScene(scene);

        stage.centerOnScreen();

        stage.setTitle("Homepage Form");

    }


    @Override
    public LoginEntity searchById(String id) throws SQLException {
        return null;
    }

    @Override
    public boolean save(LoginEntity entity) throws SQLException {
        return false;
    }

    @Override
    public boolean update(LoginEntity entity) throws SQLException {
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException {
        return false;
    }

    @Override
    public List<LoginEntity> getAll() throws SQLException {
        return null;
    }

    @Override
    public List<String> getIds() throws SQLException {
        return null;
    }

    @Override
    public String getCurrentBillId() throws SQLException {
        return null;
    }
}
