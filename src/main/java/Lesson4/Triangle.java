package Lesson4;

public class Triangle {

    public static double calcTriangleArea(double a, double b, double c) throws Exception {
        if(a <= 0 || b <= 0 || c <= 0){
            throw new Exception("Стороны треугольника не могут быть меньше или равным 0");
        }
        double p = (a+b+c) / 2;
        double s = Math.sqrt(p * (p-a) *(p-b)*( p-c ));
        return s;
    }

}
