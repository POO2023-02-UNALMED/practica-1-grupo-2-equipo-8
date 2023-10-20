package baseDeDatos;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class SerializadorEnvio {

    private FileOutputStream fileOutputStream; //Se establece el atributo fileOutputStream
    private final String DIR = "ficheroEnvio.txt";

    public SerializadorEnvio() throws FileNotFoundException {

        //Se crea el archivo fichero ficheroEnvio.txt
        fileOutputStream = new FileOutputStream(DIR);

    }
}
