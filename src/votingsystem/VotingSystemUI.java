package votingsystem;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class VotingSystemUI {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Online Voting System");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel for user role selection
        JPanel rolePanel = new JPanel();
        JLabel roleLabel = new JLabel("Select Role: ");
        JButton userButton = new JButton("User");
        JButton adminButton = new JButton("Admin");
        rolePanel.add(roleLabel);
        rolePanel.add(userButton);
        rolePanel.add(adminButton);

        // Voting Admin logic
        Admin admin = new Admin();

        // Setup User voting interface
        userButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame userFrame = new JFrame("User Voting");
                userFrame.setSize(300, 200);

                // Create User interface
                JLabel nameLabel = new JLabel("Enter your name:");
                JTextField nameField = new JTextField(10);
                JLabel ageLabel = new JLabel("Enter your age:");
                JTextField ageField = new JTextField(2);
                JLabel voteLabel = new JLabel("Enter candidate name:");
                JTextField voteField = new JTextField(10);
                JButton submitVoteButton = new JButton("Submit Vote");

                JPanel panel = new JPanel();
                panel.add(nameLabel);
                panel.add(nameField);
                panel.add(ageLabel);
                panel.add(ageField);
                panel.add(voteLabel);
                panel.add(voteField);
                panel.add(submitVoteButton);

                userFrame.add(panel);
                userFrame.setVisible(true);

                submitVoteButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try {
                            String name = nameField.getText();
                            String vote = voteField.getText();
                            int age = Integer.parseInt(ageField.getText());

                            // Validate name to allow only alphabetic characters
                            if (!isValidName(name)) {
                                throw new Exception("Invalid name! Please use only alphabetic characters.");
                            }

                            if (age < 18) {
                                JOptionPane.showMessageDialog(null, "You must be at least 18 years old to vote.", "Age Restriction", JOptionPane.WARNING_MESSAGE);
                                userFrame.dispose();  // Close the voting frame
                            } else if (vote.isEmpty()) {
                                JOptionPane.showMessageDialog(null, "Please enter a candidate to vote for!", "Error", JOptionPane.ERROR_MESSAGE);
                            } else {
                                // Cast vote using Admin's voting method to check for duplicate votes
                                admin.castVote(name, vote);

                                // Show confirmation
                                JOptionPane.showMessageDialog(null, name + ", your vote for " + vote + " has been cast successfully!", "Vote Success", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } catch (NumberFormatException ex) {
                            JOptionPane.showMessageDialog(null, "Invalid age entered.", "Error", JOptionPane.ERROR_MESSAGE);
                        } catch (Exception ex) {
                            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                });

            }
        });

        // Setup Admin election management interface
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame adminFrame = new JFrame("Admin Panel");
                adminFrame.setSize(300, 200);

                // Create Admin interface
                JLabel candidateLabel = new JLabel("Enter candidate name:");
                JTextField candidateField = new JTextField(10);
                JButton addCandidateButton = new JButton("Add Candidate");
                JButton showResultsButton = new JButton("Show Results");

                JPanel panel = new JPanel();
                panel.add(candidateLabel);
                panel.add(candidateField);
                panel.add(addCandidateButton);
                panel.add(showResultsButton);

                addCandidateButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        String candidate = candidateField.getText();
                        if (candidate.isEmpty()) {
                            JOptionPane.showMessageDialog(null, "Please enter a candidate name!", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            admin.addCandidate(candidate);
                            JOptionPane.showMessageDialog(null, candidate + " has been added as a candidate!", "Candidate Added", JOptionPane.INFORMATION_MESSAGE);
                        }
                    }
                });

                showResultsButton.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        // Display the election results
                        String results = admin.getResults();
                        JOptionPane.showMessageDialog(null, results, "Election Results", JOptionPane.INFORMATION_MESSAGE);
                    }
                });

                adminFrame.add(panel);
                adminFrame.setVisible(true);
            }
        });

        // Adding rolePanel to frame
        frame.add(rolePanel);
        frame.setVisible(true);
    }

    // Helper method to validate if the name contains only alphabetic characters
    private static boolean isValidName(String name) {
        // Regular expression to check only alphabetic characters
        Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
        Matcher matcher = pattern.matcher(name);
        return matcher.matches();
    }
}
