package application;

public class RLE {

	public static String encode(String plainText) {
		StringBuilder sb = new StringBuilder();
		char[] word = plainText.toCharArray();
		char current = word[0];
		int index = 0;
		int count = 0;

		for (char c : word) {
			if (c == current) {
				count++;
				index++;

				if (index == word.length)
					sb.append(current + Integer.toString(count));
			}else {
				sb.append(current + Integer.toString(count) + ",");
				count = 1;
				current = c;
				index++;
			}
		}
		return sb.toString();
	}

	public static String decode(String encodedText) {
		StringBuilder sb = new StringBuilder();
		char[] encode = encodedText.toCharArray();
		char current = encode[0];
		for (char c : encode) {

			if (!Character.isDigit(c)) {
				current = c;
			} else {
				int n = Integer.parseInt(String.valueOf(c));
				for (int i = 0; i < n; i++) {
					sb.append(current);
				}
			}
		}
		return sb.toString().replace(",", "");
	}

	public static void main(String[] args) {

		System.out.println(RLE.encode("aaasssfdfsdfaaa"));
		System.out.println(RLE.decode("a3,s3,f1,d1,f1,s1,d1,f1,a3"));
	}
}
