package abstractExample;

/**
 * Created by rohanrampuria on 1/24/17.
 */
public abstract class BaseAbstract
{
    int x,y;
     void show()
    {
        System.out.println("x");
        System.out.println("y");
    }
    abstract void  display();
}
class child extends BaseAbstract
{
    void set (int x,int y)
    {
        this.x=x;
        this.y=y;
        System.out.println("x "+x);
        System.out.println("y "+y);

    }
    void display()
    {
        System.out.println("revoke");

    }
    public static void main(String args[])
    {
        child c1= new child();
        c1.set(10,20);
        c1.show();
        c1.display();
    }
}