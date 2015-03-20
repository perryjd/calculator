import java.awt.*;
import java.awt.event.*;

public class CalcWindow extends Frame implements ActionListener {

	/**
	 * @param args
	 */
	public static final int WIDTH = 300;
	public static final int HEIGHT = 300;
	private Panel textPanel;
	private TextField displayer;
	private String toParse = "";
	Font inputPanelFont = new Font("Garamond", Font.PLAIN, 35);
	Font textPanelFont = new Font("Garamond", Font.PLAIN, 10);

	private String backSpace(String toFix) {
		String temp = "";
		int n;

		if (toFix.charAt(toFix.length() -1) == ' ')
			for (n = 0; n < toFix.length() - 3; n++)
				temp += toFix.charAt(n);
		else
			for (n = 0; n < toFix.length() - 1; n++)
				temp += toFix.charAt(n);
		return temp;
	}
	
	public CalcWindow() {
		super();
		setSize(WIDTH, HEIGHT);
		setTitle("Calculator");
		
		addWindowListener(new WindowDestroyer());
		
		textPanel = new Panel();
		displayer = new TextField(20);
		textPanel.add(displayer);
		textPanel.setFont(textPanelFont);
		
		Button clearButton = new Button("CLEAR");
		clearButton.addActionListener(this);
		textPanel.add(clearButton);

		Button backSpaceButton = new Button("BACKSPACE");
		backSpaceButton.addActionListener(this);
		textPanel.add(backSpaceButton);

		Panel inputPanel = new Panel();
		inputPanel.setFont(inputPanelFont);
		
		Panel buttonPanel = new Panel();
		buttonPanel.setLayout(new GridLayout(4,3));
		
		Button sevenButton = new Button("7");
		sevenButton.addActionListener(this);
		buttonPanel.add(sevenButton);
		
		Button eightButton = new Button("8");
		eightButton.addActionListener(this);
		buttonPanel.add(eightButton);
		
		Button nineButton = new Button("9");
		nineButton.addActionListener(this);
		buttonPanel.add(nineButton);
		
		Button fourButton = new Button("4");
		fourButton.addActionListener(this);
		buttonPanel.add(fourButton);
		
		Button fiveButton = new Button("5");
		fiveButton.addActionListener(this);
		buttonPanel.add(fiveButton);
		
		Button sixButton = new Button("6");
		sixButton.addActionListener(this);
		buttonPanel.add(sixButton);
		
		Button oneButton = new Button("1");
		oneButton.addActionListener(this);
		buttonPanel.add(oneButton);
		
		Button twoButton = new Button("2");
		twoButton.addActionListener(this);
		buttonPanel.add(twoButton);
		
		Button threeButton = new Button("3");
		threeButton.addActionListener(this);
		buttonPanel.add(threeButton);

		Button zeroButton = new Button("0");
		zeroButton.addActionListener(this);
		buttonPanel.add(zeroButton);

		Button pointButton = new Button(".");
		pointButton.addActionListener(this);
		buttonPanel.add(pointButton);

		Button equalsButton = new Button("=");
		equalsButton.addActionListener(this);
		buttonPanel.add(equalsButton);

		Panel opPanel =  new Panel();
		opPanel.setLayout(new GridLayout(3, 2));
		
		Button minusButton = new Button("-");
		minusButton.addActionListener(this);
		opPanel.add(minusButton);
		
		Button multiplyButton = new Button("*");
		multiplyButton.addActionListener(this);
		opPanel.add(multiplyButton);

		Button divideButton = new Button("/");
		divideButton.addActionListener(this);
		opPanel.add(divideButton);
		
		Button plusButton = new Button("+");
		plusButton.addActionListener(this);
		opPanel.add(plusButton);

		Button openParenButton = new Button("(");
		openParenButton.addActionListener(this);
		opPanel.add(openParenButton);

		Button closeParenButton = new Button(")");
		closeParenButton.addActionListener(this);
		opPanel.add(closeParenButton);
		
		
		
		setLayout(new BorderLayout());
		add(textPanel, "North");
		add(inputPanel, "Center");
		inputPanel.add(buttonPanel);
		inputPanel.add(opPanel);
		//add(buttonPanel, "Center");
		//add(opPanel, "East");
		
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
		else if (actionCommand.equals("BACKSPACE"))
			toParse = backSpace(toParse);
		else if (actionCommand.equals("+") || actionCommand.equals("-") || actionCommand.equals("/") || actionCommand.equals("*") || actionCommand.equals("(") || actionCommand.equals(")"))
			toParse += " " + actionCommand + " ";
		else
			toParse += actionCommand;

		displayer.setText(toParse);
		textPanel.repaint();
	}
}
