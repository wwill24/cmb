package ig;

import ig.n;
import java.security.GeneralSecurityException;
import java.security.KeyFactory;
import java.security.KeyPairGenerator;
import java.security.MessageDigest;
import java.security.Provider;
import java.security.Security;
import java.security.Signature;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.Mac;

public final class m<T_WRAPPER extends n<T_ENGINE>, T_ENGINE> {

    /* renamed from: d  reason: collision with root package name */
    private static final Logger f23526d = Logger.getLogger(m.class.getName());

    /* renamed from: e  reason: collision with root package name */
    private static final List<Provider> f23527e;

    /* renamed from: f  reason: collision with root package name */
    public static final m<n.a, Cipher> f23528f = new m<>(new n.a());

    /* renamed from: g  reason: collision with root package name */
    public static final m<n.e, Mac> f23529g = new m<>(new n.e());

    /* renamed from: h  reason: collision with root package name */
    public static final m<n.g, Signature> f23530h = new m<>(new n.g());

    /* renamed from: i  reason: collision with root package name */
    public static final m<n.f, MessageDigest> f23531i = new m<>(new n.f());

    /* renamed from: j  reason: collision with root package name */
    public static final m<n.b, KeyAgreement> f23532j = new m<>(new n.b());

    /* renamed from: k  reason: collision with root package name */
    public static final m<n.d, KeyPairGenerator> f23533k = new m<>(new n.d());

    /* renamed from: l  reason: collision with root package name */
    public static final m<n.c, KeyFactory> f23534l = new m<>(new n.c());

    /* renamed from: a  reason: collision with root package name */
    private T_WRAPPER f23535a;

    /* renamed from: b  reason: collision with root package name */
    private List<Provider> f23536b = f23527e;

    /* renamed from: c  reason: collision with root package name */
    private boolean f23537c = true;

    static {
        if (v.b()) {
            f23527e = b("GmsCore_OpenSSL", "AndroidOpenSSL");
        } else {
            f23527e = new ArrayList();
        }
    }

    public m(T_WRAPPER t_wrapper) {
        this.f23535a = t_wrapper;
    }

    public static List<Provider> b(String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String str : strArr) {
            Provider provider = Security.getProvider(str);
            if (provider != null) {
                arrayList.add(provider);
            } else {
                f23526d.info(String.format("Provider %s not available", new Object[]{str}));
            }
        }
        return arrayList;
    }

    public T_ENGINE a(String str) throws GeneralSecurityException {
        Exception exc = null;
        for (Provider a10 : this.f23536b) {
            try {
                return this.f23535a.a(str, a10);
            } catch (Exception e10) {
                if (exc == null) {
                    exc = e10;
                }
            }
        }
        if (this.f23537c) {
            return this.f23535a.a(str, (Provider) null);
        }
        throw new GeneralSecurityException("No good Provider found.", exc);
    }
}
