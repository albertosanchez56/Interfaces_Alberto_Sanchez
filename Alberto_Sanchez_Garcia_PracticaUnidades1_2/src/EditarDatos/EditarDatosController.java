package EditarDatos;

import java.net.URL;
import java.util.ResourceBundle;

import Clases.Persona;
import Clases.Productos;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.control.cell.PropertyValueFactory;

public class EditarDatosController {

	public static final ObservableList<String> names = 
	        FXCollections.observableArrayList();
	public static final ObservableList<String> data = 
	        FXCollections.observableArrayList();
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ListView<String> list1;
    
    @FXML
    private ChoiceBox<String> procedenciaCombo;
    @FXML
    private ComboBox<Object> tipoCombo;
    
    @FXML
    private TableView<Productos> listaNombresProducto;
    @FXML
    private  TableView<Persona> listaNombresEmpleados;
    
    @FXML
    private TableColumn<Persona, String> firstNameCol;

    @FXML
    private TableColumn<Persona, String> lastNameCol;
    
    @FXML
    private TableColumn<Productos, String> nombreProduc;
    
    private ObservableList<Persona> dataEmpleados = FXCollections.observableArrayList(
    	    new Persona("Alberto", "Sanchez" ,620141444, "", "Alberto.smith@example.com"),
    	    new Persona("Lucia", "Garcia" ,51566115, "", "Lucia.smith@example.com"),
    	    new Persona("Antonio", "Blas" ,51566115, "", "Antonio.smith@example.com"),
    	    new Persona("Javier", "Escalera" ,51566115, "", "Javier.smith@example.com"),
    	    new Persona("Miguel", "Smith" ,51566115, "", "Miguel.smith@example.com")
    	);
    

    private ObservableList<Productos> dataPro = FXCollections.observableArrayList(
    	    new Productos("Play Station 4", "Consola" ,400.0, "China", "00034"),
    	    new Productos("Elden Ring", "Videojuego" ,60.0, "China", "00032"),
    	    new Productos("Logitec 933", "Periferico" ,80.0, "Portugal", "00045"),
    	    new Productos("Skyrim", "Videojuego" ,40.0, "España", "00061"),
    	    new Productos("Xbox 360", "Consola" ,300.0, "España", "00099")
    	   
    	);
    
    @FXML
    void initialize() {
    	
    	nombreProduc.setCellValueFactory(new PropertyValueFactory<Productos,String>("firstName"));
    	
    	firstNameCol.setCellValueFactory(new PropertyValueFactory<Persona,String>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Persona,String>("lastName"));
    	
    	listaNombresProducto.setItems(dataPro);
    	listaNombresEmpleados.setItems(dataEmpleados);

    	tipoCombo.setItems(FXCollections.observableArrayList("Consola","Periferico","Videojuego"));
    	tipoCombo.setValue("Seleciona un tipo");
    	
    	procedenciaCombo.setItems(FXCollections.observableArrayList("España","China","Portugal"));
    	procedenciaCombo.setValue("Seleciona un pais");
    	
		list1.setItems(data);
		list1.setEditable(true);
		list1.setCellFactory(ComboBoxListCell.forListView(names));
		
		names.addAll(
	             "Object", "Classes", "Functions", "Variables",
	             "Compiler", "Debugger", "Projects", "Beans", 
	             "Libraries", "Modules"
	        );
		
		for (int i = 0; i < 10; i++) {
            data.add("Indefinido (elige una opcion)");
        }
    }
}
