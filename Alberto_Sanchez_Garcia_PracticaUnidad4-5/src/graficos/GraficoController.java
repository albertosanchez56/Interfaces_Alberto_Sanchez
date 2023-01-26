package graficos;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import Clases.Persona;
import Clases.Productos;
import application.Main;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;

public class GraficoController {

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PieChart PieChart;
    
    @FXML
    private LineChart<String, Number> LineChart;
    private Main mainApp;
    
    private Productos pro1= new Productos();
    private List<Productos> listapro = new ArrayList<>();
    @FXML
    void initialize() {
    	for(int i=0; i<listapro.size();i++) {
    		PieChart.Data ia= new PieChart.Data(listapro.get(i).getFirstName().toString(), listapro.get(i).getPrecio());
    		ObservableList<PieChart.Data> pieChartData =
            		FXCollections.observableArrayList(ia);
        	PieChart.setData(pieChartData);
    	}
    	
    	
    	for (final PieChart.Data data : PieChart.getData()) {
		    data.setName(data.getName() + "=" + data.getPieValue());
		}
    }
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;

        //listaNombresEmpleados.setItems(this.mainApp.getPersonData());
        listapro.addAll(this.mainApp.getProductosData());
        System.out.println(listapro);
               
        // TODO Versión con map
        //personTable.setItems(this.mainApp.getMapData()); 
    }
}
