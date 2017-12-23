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
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author HP
 */
public class FirstpageController implements Initializable {
 //creating an instance for Db connecion
    Connection conn=Connector.LoginConnector();
    
    //A statement to transport query
    PreparedStatement preparedStatement=null;
    
    //set to manipulate/bring back the result
    ResultSet rs=null;
    
    
    
    private Main application;
    @FXML
    private JFXButton signb;
    @FXML
    private Label label;
      public void setApp(Main application){
        this.application = application;}
    @FXML
    private AnchorPane root;
    @FXML
    private ImageView img;
    @FXML
    private AnchorPane bg;
    @FXML
    private ImageView image;
    @FXML
    private JFXButton loginb;
    @FXML
    private PasswordField password;
    @FXML
    private TextField userid;

    /**
     * Initializes the controller class.
     */
    @Override
     
    public void initialize(URL url, ResourceBundle rb) {
       
        
        animation();
    }    

    @FXML
    private void check(ActionEvent event) {
        checkuser();
        
    }
    
    public void checkuser()
    	{
            
		String query="SELECT * FROM pone.users where `username` = '"+userid.getText()+"'  ;";
		try
		{
			preparedStatement=conn.prepareStatement(query);
			rs=preparedStatement.executeQuery();
			
			while(rs.next())
			{
                                        if(password.getText().equals( rs.getString("password") ))
                                        {   application.gotoProfilePage();
                                        }
                                           
                                  
                                
                                }
			preparedStatement.close();
			rs.close();
                        
		}
		catch(Exception e)
		{
			System.err.println(e);
		}
                
        }
     private void animation() {
        
        
        TranslateTransition tr= new TranslateTransition(Duration.millis(1000), userid);
        tr.setFromX(100);
        tr.setToX(0);        
        tr.play();
        
        
        TranslateTransition tr1= new TranslateTransition(Duration.millis(1000), password);
        tr1.setFromX(100);
        tr1.setToX(0);        
        tr1.play();
        
        
        TranslateTransition tr2= new TranslateTransition(Duration.millis(1000), loginb);
        tr2.setFromY(100);
        tr2.setToY(0);        
        tr2.play();
        
        TranslateTransition tr3= new TranslateTransition(Duration.millis(1000), signb);
        tr3.setFromY(100);
        tr3.setToY(0);        
        tr3.play();
        
        TranslateTransition tr5= new TranslateTransition(Duration.millis(1000), label);
        tr5.setFromY(100);
        tr5.setToY(0);        
        tr5.play();
        
        TranslateTransition tr4= new TranslateTransition(Duration.millis(1000), bg);
        tr4.setFromX(200);
        tr4.setToX(0);        
        tr4.play();
        
        
        FadeTransition fd2= new FadeTransition(Duration.millis(1500), loginb);
        fd2.setFromValue(0);
        fd2.setToValue(1);
        fd2.play();
        
        FadeTransition fd3= new FadeTransition(Duration.millis(1500), signb);
        fd3.setFromValue(0);
        fd3.setToValue(1);
        fd3.play();
        
        
        ScaleTransition sl= new ScaleTransition(Duration.millis(1000), image);
        sl.setToY(1);
        sl.setFromY(0);
        sl.setToX(1);
        sl.setFromX(0);
        sl.play();
    }

    @FXML
    private void signup(ActionEvent event) {
        application.gotoSignupPage();
    }
    
}
