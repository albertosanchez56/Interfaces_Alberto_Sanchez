package application;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class MenuController {
	private BorderPane rootLayout;
  
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
    

	public BorderPane getRootLayout() {
		return rootLayout;
	}
	public void setRootLayout(BorderPane rootLayout) {
		this.rootLayout = rootLayout;
	}	
	/*public void setRootLayout(BorderPane rootLayout) {
		
	}*/

}

