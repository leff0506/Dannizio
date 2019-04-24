package imagework;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextField;

public class MyTF extends JTextField {
	
	public MyTF(){
		setForeground(Color.BLACK);
	}
    @Override
    public void paint(Graphics g) {
    	
        super.paint(g);
        
        
        getRootPane().repaint();
        g.setColor(new Color(255,110,200));
        g.drawLine(0, super.getHeight()-1, super.getWidth(), super.getHeight()-1);
    }

}
