package microservices.department.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Department {
    @Id
    private String id;
    private String name;
    private String description;
    @Indexed(unique = true)
    private String code;
}
