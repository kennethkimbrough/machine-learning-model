class DecisionTree {
    private List<DataPoint> trainingData;
    private Node root;

    public DecisionTree(List<DataPoint> trainingData) {
        this.trainingData = trainingData;
    }

    public void train() {
        root = new Node(trainingData);
        root.train();
    }

    public double classify(DataPoint dataPoint) {
        return root.classify(dataPoint);
    }
}
