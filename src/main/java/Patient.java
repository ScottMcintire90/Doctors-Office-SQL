import java.util.List;
import org.sql2o.*;
import java.util.Arrays;

public class Patient {
  private int id;
  private String name;
  private String birthdate;
  private int doctor_id;

  public Patient(String name, String birthdate, int doctor_id) {
    this.name = name;
    this.birthdate = birthdate;
    this.doctor_id = doctor_id;
  }
  public String getName() {
    return name;
  }
  public int getId() {
    return id;
  }
  public int getDoctorId() {
    return doctor_id;
  }
  public String getBirthdate() {
    return birthdate;
  }
  public static List<Patient> all() {
    String sql = "SELECT id, name, birthdate, doctor_id FROM patients";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Patient.class);
    }
  }
  @Override
  public boolean equals(Object otherPatient){
    if (!(otherPatient instanceof Patient)) {
      return false;
    } else {
      Patient newPatient = (Patient) otherPatient;
      return this.getName().equals(newPatient.getName()) &&
             this.getId() == newPatient.getId() &&
             this.getBirthdate() == newPatient.getBirthdate() &&
             this.getDoctorId() == newPatient.getDoctorId();
    }
  }
  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO patients(name, birthdate, doctor_id) VALUES (:name, :birthdate, :doctor_id)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("birthdate", this.birthdate)
        .addParameter("doctor_id", this.doctor_id)
        .executeUpdate()
        .getKey();
    }
  }
  public static Patient find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM patients where id=:id";
      Patient patient = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Patient.class);
      return patient;
    }
  }
}
