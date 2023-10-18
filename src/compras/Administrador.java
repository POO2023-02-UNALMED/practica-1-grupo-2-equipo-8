package compras;

import java.util.HashMap;

import empresa.Camion;

public class Administrador {

    private Bodega Bodega;
    private Caja Caja;
    private HashMap<String, Integer> Productos = new HashMap<String, Integer>();
    private Camion Camion;
    private Fabrica Fabrica;

    public Administrador(compras.Bodega bodega, Caja caja, HashMap<String, Integer> productos, Camion camion, Fabrica fabrica) {
        Bodega = bodega;
        Caja = caja;
        Productos = productos;
        Camion = camion;
        Fabrica = fabrica;
    }

    //Getters y Setters
    public compras.Bodega getBodega() {
        return Bodega;
    }

    public void setBodega(compras.Bodega bodega) {
        Bodega = bodega;
    }

    public Caja getCaja() {
        return Caja;
    }

    public void setCaja(Caja caja) {
        Caja = caja;
    }

    public HashMap<String, Integer> getProductos() {
        return Productos;
    }

    public void setProductos(HashMap<String, Integer> productos) {
        Productos = productos;
    }

    public empresa.Camion getCamion() {
        return Camion;
    }

    public void setCamion(empresa.Camion camion) {
        Camion = camion;
    }

    public Fabrica getFabrica() {
        return Fabrica;
    }

    public void setFabrica(Fabrica fabrica) {
        Fabrica = fabrica;
    }

    //Metodos de la clase Administrador

    //iniciarSesion(): Metodo que se ejecuta cada vez que el Administrador inicie sesiòn en cada interacciòn que tenga con el software
    private static String iniciarSesion(){
        return "Iniciar Sesion";
    }

    //acabarSesion(): Metodo que se ejecuta cada vez que termine la interaccion del Administrador con el software
    private String acabarSesion(){
        return "Acabar Sesiòn";
    }
    
}


