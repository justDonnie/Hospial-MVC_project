package peaksoft.repositories;

import peaksoft.entities.Department;

import java.util.List;

public interface DepartmentRepository {

    void saveDepartment(Department department,Long hospId);
    void saveDepartment(Department department);

    List<Department> getAllDepartments(Long hospId);

    Department getDepartmentById(Long depId,Long hospId);

    void deleteDepartment(Long depId);

    void updateDepartment(Long depId, Department department);

    Department getDepById(Long depId);
}
