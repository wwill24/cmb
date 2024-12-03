package n5;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.feature.chat.features.ChatMediaType;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.MessageBase;
import com.coffeemeetsbagel.models.StickerNetwork;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.stickers.StickerRepository;
import j8.c;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;
import k7.e;
import k7.f;
import k7.g;
import t8.l;

public class n1 implements f, e {

    /* renamed from: a  reason: collision with root package name */
    private final StickerRepository f16588a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Activity f16589b;

    /* renamed from: c  reason: collision with root package name */
    private j8.c f16590c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Bagel f16591d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public k7.b f16592e;

    /* renamed from: f  reason: collision with root package name */
    g f16593f;

    /* renamed from: g  reason: collision with root package name */
    private l f16594g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f16595h = false;

    /* renamed from: i  reason: collision with root package name */
    private List<StickerNetwork> f16596i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    private tj.b f16597j;

    class a implements c.a {

        /* renamed from: n5.n1$a$a  reason: collision with other inner class name */
        class C0177a implements k7.a {
            C0177a() {
            }

            public void h0(String str) {
                g gVar = n1.this.f16593f;
                if (gVar != null) {
                    gVar.W();
                }
            }

            public void o(MessageBase messageBase) {
                g gVar = n1.this.f16593f;
                if (gVar != null) {
                    gVar.w0();
                }
            }

            public void u(MessageBase messageBase) {
            }

            public void v(MessageBase messageBase) {
                g gVar = n1.this.f16593f;
                if (gVar != null) {
                    gVar.c0();
                }
            }
        }

        a() {
        }

        public void a(String str) {
            n1.this.f16592e.m(str, n1.this.f16591d, new C0177a(), ChatMediaType.IMAGE);
        }

        public void onFailure() {
            g gVar = n1.this.f16593f;
            if (gVar != null) {
                gVar.Y(R.string.media_upload_error);
            }
        }
    }

    class b implements k7.a {
        b() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c() {
            g gVar = n1.this.f16593f;
            if (gVar != null) {
                gVar.I();
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d() {
            g gVar = n1.this.f16593f;
            if (gVar != null) {
                gVar.s0();
            }
        }

        public void h0(String str) {
            n1.this.f16589b.runOnUiThread(new o1(this));
        }

        public void o(MessageBase messageBase) {
            n1.this.f16589b.runOnUiThread(new p1(this));
        }

        public void u(MessageBase messageBase) {
        }

        public void v(MessageBase messageBase) {
            g gVar = n1.this.f16593f;
            if (gVar != null) {
                gVar.I();
            }
        }
    }

    private static class c extends AsyncTask<Void, Void, String> {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<Activity> f16601a;

        /* renamed from: b  reason: collision with root package name */
        private final WeakReference<n1> f16602b;

        /* renamed from: c  reason: collision with root package name */
        private final Uri f16603c;

        /* renamed from: d  reason: collision with root package name */
        private final l f16604d;

        /* renamed from: e  reason: collision with root package name */
        private final j8.c f16605e;

        /* renamed from: f  reason: collision with root package name */
        private final g f16606f;

        c(WeakReference<Activity> weakReference, WeakReference<n1> weakReference2, Uri uri, l lVar, j8.c cVar, g gVar) {
            this.f16601a = weakReference;
            this.f16602b = weakReference2;
            this.f16603c = uri;
            this.f16604d = lVar;
            this.f16605e = cVar;
            this.f16606f = gVar;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x006d A[SYNTHETIC, Splitter:B:25:0x006d] */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0079 A[SYNTHETIC, Splitter:B:32:0x0079] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(java.lang.Void... r8) {
            /*
                r7 = this;
                r8 = 0
                java.lang.ref.WeakReference<android.app.Activity> r0 = r7.f16601a     // Catch:{ Exception -> 0x0051, all -> 0x004c }
                java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x0051, all -> 0x004c }
                android.app.Activity r0 = (android.app.Activity) r0     // Catch:{ Exception -> 0x0051, all -> 0x004c }
                android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ Exception -> 0x0051, all -> 0x004c }
                android.net.Uri r1 = r7.f16603c     // Catch:{ Exception -> 0x0051, all -> 0x004c }
                java.io.InputStream r0 = r0.openInputStream(r1)     // Catch:{ Exception -> 0x0051, all -> 0x004c }
                android.graphics.Bitmap r1 = android.graphics.BitmapFactory.decodeStream(r0)     // Catch:{ Exception -> 0x004a }
                int r2 = r1.getHeight()     // Catch:{ Exception -> 0x004a }
                r3 = 1080(0x438, float:1.513E-42)
                if (r2 > r3) goto L_0x0025
                int r2 = r1.getWidth()     // Catch:{ Exception -> 0x004a }
                if (r2 <= r3) goto L_0x0029
            L_0x0025:
                android.graphics.Bitmap r1 = lc.f.b(r1)     // Catch:{ Exception -> 0x004a }
            L_0x0029:
                t8.l r2 = r7.f16604d     // Catch:{ Exception -> 0x004a }
                java.lang.ref.WeakReference<android.app.Activity> r3 = r7.f16601a     // Catch:{ Exception -> 0x004a }
                java.lang.Object r3 = r3.get()     // Catch:{ Exception -> 0x004a }
                android.app.Activity r3 = (android.app.Activity) r3     // Catch:{ Exception -> 0x004a }
                android.net.Uri r4 = r7.f16603c     // Catch:{ Exception -> 0x004a }
                j8.c r5 = r7.f16605e     // Catch:{ Exception -> 0x004a }
                java.lang.String r5 = r5.a()     // Catch:{ Exception -> 0x004a }
                java.lang.String r8 = r2.g(r1, r3, r4, r5)     // Catch:{ Exception -> 0x004a }
                if (r0 == 0) goto L_0x0049
                r0.close()     // Catch:{ IOException -> 0x0045 }
                goto L_0x0049
            L_0x0045:
                r0 = move-exception
                fa.a.i(r0)
            L_0x0049:
                return r8
            L_0x004a:
                r1 = move-exception
                goto L_0x0053
            L_0x004c:
                r0 = move-exception
                r6 = r0
                r0 = r8
                r8 = r6
                goto L_0x0077
            L_0x0051:
                r1 = move-exception
                r0 = r8
            L_0x0053:
                java.lang.String r2 = "ChatPresenter"
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0076 }
                r3.<init>()     // Catch:{ all -> 0x0076 }
                java.lang.String r4 = "Failed to upload image: "
                r3.append(r4)     // Catch:{ all -> 0x0076 }
                android.net.Uri r4 = r7.f16603c     // Catch:{ all -> 0x0076 }
                r3.append(r4)     // Catch:{ all -> 0x0076 }
                java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0076 }
                fa.a.g(r2, r3, r1)     // Catch:{ all -> 0x0076 }
                if (r0 == 0) goto L_0x0075
                r0.close()     // Catch:{ IOException -> 0x0071 }
                goto L_0x0075
            L_0x0071:
                r0 = move-exception
                fa.a.i(r0)
            L_0x0075:
                return r8
            L_0x0076:
                r8 = move-exception
            L_0x0077:
                if (r0 == 0) goto L_0x0081
                r0.close()     // Catch:{ IOException -> 0x007d }
                goto L_0x0081
            L_0x007d:
                r0 = move-exception
                fa.a.i(r0)
            L_0x0081:
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: n5.n1.c.doInBackground(java.lang.Void[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            g gVar = this.f16606f;
            if (gVar == null) {
                return;
            }
            if (str == null) {
                gVar.w0();
            } else {
                this.f16602b.get().v(str);
            }
        }
    }

    n1(Activity activity, g gVar, j8.c cVar, k7.b bVar, Bagel bagel, l lVar, StickerRepository stickerRepository) {
        this.f16589b = activity;
        this.f16593f = gVar;
        this.f16590c = cVar;
        this.f16592e = bVar;
        this.f16591d = bagel;
        this.f16594g = lVar;
        this.f16588a = stickerRepository;
    }

    private boolean q() {
        return this.f16591d.isBlocked() || this.f16591d.isPastDecouplingDate() || this.f16591d.isPairBlocked();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r(boolean z10) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("pair is typing ");
        sb2.append(z10);
        if (z10 && !this.f16595h && !q()) {
            this.f16593f.k0();
        } else if (this.f16595h && !z10) {
            this.f16593f.X();
        }
        this.f16595h = z10;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s(List list) throws Exception {
        this.f16596i = list;
        g gVar = this.f16593f;
        if (gVar != null) {
            gVar.r();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t(Throwable th2) throws Exception {
        g gVar = this.f16593f;
        if (gVar != null) {
            gVar.r();
        }
        fa.a.g("ChatPresenter", "", th2);
    }

    /* access modifiers changed from: private */
    public void v(String str) {
        this.f16590c.b(str, this.f16591d.getCoupleId(), new a());
    }

    public void a() {
        this.f16592e.e(false, this.f16591d);
    }

    public void b(Intent intent) {
        Uri parse = Uri.parse(intent.getStringExtra(Extra.IMAGE_URI));
        if (parse.getAuthority() != null) {
            new c(new WeakReference(this.f16589b), new WeakReference(this), parse, this.f16594g, this.f16590c, this.f16593f).execute(new Void[0]);
        }
    }

    public void c() {
        if (!q()) {
            this.f16592e.e(true, this.f16591d);
        }
    }

    public void d(g gVar) {
        this.f16593f = gVar;
    }

    public void e(Bagel bagel) {
        this.f16591d = bagel;
    }

    public void f() {
        if (this.f16596i.size() == 0) {
            this.f16593f.G();
        } else {
            this.f16593f.N(this.f16596i);
        }
    }

    public void g(StickerNetwork stickerNetwork) {
        this.f16592e.m(stickerNetwork.getImageUrl(), this.f16591d, new b(), ChatMediaType.STICKER);
    }

    public void h(boolean z10) {
        u(z10);
    }

    public void l() {
    }

    public void start() {
        this.f16592e.i(this);
        this.f16597j = this.f16588a.h().E(sj.a.a()).b(new l1(this), new m1(this));
    }

    public void stop() {
        this.f16593f = null;
        this.f16592e.j(this);
        this.f16597j.dispose();
    }

    public void u(boolean z10) {
        this.f16589b.runOnUiThread(new k1(this, z10));
    }
}
