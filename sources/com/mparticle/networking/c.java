package com.mparticle.networking;

import android.content.SharedPreferences;
import com.mparticle.BuildConfig;
import com.mparticle.MParticle;
import com.mparticle.internal.Logger;
import com.mparticle.internal.b;
import com.mparticle.networking.b;
import com.mparticle.u;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.zip.GZIPOutputStream;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import org.jivesoftware.smack.util.TLSUtils;

public class c extends a {

    /* renamed from: b  reason: collision with root package name */
    private b f22623b;

    /* renamed from: c  reason: collision with root package name */
    private SSLSocketFactory f22624c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f22625d;

    c(b bVar, SharedPreferences sharedPreferences) {
        super(sharedPreferences);
        this.f22623b = bVar;
    }

    private boolean b() {
        NetworkOptions G = this.f22623b.G();
        if (b.u() != MParticle.Environment.Development || !G.pinningDisabledInDevelopment) {
            return false;
        }
        return true;
    }

    public u a(b.C0262b bVar, u uVar, String str, boolean z10) throws IOException {
        OutputStream a10;
        try {
            if (a() && uVar.e() && !b()) {
                try {
                    uVar.a(a(bVar));
                } catch (Exception unused) {
                }
            }
            if (str != null) {
                a10 = a(uVar);
                a10.write(str.getBytes());
                a10.close();
            }
            if (!z10) {
                int d10 = uVar.d();
                if (d10 == 400 && !this.f22625d) {
                    this.f22625d = true;
                    Logger.error("Bad API request - is the correct API key and secret configured?");
                }
                if ((d10 == 503 || d10 == 429) && !BuildConfig.MP_DEBUG.booleanValue()) {
                    a(uVar, bVar);
                }
            }
            return uVar;
        } catch (IOException e10) {
            throw e10;
        } catch (Throwable th2) {
            a10.close();
            throw th2;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a() {
        return true;
    }

    /* access modifiers changed from: protected */
    public OutputStream a(u uVar) throws IOException {
        return new GZIPOutputStream(new BufferedOutputStream(uVar.b()));
    }

    /* access modifiers changed from: protected */
    public SSLSocketFactory a(b.C0262b bVar) throws Exception {
        if (this.f22624c == null) {
            KeyStore instance = KeyStore.getInstance(KeyStore.getDefaultType());
            instance.load((InputStream) null, (char[]) null);
            CertificateFactory instance2 = CertificateFactory.getInstance("X.509");
            DomainMapping domain = this.f22623b.G().getDomain(bVar);
            for (Certificate next : domain != null ? domain.getCertificates() : d.b()) {
                instance.setCertificateEntry(next.getAlias(), a(instance2, next.getCertificate()));
            }
            TrustManagerFactory instance3 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance3.init(instance);
            SSLContext instance4 = SSLContext.getInstance(TLSUtils.TLS);
            instance4.init((KeyManager[]) null, instance3.getTrustManagers(), (SecureRandom) null);
            this.f22624c = instance4.getSocketFactory();
        }
        return this.f22624c;
    }

    private static Certificate a(CertificateFactory certificateFactory, String str) throws IOException, CertificateException {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(str.getBytes());
        try {
            return certificateFactory.generateCertificate(byteArrayInputStream);
        } finally {
            byteArrayInputStream.close();
        }
    }
}
