import java.awt.*;
import javax.swing.*;
class Master
{
    static Body currentbody;
    public static void main(String[] args) throws java.io.IOException
    {  int ss=23;
        menu();
        JFrame frame=new JFrame("N-Body");
        Plotter plot=new Plotter();
        frame.add(plot);
        frame.setSize(800,600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        while(true)
        {
            for(int i=0;i<Store.bodies.size();i++)
            {
                currentbody=Store.bodies.get(i);
                Vector gravity=new Vector(0,0);
                for(int j=0;j<Store.bodies.size();j++)
                {
                    if(j!=i)
                    {
                        gravity.add(calcGravity(j));
                    }
                }
                currentbody.update(gravity);
            }
            
            frame.repaint();
        }
    }
    
    static void populate()
    {  int ss=23;
        for(int i=1;i<=50;i++)
        {
            double positionx=Math.random()*Store.sizeofuniverse;
            double positiony=Math.random()*Store.sizeofuniverse;
            double mass=Math.random()*Store.maxmass;
            double velx=Math.random()*Store.maxvel;
            double vely=Math.random()*Store.maxvel;
            if(Math.random()>=.5) {velx=-velx; vely=-vely;}
            int green=(int)Math.floor(254-mass*254/Store.maxmass);
            int blue=(int)Math.floor(254-mass*254/Store.maxmass);
            int red=255;
            Color color=new Color(red, green, blue);
            Store.bodies.add(new Body(new Vector(positionx,positiony),new Vector(velx,vely),mass,color));
        }
    }
    
    static Vector calcGravity(int j)
    {
        double G=6.67e-11; double gx=0,gy=0;
        Body otherbody=Store.bodies.get(j);
        double rx=otherbody.position.x-currentbody.position.x;
        double ry=otherbody.position.y-currentbody.position.y;
        double r=Math.sqrt(Math.abs(rx*rx+ry*ry));
        if(r!=0)
        {
            double gravity=G*currentbody.mass*otherbody.mass/(r*r);
            gx=gravity*rx/r; gy=gravity*ry/r;
        }
        return new Vector(gx,gy);
    }
    
    static void menu() throws java.io.IOException
    {
        System.out.println("What do you want to simulate?");
        System.out.println("1. 50 Random Bodies");
        System.out.println("2. Earth-Moon System");
        System.out.println("3. Earth-Moon L4 Point");
        System.out.print("Enter your choice:");
        switch((char)System.in.read())
        {
            case '1': populate();break;
            case '2': populate2();break;
            case '3': populate3();break;
        }
    }
    
    static void populate2()
    {
        Store.bodies.add(new Body(new Vector(384400000,384400000),new Vector(0,13.5),5.9e24,Color.BLUE));
        Store.bodies.add(new Body(new Vector(2*384400000,384400000),new Vector(0,-1011.805),7.3e22,Color.BLACK));
    }
    
    static void populate3()
    {
        Store.bodies.add(new Body(new Vector(384400000,384400000),new Vector(0,13.5),5.9e24,Color.BLUE));
        Store.bodies.add(new Body(new Vector(2*384400000,384400000),new Vector(0,-1011.805),7.3e22,Color.BLACK));
        Store.bodies.add(new Body(new Vector(384400000+192200000,384400000-332900000), new Vector(-875.5,-505.5),100,Color.GREEN));
    }
}
