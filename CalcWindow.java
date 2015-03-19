import java.awt.*;
import java.awt.event.*;

public class CalcWindow extends Frame implements ActionListener {

	/**
	 * @param args
	 */
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	private Panel textPanel;
	private TextField displayer;
	private String toParse = "";
	
	public CalcWindow() {
		super();
		setSize(WIDTH, HEIGHT);
		setTitle("Calculator");
		
		addWindowListener(new WindowDestroyer());
		
		textPanel = new Panel();
		displayer = new TextField(40);
		textPanel.add(displayer);
		
		Button clearButton = new Button("CLEAR");
		clearButton.addActionListener(this);
		textPanel.add(clearButton);
		
		Panel buttonPanel = new Panel();
		buttonPanel.setLayout(new GridLayout(4,4));
		
		Button sevenButton = new Button("7");
		sevenButton.addActionListener(this);
		buttonPanel.add(sevenButton);
		
		Button eightButton = new Button("8");
		eightButton.addActionListener(this);
		buttonPanel.add(eightButton);
		
		Button nineButton = new Button("9");
		nineButton.addActionListener(this);
		buttonPanel.add(nineButton);
		
		Button divideButton = new Button("/");
		divideButton.addActionListener(this);
		buttonPanel.add(divideButton);
		
		Button fourButton = new Button("4");
		fourButton.addActionListener(this);
		buttonPanel.add(fourButton);
		
		Button fiveButton = new Button("5");
		fiveButton.addActionListener(this);
		buttonPanel.add(fiveButton);
		
		Button sixButton = new Button("6");
		sixButton.addActionListener(this);
		buttonPanel.add(sixButton);
		
		Button multiplyButton = new Button("*");
		multiplyButton.addActionListener(this);
		buttonPanel.add(multiplyButton);
		
		Button oneButton = new Button("1");
		oneButton.addActionListener(this);
		buttonPanel.add(oneButton);
		
		Button twoButton = new Button("2");
		twoButton.addActionListener(this);
		buttonPanel.add(twoButton);
		
		Button threeButton = new Button("3");
		threeButton.addActionListener(this);
		buttonPanel.add(threeButton);
		
		Button minusButton = new Button("-");
		minusButton.addActionListener(this);
		buttonPanel.add(minusButton);
		
		Button zeroButton = new Button("0");
		zeroButton.addActionListener(this);
		buttonPanel.add(zeroButton);
		
		Button pointButton = new Button(".");
		pointButton.addActionListener(this);
		buttonPanel.add(pointButton);
		
		Button equalsButton = new Button("=");
		equalsButton.addActionListener(this);
		buttonPanel.add(equalsButton);
		
		Button plusButton = new Button("+");
		plusButton.addActionListener(this);
		buttonPanel.add(plusButton);
		
		
		
		setLayout(new BorderLayout());
		add(textPanel, "North");
		add(buttonPanel, "Center");
		
	}
	
	public void paint(Graphics g) {
	}
	
	public void actionPerformed(ActionEvent e) {
		Calculator calcer = new Calculator();
		String actionCommand = e.getActionCommand();
		if (actionCommand.equals("=")) {
			System.out.println("Trying to parse...");
			toParse = calcer.calculate(toParse);
		}
		else if (actionCommand.equals("CLEAR"))
			toParse = "";
		else if (actionCommand.equals("+") || actionCommand.equals("-") || actionCommand.equals("/") || actionCommand.equals("*"))
			toParse += actionCommand + " ";
		else
			toParse += Double.toString(Double.parseDouble(actionCommand)) + " ";

		displayer.setText(toParse);
		textPanel.repaint();
	}
}
