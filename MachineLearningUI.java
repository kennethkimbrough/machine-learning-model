import javax.swing.*;
import java .awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MachineLearningUI {
    private JFrame frame;
    private JTextField questionField;
    private JTextArea responseArea;
    private MachineLearningModel model;

    public MachineLearningUI(MachineLearningModel model) {
        this.model = model;
        createUI();
    }

    private void createUI() {
        frame = new JFrame("Machine Learning UI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new FlowLayout());

        JLabel questionLabel = new JLabel("Enter your question:");
        questionField = new JTextField(20);

        JButton askButton = new JButton("Ask");
        askButton.addActionListener(new AskButtonListener());

        inputPanel.add(questionLabel);
        inputPanel.add(questionField);
        inputPanel.add(askButton);

        responseArea = new JTextArea(10, 20);
        responseArea.setEditable(false);

        frame.add(inputPanel, BorderLayout.NORTH);
        frame.add(new JScrollPane(responseArea), BorderLayout.CENTER);

        frame.pack();
        frame.setVisible(true);
    }

    private class AskButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String question = questionField.getText();
            double response = model.classify(new DataPoint(question));
            responseArea.setText("Response: " + response);
        }
    }

    public static void main(String[] args) {
        MachineLearningModel model = new MachineLearningModel(/* training data */);
        MachineLearningUI ui = new MachineLearningUI(model);
    }
}
