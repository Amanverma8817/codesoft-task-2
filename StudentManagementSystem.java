import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class StudentManagementSystem extends JFrame {
    private List<Student> studentList;
    private DefaultListModel<String> studentListModel;
    private JList<String> studentListUI;
    private JTextField nameField;
    private JTextField idField;

    public StudentManagementSystem() {
        studentList = new ArrayList<>();
        studentListModel = new DefaultListModel<>();
        studentListUI = new JList<>(studentListModel);

        nameField = new JTextField(20);
        idField = new JTextField(20);

        JButton addButton = new JButton("Add Student");
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String id = idField.getText();

                if (!name.isEmpty() && !id.isEmpty()) {
                    Student student = new Student(name, id);
                    studentList.add(student);
                    studentListModel.addElement(student.toString());
                    nameField.setText("");
                    idField.setText("");
                }
            }
        });

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(3, 2));
        inputPanel.add(new JLabel("Name: "));
        inputPanel.add(nameField);
        inputPanel.add(new JLabel("ID: "));
        inputPanel.add(idField);
        inputPanel.add(addButton);

        setLayout(new BorderLayout());
        add(new JScrollPane(studentListUI), BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        setTitle("Student Management System");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                StudentManagementSystem sms = new StudentManagementSystem();
                sms.setVisible(true);
            }
        });
    }
}

class Student {
    private String name;
    private String id;

    public Student(String name, String id) {
        this.name = name;
        this.id = id;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", ID: " + id;
    }
}
