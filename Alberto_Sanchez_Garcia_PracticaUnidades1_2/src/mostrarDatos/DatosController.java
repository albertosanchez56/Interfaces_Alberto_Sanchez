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
    private  TableView<Persona> listaNombresEmpleados;
    
    @FXML
    private TableColumn<Persona, String> firstNameCol;

    @FXML
    private TableColumn<Persona, String> lastNameCol;
    
    @FXML
    private TableView<Productos> listaNombresProducto;

    @FXML
    private TableColumn<Productos, String> nombreProduc;

   
    private ObservableList<Persona> dataEmpleados  = FXCollections.observableArrayList(
    	    new Persona("Alberto", "Sanchez" ,0, "Alberto.smith@example.com", ""),
    	    new Persona("Lucia", "Garcia" ,0, "Lucia.smith@example.com", ""),
    	    new Persona("Antonio", "Blas" ,0, "Antonio.smith@example.com", ""),
    	    new Persona("Javier", "Escalera" ,0, "Javier.smith@example.com", ""),
    	    new Persona("Miguel", "Smith" ,0, "Miguel.smith@example.com", "")
    	);
    

    private ObservableList<Productos> dataPro = FXCollections.observableArrayList(
    	    new Productos("Play Station 4", "Consola" ,400.0, "China", "00034"),
    	    new Productos("Elden Ring", "Videojuego" ,60.0, "China", "00032"),
    	    new Productos("Logitec 933", "Periferico" ,80.0, "Portugal", "00045"),
    	    new Productos("Skyrim", "Videojuego" ,40.0, "España", "00061"),
    	    new Productos("Xbox 360", "Consola" ,300.0, "España", "00099"));
    @FXML
    void initialize() {
       
    	
    		 firstNameCol.setCellValueFactory(new PropertyValueFactory<Persona,String>("firstName"));
             lastNameCol.setCellValueFactory(new PropertyValueFactory<Persona,String>("lastName"));
             
             nombreProduc.setCellValueFactory(new PropertyValueFactory<Productos,String>("firstName"));
        	
        	
        	listaNombresEmpleados.setItems(dataEmpleados);
        	listaNombresProducto.setItems(dataPro);
    	
    	
    	
    }

	
}
