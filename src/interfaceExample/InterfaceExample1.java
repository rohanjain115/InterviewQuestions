package interfaceExample;

/**
 * Created by rohanrampuria on 1/24/17.
 *
 * Interface are implemented to overcome the problem of multiple inheritance
 *
 * Difference between Abstract class and interface
 *                  declare                declare
 *                  class                   interface
 *                  define                  cannot define
 */



interface A{

    void show();
}

interface B{
    void display();
}
public class InterfaceExample1 implements A,B {

    public void show(){

    }

    public void display(){

    }


    public static void main(String [] arr){

        InterfaceExample1 obj = new InterfaceExample1();
        obj.show();
        obj.display();

        try{

        }

        catch(ArithmeticException e){
            e.printStackTrace();
        }
        catch(Exception e){
            e.printStackTrace();
        }

    }
}
