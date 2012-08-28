/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.simulator;

import com.rixon.lms_console.command.simulator.dataFiles.SimulatedDataFiles;
import com.rixon.lms_console.util.DateUtil;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.*;

/**
 * This class is used to simulate stub titles based on a set of seed entries. This logic can
 * be used to create random values that conform to a given pattern with random values in the
 * places where pattern is not required
 * User: rixon|Date: 8/20/12|Time: 1:18 AM
 */
public class DataSimulator {

    private List<String> seedWordsTitle;
    private List<String> seedWordsDescription;
    private List<Date> seedDates;
    private List<String> seedPropertyValues;
    private List<String> seedISBNs;
    Random random = new Random();

    public void setTitleSeed(List<String> seedWords) {
        this.seedWordsTitle = seedWords;
    }

    public List<String> mockTitles(int number) {
        List<String> mockTitles = new ArrayList<String>();
        String titlePattern = " %1$s %2$s %3$s %4$s";
        for (int i=0;i<number;i++) {
            Formatter stringFormatter = new Formatter();
            String sampleTitle = stringFormatter.format(titlePattern, randomTitle(),
                                            randomTitle(),randomTitle(),randomTitle()).toString();
            mockTitles.add(sampleTitle);
        }
        return mockTitles;
    }

    private String randomTitle() {
        return seedWordsTitle.get(random.nextInt(seedWordsTitle.size()));
    }

    public void setDateSeed(List<Date> seedDates) {
        this.seedDates = seedDates;
    }

    public List<Date> mockDates(int number) {
        List<Date> mockDates = new ArrayList<Date>();
        for (int i=0;i<number;i++) {
            mockDates.add(randomDate());
        }
        return mockDates;
    }

    private Date randomDate() {
        return seedDates.get(random.nextInt(seedDates.size()));
    }

    public void setISBNSeed(List<String> isbns) {
       this.seedISBNs = isbns;
    }

    public List<String> mockISBNs(int number) {
        List<String> mockISBNs = new ArrayList<String>();
        String isbnFormat = "%d%d%d-%d-%d%d%d-%d%d%d%d%d-%d" ;  //"%1$d%2$d%3$d-%4$d-%5$d%6$d%7$d-%8$d%9$d%10$d%11$d%12$d%13$d-%14$d";
        for (int i=0;i<number;i++) {
            Formatter stringFormatter = new Formatter();
            String mockISBN = stringFormatter.format(isbnFormat,numbersForISBN(13)).toString();
            mockISBNs.add(mockISBN);
        }
        return mockISBNs;
    }

    private Integer[] numbersForISBN(int size) {
        Integer[] numbers = new Integer[size];
        for (int i=0;i<size;i++) {
            numbers[i] = randomNumber();
        }
        return numbers;
    }

    private int randomNumber() {
        return Integer.valueOf(seedISBNs.get(random.nextInt(seedISBNs.size())));
    }

    public void setSeedPropertyValues(List<String> propertyValues) {
        this.seedPropertyValues = propertyValues;
    }

    public List<String> mockPropertyValues(int expectedMockItems) {
        List<String> mockValues = new ArrayList<String>();
        String titlePattern = " %1$s %2$s";
        for (int i=0;i<expectedMockItems;i++) {
            Formatter stringFormatter = new Formatter();
            String sampleTitle = stringFormatter.format(titlePattern, randomPropertyValue(),
                    randomPropertyValue()).toString();
            mockValues.add(sampleTitle);
        }
        return mockValues;
    }

    private String randomPropertyValue() {
        return seedPropertyValues.get(random.nextInt(seedPropertyValues.size()));
    }

    public void loadSeedsFromFiles() throws IOException {
        loadTitles();
        loadDescription();
        loadDates();
        loadPropertyValues();
        loadISBNs();
    }

    private void loadTitles() throws IOException {
        seedWordsTitle = stringsFromFile(SimulatedDataFiles.TITLE_FILE);
    }

    private void loadDescription() throws IOException {
        seedWordsDescription = stringsFromFile(SimulatedDataFiles.DESCRIPTION_FILE);
    }

    private void loadDates() throws IOException{
        seedDates = datesFormFile(SimulatedDataFiles.DATES_FILE);
    }

    private void loadPropertyValues() throws IOException{
        seedPropertyValues = stringsFromFile(SimulatedDataFiles.PROPERTY_FILE);
    }

    private void loadISBNs() throws IOException {
        seedISBNs = stringsFromFile(SimulatedDataFiles.NUMBERS_FILE);
    }

    private List<String> stringsFromFile(String fileName) throws IOException{
        URL fileURL = SimulatedDataFiles.class.getResource(fileName);
        List<String> fileContents = new ArrayList<String>();
        if (fileURL == null) {
            return fileContents;
        }
        BufferedReader br = new BufferedReader(new FileReader(fileURL.getPath()));
        String line = br.readLine();
        while (line != null) {
            line = br.readLine();
            if (line != null)
                fileContents.add(line);
        }
        br.close();
        return fileContents;
    }

    private List<Date> datesFormFile(String fileName) throws IOException {
        URL datesURL = SimulatedDataFiles.class.getResource(fileName);
        List<Date> dateList = new ArrayList<Date>();
        if (datesURL == null) {
            return dateList;
        }
        BufferedReader br = new BufferedReader(new FileReader(datesURL.getPath()));
        String line = br.readLine();
        while (line != null) {
            line = br.readLine();
            if (line != null)
                dateList.add(DateUtil.getFormattedDate(line));
        }
        br.close();
        return dateList;
    }
}


/**
 //TODO
 1) Strategy pattern to get the sampleString based on template and seedList
 2) Higher level function based on domain object that knows which simulator to call
 e.g. Title Simulator, Author Simulator, Date Simulator,  Property Simulator based on the attributes
 of the domain object.

 3) Create configuration that takes count
 4) create sequence for each table and associated with the dao object to save repetitive manual effort

 */