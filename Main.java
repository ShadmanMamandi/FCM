package main;

/**
 * Created by fatemeh on 1/11/2017.
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("Sending Post to FCM");

        String apikey = "AIzaSyBbbVrLt_LFWO58rb3B9v2Isq4a1Zo6zQM";
        Content content = createContent();

        POST2FCM.post(apikey,content);
    }

    public  static Content createContent(){

        Content c = new Content();

        c.addRegId("");// registration id
        c.createData("Test Title","Test Message");

        return c;
    }

}
