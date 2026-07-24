import java.util.*;

class UndergroundSystem {

    HashMap<Integer, Object[]> checkIn = new HashMap<>();
    HashMap<String, double[]> trips = new HashMap<>();

    public UndergroundSystem() {
    }

    public void checkIn(int id, String stationName, int t) {
        checkIn.put(id, new Object[]{stationName, t});
    }

    public void checkOut(int id, String stationName, int t) {
        Object[] data = checkIn.get(id);

        String start = (String) data[0];
        int time = (int) data[1];

        String key = start + "-" + stationName;

        trips.putIfAbsent(key, new double[2]);

        trips.get(key)[0] += (t - time); 
        trips.get(key)[1]++;             

        checkIn.remove(id);
    }

    public double getAverageTime(String startStation, String endStation) {
        double[] ans = trips.get(startStation + "-" + endStation);
        return ans[0] / ans[1];
    }
}
