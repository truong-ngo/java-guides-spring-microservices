package microservices.department.controller;

import lombok.RequiredArgsConstructor;
import microservices.department.dto.DepartmentDto;
import microservices.department.service.core.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/departments")
@RequiredArgsConstructor
public class DepartmentController {
    private final DepartmentService departmentService;

    @GetMapping
    public ResponseEntity<List<DepartmentDto>> findAll() {
        return ResponseEntity.ok(departmentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DepartmentDto> findById(@PathVariable String id) {
        return ResponseEntity.ok(departmentService.findById(id));
    }

    @GetMapping("/code/{code}")
    public ResponseEntity<DepartmentDto> findByCode(@PathVariable String code) {
        return ResponseEntity.ok(departmentService.findByCode(code));
    }

    @PostMapping
    public ResponseEntity<DepartmentDto> save(@RequestBody DepartmentDto departmentDto) {
        return ResponseEntity.ok(departmentService.save(departmentDto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DepartmentDto> update(@RequestBody DepartmentDto departmentDto, @PathVariable String id) {
        departmentDto.setId(id);
        return ResponseEntity.ok(departmentService.save(departmentDto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id) {
        departmentService.findById(id);
        return ResponseEntity.ok("Delete successfully id: " + id);
    }
}
