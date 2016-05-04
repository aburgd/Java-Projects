import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.border.Border;

public class MilesKmsConverter extends JFrame {
	public MilesKmsConverter() {
		super("Miles to Kilometers");
		
		JPanel controlPanel = new JPanel( new GridLayout(4, 1) );
		Border gap = BorderFactory.createEmptyBorder(5,5,5,5);
		controlPanel.setBorder(gap);
		
		controlPanel.add( new JLabel("Miles:") );
		myMilesBox = new JTextField(16);
		controlPanel.add(myMilesBox);
		controlPanel.add( new JLabel("Kilometers:") );
		myKmsBox = new JTextField(16);
		controlPanel.add(myKmsBox);
		
		super.setContentPane(controlPanel);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		myMilesBox.addActionListener( new MilesListener() );
		myKmsBox.addActionListener( new KmsListener() );
	}
	
	private class MilesListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			final double CONVERSION_FACTOR = 1.609344;
			String milesString = myMilesBox.getText();
			String kmString = null;
			if ( milesString != null && !milesString.equals("") ) {
				double miles = Double.valueOf(milesString);
				double kms = miles * CONVERSION_FACTOR;
				kmString = new Double(kms).toString();
			} else {
				kmString = "";
			}
			myKmsBox.setText(kmString);
		}
	}
	
	private class KmsListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			final double CONVERSION_FACTOR = 0.621371192;
			String kmString = myKmsBox.getText();
			String milesString = null;
			if ( kmString != null && !kmString.equals("") ) {
				double kms = Double.valueOf(kmString);
				double miles = kms * CONVERSION_FACTOR;
				milesString = new Double(miles).toString();
			} else {
				milesString = "";
			}
			myMilesBox.setText(milesString);
		}
	}
	
	private JTextField myMilesBox = null;
	private JTextField myKmsBox = null;
	private static final long serialVersionUID = 1L;
	
	public static void main(String[] args) {
		MilesKmsConverter self = new MilesKmsConverter();
		self.pack();
		self.setVisible(true);
	}
}
