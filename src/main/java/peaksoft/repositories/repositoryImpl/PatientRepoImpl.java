package peaksoft.repositories.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import peaksoft.entities.Patient;
import peaksoft.repositories.PatientRepository;

import java.util.List;
@Repository
@Transactional

public class PatientRepoImpl implements PatientRepository {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void savePatient(Patient patient) {

    }

    @Override
    public List<Patient> getAllPatients() {
        return null;
    }

    @Override
    public Patient getPatientById(Long id) {
        return null;
    }

    @Override
    public void deletePatient(Long id) {

    }

    @Override
    public void updatePatient(Long id, Patient patient) {

    }
}
