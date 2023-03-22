package me.mrfunny.krab.exception;

import me.mrfunny.krab.Krab;

public class KrabException extends RuntimeException {
    public KrabException(Krab source, String additionalMessage) {
        super("Error while generating source code " + (source == null ? additionalMessage : "of " + source.getName() + "\n" +
                additionalMessage));
    }
}
