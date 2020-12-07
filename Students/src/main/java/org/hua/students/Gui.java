package org.hua.students;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;
import javax.swing.filechooser.FileNameExtensionFilter;


public class Gui extends JFrame {
    private JPanel home;
    private JPanel inputDetails;
    private JTextField txtName;
    private JTextField textId;
    private JTextField textGrade;
    private JPanel findID;
    private JTextField getID;
    private final JPanel printPanel;
    private JFileChooser fileChooser;
    private File file;
    JTextPane txtDosentExist;
    JTextPane txtWrongInput;
    JTextPane txtThisStudentAlready;
    JTextArea textArea;
    JTextPane txtWrongName;
    JTextPane txtWrongID;
    JTextPane txtpnWrongGrade;

    private boolean addOrChange = true;

    private int DeleteChangeFind = 0;
    private int inputID;

    final String aName = null;
    final String anID = null;
    final String aGrade = null;

    ListStudents list = new ListStudents();

    public Gui() {
        setResizable(false);
        setForeground(Color.DARK_GRAY);
        setBackground(Color.DARK_GRAY);
        getContentPane().setLayout(new CardLayout(0, 0));

        home = new JPanel();
        home.setBackground(Color.DARK_GRAY);
        getContentPane().add(home, "name_543884465689600");

        JButton deleteButton = new JButton("Delete Student");
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                DeleteChangeFind = 1;

                txtWrongInput.setVisible(false);
                txtDosentExist.setVisible(false);
                getID.setText(null);
                findID.setVisible(true);
                home.setVisible(false);
            }
        });

        JButton findButton = new JButton("Find Student");
        findButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                DeleteChangeFind = 3;

                txtWrongInput.setVisible(false);
                txtDosentExist.setVisible(false);
                getID.setText(null);
                findID.setVisible(true);
                home.setVisible(false);
            }
        });

        JButton btnNewButton_2 = new JButton("Change details");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                DeleteChangeFind = 2;

                txtWrongInput.setVisible(false);
                txtDosentExist.setVisible(false);
                getID.setText(null);
                findID.setVisible(true);
                home.setVisible(false);
            }
        });

        JButton printAllButton = new JButton("Print All");
        printAllButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                textArea.setText(list.printAllStudents());

                printPanel.setVisible(true);
                home.setVisible(false);
            }
        });

        JButton fileButton = new JButton("Select File");
        fileButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                fileChooser = new JFileChooser();

                int returnVal = fileChooser.showOpenDialog(home);

                if (returnVal == JFileChooser.OPEN_DIALOG) {
                    file = fileChooser.getSelectedFile();
                }


                list.load(file);


            }
        });

        JButton addbutton = new JButton("New Student");

        addbutton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                txtName.setText(null);
                textId.setText(null);
                textGrade.setText(null);
                txtWrongName.setVisible(false);
                txtThisStudentAlready.setVisible(false);
                txtWrongID.setVisible(false);
                txtpnWrongGrade.setVisible(false);

                textId.setEnabled(true);
                txtThisStudentAlready.setVisible(false);
                addOrChange = true;
                inputDetails.setVisible(true);
                home.setVisible(false);
            }
        });

        GroupLayout gl_home = new GroupLayout(home);
        gl_home.setHorizontalGroup(
                gl_home.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_home.createSequentialGroup()
                                .addGap(100)
                                .addGroup(gl_home.createParallelGroup(Alignment.LEADING)
                                        .addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(printAllButton, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(addbutton, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                                .addGap(100)
                                .addGroup(gl_home.createParallelGroup(Alignment.LEADING)
                                        .addComponent(fileButton, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(findButton, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)
                                        .addGroup(gl_home.createSequentialGroup()
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(177, Short.MAX_VALUE))
        );
        gl_home.setVerticalGroup(
                gl_home.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_home.createSequentialGroup()
                                .addGap(70)
                                .addGroup(gl_home.createParallelGroup(Alignment.BASELINE)
                                        .addComponent(addbutton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(deleteButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addGap(50)
                                .addGroup(gl_home.createParallelGroup(Alignment.LEADING)
                                        .addComponent(findButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(btnNewButton_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addGap(50)
                                .addGroup(gl_home.createParallelGroup(Alignment.LEADING)
                                        .addComponent(printAllButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fileButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(83, Short.MAX_VALUE))
        );
        home.setLayout(gl_home);

        inputDetails = new JPanel();
        inputDetails.setBackground(Color.DARK_GRAY);
        getContentPane().add(inputDetails, "name_544560317342700");

        txtName = new JTextField();
        txtName.setText(null);
        txtName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        txtName.setHorizontalAlignment(SwingConstants.CENTER);
        txtName.setForeground(Color.WHITE);
        txtName.setBackground(Color.DARK_GRAY);
        txtName.setColumns(10);

        JTextPane txtpnName = new JTextPane();
        txtpnName.setEditable(false);
        txtpnName.setToolTipText("");
        txtpnName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtpnName.setForeground(Color.WHITE);
        txtpnName.setBackground(Color.DARK_GRAY);
        txtpnName.setText("Name");

        JTextPane txtpnId = new JTextPane();
        txtpnId.setEditable(false);
        txtpnId.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtpnId.setForeground(new Color(255, 255, 255));
        txtpnId.setBackground(Color.DARK_GRAY);
        txtpnId.setText("ID");

        textId = new JTextField();
        textId.setText(null);
        textId.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textId.setHorizontalAlignment(SwingConstants.CENTER);
        textId.setForeground(Color.WHITE);
        textId.setBackground(Color.DARK_GRAY);
        textId.setColumns(10);

        JTextPane txtpnGrade = new JTextPane();
        txtpnGrade.setEditable(false);
        txtpnGrade.setForeground(Color.WHITE);
        txtpnGrade.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtpnGrade.setBackground(Color.DARK_GRAY);
        txtpnGrade.setText("Grade");

        textGrade = new JTextField();
        textGrade.setText(null);
        textGrade.setFont(new Font("Tahoma", Font.PLAIN, 14));
        textGrade.setHorizontalAlignment(SwingConstants.CENTER);
        textGrade.setForeground(Color.WHITE);
        textGrade.setBackground(Color.DARK_GRAY);
        textGrade.setColumns(10);

        JButton saveStudentButton = new JButton("OK");
        saveStudentButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                txtpnWrongGrade.setVisible(false);
                txtWrongID.setVisible(false);

                String name = txtName.getText();
                String txtID = textId.getText();
                String txtGrade = textGrade.getText();


                try {
                    int id = Integer.parseInt(txtID);
                    double grade = Double.parseDouble(txtGrade);

                    if (addOrChange) {
                        if (list.findStudent(id)) {
                            txtThisStudentAlready.setVisible(true);

                        } else {
                            list.addNewStudent(name, id, grade);
                            list.save();
                            home.setVisible(true);
                            inputDetails.setVisible(false);
                        }
                    } else {
                        list.changeDetails(name, id, grade, inputID);
                        list.save();
                        home.setVisible(true);
                        inputDetails.setVisible(false);
                    }

                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    try {
                        int id = Integer.parseInt(txtID);

                    } catch (NumberFormatException e1) {
                        e.printStackTrace();
                        txtWrongID.setVisible(true);
                    }
                    try {
                        double grade = Double.parseDouble(txtGrade);

                    } catch (NumberFormatException e1) {
                        e.printStackTrace();
                        txtpnWrongGrade.setVisible(true);
                    }

                }
            }
        });

        JButton btnNewButton = new JButton("<< Back");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                home.setVisible(true);
                inputDetails.setVisible(false);
            }
        });
        btnNewButton.setBackground(Color.DARK_GRAY);

        txtWrongID = new JTextPane();
        txtWrongID.setVisible(false);
        txtWrongID.setForeground(Color.RED);
        txtWrongID.setText("Wrong Input!");
        txtWrongID.setEditable(false);
        txtWrongID.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtWrongID.setBackground(Color.DARK_GRAY);

        txtpnWrongGrade = new JTextPane();
        txtpnWrongGrade.setVisible(false);
        txtpnWrongGrade.setEditable(false);
        txtpnWrongGrade.setText("Wrong Input!");
        txtpnWrongGrade.setForeground(Color.RED);
        txtpnWrongGrade.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtpnWrongGrade.setBackground(Color.DARK_GRAY);

        txtWrongName = new JTextPane();
        txtWrongName.setEditable(false);
        txtWrongName.setVisible(false);
        txtWrongName.setForeground(Color.RED);
        txtWrongName.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtWrongName.setBackground(Color.DARK_GRAY);
        txtWrongName.setText("Wrong Input!");

        txtThisStudentAlready = new JTextPane();
        txtThisStudentAlready.setEditable(false);
        txtThisStudentAlready.setVisible(false);
        txtThisStudentAlready.setForeground(Color.RED);
        txtThisStudentAlready.setBackground(Color.DARK_GRAY);
        txtThisStudentAlready.setText("This student already exist!");
        txtThisStudentAlready.setFont(new Font("Tahoma", Font.PLAIN, 16));
        GroupLayout gl_inputDetails = new GroupLayout(inputDetails);
        gl_inputDetails.setHorizontalGroup(
                gl_inputDetails.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_inputDetails.createSequentialGroup()
                                .addGroup(gl_inputDetails.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_inputDetails.createSequentialGroup()
                                                .addGap(110)
                                                .addComponent(txtpnName, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(txtName, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(txtWrongName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_inputDetails.createSequentialGroup()
                                                .addGap(110)
                                                .addComponent(txtpnId, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textId, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(txtWrongID, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(btnNewButton)
                                        .addGroup(gl_inputDetails.createSequentialGroup()
                                                .addGap(110)
                                                .addComponent(txtpnGrade, GroupLayout.PREFERRED_SIZE, 80, GroupLayout.PREFERRED_SIZE)
                                                .addComponent(textGrade, GroupLayout.PREFERRED_SIZE, 230, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(txtpnWrongGrade, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_inputDetails.createSequentialGroup()
                                                .addGap(210)
                                                .addComponent(saveStudentButton, GroupLayout.PREFERRED_SIZE, 105, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_inputDetails.createSequentialGroup()
                                                .addGap(174)
                                                .addComponent(txtThisStudentAlready, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(18, Short.MAX_VALUE))
        );
        gl_inputDetails.setVerticalGroup(
                gl_inputDetails.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_inputDetails.createSequentialGroup()
                                .addComponent(btnNewButton)
                                .addGap(17)
                                .addGroup(gl_inputDetails.createParallelGroup(Alignment.LEADING)
                                        .addComponent(txtpnName, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtName, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtWrongName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(40)
                                .addGroup(gl_inputDetails.createParallelGroup(Alignment.LEADING)
                                        .addComponent(txtpnId, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(textId, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtWrongID, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addGap(40)
                                .addGroup(gl_inputDetails.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_inputDetails.createSequentialGroup()
                                                .addGroup(gl_inputDetails.createParallelGroup(Alignment.LEADING)
                                                        .addComponent(txtpnGrade, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(textGrade, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                                .addGap(40)
                                                .addComponent(saveStudentButton, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtpnWrongGrade, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addComponent(txtThisStudentAlready, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(19))
        );
        inputDetails.setLayout(gl_inputDetails);

        findID = new JPanel();
        findID.setBackground(Color.DARK_GRAY);
        getContentPane().add(findID, "name_548647179567400");

        JTextPane txtpnGiveTheStudent = new JTextPane();
        txtpnGiveTheStudent.setForeground(Color.WHITE);
        txtpnGiveTheStudent.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtpnGiveTheStudent.setBackground(Color.DARK_GRAY);
        txtpnGiveTheStudent.setText("Give the Student ID");

        getID = new JTextField();
        getID.setText(null);
        getID.setHorizontalAlignment(SwingConstants.CENTER);
        getID.setForeground(Color.WHITE);
        getID.setFont(new Font("Tahoma", Font.PLAIN, 14));
        getID.setBackground(Color.DARK_GRAY);
        getID.setColumns(10);

        JButton btnNewButton_1 = new JButton("OK");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {

                try {
                    txtWrongInput.setVisible(false);
                    txtDosentExist.setVisible(false);
                    inputID = Integer.parseInt(getID.getText());

                    if (DeleteChangeFind == 1) {
                        if (list.findStudent(inputID)) {
                            list.deleteStudent(inputID);
                            list.save();
                            home.setVisible(true);
                            findID.setVisible(false);

                        } else {
                            txtDosentExist.setVisible(true);
                        }
                    } else if (DeleteChangeFind == 2) {
                        if (list.findStudent(inputID)) {

                            textId.setEnabled(false);
                            txtThisStudentAlready.setVisible(false);
                            addOrChange = false;
                            txtWrongName.setVisible(false);
                            txtThisStudentAlready.setVisible(false);
                            txtWrongID.setVisible(false);
                            txtpnWrongGrade.setVisible(false);

                            Student st = list.getStudent(inputID);
                            txtName.setText(st.getName());
                            textId.setText(String.valueOf(st.getId()));
                            textGrade.setText(String.valueOf(st.getGrade()));


                            inputDetails.setVisible(true);
                            findID.setVisible(false);
                        } else {
                            txtDosentExist.setVisible(true);

                        }
                    } else if (DeleteChangeFind == 3) {

                        if (list.findStudent(inputID)) {

                            Student st = list.getStudent(inputID);
                            textArea.setText("  ID\t\tName\t\tGrade\n" + String.valueOf(st.getId()) + "\t\t" + st.getName() + "\t\t" + String.valueOf(st.getGrade()) + "\n");
                            printPanel.setVisible(true);
                            findID.setVisible(false);
                        } else {
                            txtDosentExist.setVisible(true);
                        }
                    }


                } catch (NumberFormatException e) {
                    e.printStackTrace();
                    txtWrongInput.setVisible(true);
                }


            }
        });

        JButton btnNewButton_9 = new JButton("<<Back");
        btnNewButton_9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                home.setVisible(true);
                findID.setVisible(false);
            }
        });
        btnNewButton_9.setBackground(Color.DARK_GRAY);

        txtDosentExist = new JTextPane();
        txtDosentExist.setVisible(false);
        txtDosentExist.setEditable(false);
        txtDosentExist.setForeground(Color.RED);
        txtDosentExist.setText("This Student dosen't exist!");
        txtDosentExist.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtDosentExist.setBackground(Color.DARK_GRAY);

        txtWrongInput = new JTextPane();
        txtWrongInput.setVisible(false);
        txtWrongInput.setText("Wrong Input!");
        txtWrongInput.setForeground(Color.RED);
        txtWrongInput.setFont(new Font("Tahoma", Font.PLAIN, 16));
        txtWrongInput.setBackground(Color.DARK_GRAY);
        txtWrongInput.setEditable(false);
        GroupLayout gl_findID = new GroupLayout(findID);
        gl_findID.setHorizontalGroup(
                gl_findID.createParallelGroup(Alignment.TRAILING)
                        .addGroup(gl_findID.createSequentialGroup()
                                .addGroup(gl_findID.createParallelGroup(Alignment.LEADING)
                                        .addGroup(gl_findID.createSequentialGroup()
                                                .addGap(190)
                                                .addComponent(txtpnGiveTheStudent, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(btnNewButton_9)
                                        .addGroup(gl_findID.createSequentialGroup()
                                                .addGap(210)
                                                .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 125, GroupLayout.PREFERRED_SIZE))
                                        .addGroup(gl_findID.createSequentialGroup()
                                                .addGap(190)
                                                .addComponent(getID, GroupLayout.PREFERRED_SIZE, 165, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.RELATED)
                                                .addComponent(txtWrongInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap(177, Short.MAX_VALUE))
                        .addGroup(gl_findID.createSequentialGroup()
                                .addContainerGap(178, Short.MAX_VALUE)
                                .addComponent(txtDosentExist, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addGap(175))
        );
        gl_findID.setVerticalGroup(
                gl_findID.createParallelGroup(Alignment.LEADING)
                        .addGroup(gl_findID.createSequentialGroup()
                                .addGroup(gl_findID.createParallelGroup(Alignment.TRAILING)
                                        .addGroup(gl_findID.createSequentialGroup()
                                                .addComponent(btnNewButton_9)
                                                .addGap(92)
                                                .addComponent(txtpnGiveTheStudent, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(ComponentPlacement.UNRELATED)
                                                .addComponent(getID, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
                                        .addComponent(txtWrongInput, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                                .addGap(18)
                                .addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
                                .addGap(34)
                                .addComponent(txtDosentExist, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                                .addContainerGap(49, Short.MAX_VALUE))
        );
        findID.setLayout(gl_findID);

        printPanel = new JPanel();
        printPanel.setBackground(Color.DARK_GRAY);
        getContentPane().add(printPanel, "name_604866131980500");
        printPanel.setLayout(null);

        textArea = new JTextArea();
        textArea.setFont(new Font("Monospaced", Font.PLAIN, 16));
        textArea.setForeground(Color.WHITE);
        textArea.setBackground(Color.DARK_GRAY);
        textArea.setBounds(10, 23, 525, 309);
        printPanel.add(textArea);

        JButton btnNewButton_3 = new JButton("<<Back");
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                printPanel.setVisible(false);
                home.setVisible(true);
            }
        });

        JScrollPane scroll = new JScrollPane(textArea);
        scroll.setBounds(10, 23, 525, 309);
        printPanel.add(scroll);
        btnNewButton_3.setBounds(0, 0, 89, 23);
        printPanel.add(btnNewButton_3);


        this.setVisible(true);
        this.setTitle("Student Menu");
        this.setSize(561, 382);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

