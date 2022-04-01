
/**
 * Parser
 */
import java.lang.String;
import java.util.Scanner;

public class Parser {

	private static int _firstNum;
	private static int _secondNum;
	private static char _operation;
	private static String arabicNumString = "1234567890";
	private static String rimNumString = "IVX";
	private static String operationCounString = "+-/*";
	private static boolean flagIsRim = false;
	private static boolean flagIsArabic = false;
	// private static ThrowClass throwC;

	public Parser() {
	}

	public static int getFirstNum() {
		return (_firstNum);
	}

	public static int getSecondNum() {
		return (_secondNum);
	}

	public static char getOperation() {
		return (_operation);
	}

	public static boolean IsMixed(String _str) {
		for (int i = 0; i < _str.length(); i++) {
			if (rimNumString.indexOf(_str.charAt(i)) != -1) {
				flagIsRim = true;
				if (flagIsArabic)
					ThrowClass.throwMixedAlphabet(_str);
			} else if (arabicNumString.indexOf(_str.charAt(i)) != -1)// если есть
			{
				flagIsArabic = true;
				if (flagIsRim)
					ThrowClass.throwMixedAlphabet(_str);
			}
		}
		return (flagIsRim);
	}

	public static void parser(String _str) {
		_str = _str.replace(" ", "");
		flagIsRim = IsMixed(_str);
		if (flagIsRim) {
			_str = RimNum.parser(_str);
			_firstNum = RimNum.getFirstNum();
			_secondNum = RimNum.getSecondNum();
			_operation = RimNum.getOperation();
		}
		ThrowClass.throwNegativeNums(_str);
		ThrowClass.throwDoubleNums(_str);
		ThrowClass.throwGreaterNums(_str);
		ThrowClass.throwMoreOperand(_str);
		if (flagIsRim) {
			ThrowClass.throwRimFirstSmaller(_str);
			ThrowClass.throwOperator(_operation, operationCounString);
			return;
		}
		int i = 0;
		while (_str.charAt(i) >= '0' && _str.charAt(i) <= '9')
			i++;
		_firstNum = Integer.parseInt(_str.substring(0, i));
		
		_str = _str.substring(i, _str.length());
		i = 0;
		_operation = _str.charAt(i);
		_str.substring(i, _str.length());
		_str = _str.substring(i + 1, _str.length());
		ThrowClass.throwOperator(_operation, operationCounString);
		i = 0;
		while (_str.isEmpty() && _str.charAt(i) >= '0' && _str.charAt(i) <= '9')
			i++;
		_secondNum = Integer.parseInt(_str.substring(i, _str.length()));
		_str = _str.substring(i, _str.length());
	}

	public static void add(int firstNum, int secondNum) {
		if (flagIsRim)
			System.out.println(RimNum.convert(firstNum + secondNum));
		else
			System.out.println(firstNum + secondNum);
	}

	public static void subs(int firstNum, int secondNum) {
		if (flagIsRim)
			System.out.println(RimNum.convert(firstNum - secondNum));
		else
			System.out.println(firstNum - secondNum);
	}

	public static void multi(int firstNum, int secondNum) {
		if (flagIsRim)
			System.out.println(RimNum.convert(firstNum * secondNum));
		else
			System.out.println(firstNum * secondNum);
	}

	public static void div(int firstNum, int secondNum) {
		if (flagIsRim)
		{
			System.out.println(RimNum.convert(firstNum / secondNum));
		}
		else
			System.out.println(firstNum / secondNum); // отбрасывает любой остаток
	}
}
