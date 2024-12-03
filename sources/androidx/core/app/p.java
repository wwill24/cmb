package androidx.core.app;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.annotation.NonNull;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;

public class p {

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        final Bundle f4473a;

        /* renamed from: b  reason: collision with root package name */
        private IconCompat f4474b;

        /* renamed from: c  reason: collision with root package name */
        private final o0[] f4475c;

        /* renamed from: d  reason: collision with root package name */
        private final o0[] f4476d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f4477e;

        /* renamed from: f  reason: collision with root package name */
        boolean f4478f;

        /* renamed from: g  reason: collision with root package name */
        private final int f4479g;

        /* renamed from: h  reason: collision with root package name */
        private final boolean f4480h;
        @Deprecated

        /* renamed from: i  reason: collision with root package name */
        public int f4481i;

        /* renamed from: j  reason: collision with root package name */
        public CharSequence f4482j;

        /* renamed from: k  reason: collision with root package name */
        public PendingIntent f4483k;

        /* renamed from: l  reason: collision with root package name */
        private boolean f4484l;

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public a(int i10, CharSequence charSequence, PendingIntent pendingIntent) {
            this(i10 != 0 ? IconCompat.h((Resources) null, "", i10) : null, charSequence, pendingIntent);
        }

        public PendingIntent a() {
            return this.f4483k;
        }

        public boolean b() {
            return this.f4477e;
        }

        @NonNull
        public Bundle c() {
            return this.f4473a;
        }

        public IconCompat d() {
            int i10;
            if (this.f4474b == null && (i10 = this.f4481i) != 0) {
                this.f4474b = IconCompat.h((Resources) null, "", i10);
            }
            return this.f4474b;
        }

        public o0[] e() {
            return this.f4475c;
        }

        public int f() {
            return this.f4479g;
        }

        public boolean g() {
            return this.f4478f;
        }

        public CharSequence h() {
            return this.f4482j;
        }

        public boolean i() {
            return this.f4484l;
        }

        public boolean j() {
            return this.f4480h;
        }

        public a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent) {
            this(iconCompat, charSequence, pendingIntent, new Bundle(), (o0[]) null, (o0[]) null, true, 0, true, false, false);
        }

        a(IconCompat iconCompat, CharSequence charSequence, PendingIntent pendingIntent, Bundle bundle, o0[] o0VarArr, o0[] o0VarArr2, boolean z10, int i10, boolean z11, boolean z12, boolean z13) {
            this.f4478f = true;
            this.f4474b = iconCompat;
            if (iconCompat != null && iconCompat.l() == 2) {
                this.f4481i = iconCompat.j();
            }
            this.f4482j = e.d(charSequence);
            this.f4483k = pendingIntent;
            this.f4473a = bundle == null ? new Bundle() : bundle;
            this.f4475c = o0VarArr;
            this.f4476d = o0VarArr2;
            this.f4477e = z10;
            this.f4479g = i10;
            this.f4478f = z11;
            this.f4480h = z12;
            this.f4484l = z13;
        }
    }

    public static class b extends f {

        /* renamed from: e  reason: collision with root package name */
        private IconCompat f4485e;

        /* renamed from: f  reason: collision with root package name */
        private IconCompat f4486f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f4487g;

        /* renamed from: h  reason: collision with root package name */
        private CharSequence f4488h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f4489i;

        private static class a {
            static void a(Notification.BigPictureStyle bigPictureStyle, Bitmap bitmap) {
                bigPictureStyle.bigLargeIcon(bitmap);
            }

            static void b(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                bigPictureStyle.setSummaryText(charSequence);
            }
        }

        /* renamed from: androidx.core.app.p$b$b  reason: collision with other inner class name */
        private static class C0034b {
            static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                bigPictureStyle.bigLargeIcon(icon);
            }
        }

        private static class c {
            static void a(Notification.BigPictureStyle bigPictureStyle, Icon icon) {
                Notification.BigPictureStyle unused = bigPictureStyle.bigPicture(icon);
            }

            static void b(Notification.BigPictureStyle bigPictureStyle, CharSequence charSequence) {
                Notification.BigPictureStyle unused = bigPictureStyle.setContentDescription(charSequence);
            }

            static void c(Notification.BigPictureStyle bigPictureStyle, boolean z10) {
                Notification.BigPictureStyle unused = bigPictureStyle.showBigPictureWhenCollapsed(z10);
            }
        }

        public void b(o oVar) {
            Context context;
            int i10 = Build.VERSION.SDK_INT;
            Notification.BigPictureStyle bigContentTitle = new Notification.BigPictureStyle(oVar.a()).setBigContentTitle(this.f4518b);
            IconCompat iconCompat = this.f4485e;
            Context context2 = null;
            if (iconCompat != null) {
                if (i10 >= 31) {
                    if (oVar instanceof g0) {
                        context = ((g0) oVar).f();
                    } else {
                        context = null;
                    }
                    c.a(bigContentTitle, this.f4485e.r(context));
                } else if (iconCompat.l() == 1) {
                    bigContentTitle = bigContentTitle.bigPicture(this.f4485e.i());
                }
            }
            if (this.f4487g) {
                if (this.f4486f == null) {
                    a.a(bigContentTitle, (Bitmap) null);
                } else {
                    if (oVar instanceof g0) {
                        context2 = ((g0) oVar).f();
                    }
                    C0034b.a(bigContentTitle, this.f4486f.r(context2));
                }
            }
            if (this.f4520d) {
                a.b(bigContentTitle, this.f4519c);
            }
            if (i10 >= 31) {
                c.c(bigContentTitle, this.f4489i);
                c.b(bigContentTitle, this.f4488h);
            }
        }

        /* access modifiers changed from: protected */
        @NonNull
        public String c() {
            return "androidx.core.app.NotificationCompat$BigPictureStyle";
        }

        @NonNull
        public b h(Bitmap bitmap) {
            IconCompat iconCompat;
            if (bitmap == null) {
                iconCompat = null;
            } else {
                iconCompat = IconCompat.e(bitmap);
            }
            this.f4486f = iconCompat;
            this.f4487g = true;
            return this;
        }

        @NonNull
        public b i(Bitmap bitmap) {
            this.f4485e = bitmap == null ? null : IconCompat.e(bitmap);
            return this;
        }

        @NonNull
        public b j(CharSequence charSequence) {
            this.f4518b = e.d(charSequence);
            return this;
        }

        @NonNull
        public b k(CharSequence charSequence) {
            this.f4519c = e.d(charSequence);
            this.f4520d = true;
            return this;
        }
    }

    public static class c extends f {

        /* renamed from: e  reason: collision with root package name */
        private CharSequence f4490e;

        public void a(@NonNull Bundle bundle) {
            super.a(bundle);
        }

        public void b(o oVar) {
            Notification.BigTextStyle bigText = new Notification.BigTextStyle(oVar.a()).setBigContentTitle(this.f4518b).bigText(this.f4490e);
            if (this.f4520d) {
                bigText.setSummaryText(this.f4519c);
            }
        }

        /* access modifiers changed from: protected */
        @NonNull
        public String c() {
            return "androidx.core.app.NotificationCompat$BigTextStyle";
        }

        @NonNull
        public c h(CharSequence charSequence) {
            this.f4490e = e.d(charSequence);
            return this;
        }
    }

    public static final class d {
        public static Notification.BubbleMetadata a(d dVar) {
            return null;
        }
    }

    public static abstract class f {

        /* renamed from: a  reason: collision with root package name */
        protected e f4517a;

        /* renamed from: b  reason: collision with root package name */
        CharSequence f4518b;

        /* renamed from: c  reason: collision with root package name */
        CharSequence f4519c;

        /* renamed from: d  reason: collision with root package name */
        boolean f4520d = false;

        public void a(@NonNull Bundle bundle) {
            if (this.f4520d) {
                bundle.putCharSequence("android.summaryText", this.f4519c);
            }
            CharSequence charSequence = this.f4518b;
            if (charSequence != null) {
                bundle.putCharSequence("android.title.big", charSequence);
            }
            String c10 = c();
            if (c10 != null) {
                bundle.putString("androidx.core.app.extra.COMPAT_TEMPLATE", c10);
            }
        }

        public abstract void b(o oVar);

        /* access modifiers changed from: protected */
        public abstract String c();

        public RemoteViews d(o oVar) {
            return null;
        }

        public RemoteViews e(o oVar) {
            return null;
        }

        public RemoteViews f(o oVar) {
            return null;
        }

        public void g(e eVar) {
            if (this.f4517a != eVar) {
                this.f4517a = eVar;
                if (eVar != null) {
                    eVar.z(this);
                }
            }
        }
    }

    public static Bundle a(@NonNull Notification notification) {
        return notification.extras;
    }

    public static class e {
        boolean A;
        boolean B;
        String C;
        Bundle D;
        int E;
        int F;
        Notification G;
        RemoteViews H;
        RemoteViews I;
        RemoteViews J;
        String K;
        int L;
        String M;
        long N;
        int O;
        int P;
        boolean Q;
        Notification R;
        boolean S;
        Icon T;
        @Deprecated
        public ArrayList<String> U;

        /* renamed from: a  reason: collision with root package name */
        public Context f4491a;

        /* renamed from: b  reason: collision with root package name */
        public ArrayList<a> f4492b;
        @NonNull

        /* renamed from: c  reason: collision with root package name */
        public ArrayList<m0> f4493c;

        /* renamed from: d  reason: collision with root package name */
        ArrayList<a> f4494d;

        /* renamed from: e  reason: collision with root package name */
        CharSequence f4495e;

        /* renamed from: f  reason: collision with root package name */
        CharSequence f4496f;

        /* renamed from: g  reason: collision with root package name */
        PendingIntent f4497g;

        /* renamed from: h  reason: collision with root package name */
        PendingIntent f4498h;

        /* renamed from: i  reason: collision with root package name */
        RemoteViews f4499i;

        /* renamed from: j  reason: collision with root package name */
        Bitmap f4500j;

        /* renamed from: k  reason: collision with root package name */
        CharSequence f4501k;

        /* renamed from: l  reason: collision with root package name */
        int f4502l;

        /* renamed from: m  reason: collision with root package name */
        int f4503m;

        /* renamed from: n  reason: collision with root package name */
        boolean f4504n;

        /* renamed from: o  reason: collision with root package name */
        boolean f4505o;

        /* renamed from: p  reason: collision with root package name */
        f f4506p;

        /* renamed from: q  reason: collision with root package name */
        CharSequence f4507q;

        /* renamed from: r  reason: collision with root package name */
        CharSequence f4508r;

        /* renamed from: s  reason: collision with root package name */
        CharSequence[] f4509s;

        /* renamed from: t  reason: collision with root package name */
        int f4510t;

        /* renamed from: u  reason: collision with root package name */
        int f4511u;

        /* renamed from: v  reason: collision with root package name */
        boolean f4512v;

        /* renamed from: w  reason: collision with root package name */
        String f4513w;

        /* renamed from: x  reason: collision with root package name */
        boolean f4514x;

        /* renamed from: y  reason: collision with root package name */
        String f4515y;

        /* renamed from: z  reason: collision with root package name */
        boolean f4516z;

        public e(@NonNull Context context, @NonNull String str) {
            this.f4492b = new ArrayList<>();
            this.f4493c = new ArrayList<>();
            this.f4494d = new ArrayList<>();
            this.f4504n = true;
            this.f4516z = false;
            this.E = 0;
            this.F = 0;
            this.L = 0;
            this.O = 0;
            this.P = 0;
            Notification notification = new Notification();
            this.R = notification;
            this.f4491a = context;
            this.K = str;
            notification.when = System.currentTimeMillis();
            this.R.audioStreamType = -1;
            this.f4503m = 0;
            this.U = new ArrayList<>();
            this.Q = true;
        }

        protected static CharSequence d(CharSequence charSequence) {
            if (charSequence != null && charSequence.length() > 5120) {
                return charSequence.subSequence(0, 5120);
            }
            return charSequence;
        }

        private Bitmap e(Bitmap bitmap) {
            if (bitmap == null || Build.VERSION.SDK_INT >= 27) {
                return bitmap;
            }
            Resources resources = this.f4491a.getResources();
            int dimensionPixelSize = resources.getDimensionPixelSize(t0.b.compat_notification_large_icon_max_width);
            int dimensionPixelSize2 = resources.getDimensionPixelSize(t0.b.compat_notification_large_icon_max_height);
            if (bitmap.getWidth() <= dimensionPixelSize && bitmap.getHeight() <= dimensionPixelSize2) {
                return bitmap;
            }
            double min = Math.min(((double) dimensionPixelSize) / ((double) Math.max(1, bitmap.getWidth())), ((double) dimensionPixelSize2) / ((double) Math.max(1, bitmap.getHeight())));
            return Bitmap.createScaledBitmap(bitmap, (int) Math.ceil(((double) bitmap.getWidth()) * min), (int) Math.ceil(((double) bitmap.getHeight()) * min), true);
        }

        private void p(int i10, boolean z10) {
            if (z10) {
                Notification notification = this.R;
                notification.flags = i10 | notification.flags;
                return;
            }
            Notification notification2 = this.R;
            notification2.flags = (~i10) & notification2.flags;
        }

        @NonNull
        public e A(CharSequence charSequence) {
            this.f4507q = d(charSequence);
            return this;
        }

        @NonNull
        public e B(CharSequence charSequence) {
            this.R.tickerText = d(charSequence);
            return this;
        }

        @NonNull
        public e C(long[] jArr) {
            this.R.vibrate = jArr;
            return this;
        }

        @NonNull
        public e D(int i10) {
            this.F = i10;
            return this;
        }

        @NonNull
        public e E(long j10) {
            this.R.when = j10;
            return this;
        }

        @NonNull
        public e a(int i10, CharSequence charSequence, PendingIntent pendingIntent) {
            this.f4492b.add(new a(i10, charSequence, pendingIntent));
            return this;
        }

        @NonNull
        public Notification b() {
            return new g0(this).c();
        }

        @NonNull
        public Bundle c() {
            if (this.D == null) {
                this.D = new Bundle();
            }
            return this.D;
        }

        @NonNull
        public e f(boolean z10) {
            p(16, z10);
            return this;
        }

        @NonNull
        public e g(int i10) {
            this.L = i10;
            return this;
        }

        @NonNull
        public e h(@NonNull String str) {
            this.K = str;
            return this;
        }

        @NonNull
        public e i(int i10) {
            this.E = i10;
            return this;
        }

        @NonNull
        public e j(boolean z10) {
            this.A = z10;
            this.B = true;
            return this;
        }

        @NonNull
        public e k(PendingIntent pendingIntent) {
            this.f4497g = pendingIntent;
            return this;
        }

        @NonNull
        public e l(CharSequence charSequence) {
            this.f4496f = d(charSequence);
            return this;
        }

        @NonNull
        public e m(CharSequence charSequence) {
            this.f4495e = d(charSequence);
            return this;
        }

        @NonNull
        public e n(int i10) {
            Notification notification = this.R;
            notification.defaults = i10;
            if ((i10 & 4) != 0) {
                notification.flags |= 1;
            }
            return this;
        }

        @NonNull
        public e o(PendingIntent pendingIntent) {
            this.R.deleteIntent = pendingIntent;
            return this;
        }

        @NonNull
        public e q(Bitmap bitmap) {
            this.f4500j = e(bitmap);
            return this;
        }

        @NonNull
        public e r(int i10, int i11, int i12) {
            int i13;
            Notification notification = this.R;
            notification.ledARGB = i10;
            notification.ledOnMS = i11;
            notification.ledOffMS = i12;
            if (i11 == 0 || i12 == 0) {
                i13 = 0;
            } else {
                i13 = 1;
            }
            notification.flags = i13 | (notification.flags & -2);
            return this;
        }

        @NonNull
        public e s(boolean z10) {
            this.f4516z = z10;
            return this;
        }

        @NonNull
        public e t(int i10) {
            this.f4502l = i10;
            return this;
        }

        @NonNull
        public e u(boolean z10) {
            p(8, z10);
            return this;
        }

        @NonNull
        public e v(int i10) {
            this.f4503m = i10;
            return this;
        }

        @NonNull
        public e w(boolean z10) {
            this.f4504n = z10;
            return this;
        }

        @NonNull
        public e x(int i10) {
            this.R.icon = i10;
            return this;
        }

        @NonNull
        public e y(Uri uri) {
            Notification notification = this.R;
            notification.sound = uri;
            notification.audioStreamType = -1;
            notification.audioAttributes = new AudioAttributes.Builder().setContentType(4).setUsage(5).build();
            return this;
        }

        @NonNull
        public e z(f fVar) {
            if (this.f4506p != fVar) {
                this.f4506p = fVar;
                if (fVar != null) {
                    fVar.g(this);
                }
            }
            return this;
        }

        @Deprecated
        public e(@NonNull Context context) {
            this(context, (String) null);
        }
    }
}
