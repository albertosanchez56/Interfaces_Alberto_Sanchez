package application;
	
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Clases.Persona;
import Clases.Productos;
import EditarDatos.EditarDatosController;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

/**
 * Clase Main donde se inicia la aplicación
 * 
 * @author Alberto Sanchez Garcia
 * @version 4.0
 * 
 * */
public class Main extends Application {
	
		private Stage primaryStage;
		private BorderPane rootLayout;	
		private ObservableList<Persona> personData = FXCollections.observableArrayList();
		private ObservableList<Productos> proData = FXCollections.observableArrayList();
		private List<Productos> listapro = new ArrayList<>();
		
		/**Crea la informacion de los empleados y los productos */
 	   public Main() {
 			personData.add(new Persona("Alberto", "Sanchez" ,620141444, "C/asdasdasdasdas", "Alberto.smith@example.com","Encargado","masculino"));
 			personData.add(new Persona("Lucia", "Garcia" ,51566115, "C/asdasdasdasdas", "Lucia.smith@example.com","Manager","femenino"));
 			personData.add(new Persona("Antonio", "Blas" ,51566115, "C/asdasdasdasdas", "Antonio.smith@example.com","Contable","masculino"));
 			personData.add(new Persona("Javier", "Escalera" ,51566115, "C/asdasdasdasdas", "Javier.smith@example.com","Encargado","masculino"));
 			personData.add(new Persona("Miguel", "Smith" ,51566115, "C/asdasdasdasdas", "Miguel.smith@example.com","Contable","masculino"));
 			
 			proData.add(new Productos("Play Station 4", "Consola" ,400.0, "China", "00034"));
 			proData.add(new Productos("Elden Ring", "Videojuego" ,60.0, "China", "00032"));
 			proData.add(new Productos("Logitec 933", "Periferico" ,80.0, "Portugal", "00045"));
 			proData.add(new Productos("Skyrim", "Videojuego" ,40.0, "España", "00061"));
 			proData.add(new Productos("Xbox 360", "Consola" ,300.0, "España", "00099"));
 			
 		}
 	  /**
 	   * 
 	   * @param primaryStage Objeto con la ventana principal
 	   * Inicia la aplicacion */
		@Override
		public void start(Stage primaryStage ) {
			try {
				// Carga el diseño del archivo FXML en la variable rootLayout
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(Main.class.getResource("Menu.fxml"));
				rootLayout = (BorderPane) loader.load();
				rootLayout.getStylesheets().add(getClass().getResource("/application/application.css").toExternalForm());
				// Pasamos al controlador de menu el objeto con el BorderPane principal
				MenuController menuController = loader.getController();
				menuController.setRootLayout(rootLayout);
				MenuController main = loader.getController();
				main.setMainApp(this);
				
				// Mostramos la escena del BorderPane de la variable rootLayot
				Scene scene = new Scene(rootLayout);
				this.primaryStage = primaryStage;
				primaryStage.setScene(scene);
				primaryStage.setResizable(false);
				
				
				//primaryStage.setMaximized(true);
				primaryStage.setTitle("Practica temas 4-5");
				primaryStage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		/**@param person Objeto para mostrar los datos de la persona seleccionada
		 * 
		 * Abre un nuevo dialogo para editar los empleados*/
		public boolean showPersonEditDialog(Persona person) {
		    try {
		        // Cargamos el diseño del diálogo desde un XML
		        FXMLLoader loader = new FXMLLoader();
		        loader.setLocation(Main.class.getResource("/EditarDatos/PersonaEditDiealog.fxml"));
		        AnchorPane page = (AnchorPane) loader.load();

		        // Se crea un nuevo Stage para mostrar el diálogo
		        Stage dialogStage = new Stage();
		        dialogStage.setTitle("Crear o editar persona");
		        dialogStage.initModality(Modality.WINDOW_MODAL);
		        dialogStage.initOwner(primaryStage);
		        Scene scene = new Scene(page);
		        dialogStage.setScene(scene);

		        // Carga la persona en el controlador
		        EditarDatos.PersonEditDialogController controller = loader.getController();
		        controller.setDialogStage(dialogStage);
		        controller.setPerson(person);

		        // Muestra el diálogo y no continúa el código hasta que lo cierra el usuario
		        dialogStage.showAndWait();

		        return controller.isOkClicked();//controller.isOkClicked();
		    } catch (IOException e) {
		        e.printStackTrace();
		        return false;
		    }
		}
		/**
		 * @param product Objeto para mostrar los datos del producto seleccionada
		 * Abre un nuevo dialogo para editar los productos*/
		public boolean showProductEditDialog(Productos product) {
		    try {
		        // Cargamos el diseño del diálogo desde un XML
		        FXMLLoader loader = new FXMLLoader();
		        loader.setLocation(Main.class.getResource("/EditarDatos/ProductosEditarDialog.fxml"));
		        AnchorPane page = (AnchorPane) loader.load();

		        // Se crea un nuevo Stage para mostrar el diálogo
		        Stage dialogStage = new Stage();
		        dialogStage.setTitle("Crear o editar producto");
		        dialogStage.initModality(Modality.WINDOW_MODAL);
		        dialogStage.initOwner(primaryStage);
		        Scene scene = new Scene(page);
		        dialogStage.setScene(scene);

		        // Carga la persona en el controlador
		        EditarDatos.ProductEditDialogController controller = loader.getController();
		        controller.setDialogStage(dialogStage);
		        controller.setProduct(product);

		        // Muestra el diálogo y no continúa el código hasta que lo cierra el usuario
		        dialogStage.showAndWait();

		        return controller.isOkClicked();//controller.isOkClicked();
		    } catch (IOException e) {
		        e.printStackTrace();
		        return false;
		    }
		}
		
		/**Añade los datos al PieChart*/
		public ObservableList<PieChart.Data> loadPieData(){
			listapro=new ArrayList<>();
			listapro.addAll(getProductosData());
			// Rellenamos los datos del gr�fico
			ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
		
			for(int i=0; i<listapro.size();i++) {
	    		PieChart.Data pie= new PieChart.Data(listapro.get(i).getFirstName().toString(), listapro.get(i).getPrecio());
	    		
	    		pieChartData.add(pie);
	    		System.out.println(listapro.get(i).getFirstName());
	        		
		
		}
				
			return pieChartData;
		}
		
		
		public ObservableList<XYChart.Series<String, Number>> loadDist1(){
			List<XYChart.Series<String, Number>> list = new ArrayList<XYChart.Series<String,Number>>();
		
			// Se crean dos series con datos
			XYChart.Series<String, Number> series1 = new XYChart.Series<String, Number>();
			series1.setName("Consolas");
			series1.getData().add(new XYChart.Data<String, Number>("2018", 300));
			series1.getData().add(new XYChart.Data<String, Number>("2019", 1000));
			series1.getData().add(new XYChart.Data<String, Number>("2020", 400));
			series1.getData().add(new XYChart.Data<String, Number>("2021", 600));
			series1.getData().add(new XYChart.Data<String, Number>("2022", 1300));
			series1.getData().add(new XYChart.Data<String, Number>("2023", 900));
			
	        
			// Se crean dos series con datos
			XYChart.Series<String, Number> series2 = new XYChart.Series<String, Number>();
			series2.setName("Videojuegos");
			series2.getData().add(new XYChart.Data<String, Number>("2018", 1300));
			series2.getData().add(new XYChart.Data<String, Number>("2019", 1900));
			series2.getData().add(new XYChart.Data<String, Number>("2020", 1500));
			series2.getData().add(new XYChart.Data<String, Number>("2021", 1100));
			series2.getData().add(new XYChart.Data<String, Number>("2022", 1903));
			series2.getData().add(new XYChart.Data<String, Number>("2023", 1111));
			
			
			XYChart.Series<String, Number> series3 = new XYChart.Series<String, Number>();
			series3.setName("Perifericos");
			series3.getData().add(new XYChart.Data<String, Number>("2018", 700));
			series3.getData().add(new XYChart.Data<String, Number>("2019", 400));
			series3.getData().add(new XYChart.Data<String, Number>("2020", 300));
			series3.getData().add(new XYChart.Data<String, Number>("2021", 1000));
			series3.getData().add(new XYChart.Data<String, Number>("2022", 600));
			series3.getData().add(new XYChart.Data<String, Number>("2023", 700));
			
			
			list.add(series1);
			list.add(series2);
			list.add(series3);
			
	        return FXCollections.observableArrayList(list);
		}
		public ObservableList<XYChart.Series<Integer, Integer>> loadBubbleData(){
			List<XYChart.Series<Integer, Integer>> list = new ArrayList<XYChart.Series<Integer, Integer>>();
			XYChart.Series<Integer, Integer> bubbleData1=  new XYChart.Series<Integer, Integer>();
			
			bubbleData1.setName("Consola");
			bubbleData1.getData().add(new XYChart.Data<Integer, Integer>(2020, 300));
			bubbleData1.getData().add(new XYChart.Data<Integer, Integer>(2021, 100));
			bubbleData1.getData().add(new XYChart.Data<Integer, Integer>(2022, 400));
			
			XYChart.Series<Integer, Integer> bubbleData2=  new XYChart.Series<Integer, Integer>();
			bubbleData2.setName("Videojuegos");
			bubbleData2.getData().add(new XYChart.Data<Integer, Integer>(2019, 200));
			bubbleData2.getData().add(new XYChart.Data<Integer, Integer>(2020, 900));
			bubbleData2.getData().add(new XYChart.Data<Integer, Integer>(2021, 500));
			
			XYChart.Series<Integer, Integer> bubbleData3=  new XYChart.Series<Integer, Integer>();
			bubbleData3.setName("Perifericos");
			bubbleData3.getData().add(new XYChart.Data<Integer, Integer>(2021, 500));
			bubbleData3.getData().add(new XYChart.Data<Integer, Integer>(2020, 200));
			bubbleData3.getData().add(new XYChart.Data<Integer, Integer>(2022, 300));
			
			
			list.add(bubbleData1);
			list.add(bubbleData2);
			list.add(bubbleData3);
			

			return FXCollections.observableArrayList(list);
		}
		public ObservableList<XYChart.Series<String, Integer>> loadStackBarchart(){
			List<XYChart.Series<String, Integer>> list = new ArrayList<XYChart.Series<String,Integer>>();
		
			// Se crean dos series con datos
			XYChart.Series<String, Integer> series1 = new XYChart.Series<String, Integer>();
			series1.setName("2020");
			series1.getData().add(new XYChart.Data<String, Integer>("Encargado", 200));
			series1.getData().add(new XYChart.Data<String, Integer>("Marketing", 1000));
			series1.getData().add(new XYChart.Data<String, Integer>("Manager", 400));
			series1.getData().add(new XYChart.Data<String, Integer>("Contable", 1500));
	
	        
			// Se crean dos series con datos
			XYChart.Series<String, Integer> series2 = new XYChart.Series<String, Integer>();
			series2.setName("2021");
			series2.getData().add(new XYChart.Data<String, Integer>("Encargado", 500));
			series2.getData().add(new XYChart.Data<String, Integer>("Marketing", 1300));
			series2.getData().add(new XYChart.Data<String, Integer>("Manager", 600));
			series2.getData().add(new XYChart.Data<String, Integer>("Contable", 500));
			
			XYChart.Series<String, Integer> series3 = new XYChart.Series<String, Integer>();
			series3.setName("2022");
			series3.getData().add(new XYChart.Data<String, Integer>("Encargado", 1340));
			series3.getData().add(new XYChart.Data<String, Integer>("Marketing", 507));
			series3.getData().add(new XYChart.Data<String, Integer>("Manager", 400));
			series3.getData().add(new XYChart.Data<String, Integer>("Contable", 700));
			
			XYChart.Series<String, Integer> series4 = new XYChart.Series<String, Integer>();
			series4.setName("2023");
			series4.getData().add(new XYChart.Data<String, Integer>("Encargado", 800));
			series4.getData().add(new XYChart.Data<String, Integer>("Marketing", 1500));
			series4.getData().add(new XYChart.Data<String, Integer>("Manager", 460));
			series4.getData().add(new XYChart.Data<String, Integer>("Contable", 1333));
			
			list.add(series1);
			list.add(series2);
			list.add(series3);
			list.add(series4);
			
	        return FXCollections.observableArrayList(list);
		}
		
		public static void main(String[] args) {
			launch(args);
		}
		public ObservableList<Persona> getPersonData() {
			return personData;
		}
		public ObservableList<Productos> getProductosData() {
			return proData;
		}
		
}
