package DTOs;

import java.util.List;

public record ValidationResult(
        boolean isValid,
        List<String> errorMessage
) {
}
