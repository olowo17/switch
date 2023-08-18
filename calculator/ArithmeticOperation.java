package calculator;

public class ArithmeticOperation {
    public static  int add(int a,int b){
        return a+b;
    }

    public static void main(String[] args) {
        int result = ArithmeticOperation.add(6,7);
        System.out.printf("the result is %s",result );
    }
}
