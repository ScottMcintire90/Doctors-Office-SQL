import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

public class DoctorTest {

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/medical_records_test", null, null);
  }
  @After
  public void tearDown() {
    try(Connection con = DB.sql2o.open()) {
      String deletePatientsQuery = "DELETE FROM patients *;";
      String deleteDoctorsQuery = "DELETE FROM doctors *;";
      con.createQuery(deletePatientsQuery).executeUpdate();
      con.createQuery(deleteDoctorsQuery).executeUpdate();
    }
  }
  @Test
  public void Doctor_instantiatesCorrectly_true() {
    Doctor testDoctor = new Doctor("John Smith");
    assertEquals(true, testDoctor instanceof Doctor);
  }
  @Test
  public void getName_doctorInstantiatesWithName_name() {
    Doctor testDoctor = new Doctor("John Smith");
    assertEquals("John Smith", testDoctor.getName());
  }
}
