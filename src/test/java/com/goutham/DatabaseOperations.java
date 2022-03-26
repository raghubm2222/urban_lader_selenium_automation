package com.goutham;

import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class DatabaseOperations {
    static String databasePath = System.getProperty("user.dir") + "\\database";

    public static List<TestData> getTestList() {
        List<TestData> testDataList = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(databasePath + "\\giftcard.csv");
            Scanner fileScanner = new Scanner(fileReader);
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                String[] data = line.split(",");
                if (line.contains("Recipients"))
                    continue;
                TestData testData = new TestData(data[5], data[0], data[1], data[2], data[3],
                        data[4]);
                testDataList.add(testData);
            }
            fileScanner.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return testDataList;
    }
}
