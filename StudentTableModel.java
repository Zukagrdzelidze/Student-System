import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;
import java.util.List;

public class StudentTableModel extends AbstractTableModel {

    private String[] header = {"First Name", "Last Name",  "Year"};
    private List<Student> students;

    public StudentTableModel(){
        students = new ArrayList<>();
    }
    @Override
    public int getRowCount() {
         return students.size();
    }

    @Override
    public int getColumnCount() {
        return header.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Student student = students.get(rowIndex);
        switch (columnIndex){
            case 0: return student.getFirstName();
            case 1: return student.getLastName();
            case 2: return student.getYear();
        }
        throw new RuntimeException("Could not get value. You made mistake");
    }
    @Override
    public String getColumnName(int column){
        return header[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex){
        return false;
    }


    public void setStudents(List<Student> students){
        this.students = students;
        fireTableDataChanged();
    }

}
