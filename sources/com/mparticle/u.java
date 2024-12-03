package com.mparticle;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ProtocolException;
import javax.net.ssl.SSLSocketFactory;

public interface u {
    InputStream a();

    void a(Boolean bool);

    void a(Integer num);

    void a(String str) throws ProtocolException;

    void a(String str, String str2);

    void a(SSLSocketFactory sSLSocketFactory);

    OutputStream b() throws IOException;

    String b(String str);

    void b(Integer num);

    InputStream c() throws IOException;

    int d() throws IOException;

    boolean e();

    String f() throws IOException;

    String g();

    b0 h();
}
