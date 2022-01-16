package ua.gigo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class MainApp {
	private static HashMap<String, Integer> alfabetTable;

	private static HashMap<String, Integer> getScoreTable() {
		HashMap<String, Integer> score = new HashMap<>();
		score.put("A", 1);
		score.put("B", 2);
		score.put("C", 3);
		score.put("D", 4);
		score.put("E", 5);
		score.put("F", 6);
		score.put("G", 7);
		score.put("H", 8);
		score.put("I", 9);
		score.put("J", 10);
		score.put("K", 11);
		score.put("L", 12);
		score.put("M", 13);
		score.put("N", 14);
		score.put("O", 15);
		score.put("P", 16);
		score.put("Q", 17);
		score.put("R", 18);
		score.put("S", 19);
		score.put("T", 20);
		score.put("U", 21);
		score.put("V", 22);
		score.put("W", 23);
		score.put("X", 24);
		score.put("Y", 25);
		score.put("Z", 26);
		return score;
	}

	private static List<String> readFile(String path) {
		List<String> namesList = new ArrayList<String>();
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(path));
			String currentLine = null;
			do {
				currentLine = reader.readLine();
				if (currentLine != null) {
					currentLine = currentLine.toLowerCase();
					namesList.add(currentLine);
				}
			} while (currentLine != null);

		} catch (IOException e) {
			System.out.println("io.exeption");
		} finally {
			try {
				reader.close();
			} catch (IOException e) {
				System.out.println("io.exeption");
			}
		}
		return namesList;
	}
	
	private static List<String> readFileWD(String path) {
		List<String> namesList = new ArrayList<String>();
		Scanner scanner = null;
		try {
			scanner = new Scanner(new File(path));
			 scanner.useDelimiter("\",\"");
				while (scanner.hasNext()) {
					namesList.add(scanner.next());
				}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	   
	}
		return namesList;
	}

	private static int calcChar(char separateChar) {
		String separateString = String.valueOf(separateChar);
		if(separateString.equals("\"")) {
		 return 0;
		}
		return alfabetTable.get(separateString);
	}

	private static List<Integer> calcValue(List<String> nameList) {
		List<Integer> scoreList = new ArrayList<>();
		for (int j = 0; j < nameList.size(); j++) {
			String name = nameList.get(j);
			int nameValue = 0;
			for (int i = 0; i < name.length(); i++) {
				char separateChar = name.charAt(i);
				nameValue = nameValue + calcChar(separateChar);
			}
			scoreList.add(nameValue * (j + 1));
		}
		return scoreList;
	}

	public static void main(String[] args) {
		alfabetTable = getScoreTable();
		List<String> nameList = readFileWD("p022_names.txt");
		Collections.sort(nameList);
		List<Integer> number = calcValue(nameList);
		int sum = 0;
		for (Integer integer : number) {
			sum += integer;
		}
		System.out.println("total sum of names in file  is " + sum);
	}

}
