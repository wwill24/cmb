package com.mparticle;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

class c0 extends b0 {

    /* renamed from: c  reason: collision with root package name */
    private URL f22273c;

    c0(String str) throws MalformedURLException {
        this.f22273c = new URL(str);
    }

    public String b() {
        return this.f22273c.getFile();
    }

    public u c() throws IOException {
        return new v((HttpURLConnection) this.f22273c.openConnection(), this);
    }

    public boolean equals(Object obj) {
        if (obj instanceof c0) {
            return this.f22273c.equals(((c0) obj).f22273c);
        }
        return this.f22273c.equals(obj);
    }

    public String toString() {
        return this.f22273c.toString();
    }
}
