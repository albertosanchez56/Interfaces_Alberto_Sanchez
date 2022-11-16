package application;
	
import Clases.Persona;
import Clases.Productos;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.MenuBar;
import javafx.scene.layout.BorderPane;


public class Main extends Application {
	
		private BorderPane rootLayout;	
		private ObservableList<Persona> personData = FXCollections.observableArrayList();
		private ObservableList<Productos> proData = FXCollections.observableArrayList();
		
	
 	   public Main() {
 			personData.add(new Persona("Alberto", "Sanchez" ,620141444, "C/asdasdasdasdas", "Alberto.smith@example.com"));
 			personData.add(new Persona("Lucia", "Garcia" ,51566115, "C/asdasdasdasdas", "Lucia.smith@example.com"));
 			personData.add(new Persona("Antonio", "Blas" ,51566115, "C/asdasdasdasdas", "Antonio.smith@example.com"));
 			personData.add(new Persona("Javier", "Escalera" ,51566115, "C/asdasdasdasdas", "Javier.smith@example.com"));
 			personData.add(new Persona("Miguel", "Smith" ,51566115, "C/asdasdasdasdas", "Miguel.smith@example.com"));
 			
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
				primaryStage.setScene(scene);
				primaryStage.setResizable(false);
				
				
				//primaryStage.setMaximized(true);
				primaryStage.setTitle("Practica tema1_2");
				primaryStage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
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
