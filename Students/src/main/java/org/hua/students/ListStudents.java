package org.hua.students;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class ListStudents {
    private ArrayList<Student> l = null;
    private String fileName = "Students.txt";
    private File file;
    private boolean openFile = false;

    public ListStudents() {
        l = new ArrayList<Student>();
    }

    public void addNewStudent(String aName, int anId, double aGrade) {
        Student st = new Student();

        st.setDetails(aName, anId, aGrade);
        l.add(st);
    }

    public void deleteStudent(int anId) {
        Student st;
        for (int i = 0; i < l.size(); i++) {
            st = l.get(i);
            if (anId == st.getId()) {
                l.remove(i);

                System.out.println("It" + anId + " Deleted succesfully!");
            }
        }
    }

    public boolean changeDetails(String aName, int anId, double aGrade, int parameter) {
        Student st;

        for (int i = 0; i < l.size(); i++) {
            st = l.get(i);

            if (parameter == st.getId()) {
                st.setDetails(aName, anId, aGrade);
                return true;
            }
        }

        return false;

    }

    public boolean findStudent(int anId) {
        for (Student student : l) {

            if (anId == student.getId()) {
                return true;
            }
        }

        return false;
    }

    public String printAllStudents() {
        Student st;
        String printData = ("  ID\t\tName\t\tGrade\n");
        for (int i = 0; i < l.size(); i++) {
            st = l.get(i);
            printData += (st.getId() + "\t\t" + st.getName() + "\t\t" + st.getGrade() + "\n");
        }

        return printData;

    }

    public Student getStudent(int anID) {
        Student st = null;
        int i;

        for (i = 0; i < l.size(); i++) {
            st = l.get(i);

            if (st.getId() == anID) {
                return st;
            }
        }

        return null;
    }

    public void save() {
        if (openFile) {
            try {
                FileOutputStream fileOut = new FileOutputStream(file);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(l);
                out.close();
                fileOut.close();
            } catch (IOException i) {
                i.printStackTrace();
            }
        } else {
            try {
                FileOutputStream fileOut = new FileOutputStream(fileName);
                ObjectOutputStream out = new ObjectOutputStream(fileOut);
                out.writeObject(l);
                out.close();
                fileOut.close();
            } catch (IOException i) {
                i.printStackTrace();
            }
        }

    }


    @SuppressWarnings("unchecked")
    public void load(File aFile) {
        try {
            FileInputStream fileIn = new FileInputStream(aFile);
            ObjectInputStream in = new ObjectInputStream(fileIn);
            l = (ArrayList<Student>) in.readObject();
            in.close();
            fileIn.close();

            openFile = true;
            file = aFile;
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            c.printStackTrace();
            return;
        }
    }


}
