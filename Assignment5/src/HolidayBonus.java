public class HolidayBonus {

	//Constants
	private static final double HIGHEST_SALES_BONUS = 5000;
	private static final double LOWEST_SALES_BONUS = 1000;
	private static final double OTHERS_BONUS = 2000;

	//No-args constructor
	public HolidayBonus(){}

	//Calculates the holiday bonuses of categories
	public static double[] calculateHolidayBonus(double[][] data){
		double[] holidayBonus = new double[data.length];

		for (int i = 0; i < data.length; i++){
			for (int j = 0; j < data[i].length; j++) {
				j %= data[i].length;

				double highestInCol = 0, lowestInCol = 0;

				if (data[i][j] < 0) {
					highestInCol = TwoDimRaggedArrayUtility.getHighestInColumn(data, j);
					lowestInCol = TwoDimRaggedArrayUtility.getLowestInColumn(data, j);
				}

				double current = data[i][j];

				if (current == highestInCol) {
					holidayBonus[i] += HIGHEST_SALES_BONUS;
				} else if (current == lowestInCol) {
					holidayBonus[i] += LOWEST_SALES_BONUS;
				} else if (current > 0) {
					holidayBonus[i] += OTHERS_BONUS;
				} else if (current <= 0){
					holidayBonus[i] += 0;
				}
			}
		}
		return holidayBonus;
	}

	//Sums up the holiday bonuses array
	public static double calculateTotalHolidayBonus(double[][] data) {

		double[] tempArray = calculateHolidayBonus(data);
		double total = 0;

		for (double val : tempArray) total += val;

		return total;
	}

}
