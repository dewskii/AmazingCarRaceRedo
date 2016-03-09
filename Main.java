
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
	public Main(Gui gui){
            startScreen = new JPanel();                    
            startButton = new JButton("Start");
            startScreen.setVisible(true);                   
            startScreen.add(startButton);
            ButtonListener bl = new ButtonListener();
            add(startScreen);
            
		this.gui = gui;
		setSize(400,600);
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.PAGE_AXIS));
		mainPanel.setSize(400, 600);
		JScrollPane scrollPane = new JScrollPane(gui.race.getText(), JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		mainPanel.add(gui);
		mainPanel.add(scrollPane);
		mainPanel.setVisible(true);
		getContentPane().add(mainPanel);
             setVisible(true);
          
            
	}
        
        public class ButtonListener implements ActionListener { 
            @Override
            public void actionPerformed(ActionEvent e) { 
               if(e.getSource()==startButton)
                {
                    startScreen.setVisible(false);
                    
                    run();
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