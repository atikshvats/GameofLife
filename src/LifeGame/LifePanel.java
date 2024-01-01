package LifeGame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.*;

public class LifePanel extends JPanel {
	private int w, h;
	private JButton college, career;
	private JLabel label;
	private JPanel lifePanel;
	private Color color;
	public ArrayList<String> choices;
	private CareerPanel car;
	private JPanel subPanel;

	public LifePanel(int w, int h) {
		choices = new ArrayList<String>();
		car = new CareerPanel(1000, 1000);

		this.w = w;
		this.h = h;
		college = new JButton("College");
		career = new JButton("Career");


		ButtonListener BL = new ButtonListener();
		college.addActionListener(BL);
		career.addActionListener(BL);

		label = new JLabel("Pick an Option");

		lifePanel = new JPanel();
		lifePanel.setLayout(new BoxLayout(lifePanel, BoxLayout.Y_AXIS));  // Use BoxLayout

		lifePanel.setPreferredSize(new Dimension(200, 200));
		lifePanel.setBackground(Color.blue);

		lifePanel.add(college);
		lifePanel.add(career);
		lifePanel.add(label);

		lifePanel.add(car);  // Add CareerPanel, but keep it invisible initially
		car.setVisible(false);

		add(lifePanel);  // Add lifePanel to the main panel

	}

	public void addCareer() {

		// Hide College and Career buttons
		college.setVisible(false);
		career.setVisible(false);

		// Show CareerPanel
		car.setVisible(true);
	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == college) {
				choices.add("College");
				label.setText("College");
				// Switch to CollegePanel if needed
			}
			if (e.getSource() == career) {
				// choices.add("Career");
				addCareer();
			}
		}
	}


}
