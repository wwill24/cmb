package org.jivesoftware.smack.parsing;

import java.io.IOException;
import org.jivesoftware.smack.UnparseableStanza;

public class ExceptionThrowingCallback implements ParsingExceptionCallback {
    public void handleUnparsableStanza(UnparseableStanza unparseableStanza) throws IOException {
        throw new IOException(unparseableStanza.getParsingException());
    }
}
