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
import javafx.scene.chart.BubbleChart;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.chart.StackedBarChart;
import mostrarDatos.DatosController;
import javafx.scene.chart.XYChart;

public class GraficoController {

	@FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private PieChart pieChart;
    @FXML
    private BubbleChart<Integer, Integer> bubbleChart;
    
    @FXML
    private StackedBarChart<String, Integer> stackedBar;
    
    @FXML
    private LineChart<String, Number> LineChart;
    private ObservableList<PieChart.Data> pieData;
    private ObservableList<XYChart.Series<Integer, Integer>> dist2;
    private ObservableList<XYChart.Series<String, Integer>> dist1;
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
    		
    			
    	 public void initBubbleChart() {
    	    	bubbleChart.setData(this.dist2);
    	    }
    	    
    	public void initStackBarchart() {
    		stackedBar.setData(this.dist1);
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
	
	public ObservableList<XYChart.Series<Integer, Integer>> getDist2() {
		return dist2;
	}

	public void setDist2(ObservableList<XYChart.Series<Integer, Integer>> dist2) {
		this.dist2 = dist2;
	}
	
	public ObservableList<XYChart.Series<String, Integer>> getDist1() {
		return dist1;
	}

	public void setDist1(ObservableList<XYChart.Series<String, Integer>> dist1) {
		this.dist1 = dist1;
	}
}
