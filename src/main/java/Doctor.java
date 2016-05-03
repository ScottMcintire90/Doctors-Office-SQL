import java.util.List;
import java.util.Arrays;
import org.sql2o.*;

public class Doctor {
  private int id;
  private String name;
  private String specialty;

  public Doctor(String name, String specialty) {
    this.name = name;
    this.specialty = specialty;
  }
  @Override
  public boolean equals(Object otherDoctor) {
    if (!(otherDoctor instanceof Doctor)) {
      return false;
    } else {
      Doctor newDoctor = (Doctor) otherDoctor;
      return this.getName().equals(newDoctor.getName()) &&
             this.getSpecialty() == newDoctor.getSpecialty();
    }
  }
  public String getName() {
    return name;
  }
  public String getSpecialty() {
    return specialty;
  }
  public int getId() {
    return id;
  }

  public static List<Doctor> all() {
    String sql = "SELECT id, name, specialty FROM doctors";
    try(Connection con = DB.sql2o.open()) {
      return con.createQuery(sql).executeAndFetch(Doctor.class);
    }
  }



  public void save() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "INSERT INTO doctors(name, specialty) VALUES (:name, :specialty)";
      this.id = (int) con.createQuery(sql, true)
        .addParameter("name", this.name)
        .addParameter("specialty", this.specialty)
        .executeUpdate()
        .getKey();
    }
  }
  public static Doctor find(int id) {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM doctors where id=:id";
      Doctor doctor = con.createQuery(sql)
        .addParameter("id", id)
        .executeAndFetchFirst(Doctor.class);
      return doctor;
    }
  }
  public List<Patient> getPatients() {
    try(Connection con = DB.sql2o.open()) {
      String sql = "SELECT * FROM patients where doctor_id=:id";
      return con.createQuery(sql)
        .addParameter("id", this.id)
        .executeAndFetch(Patient.class);
    }
  }
}
