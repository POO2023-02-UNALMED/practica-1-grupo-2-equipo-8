package baseDeDatos;

import gestorAplicacion.empresa.Ingrediente;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializadorIngredientes {

    //Se añaden los ingredientes al Fichero ficheroIngrediente.txt mediante Serializador
    private FileOutputStream fileOutputStream; //Se establece el atributo fileOutputStream
    private final String DIR = "ficheroIngrediente.txt";

    public SerializadorIngredientes() throws FileNotFoundException {

        //Se crea el archivo fichero
        fileOutputStream = new FileOutputStream(DIR);
    }

    //Funcion Agregar Ingredientes
    public void agregarIngrediente(Ingrediente ingrediente) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

        //Escribe cada ingrediente en el fichero "ficheroIngrediente.txt"
        objectOutputStream.writeObject(ingrediente);

        //Cierra el flujo al fichero "ficheroIngrediente.txt"
        objectOutputStream.close();
    }

    public void eliminarIngrediente(Ingrediente ingrediente){
        ;
    }


    //Pero solo se imprime el primer ingrediente y sus datos
		/*FileInputStream fileInputStream = new FileInputStream("ficheroIngrediente.txt");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		Ingrediente ingredienteEnFichero = (Ingrediente) objectInputStream.readObject();
		objectInputStream.close();
		System.out.println(ingredienteEnFichero); */
}
