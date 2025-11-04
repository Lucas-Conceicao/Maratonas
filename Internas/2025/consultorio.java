//PROBLEMA F CONSULTÓRIO OFTALMOLÓGICO
import java.util.Scanner;

public class consultorio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String entrada = scanner.nextLine();
        int count = 0;
        
        for(int x = 0; x < entrada.length(); x++){
            if(isLatino(x, entrada) == false){
                count++;
            }
        }
        System.out.println(count);
    }

    public static boolean isLatino(int x, String consulta){
        int numCaracter = (int) consulta.charAt(x);
        return (numCaracter >= 65 && numCaracter <= 90) || (numCaracter >= 97 && numCaracter <= 122);
    }
}

