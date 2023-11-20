import java.io.*;

public final class TwoDimRaggedArrayUtility { //This is a final class, meaning it can't be extended.

	//Constants
	private static final int MAX_ROW = 10;
	private static final int MAX_COLUMN = 10;

	//No-arg constructor
	public TwoDimRaggedArrayUtility(){}

	//Hi Professor Monshi, I would've used the superclass, IOException, for the readFile() and writeFile() methods, but if I did, it wouldn't have worked with the provided GUI and I didn't want to modify the GUI file, so I instead added try-catch blocks to catch the IOException's I ran into. Sorry for the disorganized code!
	public static double[][] readFile(File file) throws FileNotFoundException {

		//This method can also be implemented using a Scanner, but I personally prefer using a BufferedReader and find it easier.
		String line;
		String[][] tempStringArray = new String[MAX_ROW][MAX_COLUMN];

		BufferedReader reader = new BufferedReader(new FileReader(file));


		//Sets line equal to next line while checking if it is not null. Also, this checks for if the rows are less than the max rows.
		int rows = 0;

		while (true){
			try {
				if (!(((line = reader.readLine()) != null) && (rows < MAX_ROW))) break;
			} catch (IOException e) {
				throw new RuntimeException(e);
			}
			//Trims the next line while also converting it to a String array. Stores it in a row of the String array.
			tempStringArray[rows] = line.trim().split(" ");
			rows++;
		}

		double[][] bonuses = new double[rows][];
		for (int i = 0; i < rows; i++) {
			int cols = 0;

			while ((cols < tempStringArray[i].length) && (cols < MAX_COLUMN))
				cols++;

			bonuses[i] = new double[cols];

			for (int j = 0; j < cols; j++)
				bonuses[i][j] = Double.parseDouble(tempStringArray[i][j]);
		}
		try {
			reader.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		return bonuses;
	}



	public static void writeToFile(double[][] data, File outputFile) throws FileNotFoundException {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));

			for (double[] vals : data) {
				for (double val : vals) {
					writer.write(val + " ");
				}
				writer.newLine();
			}

			writer.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	//returns total of passed 2d array
	public static double getTotal(double[][] data){
		double total = 0;

		for (double[] datum : data)
			for (double v : datum) total += v;

		return total;
	}

	public static double getAverage(double[][] data){
		int elements = 0;

		for (double[] datum : data)
			elements += datum.length;

		return getTotal(data) / elements; //called getTotal divided by elements
	}

	public static double getRowTotal(double[][] data, int row){
		double rowTotal = 0;


		for (int i = 0; i < data[row].length; i++) {
			rowTotal += data[row][i];
		}

		return rowTotal;
	}

	public static double getColumnTotal(double[][] data, int col){
		double columnTotal = 0;
		int cols = 0;

		for (int i = 0; i < data.length; i++)
			if (col < data[i].length)
				columnTotal += data[i][col];

		return columnTotal;
	}

	public static double getHighestInRow(double[][] data, int row){
		double highestInRow = data[row][0];

		for (int i = 1; i < data[row].length; i++)
			if (data[row][i] > highestInRow) highestInRow = data[row][i];

		return highestInRow;
	}

	public static int getHighestInRowIndex(double[][] data, int row){
		double highestInRow = getHighestInRow(data, row);
		int indexToReturn = 0;

		for (int i = 1; i < data[row].length; i++) {
			if (data[row][i] == highestInRow) indexToReturn = i;
		}

		return indexToReturn;
	}

	public static double getLowestInRow(double[][] data, int row){
		double lowestInRow = data[row][0];

		for (int i = 1; i < data[row].length; i++)
			if (data[row][i] < lowestInRow) lowestInRow = data[row][i];

		return lowestInRow;
	}

	public static int getLowestInRowIndex(double[][] data, int row){
		double lowestInRow = getLowestInRow(data, row);
		int index = 0;

		for (int i = 0; i < data.length; i++)
			if (data[row][i] == lowestInRow){
				index = i;
				break;
			}

		return index;
	}


	public static double getHighestInColumn(double[][] data, int col){
		double highestInColumn = Double.MIN_VALUE;


		for (int i = 0; i < data.length; i++) {
			if (col < data[i].length){
				if (data[i][col] > highestInColumn) highestInColumn = data[i][col];
			}
		}
		return highestInColumn;
	}

	public static int getHighestInColumnIndex(double[][] data, int col){
		double highestInCol = getHighestInColumn(data, col);
		int index = 0;

		for (int i = 0; i < data.length; i++)
			if (data[i].length > col) {
				if (data[i][col] == highestInCol) {
					index = i;
					break;
				}
			}

		return index;
	}

	public static double getLowestInColumn(double[][] data, int col){
		double lowestInColumn = Double.MAX_VALUE;

		for (int i = 0; i < data.length; i++) {
			if (data[i].length > col){
				if (data[i][col] < lowestInColumn) lowestInColumn = data[i][col];
			}
		}
		return lowestInColumn;
	}

	public static int getLowestInColumnIndex(double[][] data, int col){
		double lowestInColumn = getLowestInColumn(data, col);
		int index = 0;

		for (int i = 0; i < data.length; i++) {
			if (col < data[i].length) {
				if (data[i][col] == lowestInColumn) {
					index = i;
					break;
				}
			}
		}

		return index;
	}


	public static double getHighestInArray(double[][] data){
		double initial = data[0][0];

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				double current = data[i][j];
				if (current > initial) initial = current;
			}
		}
		return initial;
	}

	public static double getLowestInArray(double[][] data){
		double initial = data[0][0];

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				double current = data[i][j];
				if (current < initial) initial = current;
			}
		}
		return initial;
	}
}
