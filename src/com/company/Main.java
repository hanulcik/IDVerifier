package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) throws IOException {
        int max_iterations = 24;
        int iterations = 0;
        String index = "";
        String input = "";
        String pauseTime = "";

        // input log file from session files for parsing
        File file = new File("G:\\GGXLog\\session files\\RailwayTest1\\Session_log.log");
        Scanner scan = new Scanner(file);



        // regex & StringBuilder setup
        String regexIndex = "(\\d+)";
        String regexInput = "([a-zA-Z])";
        String regexPause = "\\d\\d:\\d\\d:\\d\\d\\s\\d+\\s(\\d)";
        Pattern patternIndex = Pattern.compile(regexIndex);
        Pattern patternInput = Pattern.compile(regexInput);
        Pattern patternPause = Pattern.compile(regexPause);


        /**
         *            ~~~ MAIN LOOP ~~~
         * Scan the log file line by line for regex of the target character & associated pause_time.
         * Target character = any letter followed by another letter, ignore capitalization.
         */

        //print target loop
        System.out.println("~~~ BEGIN TARGET DATA ~~~   iterations:" + iterations);
        while (scan.hasNextLine() && iterations <= max_iterations) {
            System.out.println(scan.nextLine());
            iterations++;
        }

        iterations = 0;
        System.out.println("\n~~~ END TARGET DATA ~~~");

        //print results loop
        System.out.println("\n~~~ BEGIN OUTPUT ~~~\n");
        while (scan.hasNextLine() && iterations <= max_iterations) {
            String lineToParse = scan.nextLine();
            Matcher matcherIndex = patternIndex.matcher(lineToParse);
            Matcher matcherInput = patternInput.matcher(lineToParse);
            Matcher matcherPause = patternPause.matcher(lineToParse);
            while (matcherIndex.find()) index = matcherIndex.group(1);
            while (matcherInput.find()) input = matcherInput.group(1);
            while (matcherPause.find()) pauseTime = matcherPause.group(1);

            System.out.println("index: " + index + "\tinput: " + input + "\tpause: " + pauseTime);


            iterations++;
        }

        System.out.println("\n~~~ END OUTPUT ~~~");



        //
//        String fileContent = "";
//        while(scan.hasNextLine()) fileContent = fileContent.concat(scan.nextLine() + "\n");


        // function to write the content of fileContent object to a txt file
//        FileWriter writer = new FileWriter("G:\\GGXLog\\session files\\ParsedLogFiles");
//        writer.write(fileContent);
//        writer.close();


    }
}
