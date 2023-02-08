package EditarDatos;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import Clases.Persona;
import Clases.Productos;
import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.ComboBoxListCell;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.input.TransferMode;

/**
 * Clase Controller para editar los datos
 * 
 * @author Alberto Sanchez Garcia
 * */
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
    @FXML
    private RadioButton femeRadButton;
    
    @FXML
    private RadioButton mascuRadButton;
    
    
    @FXML
	private ImageView imageView;

    private Main mainApp;
    /**
     * Metodo initialize para inicializar los datos en las distintas tabla , labels ...
     * */
    @FXML
    void initialize() {

    	firstNameCol.setCellValueFactory(cellData -> cellData.getValue().firstNameProperty());
    	lastNameCol.setCellValueFactory(cellData -> cellData.getValue().lastNameProperty());

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
    	
    	

    	tipoCombo2.setItems(FXCollections.observableArrayList("Consola","Periferico","Videojuego"));
    	tipoCombo2.setValue("Seleciona un tipo");

    	
    	procedenciaCombo2.setItems(FXCollections.observableArrayList("España","China","Portugal","India","Francia","Inglaterra"));
    	procedenciaCombo2.setValue("Seleciona un pais");
    	
    	puestoCombo.setItems(FXCollections.observableArrayList("Encargado","Manager","Contable"));

    	
		list1.setItems(data);
		list1.setEditable(true);
		list1.setCellFactory(ComboBoxListCell.forListView(names));
		
		names.addAll(
	             "trabajador", "productivo", "actitud positiva", "empatico",
	             "polivalente", "autodidacta", "puntual", "creativo"
	             
	        );
		
		for (int i = 0; i < 10; i++) {
            data.add("Indefinido (elige una opcion)");
        }
    }
    
    /**
     * @param mainApp para recoger la clase principal
     * Metodo para recoger los datos de la clase main*/
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;

        listaNombresEmpleados.setItems(this.mainApp.getPersonData());
        listaNombresProducto.setItems(this.mainApp.getProductosData());
               
        // TODO Versión con map
        //personTable.setItems(this.mainApp.getMapData()); 
    }
    @FXML
    private void handleDialogOver(DragEvent event) {
    	if (event.getDragboard().hasFiles()) {
    		event.acceptTransferModes(TransferMode.MOVE);
    	}
    }
    @FXML
    private void handleDrop(DragEvent event) throws FileNotFoundException {
    	List<File> files = event.getDragboard().getFiles();
    	Image img = new Image(new FileInputStream(files.get(0)));
    	imageView.setImage(img);
    }
    
  
 
   
   /**Metodo para mostrar los datos de el empleado seleccionado*/
    private void showPersonDetails(Persona person) {
        if (person != null) {
        	// Si el campo contiene datos, entonces se rellena la información
        	firstNameField.setText(person.getFirstName());
        	lastNameField.setText(person.getLastName());
        	telefonoField.setText(Integer.toString(person.getTelefono()));
        	direccionField.setText(person.getDireccion());
        	emailField.setText(person.getEmail());
        	puestoCombo.setItems(FXCollections.observableArrayList("Encargado","Manager","Contable"));
        	puestoCombo.setValue(person.getPuesto());
        	if(person.getGenero().equals("masculino")) {
        		mascuRadButton.setSelected(true);
        	}else {
        		femeRadButton.setSelected(true);
        	}
        } else {
            // Person is null, remove all the text.
        	firstNameField.setText("");
        	lastNameField.setText("");
        	telefonoField.setText("");
        	direccionField.setText("");
        	emailField.setText("");
            
        }
    }
    
    /**Metodo para mostrar los datos de el producto seleccionado*/
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
    
    /**metodo para borrar el empleado seleccionado*/
    @FXML
    private void handleDeletePerson(ActionEvent event) {
       	int selectedIndex = listaNombresEmpleados.getSelectionModel().getSelectedIndex();
    	
    	// Si no hay ningún campo seleccionado, se muestra un alert
    	if (selectedIndex >= 0) {
    		// Si se ha seleccionado una fila, se muestra un pop up de confirmación
    		Alert confirm = new Alert(AlertType.CONFIRMATION);
        	
    		confirm.setTitle("Confirmación para eliminar");
    		//errorAlert.setHeaderText("Va a eliminar la fila seleccionada");
    		confirm.setContentText("¿Está seguro de eliminar la fila actual?");
    		    	    		
    		// Si el usuario acepta, entonces se lleva a cabo la acción correspondiente
    		confirm.showAndWait().ifPresent(response -> {
    			if (response == ButtonType.OK) {
    				listaNombresEmpleados.getItems().remove(selectedIndex);
    		    }
    		});
    	} else {
    		// Se muestra un alert si no se puede eliminar la fila
    		Alert errorAlert = new Alert(AlertType.ERROR);
        	
    		errorAlert.setTitle("Error al eliminar");
    		errorAlert.setHeaderText("Se ha producido un error");
    		errorAlert.setContentText("No se puede eliminar porque no ha seleccionado una fila o la tabla está vacía");
    		
    		errorAlert.showAndWait();
    	}    	
    }
    
    /**metodo para borrar el producto seleccionado*/
    @FXML
    private void handleDeleteProduct(ActionEvent event) {
       	int selectedIndex = listaNombresProducto.getSelectionModel().getSelectedIndex();
    	
    	// Si no hay ningún campo seleccionado, se muestra un alert
    	if (selectedIndex >= 0) {
    		// Si se ha seleccionado una fila, se muestra un pop up de confirmación
    		Alert confirm = new Alert(AlertType.CONFIRMATION);
        	
    		confirm.setTitle("Confirmación para eliminar");
    		//errorAlert.setHeaderText("Va a eliminar la fila seleccionada");
    		confirm.setContentText("¿Está seguro de eliminar la fila actual?");
    		    	    		
    		// Si el usuario acepta, entonces se lleva a cabo la acción correspondiente
    		confirm.showAndWait().ifPresent(response -> {
    			if (response == ButtonType.OK) {
    				listaNombresProducto.getItems().remove(selectedIndex);
    		    }
    		});
    	} else {
    		// Se muestra un alert si no se puede eliminar la fila
    		Alert errorAlert = new Alert(AlertType.ERROR);
        	
    		errorAlert.setTitle("Error al eliminar");
    		errorAlert.setHeaderText("Se ha producido un error");
    		errorAlert.setContentText("No se puede eliminar porque no ha seleccionado una fila o la tabla está vacía");
    		
    		errorAlert.showAndWait();
    	}    	
    }
    @FXML
    private void handleNewProduct(ActionEvent event) {
    	 Productos tempProduct2 = new Productos();
         boolean okClicked = mainApp.showProductEditDialog(tempProduct2);
         if (okClicked) {
             mainApp.getProductosData().add(tempProduct2);
         }  
        
               
    }
    
    /**metodo para editar el producto seleccionado*/
    @FXML
    private void handleEditProdcut(ActionEvent event) {
    	Productos selectedProduct = listaNombresProducto.getSelectionModel().getSelectedItem();
        if (selectedProduct != null) {
            boolean okClicked = mainApp.showProductEditDialog(selectedProduct);
            if (okClicked) {
                showProductosDetails(selectedProduct);
            }

        } else {
        	// Se muestra un alert si no se puede eliminar la fila
    		Alert errorAlert = new Alert(AlertType.ERROR);
        	
    		errorAlert.setTitle("Error al editar persona");
    		errorAlert.setHeaderText("No se ha seleccionado ninguna fila");
    		errorAlert.setContentText("Por favor, selecciona una persona en la tabla");
    		
    		errorAlert.showAndWait();
        }
    }
    
    @FXML
    private void handleNewPerson(ActionEvent event) {
    	 Persona tempPerson = new Persona();
         boolean okClicked = mainApp.showPersonEditDialog(tempPerson);
         if (okClicked) {
             mainApp.getPersonData().add(tempPerson);
         }  
        
               
    }
    /**metodo para editar el empleado seleccionado*/
    @FXML
    private void handleEditPerson(ActionEvent event) {
        Persona selectedPerson = listaNombresEmpleados.getSelectionModel().getSelectedItem();
        if (selectedPerson != null) {
            boolean okClicked = mainApp.showPersonEditDialog(selectedPerson);
            if (okClicked) {
                showPersonDetails(selectedPerson);
            }

        } else {
        	// Se muestra un alert si no se puede eliminar la fila
    		Alert errorAlert = new Alert(AlertType.ERROR);
        	
    		errorAlert.setTitle("Error al editar persona");
    		errorAlert.setHeaderText("No se ha seleccionado ninguna fila");
    		errorAlert.setContentText("Por favor, selecciona una persona en la tabla");
    		
    		errorAlert.showAndWait();
        }
    }
}
