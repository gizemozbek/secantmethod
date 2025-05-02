import java.util.Scanner;

public class modifiedSecantMethod {
    
        public static void main(String[] args) {
            Scanner input = new Scanner(System.in);
            System.out.print("Başlangıç kök tahmini(x0) giriniz: ");

            double xr = input.nextDouble();
            System.out.print("Delta değerini giriniz: ");

            double delta = input.nextDouble();
            System.out.print("Yapılacak iterasyon sayısını giriniz: ");

            int iterSayisi = input.nextInt();
            System.out.println("\ni\t\tx_i\t\t\t\tf(x_i)\t\t\tx_i+δx_i\t\tf(x_i+δx_i)\t\tx_i+1\t\t\tEa(%)");
            System.out.println("----------------------------------------------------------------------------------------------------");

            for (int iter = 0; iter < iterSayisi; iter++) {
                double f = f(xr);
                double deltaXi = delta * xr;
                double xDelta = xr + deltaXi;
                double fDelta = f (xDelta);
                double xi1 = xr - (deltaXi * f) / (fDelta - f);
                double ea = (iter == 0) ? 100.0 : Math.abs((xi1 - xr) / xi1)*100;
                System.out.printf("%-6d\t%-12.8f\t%-12.8f\t%-12.8f\t%-12.8f\t%-12.8f\t%-12.8f\n", iter + 1, xr, f, xDelta, fDelta, xi1, ea);
                xr = xi1;
            }
            input.close();
        }
        public static double f(double x) {
            return Math.exp(-x)-x;
        }
    }

