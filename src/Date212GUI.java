import java.awt.Font;

import java.awt.GridLayout;

import java.io.File;

import java.io.FileNotFoundException;

import java.util.Scanner;

import java.util.StringTokenizer;

import javax.swing.JFrame;

import javax.swing.JTextArea;

public class Date212GUI extends JFrame{

// defining all required components. Declaring one UnsortedDate212List and one SortedDate212List

private UnsortedDate212List unsortedList;

private SortedDate212List sortedList;

// text areas to display unsorted and sorted texts

JTextArea unsortedText, sortedText;

public void loadFromFile(String filename) {

// initializing lists

unsortedList = new UnsortedDate212List();

sortedList = new SortedDate212List();

try {

// using scanner to read file line by line

Scanner scanner = new Scanner(new File(filename));

while (scanner.hasNext()) {

// using StringTokenizer to split line by comma

StringTokenizer line = new StringTokenizer(scanner.nextLine(),

",");

while (line.hasMoreTokens()) {

// getting a token

String dateToken = line.nextToken();

try {

// trying to create a Date212

Date212 date = new Date212(dateToken);

// adding to the lists

unsortedList.add(date);

sortedList.add(date);

} catch (Exception e) {

// date creation failed, invalid date, printing to

// console

System.out.println(e.getMessage());

}

}

}

} catch (FileNotFoundException e) {

// file not found

System.out.println("Input data file not found!");

}

// appending all dates to the both text fields

unsortedText.setText(unsortedList.toString());

sortedText.setText(sortedList.toString());

}

public Date212GUI(String inputFileName) {

setLayout(new GridLayout(1, 2, 10, 10));

// initializing components

unsortedText = new JTextArea();

unsortedText.setLineWrap(true);

// using a bigger font size

unsortedText.setFont(new Font("SansSerif", Font.PLAIN, 30));

sortedText = new JTextArea();

sortedText.setLineWrap(true);

sortedText.setFont(new Font("SansSerif", Font.PLAIN, 30));

add(unsortedText);

add(sortedText);

setSize(600, 400);

setDefaultCloseOperation(EXIT_ON_CLOSE);

setTitle("Dates");

setVisible(true);

// loading dates from file, adding to lists, displaying on text fields

loadFromFile(inputFileName);

}

}