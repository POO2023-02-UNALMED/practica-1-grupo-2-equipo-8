package gestorAplicacion.empresa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;

public class Camion implements Serializable {
	//Atributos
	private String marca;
	private String modelo;
	private int capacidad;
	private String placa;
	private List<Envio> envios = new ArrayList<Envio>();
	private static List<Camion> camionesNoasignados =new ArrayList<Camion>();
	private static List<Camion> camionesAsignados =new ArrayList<Camion>();
	private boolean disponibilidad= true;
	
	//Constructor
	public Camion(String marca, String modelo, int capacidad, String placa) {
		this.marca=marca;
		this.modelo=modelo;
		this.capacidad=capacidad;
		Camion.camionesNoasignados.add(this);
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

	    for (Camion camion : camionesNoasignados) {
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



	public void setMarca(String marca) {
		this.marca = marca;
	}



	public String getModelo() {
		return modelo;
	}



	public void setModelo(String modelo) {
		this.modelo = modelo;
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



	public void setPlaca(String placa) {
		this.placa = placa;
	}



	public List<Envio> getEnvios() {
		return envios;
	}



	public void setEnvios(List<Envio> envios) {
		this.envios = envios;
	}



	public static List<Camion> getCamiones() {
		return camionesNoasignados;
	}



	public static void setCamiones(List<Camion> camiones) {
		Camion.camionesNoasignados = camiones;
	}



	public boolean isDisponibilidad() {
		return disponibilidad;
	}



	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}


	public static List<Camion> getCamionesNoasignados() {
		return camionesNoasignados;
	}


	public static void setCamionesNoasignados(List<Camion> camionesNoasignados) {
		Camion.camionesNoasignados = camionesNoasignados;
	}


	public static List<Camion> getCamionesAsignados() {
		return camionesAsignados;
	}


	public static void setCamionesAsignados(List<Camion> camionesAsignados) {
		Camion.camionesAsignados = camionesAsignados;
	}
	
	
		
	}
