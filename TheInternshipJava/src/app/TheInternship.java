package app;

import controllers.ViewController;
import domain.Specialisatie;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
/**
 * @author iDev
 */

public class TheInternship extends Application 
{
    public static String idLoginPanel = "login";
    public static String fileLoginPanel = "/resources/LoginPanel.fxml";
    public static String idOverzichtPanel = "overzicht";
    public static String fileOverzichtPanel = "/resources/OpdrachtenOverzichtPanel.fxml";
    
    @Override
    public void start(Stage stage) throws Exception 
    {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TheInternshipPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Specialisatie sp = new Specialisatie("test");
        em.persist(sp);
        //test
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        ViewController viewContainer = new ViewController();
        viewContainer.loadView(idLoginPanel, fileLoginPanel);
        viewContainer.loadView(idOverzichtPanel, fileOverzichtPanel);
        
        viewContainer.setView(idLoginPanel);
        
        Group root = new Group();
        root.getChildren().addAll(viewContainer);
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("The Internship Desktop Application");
        stage.show();
    }

    public static void main(String[] args) 
    {
        launch(args);
    }
}
