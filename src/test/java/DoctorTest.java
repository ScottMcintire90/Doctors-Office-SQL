import org.sql2o.*;
import org.junit.*;
import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.List;

public class DoctorTest {

  @Before
  public void setUp() {
    DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/office_test", null, null);
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
    Doctor testDoctor = new Doctor("John Smith", "Endocrinologist");
    assertEquals(true, testDoctor instanceof Doctor);
  }
  @Test
  public void getName_doctorInstantiatesWithName_name() {
    Doctor testDoctor = new Doctor("John Smith", "Endocrinologist");
    assertEquals("John Smith", testDoctor.getName());
  }
  @Test
  public void all_emptyAtFirst() {
    assertEquals(Doctor.all().size(), 0);
  }
  @Test
  public void equals_returnsTrueIfNamesAretheSame() {
    Doctor firstDoctor = new Doctor("John Smith", "Endocrinologist");
    Doctor secondDoctor = new Doctor("John Smith", "Endocrinologist");
    assertTrue(firstDoctor.equals(secondDoctor));
  }
  @Test
  public void save_returnsTrueIfSaved_true() {
    Doctor testDoctor = new Doctor("John Smith", "Endocrinologist");
    testDoctor.save();
    assertEquals(Doctor.all().get(0).getName(),testDoctor.getName());
  }
  @Test
    public void save_assignsIdToObject() {
    Doctor testDoctor = new Doctor("John Smith", "Endocrinologist");
    testDoctor.save();
    Doctor savedDoctor = Doctor.all().get(0);
    assertEquals(testDoctor.getId(), savedDoctor.getId());
  }
  @Test
    public void find_findDoctorInDatabase_true() {
    Doctor testDoctor = new Doctor("John Smith", "Endocrinologist");
    testDoctor.save();
    Doctor savedDoctor = Doctor.find(testDoctor.getId());
    assertEquals(savedDoctor.getName(), testDoctor.getName());
  }
  @Test
  public void getPatients_retrievesAllPatientsFromDatabase_patientsList() {
    Doctor testDoctor = new Doctor("John Smith",  "Endocrinologist");
    testDoctor.save();
    Patient firstPatient = new Patient("Jane Doe", "12-14-1980", testDoctor.getId());
    firstPatient.save();
    Patient secondPatient = new Patient("Susan Summers", "11-13-1970", testDoctor.getId());
    secondPatient.save();
    Patient[] patients = new Patient[] { firstPatient, secondPatient };
    System.out.println(testDoctor.getPatients().size());
    assertEquals(testDoctor.getPatients().size(), 2);
  }
}
