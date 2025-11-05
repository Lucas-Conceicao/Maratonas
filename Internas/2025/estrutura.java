//PROBLEMA C ADIVINHE A ESTRUTURA
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class estrutura {
    private static Stack<Integer> pilha = new Stack<>();
    private static LinkedList<Integer> fila = new LinkedList<>();
    private static PriorityQueue<Integer> priority = new PriorityQueue<>(Collections.reverseOrder()); //Collections.reverseOrder() faz com que a prioridade seja invetida pegando maior elemento e não o menor 
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int linhas = scanner.nextInt();
        boolean isPilha = true;
        boolean isFila = true;
        boolean isPriority = true;
        
        for(int x = 0; x < linhas; x++){
            int operacao = scanner.nextInt();
            int num = scanner.nextInt();
            if(operacao == 1){
                pilha.add(num);
                fila.add(num);
                priority.add(num);
            }
            else{   
                if (isPilha) isPilha = verficaPilha(operacao, num);
                if (isFila) isFila = verficaFila(operacao, num);
                if (isPriority) isPriority = verficaPriority(operacao, num);
            }
        }

        int count = 0;
        if(isPilha) count++;
        if(isFila) count++;
        if(isPriority) count++;

        if(count > 1) System.out.print("inconclusivo");
        else if(count == 0) System.out.print("nenhum");
        else{
            if(isPilha) System.out.print("pilha");
            else if(isFila) System.out.print("fila");
            else System.out.print("fila de prioridade");
        }
    }

    public static boolean verficaPilha(int operacao, int num) { //FILO 
        if(pilha.isEmpty() == true)
            return false;
        return pilha.pop() == num;
    }

    public static boolean verficaFila(int operacao, int num) { //FIFO
         if(fila.isEmpty() == true)
            return false;
        return fila.poll() == num;
    }

    public static boolean verficaPriority(int operacao, int num) {
        if(priority.isEmpty() == true)
            return false;
        return priority.poll() == num;
    }
}