package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import EditarDatos.EditarDatosController;
import graficos.GraficoController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import mostrarDatos.DatosController;
/**
 * Clase Controller para el menu principal
 * 
 * @author Alberto Sanchez Garcia
 * */
public class MenuController {
	private BorderPane rootLayout;
	private Main main;
  
	 @FXML
	    private MenuBar menu;

    @FXML
    private URL location;

    @FXML
    private TextField correo2;
    
    @FXML
    private TextField password2;
    @FXML
    void initialize() {

    }
    /** Abre el formulario de los empleados y los productos*/
    @FXML
    private void abrirFormulario(ActionEvent event) {    	
    	try {
			// Cargamos el archivo Controles Dinámicos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MenuController.class.getResource("/mostrarDatos/mostrarDatos.fxml"));
			TabPane listadoControles = (TabPane) loader.load();
			
			DatosController datos=loader.getController();
			datos.setMainApp(main);
			
			// Se sitúa en el centro del diseño principal
			rootLayout.setCenter(listadoControles);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    /**Abre el formulario para editar los empleados y los productos*/
    @FXML
    void abrirFormularioEditar(ActionEvent event) {
    	try {
			// Cargamos el archivo Controles Dinámicos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MenuController.class.getResource("/EditarDatos/EditarDatos.fxml"));
			TabPane listadoControles = (TabPane) loader.load();
			EditarDatosController datos2=loader.getController();
			datos2.setMainApp(main);

			// Se sitúa en el centro del diseño principal
			rootLayout.setCenter(listadoControles);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    /**Abre la ayuda de la aplicacion*/
    @FXML
    void abrirAyuda(ActionEvent event) {
    	try {
			// Cargamos el archivo Controles Dinámicos
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(MenuController.class.getResource("/ayuda/Ayuda.fxml"));
			ScrollPane listadoControles = (ScrollPane) loader.load();
		

			// Se sitúa en el centro del diseño principal
			rootLayout.setCenter(listadoControles);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    /**Abre el inicio de sesion*/
    @FXML
    void iniciarSesion(ActionEvent event) {
    	if(isInputValid()) {
    		rootLayout.setCenter(null);
        	menu.setVisible(true);
        	
    	}
    	
    	
    }
    private boolean isInputValid() {
    	String errorMessage = "";
    	if(correo2.getText()== null || correo2.getText().length() == 0) {
    		errorMessage += "introduce un correo\n"; 
    	}
    	if(password2.getText()== null || password2.getText().length() == 0) {
    		errorMessage += "introduce una contraseña\n"; 
    	}
    	if (errorMessage.length() == 0) {
            return true;
        } else {
        	// Se muestra un alert si no se puede eliminar la fila
    		Alert errorAlert = new Alert(AlertType.ERROR);
        	
    		errorAlert.setTitle("Hay campos incorrectos");
    		errorAlert.setHeaderText("Por favor, rellena correctamente los campos");
    		errorAlert.setContentText(errorMessage);
    		
    		errorAlert.showAndWait();
            return false;
        }
    }
    @FXML
    void cerrarFormulario(ActionEvent event) {
    	rootLayout.setCenter(null);	
    }
    @FXML
    void cerrarFormularioEditar(ActionEvent event) {
    	rootLayout.setCenter(null);
    }

	public BorderPane getRootLayout() {
		return rootLayout;
	}
	public void setRootLayout(BorderPane rootLayout) {
		this.rootLayout = rootLayout;
	}	
	/*public void setRootLayout(BorderPane rootLayout) {
		
	}*/
	public Main getMainApp() {
		return main;
	}
	public void setMainApp(Main main) {
		// TODO Auto-generated method stub
		this.main=main;
	}

}

