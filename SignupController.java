/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newproj;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import javafx.animation.FadeTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class SignupController implements Initializable {
 private Main application;
    @FXML
    private JFXButton signup;
    @FXML
    private TextField email;
    @FXML
    private TextField username;
    @FXML
    private TextField password;
    @FXML
    private TextField contact;
    @FXML
    private JFXButton goback;
    @FXML
    private AnchorPane yellow;
      public void setApp(Main application){
        this.application = application;
      }
      //creating an instance for Db connecion
    Connection conn=Connector.LoginConnector();
    
    //A statement to transport query
    PreparedStatement preparedStatement=null;
    
    //set to manipulate/bring back the result
    ResultSet rs=null;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        animation();
    }    

    @FXML
    private void signedin(ActionEvent event) {
        insertuser();
    }

    @FXML
    private void backtologin(ActionEvent event) {
        application.gotoLoginPage();
    }
    
     private void animation() {
        
        
        TranslateTransition tr= new TranslateTransition(Duration.millis(1000), email);
        tr.setFromX(100);
        tr.setToX(0);        
        tr.play();
        
        
        TranslateTransition tr1= new TranslateTransition(Duration.millis(1000), username);
        tr1.setFromX(100);
        tr1.setToX(0);        
        tr1.play();
        
        
        TranslateTransition tr2= new TranslateTransition(Duration.millis(1000), password);
        tr2.setFromX(100);
        tr2.setToX(0);        
        tr2.play();
        
        
        TranslateTransition tr4= new TranslateTransition(Duration.millis(1000), contact);
        tr4.setFromX(100);
        tr4.setToX(0);        
        tr4.play();
        
        TranslateTransition tr5= new TranslateTransition(Duration.millis(1000), signup);
        tr5.setFromY(-100);
        tr5.setToY(0);        
        tr5.play();
        
        TranslateTransition tr6= new TranslateTransition(Duration.millis(1000), goback);
        tr6.setFromY(-100);
        tr6.setToY(0);        
        tr6.play();
        
        FadeTransition fd2= new FadeTransition(Duration.millis(1500), signup);
        fd2.setFromValue(0);
        fd2.setToValue(1);
        fd2.play();
        
        FadeTransition fd3= new FadeTransition(Duration.millis(1500), goback);
        fd3.setFromValue(0);
        fd3.setToValue(1);
        fd3.play();
        
        
        FadeTransition fd4= new FadeTransition(Duration.millis(1000), yellow);
        fd4.setFromValue(0);
        fd4.setToValue(0.4);
        fd4.play();
    }

    private void insertuser() 
    
    {
            
		String query="INSERT INTO `pone`.`users` (`username`, `email`, `password`, `contact`) VALUES (?,?,?,?)";

		try
		{
			preparedStatement=conn.prepareStatement(query);
                        preparedStatement.setString(1, username.getText()); // set input parameter 1
                        preparedStatement.setString(2, email.getText()); // set input parameter 2
                        preparedStatement.setString(3,password.getText());
                        preparedStatement.setString(4, contact.getText());// set input parameter 3
                        

                        int i=preparedStatement.executeUpdate();
                        if(i!=0)
                        {
                            application.gotoProfilePage();
                        } 
                        else
                        {
                            System.out.println("failed to insert the data");
                        } 
                } 
                catch (Exception e)
                { 
                    System.out.println(e); 
                }
                
        }
    }
    
    


