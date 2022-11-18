package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import EditarDatos.EditarDatosController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import mostrarDatos.DatosController;

public class MenuController {
	private BorderPane rootLayout;
	private Main main;
  
	 @FXML
	    private MenuBar menu;

    @FXML
    private URL location;

    @FXML
    void initialize() {

    }
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
    

    @FXML
    void iniciarSesion(ActionEvent event) {
    	rootLayout.setCenter(null);
    	menu.setVisible(true);
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
