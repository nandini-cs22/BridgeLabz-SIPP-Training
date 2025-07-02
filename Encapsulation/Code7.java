import java.util.ArrayList;
import java.util.List;

abstract class Patient {
    private String patientId;
    private String name;
    private int age;
    private String diagnosis;

    public Patient(String patientId, String name, int age, String diagnosis) {
        this.patientId = patientId;
        this.name = name;
        this.age = age;
        this.diagnosis = diagnosis;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    protected String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getPatientDetails() {
        return "ID: " + patientId + ", Name: " + name + ", Age: " + age + ", Diagnosis: " + diagnosis;
    }

    public abstract double calculateBill();
}

interface MedicalRecord {
    void addRecord(String record);
    List<String> viewRecords();
}

class InPatient extends Patient implements MedicalRecord {
    private int daysAdmitted;
    private double dailyRate;
    private List<String> medicalHistory;

    public InPatient(String patientId, String name, int age, String diagnosis, int daysAdmitted, double dailyRate) {
        super(patientId, name, age, diagnosis);
        this.daysAdmitted = daysAdmitted;
        this.dailyRate = dailyRate;
        this.medicalHistory = new ArrayList<>();
    }

    public double calculateBill() {
        return daysAdmitted * dailyRate;
    }

    public void addRecord(String record) {
        medicalHistory.add(record);
    }

    public List<String> viewRecords() {
        return medicalHistory;
    }
}

class OutPatient extends Patient implements MedicalRecord {
    private double consultationFee;
    private List<String> medicalHistory;

    public OutPatient(String patientId, String name, int age, String diagnosis, double consultationFee) {
        super(patientId, name, age, diagnosis);
        this.consultationFee = consultationFee;
        this.medicalHistory = new ArrayList<>();
    }

    public double calculateBill() {
        return consultationFee;
    }

    public void addRecord(String record) {
        medicalHistory.add(record);
    }

    public List<String> viewRecords() {
        return medicalHistory;
    }
}

public class Main {
    public static void main(String[] args) {
        Patient[] patients = new Patient[2];

        InPatient inPatient = new InPatient("P001", "Alice", 45, "Pneumonia", 5, 2000);
        inPatient.addRecord("Admitted to ward A");
        inPatient.addRecord("Prescribed antibiotics");

        OutPatient outPatient = new OutPatient("P002", "Bob", 30, "Flu", 500);
        outPatient.addRecord("Consulted Dr. Smith");
        outPatient.addRecord("Prescribed rest");

        patients[0] = inPatient;
        patients[1] = outPatient;

        for (Patient p : patients) {
            System.out.println(p.getPatientDetails());
            System.out.println("Total Bill: " + p.calculateBill());

            if (p instanceof MedicalRecord) {
                List<String> records = ((MedicalRecord) p).viewRecords();
                System.out.println("Medical History:");
                for (String r : records) {
                    System.out.println("- " + r);
                }
            }

            System.out.println();
        }
    }
}
