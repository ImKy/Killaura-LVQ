package LVQ;

import java.util.Arrays;
import java.util.List;

/**
 * Created by himyn on 6/27/2017.
 */
public class LVQ {

    private String name;
    private List<DataSet> dataSets;
    private double learnRate;
    private double decayRate;

    public LVQ(String name, double learnRate, double decayRate) {
        this.name = name;
        this.learnRate = learnRate;
        this.decayRate = decayRate;
    }

    public void addDataSet(DataSet dataSet) {
        this.dataSets.add(dataSet);
    }

    public void train() {
        for (int i = 0; i < this.dataSets.size(); i++) {
            //
        }

        // Approach / Diverge
        // If approach = data point of winner + learn rate x ( data point of current - data point of winner )
        // If diverge = data point of winner - learn rate x ( data point of current - data point of winner )
        // Real learn rate = current learn rate x ( 1 - ( epoch / total ) )
    }

    public String categorizeData(DataSet dataSet) {
        return null;
    }

    public DataSet getWinner(DataSet dataSet) {
        DataSet dataSet1 = null;
        double minDist = Double.MAX_VALUE;
        for (int i = 0; i < this.dataSets.size(); i++) {
            double tempDist = 0;
            for (int j = 0; j < dataSet.getData().size(); j++) {
                tempDist += Math.pow(dataSet.getData().get(j) - this.dataSets.get(i).getData().get(j), 2);
            }
            if (tempDist < minDist) {
                minDist = tempDist;
                dataSet1 = this.dataSets.get(i);
            }
        }
        return dataSet1;
    }
}
