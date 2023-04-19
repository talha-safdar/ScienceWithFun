package uos.assignment.controller;

/**
 * The Class DifficultyLevel to change the difficulty level.
 * It has two field variables.
 * 
 * @version 1.0
 */
public class DifficultyLevel 
{
	public static int easy=1, normal=2, hard=3;
	public static int difficultyLevel=5;
	
	/**
	 * Sets the difficulty level.
	 *
	 * @param difficultyLevel the new difficulty level
	 */
	public static void setDifficultyLevel(int difficultyLevel)
	{
		if (difficultyLevel <= 3)
		{
			if (difficultyLevel == easy)
			{
				DifficultyLevel.difficultyLevel = 5;
			}
			else if (difficultyLevel == normal)
			{
				DifficultyLevel.difficultyLevel = 3;
			}
			else if (difficultyLevel == hard)
			{
				DifficultyLevel.difficultyLevel = 1;
			}
			else
			{
				DifficultyLevel.difficultyLevel = 5;
			}
		}			
		else
		{
			System.out.println("Error: unknown difficulty level selection");
		}
	}
	
	/**
	 * Gets the difficulty level.
	 *
	 * @return the difficulty level
	 */
	public static int getDifficultyLevel()
	{
		return difficultyLevel;
	}
}