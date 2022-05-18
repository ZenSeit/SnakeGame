/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author Diego Becerra
 */
public class SnakeP extends JPanel {

    Color colorSnake = new Color(102, 100, 118);
    Color colorFeed = Color.pink;
    int quamax, qua, sizep;
    List<int[]> snake = new ArrayList<>();
    int[] feed = new int[2];
    String dir = "ri";

    public SnakeP(int quamax, int qua) {
        this.quamax = quamax;
        this.qua = qua;
        this.sizep = quamax / qua;
        int[] a = {qua / 2, qua / 2 - 1};
        int[] b = {qua / 2 - 1, qua / 2 - 1};
        snake.add(b);
        snake.add(a);
        generateFeed();
    }

    public void paint(Graphics painter) {
        super.paint(painter);
        painter.setColor(colorSnake);
        for (int i = 0; i < snake.size(); i++) {
            painter.fillRect(snake.get(i)[0] * sizep, snake.get(i)[1] * sizep, sizep - 1, sizep - 1);
        }

        painter.setColor(colorFeed);
        painter.fillRect(feed[0] * sizep, feed[1] * sizep, sizep - 1, sizep - 1);
    }

    public void walk() {
        int[] last = snake.get(snake.size() - 1);
        int addX = 0;
        int addY = 0;
        switch (dir) {
            case "ri":
                addX = 1;
                break;
            case "le":
                addX = -1;
                break;
            case "up":
                addY = -1;
                break;
            case "down":
                addY = 1;
                break;
        }

        int[] newp = {Math.floorMod(last[0] + addX, qua), Math.floorMod(last[1] + addY, qua)};
        boolean state=false;
        for (int[] cor : snake) {
                if(cor[0]==newp[0] && cor[1]==newp[1]){
                    state=true;
                    break;
                }
            }
        if (newp[0] == feed[0] && newp[1] == feed[1]) {
            snake.add(newp);
            generateFeed();
        }else if(state){
            JOptionPane.showMessageDialog(null, "Game Over");
        }else{
            
            snake.add(newp);
            snake.remove(0);
        }
        
            

    }

    public void generateFeed() {

        int a = (int) (Math.random() * (qua - 1));
        int b = (int) (Math.random() * (qua - 1));

        boolean state = false;

        for (int[] cor : snake) {
            if (cor[0] == a && cor[1] == b) {
                state = true;
                generateFeed();
                break;
            }
        }
        if (!state) {
            feed[0] = a;
            feed[1] = b;
        }

    }

}
