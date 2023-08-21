package peaksoft.repositories.repositoryImpl;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;
import peaksoft.entities.Department;
import peaksoft.entities.Hospital;
import peaksoft.repositories.DepartmentRepository;

import java.util.List;

@Repository
@Transactional

public class DepartmentRepoImpl implements DepartmentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public void saveDepartment(Department department, Long hospId) {
        Hospital hospital = entityManager.find(Hospital.class, hospId);
        department.setHospital(hospital);
        entityManager.persist(department);
    }

    @Override
    public void saveDepartment(Department department) {
        entityManager.persist(department);
    }

    @Override
    public List<Department> getAllDepartments(Long hospId) {
        return entityManager.createQuery("select d from Department d where d.hospital.id = :hospId",Department.class)
                .setParameter("hospId",hospId)
                .getResultList();
    }

    @Override
    public Department getDepartmentById(Long depId, Long hospId){
        return entityManager.createQuery("select d from Department d where d.id = :depId and d.hospital.id=:hospId",Department.class)
                        .setParameter("depId",depId)
                        .setParameter("hospId",hospId)
                        .getSingleResult();
    }

    @Override
    public void deleteDepartment(Long depId) {
        entityManager.remove(entityManager.find(Department.class,depId));
    }

    @Override
    public void updateDepartment(Long depId, Department department) {
        Department department1 = entityManager.find(Department.class, depId);
        department1.setName(department.getName());
        department1.setDoctors(department.getDoctors());
        entityManager.merge(department1);
    }

    @Override
    public Department getDepById(Long depId) {
        Department department = entityManager.find(Department.class,depId);
        return department;
    }
}
