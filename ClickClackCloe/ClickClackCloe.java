import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ClickClackCloe extends JApplet {
	private final int MY_ROWS = 3,
			MY_COLUMNS = 3;
	
	private JLabel myFeedbackLabel = null;
	private JButton [] [] myGrid = null;
	private boolean itsRedsTurn = true,
			gameIsDone = false;
	private static final long serialVersionUID = 1L;
	
	public void init() {
		JPanel contentPane = new JPanel( new BorderLayout() );
		contentPane.setBorder( BorderFactory.createEtchedBorder() );
		JPanel topPane = new JPanel( new FlowLayout() );
		topPane.setBorder( BorderFactory.createEmptyBorder(5, 5, 5, 5) );
		myFeedbackLabel = new JLabel("Red vs. Blue. Red's turn.");
		topPane.add(myFeedbackLabel);
		contentPane.add(topPane, BorderLayout.NORTH);
		JPanel gridPane = new JPanel( new GridLayout(MY_ROWS, MY_COLUMNS) );
		gridPane.setBorder( BorderFactory.createEtchedBorder() );
		myGrid = new JButton[MY_ROWS] [MY_COLUMNS];
		ButtonListener buttonListener = new ButtonListener();
		for (int r = 0; r < MY_ROWS; r++) {
			for (int c = 0; c < MY_COLUMNS; c++) {
				myGrid[r][c] = new JButton();
				myGrid[r][c].setBackground(Color.WHITE);
				myGrid[r][c].addActionListener(buttonListener);
				gridPane.add(myGrid[r][c]);
			}
		}
		contentPane.add(gridPane);
		this.setContentPane(contentPane);
	}
	
	private class ButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent event) {
			if ( !gameIsDone ) {
				Object eventSource = event.getSource();
				if (eventSource instanceof JButton) {
					JButton buttonClicked = (JButton) eventSource;
					if (itsRedsTurn) {
						handleClick(buttonClicked, Color.RED, "Red", "Blue");
					} else {
						handleClick(buttonClicked, Color.BLUE, "Blue", "Red");
					}
				}
			}
		}
		
		private void handleClick(JButton button, Color playerColor, String thisPlayer, String nextPlayer) {
			if (button.getBackground() == Color.WHITE) {
				button.setBackground(playerColor);
				if ( this.gameOver() ) {
					myFeedbackLabel.setText(thisPlayer + " WINS!");
					gameIsDone = true;
				} else {
					myFeedbackLabel.setText(nextPlayer + "'s turn.");
				}
				itsRedsTurn = !itsRedsTurn;
			}
		}
		
		private boolean gameOver() {
			if ( checkDiagonals() ) return true;
			else if ( checkRows() ) return true;
			else if ( checkColumns() ) return true;
			else { return false; }
		}
		
		private boolean checkDiagonals() {
			Color middleColor = myGrid[1][1].getBackground();
			if (middleColor != Color.WHITE) {
				return middleColor == myGrid[0][0].getBackground()
						&& middleColor == myGrid[2][2].getBackground() ||
						middleColor == myGrid[0][2].getBackground()
						&& middleColor == myGrid[2][0].getBackground();
			}
			return false;
		}
		
		private boolean checkRows() {
			for (int r = 0; r < MY_ROWS; r++) {
				Color cellColor = myGrid[r][0].getBackground();
				if ( cellColor != Color.WHITE
						&& cellColor == myGrid[r][1].getBackground()
						&& cellColor == myGrid[r][2].getBackground()) {
					return true;
				}
			}
			return false;
		}
		
		private boolean checkColumns() {
			for (int c = 0; c < MY_COLUMNS; c++) {
				Color cellColor = myGrid [0][c].getBackground();
				if ( cellColor != Color.WHITE
						&& cellColor == myGrid[1][c].getBackground()
						&& cellColor == myGrid[2][c].getBackground()) {
					return true;
				}
			}
			return false;
		}
	}
}
