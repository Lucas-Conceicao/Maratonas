//PROBLEMA H NOTAS DO PROFESSOR
import java.util.ArrayList;
import java.util.Collections;
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
        scanner.close();
        Collections.sort(notas,Collections.reverseOrder()); //reserveOrder para ficar decrescente
        for (x = 0; x < notas.size(); x++) {
            System.out.print(notas.get(x)); // Imprime o número      
            if (x != (notas.size()) - 1) 
                System.out.print(" "); // Só imprime o espaço se não for o último numero
        }
        /* Usando o buble
        notas = bubbleSort(notas);
        for (x = notas.size() - 1; x >= 0; x--) { //imprimindo na ordem inversa
            System.out.print(notas.get(x)); // Imprime o número      
            if (x > 0) {
                System.out.print(" "); // Só imprime o espaço se 'x' (o índice) for maior que 0.
            }
        }*/
    }
    // Ordenação Manual com bubble
    /*public static List<Integer> bubbleSort(List<Integer> lista) {
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
    }*/ 
}