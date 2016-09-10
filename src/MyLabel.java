import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Пользователь on 04.09.2016.
 */
public class MyLabel extends JLabel {
    int posx, posy;
    String value;

    public  MyLabel(int posx, int posy, String value){
        this.posx = posx;
        this.posy = posy;
        if(value.equals("0")) {
            this.value = "";
        } else {
            this.value = value;
        }
        Border solidBorder = BorderFactory.createLineBorder(Color.BLACK, 1);
        setText(value);
        setHorizontalAlignment(CENTER);
        setBorder(solidBorder);
        setPreferredSize(new Dimension(50,50));
    }
}
