package other.stringbuilder;

public class Main {

	public static void main(String[] args) {
		String string = "aaa";
		System.out.println(string);
		string += "bb";
		System.out.println(string);
		
		StringBuilder stringBuilder = new StringBuilder("ccc");
		System.out.println(stringBuilder);
		stringBuilder.append("ddd");
		System.out.println(stringBuilder);

	}

}
