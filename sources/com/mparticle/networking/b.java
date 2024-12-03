package com.mparticle.networking;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import com.facebook.internal.security.CertificateUtil;
import com.mparticle.BuildConfig;
import com.mparticle.b0;
import com.mparticle.internal.Logger;
import com.mparticle.internal.MPUtility;
import com.mparticle.u;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private Context f22610a;

    /* renamed from: b  reason: collision with root package name */
    private com.mparticle.internal.b f22611b;

    /* renamed from: c  reason: collision with root package name */
    private a f22612c;

    /* renamed from: d  reason: collision with root package name */
    private SharedPreferences f22613d;

    /* renamed from: e  reason: collision with root package name */
    String f22614e;

    static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f22615a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.mparticle.networking.b$b[] r0 = com.mparticle.networking.b.C0262b.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f22615a = r0
                com.mparticle.networking.b$b r1 = com.mparticle.networking.b.C0262b.CONFIG     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f22615a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mparticle.networking.b$b r1 = com.mparticle.networking.b.C0262b.EVENTS     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f22615a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.mparticle.networking.b$b r1 = com.mparticle.networking.b.C0262b.ALIAS     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f22615a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.mparticle.networking.b$b r1 = com.mparticle.networking.b.C0262b.IDENTITY     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f22615a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.mparticle.networking.b$b r1 = com.mparticle.networking.b.C0262b.AUDIENCE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mparticle.networking.b.a.<clinit>():void");
        }
    }

    /* renamed from: com.mparticle.networking.b$b  reason: collision with other inner class name */
    public enum C0262b {
        CONFIG(1),
        IDENTITY(2),
        EVENTS(3),
        AUDIENCE(4),
        ALIAS(5);
        

        /* renamed from: a  reason: collision with root package name */
        public int f22622a;

        private C0262b(int i10) {
            this.f22622a = i10;
        }

        static C0262b a(int i10) {
            if (i10 == 1) {
                return CONFIG;
            }
            if (i10 == 2) {
                return IDENTITY;
            }
            if (i10 == 3) {
                return EVENTS;
            }
            if (i10 == 4) {
                return AUDIENCE;
            }
            if (i10 != 5) {
                return null;
            }
            return ALIAS;
        }
    }

    public b(Context context, com.mparticle.internal.b bVar) {
        this.f22610a = context;
        this.f22611b = bVar;
        SharedPreferences sharedPreferences = context.getSharedPreferences("mParticlePrefs", 0);
        this.f22613d = sharedPreferences;
        this.f22612c = new c(bVar, sharedPreferences);
        this.f22614e = bVar.j();
    }

    /* access modifiers changed from: protected */
    public u a(C0262b bVar, u uVar, boolean z10) throws IOException {
        return a(bVar, uVar, (String) null, z10);
    }

    /* access modifiers changed from: protected */
    public b0 b(C0262b bVar) throws MalformedURLException {
        return a(bVar, (String) null);
    }

    /* access modifiers changed from: protected */
    public String c() {
        return new SimpleDateFormat("EEE, dd MMM yyyy HH:mm:ss zzz", Locale.US).format(new Date());
    }

    public u a(C0262b bVar, u uVar, String str, boolean z10) throws IOException {
        return this.f22612c.a(bVar, uVar, str, z10);
    }

    /* access modifiers changed from: protected */
    public String a(u uVar, String str, String str2, String str3) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
        String g10 = uVar.g();
        String b10 = uVar.h().a().b();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(g10);
        sb2.append("\n");
        sb2.append(str);
        sb2.append("\n");
        sb2.append(b10);
        if (str2 != null) {
            sb2.append(str2);
        }
        return MPUtility.hmacSha256Encode(str3, sb2.toString());
    }

    public long a(C0262b bVar) {
        SharedPreferences sharedPreferences = this.f22613d;
        return sharedPreferences.getLong(bVar.name() + CertificateUtil.DELIMITER + "mp::next_valid_request_time", 0);
    }

    /* access modifiers changed from: protected */
    public b0 a(C0262b bVar, String str) throws MalformedURLException {
        return a(bVar, str, false);
    }

    /* access modifiers changed from: protected */
    public b0 a(C0262b bVar, String str, boolean z10) throws MalformedURLException {
        String str2;
        boolean z11;
        DomainMapping domain = this.f22611b.G().getDomain(bVar);
        String a10 = d.a(bVar);
        if (domain == null || MPUtility.isEmpty((CharSequence) domain.getUrl()) || z10) {
            str2 = a10;
            z11 = true;
        } else {
            str2 = domain.getUrl();
            z11 = a10.equals(str2);
        }
        b0 a11 = !z11 ? a(bVar, str, true) : null;
        boolean z12 = domain.isOverridesSubdirectory() && !z10;
        int i10 = a.f22615a[bVar.ordinal()];
        String str3 = "";
        if (i10 == 1) {
            if (!z12) {
                str3 = "/v4/";
            }
            Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").encodedAuthority(str2).path(str3 + this.f22614e + "/config").appendQueryParameter("av", MPUtility.getAppVersionName(this.f22610a)).appendQueryParameter("sv", BuildConfig.VERSION_NAME);
            if (this.f22611b.q() != null) {
                appendQueryParameter.appendQueryParameter("plan_id", this.f22611b.q());
                Integer s10 = this.f22611b.s();
                if (s10 != null) {
                    if (s10.intValue() <= 0 || s10.intValue() >= 1001) {
                        Logger.warning("Dataplan version of " + s10 + " is out of range and will not be used to fetch remote dataplan. Version must be between 1 and 1000.");
                    } else {
                        appendQueryParameter.appendQueryParameter("plan_version", this.f22611b.s().toString());
                    }
                }
            }
            return b0.a(appendQueryParameter.build().toString(), a11);
        } else if (i10 == 2) {
            if (!z12) {
                str3 = "/v2/";
            }
            return b0.a(new Uri.Builder().scheme("https").encodedAuthority(str2).path(str3 + this.f22614e + "/events").build().toString(), a11);
        } else if (i10 == 3) {
            if (!z12) {
                str3 = "/v1/identity/";
            }
            return b0.a(new Uri.Builder().scheme("https").encodedAuthority(str2).path(str3 + this.f22614e + "/alias").build().toString(), a11);
        } else if (i10 == 4) {
            if (!z12) {
                str3 = "/v1/";
            }
            return b0.a(new Uri.Builder().scheme("https").encodedAuthority(str2).path(str3 + str).build().toString(), a11);
        } else if (i10 != 5) {
            return null;
        } else {
            return b0.a(new Uri.Builder().scheme("https").encodedAuthority(str2).path("/v2/" + this.f22614e + "/audience?mpID=" + this.f22611b.E()).build().toString(), a11);
        }
    }
}
