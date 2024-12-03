package org.jivesoftware.smackx.bytestreams;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface BytestreamSession {
    void close() throws IOException;

    InputStream getInputStream() throws IOException;

    OutputStream getOutputStream() throws IOException;

    int getReadTimeout() throws IOException;

    void setReadTimeout(int i10) throws IOException;
}
