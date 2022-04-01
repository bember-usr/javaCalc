package javaCalc;

public enum RomanNum {
	// I(1, "I"), II(2, "II"), III(3, "III"), IV(4, "IV"), V(5, "V"),
	// VI(6, "VI"), VII(7, "VII"), VIII(8, "VIII"),  IX(9, "XI"), X(10, "X"),
	// XL(40, "XL"), L(50, "L"), XC(90, "XC"), C(100, "C");

	I(1), IV(4), V(5), IX(9), X(10),
	XL(40), L(50), XC(90), C(100);

	private int valueI;
	private String valueS;


	public static void romanToArabic(String str) {
		// this.valueI;
		// return ();
	}
	RomanNum(int value) {
		this.valueI = value;
	}

	RomanNum(String value) {
		this.valueS = value;
	}

	public int getValueI() {
		return valueI;
	}
	
	public String getValueS() {
		return valueS;
	}

}
