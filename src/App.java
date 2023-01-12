import db.DB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class App {

  public static void main(String[] args) {
    System.out.println("=====================================================");

    Connection conn = null;
    PreparedStatement st = null;
    try {
      conn = DB.getConnection();

      st =
        conn.prepareStatement(
          "UPDATE seller " +
          "SET BaseSalary = BaseSalary + ?" +
          "WHERE " +
          "(DepartmentId = ?)"
        );

      st.setDouble(1, 200.0);
      st.setInt(2, 2);

      int rowsAffected = st.executeUpdate();

      System.out.println("Done! Rows affected: " + rowsAffected);
    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      DB.closeStatement(st);
      DB.closeConnection();
    }

    System.out.println("=====================================================");
  }
}
