package EditarDatos;

import java.net.URL;
import java.util.ResourceBundle;

import Clases.Persona;
import Clases.Productos;
import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;

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
    
    @FXML
    private TreeView<String> tree1;

    @FXML
    private TreeView<String> tree2;
    
 
    
    @FXML
    private TextField direccionField;
    
    @FXML
    private TextField emailField;
    
    @FXML
    private TextField firstNameField;
    
    @FXML
    private TextField lastNameField;
    
    @FXML
    private TextField telefonoField;
    
    @FXML
    private TextField nombreProField;
    @FXML
    private TextField tipoField;
    
    @FXML
    private TextField precioField;
    
    @FXML
    private TextField procedenciaField;
    
    @FXML
    private TextField codigoField;
    
   
    
   /* private ObservableList<Persona> dataEmpleados = FXCollections.observableArrayList(
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
    	   
    	);*/
    private Main mainApp;
    @FXML
    void initialize() {
    	
    	/*nombreProduc.setCellValueFactory(new PropertyValueFactory<Productos,String>("firstName"));
    	tipoCol.setCellValueFactory(new PropertyValueFactory<Productos,String>("tipo"));
    	precioCol.setCellValueFactory(new PropertyValueFactory<Productos,Double>("precio"));
    	procedenciaCol.setCellValueFactory(new PropertyValueFactory<Productos,String>("procedencia"));
    	codigoCol.setCellValueFactory(new PropertyValueFactory<Productos,String>("codigo"));
    	
    	firstNameCol.setCellValueFactory(new PropertyValueFactory<Persona,String>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<Persona,String>("lastName"));
        telefonoCol.setCellValueFactory(new PropertyValueFactory<Persona,Integer>("telefono"));
        direccionCol.setCellValueFactory(new PropertyValueFactory<Persona,String>("direccion"));
        emailCol.setCellValueFactory(new PropertyValueFactory<Persona,String>("email"));*/
    	firstNameCol.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
    	lastNameCol.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());
    	//telefonoCol.setCellValueFactory(cellData -> cellData.getValue().telefonoProperty());
    	telefonoCol.setCellValueFactory(new PropertyValueFactory<Persona,Integer>("telefono"));
    	direccionCol.setCellValueFactory(cellData -> cellData.getValue().direccionProperty());
    	emailCol.setCellValueFactory(cellData -> cellData.getValue().emailProperty());
    	
    	nombreProduc.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
    	tipoCol.setCellValueFactory(cellData -> cellData.getValue().tipoProperty());
    	precioCol.setCellValueFactory(new PropertyValueFactory<Productos,Double>("precio"));
    	procedenciaCol.setCellValueFactory(cellData -> cellData.getValue().procedenciaProperty());
    	codigoCol.setCellValueFactory(cellData -> cellData.getValue().codigoProperty());
    	
    	listaNombresEmpleados.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));
    	listaNombresProducto.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showProductosDetails(newValue));
    	
    	
    	//listaNombresProducto.setItems(dataPro);
    	//listaNombresEmpleados.setItems(dataEmpleados);

    	//tipoCombo.setItems(FXCollections.observableArrayList("Consola","Periferico","Videojuego"));
    	//tipoCombo.setValue("Seleciona un tipo");
    	
    	tipoCombo2.setItems(FXCollections.observableArrayList("Consola","Periferico","Videojuego"));
    	tipoCombo2.setValue("Seleciona un tipo");
    	
    	
    	//procedenciaCombo.setItems(FXCollections.observableArrayList("España","China","Portugal","India","Francia","Inglaterra"));
    	//procedenciaCombo.setValue("Seleciona un pais");
    	
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
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;

        listaNombresEmpleados.setItems(this.mainApp.getPersonData());
        listaNombresProducto.setItems(this.mainApp.getProductosData());
               
        // TODO Versión con map
        //personTable.setItems(this.mainApp.getMapData()); 
    }
    private void showPersonDetails(Persona person) {
        if (person != null) {
        	// Si el campo contiene datos, entonces se rellena la información
        	firstNameField.setText(person.getFirstName());
        	lastNameField.setText(person.getLastName());
        	telefonoField.setText(Integer.toString(person.getTelefono()));
        	direccionField.setText(person.getDireccion());
        	emailField.setText(person.getEmail());
            
        } else {
            // Person is null, remove all the text.
        	firstNameField.setText("");
        	lastNameField.setText("");
        	telefonoField.setText("");
        	direccionField.setText("");
        	emailField.setText("");
            
        }
    }
    private void showProductosDetails(Productos produc) {
    	
    	if(produc!=null) {
    	   nombreProField.setText(produc.getFirstName());
    	   tipoCombo.setItems(FXCollections.observableArrayList("Consola","Periferico","Videojuego"));
    	   tipoCombo.setValue(produc.getTipo());
    	  // tipoCombo.initModality(Modality.APPLICATION_MODAL);
     	   precioField.setText(Double.toString(produc.getPrecio())+"€");
     	  // procedenciaField.setText(produc.getProcedencia());
     	  procedenciaCombo.setItems(FXCollections.observableArrayList("España","China","Portugal","India","Francia","Inglaterra"));
     	  procedenciaCombo.setValue(produc.getProcedencia());
     	   codigoField.setText(produc.getCodigo());
    	}else {
    	   nombreProField.setText("");
    	   tipoField.setText("");
    	   precioField.setText("");
    	   procedenciaField.setText("");
    	   codigoField.setText("");
    	}
    }
}