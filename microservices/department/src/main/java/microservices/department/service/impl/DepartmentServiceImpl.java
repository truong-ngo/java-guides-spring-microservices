package microservices.department.service.impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import microservices.department.dto.DepartmentDto;
import microservices.department.exception.BusinessException;
import microservices.department.repository.DepartmentRepo;
import microservices.department.service.core.DepartmentService;
import microservices.department.service.mapper.DepartmentMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {
    private final DepartmentRepo departmentRepo;
    private final DepartmentMapper departmentMapper;

    @Override
    public DepartmentDto findById(String id) {
        log.info("Request to get department by id: {}", id);
        return departmentMapper.toDto(departmentRepo.findById(id)
                .orElseThrow(() -> new BusinessException("deptNotFound")));
    }

    @Override
    public DepartmentDto save(DepartmentDto departmentDto) {
        log.info("Request to save department: {}", departmentDto);
        return departmentMapper.toDto(departmentRepo.save(departmentMapper.toEntity(departmentDto)));
    }

    @Override
    public void delete(String id) {
        log.info("Request to save department with id: {}", id);
        departmentRepo.deleteById(id);
    }

    @Override
    public List<DepartmentDto> findAll() {
        log.info("Request to get all department");
        return departmentRepo.findAll().stream().map(departmentMapper::toDto).toList();
    }

    @Override
    public DepartmentDto findByCode(String code) {
        log.info("Request to get department by code: {}", code);
        return departmentMapper.toDto(departmentRepo.findByCode(code)
                .orElseThrow(() -> new BusinessException("deptNotFound")));
    }
}
