//PROBLEMA D DESCENDENTES
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class descendentes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int linhas = scanner.nextInt(), x;
        List<Integer> genitor = new ArrayList<>(), descendente = new ArrayList<>();

        for(x = 0; x < linhas; x++){
            genitor.add(scanner.nextInt()); //lista de genitores
            descendente.add(scanner.nextInt()); //lista de descendetes
        }
        int escolhido = scanner.nextInt();
        scanner.close();
        System.out.println(verificarDescendentes(escolhido, genitor, descendente));

    }

    public static int verificarDescendentes(int pessoa, List<Integer> genitor, List<Integer> descendente){
        int count = 0, x;

        for(x = 0; x < genitor.size();x++){
            if(genitor.get(x) == pessoa){
                int filho = descendente.get(x);
                count++;
                count = count + verificarDescendentes(filho, genitor, descendente); // chama recursivamente o filho direto, depois os filhos dele e assim sucesivamente. Voltando para o for anterior ao finalizar o loop;
            }
        }
        return count;
    }
}