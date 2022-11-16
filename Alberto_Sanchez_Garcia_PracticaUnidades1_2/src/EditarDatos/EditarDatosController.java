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
    private ListView<String> list2;
    
    @FXML
    private ChoiceBox<String> procedenciaCombo;
    @FXML
    private ChoiceBox<String> procedenciaCombo2;
    @FXML
    private ComboBox<Object> tipoCombo;
    @FXML
    private ComboBox<Object> tipoCombo2;

    @FXML
    private ComboBox<Object> puestoCombo;
    @FXML
    private ComboBox<Object> puestoCombo2;
    @FXML
    private TableView<Productos> listaNombresProducto;
    @FXML
    private  TableView<Persona> listaNombresEmpleados;
    
    @FXML
    private TableColumn<Persona, String> firstNameCol;

    @FXML
    private TableColumn<Persona, String> lastNameCol;
    
    @FXML
    private TableColumn<Persona, Integer> telefonoCol;
    
    @FXML
    private TableColumn<Productos, String> nombreProduc;
    
    @FXML
    private TableColumn<Persona, String> direccionCol;

    @FXML
    private TableColumn<Persona, String> emailCol;
    
    @FXML
    private TableColumn<Productos, String> codigoCol;

    @FXML
    private TableColumn<Productos, Double> precioCol;

    @FXML
    private TableColumn<Productos, String> procedenciaCol;
    @FXML
    private TableColumn<Productos, String> tipoCol;
    
    
   
    
    private ObservableList<Persona> dataEmpleados = FXCollections.observableArrayList(
    	    new Persona("Alberto", "Sanchez" ,620141444, "C/asdasdasdasdas", "Alberto.smith@example.com"),
    	    new Persona("Lucia", "Garcia" ,51566115, "C/asdasdasdasdas", "Lucia.smith@example.com"),
    	    new Persona("Antonio", "Blas" ,51566115, "C/asdasdasdasdas", "Antonio.smith@example.com"),
    	    new Persona("Javier", "Escalera" ,51566115, "C/asdasdasdasdas", "Javier.smith@example.com"),
    	    new Persona("Miguel", "Smith" ,51566115, "C/asdasdasdasdas", "Miguel.smith@example.com")
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
    	tipoCol.setCellValueFactory(new PropertyValueFactory<Productos,String>("tipo"));
    	precioCol.setCellValueFactory(new PropertyValueFactory<Productos,Double>("precio"));
    	procedenciaCol.setCellValueFactory(new PropertyValueFactory<Productos,String>("procedencia"));
    	codigoCol.setCellValueFactory(new PropertyValueFactory<Productos,String>("codigo"));
    	
    	firstNameCol.setCellValueFactory(new PropertyValueFactory<Persona,String>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Persona,String>("lastName"));
        telefonoCol.setCellValueFactory(new PropertyValueFactory<Persona,Integer>("telefono"));
        direccionCol.setCellValueFactory(new PropertyValueFactory<Persona,String>("direccion"));
        emailCol.setCellValueFactory(new PropertyValueFactory<Persona,String>("email"));
    	
    	listaNombresProducto.setItems(dataPro);
    	listaNombresEmpleados.setItems(dataEmpleados);

    	tipoCombo.setItems(FXCollections.observableArrayList("Consola","Periferico","Videojuego"));
    	tipoCombo.setValue("Seleciona un tipo");
    	
    	tipoCombo2.setItems(FXCollections.observableArrayList("Consola","Periferico","Videojuego"));
    	tipoCombo2.setValue("Seleciona un tipo");
    	
    	
    	procedenciaCombo.setItems(FXCollections.observableArrayList("España","China","Portugal","India","Francia","Inglaterra"));
    	procedenciaCombo.setValue("Seleciona un pais");
    	
    	procedenciaCombo2.setItems(FXCollections.observableArrayList("España","China","Portugal","India","Francia","Inglaterra"));
    	procedenciaCombo2.setValue("Seleciona un pais");
    	
    	puestoCombo.setItems(FXCollections.observableArrayList("Encargado","Manager","Contable"));
    	puestoCombo2.setItems(FXCollections.observableArrayList("Encargado","Manager","Contable"));
    	
		list1.setItems(data);
		list1.setEditable(true);
		list1.setCellFactory(ComboBoxListCell.forListView(names));
		list2.setItems(data);
		list2.setEditable(true);
		list2.setCellFactory(ComboBoxListCell.forListView(names));
		
		names.addAll(
	             "trabajador", "productivo", "actitud positiva", "empatico",
	             "polivalente", "autodidacta", "puntual", "creativo"
	             
	        );
		
		for (int i = 0; i < 10; i++) {
            data.add("Indefinido (elige una opcion)");
        }
    }
}
