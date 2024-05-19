package controller;

import dao.StudentsDAO;
import view.MainView;
import java.util.ArrayList;
import view.ResultWindow;

public class MainController {
    private final MainView view;
    private StudentsDAO studentData;
    private String path;
    private ResultWindow results;

    public MainController(MainView view, ResultWindow results) {
        this.view = view;
        this.results = results;
        view.addUIComponents();
        initController();
        printList();
    }
    private void initController(){
        view.getFileDialogButton().addActionListener(e -> {
            studentData = new StudentsDAO();
            path = studentData.pathToCSV();
            System.out.println(path);
            studentData.setPath(path);
            studentData.createList();
            view.setNumOfStudents(studentData.getNumOfStudents(studentData.getStudentsList()));
            view.setCenterPanel();
            view.createCBs(studentData.getStudentsList());
        });
    }
    private void printList(){
        view.getSend().addActionListener(e -> {
            ArrayList<String> absentStudents = studentData.getAbsentStudents(view.getAllStudents());
            results.setAbsentStudents(absentStudents);
            results.showResults();
        });
    }
}