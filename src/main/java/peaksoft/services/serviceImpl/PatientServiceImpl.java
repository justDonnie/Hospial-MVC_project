package peaksoft.services.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entities.Patient;
import peaksoft.repositories.PatientRepository;
import peaksoft.services.PatientService;

import java.util.List;
@Service
@RequiredArgsConstructor

public class PatientServiceImpl implements PatientService {

    private final PatientRepository patientRepository;
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
