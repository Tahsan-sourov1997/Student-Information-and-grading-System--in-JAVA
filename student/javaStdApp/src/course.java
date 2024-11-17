
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;

public class course {
 
     public void insertUpdateDeleteCourse(char operation,Integer id,String label,Integer hours){
        Connection con = MyConnection.getConnection();
        PreparedStatement ps;
        if(operation == 'i')
        {
            try {
                ps = con.prepareStatement("INSERT INTO `course` (`label`,`hours_number`) VALUES(?,?)");
                ps.setString(1, label);
                ps.setInt(2, hours);
                if(ps.executeUpdate()>=1){
                    JOptionPane.showMessageDialog(null,"New Course Added");
                }
                
                
            } catch (SQLException ex) {
                Logger.getLogger(student.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
     }
     
     public int getCourseId(String Courselabel){
         
         int courseId = 0;
         
         Connection con = MyConnection.getConnection();
         PreparedStatement ps;
         
         try {
             ps = con.prepareStatement("SELECT * FROM `course` WHERE `label` = ?");
             ps.setString(1, Courselabel);
             ResultSet rs = ps.executeQuery();
             
             if(rs.next()){
                 courseId = rs.getInt("id");
             }
             
                     
                     } catch (SQLException ex) {
             Logger.getLogger(course.class.getName()).log(Level.SEVERE, null, ex);
         }
         
         return courseId;
     }
     
     
     public void fillCourseCombo(JComboBox combo){
         
          Connection con = MyConnection.getConnection();
         PreparedStatement ps;
         
         try {
             ps = con.prepareStatement("SELECT * FROM `course`");
       
             ResultSet rs = ps.executeQuery();
             while(rs.next()){
                 combo.addItem(rs.getString(2));
             }
             
                  } catch (SQLException ex) {
             Logger.getLogger(course.class.getName()).log(Level.SEVERE, null, ex);
         }
         
     }
}
   

