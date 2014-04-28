package controllers;

import app.TheInternship;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.*;

/**
 * FXML Controller class
 *
 * @author iDev
 */
public class LoginPanelController implements Initializable, ControlledView 
{
    ViewController controller;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        // TODO
    }    

    @Override
    public void setViewParent(ViewController viewcontroller) 
    {
        controller = viewcontroller;
    }
    
    @FXML
    private void onSubmit(ActionEvent event)
    {
        controller.setView(TheInternship.idOverzichtPanel);
    }
}
