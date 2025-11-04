//PROBLEMA H NOTAS DO PROFESSOR
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class notas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> notas = new ArrayList<>();
        int monitores = scanner.nextInt(), x, y, quantNotas;
        
        for(x = 0; x < monitores;x++){
            quantNotas = scanner.nextInt();
            for (y = 0; y < quantNotas; y++) {  
                notas.add(scanner.nextInt());
            }
        }
        notas = bubbleSort(notas);
        for (x = notas.size() - 1; x >= 0; x--) {
            System.out.print(notas.get(x) + " ");
        }
    }

    public static List<Integer> bubbleSort(List<Integer> lista) {
        int aux, i, j, tamanho = lista.size() - 1;
        for(i = 0; i < tamanho; i++){
            for(j = 0; j < tamanho - i; j++){
                if(lista.get(j) > lista.get(j + 1)){
                    aux = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, aux);
                }
            }
        }
        return lista;
    }
}