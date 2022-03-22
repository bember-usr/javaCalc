import javax.management.ConstructorParameters;

/**
 * ArabicNum
 */
public class ArabicNum extends Parser {	//наследование; имеет доступ ко всем полям кроме private
	// private int _firstNum;
	// private int _secondNum;
	// private char _operation;

	public ArabicNum(String str) {
		super(str);	//вызов конструктора базового класса
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