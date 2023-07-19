package com.javaguide.restapi.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import lombok.Data;

@Schema(
        description = "UserDto Model Information"
)
@Data
public class UserDTO {
    private Long id;
    @Schema(
            description = "User first name"
    )
    private String firstName;
    @Schema(
            description = "User last name"
    )
    private String lastName;
    @Schema(
            description = "User email"
    )
    @Email
    private String email;
}
