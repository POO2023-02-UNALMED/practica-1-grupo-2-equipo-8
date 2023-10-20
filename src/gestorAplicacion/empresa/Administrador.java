package gestorAplicacion.empresa;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Scanner;

public class Administrador implements Serializable {

    private Bodega Bodega;
    private Caja Caja;
    private HashMap<String, Integer> Productos ;
    private Camion Camion;
    private Fabrica Fabrica;


    public Administrador() {
        Bodega = new Bodega();
        Caja = new Caja();
        //Productos = Producto.  Implementar metodo de clase ObtenerProductos;
        Camion = new Camion();
        //Fabrica = new Fabrica(); Implementar dependiendo de Decision de Fabrica

    }

    //Getters y Setters
    public Bodega getBodega() {
        return Bodega;
    }

    public void setBodega(Bodega bodega) {
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

    public Camion getCamion() {
        return Camion;
    }

    public void setCamion(Camion camion) {
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

        //public static void iniciarSesion(String[] args){}

        //while

        //Se crea un objeto Scanner para leer la respuesta del usuario al mensaje a continuacion
        Scanner numero = new Scanner(System.in);

        //Mensaje inicial del Software, dando la bienvenida al Administrador y dandole las opciones disponibles a elegir mediante numeros (del 1 al 5)
        System.out.println("Bienvenido a Alimentos Delihorno. ¿Que desearìa hacer el dìa de hoy?:" + "\n" + "1. Comprar Materia Prima" + "\n"
        + "2. Venta Por Encargo" + "\n" + "3. Cambiar Lista de Produccion Diaria" + "\n" + "4. Agregar Producto" + "\n" + "5. Eliminar Producto");

        //Se lee la respuesta del usuario al mensaje anterior
        int opcionElegida = numero.nextInt(); 

        //De acuerdo al valor Integer de opcionElegida, se elige ejecutar uno de los metodos a continuacion
        if (opcionElegida == 1){

        } else if(opcionElegida == 2){

        } else if(opcionElegida == 3){

        } else if (opcionElegida == 4){

            //Metodo de clase
            //Producto.MostrarProductos();


        } else if (opcionElegida == 5){

            //Metodo de clase
            //Producto.MostrarProductos();

        };

        //Retorno a eliminarse cuando se corrija el codigo
        return null;
    }

    //acabarSesion(): Metodo que se ejecuta cada vez que termine la interaccion del Administrador con el software
    private String acabarSesion(){

        //Mensaje de despedida
        return "Muchas gracias por usar el software de DeliHorno. Que tenga un feliz dia.";
    }

}


