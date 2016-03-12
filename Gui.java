//Fred Dolan

//its a gui
import javax.swing.*;
import java.awt.*;
public class Gui extends JPanel {

    public Race race;
    public static int XS;
    public static int YS;
   

    public Gui() {

        //resolution
        XS = 400;
        YS = 300;
        //creating the race object
        //int xSize, int ySize, int minSpeed, int maxSpeed, int nStops, int nCars, int nDinos
        race = new Race(XS,YS,2,8,5,7,2);
        setSize(XS, YS);
        setVisible(true);


    }



    public void paint(Graphics g) {
        g.clearRect(0,0,XS,YS);
        g.setColor(Color.BLACK);
        race.draw(g);
    }


}
