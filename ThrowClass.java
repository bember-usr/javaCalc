import javax.management.RuntimeErrorException;

/**
 * ThrowClass
 */
public class ThrowClass {

	public ThrowClass() {
	}

	public static void throwNegativeNums(String _str) {
		try {
			boolean flagMinus = false;
			int i = 0;
			if (_str.charAt(i) == '-')
				flagMinus = true;
			while (_str.charAt(i) >= '0' && _str.charAt(i) <= '9')
				i++;
			_str = _str.substring(i + 1, _str.length());
			i = 0;
			if (_str.charAt(i) == '-')
				flagMinus = true;
			if (flagMinus)
				throw new RuntimeException();
			else
				return;
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

	public static void throwGreaterNums(String _str) {//функция проверяющая на число>10 или <1
		try {
			int i = 0;
			int first, second;
			while (_str.charAt(i) >= '0' && _str.charAt(i) <= '9')
				i++;
			first = Integer.parseInt(_str.substring(0, i));//тут число
			_str = _str.substring(i + 1, _str.length());
			i = 0;
			while (i < _str.length() && _str.charAt(i) >= '0' && _str.charAt(i) <= '9')
				i++;
			second = Integer.parseInt(_str.substring(0, i));//тут число
			if (first > 10 || second > 10 || first < 1 || second < 1)
				throw new RuntimeException();
			else
				return;
		} catch (Exception ex) {
			System.err.print("throws Exception: Number greater than 10 or 0");
			System.exit(-1);
		}
	}

	public static void throwMoreOperand(String _str) {
		try {
			int i = 0;
			while (_str.charAt(i) >= '0' && _str.charAt(i) <= '9')
				i++;
			_str = _str.substring(i + 1, _str.length());
			i = 0;
			while (i < _str.length() && _str.charAt(i) >= '0' && _str.charAt(i) <= '9')
				i++;
			_str = _str.substring(i, _str.length());
			if (!_str.isEmpty())
				throw new RuntimeException();
		} catch (Exception ex) {
			System.err.println("throws Exception: More than two operand");
			System.exit(-1);
		}
	}

	public static void throwMixedAlphabet(String _str) {
		try {
			throw new RuntimeException();
		} catch (Exception ex) {
			System.err.println("throws Exception: Mixed roman nums and arabic");
			System.exit(-1);
		}
	}


	public static void throwOperator(char oper, String operationCounString) {
		try {
			if (operationCounString.indexOf(oper) == -1)
				throw new RuntimeException();
		} catch (Exception ex) {
			System.err.println("throws Exception: Unknown operation");
			System.exit(-1);
		}
	}

	public static void throwRimFirstSmaller(String _str) {
		try {
			int i = 0;
			int first, second;
			char oper;
			while (_str.charAt(i) >= '0' && _str.charAt(i) <= '9')
				i++;
			first = Integer.parseInt(_str.substring(0, i));
			oper = _str.charAt(i);
			_str = _str.substring(i + 1, _str.length());
			i = 0;
			while (i < _str.length() && _str.charAt(i) >= '0' && _str.charAt(i) <= '9')
				i++;
			second = Integer.parseInt(_str.substring(0, i));
			if (oper == '-')
			{
				if (first < second)
					throw new RuntimeException();
				else if (first == second)
					throwSmallerThan1();
			}
			else if (oper == '/' && first < second )
				throwSmallerThan1();
		} catch (Exception ex) {
			System.err.print("throws Exception: First num smaller than second");
			System.exit(-1);
		}
	}
	
	public static void throwSmallerThan1() {
		try {
			throw new RuntimeException();
		} catch (Exception e) {
			System.err.print("throws Exception: Answer is smaller than 1");
			System.exit(-1);
		}
	}

	public static void throwUncnownSymb() {
		try
		{
			throw new RuntimeException();
		}
		catch (Exception ex)
		{
			System.err.println("throws Exception: Unknown symbol");
			System.exit(-1);
		}
	}
}