package EditarDatos;

import Clases.Persona;
import Clases.Productos;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

/**
 * Clase Controller para el editDialog de los productos
 * 
 * @author Alberto Sanchez Garcia
 * */
public class ProductEditDialogController {

	 @FXML
	    private TextField firstName3;
	    @FXML
	    private TextField tipo3;
	    
	    @FXML
	    private TextField precio3;
	    
	    @FXML
	    private TextField procedencia3;
	    
	    @FXML
	    private TextField codigo3;
	    
	  
	    
	    
	    private Stage dialogStage;
	    private Productos product;
	    private boolean okClicked = false;
	    
	    @FXML
	    private void initialize() {
	    	
	    }
	    public void setProduct(Productos product) {
	        this.product = product;
	        
	       
		    firstName3.setText(product.getFirstName());
		    tipo3.setText(product.getTipo());
		    precio3.setText(Double.toString(product.getPrecio()));
		    procedencia3.setText(product.getProcedencia());
		    codigo3.setText(product.getCodigo());
	      
	    }
	    
	    public boolean isOkClicked() {
	        return okClicked;
	    }

	    /**Metodo para manejar el boton de ok*/
	    @FXML
	    private void handleOk() {
	    	 if (isInputValid()) {
	    		 product.setFirstName(firstName3.getText());
	    		 product.setTipo(tipo3.getText());
	    		 product.setPrecio(Double.parseDouble(precio3.getText()));
	    		 product.setProcedencia(procedencia3.getText());
	    		 product.setCodigo(codigo3.getText());
	             okClicked = true;
	             dialogStage.close();
	             
	         }
	    }
	    
	    @FXML
	    private void handleCancel() {
	        dialogStage.close();
	    }
	    /**Metodo para comprobar si los datos introducidos son validos*/
	    private boolean isInputValid() {
	    	String errorMessage = "";
	    	
	    	if (firstName3.getText() == null || firstName3.getText().length() == 0) {
	            errorMessage += "El campo nombre está vacío\n"; 
	        }
	        if (tipo3.getText() == null || tipo3.getText().length() == 0) {
	            errorMessage += "El campo apellido está vacío\n"; 
	        }
	        if (precio3.getText() == null || precio3.getText().length() == 0) {
	            errorMessage += "El campo precio está vacío\n"; 
	        } else {
	            // Se intenta convertir el código postal en entero y si da un error se muestra un mensaje
	            try {
	                Double.parseDouble(precio3.getText());
	            } catch (NumberFormatException e) {
	                errorMessage += "Telefono no válido. Debe ser un número entero\n"; 
	            }
	        }
	        if (procedencia3.getText() == null || procedencia3.getText().length() == 0) {
	            errorMessage += "El campo procedencia está vacío\n"; 
	        }
	        if (codigo3.getText() == null || codigo3.getText().length() == 0) {
	            errorMessage += "El campo codigo está vacío\n"; 
	        }
	        
	        if (errorMessage.length() == 0) {
	            return true;
	        } else {
	        	// Se muestra un alert si no se puede eliminar la fila
	    		Alert errorAlert = new Alert(AlertType.ERROR);
	        	
	    		errorAlert.setTitle("Hay campos incorrectos");
	    		errorAlert.setHeaderText("Por favor, rellena correctamente los campos");
	    		errorAlert.setContentText(errorMessage);
	    		
	    		errorAlert.showAndWait();
	            return false;
	        }
	    	
	    }
	public void setDialogStage(Stage dialogStage) {
     this.dialogStage = dialogStage;
 }
}
