import com.sun.org.apache.xalan.internal.xslt.Process;


import javax.swing.*;
import java.awt.*;
import java.awt.Label;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;

/**
 * Created by Пользователь on 04.09.2016.
 */
public class Frame extends JFrame {
    String [][] data = new String [Constants.FIELD_SIZE][Constants.FIELD_SIZE];
    JPanel panel;
    JPanel mainPanel;
    MyLabel[][] labelarr = new MyLabel[Constants.FIELD_SIZE][Constants.FIELD_SIZE];
    Engine engine = new Engine(this);
    JButton button;

    public Frame() {
        super("2048");
        mainPanel = new JPanel(new BorderLayout(5,5));
        panel = new JPanel(new GridLayout(Constants.FIELD_SIZE,Constants.FIELD_SIZE,6,3));
        for(int i = 0;i< Constants.FIELD_SIZE;i++){
            for(int y = 0; y<Constants.FIELD_SIZE;y++){
                data[i][y] = "0";
                labelarr[i][y] = new MyLabel(i, y, data[i][y], Constants.DEFAULT_COLOR);
                panel.add(labelarr[i][y]);
            }
        }
        button = new JButton("refresh");
        button.addActionListener(engine);
        mainPanel.add(button, BorderLayout.NORTH);
        mainPanel.add(panel);
        keylist();
        getContentPane().add(mainPanel);
        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);

    }

    /*********************************************************
    this is the real engine, dude. That Class is bullshit*****
    *********************************************************/

    //comparator of array values
    //up button
    //testing git
    //Not in use anymore!!
    public static String[][] pressUp(String[][] data){
        outer: for(int y = 0; y<data[0].length;y++){
            for(int i = 0; i< data.length; i++){
                try {
                    String[] res  = compare(data[data.length - i - 2][y],data[data.length - i - 1][y]);

                    data[data.length - i - 1][y] = res[1];
                    data[data.length - i - 2][y] = res[0];
                } catch (IndexOutOfBoundsException e){
                    continue outer;
                }
            }
        }
        return data;
    }
    //Down button
    public static String[][] pressDown(String[][] data){
        outer: for(int y = 0; y<data[0].length;y++){
            for(int i = 0; i< data.length; i++){
                try {
                    String[] res  = compare(data[i][y],data[i + 1][y]);
                    data[i][y] = res[1];
                    data[i+1][y] = res[0];
                } catch (IndexOutOfBoundsException e){

                    continue outer;
                }
            }
        }
        return data;
    }
    //Left button
    public static String[][] pressLeft(String[][] data){
        outer: for(int i = 0; i< data.length; i++){
            for(int y = 0; y<data[0].length;y++){
                try {
                    String[] res  = compare(data[i][data.length - y - 2],data[i][data.length - y - 1]);
                    data[i][data.length - y - 1] = res[1];
                    data[i][data.length - y - 2] = res[0];
                } catch (IndexOutOfBoundsException e){
                    continue outer;
                }
            }
        }
        return data;
    }
    //Right button
    public static String[][] pressRight(String[][] data){
        outer: for(int y = 0; y<data[0].length;y++){
            for(int i = 0; i< data.length; i++){
                try {
                    String[] res  = compare(data[i][y],data[i][y+1]);
                    data[i][y] = res[1];
                    data[i][y+1] = res[0];
                } catch (IndexOutOfBoundsException e){
                    continue outer;
                }
            }
        }
        return data;
    }

    //new algorithm
    //compare vector
    public static String[] compare(String[] initArr){
        int stopConst = 0;
        outer: for(int i = 0; i<initArr.length; i++){
            try {
                for (int y = i; y > stopConst; y--) {
                    int curPosition = y;
                    //System.out.println("значение: " + initArr[curPosition]);
                    String curValue = initArr[curPosition];
                    if (curValue.equals("0")) {
                        continue outer;
                    } else if (initArr[curPosition - 1].equals(curValue)) {
                        initArr[curPosition - 1] = Integer.toString(Integer.parseInt(initArr[curPosition - 1]) * 2);
                        initArr[curPosition] = "0";
                        stopConst = y;
                    } else if (initArr[curPosition - 1].equals("0")) {
                        initArr[curPosition - 1] = curValue;
                        initArr[curPosition] = "0";
                    } else if (!initArr[curPosition - 1].equals("0")) {
                        continue outer;
                    }
                }
            } catch (IndexOutOfBoundsException e){ continue outer;}
        }
        return initArr;
    }
    //compare whole array
    public static String[][] arrCompare(String[][] arr, String direction){

        String[] currArr = new String[arr.length];
        switch (direction){
            case "Up":
                for(int y = 0; y<arr.length; y++) {
                    for (int i = 0; i < arr.length; i++) {
                        currArr[i] = arr[i][y];
                    }
                    currArr = compare(currArr);
                    for (int i = 0; i < arr.length; i++) {
                        arr[i][y] = currArr[i];
                    }
                }
                break;
            case "Down":
                for(int y = 0; y<arr.length; y++) {
                    for (int i = arr.length-1; i >= 0; i--) {
                        currArr[arr.length-1-i] = arr[i][y];
                    }
                    currArr = compare(currArr);
                    for (int i = arr.length-1; i >= 0; i--) {
                        arr[i][y] = currArr[arr.length-1-i];
                    }
                }
                break;
            case "Left":
                for(int y = 0; y<arr.length; y++) {
                    for (int i = 0; i < arr.length; i++) {
                        currArr[i] = arr[y][i];
                    }
                    currArr = compare(currArr);
                    for (int i = 0; i < arr.length; i++) {
                        arr[y][i] = currArr[i];
                    }
                }
                break;
            case "Right":
                for(int y = 0; y<arr.length; y++) {
                    for (int i = arr.length-1; i >= 0; i--) {
                        currArr[arr.length-1-i] = arr[y][i];
                    }
                    currArr = compare(currArr);
                    for (int i = arr.length-1; i >= 0; i--) {
                        arr[y][i] = currArr[arr.length-1-i];
                    }
                }
                break;
        }
        return arr;
    }

    //joins KeyEvent to Frame -- rewrited
    public void keylist(){
        button.addKeyListener(new KeyAdapter() {
            public void keyReleased(KeyEvent e) {
                arrCompare(data,e.getKeyText(e.getKeyCode()));
                genStart();
                refreshtable();

                /** not in use anymore, previous code version
                switch (e.getKeyText(e.getKeyCode())){
                    case "Up":
                        pressUp(data);
                        genStart();
                        refreshtable();
                        break;
                    case "Down":
                        pressDown(data);
                        genStart();
                        refreshtable();
                        break;
                    case "Left":
                        pressLeft(data);
                        genStart();
                        refreshtable();
                        break;
                    case "Right":
                        pressRight(data);
                        genStart();
                        refreshtable();
                        break;
                    }
                 */
                }
            });
    }

    // compare two array values
    public static String[] compare(String firstx, String secondx){
        String result[] = new String[2];
        if(firstx.equals("0")&&secondx.equals("0")){
            result[0] = "0";
            result[1] = "0";

        } else if(firstx.equals("0")){
            result[0] = secondx;
            result[1] = "0";

        } else if(secondx.equals("0")){
            result[0] = firstx;
            result[1] = "0";

        } else if(firstx.equals(secondx)) {
            result[0] = Integer.toString(Integer.parseInt(firstx) + Integer.parseInt(secondx));
            result[1] = "0";
        } else {
            result[0] = firstx;
            result[1] = secondx;
        }
        return result;
    }

    // generate int - coord limited by FIELD_SIZE constant
    public int rndcoord(){
        int coord = new Random().nextInt(Constants.FIELD_SIZE);
        return coord;
    }

    // generates randomly "2" or "4" value for cell
    public String boolvalue(){
        if(new Random().nextBoolean()){
            return "2";
        } else {
            return "4";
        }
    }

    // generates 1 cell value, counts empty cells, shows score before exit
    public void genStart(){
        Boolean emptyExist = true;
        int emptyCellsNumber = 0;
        int score = 0;
    for(int y = 0; y<data[0].length;y++) {
        for (int i = 0; i < data.length; i++) {
            if (data[i][y] == "0") emptyCellsNumber+=1;
        }
    }

    if(emptyCellsNumber==0){
        emptyExist = false;
    } else {
        emptyExist = true;
    }

    if(emptyExist) {
        int x = rndcoord(), y = rndcoord();
        if(data[x][y]=="0") {

            data[x][y] = boolvalue();

        } else {
            genStart();
        }
    } else{
        for(int y = 0; y<data[0].length;y++) {
            for (int i = 0; i < data.length; i++) {
            score += Integer.parseInt(data[i][y]);
            }
        }
        JOptionPane.showConfirmDialog(null, "No empty cell left", "Warning", JOptionPane.PLAIN_MESSAGE);
        JOptionPane.showConfirmDialog(null, "Your score is: " + score, "SCORE", JOptionPane.PLAIN_MESSAGE);
        System.exit(0);
    }
    }

    // updates labels in Frame with new values of data array
    // added color??????
    public void refreshtable(){
        for(int i = 0;i< Constants.FIELD_SIZE;i++){
            for(int y = 0; y< Constants.FIELD_SIZE;y++){
                String z = data[i][y];
                if(z.equals("0")) {
                    labelarr[i][y].setText("");
                    labelarr[i][y].labelColor(labelarr[i][y].value);
                    System.out.println(labelarr[i][y].getBackground());
                    labelarr[i][y].setBackground(Constants.DEFAULT_COLOR);
                } else {
                    labelarr[i][y].setText(data[i][y]);
                    labelarr[i][y].value = data[i][y];
                    labelarr[i][y].setBackground(MyLabel.labelColor(labelarr[i][y].value));
                    labelarr[i][y].labelColor(labelarr[i][y].value);
                }
            }
    }}

}
