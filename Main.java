
import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;


public class Main extends JFrame{
    
   
    private Gui gui;
    private JPanel mainPanel;
    private JScrollPane scrollPane;   
    private JPanel resultsScreen;
    private JScrollPane results;
    
    
	public Main(Gui gui){
           
            this.gui = gui;
            setSize(400,600);
            mainPanel = new JPanel();
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
            mainPanel.setSize(400, 600);
            scrollPane = new JScrollPane(gui.race.getText(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            mainPanel.add(gui);
            mainPanel.add(scrollPane);
            mainPanel.setVisible(true);
            getContentPane().add(mainPanel);
            setVisible(true); 
           
            
             resultsScreen = new JPanel();
             //JTextArea resultsTitle = new JTextArea("Results Page!!!");
            // resultsTitle.setSize(100,100);
            // resultsTitle.setBackground(Color.red);
             resultsScreen.setLayout(new BoxLayout(resultsScreen, BoxLayout.PAGE_AXIS));
             resultsScreen.setVisible(false);
             resultsScreen.setSize(400,600);
             results = new JScrollPane(gui.race.getResultsText());
             results.setVisible(false);
             results.setSize(400,500);
            //resultsScreen.add(resultsTitle);
             resultsScreen.add(results);
             add(resultsScreen);
              
           
            setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
        
        public void displayWinner(){
            if(gui.race.getOver())
            {
                System.out.println("winner");
                remove(mainPanel);
                resultsScreen.setVisible(true);
                results.setVisible(true);                
                revalidate();
                repaint();
            }
        }
	  public void run() {
	    	int ind = 0;
	        while(!gui.race.getOver()){
	            gui.race.go();
	            try {
	                //the tick rate
	                Thread.sleep(400);
	            } catch(InterruptedException ex) {
	                Thread.currentThread().interrupt();
	                System.out.println("Everything's broken cry");
	            }
	            gui.repaint();
	            ind++;
	            //System.out.println(ind);
	        }
	    }

	public static void main(String[] args){
		Gui g = new Gui();
		Main m = new Main(g);
                m.run();
                m.displayWinner();     
	}
}