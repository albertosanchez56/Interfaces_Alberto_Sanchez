package mostrarDatos;

import java.net.URL;
import java.util.ResourceBundle;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class DatosController {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private TableColumn<Persona, String> firstNameCol;

    @FXML
    private TableColumn<Persona, String> lastNameCol;

    @FXML
    private  TableView<Persona> listaNombresEmpleados;
    
    private ObservableList<Persona> data = FXCollections.observableArrayList(
    	    new Persona("Jacob", "Smith" ,0, "jacob.smith@example.com", ""),
    	    new Persona("Jacob", "Smith" ,0, "jacob.smith@example.com", ""),
    	    new Persona("Jacob", "Smith" ,0, "jacob.smith@example.com", ""),
    	    new Persona("Jacob", "Smith" ,0, "jacob.smith@example.com", ""),
    	    new Persona("Jacob", "Smith" ,0, "jacob.smith@example.com", "")
    	);
    
    @FXML
    void initialize() {
       
    	
    	
    	 firstNameCol.setCellValueFactory(new PropertyValueFactory<Persona,String>("firstName"));
         lastNameCol.setCellValueFactory(new PropertyValueFactory<Persona,String>("lastName"));
    	
    	
    	listaNombresEmpleados.setItems(data);
    }

	
}
