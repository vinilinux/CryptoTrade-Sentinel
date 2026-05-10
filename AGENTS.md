# CryptoTrade-Sentinel Agent Guidelines

## Overview
CryptoTrade-Sentinel is a Java application for processing cryptocurrency trade transactions. It parses payloads, validates data, applies financial processing, and enforces limits.

## Architecture
- **Monolithic structure**: Single entry point with utility classes.
- **Packages**: Default (Main), DTOs, Utils.
- **No external dependencies**: Pure Java using standard library.

## Key Components
- `Main.java`: Entry point; orchestrates parsing, validation, processing.
- `ProcessamentoFinanceiro.java`: Applies 1.02 tax multiplier to transaction values.
- `TransactionDTO.java`: Record holding user, id, value, coin, hash (all strings).
- `Mapper.java`: Parses pipe-separated key:value payload into DTO.
- `Validacao.java`: Validates user (digits only) and hash (alphanumeric).

## Data Flow
1. Payload string (e.g., "USER:123|ID:acc_br_99|VAL:1500,75|COIN:BTC|HASH:7a8b9c") → `Mapper.parsePayload()` → `TransactionDTO`
2. `Validacao.isValidTransation()` → error string or empty
3. `ProcessamentoFinanceiro.processar(value)` → BigDecimal with tax applied
4. Compare to limit; print result or error

## Conventions
- **Naming**: Methods in Portuguese (e.g., `processar`, `validaUser`).
- **Numbers**: Brazilian locale parsing (comma as decimal separator).
- **Validation**: Returns concatenated error messages; empty string means valid.
- **Money**: Use `BigDecimal` for precision; apply `RoundingMode.HALF_UP` to 2 decimals.
- **Payload parsing**: Remove spaces, split by "|", then ":"; assumes fixed order.

## Workflows
- **Compile**: `javac -d out src/main/java/*.java src/main/java/DTOs/*.java src/main/java/Utils/*.java`
- **Run**: `java -cp out Main`
- **Debug**: Add print statements in Main; no logging framework.

## Patterns
- **DTO**: Use records for immutable data transfer.
- **Utils**: Static methods for parsing/validation.
- **Processing**: Separate class for financial logic; throws RuntimeException on parse errors.
- **Limits**: Hardcoded in Main; compare BigDecimal values.</content>
<parameter name="filePath">/home/vinicius/Documentos/CryptoTrade-Sentinel/AGENTS.md
