class StackX {
	private int maxSize;
	private String[] stackArray;
	private int top;

	public StackX(int s) {
		maxSize = s;
		stackArray = new String[maxSize];
		top = -1;
	}

	public void push(String j) {
		stackArray[++top] = j;
	}

	public String pop() {
		return stackArray[top--];
	}

	public String peek() {
		return stackArray[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}

	public int size() {
		return top + 1;
	}

	public String peekN(int n) {
		return stackArray[n];
	}
}

class InToPost {
	private StackX theStack;
	private String[] input;
	private String output = "";

	public InToPost(String in) {
		input = in.split(" ");
		int stackSize = input.length;
		theStack = new StackX(stackSize);
	}

	public String doTrans() {
		System.out.println("inside doTrans");
		for (int j = 0; j < input.length; j++) {
			String str = input[j];
			switch (str) {
				case "+":
				case "-":
					gotOper(str, 1);
					break;
				case "*":
				case "/":
					gotOper(str, 2);
					break;
				case "(":
					theStack.push(str);
					break;
				case ")":
					gotParen(str);
					break;
				default:
					output = output + str + " ";
					break;
			}
		}
		while (!theStack.isEmpty()) {
			output += theStack.pop();
		}
		return output;
	}

	public void gotOper(String opThis, int prec1) {
		while (!theStack.isEmpty()) {
			String opTop = theStack.pop();
			if (opTop.equals("(")) {
				theStack.push(opTop);
				break;
			}
			else {
				int prec2;

				if (opTop.equals("+") || opTop.equals("-"))
					prec2 = 1;
				else
					prec2 = 2;
				if (prec2 < prec1) {
					theStack.push(opTop);
					break;
				}
				else
					output = output + opTop + " ";
			}
		}
		theStack.push(opThis);
	}

	public void gotParen(String ch) {
		while (!theStack.isEmpty()) {
			String chx = theStack.pop();
			if (chx == "(")
				break;
			else
				output = output + chx + " ";
		}
	}
}

class ParsePost {
	private StackX theStack;
	private String[] input;

	public ParsePost (String s) {
		input = s.split(" ");
	}

	public double doParse() {
		theStack = new StackX(20);
		String ch;
		int j;
		double num1, num2, interAns;

		for (j = 0; j < input.length; j++) {
			ch = input[j];
			if (ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/")) {
				num2 = Double.parseDouble(theStack.pop());
				num1 = Double.parseDouble(theStack.pop());
				switch (ch) {
					case "+":
						interAns = num1 + num2;
						break;
					case "-":
						interAns = num1 - num2;
						break;
					case "*":
						interAns = num1 * num2;
						break;
					case "/":
						interAns = num1 / num2;
						break;
					default:
						interAns = 0;
					}
				theStack.push(Double.toString(interAns));
				}
			else {
				theStack.push(ch);
				}
			}
		interAns = Double.parseDouble(theStack.pop());
		return interAns;
	}
}

class Calculator {

	public String calculate (String input) {
		System.out.println("inside calculator...");
		InToPost toSolve = new InToPost (input);
		String midSolve = toSolve.doTrans();

		System.out.println(midSolve);

		ParsePost solver = new ParsePost (midSolve);
		double solution = solver.doParse();
		return (Double.toString(solution) + " ");

	}
}
