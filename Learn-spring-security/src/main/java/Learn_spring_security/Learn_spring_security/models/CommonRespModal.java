package Learn_spring_security.Learn_spring_security.models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@Component
public class CommonRespModal {
    private String statusCode;
    private String message;
    private List<?> response;
}

