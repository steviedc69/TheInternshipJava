package app;

import controllers.OpdrachtenOverzichtPanelController;

import domain.*;
import java.io.IOException;
import java.util.List;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
/**
 * @author iDev
 */

public class TheInternship extends Application 
{
    @Override
    public void start(Stage stage) throws Exception 
    {
        BorderPane root = initialize();        
        Scene scene = new Scene(root);
        
        stage.setScene(scene);
        stage.setTitle("The Internship Desktop Application");
        stage.show();
    }
    
    public List<Opdracht> getOpdrachten(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TheInternshipPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();

        TypedQuery<Opdracht> queryFindAll = em.createNamedQuery("Opdracht.findAll", Opdracht.class);
        List<Opdracht> list = queryFindAll.getResultList();
        em.getTransaction().commit();
        em.close();
        emf.close();
        
        return list;
    }
    
    public BorderPane initialize() throws IOException{
        
        List<Opdracht> list = getOpdrachten();
        
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/resources/OpdrachtenOverzichtPanel.fxml"));
        loader.load();
        
        OpdrachtenOverzichtPanelController controller = loader.getController();
        controller.vulLijst(list);
        
        BorderPane root = loader.getRoot();
        
        return root;
    }

    public static void main(String[] args) 
    {
        launch(args);
    }
}
