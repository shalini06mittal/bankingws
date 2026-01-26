package oops.project1_exception;

class AEx extends  Exception{

    public AEx(String message) {
        super(message);
    }
}
public class Demo {
    public static void calculate(int no) throws AEx
    {
        if(no<1)
            throw new AEx("No cannot be -ve");
        System.out.println(Math.sqrt(no));

    }
    static void main() {
        try {
            calculate(-2);
        } catch (AEx e) {
            System.out.println(e.getMessage());
        }
        System.out.println("askldj");
    }
}
