package microservices.department.service.core;

import microservices.department.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService extends CrudService<DepartmentDto, String> {
    List<DepartmentDto> findAll();
    DepartmentDto findByCode(String code);
}
