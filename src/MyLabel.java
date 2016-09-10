import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * Created by Пользователь on 04.09.2016.
 */
public class MyLabel extends JLabel {
    int posx, posy;
    String value;
    Color myColor;

    public  MyLabel(int posx, int posy, String value, Color myColor){
        this.posx = posx;
        this.posy = posy;
        this.myColor = myColor;
        if(value.equals("0")) {
            this.value = "";
        } else {
            this.value = value;
        }
        Border solidBorder = BorderFactory.createLineBorder(Color.white, 1);
        setText(value);
        setOpaque(true);
        setHorizontalAlignment(CENTER);
        setBorder(solidBorder);
        setPreferredSize(new Dimension(60,60));
        setFont(new Font(Font.SANS_SERIF, Font.BOLD, 25));
        setForeground(Color.DARK_GRAY);
        setBackground(myColor);
    }

    public void setColor(Color color){
        this.myColor = color;
        this.setBackground(color);
        setOpaque(true);
    }
    public static Color labelColor(String value){
        Color newColor = null;
            if(value.equals("")) {
            } else if(value.equals("2")) {
                System.out.println("Color exist");
                newColor = (new Color(220,220,220));
            } else if(value.equals("4")) {
                newColor = (new Color(100, 149, 237));
            } else if(value.equals("8")) {
                newColor = (new Color(123, 104, 238));
            } else if(value.equals("16")) {
                newColor = (new Color(135, 206, 235));
            } else if(value.equals("32")) {
                newColor = (new Color(173, 255, 47));
            } else if(value.equals("64")) {
                newColor = (new Color(189, 183, 107));
            } else if(value.equals("128")) {
                newColor = (new Color(218, 165, 32));
            } else if(value.equals("512")) {
                newColor = (new Color(205, 92, 92));
            } else if(value.equals("1024")) {
                newColor = (new Color(178, 34, 34));
            } else {
                newColor = (Color.white);
            }

        return newColor;
    }
}
