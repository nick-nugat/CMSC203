import java.io.*;
import java.util.Scanner;

public final class TwoDimRaggedArrayUtility { //can't be extended

	//constants
	private static final int MAX_ROW = 10;
	private static final int MAX_COLUMN = 10;

	//no-arg constructor
	public TwoDimRaggedArrayUtility(){}



	public static double[][] readFile(File file)
			throws FileNotFoundException{
		Scanner scanner = new Scanner(file);
		String[][] tempArray = new String[MAX_ROW][MAX_COLUMN];
		String temp = "";
		double[][] data;
		int rows = 0;
		int cols = 0;

		while(scanner.hasNextLine()
				&& scanner.nextLine() != null){
			temp = "";
			rows++;

			while (scanner.nextLine()
					.contains(" ")) cols++;

			temp += scanner.nextLine();
			tempArray[rows] = temp.split(" ");
		}
		data = new double[rows][cols];
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				data[i][j] = Double.parseDouble(tempArray[i][j]);
			}
		} return data;

	}


	//Writes the ragged array of doubles into the file. Each row is on a separate line within the file and each double is separated by a space.
	public static void writeToFile(double[][] data, File outputFile)
			throws FileNotFoundException {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
			for (double[] datum : data) {
				for (double v : datum) {
					writer.write(String.valueOf(v));
				}
				writer.write("\n");
			}
		writer.close();
		} catch (IOException e) {
			e.printStackTrace();
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

		for (int i = 0; i < data.length; i++)
			columnTotal += data[i][col];

		return columnTotal;
	}

	public static double getHighestInRow(double[][] data, int row){
		double highestInRow = data[row][0];

		for (int i = 0; i < data.length; i++)
			if (data[row][i] > highestInRow) highestInRow = data[row][i];

		return highestInRow;
	}

	public static int getHighestInRowIndex(double[][] data, int row){
		double highestInRow = getHighestInRow(data, row);
		int indexToReturn = 0;

		for (int i = 0; i < data[row].length; i++) {
			if (data[row][i] == highestInRow) indexToReturn = i;
		}

		return indexToReturn;
	}

	public static double getLowestInRow(double[][] data, int row){
		double lowestInRow = data[row][0];

		for (int i = 0; i < data.length; i++)
			if (data[row][i] < lowestInRow) lowestInRow = data[row][i];

		return lowestInRow;
	}

	public static int getLowestInRowIndex(double[][] data, int row){
		double lowestInRow = getLowestInRow(data, row);
		int index = 0;

		for (int i = 0; i < data.length; i++)
			if (data[row][i] == lowestInRow) index = i;

		return index;
	}


	public static double getHighestInColumn(double[][] data, int col){

		double highestInColumn = data[0][col];

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j <= col; j++) {
				if (data[i].length >= col){
					if (data[i][j] > highestInColumn) highestInColumn = data[i][j];
				}
			}
		}
		return highestInColumn;
	}

	public static int getHighestInColumnIndex(double[][] data, int col){
		double highestInColumn = getHighestInColumn(data, col);
		int index = 0;

		for (int i = 0; i < data.length; i++)
			if (data[i][col] == highestInColumn) index = i;

		return index;
	}

	public static double getLowestInColumn(double[][] data, int col){
		double lowestInColumn = data[0][col];

		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < col; j++) {
				if (data[i].length >= col){
					if (data[i][j] < lowestInColumn) lowestInColumn = data[i][j];
				}
			}
		}

		return lowestInColumn;
	}

	public static int getLowestInColumnIndex(double[][] data, int col){
		double lowestInColumn = getLowestInColumn(data, col);
		int index = 0;

		for (int i = 0; i < data.length; i++)
			if (data[i][col] == lowestInColumn) index = i;

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
