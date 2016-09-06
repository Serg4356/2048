import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Пользователь on 04.09.2016.
 */
public class Engine implements ActionListener {

    Frame parent;
    Engine(Frame parent){
        this.parent = parent;
    }
    public void actionPerformed(ActionEvent e) {
        for(int y = 0; y<parent.data[0].length;y++){
            for(int i = 0; i< parent.data.length; i++) {
                parent.data[y][i] = "";
            }
        }

        parent.genStart();
        parent.genStart();
        parent.refreshtable();
    }

}
