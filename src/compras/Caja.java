package compras;

import java.util.ArrayList;
import java.util.List;

public class Caja {
    private double dineroActual;
    private List<Double> preciosProductosCatalogo = new ArrayList<>();
    private List<Double> preciosIngredientesCatalogo = new ArrayList<>();
    private List<Double> preciosIngredientesNoUsados = new ArrayList<>();
    

    public Caja(double dineroActual, List<Double> preciosProductosCatalogo,List<Double> preciosIngredientesCatalogo,List<Double> preciosIngredientesNoUsados) {
       this.dineroActual=dineroActual;
       this.preciosProductosCatalogo=preciosProductosCatalogo;
       this.preciosIngredientesCatalogo=preciosIngredientesCatalogo ;
       this.preciosIngredientesNoUsados=preciosIngredientesNoUsados;  	
    }

    public  List<String> verHistorialDeCompras() {
        return null;
    }
    
    public void calcularRentabilidad() {
    	
    }
    
    public void agregarProductoCaja() {
    	
    }
    public void eliminarProductoCaja() {
    	
    }
    public void  venderIngredientes(){
    	
    }    
    public void calcularCostoProducto() {
    	
    }
    public void cantidadDineroAPedir() {
    
    }
    public  void descontarDinero(){
    	
    }    
    public void renegociacion() {
    	}
    public void sumarDineroCompra(List<Double> listaPrecios) {
    	
    }
    public  void generarCodigoCompra() {
    	
    }
    public void calcularCosto() {
    	
    }
    
    
    
    // Métodos getter y setter
	public double getDineroActual() {
		return dineroActual;
	}


	public void setDineroActual(double dineroActual) {
		this.dineroActual = dineroActual;
	}


	public List<Double> getPreciosProductosCatalogo() {
		return preciosProductosCatalogo;
	}


	public void setPreciosProductosCatalogo(List<Double> preciosProductosCatalogo) {
		this.preciosProductosCatalogo = preciosProductosCatalogo;
	}


	public List<Double> getPreciosIngredientesCatalogo() {
		return preciosIngredientesCatalogo;
	}


	public void setPreciosIngredientesCatalogo(List<Double> preciosIngredientesCatalogo) {
		this.preciosIngredientesCatalogo = preciosIngredientesCatalogo;
	}


	public List<Double> getPreciosIngredientesNoUsados() {
		return preciosIngredientesNoUsados;
	}


	public void setPreciosIngredientesNoUsados(List<Double> preciosIngredientesNoUsados) {
		this.preciosIngredientesNoUsados = preciosIngredientesNoUsados;
	}

    private ArrayList<String> VerHistorialCompras(){
        return null;
    }

    private void CalcularRentabilidad(){
        ;
    }

    private void AgregarProductoCaja(){
        ;
    }

    private void EliminarProducto(){
        ;
    }

    private void VenderIngrediente(){
        ;
    }

    private void CalcularCostoProductoNuevo(){
        ;
    }

    private void CantidadDineroAPedir(){
        ;
    }

    private void DescontarDinero(){
        ;
    }

    private void Renegociacion() {
        ;
    }

    private void SumarDineroCompra(){
        ;
    }

    private void GenerarCodigoCompra(){
        ;
    }

    private void CalcularCosto(){
        ;
    }
}
