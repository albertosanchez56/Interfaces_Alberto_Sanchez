package mostrarDatos;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Persona {

    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private final SimpleIntegerProperty telefono;
    private final SimpleStringProperty direccion;
    private final SimpleStringProperty email;
    
    
    
    
	public Persona(String fName, String lName, Integer itelefono,String sdireccion, String email ) {
        this.firstName = new SimpleStringProperty(fName);
        this.lastName = new SimpleStringProperty(lName);
        this.telefono = new SimpleIntegerProperty(itelefono);
        this.direccion = new SimpleStringProperty(sdireccion);
        this.email = new SimpleStringProperty(email);
        
    }
	public String getFirstName() {
        return firstName.get();
    }
    
    public void setFirstName(String fName) {
        firstName.set(fName);
    }
        
    public String getLastName() {
        return lastName.get();
    }
    public void setLastName(String lName) {
        lastName.set(lName);
    }

	public Integer getTelefono() {
		return telefono.get();
	}
	public void setTelefono(Integer itelefono) {
		telefono.set(itelefono);
    }
	public String getDireccion() {
        return direccion.get();
    }
    public void setDireccion(String sdireccion) {
        direccion.set(sdireccion);
    }
    
    public String getEmail() {
        return email.get();
    }
    public void setEmail(String sdireccion) {
        email.set(sdireccion);
    }
      
      

     
    
 
}
