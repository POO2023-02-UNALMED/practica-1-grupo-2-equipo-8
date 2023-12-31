package gestorAplicacion.empresa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;

public class Camion implements Serializable {
	//Atributos
	private  final String marca;
	private  final String modelo;
	private int capacidad;
	private  final String placa;
	private List<Envio> envios = new ArrayList<Envio>();
	private static ArrayList<Camion> camiones =new ArrayList<Camion>();
	private boolean disponibilidad= true;
	
	//Constructor
	public Camion(String marca, String modelo, int capacidad, String placa) {
		this.marca=marca;
		this.modelo=modelo;
		this.capacidad=capacidad;
		Camion.camiones.add(this);
		this.placa=placa;
	}
	
	
	public void agregarEnvio(Envio envio) {
		if (this.envios.contains(envio)||envio.isAsignadoAUnCamion()) {
		return;	
		}
		this.envios.add(envio);
		this.capacidad-=envio.getPesoTotal();
		envio.setAsignadoAUnCamion(true);
		
		
		
	}
	
	public void eliminarEnvio(Envio envio) {
		if (this.envios.contains(envio)) {
			this.envios.remove(envio);
			this.capacidad+=envio.getPesoTotal();
			envio.setAsignadoAUnCamion(false);
			
		}
	}

	public  static String camionesYCapacidad(int pesoEnvio) {
		StringBuilder result = new StringBuilder();
	    int numeracion = 1;

	    for (Camion camion : camiones) {
	        if (camion.getCapacidad() > pesoEnvio&& camion.isDisponibilidad()) {
	            result.append(numeracion).append(". ").append(camion.getMarca()).append(", ")
	                  .append(camion.getModelo()).append(", ").append(camion.getPlaca()).append(", ")
	                  .append(camion.getCapacidad()).append("\n");
	            numeracion++;
	        }
	    }

	    return result.toString();
	}

//Getters y Setters

	public String getMarca() {
		return marca;
	}





	public String getModelo() {
		return modelo;
	}






	public int getCapacidad() {
		return capacidad;
	}



	public void setCapacidad(int capacidad) {
		this.capacidad = capacidad;
	}



	public String getPlaca() {
		return placa;
	}



	public List<Envio> getEnvios() {
		return envios;
	}



	public void setEnvios(List<Envio> envios) {
		this.envios = envios;
	}



	public static ArrayList<Camion> getCamiones() {
		return camiones;
	}



	public static void setCamiones(ArrayList<Camion> camiones) {
		Camion.camiones = camiones;
	}



	public boolean isDisponibilidad() {
		return disponibilidad;
	}



	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
	
		
	}




