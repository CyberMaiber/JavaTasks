import java.util.Scanner;


public class program {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Введите порядковый номер треугольного числа для его вычисления: ");
        int nTriangle = in.nextInt();
        System.out.println("Искомое треугольное число: " + triangleNum(nTriangle));
    }
    
    public static int triangleNum(int nTr) {
        return nTr*(nTr + 1)/2;
    }

}