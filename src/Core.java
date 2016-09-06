/**
 * Created by Пользователь on 04.09.2016.
 */
public class Core {
    public static void main(String[] args) {

        Frame a = new Frame();
        try {
            Thread.sleep(1000);
            a.genStart();
            a.genStart();
            a.refreshtable();
        } catch (InterruptedException ie) {
            System.out.print("YO MOTHERFUCKER");
        }
    }
}

