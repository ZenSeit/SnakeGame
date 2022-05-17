/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graphics;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author Diego Becerra
 */
public class SnakeP extends JPanel {
    
    Color colorSnake=Color.green;
    Color colorFeed=Color.pink;
    int quamax,qua,sizep;
    List<int[]> snake = new ArrayList<>();
    int[] feed;
    String dir="ri";

    public SnakeP (int quamax, int qua) {
        this.quamax = quamax;
        this.qua = qua;
        this.sizep = quamax/qua;
        int[] a ={qua/2,qua/2-1};
        int[] b ={qua/2-1,qua/2-1};
        snake.add(b);
        snake.add(a);
    }
    
    public void paint(Graphics painter){
        super.paint(painter);
        painter.setColor(colorSnake);      
        for(int i =0;i<snake.size();i++){
                painter.fillRect(snake.get(i)[0]*sizep, snake.get(i)[1]*sizep, sizep-1, sizep-1);
            
        } 
    }
    
    public void goHead(){
        int[] last = snake.get(snake.size()-1);
        int addX=0;
        int addY=0;
        switch(dir){
            case "ri":addX=1;break;
            case "le":addX=-1;break;
            case "up":addY=-1;break;
            case "down":addY=1;break;
        }
        
        int[] newp={last[0]+addX, last[1]+addY};
        snake.add(newp);
        snake.remove(0);
    }
    
    
    
}
