package mostrarDatos;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;


import application.Main;
import application.MenuController;
import graficos.GraficoController;
import Clases.Persona;
import Clases.Productos;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ListView;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;

import javafx.event.ActionEvent;


/**
 * 
 * Clase Controller para mostrar los datos de los productos y de los empleados
 * 
 * @author Alberto Sanchez Garcia
 * */
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
    @FXML
    private PieChart pieChart;
    private List<Productos> listapro = new ArrayList<>();
    /**
     * Metodo initialize para inicializar los datos en las distintas tabla , labels ...
     * */
    @FXML
    void initialize(){
    	

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
    	listaNombresProducto.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> showProductosDetails(newValue));
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
    
    /**
     * 
     * Metodo para abrir los graficos de los productos
     * */
    @FXML
    void graficoIni(ActionEvent event) {
    	try {
    		// Cargamos el diseño del diálogo desde un XML
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(DatosController.class.getResource("/graficos/graficos.fxml"));
            TabPane dialogo = (TabPane) loader.load();
            dialogo.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());

            // Se crea un nuevo Stage para mostrar el diálogo
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Graficos");
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.setResizable(false);
                    
            Scene scene = new Scene(dialogo);
            dialogStage.setScene(scene);   
            GraficoController controller = loader.getController();
            controller.setPieData(mainApp.loadPieData());
            controller.initPieChart();
            controller.setScatter(mainApp.loadDist1());
	        controller.initScatterChart();
          
	        
            
           			        
            // Muestra el diálogo y no continúa el código hasta que lo cierra el usuario
            dialogStage.showAndWait(); 
            
    	} catch (IOException e) {
	        e.printStackTrace();
	        
	    }
    }
    
    /**Metodo para abrir los graficos de los empleados*/
    @FXML
    void graficoEmpleadoIni(ActionEvent event) {
    	try {
    		// Cargamos el diseño del diálogo desde un XML
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(DatosController.class.getResource("/graficos/graficosEmpleados.fxml"));
            TabPane dialogo = (TabPane) loader.load();
            dialogo.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());

            // Se crea un nuevo Stage para mostrar el diálogo
            Stage dialogStage = new Stage();
            dialogStage.setTitle("Precios");
            dialogStage.initModality(Modality.APPLICATION_MODAL);
            dialogStage.setResizable(false);
                    
            Scene scene = new Scene(dialogo);
            dialogStage.setScene(scene);   
            GraficoController controller = loader.getController();
            controller.setDist1(mainApp.loadStackBarchart());
           controller.initStackBarchart();
          
	        
            
           			        
            // Muestra el diálogo y no continúa el código hasta que lo cierra el usuario
            dialogStage.showAndWait(); 
            
    	} catch (IOException e) {
	        e.printStackTrace();
	        
	    }
    }
    
    
    /**Metodo para recoger los datos de la clase main*/
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;

        listaNombresEmpleados.setItems(this.mainApp.getPersonData());
        listaNombresProducto.setItems(this.mainApp.getProductosData());
        listapro.addAll(this.mainApp.getProductosData());
               System.out.println(listaNombresEmpleados);
               System.out.println(listapro.toString());
        // TODO Versión con map
        //personTable.setItems(this.mainApp.getMapData()); 
    }
    
    /**
     * Metodo para mostrar los detalles de la persona en los labels
     * */
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
    /**
     * Metodo para mostrar los detalles de los productos en los labels
     * */
    private void showProductosDetails(Productos produc) {
    	
    	if(produc!=null) {
    	   nombreProField.setText(produc.getFirstName());
     	   tipoField.setText(produc.getTipo());
     	   precioField.setText(Double.toString(produc.getPrecio())+"€");
     	   procedenciaField.setText(produc.getProcedencia());
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
