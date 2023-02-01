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


public class Main extends Application {
	
		private Stage primaryStage;
		private BorderPane rootLayout;	
		private ObservableList<Persona> personData = FXCollections.observableArrayList();
		private ObservableList<Productos> proData = FXCollections.observableArrayList();
		private List<Productos> listapro = new ArrayList<>();
		
	
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
 			
 		  
 			
 			// TODO Probamos el map con solo dos ítems, ya que como se puede observar requiere más líneas de código que la altenrativa anterior
 			/*Map<String, Object> item1 = new HashMap<>();
 			item1.put("firstName", "Hans");
 			item1.put("lastName" , "Muster");

 			mapData.add(item1);

 			Map<String, Object> item2 = new HashMap<>();
 			item2.put("firstName", "Ruth");
 			item2.put("lastName" , "Mueller");

 			mapData.add(item2);*/
 		}
 		
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
				primaryStage.setTitle("Practica tema3");
				primaryStage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
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
		public XYChart.Series<Integer, String> loadBubbleData(){
			
			XYChart.Series<Integer, String> bubbleData=  new XYChart.Series<Integer, String>();
			
			bubbleData.setName("Cantidad de productos por categoria");
			bubbleData.getData().add(new XYChart.Data<Integer, String>(300, "Consola", 2));
			bubbleData.getData().add(new XYChart.Data<Integer, String>(300, "Videojuego", 2));
			bubbleData.getData().add(new XYChart.Data<Integer, String>(300, "Consola", 2));
			bubbleData.getData().add(new XYChart.Data<Integer, String>(300, "Consola", 2));
			bubbleData.getData().add(new XYChart.Data<Integer, String>(300, "Consola", 2));

			

			return bubbleData;
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
