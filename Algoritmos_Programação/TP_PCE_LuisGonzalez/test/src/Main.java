import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
public class Main {
    public static void main(String[] args) {
         // ArrayLists relacionados
                ArrayList<String> nombres = new ArrayList<>();
                ArrayList<Integer> edades = new ArrayList<>();
                ArrayList<String> ciudades = new ArrayList<>();

                // Agregar datos
                nombres.add("Luis");
                nombres.add("Ana");
                nombres.add("Carlos");
                nombres.add("Beatriz");

                edades.add(25);
                edades.add(20);
                edades.add(30);
                edades.add(22);

                ciudades.add("Madrid");
                ciudades.add("Lisboa");
                ciudades.add("Barcelona");
                ciudades.add("Porto");

                // Imprimir antes de ordenar
                System.out.println("Antes de ordenar:");
                imprimirDatos(nombres, edades, ciudades);

                // Ordenar basándonos en el ArrayList 'edades'
                ArrayList<Integer> indices = new ArrayList<>();
                for (int i = 0; i < edades.size(); i++) {
                    indices.add(i);
                }

                // Ordenar índices según los valores en 'edades'
                Collections.sort(indices;

                // Crear nuevas listas ordenadas
                ArrayList<String> nombresOrdenados = new ArrayList<>();
                ArrayList<Integer> edadesOrdenadas = new ArrayList<>();
                ArrayList<String> ciudadesOrdenadas = new ArrayList<>();

                for (int index : indices) {
                    nombresOrdenados.add(nombres.get(index));
                    edadesOrdenadas.add(edades.get(index));
                    ciudadesOrdenadas.add(ciudades.get(index));
                }

                // Imprimir después de ordenar
                System.out.println("\nDespués de ordenar:");
                imprimirDatos(nombresOrdenados, edadesOrdenadas, ciudadesOrdenadas);
            }

            // Método auxiliar para imprimir datos
            public static void imprimirDatos(ArrayList<String> nombres, ArrayList<Integer> edades, ArrayList<String> ciudades) {
                for (int i = 0; i < nombres.size(); i++) {
                    System.out.println(nombres.get(i) + " - " + edades.get(i) + " - " + ciudades.get(i));
                }
            }


    }
