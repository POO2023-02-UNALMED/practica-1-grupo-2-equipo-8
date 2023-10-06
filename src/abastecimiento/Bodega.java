package abastecimiento;

import java.util.ArrayList;
import java.util.List;
import productos.Producto;

public class Bodega {
    private String idBodega;
    private String ciudad;
    private List<Producto> productosAlmacenados;
    private List<Materia_Prima> materiasPrimasAlmacenadas;

    public Bodega(String idBodega, String ciudad) {
        this.idBodega = idBodega;
        this.ciudad = ciudad;
        this.productosAlmacenados = new ArrayList<>();
    }

    // Métodos getter y setter
    public String getIdBodega() {
        return idBodega;
    }

    public void setIdBodega(String idBodega) {
        this.idBodega = idBodega;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }
    
    public List<Producto> getProductosAlmacenados() {
        return productosAlmacenados;
    }

    public void agregarProducto(Producto producto) {
        productosAlmacenados.add(producto);
    }

    public void quitarProducto(Producto producto) {
        productosAlmacenados.remove(producto);
    }
    
    public List<Materia_Prima> getMateriasPrimasAlmacenadas() {
        return materiasPrimasAlmacenadas;
    }

    public void agregarMateriaPrima(Materia_Prima materiaPrima) {
        materiasPrimasAlmacenadas.add(materiaPrima);
    }

    public void quitarMateriaPrima(Materia_Prima materiaPrima) {
        materiasPrimasAlmacenadas.remove(materiaPrima);
    }
}


