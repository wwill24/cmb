package com.mparticle.internal;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.os.Message;
import com.mparticle.MParticle;
import com.mparticle.b;
import com.mparticle.d0;
import com.mparticle.identity.AliasResponse;
import com.mparticle.internal.f;
import com.mparticle.internal.g;
import com.mparticle.internal.listeners.InternalListenerManager;
import com.mparticle.s;
import com.mparticle.segmentation.SegmentListener;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import org.json.JSONException;

public class o extends b {

    /* renamed from: d  reason: collision with root package name */
    private final Context f22563d;

    /* renamed from: e  reason: collision with root package name */
    d0 f22564e;

    /* renamed from: f  reason: collision with root package name */
    private final a f22565f;

    /* renamed from: g  reason: collision with root package name */
    private final j f22566g;

    /* renamed from: h  reason: collision with root package name */
    private b f22567h;

    /* renamed from: i  reason: collision with root package name */
    private d f22568i;

    /* renamed from: j  reason: collision with root package name */
    private final SharedPreferences f22569j;

    /* renamed from: k  reason: collision with root package name */
    private final m f22570k;

    /* renamed from: l  reason: collision with root package name */
    f f22571l;

    /* renamed from: m  reason: collision with root package name */
    volatile boolean f22572m = true;

    /* renamed from: n  reason: collision with root package name */
    String f22573n = "\"dt\":\"se\"";

    public o(Context context, Looper looper, b bVar, a aVar, j jVar, d0 d0Var, d dVar) {
        super(looper);
        this.f22567h = bVar;
        this.f22563d = context;
        this.f22565f = aVar;
        this.f22570k = new m(context);
        this.f22564e = d0Var;
        SharedPreferences sharedPreferences = context.getSharedPreferences("mParticlePrefs", 0);
        this.f22569j = sharedPreferences;
        this.f22566g = jVar;
        this.f22568i = dVar;
        try {
            a((f) new g(bVar, sharedPreferences, context));
        } catch (MalformedURLException unused) {
        } catch (g.b unused2) {
            Logger.error("Unable to process uploads, API key and/or API Secret are missing.");
        }
    }

    public void a(Message message) {
        try {
            this.f22564e.c();
            int i10 = message.what;
            if (i10 != 1) {
                if (i10 == 3) {
                    a(3);
                    b(true);
                    if (this.f22572m) {
                        d(true);
                        return;
                    }
                    return;
                } else if (i10 == 4) {
                    MParticle instance = MParticle.getInstance();
                    if (instance != null) {
                        instance.Internal().c().c();
                    }
                    this.f22571l.a(true);
                    return;
                } else if (i10 != 5) {
                    if (i10 == 6) {
                        this.f22567h.g();
                        return;
                    }
                    return;
                }
            }
            long R = this.f22567h.R();
            if (this.f22572m && (R > 0 || message.arg1 == 1)) {
                while (this.f22564e.e()) {
                    b(false);
                }
                if (d(false)) {
                    b(3);
                }
            }
            if (this.f22565f.j().isActive() && R > 0 && message.arg1 == 0) {
                a(1, R);
            }
        } catch (g.a unused) {
            Logger.error("Bad API request - is the correct API key and secret configured?");
        } catch (Exception e10) {
            Logger.verbose("UploadHandler Exception while handling message: " + e10.toString());
        } catch (VerifyError e11) {
            Logger.verbose("UploadHandler VerifyError while handling message" + e11.toString());
        }
    }

    /* access modifiers changed from: protected */
    public void b(boolean z10) throws Exception {
        String str = this.f22565f.j().mSessionID;
        if (MPUtility.getRemainingHeapInBytes() >= 204800) {
            MParticle instance = MParticle.getInstance();
            if (instance != null) {
                boolean z11 = instance.Internal().b().z();
                try {
                    this.f22564e.a();
                    if (z10 && !z11) {
                        this.f22564e.b(str);
                    } else if (z10) {
                        this.f22564e.a(this.f22567h, this.f22566g.b(), str);
                    } else {
                        this.f22564e.a(this.f22567h, this.f22566g.b(), str, z11);
                    }
                } catch (Exception e10) {
                    Logger.verbose("Error preparing batch upload in mParticle DB: " + e10.getMessage());
                }
            }
        } else {
            throw new Exception("Low remaining heap space, deferring uploads.");
        }
    }

    public void c(boolean z10) {
        try {
            MParticle instance = MParticle.getInstance();
            if (instance != null && !this.f22572m && z10 && this.f22567h.W()) {
                instance.Messaging().enablePushNotifications(this.f22567h.N());
            }
        } catch (Exception unused) {
        }
        this.f22572m = z10;
    }

    public boolean c(int i10) {
        return i10 != 429 && (200 == i10 || 202 == i10 || (i10 >= 400 && i10 < 500));
    }

    /* access modifiers changed from: protected */
    public boolean d(boolean z10) {
        this.f22564e.b();
        boolean z11 = false;
        try {
            List<d0.d> d10 = this.f22564e.d();
            if (d10.size() > 0) {
                this.f22571l.b();
            }
            boolean z12 = this.f22567h.z();
            for (d0.d next : d10) {
                if (!z10 || z12) {
                    if (!z10 && !z11 && next.b().contains(this.f22573n)) {
                        z11 = true;
                    }
                    String b10 = next.b();
                    InternalListenerManager.getListener().onCompositeObjects(next, b10);
                    if (next.c()) {
                        a(next.a(), b10);
                    } else {
                        b(next.a(), b10);
                    }
                } else {
                    this.f22564e.a(next.a());
                }
            }
        } catch (g.d unused) {
        } catch (SSLHandshakeException unused2) {
            Logger.debug("SSL handshake failed while preparing uploads - possible MITM attack detected.");
        } catch (g.a unused3) {
            Logger.error("Bad API request - is the correct API key and secret configured?");
        } catch (Exception e10) {
            Logger.error(e10, "Error processing batch uploads in mParticle DB.");
        }
        return z11;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0045  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(int r8, java.lang.String r9) throws java.io.IOException, com.mparticle.internal.g.d {
        /*
            r7 = this;
            r0 = 0
            r1 = 1
            r2 = -1
            com.mparticle.internal.f r3 = r7.f22571l     // Catch:{ c -> 0x0028, AssertionError -> 0x000a }
            int r2 = r3.a((java.lang.String) r9)     // Catch:{ c -> 0x0028, AssertionError -> 0x000a }
            goto L_0x0032
        L_0x000a:
            r3 = move-exception
            java.lang.String[] r4 = new java.lang.String[r1]
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "API request failed "
            r5.append(r6)
            java.lang.String r3 = r3.toString()
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            r4[r0] = r3
            com.mparticle.internal.Logger.error(r4)
            goto L_0x0031
        L_0x0028:
            java.lang.String r0 = "This device is being sampled."
            java.lang.String[] r0 = new java.lang.String[]{r0}
            com.mparticle.internal.Logger.debug(r0)
        L_0x0031:
            r0 = r1
        L_0x0032:
            if (r0 != 0) goto L_0x0045
            boolean r0 = r7.c((int) r2)
            if (r0 == 0) goto L_0x003b
            goto L_0x0045
        L_0x003b:
            java.lang.String r8 = "Upload failed and will be retried."
            java.lang.String[] r8 = new java.lang.String[]{r8}
            com.mparticle.internal.Logger.warning(r8)
            goto L_0x004d
        L_0x0045:
            r7.a((java.lang.String) r9)
            com.mparticle.d0 r9 = r7.f22564e
            r9.a((int) r8)
        L_0x004d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mparticle.internal.o.b(int, java.lang.String):void");
    }

    /* access modifiers changed from: protected */
    public void b(int i10) {
        sendEmptyMessage(i10);
    }

    /* access modifiers changed from: package-private */
    public void a(int i10, String str) throws IOException, g.d {
        boolean z10;
        f.a aVar = new f.a(-1);
        boolean z11 = false;
        try {
            aVar = this.f22571l.b(str);
        } catch (JSONException unused) {
            aVar.a("Unable to deserialize Alias Request");
            Logger.error(aVar.a());
        } catch (g.c unused2) {
            aVar.a("This device is being sampled.");
            Logger.debug(aVar.a());
            z10 = true;
        }
        z10 = false;
        if (z10 || c(aVar.b())) {
            z11 = true;
        }
        if (z11) {
            this.f22564e.a(i10);
        } else {
            Logger.warning("Alias Request will be retried");
        }
        try {
            s sVar = new s(str);
            InternalListenerManager.getListener().onAliasRequestFinished(new AliasResponse(aVar, sVar.a(), sVar.b(), !z11));
        } catch (JSONException unused3) {
            Logger.warning("Unable to deserialize AliasRequest, SdkListener.onAliasRequestFinished will not be called");
        }
    }

    /* access modifiers changed from: package-private */
    public void a(f fVar) {
        this.f22571l = fVar;
    }

    public void a(long j10, String str, SegmentListener segmentListener) {
        new n(this.f22570k, this.f22571l).a(j10, str, segmentListener);
    }

    /* access modifiers changed from: protected */
    public void a(int i10, long j10) {
        sendEmptyMessageDelayed(i10, j10);
    }

    /* access modifiers changed from: protected */
    public void a(String str) {
        MParticle instance;
        if (this.f22568i == null && (instance = MParticle.getInstance()) != null) {
            this.f22568i = instance.Internal().c();
        }
        d dVar = this.f22568i;
        if (dVar != null) {
            dVar.logBatch(str);
        } else {
            Logger.warning("Unable to forward batch to Kits, KitManager has been closed");
        }
    }
}
