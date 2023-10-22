package baseDatos;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import gestorAplicacion.empresa.*;
import gestorAplicacion.producto.Producto;

public class Serializador {
    static File archivo = new File("");
    
    private static String serializar(ArrayList<?> lista, String nombreArchivo) {
    	try {
            FileOutputStream f = new FileOutputStream(new File(archivo.getAbsolutePath()+
                    "\\src\\baseDatos\\temp\\" + nombreArchivo));
            ObjectOutputStream o = new ObjectOutputStream(f);

            o.writeObject(lista);

            o.close();
            f.close();
            return "La serialización se ha completado correctamente.";

        }catch(FileNotFoundException e){
            return "Archivo no encontrado: "+ e.getMessage();
        }
        catch(IOException e) {
            return "Error de flujo de inicializacion: " + e.getMessage();
        }
    };
    
    public static String serializarProductos(ArrayList<Producto> lista) {
        return serializar(lista, "productos.txt");
    }
    
    public static String serializarIngredientes(ArrayList<Ingrediente> lista) {
        return serializar(lista, "ingredientes.txt");
    }
    
    public static String serializarAdministrador(Administrador administrador) {
    	ArrayList<Administrador> lista = new ArrayList<Administrador>();
    	lista.add(administrador);
        return serializar(lista, "administrador.txt");
    }
    
    public static String serializarBodegas(ArrayList<Bodega> lista) {
        return serializar(lista, "bodegas.txt");
    }
    
    public static String serializarCajas(ArrayList<Caja> lista) {
        return serializar(lista, "cajas.txt");
    }
    
    public static String serializarCamiones(ArrayList<Camion> lista) {
        return serializar(lista, "camiones.txt");
    }
    
    public static String serializarEnvios(ArrayList<Envio> lista) {
        return serializar(lista, "envios.txt");
    }
    
    public static String serializarFabricas(ArrayList<Fabrica> lista) {
        return serializar(lista, "fabricas.txt");
    }
}