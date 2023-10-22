package baseDatos;

import gestorAplicacion.empresa.Fabrica;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;


public class SerializadorFabrica {

    //Se añaden los datos al Fichero ficheroFabrica.txt mediante Serializador
    private FileOutputStream fileOutputStream; //Se establece el atributo fileOutputStream
    private final String DIR = "ficheroFabrica.txt";

    public SerializadorFabrica() throws FileNotFoundException {

        //Se crea el archivo fichero
        fileOutputStream = new FileOutputStream(DIR);
    }

}
