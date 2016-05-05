/** ColorPicker.java helps you find a color's RGB values.
 * @author Joel Adams, for Alice+Java.
 */
import javax.swing.*;            // JFrame, JPanel, ...
import javax.swing.event.*;      // ChangeEvent, ...
import java.awt.*;               // BorderLayout, Color, ...
import java.awt.event.*;         // ActionEvent, ...

public class ColorPicker extends JFrame {
	private JPanel  myContentPane = null;
	private JSlider myRedSlider = null;
	private JSlider myGreenSlider = null;
	private JSlider myBlueSlider = null;
	private JLabel  myRedLabel = null;
	private JLabel  myGreenLabel = null;
	private JLabel  myBlueLabel = null;
	private JPanel  myColorPanel = null;
	private int     myRed, myGreen, myBlue;
	private static final long serialVersionUID = 0;
	
	public ColorPicker() {
		super("ColorPicker");
		this.initializeFrame();
		this.buildSliderPanel();
		this.buildColorPanel();
		this.buildButtonPanel();
	}
	
	private void initializeFrame() {
		myContentPane = new JPanel( new BorderLayout() );
		super.setContentPane(myContentPane);
		super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		super.setBackground(Color.WHITE);
	}
	
	private void buildSliderPanel() {
		JPanel sliderPanel = new JPanel( new FlowLayout() );
		this.addRGBLabelsTo(sliderPanel);
		this.addSlidersTo(sliderPanel);
		this.addNumberLabelsTo(sliderPanel);
		myContentPane.add(sliderPanel, BorderLayout.NORTH);
		myRed = myGreen = myBlue = 255;
	}
	
	private void addRGBLabelsTo(JPanel containingPanel) {
		JPanel labelPane = new JPanel( new GridLayout(3,1) );
		labelPane.add( new JLabel("R") );
		labelPane.add( new JLabel("G") );
		labelPane.add( new JLabel("B") );
		containingPanel.add(labelPane);
	}
	
	private void addSlidersTo(JPanel containingPanel) {
		JPanel sliderSubPane = new JPanel( new GridLayout(3,1) );
		myRedSlider = new JSlider(0, 255);
		myRedSlider.setValue(255);
		myRedSlider.addChangeListener( new RedSliderListener() );
		sliderSubPane.add(myRedSlider);
		myGreenSlider = new JSlider(0, 255);
		myGreenSlider.setValue(255);
		myGreenSlider.addChangeListener( new GreenSliderListener() );
		sliderSubPane.add(myGreenSlider);
		myBlueSlider = new JSlider(0, 255);
		myBlueSlider.setValue(255);
		myBlueSlider.addChangeListener( new BlueSliderListener() );
		sliderSubPane.add(myBlueSlider);
		containingPanel.add(sliderSubPane);
	}
	
	private void addNumberLabelsTo(JPanel containingPanel) {
		JPanel numberPane = new JPanel( new GridLayout(3,1) );
		myRedLabel = new JLabel("255");
		numberPane.add(myRedLabel);
		myGreenLabel = new JLabel("255");
		numberPane.add(myGreenLabel);
		myBlueLabel = new JLabel("255");
		numberPane.add(myBlueLabel);
		containingPanel.add(numberPane);
	}
	
	private void buildColorPanel() {
		myColorPanel = new JPanel();
		myColorPanel.setBorder( BorderFactory.createEtchedBorder() );
		myColorPanel.setPreferredSize( new Dimension(300, 100) );
		myColorPanel.setBackground(Color.WHITE);
		myContentPane.add(myColorPanel, BorderLayout.CENTER);
	}

	private void buildButtonPanel() {
		JPanel buttonPanel = new JPanel( new GridLayout(1, 3) );
		buttonPanel.setBackground(Color.WHITE);
		buttonPanel.setBorder( BorderFactory.createEmptyBorder(4,4,4,4) );
		JButton redButton = new JButton("Red");
		redButton.setBackground(Color.RED);
		redButton.setForeground(Color.WHITE);
		redButton.addActionListener( new RedButtonListener() );
		buttonPanel.add(redButton);
		JButton greenButton = new JButton("Green");
		greenButton.setBackground(Color.GREEN);
		greenButton.setForeground(Color.WHITE);
		greenButton.addActionListener( new GreenButtonListener() );
		buttonPanel.add(greenButton);
		JButton blueButton = new JButton("Blue");
		blueButton.setBackground(Color.BLUE);
		blueButton.setForeground(Color.WHITE);
		blueButton.addActionListener( new BlueButtonListener() );
		buttonPanel.add(blueButton);
		myContentPane.add(buttonPanel, BorderLayout.SOUTH);
	}
	
	
	private class RedSliderListener implements ChangeListener {
		public void stateChanged(ChangeEvent ce) {
			myRed = myRedSlider.getValue();
			myRedLabel.setText( Integer.toString(myRed) );
			myColorPanel.setBackground( new Color(myRed, myGreen, myBlue) );
		}
	}
	
	private class GreenSliderListener implements ChangeListener {
		public void stateChanged(ChangeEvent ce) {
			myGreen = myGreenSlider.getValue();
			myGreenLabel.setText( Integer.toString(myGreen) );
			myColorPanel.setBackground( new Color(myRed, myGreen, myBlue) );
		}
	}

	private class BlueSliderListener implements ChangeListener {
		public void stateChanged(ChangeEvent ce) {
			myBlue = myBlueSlider.getValue();
			myBlueLabel.setText( Integer.toString(myBlue) );
			myColorPanel.setBackground( new Color(myRed, myGreen, myBlue) );
		}
	}
	
	private void setColor(int red, int green, int blue) {
		myRedSlider.setValue(red);
		myRedLabel.setText( Integer.toString(red) );
		myGreenSlider.setValue(green);
		myGreenLabel.setText( Integer.toString(green) );
		myBlueSlider.setValue(blue);
		myBlueLabel.setText( Integer.toString(blue) );
		myColorPanel.setBackground(new Color(red, green, blue) );
		myRed = red; myGreen = green; myBlue = blue;
	}
	
	private class RedButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			setColor(255, 0, 0);
		}
	}
	
	private class GreenButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			setColor(0, 255, 0);
		}
	}
	
	private class BlueButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			setColor(0, 0, 255);
		}
	}
	
	private void centerFrame() {
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int drawAtX = screen.width / 2 - super.getWidth() / 2;
		int drawAtY = screen.height / 2 - super.getHeight() / 2;
		super.setLocation(drawAtX, drawAtY);
	}
	
	public static void main(String[] args) {
		ColorPicker self = new ColorPicker();
		self.pack();
		self.centerFrame();
		self.setVisible(true);
	}
}
