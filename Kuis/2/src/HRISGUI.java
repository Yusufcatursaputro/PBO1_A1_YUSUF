import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class HRISGUI extends JFrame {
    private JFrame frame;
    private JComboBox<String> departmentComboBox;
    private JComboBox<String> positionComboBox;
    private JTextField nameField;
    private JTextField dobField;
    private JButton addEmployeeButton;
    private JButton cancelButton;
    private JTextArea displayArea;
    private JTextField findIdField;
    private JButton addButton;
    private JButton showAllButton;

    private List<Employee> employees;

    public HRISGUI() {
        employees = new ArrayList<>();
        frame = new JFrame("HRIS");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.add(showMainPanel(), BorderLayout.CENTER);
        frame.pack();
        frame.setSize(600, 400);
        frame.setVisible(true);
    }

    private JPanel showMainPanel() {
        addButton = new JButton("Add Data");
        showAllButton = new JButton("Show Data");

        JPanel buttonPanel = new JPanel(new GridLayout(2, 1));
        buttonPanel.add(addButton);
        buttonPanel.add(showAllButton);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaintPanel(showInputPanel());
            }
        });

        showAllButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaintPanel(showAllDataPanel());
            }
        });

        return buttonPanel;
    }

    private JPanel showAllDataPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        JPanel topPanel = new JPanel(new GridLayout(1, 1));

        findIdField = new JTextField(15);
        topPanel.add(findIdField);

        cancelButton = new JButton("Cancel");
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(cancelButton);

        displayArea = new JTextArea(20, 50);
        displayArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(displayArea);

        panel.add(topPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.CENTER);
        panel.add(scrollPane, BorderLayout.SOUTH);

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaintPanel(showMainPanel());
            }
        });

        StringBuilder strBuilder = new StringBuilder();
        for (Employee employee : employees) {
            strBuilder.append("ID: ").append(employee.getId()).append("\n");
            strBuilder.append("Name: ").append(employee.getName()).append("\n");
            strBuilder.append("DOB: ").append(employee.getDateOfBirth()).append("\n");
            strBuilder.append("Position: ").append(employee.getPosition()).append("\n");
            strBuilder.append("Department: ").append(employee.getDepartment()).append("\n");
            strBuilder.append("Salary: ").append(employee.getSalary()).append("\n\n");
        }
        displayArea.setText(strBuilder.toString());

        return panel;
    }

    private void repaintPanel(JPanel newPanel) {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(newPanel);
        frame.revalidate();
        frame.repaint();
    }

    private JPanel showInputPanel() {
        JPanel inputPanel = new JPanel(new GridLayout(7, 2));

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField(15);

        JLabel dobLabel = new JLabel("Date of Birth:");
        dobField = new JTextField(15);

        JLabel departmentLabel = new JLabel("Department:");
        String[] departments = Employee.getDepartment();
        departmentComboBox = new JComboBox<>(departments);

        JLabel positionLabel = new JLabel("Position:");
        String[] positions = {"Manager", "Developer", "HR Staff"};
        positionComboBox = new JComboBox<>(positions);

        addEmployeeButton = new JButton("Add Data");
        cancelButton = new JButton("Cancel");

        inputPanel.add(nameLabel);
        inputPanel.add(nameField);
        inputPanel.add(dobLabel);
        inputPanel.add(dobField);
        inputPanel.add(departmentLabel);
        inputPanel.add(departmentComboBox);
        inputPanel.add(positionLabel);
        inputPanel.add(positionComboBox);
        inputPanel.add(new JLabel(""));
        inputPanel.add(addEmployeeButton);
        inputPanel.add(new JLabel(""));
        inputPanel.add(cancelButton);

        addEmployeeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String dob = dobField.getText();
                String department = departmentComboBox.getSelectedItem().toString();
                String position = positionComboBox.getSelectedItem().toString();
                Employee employee = null;

                if (position.equals("Manager")) {
                    employee = new Manager(name, dob, department);
                } else if (position.equals("Developer")) {
                    employee = new Developer(name, dob, department);
                } else if (position.equals("HR Staff")) {
                    employee = new HRStaff(name, dob, department);
                }

                if (employee != null) {
                    employees.add(employee);
                    JOptionPane.showMessageDialog(HRISGUI.this, "Employee added: " + name + ", " + department);
                }
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaintPanel(showMainPanel());
            }
        });

        return inputPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new HRISGUI();
            }
        });
    }
}
