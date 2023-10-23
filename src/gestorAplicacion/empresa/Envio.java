package gestorAplicacion.empresa;

import gestorAplicacion.producto.Producto;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Envio implements Serializable {
	
	private long codigoDeEnvio;
	private Camion camionAsignado;
	private List<Producto> productos=new ArrayList<Producto>();
	private int pesoTotal;
	private Caja caja;
	private boolean asignadoAUnCamion=false;
	private static List<Envio> listaEnvios = new ArrayList<Envio>();
	private Bodega bodega;

	//	Constructor	
	 public Envio(int codigoDeEnvio, List<Producto> productos, Caja caja,Bodega bodega) {
		 	int pesoTotal = 0;
		 	this.bodega=bodega;
	        this.codigoDeEnvio = codigoDeEnvio;
	        this.productos = productos;
	        this.caja = caja;
	        for (Producto producto:productos) {
	        	producto.setAsignadoAEnvio(true);//Todos los prodctos aquí ya estara asignados
	        	this.bodega.getProductos().remove(producto);//se eliminan estos productos de bodega
	        	//Se le resta uno a la cantidad de este producto
	        	int valorActual=this.bodega.getContabilidadProductos().get(producto.getNombre());
	        	String clave=producto.getNombre();
	        	this.bodega.getContabilidadProductos().put(clave, valorActual-1);
	        	//Agregamos venta al historial de ventas
	        	Caja.agregarVenta(producto.getNombre(), 1);
	        	Caja.ingresarDinero(producto.getPrecio());
	        }
	        //se suma el dinero del envio a caja
	        
	        for(Producto producto:productos) {
	        	pesoTotal+=producto.getPeso();
	        }
	        this.pesoTotal = pesoTotal;
	        Envio.listaEnvios.add(this);
	        //Los envios deben de efectuar cambios en bodega y caja
	        
	        
	       
	    }
	 //Devuelve aquellos envios que no han sido asignados importates para la funcionalidad5
	 public static String enviosPorAsignar() {
		    StringBuilder result = new StringBuilder();
		    int numeracion = 1;

		    for (Envio envio : listaEnvios) {
		        if (!envio.isAsignadoAUnCamion()) {
		            result.append(numeracion).append(". Envío con código ").append(envio.getCodigoDeEnvio())
		                  .append(", con un peso de ").append(envio.getPesoTotal()).append("\n");
		            numeracion++;
		        }
		    }

		    return result.toString();
		}

	 //Añade un producto al envio con sus repercuciones en bodega y en caja
	 public void anadirProducto(Producto producto) {
		 this.productos.add(producto);
		 this.pesoTotal+=producto.getPeso();
		 this.getCaja().ingresarDinero(producto.getPrecio());
		 this.bodega.getProductos().remove(producto);
		 int valorActual=this.bodega.getContabilidadProductos().get(producto.getNombre());
      	 String clave=producto.getNombre();
     	 this.bodega.getContabilidadProductos().put(clave, valorActual-1);
     	 this.caja.agregarVenta(producto.getNombre(), 1);
	 }
	//Elimina un producto al envio con sus repercuciones en bodega y en caja
	 public void eliminarProducto(Producto producto) {
		 if (this.productos.contains(producto)){
			 this.productos.remove(producto);
			 this.pesoTotal-=producto.getPeso();
			 this.getCaja().restarDinero(producto.getPrecio());
			 this.bodega.getProductos().add(producto);
			 int valorActual=this.bodega.getContabilidadProductos().get(producto.getNombre());
	      	 String clave=producto.getNombre();
	     	 this.bodega.getContabilidadProductos().put(clave, valorActual+1);
	     	 this.caja.eliminarVenta(producto.getNombre(), 1);
			 
			 
		 }
	 }
	 
//	 Getters y Setters
	 
	public long getCodigoDeEnvio() {
		return codigoDeEnvio;
	}
	public Camion getCamionAsignado() {
		return camionAsignado;
	}
	public List<Producto> getProductos() {
		return productos;
	}
	public int getPesoTotal() {
		return pesoTotal;
	}
	public Caja getCaja() {
		return caja;
	}
	public void setCodigoDeEnvio(int codigoDeEnvio) {
		this.codigoDeEnvio = codigoDeEnvio;
	}
	public void setCamionAsignado(Camion camionAsignado) {
		this.camionAsignado = camionAsignado;
	}
	public void setProductos(List<Producto> productos) {
		this.productos = productos;
	}
	public void setPesoTotal(int pesoTotal) {
		this.pesoTotal = pesoTotal;
	}
	public void setCaja(Caja caja) {
		this.caja = caja;
	}

	public boolean isAsignadoAUnCamion() {
		return asignadoAUnCamion;
	}

	public void setAsignadoAUnCamion(boolean asignadoAUnCamion) {
		this.asignadoAUnCamion = asignadoAUnCamion;
	}

	public static List<Envio> getListaEnvios() {
		return listaEnvios;
	}

	public static void setListaEnvios(List<Envio> listaEnvios) {
		Envio.listaEnvios = listaEnvios;
	}
	 
	 
	 
	 
	 
}
