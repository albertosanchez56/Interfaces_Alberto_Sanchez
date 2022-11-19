package EditarDatos;
import Clases.Persona;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class PersonEditDialogController {
	 @FXML
	    private TextField firstName2;
	    @FXML
	    private TextField lastName2;
	    
	    @FXML
	    private TextField telefono2;
	    
	    @FXML
	    private TextField direcciones2;
	    
	    @FXML
	    private TextField email2;
	    
	    @FXML
	    private RadioButton femeRadButton2;
	    
	    @FXML
	    private RadioButton mascuRadButton2;
	    
	    
	    @FXML
	    private TextField puesto2;
	    
	    private Stage dialogStage;
	    private Persona person;
	    private boolean okClicked = false;
	    
	    @FXML
	    private void initialize() {
	    	
	    }
	    public void setPerson(Persona person) {
	        this.person = person;

	        firstName2.setText(person.getFirstName());
	        lastName2.setText(person.getLastName());
	        telefono2.setText(Integer.toString(person.getTelefono()));
	        
	        if(person.getGenero()!=null) {
	        	if(person.getGenero().equals("masculino")&& person.getGenero()!=null) {
		        	mascuRadButton2.setSelected(true);
		        }else if(person.getGenero().equals("femenino")&& person.getGenero()!=null){
		        	femeRadButton2.setSelected(true);
		        }
	        }else {
	        	mascuRadButton2.setText("masculino");
	        }
	        
	        
	        puesto2.setText(person.getPuesto());
	        direcciones2.setText(person.getDireccion());
	        email2.setText(person.getEmail());
	       
	    }
	    
	    public boolean isOkClicked() {
	        return okClicked;
	    }

	    @FXML
	    private void handleOk() {
	    	 if (isInputValid()) {
	             person.setFirstName(firstName2.getText());
	             person.setLastName(lastName2.getText());
	             person.setTelefono(Integer.parseInt(telefono2.getText()));
	             if(mascuRadButton2.isSelected()) {
	            	 person.setGenero("masculino");
	             }else {
	            	 person.setGenero("femenino");
	             }
	            
	             person.setPuesto(puesto2.getText());
	             person.setDireccion(direcciones2.getText());
	             person.setEmail(email2.getText());
	             
	             okClicked = true;
	             dialogStage.close();
	             
	         }
	    }
	    
	    
	    @FXML
	    private void handleCancel() {
	        dialogStage.close();
	    }
	    
	    private boolean isInputValid() {
	    	String errorMessage = "";
	    	
	    	if (firstName2.getText() == null || firstName2.getText().length() == 0) {
	            errorMessage += "El campo nombre está vacío\n"; 
	        }
	        if (lastName2.getText() == null || lastName2.getText().length() == 0) {
	            errorMessage += "El campo apellido está vacío\n"; 
	        }
	        if (telefono2.getText() == null || telefono2.getText().length() == 0) {
	            errorMessage += "El campo telefono está vacío\n"; 
	        } else {
	            // Se intenta convertir el código postal en entero y si da un error se muestra un mensaje
	            try {
	                Integer.parseInt(telefono2.getText());
	            } catch (NumberFormatException e) {
	                errorMessage += "Telefono no válido. Debe ser un número entero\n"; 
	            }
	        }
	        if (direcciones2.getText() == null || direcciones2.getText().length() == 0) {
	            errorMessage += "El campo direccion está vacío\n"; 
	        }
	        if (email2.getText() == null || email2.getText().length() == 0) {
	            errorMessage += "El campo emnail está vacío\n"; 
	        }
	        if (puesto2.getText() == null || puesto2.getText().length() == 0) {
	            errorMessage += "El campo puesto está vacío\n"; 
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
