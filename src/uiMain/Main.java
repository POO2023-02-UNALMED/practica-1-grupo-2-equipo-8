package uiMain;

import gestorAplicacion.empresa.Ingrediente;

import java.io.*;

public class Main {

	public static void main(String[] args) throws IOException, ClassNotFoundException {

//		Instanciamos ingredientes
		
		Ingrediente ingrediente1 = new Ingrediente("Harina", 5, 1, 500, "01/01/2024");
		Ingrediente ingrediente2 = new Ingrediente("Azúcar", 3, 2, 300, "01/01/2023");
		Ingrediente ingrediente3 = new Ingrediente("Levadura", 2, 3, 100, "01/01/2023");
		Ingrediente ingrediente4 = new Ingrediente("Sal", 1, 4, 200, "01/01/2025");
		Ingrediente ingrediente5 = new Ingrediente("Mantequilla", 4, 5, 250, "01/01/2023");
		Ingrediente ingrediente6 = new Ingrediente("Huevos", 2, 6, 100, "01/01/2023");
		Ingrediente ingrediente7 = new Ingrediente("Chocolate", 6, 7, 150, "01/01/2023");
		Ingrediente ingrediente8 = new Ingrediente("Canela", 3, 8, 50, "01/01/2024");
		Ingrediente ingrediente9 = new Ingrediente("Vainilla", 5, 9, 50, "01/01/2023");
		Ingrediente ingrediente10 = new Ingrediente("Nuez", 4, 10, 200, "01/01/2024");

		//Se imprime cada ingrediente con su respectiva informacion
		System.out.println(Ingrediente.obtenerListaIngredientes());

		//Se añaden los ingredientes al Fichero ficheroIngrediente.txt mediante Serializador
		FileOutputStream fileOutputStream = new FileOutputStream("ficheroIngrediente.txt");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(ingrediente1);
		objectOutputStream.writeObject(ingrediente2);
		objectOutputStream.writeObject(ingrediente3);
		objectOutputStream.writeObject(ingrediente4);
		objectOutputStream.writeObject(ingrediente5);
		objectOutputStream.writeObject(ingrediente6);
		objectOutputStream.writeObject(ingrediente7);
		objectOutputStream.writeObject(ingrediente8);
		objectOutputStream.writeObject(ingrediente9);
		objectOutputStream.writeObject(ingrediente10);
		objectOutputStream.close();

		//Se busca imprimir la lista de Ingredientes de ficheroIngrediente.txt
		//Pero solo se imprime el primer ingrediente y sus datos
		/*FileInputStream fileInputStream = new FileInputStream("ficheroIngrediente.txt");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		Ingrediente ingredienteEnFichero = (Ingrediente) objectInputStream.readObject();
		objectInputStream.close();
		System.out.println(ingredienteEnFichero); */

	}

}
