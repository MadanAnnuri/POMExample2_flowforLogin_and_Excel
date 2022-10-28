import java.util.Scanner;

public class AreaRectangle {
    public static void main(String [] args){
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter length:");
         int length =sc.nextInt();
        System.out.println("Enter breadth:");
         int breadth = sc.nextInt();
         int area=length*breadth;
        System.out.println("area of a rectangle: "+area);
    }
}
