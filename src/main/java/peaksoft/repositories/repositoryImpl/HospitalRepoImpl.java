package peaksoft.repositories.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import peaksoft.entities.Hospital;
import peaksoft.repositories.HospitalRepository;

import java.util.List;
import java.util.Optional;

@Repository
@Transactional

public class HospitalRepoImpl implements HospitalRepository{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveHospital(Hospital hospital) {
        entityManager.persist(hospital);
    }

    @Override
    public List<Hospital> getAllHospitals() {
        return entityManager.createQuery("select h from Hospital h", Hospital.class).getResultList();
    }

    @Override
    public Optional<Hospital>getHospitalById(Long hospId){
        return Optional.ofNullable(
                entityManager.createQuery("select h from Hospital h where h.id= :hospId",Hospital.class)
                        .setParameter("hospId",hospId)
                        .getSingleResult()
        );
    }

    @Override
    public void deleteHospital(Long id) {
        entityManager.remove(entityManager.find(Hospital.class,id));
    }

    @Override
    public void updateHospital(Long id, Hospital hospital) {
        Hospital hospital1 = entityManager.find(Hospital.class, id);
        hospital1.setName(hospital.getName());
        hospital1.setAddress(hospital.getAddress());
        hospital1.setDoctors(hospital.getDoctors());
        hospital1.setPatients(hospital.getPatients());
        hospital1.setDepartments(hospital.getDepartments());
        hospital1.setAppointments(hospital.getAppointments());
        entityManager.merge(hospital1);
    }

    @Override
    public List<Hospital> findAllByName(String name) {
        return entityManager.createQuery("select h from Hospital h where h.name = :word or h.address=:word",Hospital.class)
                .setParameter("word",name)
                .getResultList();
    }

}
