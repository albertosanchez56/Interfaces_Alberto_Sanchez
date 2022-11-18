package mostrarDatos;

import java.net.URL;
import java.util.ResourceBundle;
import application.Main;
import Clases.Persona;
import Clases.Productos;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
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
    
    @FXML
    private TableColumn<Persona, Integer> telefonoCol;
   
    
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
    
    private Main mainApp;
    
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
        emailCol.setCellValueFactory(new PropertyValueFactory<Persona,String>("email"));
        	*/
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
    	
    	//showPersonDetails(null);
    	
    	listaNombresEmpleados.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showPersonDetails(newValue));
        
        TreeItem<String> rootItem=new TreeItem<String>("Puestos");
		TreeItem<String> encargado=new TreeItem<String>("Encargado");
		TreeItem<String> Marke=new TreeItem<String>("Marketing");	
		TreeItem<String> manager=new TreeItem<String>("Manager");
		TreeItem<String> cost=new TreeItem<String>("Contable");
		rootItem.getChildren().add(encargado);
		rootItem.getChildren().add(Marke);
		rootItem.getChildren().add(manager);
		rootItem.getChildren().add(cost);
		
		rootItem.setExpanded(true);
		tree1.setRoot(rootItem);
		
		 TreeItem<String> rootItem2=new TreeItem<String>("Tipos de producto");
			TreeItem<String> consola=new TreeItem<String>("Consola");
			TreeItem<String> periferico=new TreeItem<String>("Periferico");	
			TreeItem<String> videojuegos=new TreeItem<String>("Videojuegos");
			rootItem2.getChildren().add(consola);
			rootItem2.getChildren().add(periferico);
			rootItem2.getChildren().add(videojuegos);
			
			rootItem2.setExpanded(true);
			tree2.setRoot(rootItem2);
        	
        	//listaNombresEmpleados.setItems(dataEmpleados);
        	//listaNombresProducto.setItems(dataPro);
    	
    	
    	
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
            
        } /*else {
            // Person is null, remove all the text.
        	//firstNameField.setText("");
        	lastNameField.setText("");
        	telefonoField.setText("");
        	direccionField.setText("");
        	emailField.setText("");
            
        }*/
    }
    

	
}
