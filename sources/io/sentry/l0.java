package io.sentry;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.util.Map;

public interface l0 {
    <T> void a(T t10, Writer writer) throws IOException;

    void b(w2 w2Var, OutputStream outputStream) throws Exception;

    <T> T c(Reader reader, Class<T> cls);

    w2 d(InputStream inputStream);

    String e(Map<String, Object> map) throws Exception;
}
