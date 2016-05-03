// import java.util.Date;
// import java.sql.Timestamp;
// import java.time.LocalDateTime;
// import org.junit.*;
// import static org.junit.Assert.*;
// import org.sql2o.*;
// import java.util.List;
//
// public class PatientTest {
//
//   @Before
//   public void setUp() {
//     DB.sql2o = new Sql2o("jdbc:postgresql://localhost:5432/to_do_test", null, null);
//   }
//   @After
//   public void tearDown() {
//     try(Connection con = DB.sql2o.open()) {
//       String deletePatientsQuery = "DELETE FROM patients *;";
//       String deleteDoctorsQuery = "DELETE FROM doctors *;";
//       con.createQuery(deletePatientsQuery).executeUpdate();
//       con.createQuery(deleteDoctorsQuery).executeUpdate();
//     }
//   }
//   @Test
//   public void patient_instantiatesCorrectly_true() {
//     Patient testPatient = new Patient("Jane Doe", "12-14-1980");
//     assertEquals(true, testPatient instanceof Patient);
//   }
// }
