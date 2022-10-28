import java.util.Scanner;

public class AreaCircle {
    public static void main(String [] args){
        double pi=3.14;
        Scanner sc= new Scanner(System.in);
        System.out.println("Enter radius:");
         double radius =sc.nextDouble();
         double area=pi*radius*radius;
        System.out.println("area of a circle: "+area);
    }
}
