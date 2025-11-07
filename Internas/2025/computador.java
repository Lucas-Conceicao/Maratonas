//PROBLEMA A COMPUTADOR INTCODE
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class computador {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String entrada = scanner.nextLine();
        scanner.close();
        List<Integer> entradaInt = toListInteger(entrada);
        int res = 0;
        res = calculos(entradaInt);
        System.out.println(res);
    }

    public static List<Integer> toListInteger(String entrada){
        List<Integer> listInteger = new ArrayList<>();
        String aux = "";
        int x;

        for(x = 0; x < entrada.length(); x++){
            if(entrada.charAt(x) == ','){ //A ","não é adicionada a String, ela serve como gatilho
                listInteger.add(Integer.valueOf(aux));//Converte a String em um número inteiro e o adicona na lista
                aux = ""; //reseta o valor da String
            }
            else
                aux = aux + entrada.charAt(x); //Adiciona os caracteres a String até chegar em uma ","
        }
        listInteger.add(Integer.valueOf(aux)); //Adiciona o último número já que não há "," após ele
        return listInteger;
    }

    public static int calculos(List<Integer> entradaInt){
        int res;
        
        try{
        for(int i = 0; i <entradaInt.size(); i = i + 4){ //vai direto nos opcodes
            if(entradaInt.get(i) == 1){ //Se for 1 soma
                res = entradaInt.get(entradaInt.get(i + 1)) + entradaInt.get(entradaInt.get(i + 2));//soma os valores que estão presentes nos índices que correspondem ao 1° e ao 2° número após o upcode
                entradaInt.set(entradaInt.get(i + 3), res); //Colocar o resultado no 3º número após o opcode
            }
            else if(entradaInt.get(i) == 2){ //Se for dois multiplica
                res = entradaInt.get(entradaInt.get(i + 1)) * entradaInt.get(entradaInt.get(i + 2));//Faz o mesmo que o de cima, mudando apenas a operação
                entradaInt.set(entradaInt.get(i + 3), res); 
            }
            else if(entradaInt.get(i) == 99 ){
                return entradaInt.get(0);
            }
            else{
                return -1; //O número não pode ser difeente de 1, 2 e 99
            }
        }
        }catch(IndexOutOfBoundsException e){
            return -1; //validação se apontar para um índice inexistente
        }

        return -1; //Se sair do loop deu algum erro
    }
}