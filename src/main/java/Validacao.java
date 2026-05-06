public class Validacao {
    public boolean isValidTransation(String payload) {
        return payload.codePoints().noneMatch(cp ->
                Character.isISOControl(cp) ||
                        Character.getType(cp) == Character.MATH_SYMBOL
                );
    }
}
