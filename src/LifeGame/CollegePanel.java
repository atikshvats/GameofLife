package LifeGame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.*;

public class CollegePanel extends JPanel {
	private int w, h;
	private JPanel collegePanel;
	private JButton career;
	private JLabel label;
	private Random rng;

	public CollegePanel(int w, int h) {
		label = new JLabel("Click here to choose a random career");
		this.w = w;
		this.h = h;
		rng = new Random();
		career = new JButton("Career");
		collegePanel = new JPanel();
		collegePanel.setLayout(new BoxLayout(collegePanel, BoxLayout.Y_AXIS));  // Use BoxLayout
		collegePanel.setPreferredSize(new Dimension(200, 200));
		collegePanel.setBackground(Color.cyan);

		career.addActionListener(new ButtonListener());

		collegePanel.add(career);
		collegePanel.add(label);

		add(collegePanel);
	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == career) {
				label.setText(getRandomCareer());
				addTaxButtons();
			}
		}

		private String getRandomCareer() {
			ArrayList<String> cjobs = new ArrayList<String>();
			cjobs.add("credit analyst at $42,000");
			cjobs.add("computer programmer at $90,000");
			cjobs.add("engineer at $60,000");
			return cjobs.get(rng.nextInt(cjobs.size()));
		}

		private void addTaxButtons() {
			JButton tax = new JButton("Pay 20% of your income in taxes");
			JButton atax = new JButton("Commit tax evasion");

			// Add ActionListener logic for tax and atax buttons if needed

			collegePanel.add(tax);
			collegePanel.add(atax);

			collegePanel.revalidate();
			collegePanel.repaint();
		}
	}
}
