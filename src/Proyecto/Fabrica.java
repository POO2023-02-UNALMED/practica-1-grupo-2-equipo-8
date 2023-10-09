package Proyecto;

import productos.Producto;

import java.util.List;
import java.util.ArrayList;


public class Fabrica {
	private Bodega bodega;
	private List<Producto> ListaDeProductosDiarios = new ArrayList<Producto>();
	
	

	public Fabrica(Bodega bodega, List<Producto> ListaDeProductosDiarios) {
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

	public List<Producto> getListaDeProductosDiarios() {
		return ListaDeProductosDiarios;
	}

	public void setListaDeProductosDiarios(List<Producto> listaDeProductosDiarios) {
		ListaDeProductosDiarios = listaDeProductosDiarios;
	}


	
}
