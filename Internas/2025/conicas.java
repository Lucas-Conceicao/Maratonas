//PROBLEMA B CONICAS
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class conicas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String entrada = scanner.nextLine();

        //converte a String para uma Lista de Double
        List<Double> entradaDouble = toListDouble(entrada);

        //Coloca os valores nas letras
        double A = entradaDouble.get(0);
        double B = entradaDouble.get(1);
        double C = entradaDouble.get(2);
        double D = entradaDouble.get(3);
        double E = entradaDouble.get(4);
        double F = entradaDouble.get(5);

        //resultados das matrizes
        double d = calcD(A, B, C, D, E, F);
        double d33 = calcD33(A, B, C); 
        double d22 = calcD22(A, D, F);
        double d11 = calcD11(C, E, F);
        double t = A + C;

        System.out.println(verififacao(A, B, C, d, d11, d22, d33, t));
    }

    //Reutilizada do problema A computador
    public static List<Double> toListDouble(String entrada){
        List<Double> listDouble = new ArrayList<>();
        String aux = "";
        int x;

        for(x = 0; x < entrada.length();x++){
            if(entrada.charAt(x) == ','){
                listDouble.add(Double.valueOf(aux));
                aux = "";
            } 
            else
                aux = aux + entrada.charAt(x);
        }
        listDouble.add(Double.valueOf(aux));
        return listDouble;
    }

    public static double calcD(double A, double B, double C, double D, double E, Double F){
        double dp1, dp2, dp3, dn1, dn2, dn3, res; // dp(diagonal positiva) dn(diagonal negativa)

        dp1 = A * C * F;
        dp2 = (B/2) * (E/2) * (D/2);
        dp3 = (D/2) * (B/2) * (E/2);

        dn1 = (D/2) * C * (D/2);
        dn2 = A * (E/2) * (E/2);
        dn3 = (B/2) * (B/2) * F;

        res = (dp1 + dp2 + dp3) - (dn1 + dn2 + dn3);
        return res; 
    }

    public static Double calcD33(double A, double B, double C){ 
        double dp, dn, res;

        dp = A * C;
        dn = (B/2) * (B/2);
        res = dp - dn;
        return res;
    }

    public static Double calcD22(double A, double D, Double F){
        double dp, dn, res;

        dp = A * F;
        dn = (D/2) * (D/2);
        res = dp - dn;
        return res;
    }

    public static Double calcD11(double C, double E, Double F){
        double dp, dn, res;

        dp = C * F;
        dn = (E/2) * (E/2);
        res = dp - dn;
        return res;
    }

    public static String verififacao(double A, double B, double C, double d, double d11, double d22, double d33, double t){
        if(d33 > 0 && d != 0 && t*d > 0)
            return "Conjunto vazio";
        //usando .equals para comparar o valor vindo de dois objetos diferentes
        else if(d33 > 0 && d != 0 && t*d < 0 && A == C && B == 0) 
            return "Circunferencia";
        else if (d33 > 0 && d != 0 && t*d < 0) 
            return "Elipse";
        else if(d33 < 0 && d != 0)
            return "Hiperbole";
        else if(d33 > 0 && d == 0)
            return "Um ponto";
        else if(d33 < 0 && d == 0)
            return "Duas retas concorrentes";
        else if(d33 == 0 && d != 0)
            return "Parabola";
        else if(d33 == 0 && d == 0 && (d11 + d22) > 0)
            return "Conjunto vazio";
        else if(d33 == 0 && d == 0 && (d11 + d22) < 0)
            return "Duas retas paralelas";
        return "erro";
    }
}