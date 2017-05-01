import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MainFrame extends JFrame{
	JTextField RVal, GVal, BVal;
	int r, g, b;
	JTextArea colorArea;
	JSlider RSlider, GSlider, BSlider;
	
	public MainFrame(){
		this.setTitle("Color Chooser");
		this.setBounds(200, 200, 450, 170);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
		
		JPanel choosePanel = new JPanel();
		choosePanel.setLayout(new GridLayout(3, 1));
		
		JPanel RPanel = new JPanel();
		JLabel RLabel = new JLabel("R: ");
		RSlider = new JSlider(0, 255, 127);
		r = RSlider.getValue();
		RVal = new JTextField(5);
		//RVal.setBorder(null);
		RVal.setHorizontalAlignment(JTextField.CENTER);
		RVal.setEditable(false);
		RVal.setText("" + r);
		RPanel.add(RLabel);
		RPanel.add(RSlider);
		RPanel.add(RVal);
		choosePanel.add(RPanel);
		
		JPanel GPanel = new JPanel();
		JLabel GLabel = new JLabel("G: ");
		GSlider = new JSlider(0, 255, 127);
		g = GSlider.getValue();
		GVal = new JTextField(5);
		//GVal.setBorder(null);
		GVal.setHorizontalAlignment(JTextField.CENTER);
		GVal.setEditable(false);
		GVal.setText("" + g);
		GPanel.add(GLabel);
		GPanel.add(GSlider);
		GPanel.add(GVal);
		choosePanel.add(GPanel);
		
		JPanel BPanel = new JPanel();
		JLabel BLabel = new JLabel("B: ");
		BSlider = new JSlider(0, 255, 127);
		b = BSlider.getValue();
		BVal = new JTextField(5);
		//BVal.setBorder(null);
		BVal.setHorizontalAlignment(JTextField.CENTER);
		BVal.setEditable(false);
		BVal.setText("" + b);
		BPanel.add(BLabel);
		BPanel.add(BSlider);
		BPanel.add(BVal);
		choosePanel.add(BPanel);
		
		this.add(choosePanel);
		
		JPanel showPanel = new JPanel();
		colorArea = new JTextArea(5, 8);
		colorArea.setBackground(new Color(r, g, b));
		colorArea.setEditable(false);
		showPanel.add(colorArea);
		this.add(showPanel);
		
		this.setVisible(true);
	}
	
	class AdjustSlider implements ChangeListener{
		
		public AdjustSlider(){
			RSlider.addChangeListener(this);
			GSlider.addChangeListener(this);
			BSlider.addChangeListener(this);
		}
		
		public void stateChanged(ChangeEvent e){
			r = RSlider.getValue();
			RVal.setText("" + r);
			g = GSlider.getValue();
			GVal.setText("" + g);
			b = BSlider.getValue();
			BVal.setText("" + b);
			colorArea.setBackground(new Color(r, g, b));
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MainFrame mainFrame = new MainFrame();
		MainFrame.AdjustSlider adjustSlider = mainFrame.new AdjustSlider();
	}

}
