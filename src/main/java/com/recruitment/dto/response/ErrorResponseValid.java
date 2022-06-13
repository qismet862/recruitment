package com.recruitment.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponseValid {

    private String message;
    private Map<String, String> checks;

    public ErrorResponseValid(String message) {
        this.message = message;
    }
}
