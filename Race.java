//Fred Dolan

//creates and holds all the entities and makes them go
import java.util.ArrayList;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.*;
public class Race
{
    private ArrayList<Car> cars;
    private ArrayList<Stop> stops;
    //private ArrayList<Dinosaur> dinos;
    private JTextArea textArea;
    private JTextArea winner;

    private Random gen;
/*    private int xSize;
    private int ySize;
    private int maxSpeed;
    private int minSpeed;
    private int nCars;
    private int nStops;
    private int nDinos;*/
    private boolean over;
    public Race(int xSize, int ySize, int minSpeed, int maxSpeed, int nStops, int nCars, int nDinos)
    {
        Setup setup = new Setup();
        over=false;
        gen = new Random();

        //add the stops
        stops = new ArrayList<Stop>();
        int index = 0;
        while(index<nStops){
            stops.add(new Stop(gen.nextInt(xSize-200)+100,gen.nextInt(ySize-200)+100, "Stop "+index));
            index++;
        }
        //dinos = new ArrayList<Dinosaur>();
        index=0;

        //add the dinos
        /*while(index<nDinos){
           //dinos.add(new Dinosaur(gen.nextInt(xSize-200)+100,gen.nextInt(ySize-200)+100,
            setup.getDinoNames().get(gen.nextInt(setup.getDinoNames().size()))+" "+setup.getDinoNames().get(gen.nextInt(setup.getDinoNames().size()))));
            index++;
        }*/

        //add the cars
        cars = new ArrayList<Car>();
        index = 0;
        while(index<nCars){
            cars.add(new Car(gen.nextInt(xSize-200)+100,gen.nextInt(ySize-200)+100,
            setup.getFirstNames().get(gen.nextInt(setup.getFirstNames().size()))+" "+setup.getLastNames().get(gen.nextInt(setup.getLastNames().size())),
            gen.nextInt(maxSpeed-minSpeed)+minSpeed, stops));
            index++;
        }
        //set the text area
        textArea = new JTextArea();
        textArea.setSize(380, 300);
        textArea.setEditable(false);
        //text area for the results page
        winner = new JTextArea();
        winner.setSize(400,600);
        
        
    }
    public ArrayList<Car> getCars() {
    	return cars;
    }
    public void draw(Graphics g)
    {
        for(Car car: cars)
        {
            car.draw(g);
        }
        for(Stop stop: stops)
        {
            stop.draw(g);
        }
        /*for(Dinosaur d: dinos)
        {
            d.draw(g);
        }*/
    }

    //checks if there's a winner
    public String findWinner()
    {
        for(Car c:cars)
        {
            if(c.getWinner()==true)
            {
                return c.getName();
            }
        }
        return null;
    }

    //makes stuff go if there isn't a winner
    public void go()
    {
        if(findWinner()!=null){
            over=true;
            addText(findWinner()+" has won");
            addResults(findWinner()+ " has won");
        }
        else{
           /* for(Dinosaur d: dinos)
            {
                d.go();
            }*/
            goCars();
        }
    }

    //makes the cars check for hazards and react or go normally
    public void goCars()
    {
        for(Car c: cars)
        {
//            c.incShutup();
            /*if(c.checkDinos(dinos)!=null)
            {
                //addText(c.checkDinos(dinos).getName()+" has scared "+c.getName());
                c.flee(c.checkDinos(dinos));

            }
            else
            {*/
                c.go();
                addText(c.getName()+"'s next destition is "+c.getDestination().getName());
            //}
        }
    }
    
    public void addResults(String text)
    {
      winner.append(text);
    }
    
    public JTextArea getResultsText()
    {
        return winner;
    }
    //adds text to the info display that displays below the game display
    public void addText(String text){
    	textArea.append(text+"\n");
    }

    public JTextArea getText() {
    	
    	return textArea;
    }

    //is the game still going?
    public boolean getOver()
    {
        return over;
    }
}

