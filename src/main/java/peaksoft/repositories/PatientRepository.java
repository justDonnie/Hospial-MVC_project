package peaksoft.repositories;

import peaksoft.entities.Patient;

import java.util.List;

public interface PatientRepository {

    void savePatient(Patient patient);

    List<Patient> getAllPatients();

    Patient getPatientById(Long id);

    void deletePatient(Long id);

    void updatePatient(Long id,Patient patient);

}
