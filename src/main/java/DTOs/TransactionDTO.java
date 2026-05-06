package DTOs;

public record TransactionDTO(
        String user,
        String id,
        String value,
        String coin,
        String hash
) {}
