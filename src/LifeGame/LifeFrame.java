package LifeGame;
import javax.swing.JFrame;

public class LifeFrame {

	public static void main(String[]args) {

		JFrame frame=new JFrame("Game of Life");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Adjust the size as needed
		int panelWidth = 800;
		int panelHeight = 600;

		LifePanel lifePanel = new LifePanel(panelWidth, panelHeight);
		frame.getContentPane().add(lifePanel);



		// Set the size of the frame explicitly
		frame.setSize(panelWidth, panelHeight);

		// Center the frame on the screen
		frame.setLocationRelativeTo(null);

		frame.setVisible(true);

}
}
