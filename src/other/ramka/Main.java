package other.ramka;

public class Main
{
	static int poz1 = 140;
	static int poz2 = 20;
	static int ramka1 = 0;
	static char border[] = new char[100];
	public static void main(String[] args) 
	{
		for(int i = 0; i < 100; i++)
		{
			border[i] = '✹';
		}
		//❤✿❃❂❁❀✾✿✽✼✻✺✹✸✷ ✶✵✴❄❅❆❇❈❉❊❋❖☀╠═╝ ❀
		String string = "aaa";
		println(string);
		string += "bb";
		println(string);
		
		StringBuilder stringBuilder = new StringBuilder("ccc");
		println(stringBuilder);
		stringBuilder.append("ddd");
		println(stringBuilder);
	}
	public static void print(String string)
	{

	}
	public static void println(String string)
	{
		poz1 -= string.length();
		for(int i = 0; i < poz1; i++)
			System.out.print(" ");
		System.out.print(border[ramka1]);
		for(int i = 0; i < poz2; i++)
			System.out.print(" ");
		System.out.print(string);
		for(int i = 0; i < poz2; poz2--)
			System.out.print(" ");
		System.out.print(border[ramka1]);
		for(int i = 0; i < poz1; poz1--)
			System.out.print(" ");
		System.out.println();
		poz1 = 140;
		poz2 = 20;
	}
	public static void println(StringBuilder string)
	{
		poz1 -= string.length();
		for(int i = 0; i < poz1; i++)
			System.out.print(" ");
		System.out.print(border[ramka1]);
		for(int i = 0; i < poz2; i++)
			System.out.print(" ");
		System.out.print(string);
		for(int i = 0; i < poz2; poz2--)
			System.out.print(" ");
		System.out.print(border[ramka1]);
		for(int i = 0; i < poz1; poz1--)
			System.out.print(" ");
		System.out.println();
		poz1 = 140;
		poz2 = 20;
	}
	public static void println()
	{
		for(int i = 0; i < poz1; i++)
			System.out.print(" ");
		System.out.print(border[ramka1]);
		for(int i = 0; i < poz2; i++)
			System.out.print(" ");
		for(int i = 0; i < poz2; poz2--)
			System.out.print(" ");
		System.out.print(border[ramka1]);
		for(int i = 0; i < poz1; poz1--)
			System.out.print(" ");
		System.out.println();
		poz1 = 140;
		poz2 = 20;
	}
	public static void start()
	{
		for(int i = 0; i < 84; i++)
		{
			System.out.print(border[i]);
		}
		System.out.println();
	}
	public static void end()
	{
		System.out.println();
		for(int i = 0; i < 84; i++)
		{
			System.out.print(border[i]);
		}
	}

}
