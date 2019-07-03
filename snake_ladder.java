import java.io.*;
import java.util.Random;
class snake_ladder
{
	static int[] array = new int[100];
	static int[] player = {0,0,0,0};
	public static void make_board()
	{
		for(int i=0;i<=100;i++)
		{
			array[i]=0;
		}
		array[12]=-4;
		array[26]=-14;
		array[36]=-20;
		array[49]=-7;
		array[99]=-95;
		array[82]=-42;

		array[20]=7;
		array[28]=21;
		array[33]=40;
		array[80]=8;
	}
	public static int generate_number()
	{

			Random generate = new Random();
			int index = generate.nextInt(6);
			return index;
	}
	public static int condition_check(int player_current,int add,int pos)
	{
		if(player_current+add>100)
		{
			return 0;
		}
		else
		{
			if(player_current+add==100)
			{
				return 2;
			}

			player_current=player_current+add;
			player[pos]=player[pos]+add;
			if(array[player_current]>0)
			{
				player_current = player_current+array[player_current];
				player[pos]=player[pos]+array[player_current];
			}
			else
			{
				if(array[player_current]<0)
				{
					player_current = player_current - array[player_current];
					player[pos]=player[pos]-array[player_current];
				}
			}
			return 1;
		}

	}
	public static void make_move()
	{
		Boolean keep_moving=true;


		int[] dice = {1,2,3,4,5,6};
		while(keep_moving)
		{
			int value;
			for(int i=0;i<4;i++)
			{
				value = generate_number();
				int x=condition_check(player[i],dice[value],i);
				System.out.print(" player ");
				System.out.print(i+1);
				System.out.print(" ");
				System.out.println(player[i]);
				if(x==2)
				{
					System.out.print(i+1);
					System.out.println(" WON");
					keep_moving=false;
					break;
				}

			}
		}
	}
		
	public static void main(String[] args) {
		make_move();
	}
}