package peaksoft.services.serviceImpl;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import peaksoft.entities.Department;
import peaksoft.repositories.DepartmentRepository;
import peaksoft.services.DepartmentService;

import java.util.List;

@Service
@RequiredArgsConstructor

public class DepartmentServiceImpl implements DepartmentService{
    private final DepartmentRepository departmentRepository;

    @Override
    public void saveDepartment(Department department, Long hospId) {
        departmentRepository.saveDepartment(department,hospId);
    }

    @Override
    public List<Department> getAllDepartments(Long hospId) {
        return departmentRepository.getAllDepartments(hospId);
    }

    @Override
    public Department getDepartmentById(Long depId,Long hospId) {
        return departmentRepository.getDepartmentById(depId,hospId);
    }

    @Override
    public void deleteDepartment(Long depId) {
        departmentRepository.deleteDepartment(depId);
    }

    @Override
    public void updateDepartment(Long depId, Department newDepartment) {
        departmentRepository.updateDepartment(depId,newDepartment);
    }

    @Override
    @Transactional
    public void updateDepartmentByHospId(Long depId,Long hospId, Department newDepartment) {
        Department department = departmentRepository.getDepartmentById(depId,hospId);
        if (department != null){
            department.setName(newDepartment.getName());
            departmentRepository.saveDepartment(department);
        }
    }

    @Override
    public Department getDepById(Long depId) {
        return departmentRepository.getDepById(depId);
    }
}
