//PROBLEMA G SERPENTE DOURADA
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class serpente {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> anos = new ArrayList<>();
        int quant = scanner.nextInt(), x, count = 0;
        
        for(x = 0; x < quant; x++){
            anos.add(scanner.nextInt());
        }
        for(x = 0; x < anos.size(); x++){ 
            if(anos.get(x) % 7 == 2 && anos.get(x) % 12 == 9){// Ao dividir os anos sourados por 7 o resto é sempre 2 e ao dividir os anos da serpente por 12 o resto é sempre 9
                count++;
            }
        }
        scanner.close();
        System.out.println(count);
    }
}
