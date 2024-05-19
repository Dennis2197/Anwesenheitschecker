package view;
import javax.swing.*;
import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ResultWindow {
    private ArrayList<String> absentStudents;

    public void showResults() {
        String absentString = String.join(", ", absentStudents);

        JFrame frame = new JFrame("Abwesende Teilnehmer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);
        frame.setLayout(new BorderLayout());

        String message = absentString;
        JTextArea textArea = new JTextArea(message);
        textArea.setEditable(false);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setMargin(new Insets(10, 10, 10, 10));
        frame.add(new JScrollPane(textArea), BorderLayout.CENTER);

        // Erstelle einen Button zum Kopieren der Nachricht in die Zwischenablage
        JButton copyButton = new JButton("In die Zwischenablage kopieren");
        copyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                StringSelection stringSelection = new StringSelection(textArea.getText());
                Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
                JOptionPane.showMessageDialog(frame, "Nachricht in die Zwischenablage kopiert!");
            }
        });
        frame.add(copyButton, BorderLayout.SOUTH);

        // Zeige das Fenster an
        frame.setLocationRelativeTo(null); // Fenster zentrieren
        frame.setVisible(true);
    }
    public void setAbsentStudents(ArrayList<String> absentStudents){
        this.absentStudents = absentStudents;
    }
}