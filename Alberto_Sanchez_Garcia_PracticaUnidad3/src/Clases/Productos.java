package Clases;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Productos {

	
		private SimpleStringProperty firstName;
	    private SimpleStringProperty tipo;
	    private SimpleDoubleProperty precio;
	    private SimpleStringProperty procedencia;
	    private SimpleStringProperty codigo;
	    
	    public Productos() {
	    	this(null,null,0.0,null,null);
			// TODO Auto-generated constructor stub
		}
	    
		public Productos(String fName, String stipo, Double dprecio,
				String sprocedencia, String scodigo) {
			this.firstName = new SimpleStringProperty(fName);
			this.tipo = new SimpleStringProperty(stipo);
			this.precio = new SimpleDoubleProperty(dprecio);
			this.procedencia = new SimpleStringProperty(sprocedencia);
			this.codigo = new SimpleStringProperty(scodigo);
		}


		public String getFirstName() {
			return firstName.get();
		}


		public void setFirstName(String fName) {
			 firstName.set(fName);
		}


		public String getTipo() {
			return tipo.get();
		}


		public void setTipo(String stipo) {
			tipo.set(stipo);;
		}


		public Double getPrecio() {
			return precio.get();
		}


		public void setPrecio(Double dprecio) {
			precio.set(dprecio);
		}


		public String getProcedencia() {
			return procedencia.get();
		}


		public void setProcedencia(String sprocedencia) {
			procedencia.set(sprocedencia);;
		}


		public String getCodigo() {
			return codigo.get();
		}


		public void setCodigo(String scodigo) {
			codigo.set(scodigo);;
		}


		 public StringProperty firstNameProperty() {
		    	return firstName;
		    }
		 public StringProperty tipoProperty() {
		    	return tipo;
		    }
		 public DoubleProperty precioProperty() {
		    	return precio;
		    }
		 public StringProperty procedenciaProperty() {
		    	return procedencia;
		    }
		 public StringProperty codigoProperty() {
		    	return codigo;
		    }


	
		
	    
}
