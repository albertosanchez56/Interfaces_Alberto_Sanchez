package EditarDatos;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Separator;
import javafx.scene.control.cell.ComboBoxListCell;

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
    private ComboBox<Object> tipoCombo;

    @FXML
    void initialize() {

    	tipoCombo.setItems(FXCollections.observableArrayList("Consola",new Separator(),"Periferico",new Separator(),"Videojuego"));
    	tipoCombo.setValue("Select a value...");
    	
		list1.setItems(data);
		list1.setEditable(true);
		list1.setCellFactory(ComboBoxListCell.forListView(names));
		
		names.addAll(
	             "Object", "Classes", "Functions", "Variables",
	             "Compiler", "Debugger", "Projects", "Beans", 
	             "Libraries", "Modules"
	        );
		
		for (int i = 0; i < 10; i++) {
            data.add("Indeterminate (pick a choice)");
        }
    }
}
