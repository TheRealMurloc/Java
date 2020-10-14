public class kolko 
{
	public static void main(String[]args)
	{
		java.util.Scanner in = new java.util.Scanner(System.in);
		String[] mapa = 
		{
			"[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]", "[ ]"
		};
		String[] tutorial = 
		{
			"[0]", "[1]", "[2]", "[3]", "[4]", "[5]", "[6]", "[7]", "[8]"
		};
		
		for(int i = 0, z = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				System.out.print(tutorial[z]);
				z++;
			}
			System.out.println();
		}
		for(int i = 0, z = 0; i < 3; i++)
			{
				for(int j = 0; j < 3; j++)
				{
					System.out.print(mapa[z]);
					z++;
				}
				System.out.println();
			}
		int x = in.nextInt();
		if(mapa[x]=="[ ]")
			mapa[x] = "[X]";
		else
			System.out.println("Juz jest tam znak :(");
		for(int i = 0, z = 0; i < 3; i++)
			{
				for(int j = 0; j < 3; j++)
				{
					System.out.print(mapa[z]);
					z++;
				}
				System.out.println();
			}
		int o = in.nextInt();
		if(mapa[o]=="[ ]")
			mapa[o] = "[O]";
		else
			System.out.println("Juz jest tam znak :(");
		for(int i = 0, z = 0; i < 3; i++)
			{
				for(int j = 0; j < 3; j++)
				{
					System.out.print(mapa[z]);
					z++;
				}
				System.out.println();
			}
		
		

	
	}

}