import java.util.ArrayList;
import java.util.List;

public class MachineLearningModel {
    private List<DataPoint> trainingData;
    private DecisionTree decisionTree;

    public MachineLearningModel(List<DataPoint> trainingData) {
        this.trainingData = trainingData;
    }

    public void train() {
        decisionTree = new DecisionTree(trainingData);
        decisionTree.train();
    }

    public double classify(DataPoint dataPoint) {
        return decisionTree.classify(dataPoint);
    }
}
