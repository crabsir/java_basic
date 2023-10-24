import java.util.Objects;
import function.Functional;

public class HelloWorld {

	public static void main(String[] args) {
		System.out.println("Hello world!");
		String f = "default";
		String s = Functional.ternaryOperator(Objects::isNull, x -> f, Object::toString).apply(null);

		System.out.println(s);
	}


}