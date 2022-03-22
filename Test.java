
/**
 * Tests для программы
 */

import java.util.Scanner;

public class Test {

	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		System.out.println("Input string:");
		String _str;
		int _firstNum, _secondNum;
		_str = input.nextLine();
		Parser pars = new Parser(_str);
		pars.parser(_str);
		_firstNum = pars._firstNum;
		_secondNum = pars._secondNum;
		switch (pars._operation) {
			case '+':
				System.out.println(pars.add(_firstNum, _secondNum));
				break;
			case '-':
				System.out.println(pars.subs(_firstNum, _secondNum));
				break;
			case '/': {
				try {
					if (_secondNum == 0)
						throw new RuntimeException();
				} catch (Exception ex) {
					System.err.println("throws Exception: / by zero");
					System.exit(-1);
				}
				System.out.println(pars.div(_firstNum, _secondNum));
				break;
			}
			case '*':
				System.out.println(pars.multi(_firstNum, _secondNum));
				break;
			default: {
				try {
					throw new RuntimeException();
				} catch (Exception ex) {
					System.err.println("throws Exception: Unknown operation");
					System.exit(-1);
				}
			}
		}
	}
}