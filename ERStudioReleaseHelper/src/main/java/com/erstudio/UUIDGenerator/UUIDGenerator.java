package main.java.com.erstudio.UUIDGenerator;

import java.util.UUID;

public class UUIDGenerator {

    public static final String ELLIPSE = "...";

    public static UUID generateUUID() {
        return UUID.randomUUID();
    }

    public static String toEllipsis(UUID input, int maxCharacters, int charactersAfterEllipse) {
        if (input == null || input.toString().length() < maxCharacters) {
            return input.toString();
        }
        return input.toString().substring(0, maxCharacters - charactersAfterEllipse)
                + ELLIPSE
                + input.toString().substring(input.toString().length() - charactersAfterEllipse);
    }
}
