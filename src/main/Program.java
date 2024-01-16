package main;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Product;

public class Program {
	public static void main(String[] args) {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Product> list = new ArrayList<>();

		System.out.println("Enter file path: ");
		String strPth = sc.nextLine();

		File srcFile = new File(strPth);
		String srcFolder = srcFile.getParent();

		boolean success = new File(srcFolder + "\\out").mkdir();
		
		String trgtFile = srcFolder + "\\out\\summary.csv";

		try (BufferedReader br = new BufferedReader(new FileReader(srcFile))) {
			String itemCsv = br.readLine();
			while (itemCsv != null) {
				String[] fields = itemCsv.split(",");
				String name = fields[0];
				double price = Double.parseDouble(fields[1]);
				int qtt = Integer.parseInt(fields[2]);
				list.add(new Product(name, price, qtt));
				itemCsv = br.readLine();
			}
			
			try (BufferedWriter bw = new BufferedWriter(new FileWriter(trgtFile))) {
				for(Product item : list) {
					bw.write(item.getName() + "," + String.format("%.2f", item.total()));
					bw.newLine();
				}
				
				System.out.println(trgtFile + " Created");
			} catch (IOException e) {
				System.out.println("error!" + e.getMessage());
			}

		} catch (IOException e) {
			e.printStackTrace();
		}

		sc.close();

	}
}