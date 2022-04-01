
/**
 * RimNum
 */
import java.util.*;

public class RimNum {

	private static int _firstNum;
	private static int _secondNum;
	private static char _operation;
	private static String rimNumString = "IVXLC";
	private static Map<Character, Integer> map = new HashMap<>();

	public RimNum() {
	}

	public static String parser(String parseStr) {
		String str1 = "", str2 = "";
		int i = 0;

		if (rimNumString.indexOf(parseStr.charAt(i)) == -1)
			ThrowClass.throwUncnownSymb();
		while (rimNumString.indexOf(parseStr.charAt(i)) != -1) {
			if (rimNumString.indexOf(parseStr.charAt(i)) == -1)
				ThrowClass.throwUncnownSymb();
			str1 += parseStr.charAt(i);
			i++;
		}
		RimNum._firstNum = convertString(str1);
		RimNum._operation = parseStr.charAt(i);
		i++;
		while (i < parseStr.length()) {
			if (rimNumString.indexOf(parseStr.charAt(i)) == -1)
				ThrowClass.throwUncnownSymb();
			str2 += parseStr.charAt(i);
			i++;
		}
		RimNum._secondNum = convertString(str2);
		return (Integer.toString(RimNum._firstNum) + RimNum._operation + Integer.toString(RimNum._secondNum));
	}

	public static int convertString(String str1) {

		RimNum.map.put('I', 1);
		RimNum.map.put('V', 5);
		RimNum.map.put('X', 10);
		RimNum.map.put('L', 50);
		RimNum.map.put('C', 100);
		RimNum.map.put('D', 500);
		RimNum.map.put('M', 1000);

		int tmp = 0;
		int res = 0;

		for (int i = 0; i < str1.length(); i++) {
			Integer n = map.get(str1.charAt(i));
			if (n < tmp) {
				res += tmp;
				tmp = n;
			} else if (n > tmp) {
				if (tmp == 0)
					tmp = n;
				else {
					res += n - tmp;
					tmp = 0;
				}
			} else if (n == tmp) {
				res += tmp + n;
				tmp = 0;
			}
		}
		return (res + tmp);
	}

	public static String convert(int in) {
		StringBuffer a = new StringBuffer("");

		// Выделяем сотни из остатка
		int c1 = in / 100;
		if (c1 != 0)
			a.append(C(c1));
		// остаток из сотен
		int c2 = in % 100;

		// Выделяем полсотни
		int l1 = c2 / 50;
		if (l1 != 0)
			a.append(L(l1));
		// остаток
		int l2 = c2 % 50;

		// Выделяем десятки
		int x1 = l2 / 10;
		if (l2 != 0)
			a.append(X(x1));
		// остаток
		int x2 = l2 % 10;

		// Выделяем то что осталось
		a.append(basic(x2));
		return (a.toString());
	}

	// преобразовываем целые тысячи
	// с значениями,кратными десяти, но не 5,всё просто
	private static String M(int in) {
		StringBuffer a = new StringBuffer("");
		int i = 0;
		while (i < in) {
			a.append("M");
			i++;
		}
		return a.toString();
	}

	// преобразовываем целые сотни
	private static String C(int in) {
		if (in == 4)
			return "CD"; // если 400, то 500-100
		else if ((in != 0) && (in < 4)) {
			StringBuffer a = new StringBuffer("");
			int i = 0;
			while (i < in) {
				a.append("C");
				i++;
			}
			return a.toString();
		} else
			return "";
	}

	// целые десятки

	private static String X(int in) {
		if (in == 4)
			return "XL"; // если 40, то 50-10
		else if ((in != 0) && (in < 4)) {
			StringBuffer a = new StringBuffer("");
			int i = 0;
			while (i < in) {
				a.append("X");
				i++;
			}
			return a.toString();
		} else
			return "";
	}

	// преобразовываем пол тысячи
	private static String D(int in) {

		if (in == 4)
			return "CM"; // если 900, то 1000-100
		else
			return "D";
	}

	private static String L(int in) {
		if (in == 4)
			return "XC"; // если90 то100 - 10
		return "L";

	}

	// От 1 до 9, то что осталось
	private static String basic(int in) {
		String[] a = {
				"",
				"I",
				"II",
				"III",
				"IV",
				"V",
				"VI",
				"VII",
				"VIII",
				"IX"
		};
		return a[in];
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
}