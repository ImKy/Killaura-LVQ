package LVQ;

import java.util.Arrays;
import java.util.List;

/**
 * Created by himyn on 6/27/2017.
 */
public class DataSet {

    private List<Double> dataList;
    private String category;

    public DataSet(Double[] data) {
        this.dataList = Arrays.asList(data);
    }

    public DataSet(Double[] data, String category) {
        this.dataList = Arrays.asList(data);
        this.category = category;
    }

    public List<Double> getData() {
        return this.dataList;
    }

    public String getCategory() {
        return this.category;
    }
}
