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
		System.out.println(Ingrediente.obtenerListaIngredientes());

		//Fichero ingrediente1 Serializador
		/*FileOutputStream fileOutputStream = new FileOutputStream("ficheroFabrica.txt");
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
		objectOutputStream.writeObject(ingrediente1);
		objectOutputStream.close();

		//Fichero ingrediente1 Deserializador
		FileInputStream fileInputStream = new FileInputStream("ficheroFabrica.txt");
		ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
		Ingrediente ingredienteEnFichero = (Ingrediente) objectInputStream.readObject();
		objectInputStream.close();
		System.out.println(ingredienteEnFichero); */
	}

}
