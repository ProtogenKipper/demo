package com.example;
import java.sql.* ;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;



public class FXMLController implements Initializable {

    
    
    @FXML
    private Label lblOut;
    
  
    
    @FXML
    private void btnClickAction(ActionEvent event) {
        try {
            Connection connection =  DriverManager.getConnection("jdbc:mysql://localhost:3306/new_database", "test", "password");
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from products");

            while (resultSet.next()){
                lblOut.setText(resultSet.getString("product_name"));
                //skuCol.setCellFactory(null);
                
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}
