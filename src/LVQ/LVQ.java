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
            DataSet dataSet = this.dataSets.get(i);
            DataSet dataSet1 = getWinner(this.dataSets.get(i));
            if (dataSet1.getCategory().equalsIgnoreCase(dataSet.getCategory())) {
                List<Double> weights = dataSet1.getData();
                for (int j = 0; j < weights.size(); j++) {
                    Double weight = weights.get(j);
                    weight = weight + this.learnRate * (dataSet.getData().get(j) - weight);
                    weights.set(j, weight);
                    dataSet1.setData(weights);
                }
            } else {
                List<Double> weights = dataSet1.getData();
                for (int j = 0; j < weights.size(); j++) {
                    Double weight = weights.get(j);
                    weight = weight - this.learnRate * (dataSet.getData().get(j) - weight);
                    weights.set(j, weight);
                    dataSet1.setData(weights);
                }
            }
            this.learnRate = this.learnRate - this.learnRate * this.decayRate;
        }
    }

    public Double validate(List<DataSet> dataSets) {
        Integer totalCorrect = 0;
        for (int i = 0; i < dataSets.size(); i++) {
            DataSet dataSet = dataSets.get(i);
            DataSet winner = getWinner(dataSet);
            if (winner.getCategory().equalsIgnoreCase(dataSet.getCategory())) {
                totalCorrect++;
            }
        }
        return Double.valueOf(totalCorrect / dataSets.size());
    }

    public String categorizeData(DataSet dataSet) {
        return null;
    }

    private DataSet getWinner(DataSet dataSet) {
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
