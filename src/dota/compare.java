package dota;
/**
 * @author abhishek.bagati@gmail.com
 * direct comaprision between JD and Resume.
 * outputs the common tokens to the common.txt
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class compare {

	private static ArrayList<String> load(String f1) throws FileNotFoundException {
		Scanner reader = new Scanner(new File(f1));
		ArrayList<String> out = new ArrayList<String>();
		while (reader.hasNext()) {
			String temp = reader.nextLine();
			String[] sts = temp.split(" ");
			for (int i = 0; i < sts.length; i++) {
				if (sts[i] != "" && sts[i] != " " && sts[i] != "\n")
					out.add(sts[i]);
			}
		}
		return out;
	}

	private static void write(ArrayList<String> out, String fname) throws IOException {
		FileWriter writer = new FileWriter(new File(fname));
		for (int i = 0; i < out.size(); i++) {
			writer.write(out.get(i) + "\n");
		}
		writer.close();
	}

	public static void main(String[] args) throws IOException {
		ArrayList<String> file1;
		ArrayList<String> file2;
		ArrayList<String> file3;
		ArrayList<String> file4;
		ArrayList<String> out = new ArrayList<String>();
		ArrayList<String> finalout = new ArrayList<String>();
		file1 = load("src/dota/resources/file1.txt");
		file2 = load("src/dota/resources/file2.txt");
		for (int i = 0; i < file1.size(); i++) {
			String word1 = file1.get(i);
			for (int z = 0; z < file2.size(); z++) {
				if (word1.equalsIgnoreCase(file2.get(z))) {
					boolean already = false;
					for (int q = 0; q < out.size(); q++) {
						if (out.get(q).equalsIgnoreCase(file1.get(i))) {
							already = true;
						}
					}
					if (already == false) {
						out.add(file1.get(i));
					}
				}
			}
		}
		//System.out.println(out);

		write(out, "src/dota/resources/common.txt");
	/**	String st = new String ("src/dota/resources/common.txt");
		String[] tokens = st.split("\\s+");
		Opennlp.findSkills(tokens); */
		file4 = load("src/dota/resources/knownSkills.txt");
		file3 = load("src/dota/resources/common.txt");
		for (int i = 0; i < file3.size(); i++) {
			String word1 = file3.get(i);
			for (int z = 0; z < file4.size(); z++) {
				if (word1.equalsIgnoreCase(file4.get(z))) {
					boolean already = false;
					for (int q = 0; q < finalout.size(); q++) {
						if (finalout.get(q).equalsIgnoreCase(file3.get(i))) {
							already = true;
						}
					}
					if (already == false) {
						finalout.add(file3.get(i));
					}
				}
			}
		}
		System.out.println("Matching skills of the Candidate: " +finalout);

		write(finalout, "src/dota/resources/matchingSkills.txt"); 
	}
}
