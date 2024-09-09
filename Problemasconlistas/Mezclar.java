import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Mezclar {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Por favor, proporcione dos listas de números separados por comas.");
            return;
        }

        // Parsear las listas de números de los argumentos
        List<Integer> lista1 = parsearLista(args[0]);
        List<Integer> lista2 = parsearLista(args[1]);

        // Combinar las listas
        List<Integer> resultado = merge(lista1, lista2);

        // Mostrar el resultado
        System.out.println(resultado);
    }

    // Método que combina dos listas ordenadas
    public static List<Integer> merge(List<Integer> lista1, List<Integer> lista2) {
        List<Integer> resultado = new ArrayList<>();
        int i = 0, j = 0;

        // Combinar los elementos de ambas listas en orden
        while (i < lista1.size() && j < lista2.size()) {
            if (lista1.get(i) <= lista2.get(j)) {
                resultado.add(lista1.get(i));
                i++;
            } else {
                resultado.add(lista2.get(j));
                j++;
            }
        }

        // Agregar los elementos restantes de la primera lista
        while (i < lista1.size()) {
            resultado.add(lista1.get(i));
            i++;
        }

        // Agregar los elementos restantes de la segunda lista
        while (j < lista2.size()) {
            resultado.add(lista2.get(j));
            j++;
        }

        return resultado;
    }

    // Método para convertir la cadena de números a una lista de enteros
    public static List<Integer> parsearLista(String cadena) {
        String[] partes = cadena.split(",");
        List<Integer> lista = new ArrayList<>();
        for (String parte : partes) {
            lista.add(Integer.parseInt(parte.trim()));
        }
        return lista;
    }
}

//para correr
// javac Mezclar.java
// java Mezclar "lista de numeros 1" "lista de numeros 2"
//ejemplo java Mezclar "3, 8, 15, 22" "4, 7, 14, 30"

