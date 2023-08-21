package peaksoft.services;

import peaksoft.entities.Department;
import java.util.List;



public interface DepartmentService {

    void saveDepartment(Department department,Long hospId);

    List<Department> getAllDepartments(Long hospId);

    Department getDepartmentById(Long depId,Long hospId);

    void deleteDepartment(Long depId);

    void updateDepartment(Long depId, Department newDepartment);

    void updateDepartmentByHospId(Long depId,Long hospId, Department newDepartment);

    Department getDepById(Long depId);
}
