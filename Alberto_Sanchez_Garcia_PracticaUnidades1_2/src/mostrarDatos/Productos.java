package mostrarDatos;

import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class Productos {

	
		private SimpleStringProperty firstName;
	    private SimpleStringProperty tipo;
	    private SimpleDoubleProperty precio;
	    private SimpleStringProperty procedencia;
	    private SimpleStringProperty codigo;
	    
	    
		public Productos(String fName, String stipo, Double dprecio,
				String sprocedencia, String scodigo) {
			this.firstName = new SimpleStringProperty(fName);
			this.tipo = new SimpleStringProperty(stipo);
			this.precio = new SimpleDoubleProperty(dprecio);
			this.procedencia = new SimpleStringProperty(sprocedencia);
			this.codigo = new SimpleStringProperty(scodigo);
		}


		public SimpleStringProperty getFirstName() {
			return firstName;
		}


		public void setFirstName(SimpleStringProperty firstName) {
			this.firstName = firstName;
		}


		public SimpleStringProperty getTipo() {
			return tipo;
		}


		public void setTipo(SimpleStringProperty tipo) {
			this.tipo = tipo;
		}


		public SimpleDoubleProperty getPrecio() {
			return precio;
		}


		public void setPrecio(SimpleDoubleProperty precio) {
			this.precio = precio;
		}


		public SimpleStringProperty getProcedencia() {
			return procedencia;
		}


		public void setProcedencia(SimpleStringProperty procedencia) {
			this.procedencia = procedencia;
		}


		public SimpleStringProperty getCodigo() {
			return codigo;
		}


		public void setCodigo(SimpleStringProperty codigo) {
			this.codigo = codigo;
		}


	
		
	    
}
