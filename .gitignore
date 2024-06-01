import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentGrade extends JFrame {
    private JLabel totalMarksLabel;
    private JLabel averagePercentageLabel;
    private JLabel gradeLabel;
    private JTextField numSubjectsField;
    private JButton calculateButton;

    public StudentGrade() {
        setTitle("Student Grade Calculator");
        setSize(400, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);

        gbc.gridx = 0;
        gbc.gridy = 0;
        mainPanel.add(new JLabel("Enter the number of subjects:"), gbc);

        numSubjectsField = new JTextField(10);
        gbc.gridx = 1;
        gbc.gridy = 0;
        mainPanel.add(numSubjectsField, gbc);

        calculateButton = new JButton("Calculate");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        mainPanel.add(calculateButton, gbc);

        totalMarksLabel = new JLabel("Total Marks:");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        mainPanel.add(totalMarksLabel, gbc);

        averagePercentageLabel = new JLabel("Average Percentage:");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        mainPanel.add(averagePercentageLabel, gbc);

        gradeLabel = new JLabel("Grade:");
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 1;
        mainPanel.add(gradeLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        mainPanel.add(new JLabel(), gbc);

        gbc.gridx = 1;
        gbc.gridy = 3;
        mainPanel.add(new JLabel(), gbc);

        gbc.gridx = 1;
        gbc.gridy = 4;
        mainPanel.add(new JLabel(), gbc);

        add(mainPanel);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateGrade();
            }
        });

        setVisible(true);
    }

    private void calculateGrade() {
        try {
            int numSubjects = Integer.parseInt(numSubjectsField.getText());

            int totalMarks = 0;

            for (int i = 1; i <= numSubjects; i++) {
                String input = JOptionPane.showInputDialog("Enter marks for subject " + i + " (out of 100):");
                int marks = Integer.parseInt(input);

                if (marks < 0 || marks > 100) {
                    JOptionPane.showMessageDialog(this, "Invalid marks! Please enter a value between 0 and 100.", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                totalMarks += marks;
            }

            double averagePercentage = (double) totalMarks / numSubjects;
            String grade = calculateGrade(averagePercentage);

            totalMarksLabel.setText("Total Marks: " + totalMarks);
            averagePercentageLabel.setText("Average Percentage: " + String.format("%.2f", averagePercentage) + "%");
            gradeLabel.setText("Grade: " + grade);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "Please enter a valid number of subjects.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String calculateGrade(double averagePercentage) {
        if (averagePercentage >= 90) {
            return "A";
        } else if (averagePercentage >= 80) {
            return "B";
        } else if (averagePercentage >= 70) {
            return "C";
        } else if (averagePercentage >= 60) {
            return "D";
        } else if (averagePercentage >= 40) {
            return "E";
        } else {
            return "F";
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new StudentGrade();
            }
        });
    }
}
