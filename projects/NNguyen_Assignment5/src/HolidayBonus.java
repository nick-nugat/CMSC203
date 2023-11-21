/*
 * Class: CMSC203
 * Instructor: Professor Monshi
 * Description: Calculates holiday bonuses in a 2d ragged array
 * Due: 11/27/2023
 * Platform/compiler: javac
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or any source. I have not given my code to any student.
 * Print your Name here: Nicholas Nguyen
 */

public class HolidayBonus {

	//Constants
	private static final double
		HIGHEST_SALES_BONUS = 5000,
		LOWEST_SALES_BONUS = 1000,
		OTHERS_BONUS = 2000;

	//No-args constructor
	public HolidayBonus(){}

	//Calculates the holiday bonuses of categories
	public static double[] calculateHolidayBonus(double[][] data){
		double[] holidayBonus = new double[data.length];

		for (int i = 0; i < data.length; i++){
			for (int j = 0; j < data[i].length; j++) {
				j %= data[i].length; //Wraps around

				double
					highestInCol = TwoDimRaggedArrayUtility.getHighestInColumn(data, j),
					lowestInCol = TwoDimRaggedArrayUtility.getLowestInColumn(data, j),
					current = data[i][j];


				if (current <= 0)
					holidayBonus[i] += 0;
				else if (current == highestInCol)
					holidayBonus[i] += HIGHEST_SALES_BONUS;
				else if (current == lowestInCol)
					holidayBonus[i] += LOWEST_SALES_BONUS;
				else
					holidayBonus[i] += OTHERS_BONUS;
			}
		}
		return holidayBonus;
	}

	//Sums up the holiday bonuses array
	public static double calculateTotalHolidayBonus(double[][] data) {
		double[] tempArray = calculateHolidayBonus(data);
		double total = 0;

		for (double val : tempArray)
			total += val;

		return total;
	}
}
