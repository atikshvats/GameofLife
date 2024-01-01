package LifeGame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class CareerPanel extends JPanel {
	private int w, h;
	private JButton careerButton;
	private JLabel label;
	private ArrayList<String> careers;

	public CareerPanel(int width, int height) {
		this.w = w;
		this.h = height;

		label = new JLabel("Click here to choose a random career");
		careerButton = new JButton("Career");
		careers = new ArrayList<>();

		careers.add("Credit Analyst at $42,000");
		careers.add("Computer Programmer at $90,000");
		careers.add("Engineer at $60,000");

		ButtonListener buttonListener = new ButtonListener();
		careerButton.addActionListener(buttonListener);

		this.setPreferredSize(new Dimension(200, 200));
		this.setBackground(Color.cyan);
		this.add(careerButton);
		this.add(label);
	}

	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == careerButton) {
				CareerPanel.this.remove(careerButton);
				label.setText(careers.get(ThreadLocalRandom.current().nextInt(careers.size())));

				addTaxButton();
				addEvasionButton();
			}
		}

		private void addTaxButton() {
			JButton tax = new JButton("Pay 20% of your income in taxes");
			tax.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					// Handle tax payment
				}
			});

			CareerPanel.this.add(tax);
			CareerPanel.this.revalidate();
			CareerPanel.this.repaint();
		}

		private void addEvasionButton() {
			JButton evasion = new JButton("Commit tax evasion");
			evasion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					handleEvasion();
				}
			});

			CareerPanel.this.add(evasion);
			CareerPanel.this.revalidate();
			CareerPanel.this.repaint();
		}

		private void handleEvasion() {
			JLabel penalty = new JLabel("You were audited by the IRS and sent to prison! You lose.");
			CareerPanel.this.remove(label);
			CareerPanel.this.add(penalty);
			CareerPanel.this.revalidate();
			CareerPanel.this.repaint();
		}
	}
}

