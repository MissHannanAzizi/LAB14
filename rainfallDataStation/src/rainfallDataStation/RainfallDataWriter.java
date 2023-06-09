package rainfallDataStation;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedWriter;
import java.io.FileWriter;



public class RainfallDataWriter {
    private String dataFilePath;
    private List<RainfallData> rainfallDataList;

    public RainfallDataWriter(String dataFilePath) {
        this.dataFilePath = dataFilePath;
        this.rainfallDataList = new ArrayList<>();
    }

    public void addRainfallData(RainfallData rainfallData) {
        rainfallDataList.add(rainfallData);
    }

    public void writeDataToFile() {
    	 try (BufferedWriter writer = new BufferedWriter(new FileWriter(dataFilePath))) {
             for (RainfallData rainfallData : rainfallDataList) {
                 // Create a line with the data fields separated by commas
                 String line = rainfallData.getStationId() + "," +
                         rainfallData.getStation() + "," +
                         rainfallData.getDistrict() + "," +
                         rainfallData.getLastUpdated() + "," +
                         rainfallData.getDailyRainfall() + "," +
                         rainfallData.getRainfallFromMidnight() + "," +
                         rainfallData.getTotalOneHour();

                 // Write the line to the file
                 writer.write(line);
                 writer.newLine();
             }
            System.out.println("Data creation completed. Data written to file: " + dataFilePath);
        } catch (IOException e) {
            System.out.println("Error writing data to file: " + e.getMessage());
        }
    }
}
