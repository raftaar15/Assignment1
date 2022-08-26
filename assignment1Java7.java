package com;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.*;

public class tcsAssignmentJ7 {

    static void calAvg() throws Throwable{
        String path = "D:\\assignment1\\assignment1.csv";
        String line = "";
        // Initialization of values.
        int sum = 0;
        double count = 0;
            BufferedReader br = new BufferedReader(new FileReader(path));
            br.readLine();
            // Adding in sum and counting in while loop.
            while ((line = br.readLine()) != null) {
                String[] age = line.split(",");
                sum += Integer.parseInt(age[2]);
                count++;
            }
        // Output the value.
        System.out.println("Average age of the students - ");
        System.out.println(sum/count);

    }

    static void ascSortStudents() throws Throwable{
        String path = "D:\\assignment1\\assignment1.csv";
        String line = "";
        // Initialization of values.
        ArrayList<String> ascSort= new ArrayList<String>();
            BufferedReader br = new BufferedReader(new FileReader(path));
            br.readLine();
            // Adding students in arraylist.
            while((line = br.readLine()) != null) {
                String[] names = line.split(",");
                ascSort.add(names[1]);
            }
        // Sorting students in arraylist.
        Collections.sort(ascSort);
        System.out.println("Students sorted according to their name - ");
        for (String s : ascSort) {
            System.out.println(s);
        }
    }

    static void ascSortAge() throws Throwable{
        String path = "D:\\assignment1\\assignment1.csv";
        String line = "";
        // Initialization of values.
        SortedMap<Integer,String> ascSort= new TreeMap<Integer,String>();
            BufferedReader br = new BufferedReader(new FileReader(path));
            br.readLine();
            // Adding name and age in Treemap.
            while((line = br.readLine()) != null) {
                String[] names = line.split(",");
                ascSort.put(Integer.parseInt(names[2]),names[1]);
            }
        System.out.println("Age of students in ascending order - ");
        for(Map.Entry m:ascSort.entrySet())
            System.out.println("Name - " + m.getValue() + " and Age - " + m.getKey());
    }

    static void validStudents() throws Throwable{
        String path = "D:\\assignment1\\assignment1.csv";
        String line = "";
        // Initialization of values.
        ArrayList<String> ascSort= new ArrayList<String>();
            BufferedReader br = new BufferedReader(new FileReader(path));
            br.readLine();
            // Adding students who have less than 70% attendance.
            while((line = br.readLine()) != null) {
                String[] names = line.split(",");
                if(Integer.parseInt(names[3]) < 70) {
                    ascSort.add(names[1]);
                }
            }
        System.out.println("Students who can't appear in exam - ");
        for (String s : ascSort) {
            System.out.println("Name - " + s);
        }
    }

    static void desMarks() throws Throwable{
        String path = "D:\\assignment1\\assignment1.csv";
        String line = "";
        // Initialization of values, storing values in treemap in descending order.
        SortedMap<Integer,String> desMarks= new TreeMap<Integer,String>(Collections.reverseOrder());
            BufferedReader br = new BufferedReader(new FileReader(path));
            br.readLine();
            // Storing marks and names.
            while((line = br.readLine()) != null) {
                String[] names = line.split(",");
                if(Integer.parseInt(names[3]) >= 70) {
                    desMarks.put(Integer.parseInt(names[4]),names[1]);
                }
            }
        // Output.
        System.out.println("Qualified students to appear in exam in descending order - ");
        for(Map.Entry m:desMarks.entrySet()){
            System.out.println("Name - " + m.getValue() + " and marks - " + m.getKey());
        }
    }

    static void failedStudents() throws Throwable{
        String path = "D:\\assignment1\\assignment1.csv";
        String line = "";
        // Initialization of values.
        int failed = 0;
        int count = 0;
            BufferedReader br = new BufferedReader(new FileReader(path));
            br.readLine();
            // Checking if the marks are less than 30%.
            while((line = br.readLine()) != null) {
                String[] names = line.split(",");
                if (Integer.parseInt(names[4]) < 30) {
                    failed += 1;
                }
                count++;
            }
        System.out.println("Students who failed in exams and passed in exam - ");
        System.out.println("Number of failed students are " + failed +
                " and number of passed students " + (count-failed));

    }

    static void variousGroup() throws Throwable{
        String path = "D:\\assignment1\\assignment1.csv";
        String line = "";
            // Storing various age groups in arraylist.
            BufferedReader br = new BufferedReader(new FileReader(path));
            br.readLine();
            ArrayList<String> below30 = new ArrayList<String>();
            ArrayList<String> bet30and50 = new ArrayList<String>();
            ArrayList<String> bet50and70 = new ArrayList<String>();
            ArrayList<String> bet70and90 = new ArrayList<String>();
            ArrayList<String> above90 = new ArrayList<String>();
            while((line = br.readLine()) != null) {
                String[] names = line.split(",");
                if(Integer.parseInt(names[4]) <30){
                    below30.add(names[1]);
                }else if(Integer.parseInt(names[4]) > 30 && Integer.parseInt(names[4]) < 50){
                    bet30and50.add(names[1]);
                }else if(Integer.parseInt(names[4]) > 50 && Integer.parseInt(names[4]) < 70){
                    bet50and70.add(names[1]);
                }else if(Integer.parseInt(names[4]) > 70 && Integer.parseInt(names[4]) < 90){
                    bet70and90.add(names[1]);
                }else{
                    above90.add(names[1]);
                }
            }
            // Output.
            System.out.println("Students under various age group");
            System.out.println("Students below 30%");
            for (String s : below30) {
                System.out.println(s);
            }
            System.out.println("Students above 30% and below 50%");
            for (String s : bet30and50) {
                System.out.println(s);
            }
            System.out.println("Students above 50% and below 70%");
            for (String s : bet50and70) {
                System.out.println(s);
            }
            System.out.println("Students above 70% and below 90%");
            for (String s : bet70and90) {
                System.out.println(s);
            }
            System.out.println("Students above 90%");
            for (String s : above90) {
                System.out.println(s);
            }
    }

    public static void main(String[] args) throws Throwable {
        calAvg();
        ascSortStudents();
        ascSortAge();
        validStudents();
        desMarks();
        failedStudents();
        variousGroup();
    }
}
