package rainfallDataStation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        // Create an instance of RainfallDataWriter
        RainfallDataWriter writer = new RainfallDataWriter("rainfall_data.txt");

        // Define the station ID, station name, and district
        String stationId = "SMPAT";
        String station = "Simpang Ampat";
        String district = "Alor Gajah";

        // Define the date format for parsing the lastUpdated attribute
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        try {
            // Parse the lastUpdated dates for the 6 days
            Date day1 = dateFormat.parse("01/06/2023");
            Date day2 = dateFormat.parse("02/06/2023");
            Date day3 = dateFormat.parse("03/06/2023");
            Date day4 = dateFormat.parse("04/06/2023");
            Date day5 = dateFormat.parse("05/06/2023");
            Date day6 = dateFormat.parse("06/06/2023");

            // Define the rainfall data for each day
            RainfallData data1 = new RainfallData(stationId, station, district, day1, 10.2, 5.4, 2.1);
            RainfallData data2 = new RainfallData(stationId, station, district, day2, 8.7, 3.2, 1.8);
            RainfallData data3 = new RainfallData(stationId, station, district, day3, 6.5, 2.8, 1.5);
            RainfallData data4 = new RainfallData(stationId, station, district, day4, 9.1, 4.6, 2.0);
            RainfallData data5 = new RainfallData(stationId, station, district, day5, 7.3, 3.5, 1.9);
            RainfallData data6 = new RainfallData(stationId, station, district, day6, 11.5, 6.8, 2.4);

            // Add the rainfall data to the writer
            writer.addRainfallData(data1);
            writer.addRainfallData(data2);
            writer.addRainfallData(data3);
            writer.addRainfallData(data4);
            writer.addRainfallData(data5);
            writer.addRainfallData(data6);

            // Write the data to the file
            writer.writeDataToFile();

            // Display a message indicating the completion of data creation
            System.out.println("Data creation completed.");

            // Read and display the contents of the file
            try (BufferedReader reader = new BufferedReader(new FileReader("rainfall_data.txt"))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("Error reading data from file: " + e.getMessage());
            }
        } catch (ParseException e) {
            System.out.println("Error parsing date: " + e.getMessage());
        }
    }
}
