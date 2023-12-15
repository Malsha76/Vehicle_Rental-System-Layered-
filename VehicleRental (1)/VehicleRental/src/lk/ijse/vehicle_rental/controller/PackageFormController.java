package lk.ijse.vehicle_rental.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.vehicle_rental.bo.BOFactory;
import lk.ijse.vehicle_rental.bo.custom.PackageBO;
import lk.ijse.vehicle_rental.dto.PackagesDTO;
import lk.ijse.vehicle_rental.util.Navigation;
import lk.ijse.vehicle_rental.util.Routes;

import java.io.IOException;
import java.sql.SQLException;

public class PackageFormController {



    public TextField txtPacId;
    public TextField txtPacName;
    public TextField txtPrice;
    public AnchorPane pane;
    PackageBO packageBO  = (PackageBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.PACAKAGE);

    @FXML
    void btnAddOnAction(ActionEvent event) throws SQLException, ClassNotFoundException {
        String package_id = txtPacId.getText();
        String package_name= txtPacName.getText();
        String price = txtPrice.getText();

       PackagesDTO packagesDTO= new PackagesDTO (package_id,package_name,price);

        boolean isAdded =  packageBO.add(packagesDTO);
        if(isAdded){
            new Alert(Alert.AlertType.INFORMATION,"Package Added Successful").show();
        }else {
            new Alert(Alert.AlertType.INFORMATION,"Somthing was wrong").show();

        }
    }



    @FXML
    void btnBackOnAction(ActionEvent event) throws IOException {
        Navigation.navigate(Routes.DASHBOARD, pane);
    }

    @FXML
    void btnDeleteOnAction(ActionEvent event) {
        try {
            boolean isDelete =packageBO.delete(txtPacId.getText());
            if(isDelete){
                new Alert(Alert.AlertType.INFORMATION,"Package Delete Successful").show();
            }else {
                new Alert(Alert.AlertType.INFORMATION,"Somthig Was Wrong").show();
            }
        }catch (Exception ex){

        }

    }

    @FXML
    void btnUpdateOnAction(ActionEvent event) {
        String id = txtPacId.getText();
        String name = txtPacName.getText();
        String price = txtPrice.getText();


        PackagesDTO packagesDTO = new PackagesDTO (id,name,price);

        try {
            boolean isUpdate =packageBO.update(packagesDTO);
            if(isUpdate){
                new Alert(Alert.AlertType.INFORMATION,"pa cupdate Successful").show();
            }else {
                new Alert(Alert.AlertType.INFORMATION,"Somthig Was Wrong").show();
            }
        }catch (Exception ex){

        }

    }

}