/**
 * Parser
 */
import java.lang.String;
import java.util.Scanner;

public class Parser {

	// элементы-данные - protected, чтобы main не имел доступ
	protected static String _str;
	protected static int _firstNum;
	protected static int _secondNum;
	protected static char _operation;
	private static String arabicNumString = "12345678910";
	private static String rimNumString = "IVXLCDM";
	private static String operationCounString = "+-/*";

	//#region
	public Parser(String str) {
		this._str = str;
	}
	
	public static int getCountsOfDigits(int number) {
		int count = (number == 0) ? 1 : 0;
		while (number != 0) {
			count++;
			number /= 10;
		}
		return count;
	}

	public static void throwNegativeNums(String _str) {
		try {
			int doubleNum = _str.indexOf('-');
			if (doubleNum == 0)
				throw new RuntimeException();
		} catch (Exception e) {
			System.err.println("throws Exception: Negative numbers");
			System.exit(-1);
		}
	}

	public static void throwDoubleNums(String _str) {
		try {
			int doubleNum = _str.indexOf('.');
			int doubleNum1 = _str.indexOf(',');
			if (doubleNum != -1 || doubleNum1 != -1)
				throw new RuntimeException();
		} catch (Exception ex) {
			System.err.println("throws Exception: Double number noticed");
			System.exit(-1);
		}
	}

	public static void throwGreaterNums(String _str) {
		try {
			if (_str.length() == 2) {
				if (_str.charAt(1) != 0)
					throw new RuntimeException();
			} else if (_str.length() > 2) {
				if (_str.charAt(1) >= '0' && _str.charAt(1) <= '9')
					if (_str.charAt(1) != 0)
						throw new RuntimeException();
			}
		} catch (Exception ex) {
			System.err.print("throws Exception: Number greater than 10");
			System.exit(-1);
		}
	}
	
	public static void throwMoreOperand(String _str) {
		try {
			if (!_str.isEmpty())
				throw new RuntimeException();
		} catch (Exception ex) {
			System.err.println("throws Exception: More than two operand");
			System.exit(-1);
		}
	}
	//#endregion
	
	public static void parser(String _str) {	// сделать универсальный парсер для обоих классов, который будет сравнивать
												// числа с массивом символов. разным будет одна проверка на вычитание
												// меньшего из большего для римских
		_str = _str.replace(" ", "");
		throwNegativeNums(_str);
		throwDoubleNums(_str);
		throwGreaterNums(_str);


		int i = 0, j = 0;
		boolean flag = false;
		while (i <= _str.length()) {
			if (operationCounString.indexOf(_str.charAt(i)) == -1)
			{
 				if (flag)
				{
					_secondNum = Integer.parseInt(_str.substring(0, i+1));
					_str = _str.substring(i + 1, _str.length());
					break;
				}
				j++;
			}
			else if (!flag) {
				_firstNum = Integer.parseInt(_str.substring(0, i));
				j = 0;
				flag = true;
				_operation = _str.charAt(i);
				_str = _str.substring(i + 1, _str.length());
				throwNegativeNums(_str);
				i = -1;
			}
			i++;
		}
		throwMoreOperand(_str);
	}
	//#region
	public static int add(int firstNum, int secondNum) {
		return (firstNum + secondNum);
	}

	public static int subs(int firstNum, int secondNum) {
		return (firstNum - secondNum);	//римские не могут быть отрицательными: отследить в парсере
	}

	public static int multi(int firstNum, int secondNum) {
		return (firstNum * secondNum);
	}

	public static int div(int firstNum, int secondNum) {
		return (firstNum / secondNum); //отбрасывает любой остаток
	}
	//#endregion

	
}