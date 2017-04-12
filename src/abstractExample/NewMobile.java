package abstractExample;

/**
 * Created by rohanrampuria on 1/24/17.
 */
abstract class AbstractExample2 {

    public void camera(){

    }
    abstract public void flashlight();

    public static void main(String [] args){
        AbstractExample2 n = new NewMobile();
        n.flashlight();
    }
}



abstract class Mobile extends AbstractExample2{

}


class NewMobile extends Mobile{
    public void flashlight(){
        System.out.print("Hii");
    }


}

/*class NewMobile extends AbstractExample2{

    public void flashlight(){

    }
}*/
