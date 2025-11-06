//PROBLEMA A COMPUTADOR INTCODE
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class computador {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String entrada = scanner.nextLine();
        List<Integer> entradaInt = toListInteger(entrada);
        int res = 0;
        res = calculos(entradaInt);
        System.out.println(res);
    }

    public static List<Integer> toListInteger(String entrada){
        List<Integer> listInteger = new ArrayList<>();
        String aux = "";
        int x;

        for(x = 0; x < entrada.length();x++){
            if(entrada.charAt(x) == ','){
                listInteger.add(Integer.valueOf(aux));
                aux = "";
            }
            else
                aux = aux + entrada.charAt(x);
        }
        listInteger.add(Integer.valueOf(aux));
        return listInteger;
    }

    public static int calculos(List<Integer> entradaInt){
        int res;
        int posicao;
        
        try{
        for(int i = 0; i <entradaInt.size(); i = i + 4){ //vai direto nos opcodes
            if(entradaInt.get(i) == 1){
                res = entradaInt.get(entradaInt.get(i + 1)) + entradaInt.get(entradaInt.get(i + 2));
                posicao = entradaInt.get(i + 3);
                entradaInt.set(posicao, res);
            }
            else if(entradaInt.get(i) == 2){
                res = entradaInt.get(entradaInt.get(i + 1)) * entradaInt.get(entradaInt.get(i + 2));
                posicao = entradaInt.get(i + 3);
                entradaInt.set(posicao, res);
            }
            else if(entradaInt.get(i) == 99 ){
                return entradaInt.get(0);
            }
            else{
                return -1;
            }
        }
        }catch(IndexOutOfBoundsException e){
            return -1; //validação se apontar para um índice inexistente
        }

        return -1;
    }
}