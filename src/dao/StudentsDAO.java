package dao;

import view.MainView;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;

public class StudentsDAO {
    private ArrayList<String> studentsList = new ArrayList<>();
    private ArrayList<String> absentStudents = new ArrayList<>();
    private MainView view;
    private String path;
    private ArrayList<JCheckBox> allStudents;

    public void setPath(String path){
        this.path = path;
    }

    public void createList(){
        if (path != null) {
            studentsList = (ArrayList<String>) loadCSV(path);
            System.out.println(studentsList);
        }
    }

    public ArrayList<String> getStudentsList(){
        return studentsList;
    }

    public List<String> loadCSV(String filePath) {
        List<String> data = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                data.add(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return data;
    }
    public String pathToCSV() {
        FileDialog fd = new FileDialog(view, "CSV Datei auswählen", FileDialog.LOAD);
        fd.setDirectory("C:\\");
        fd.setFile("*.csv");
        fd.setVisible(true);
        String filename = fd.getFile();
        String directory = fd.getDirectory();
        if (filename == null) {
            System.out.println("Auswahl abgebrochen");
            return null;
        } else {
            System.out.println("Auswahl: " + filename);
            System.out.println(directory + filename);
            path = directory + filename;
            return path;
        }
    }
    public Integer getNumOfStudents(ArrayList<String> students){
        int numOfStudents = 0;
        for(String student : students){
            numOfStudents++;
        }
        return numOfStudents;
    }
    public ArrayList<String> getAbsentStudents(ArrayList<JCheckBox> checkboxes){
        absentStudents = new ArrayList<>();
        for(JCheckBox checkbox : checkboxes) {
            if (checkbox.isSelected()) {
                absentStudents.addLast(checkbox.getText());
            }
        }
        return absentStudents;
    }
}