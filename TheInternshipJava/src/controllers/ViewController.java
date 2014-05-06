package controllers;

import java.util.*;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.*;
import javafx.scene.*;
import javafx.scene.layout.*;
import javafx.util.Duration;

/**
 * @author iDev
 */

public class ViewController extends StackPane
{
    // Lijst van alle views
    private HashMap<String, Node> views = new HashMap<>();
    
    // Contructor
    public ViewController()
    {
        super();
    }
    //test
    public void addView(String id, Node view)
    {
        views.put(id, view);
    }
    
    public Node getView(String id)
    {
        return views.get(id);
    }
    
    public void loadView(String  id, String file)
    {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(file));
            Parent loadView = (Parent) loader.load();
            ControlledView viewController = ((ControlledView) loader.getController());
            viewController.setViewParent(this);
            addView(id, loadView);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void setView (final String id)
    {
        if (views.get(id) != null)
        {
            final DoubleProperty opacity = opacityProperty();
            if (!getChildren().isEmpty())
            {
                Timeline fade = new Timeline(
                new KeyFrame( Duration.ZERO, new KeyValue(opacity, 1.0) ),
                new KeyFrame( new Duration(1000), new EventHandler<ActionEvent>(){
                    @Override
                    public void handle(ActionEvent t) 
                    {
                        getChildren().remove(0);
                        getChildren().add(0, views.get(id));
                        Timeline fadeIn = new Timeline(
                        new KeyFrame( Duration.ZERO, new KeyValue(opacity, 0.0) ),
                        new KeyFrame( new Duration(800), new KeyValue(opacity, 1.0) ));
                        fadeIn.play();
                    }
                }, new KeyValue(opacity, 0.0)));
                fade.play();
            }
            else
            {
                setOpacity(0.0);
                getChildren().add(views.get(id));
                Timeline fadeIn = new Timeline(
                new KeyFrame(Duration.ZERO, new KeyValue(opacity, 0.0)),
                new KeyFrame(new Duration(2500), new KeyValue(opacity, 1.0)));
                fadeIn.play();
            }
        }
        else
        {
            System.err.println("De view werd niet geladen.");
        }
    }
    
    public boolean unloadView(String id)
    {
        if (views.remove(id) == null)
        {
            System.err.println("De view bestaat niet.");
            return false;
        }
        else
        {
            return true;
        }
    }
}
