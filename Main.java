import java.awt.Dimension;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Main extends JFrame{

	private Gui gui;
	public Main(Gui gui){
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
		//pack();
		setVisible(true);
		run();
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