package javaCalc;

/**
 * ExTest
 */
import java.util.*;

import javax.print.DocFlavor.INPUT_STREAM;

public class ExTest {
	public static int convertString(String str1) {
		Map<Character, Integer> map = new HashMap<>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

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
	public static void main(String[] args) {
		// String str;
		// Scanner in = new Scanner(System.in);
		// try {
		// 	System.out.println("Input string:");
		// 	str = in.nextLine();
		// } finally {
		// 	in.close();
		// }
		// RomanNum num = RomanNum.I;
		// System.out.println(num);
		String romanNums[] = {
			"IV",
			"III",
			"XXI",
			"V",
			"XC"
		};
		for (var r : romanNums) {
			System.out.println(r + "  is  " + convertString(r));
		}
	}
}