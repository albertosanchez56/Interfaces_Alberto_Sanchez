package Clases;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Persona {

    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;
    private final SimpleIntegerProperty telefono;
    private final SimpleStringProperty direccion;
    private final SimpleStringProperty email;
    private final SimpleStringProperty puesto;
    private final SimpleStringProperty genero;
    
    public Persona() {
    	this(null, null,0,null,null,null,null);
    }
	public Persona(String fName, String lName, Integer itelefono,String sdireccion, String email,String spuesto,String sgenero) {
        this.firstName = new SimpleStringProperty(fName);
        this.lastName = new SimpleStringProperty(lName);
        this.telefono = new SimpleIntegerProperty(itelefono);
        this.direccion = new SimpleStringProperty(sdireccion);
        this.email = new SimpleStringProperty(email);
        this.puesto = new SimpleStringProperty(spuesto);
        this.genero = new SimpleStringProperty(sgenero);
        
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
    public String getPuesto() {
        return puesto.get();
    }
    public void setPuesto(String sgenero) {
    	puesto.set(sgenero);
    }
    public String getGenero() {
        return genero.get();
    }
    public void setGenero(String spuesto) {
    	genero.set(spuesto);
    }
      
    public StringProperty firstNameProperty() {
		return firstName;
	}
    public StringProperty lastNameProperty() {
    	return lastName;
    }
      
    public IntegerProperty telefonoProperty() {
    	return telefono;
    }
      
    public StringProperty direccionProperty() {
    	return direccion;
    }
      
    public StringProperty emailProperty() {
    	return email;
    }
    public StringProperty puestoProperty() {
    	return puesto;
    }
    public StringProperty generoProperty() {
    	return genero;
    }
      
    
      
    
    
     
    
 
}
