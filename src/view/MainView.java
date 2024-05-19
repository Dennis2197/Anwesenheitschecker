package view;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.util.ArrayList;

public class MainView extends JFrame {

    private JCheckBox checkBox;
    private JButton FileDialogButton;
    private JPanel centerPanel;
    private ArrayList<JCheckBox> allStudents;
    private Integer numOfStudents = 0;
    private JLabel numOfStudentsLabel;
    private JButton send;

    public MainView(int width, int height){

        setSize(width, height);
        setTitle("Anwesenheit");
        setDefaultCloseOperation( DISPOSE_ON_CLOSE );
        setVisible(true);
        setLocationRelativeTo(null);
    }
    public void addUIComponents(){
        JPanel topPanel = new JPanel();
        centerPanel = new JPanel();
        JPanel bottomPanel = new JPanel();

        add(topPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        FileDialogButton = new JButton("Datei auswählen");
        topPanel.add(FileDialogButton);

        send = new JButton("Liste erzeugen");
        send.setEnabled(false);
        bottomPanel.add(send);
    }
    public void setCenterPanel(){
        numOfStudentsLabel = new JLabel("Gesamtanzahl der Teilnehmer: " + numOfStudents);
        centerPanel.setLayout(new GridLayout(numOfStudents + 1, 1));
        centerPanel.setBorder( new EmptyBorder(5, 5, 5, 5));
        centerPanel.add(numOfStudentsLabel);
        send.setEnabled(true);
    }
    public JButton getFileDialogButton(){
        return FileDialogButton;
    }
    public JButton getSend(){
        return send;
    }
    public void createCBs(ArrayList<String> students){
        allStudents = new ArrayList<>();
        for(String student : students){
            checkBox = new JCheckBox(student);
            centerPanel.add(checkBox);
            allStudents.add(checkBox);
        }
    }
    public ArrayList<JCheckBox> getAllStudents(){
        return allStudents;
    }
    public void setNumOfStudents(int numOfStudents){
        this.numOfStudents = numOfStudents;
    }
}