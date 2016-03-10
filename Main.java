
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;


public class Main extends JFrame{
    
    private JPanel startScreen;
    private JButton startButton;
    private Gui gui;
    private JPanel mainPanel;
    private JScrollPane scrollPane;
    
	public Main(Gui gui){
            startScreen = new JPanel(); 
            startScreen.setSize(400,600);
            startScreen.setLayout(new BoxLayout(startScreen, BoxLayout.PAGE_AXIS));
            startButton = new JButton("Start");
            startButton.setAlignmentX(CENTER_ALIGNMENT);
            startScreen.add(startButton);  
            add(startScreen);
            ButtonListener bl = new ButtonListener();
            startButton.addActionListener(bl);
            
            
            this.gui = gui;
            setSize(400,600);
            mainPanel = new JPanel();
            mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
            mainPanel.setSize(400, 600);
            scrollPane = new JScrollPane(gui.race.getText(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            mainPanel.add(gui);
            mainPanel.add(scrollPane);
            mainPanel.setVisible(false);
            getContentPane().add(mainPanel);
            setVisible(true); 
            startButton.setVisible(true);
            startScreen.setVisible(true);
            //run();
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
        
        public class ButtonListener implements ActionListener { 
            @Override
            public void actionPerformed(ActionEvent e) { 
               if(e.getSource()==startButton)
                {
                    System.out.println("clicked");
                    remove(startScreen);
                     mainPanel.add(gui);
                     mainPanel.add(scrollPane);
                     mainPanel.setVisible(true);
                     revalidate();
                     repaint();  
                     //run();
                }
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
		new Main(g);
                

	}
}