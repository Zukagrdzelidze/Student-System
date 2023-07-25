import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SwingView {


    private JFrame frame;
    private StudentTableModel model;
    private StudentStore store;
    public SwingView(StudentStore store){
        this.store = store;
        frame = new JFrame();
        JPanel mainPanel = new JPanel(new BorderLayout());

        JPanel createPanel = new JPanel(new GridLayout(2, 4));
        JTextField firstNameTF = new JTextField();
        JTextField lastNameTF = new JTextField();
        JTextField yearTF = new JTextField();
        JButton create = new JButton("Add");

        create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = firstNameTF.getText();
                String lastName = lastNameTF.getText();
                String year = yearTF.getText();
                store.addStudent(new Student(firstName, lastName, Integer.valueOf(year)));
                model.setStudents(store.getStudents());
            }
        });

        JTextField firstNameFTF = new JTextField();
        JTextField lastNameFTF = new JTextField();
        JTextField yearFTF = new JTextField();
        JButton filter = new JButton("Filter");

        createPanel.add(firstNameTF);
        createPanel.add(lastNameTF);
        createPanel.add(yearTF);
        createPanel.add(create);
        createPanel.add(firstNameFTF);
        createPanel.add(lastNameFTF);
        createPanel.add(yearFTF);
        createPanel.add(filter);

        mainPanel.add(createPanel, BorderLayout.NORTH);

        JTable table = new JTable();
        model = new StudentTableModel();
        table.setModel(model);
        JPanel tablePanel = new JPanel(new BorderLayout());

        tablePanel.add(table.getTableHeader(), BorderLayout.NORTH);
        tablePanel.add(table, BorderLayout.CENTER);

        mainPanel.add(tablePanel);

        frame.setContentPane(mainPanel);
        frame.setSize(500, 600);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    public void show(){
        frame.setVisible(true);
    }
}
