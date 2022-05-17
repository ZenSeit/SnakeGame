/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Graphics;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Diego Becerra
 */
public class Background extends JPanel {
    
    Color colorBackground=Color.black;
    int quamax,qua,sizep;

    public Background(int quamax, int qua) {
        this.quamax = quamax;
        this.qua = qua;
        this.sizep = quamax/qua;
    }
    
    public void paint(Graphics painter){
        super.paint(painter);
        painter.setColor(colorBackground);      
        for(int i =0;i<qua;i++){
            for(int j =0;j<qua;j++){
                painter.fillRect(i*sizep, j*sizep, sizep-1, sizep-1);
            }
        } 
    }
    
    
    
    
}
