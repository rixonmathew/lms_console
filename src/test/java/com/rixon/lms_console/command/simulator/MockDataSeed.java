/*
 * Copyright (c) 2012.
 * Author: Rixon Mathew (email:rixon.mathew@cognizant.com)
 * This source is distributed as is without warranty of any kind. Please use this at your
 * own risk. You are free to reuse as long as the credit is provided to me for this work
 */

package com.rixon.lms_console.command.simulator;

import com.rixon.lms_console.command.simulator.dataFiles.SimulatedDataFiles;
import com.rixon.lms_console.util.DateUtil;
import org.jetbrains.annotations.NotNull;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class acts as the data seed. The seed is initialized from a set of files
 * containing random text. Data simulators make use of the seed to generate list of
 * data to be set on the
 * User: rixon|Date: 9/11/12|Time: 5:14 PM
 */
public class MockDataSeed {

    private List<String> seedWordsTitle;
    private List<String> seedWordsDescription;
    private List<Date> seedDates;
    private List<String> seedPropertyValues;
    private List<String> seedNumbers;

    public List<String> getSeedWordsTitle() {
        return seedWordsTitle;
    }

    public List<String> getSeedWordsDescription() {
        return seedWordsDescription;
    }

    public List<Date> getSeedDates() {
        return seedDates;
    }

    public List<String> getSeedPropertyValues() {
        return seedPropertyValues;
    }

    public List<String> getSeedNumbers() {
        return seedNumbers;
    }

    public MockDataSeed() {
        try {
            loadSeedsFromFiles();
        } catch (IOException e) {
            System.err.println("An error occurred trying to load the seed files");
            e.printStackTrace();
        }
    }

    private void loadSeedsFromFiles() throws IOException {
        loadTitles();
        loadDescription();
        loadDates();
        loadPropertyValues();
        loadNumbers();
    }

    private void loadTitles() throws IOException {
        seedWordsTitle = stringsFromFile(SimulatedDataFiles.TITLE_FILE);
    }

    private void loadDescription() throws IOException {
        seedWordsDescription = stringsFromFile(SimulatedDataFiles.DESCRIPTION_FILE);
    }

    private void loadDates() throws IOException {
        seedDates = datesFormFile(SimulatedDataFiles.DATES_FILE);
    }

    private void loadPropertyValues() throws IOException {
        seedPropertyValues = stringsFromFile(SimulatedDataFiles.PROPERTY_FILE);
    }

    private void loadNumbers() throws IOException {
        seedNumbers = stringsFromFile(SimulatedDataFiles.NUMBERS_FILE);
    }

    @NotNull
    private List<String> stringsFromFile(String fileName) throws IOException {
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

    @NotNull
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
