package ua.gigo;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class MainApp {
	private static HashMap<String, Integer> alfabetTable;

	private static HashMap<String, Integer> getScoreTable() {
		HashMap<String, Integer> score = new HashMap<>();
		score.put("a", 1);
		score.put("b", 2);
		score.put("c", 3);
		score.put("d", 4);
		score.put("e", 5);
		score.put("f", 6);
		score.put("g", 7);
		score.put("h", 8);
		score.put("i", 9);
		score.put("j", 10);
		score.put("k", 11);
		score.put("l", 12);
		score.put("m", 13);
		score.put("n", 14);
		score.put("o", 15);
		score.put("p", 16);
		score.put("q", 17);
		score.put("r", 18);
		score.put("s", 19);
		score.put("t", 20);
		score.put("u", 21);
		score.put("v", 22);
		score.put("w", 23);
		score.put("x", 24);
		score.put("y", 25);
		score.put("z", 26);
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
	private static int calcChar(char separateChar) {
		String separateString =  String.valueOf(separateChar);
		return  alfabetTable.get(separateString);
	}
	private static List<Integer> calcValue(List<String> nameList){
		List<Integer> scoreList = new ArrayList<>();
		for (int j=0; j<nameList.size();j++) {
			String name = nameList.get(j);
			int nameValue =0;
			for(int i=0;i<name.length();i++) {
				char separateChar = name.charAt(i);
				nameValue= nameValue + calcChar(separateChar);
			}
			scoreList.add(nameValue*(j+1));
		}		
		return scoreList;
	}
	

	
	public static void main(String[] args) {
		alfabetTable = getScoreTable();
		List<String> nameList = readFile("1.txt");
		Collections.sort(nameList);
		List<Integer> number =  calcValue(nameList);
		int sum =0;
		for (Integer integer : number) {
			sum+=integer;
		}
		System.out.println("total sum of names in file  is " + sum);	
	}

}
