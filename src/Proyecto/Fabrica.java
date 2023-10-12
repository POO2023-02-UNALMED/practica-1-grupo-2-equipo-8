package Proyecto;

import java.util.ArrayList;
import java.util.List;


public class Fabrica {
	private Bodega bodega;
	private List<Productos> ListaDeProductosDiarios = new ArrayList<Productos>();
	
	
	public Fabrica(Bodega bodega, List<Productos> ListaDeProductosDiarios) {
		this.bodega = bodega;
		this.ListaDeProductosDiarios = ListaDeProductosDiarios;
	}
	
	public void eliminarProductoFabrica() {
		
	}
	
	public void agregarProductoNuevoFabrica() {
		
	}
	public void agregarIngredienteNuevoFabrica() {
		
	}
	public void establecerTiempoDemora() {
		
	}
	public void pausarProduccion() {
		
	}
	public String generarCodigoTanda() {
        return null;
    }
//	Getters y Setters

	public Bodega getBodega() {
		return bodega;
	}

	public void setBodega(Bodega bodega) {
		this.bodega = bodega;
	}

	public List<Productos> getListaDeProductosDiarios() {
		return ListaDeProductosDiarios;
	}

	public void setListaDeProductosDiarios(List<Productos> listaDeProductosDiarios) {
		ListaDeProductosDiarios = listaDeProductosDiarios;
	}


	
}
