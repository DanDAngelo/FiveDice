public class FiveDice2
{
	public static void main(String[] args)
	{
		final int NUM = 5;
		Die[] player = new Die[NUM];
		Die[] comp = new Die[NUM];
		int x;

		// generates 5 die objects for the arrays
		for(x = 0; x < NUM; ++x)
		{
			player[x] = new Die();
			comp[x] = new Die();
		}

		int playerMatch;
		int compMatch;
		String playerName = "Player";
		String compName = "Computer";

		// calls the display() method twice
		display(playerName, player, NUM);
		display(compName, comp, NUM);

		// determine die value matches
		playerMatch = howManySame(player, NUM);
		compMatch = howManySame(comp, NUM);

		// analyze results of howManySame()
		if(compMatch == 1)
			System.out.println("Computer has nothing!");
		else
			System.out.println("Computer has " + compMatch + " of a kind");
		if(playerMatch == 1)
			System.out.println("You have nothing!");
		else
			System.out.println("You have " + playerMatch + " of a kind");

		// determine who the winner is
		if (compMatch > playerMatch)
			System.out.println("Computer wins!");
		else
			if(playerMatch > compMatch)
				System.out.println("You win!");
			else
				System.out.println("It was a tie!");

	}

	public static void display(String who, Die[] dice, int num)
	{
		int x;
		String diceString = "";
		for(x = 0; x < num; ++x)
			diceString = diceString + dice[x].getValue() + " ";
		System.out.println(who + " rolled: " + diceString);

	}
	public static int howManySame(Die[] die, int num)
	{
		int x;
		int y;
		int highest;
		int[] same = new int[num];

		for(x = 0; x < num; ++x)
			same[x] = 1; // fills the array with something

		for(x = 0; x < num - 1; ++x)
		{
			for(y = x + 1; y < num; ++y)
				if(die[x].getValue() == die[y].getValue())
				{
					same[x]++;
				}
		}

		highest = same[0];
		for(x = 1; x < num; ++x)
			if(same[x] > highest)
				highest = same[x];
			return highest;
	}
}