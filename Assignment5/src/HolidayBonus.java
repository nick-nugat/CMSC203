public class HolidayBonus {

	//constants
	private static final double HIGHEST_SALES_BONUS = 5000;
	private static final double LOWEST_SALES_BONUS = 1000;
	private static final double OTHERS_BONUS = 2000;

	//no-args constructor
	public HolidayBonus(){}

	//calculates the holiday bonuses of categories
	public static double[] calculateHolidayBonus(double[][] data){
		int maxColumns = data[0].length;

		//finds max amount of columns throughout all the rows
		for (int i = 0; i < data.length; i++) {
			if (data[i].length > maxColumns) maxColumns = data[i].length;
		}

		double[] holidayBonus = new double[data.length];

		//adds holiday bonus values to temp array according to corresponding position in data array
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				double current = data[i][j];
				if (current == TwoDimRaggedArrayUtility.getHighestInColumn(data, j)) {
					holidayBonus[i] += HIGHEST_SALES_BONUS;
				} else if (current == TwoDimRaggedArrayUtility.getLowestInColumn(data, j)) {
					holidayBonus[i] += LOWEST_SALES_BONUS;
				} else {
					holidayBonus[i] += OTHERS_BONUS;
				}
			}
		}

		return holidayBonus;
	}

	public static double calculateTotalHolidayBonus(double[][] data){
		double total = 0,
				min = TwoDimRaggedArrayUtility.getLowestInArray(data),
				max = TwoDimRaggedArrayUtility.getHighestInArray(data);

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				double current = data[i][j];

				if (current == min) total += LOWEST_SALES_BONUS;
				else if (current == max) total += HIGHEST_SALES_BONUS;

				total += OTHERS_BONUS;
			}
		}
		return total;
	}

}
