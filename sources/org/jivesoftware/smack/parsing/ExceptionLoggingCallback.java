package org.jivesoftware.smack.parsing;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.jivesoftware.smack.UnparseableStanza;

public class ExceptionLoggingCallback implements ParsingExceptionCallback {
    private static final Logger LOGGER = Logger.getLogger(ExceptionLoggingCallback.class.getName());

    public void handleUnparsableStanza(UnparseableStanza unparseableStanza) {
        Logger logger = LOGGER;
        Level level = Level.SEVERE;
        logger.log(level, "Smack message parsing exception. Content: '" + unparseableStanza.getContent() + "'", unparseableStanza.getParsingException());
    }
}
