package example.ToolUtils;

import java.util.Random;

public class ToolUtil {

	public static String genString() {

		StringBuffer str = new StringBuffer();

		Random rand = new Random(47);

		for (int i = 0; i <= 5; i++) {
			char c = (char) (Math.random() * 26 + 'A');
			str.append(c);
		}

		return str.toString();

	}
}
