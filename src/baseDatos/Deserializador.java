package baseDatos;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.security.GeneralSecurityException;
import java.util.ArrayList;

import gestorAplicacion.producto.Producto;
import gestorAplicacion.empresa.*;

public class Deserializador {
    static File archivo = new File("");

    public static ArrayList<?> deserializar(String fileName) {
        try {
            FileInputStream file = new FileInputStream(new File(archivo.getAbsolutePath() +
                    "\\src\\baseDatos\\temp\\" + fileName));
            ObjectInputStream o = new ObjectInputStream(file);

            ArrayList<?> lista = (ArrayList<?>) o.readObject();

            file.close();
            o.close();
            
            return lista;

        } catch (FileNotFoundException e) {
            return new ArrayList<>();
        } catch (IOException e) {
            return new ArrayList<>();
        } catch (ClassNotFoundException e) {
            return new ArrayList<>();
        }
    }
    
    public static ArrayList<Producto> deserializarProductos(){
    	ArrayList<Producto> listaProductos = (ArrayList<Producto>) deserializar("productos.txt");
    	return listaProductos;
    }
    
    public static ArrayList<Ingrediente> deserializarIngredientes(){
    	ArrayList<Ingrediente> listaIngredientes = (ArrayList<Ingrediente>) deserializar("ingredientes.txt");
    	return listaIngredientes;
    }
    
    // Caso especial administrador debido a que solo se va utilizar un unico usuario que administre el sistema
    public static Administrador deserializarAdministrador(){
    	ArrayList<Administrador> lista = (ArrayList<Administrador>) deserializar("administrador.txt");
    	return lista.size() != 0 ? lista.get(0) : null;
    }
    
    public static ArrayList<Bodega> deserializarBodegas(){
    	ArrayList<Bodega> listaBodega = (ArrayList<Bodega>) deserializar("bodegas.txt");
    	return listaBodega;
    }
    
    public static ArrayList<Caja> deserializarCajas(){
    	ArrayList<Caja> listaCaja = (ArrayList<Caja>) deserializar("cajas.txt");
    	return listaCaja;
    }
    
    public static ArrayList<Camion> deserializarCamiones(){
    	ArrayList<Camion> listaCamiones = (ArrayList<Camion>) deserializar("camiones.txt");
    	return listaCamiones;
    }
    
    public static ArrayList<Envio> deserializarEnvios(){
    	ArrayList<Envio> listaEnvios = (ArrayList<Envio>) deserializar("envios.txt");
    	return listaEnvios;
    }
    
    public static ArrayList<Fabrica> deserializarFabricas(){
    	ArrayList<Fabrica> listaFabrica = (ArrayList<Fabrica>) deserializar("fabricas.txt");
    	return listaFabrica;
    }
}
