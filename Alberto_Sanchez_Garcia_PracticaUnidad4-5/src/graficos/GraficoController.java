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
    private Main mainApp;
    
    private Productos pro1= new Productos();
    private List<Productos> listapro = new ArrayList<>();
    @FXML
    void initialize() {
    	
       /* DatosController datosController= new DatosController();
        datosController.showProductosPrecio(PieChart);*/
    	
    	//if(pieChart!=null) {
    	/*ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
    	for(int i=0; i<listapro.size();i++) {
    		PieChart.Data pie= new PieChart.Data(listapro.get(i).getFirstName().toString(), listapro.get(i).getPrecio());
    		
    		pieChartData.add(pie);
    		System.out.println(listapro.get(i).getFirstName());
        	
    	}
    	pieChart.setData(pieChartData);
    	
    	for (final PieChart.Data data : pieChart.getData()) {
		    data.setName(data.getName() + "=" + data.getPieValue());
		}
    	}/*else {
			ObservableList<PieChart.Data> pieChartData =
	        		FXCollections.observableArrayList(
	        		 new PieChart.Data("DIW", 7),
	        		 new PieChart.Data("DI", 6),
	        		 new PieChart.Data("PSP", 8),
	        		 new PieChart.Data("PDM", 5),
	        		 new PieChart.Data("AD", 6),
	        		 new PieChart.Data("SGE", 4),
	        		 new PieChart.Data("DWEC", 10),
	        		 new PieChart.Data("DWES", 3));
			pieChart.setData(pieChartData);
	    	
	    	for (final PieChart.Data data : pieChart.getData()) {
			    data.setName(data.getName() + "=" + data.getPieValue());
			}
		}*/
    }
    public void setMainApp(Main mainApp) {
        this.mainApp = mainApp;

        //listaNombresEmpleados.setItems(this.mainApp.getPersonData());
        listapro.addAll(this.mainApp.getProductosData());
        System.out.println(listapro);
        System.out.println(listapro);
               
        // TODO Versión con map
        //personTable.setItems(this.mainApp.getMapData()); 
    }
}
