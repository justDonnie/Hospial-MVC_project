package peaksoft.services.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entities.Hospital;
import peaksoft.repositories.HospitalRepository;
import peaksoft.services.HospitalService;

import java.util.List;

@Service
@RequiredArgsConstructor

public class HospitalServiceImpl implements HospitalService {
    private final HospitalRepository hospitalRepository;

    @Override
    public void saveHospital(Hospital hospital) {
        hospitalRepository.saveHospital(hospital);
    }

    @Override
    public List<Hospital> getAllHospitals() {
        return hospitalRepository.getAllHospitals();
    }

    @Override
    public Hospital getHospitalById(Long hospId) {
        return hospitalRepository.getHospitalById(hospId)
                .orElseThrow(()-> new RuntimeException(" Hospital with ID "+hospId+" not found !!!"));
    }

    @Override
    public void deleteHospital(Long id) {
        hospitalRepository.deleteHospital(id);
    }

    @Transactional
    @Override
    public void updateHospital(Long hospitalId, Hospital newHospital) {
        hospitalRepository.updateHospital(hospitalId,newHospital);
    }

    @Override
    public List<Hospital> getAllHospitals(String name, String address) {
        if(name != null & address == null){
            return hospitalRepository.findAllByName(name);
        }
        return hospitalRepository.getAllHospitals();
    }
}
