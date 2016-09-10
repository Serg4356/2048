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
    }
    public void labelColor(String value){
        Color labelColor = null;
            if(value.equals("")) {
            } else if(value.equals("2")) {
                System.out.println("Color exist");
                this.setColor(new Color(220,220,220));
            } else if(value.equals("4")) {
                this.setColor(new Color(100, 149, 237));
            } else if(value.equals("8")) {
                this.setColor(new Color(123, 104, 238));
            } else if(value.equals("16")) {
                this.setColor(new Color(135, 206, 235));
            } else if(value.equals("32")) {
                this.setColor(new Color(173, 255, 47));
            } else if(value.equals("64")) {
                this.setColor(new Color(189, 183, 107));
            } else if(value.equals("128")) {
                this.setColor(new Color(218, 165, 32));
            } else if(value.equals("512")) {
                this.setColor(new Color(205, 92, 92));
            } else if(value.equals("1024")) {
                this.setColor(new Color(178, 34, 34));
            } else {
                this.setColor(Color.white);
            }

    }
}
