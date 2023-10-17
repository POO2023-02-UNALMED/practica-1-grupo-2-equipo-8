package empresa;
import java.util.ArrayList;
import java.util.List;


public class Camion {
	private String marca;
	private String modelo;
	private int caparcidad;
	private List<Envio> envios = new ArrayList<Envio>();
	private String placa;
	
	
	public void agregarEnvio(Envio envio) {
		if (this.envios.contains(envio)||envio.isAsignadoAUnCamion()) {
		return;	
		}
		this.envios.add(envio);
		this.caparcidad-=envio.getPesoTotal();
		envio.setAsignadoAUnCamion(true);
		
		
	}
	
	public void eliminarEnvio(Envio envio) {
		if (this.envios.contains(envio)) {
			this.envios.remove(envio);
			this.caparcidad+=envio.getPesoTotal();
			envio.setAsignadoAUnCamion(false);
			
		}
	}
	

}
