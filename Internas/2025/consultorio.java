//PROBLEMA F CONSULTÓRIO OFTALMOLÓGICO
import java.util.Scanner;

public class consultorio {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String entrada = scanner.nextLine();
        scanner.close();
        int count = 0;
        
        for(int x = 0; x < entrada.length(); x++){
            //int valorCaractere = (int) entrada.charAt(x);
            //if(valorCaractere == 1040) opção usando o valor númerico do caracter 
            if(entrada.charAt(x) == 'А') //'A' círico copiado do mapa de caracteres do windows Hexadeciaml: 0410 Decimal: 1040
                count++;
    }
    System.out.println(count);   

    }
}

