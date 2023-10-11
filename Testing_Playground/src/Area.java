public class Area{
    public static double getArea(double radius){
        return Math.PI * Math.pow(radius, 2);
    }
    
    public static double getArea(double l, double w){
        return l * w;

    }
    
    public static double getArea(double b1, double b2,
                                double height){
        return (b1 + b2) * height/2;
    }
    
    public static void main(String[] args){
        getArea(3);
        getArea(2, 4);
        getArea(3, 4, 5);
    }
}