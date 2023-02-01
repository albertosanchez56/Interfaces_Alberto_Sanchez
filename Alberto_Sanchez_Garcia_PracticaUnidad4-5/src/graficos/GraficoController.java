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
import javafx.scene.chart.PieChart.Data;
import mostrarDatos.DatosController;

public class GraficoController {

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PieChart pieChart;
    
    @FXML
    private LineChart<String, Number> LineChart;
    private ObservableList<PieChart.Data> pieData;
    private Main mainApp;
    
    private Productos pro1= new Productos();
    private List<Productos> listapro = new ArrayList<>();
   
    @FXML
    void initialize() {
    	
    }
    
    	public void initPieChart() {
  
    		
    			pieChart.setData(pieData);
    		
    				
    			
    			// Se muestra en cada etiqueta el valor
    	    		for (final PieChart.Data data : pieChart.getData()) {
    	    			data.setName(data.getName() + "=" + data.getPieValue()+"€");
    	    		}
    	    	}
    		
    			
    		
    		
    	public PieChart getPieChart() {
    		return pieChart;
    	}
    	public void setPieChart(PieChart pieChart) {
			this.pieChart = pieChart;
		}
    
    
    
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;
        listapro.addAll(this.mainApp.getProductosData());
      
    }

	public ObservableList<PieChart.Data> getPieData() {
		return pieData;
	}


	public void setPieData(ObservableList<PieChart.Data> pieData) {
		this.pieData = pieData;
	}
}
