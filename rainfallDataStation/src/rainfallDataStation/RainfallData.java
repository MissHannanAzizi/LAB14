package rainfallDataStation;

import java.util.Date;

public class RainfallData {
    // Fields to store the attributes of the rainfall data
    private String stationId;
    private String station;
    private String district;
    private Date lastUpdated;
    private double dailyRainfall;
    private double rainfallFromMidnight;
    private double totalOneHour;

    // Constructor to initialize the rainfall data object with the provided attribute values
    public RainfallData(String stationId, String station, String district, Date lastUpdated, double dailyRainfall, double rainfallFromMidnight, double totalOneHour) {
        this.stationId = stationId;
        this.station = station;
        this.district = district;
        this.lastUpdated = lastUpdated;
        this.dailyRainfall = dailyRainfall;
        this.rainfallFromMidnight = rainfallFromMidnight;
        this.totalOneHour = totalOneHour;
    }

    // Getter method to retrieve the station ID
    public String getStationId() {
        return stationId;
    }

    // Getter method to retrieve the station name
    public String getStation() {
        return station;
    }

    // Getter method to retrieve the district name
    public String getDistrict() {
        return district;
    }

    // Getter method to retrieve the last updated date
    public Date getLastUpdated() {
        return lastUpdated;
    }

    // Getter method to retrieve the daily rainfall value
    public double getDailyRainfall() {
        return dailyRainfall;
    }

    // Getter method to retrieve the rainfall from midnight value
    public double getRainfallFromMidnight() {
        return rainfallFromMidnight;
    }

    // Getter method to retrieve the total rainfall in one hour
    public double getTotalOneHour() {
        return totalOneHour;
    }
}
