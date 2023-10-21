package gestorAplicacion.empresa;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.ArrayList;

public class Camion implements Serializable {
	private String marca;
	private String modelo;
	private int capacidad;
	private String placa;
	private List<Envio> envios = new ArrayList<Envio>();
	private static List<Camion> camiones =new ArrayList<Camion>();
	private boolean disponibilidad= true;
	
	
	public Camion(String marca, String modelo, int capacidad) {
		this.marca=marca;
		this.modelo=modelo;
		this.capacidad=capacidad;
		this.camiones.add(this);
		//No se agregan envios dado que esto se hará desde la funcionalidad 5 de administrador
		
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
		return camiones;
	}



	public static void setCamiones(List<Camion> camiones) {
		Camion.camiones = camiones;
	}



	public boolean isDisponibilidad() {
		return disponibilidad;
	}



	public void setDisponibilidad(boolean disponibilidad) {
		this.disponibilidad = disponibilidad;
	}
	
	
		
	}




