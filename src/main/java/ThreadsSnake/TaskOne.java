/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ThreadsSnake;

import Graphics.SnakeP;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mayasoft
 */
public class TaskOne implements Runnable {

    SnakeP snk;
    boolean state = true;
    String stpause = "true";

    public TaskOne(SnakeP snk) {
        this.snk = snk;
    }

    @Override
    public void run() {

        while (state) {
            switch (stpause) {
                case "true":
                    snk.walk();
                    snk.repaint();
                    break;
                default:
                    break;
            }

            try {
                Thread.sleep(500);
            } catch (InterruptedException ex) {
                Logger.getLogger(TaskOne.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void stopIns() {
        this.state = (!this.state);
    }

    public void pause() {
        if(this.stpause.equals("true")){
            this.stpause="";
        }else{
            this.stpause="true";
        }
    }

}
