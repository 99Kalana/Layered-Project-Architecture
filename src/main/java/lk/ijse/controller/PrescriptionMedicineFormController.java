package lk.ijse.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import lk.ijse.bo.BOFactory;
import lk.ijse.bo.custom.PrescriptionMedicineBO;
import lk.ijse.db.DbConnectionPET;
import lk.ijse.dto.PrescriptionMedicineDTO;
import lk.ijse.model.tm.PrescriptionMedicineTm;
/*import lk.ijse.repository.MedicineRepo;
import lk.ijse.repository.PrescriptionMedicineRepo;*/
import lk.ijse.util.PrescriptionMedicineRegex;
import lk.ijse.util.PrescriptionMedicineTextField;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PrescriptionMedicineFormController {
    
    public AnchorPane root;

    public TextField txtId;
    public TextField txtPId;
    public TableView<PrescriptionMedicineTm> tblPrescriptionMedicine;

    public TableColumn<?,?> colId;
    public TableColumn<?,?> colPId;

    PrescriptionMedicineBO prescriptionMedicineBO = (PrescriptionMedicineBO) BOFactory.getBoFactory().getBo(BOFactory.BOTypes.PRESCRIPTION_MEDICINE);

    public void txtSearchOnAction(ActionEvent event) throws SQLException {

        String id = txtId.getText();

        //PrescriptionMedicine prescriptionMedicine = PrescriptionMedicineRepo.searchById(id);

        PrescriptionMedicineDTO prescriptionMedicine = prescriptionMedicineBO.searchById(id);

        if(prescriptionMedicine != null){
            txtId.setText(prescriptionMedicine.getId());
            txtPId.setText(prescriptionMedicine.getpId());

        }else{
            new Alert(Alert.AlertType.INFORMATION, "Prescription Medicine details not found!").show();
        }

    }

    public void btnSaveOnAction(ActionEvent event) {

        String id = txtId.getText();
        String pId = txtPId.getText();

        //PrescriptionMedicine prescriptionMedicine = new PrescriptionMedicine(id, pId);


        try{
            //boolean isSaved = PrescriptionMedicineRepo.save(prescriptionMedicine);
            boolean isSaved = prescriptionMedicineBO.save(new PrescriptionMedicineDTO(id,pId));
            if(isSaved){
                new Alert(Alert.AlertType.CONFIRMATION, "Prescription Medicine details saved!").show();
                clearFields();
            }
        }catch (SQLException e){
            throw new RuntimeException(e);
        }
        loadAllPrescriptionMedicine();

    }

    private void clearFields(){

        txtId.setText("");
        txtPId.setText("");


    }

    public void btnUpdateOnAction(ActionEvent event) {

        String id = txtId.getText();
        String pId = txtPId.getText();

        //PrescriptionMedicine prescriptionMedicine = new PrescriptionMedicine(id, pId);

        try{
            //boolean isUpdated = PrescriptionMedicineRepo.update(prescriptionMedicine);
            boolean isUpdated = prescriptionMedicineBO.update(new PrescriptionMedicineDTO(id,pId));
            if(isUpdated){
                new Alert(Alert.AlertType.CONFIRMATION, " Prescription Medicine details updated!").show();
            }
        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
        loadAllPrescriptionMedicine();

    }

    public void btnClearOnAction(ActionEvent event) {
        clearFields();
    }

    public void btnDeleteOnAction(ActionEvent event) {

        String id = txtId.getText();

        try{
            //boolean isDeleted = PrescriptionMedicineRepo.delete(id);
            boolean isDeleted = prescriptionMedicineBO.delete(id);
            if (isDeleted){
                new Alert(Alert.AlertType.CONFIRMATION, " Prescription Medicine details deleted!").show();
            }
        }catch (SQLException e){
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
        loadAllPrescriptionMedicine();

    }

    public void btnBackOnAction(ActionEvent event) throws IOException {

        AnchorPane dashboardPane = FXMLLoader.load(this.getClass().getResource("/view/dashboard_form.fxml"));

        root.getChildren().clear();
        root.getChildren().add(dashboardPane);

    }

    public void initialize() {
        setCellValueFactory();
        loadAllPrescriptionMedicine();
    }

    private void setCellValueFactory() {
        colId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colPId.setCellValueFactory(new PropertyValueFactory<>("pId"));

    }

    private void loadAllPrescriptionMedicine() {
        ObservableList<PrescriptionMedicineTm> obList = FXCollections.observableArrayList();

        try {
            //List<PrescriptionMedicine> prescriptionMedicineList = PrescriptionMedicineRepo.getAll();
            /*for (PrescriptionMedicine prescriptionMedicine : prescriptionMedicineList) {
                PrescriptionMedicineTm tm = new PrescriptionMedicineTm(
                        prescriptionMedicine.getId(),
                        prescriptionMedicine.getpId()
                );

                obList.add(tm);
            }*/

            List<PrescriptionMedicineDTO>prescriptionMedicineList=prescriptionMedicineBO.getAll();

            for (PrescriptionMedicineDTO prescriptionMedicine : prescriptionMedicineList) {
                PrescriptionMedicineTm tm = new PrescriptionMedicineTm(
                        prescriptionMedicine.getId(),
                        prescriptionMedicine.getpId()
                );

                obList.add(tm);
            }

            tblPrescriptionMedicine.setItems(obList);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void txtMedicineIDOnKeyReleased(KeyEvent keyEvent) {
        PrescriptionMedicineRegex.setTextColour(PrescriptionMedicineTextField.ID,txtId);
    }

    public void txtPrescriptionIDOnKeyReleased(KeyEvent keyEvent) {
        PrescriptionMedicineRegex.setTextColour(PrescriptionMedicineTextField.PID,txtPId);
    }

    public boolean isValid(){
        if (!PrescriptionMedicineRegex.setTextColour(PrescriptionMedicineTextField.ID,txtId));
        if (!PrescriptionMedicineRegex.setTextColour(PrescriptionMedicineTextField.PID,txtPId));

        return true;
    }

    public void btnPrintReportOnAction(ActionEvent event) throws JRException, SQLException {

        LocalDate currentDate = LocalDate.now();
        String dateString = currentDate.toString();


        JasperDesign jasperDesign = JRXmlLoader.load("src/main/resources/Reports/PrescriptionMedicineReport.jrxml");
        JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

        Map<String,Object> data = new HashMap<>();

        data.put("Date", dateString);


        JasperPrint jasperPrint =
                JasperFillManager.fillReport(jasperReport, data, DbConnectionPET.getInstance().getConnection());
        JasperViewer.viewReport(jasperPrint,false);

    }
}
