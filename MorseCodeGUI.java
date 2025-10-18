import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MorseCodeGUI {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MorseCodeGUI().createAndShowGUI());
    }

    private void createAndShowGUI() {
        JFrame frame = new JFrame("Morse Code Converter");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);

        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel textToMorsePanel = new JPanel();
        textToMorsePanel.setLayout(new BorderLayout(10, 10));
        textToMorsePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblTextToMorse = new JLabel("Enter Text:");
        lblTextToMorse.setFont(new Font("Serif", Font.BOLD, 20));
        JTextArea txtTextInput = new JTextArea(10, 40);
        txtTextInput.setFont(new Font("Serif", Font.BOLD, 15));
        JScrollPane scrollTextInput = new JScrollPane(txtTextInput);

        JButton btnTranslateToMorse = new JButton("Translate to Morse");
        btnTranslateToMorse.setFont(new Font("Serif", Font.BOLD, 15));
        JTextArea txtMorseOutput = new JTextArea(10, 40);
        txtMorseOutput.setFont(new Font("Serif", Font.BOLD, 20));
        txtMorseOutput.setEditable(false);
        JScrollPane scrollMorseOutput = new JScrollPane(txtMorseOutput);

        JPanel topPanel1 = new JPanel(new BorderLayout());
        topPanel1.add(lblTextToMorse, BorderLayout.NORTH);
        topPanel1.add(scrollTextInput, BorderLayout.CENTER);

        JPanel bottomPanel1 = new JPanel(new BorderLayout());
        bottomPanel1.add(btnTranslateToMorse, BorderLayout.NORTH);
        bottomPanel1.add(scrollMorseOutput, BorderLayout.CENTER);

        textToMorsePanel.add(topPanel1, BorderLayout.CENTER);
        textToMorsePanel.add(bottomPanel1, BorderLayout.SOUTH);

        JPanel morseToTextPanel = new JPanel();
        morseToTextPanel.setLayout(new BorderLayout(10, 10));
        morseToTextPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblMorseToText = new JLabel("Enter Morse Code:");
        lblMorseToText.setFont(new Font("Serif", Font.BOLD, 20));
        JTextArea txtMorseInput = new JTextArea(10, 40);
        txtMorseInput.setFont(new Font("Serif", Font.BOLD, 20));
        JScrollPane scrollMorseInput = new JScrollPane(txtMorseInput);

        JButton btnTranslateToText = new JButton("Translate to Text");
        btnTranslateToText.setFont(new Font("Serif", Font.BOLD, 15));
        JTextArea txtTextOutput = new JTextArea(10, 40);
        txtTextOutput.setFont(new Font("Serif", Font.BOLD, 20));
        txtTextOutput.setEditable(false);
        JScrollPane scrollTextOutput = new JScrollPane(txtTextOutput);

        JPanel topPanel2 = new JPanel(new BorderLayout());
        topPanel2.add(lblMorseToText, BorderLayout.NORTH);
        topPanel2.add(scrollMorseInput, BorderLayout.CENTER);

        JPanel bottomPanel2 = new JPanel(new BorderLayout());
        bottomPanel2.add(btnTranslateToText, BorderLayout.NORTH);
        bottomPanel2.add(scrollTextOutput, BorderLayout.CENTER);

        morseToTextPanel.add(topPanel2, BorderLayout.CENTER);
        morseToTextPanel.add(bottomPanel2, BorderLayout.SOUTH);

        tabbedPane.addTab("Text to Morse", textToMorsePanel);
        tabbedPane.addTab("Morse to Text", morseToTextPanel);

        MorseCodeConverter m = new MorseCodeConverter();

        btnTranslateToMorse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputText = txtTextInput.getText();
                
                String morseResult = m.textToMorse(inputText); // placeholder
                txtMorseOutput.setText(morseResult);
            }
        });

        btnTranslateToText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String inputMorse = txtMorseInput.getText();
                String textResult = m.morseToText(inputMorse);
                txtTextOutput.setText(textResult);
            }
        });

        frame.getContentPane().add(tabbedPane);
        frame.setVisible(true);
    }
}