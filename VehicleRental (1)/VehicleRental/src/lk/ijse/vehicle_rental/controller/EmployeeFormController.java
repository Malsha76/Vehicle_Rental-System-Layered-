package lk.ijse.vehicle_rental.controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import lk.ijse.vehicle_rental.bo.BOFactory;
import lk.ijse.vehicle_rental.bo.custom.EmployeeBO;
import lk.ijse.vehicle_rental.dto.EmployeeDTO;
import lk.ijse.vehicle_rental.entity.Employee;
import lk.ijse.vehicle_rental.util.Navigation;
import lk.ijse.vehicle_rental.util.Routes;

import java.io.IOException;
import java.sql.SQLException;

public class EmployeeFormController {
    public AnchorPane pane;
    public AnchorPane panec;
    public TextField txtEmpid;
    public TextField txtRole;
    public TextField txtAddre;
    public TextField txtContact;
    public TextField txtSalary;
    public TextField txtName;
    public TextField txtId;
    public TextField txtSearch;
    EmployeeBO employeeBO  = (EmployeeBO) BOFactory.getBoFactory().getBO(BOFactory.BOTypes.EMPLOYEE);


    public void btnAddOnAction(ActionEvent actionEvent) throws SQLException, ClassNotFoundException {
        String id = txtEmpid.getText();
        String name = txtName.getText();
        String role = txtRole.getText();
        String contact = txtContact.getText();
        String address = txtAddre.getText();
        String salary = txtSalary.getText();

        EmployeeDTO employeeDTO = new EmployeeDTO (id, name, role, contact, address, salary);
        boolean isAdded = employeeBO.addEmployee(employeeDTO);
        if (isAdded) {
            new Alert(Alert.AlertType.INFORMATION, "Employee Added Successful").show();
        } else {
            new Alert(Alert.AlertType.INFORMATION, "Employee not Added ").show();

        }



   /* public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.DASHBOARD, pane);*/
    }

    public void btnSearchOnAction(ActionEvent actionEvent) {
        try {
           Employee employee = employeeBO.searchEmployee(txtEmpid.getText());
            if(employee!=null){
                txtName.setText(employee.getName());
                txtRole.setText(employee.getAddress());
                txtContact.setText(employee.getContact());
                txtAddre.setText(employee.getAddress());
                txtSalary.setText(employee.getSalary());
            }
        }catch (Exception ex){
            System.out.println(ex);
        }

    }


    public void btnUpdateOnAction(ActionEvent actionEvent) {
        String id = txtEmpid.getText();
        String name = txtName.getText();
        String role = txtRole.getText();
        String contact = txtContact.getText();
        String address = txtAddre.getText();
        String salary = txtSalary.getText();

       EmployeeDTO employeeDTO = new EmployeeDTO (id,name,role,contact,address,salary);

        try {
            boolean isUpdate = employeeBO.updateEmployee(employeeDTO);
            if(isUpdate){
                new Alert(Alert.AlertType.INFORMATION,"Employee update Successful").show();
            }else {
                new Alert(Alert.AlertType.INFORMATION,"Somthig Was Wrong").show();
            }
        }catch (Exception ex){

        }

    }

    public void btnDeleteOnAction(ActionEvent actionEvent) {
        String id = txtEmpid.getText();
        System.out.println(id);
        try {
            boolean isDelete = employeeBO.deleteEmployee (id);

            if (isDelete) {
                new Alert(Alert.AlertType.INFORMATION, "Employee Delete Successful").show();
            } else {
                new Alert(Alert.AlertType.INFORMATION, "Something Was Wrong").show();
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
    }


    public void btnBackOnAction(ActionEvent actionEvent) throws IOException {
        Navigation.navigate(Routes.DASHBOARD, pane);
    }
}
