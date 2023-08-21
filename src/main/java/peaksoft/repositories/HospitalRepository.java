package peaksoft.repositories;

import peaksoft.entities.Hospital;

import java.util.List;
import java.util.Optional;

public interface HospitalRepository {

    void saveHospital(Hospital hospital);

    List<Hospital> getAllHospitals();

    Optional<Hospital> getHospitalById(Long id);

    void deleteHospital(Long id);

    void updateHospital(Long id,Hospital hospital);

    List<Hospital> findAllByName(String name);

}
