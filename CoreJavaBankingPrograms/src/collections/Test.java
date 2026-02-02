package collections;

interface Validate{
    public boolean test(int n);
}
class Odd implements Validate{
    @Override
    public boolean test(int n) {
        return n%2!=0;
    }
}
class Even implements Validate{
    @Override
    public boolean test(int n) {
        return n%2==0;
    }
}
public class Test {
    static void calculate(int nos[], Validate v){
        for (int n: nos){
            if(v.test(n))
                System.out.println(v);
        }
    }

    static void main() {

    calculate(new int[]{1,2,3,4,5,6}, new Odd());

    }
}
