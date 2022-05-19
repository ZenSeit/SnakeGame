/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ThreadsSnake;

import Graphics.SnakeP;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;

/**
 *
 * @author mayasoft
 */
public class TaskLabel implements Runnable {
    
    JLabel sco;
    SnakeP sk;

    public TaskLabel(JLabel sco, SnakeP sk) {
        this.sco = sco;
        this.sk = sk;
    }


    
    

    @Override
    public void run() {
        
        while (true) {
            sco.setText("Score: \n"+sk.scoreGame());
            sco.repaint();
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(TaskOne.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }
    
}
