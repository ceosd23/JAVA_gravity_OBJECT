import java.awt.*;
import javax.swing.*;

class Plotter extends JPanel
{
    public void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        g.translate(200,100);
        int size=Store.bodies.size();
        for(int i=0;i<size;i++)
        {
            int x=(int)(Store.bodies.get(i).position.x*400/Store.sizeofuniverse);
            int y=(int)(Store.bodies.get(i).position.y*400/Store.sizeofuniverse);
            g.setColor(Store.bodies.get(i).color);
            g.fillOval(x,y,7,7);
        }
    }
}