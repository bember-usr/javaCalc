/**
 * RimNum
 */
public class RimNum extends Parser {

	public RimNum(String str) {
		super(str);
	}

	
	public int getFirstNum() {
		return (_firstNum);
	}

	public int getSecondNum() {
		return (_secondNum);
	}
	
	public char getOperation() {
		return (_operation);
	}
}