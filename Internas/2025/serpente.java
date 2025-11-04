//PROBLEMA G SERPENTE DOURADA
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class serpente {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> anos = new ArrayList<>();
        int quant = scanner.nextInt(), x;
        
        for(x = 0; x < quant; x++){
            anos.add(scanner.nextInt());
        }
        System.out.println(verifcarAno(anos));
    }

    public static int verifcarAno(List<Integer> anos){
        int count = 0;
        for(int x = 0; x < anos.size(); x++){
            if(anos.get(x) % 7 == 2 && anos.get(x) % 12 == 9){
                count++;
            }
        }
        return count;
    }
}
