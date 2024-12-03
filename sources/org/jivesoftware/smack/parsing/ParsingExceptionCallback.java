package org.jivesoftware.smack.parsing;

import java.io.IOException;
import org.jivesoftware.smack.UnparseableStanza;

public interface ParsingExceptionCallback {
    void handleUnparsableStanza(UnparseableStanza unparseableStanza) throws IOException;
}
