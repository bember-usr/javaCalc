
import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		String str;
		Scanner in = new Scanner(System.in);
		try {
			System.out.println("Input string:");
			str = in.nextLine();
		} finally{
			in.close();
		}
		Parser.parser(str);
		switch (Parser.getOperation()) {
			case '+':
				Parser.add(Parser.getFirstNum(), Parser.getSecondNum());
				break;
			case '-':
				Parser.subs(Parser.getFirstNum(), Parser.getSecondNum());
				break;
			case '/': {
				Parser.div(Parser.getFirstNum(), Parser.getSecondNum());
				break;
			}
			case '*':
				Parser.multi(Parser.getFirstNum(), Parser.getSecondNum());
				break;
		}
	}
}