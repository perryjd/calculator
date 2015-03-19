public class ScratchPad {
	public static void main (String[] args) {
		String str = "arf goes the dog";
		String[] parts = str.split(" ");
		for (int n = 0; n < parts.length; n++)
			System.out.print(parts[n] + ", ");
	}
}