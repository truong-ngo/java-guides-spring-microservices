package microservices.department.service.mapper;


import microservices.department.dto.DepartmentDto;
import microservices.department.entity.Department;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface DepartmentMapper extends EntityMapper<Department, DepartmentDto> {
}
