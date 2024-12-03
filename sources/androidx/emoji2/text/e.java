package androidx.emoji2.text;

import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.annotation.NonNull;
import com.google.android.gms.common.api.a;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class e {

    /* renamed from: n  reason: collision with root package name */
    private static final Object f5417n = new Object();

    /* renamed from: o  reason: collision with root package name */
    private static final Object f5418o = new Object();

    /* renamed from: p  reason: collision with root package name */
    private static volatile e f5419p;
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final ReadWriteLock f5420a = new ReentrantReadWriteLock();
    @NonNull

    /* renamed from: b  reason: collision with root package name */
    private final Set<C0055e> f5421b;

    /* renamed from: c  reason: collision with root package name */
    private volatile int f5422c = 3;
    @NonNull

    /* renamed from: d  reason: collision with root package name */
    private final Handler f5423d;
    @NonNull

    /* renamed from: e  reason: collision with root package name */
    private final b f5424e;
    @NonNull

    /* renamed from: f  reason: collision with root package name */
    final g f5425f;

    /* renamed from: g  reason: collision with root package name */
    final boolean f5426g;

    /* renamed from: h  reason: collision with root package name */
    final boolean f5427h;

    /* renamed from: i  reason: collision with root package name */
    final int[] f5428i;

    /* renamed from: j  reason: collision with root package name */
    private final boolean f5429j;

    /* renamed from: k  reason: collision with root package name */
    private final int f5430k;

    /* renamed from: l  reason: collision with root package name */
    private final int f5431l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public final d f5432m;

    private static final class a extends b {

        /* renamed from: b  reason: collision with root package name */
        private volatile h f5433b;

        /* renamed from: c  reason: collision with root package name */
        private volatile m f5434c;

        /* renamed from: androidx.emoji2.text.e$a$a  reason: collision with other inner class name */
        class C0054a extends h {
            C0054a() {
            }

            public void a(Throwable th2) {
                a.this.f5436a.m(th2);
            }

            public void b(@NonNull m mVar) {
                a.this.d(mVar);
            }
        }

        a(e eVar) {
            super(eVar);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            try {
                this.f5436a.f5425f.a(new C0054a());
            } catch (Throwable th2) {
                this.f5436a.m(th2);
            }
        }

        /* access modifiers changed from: package-private */
        public CharSequence b(@NonNull CharSequence charSequence, int i10, int i11, int i12, boolean z10) {
            return this.f5433b.h(charSequence, i10, i11, i12, z10);
        }

        /* access modifiers changed from: package-private */
        public void c(@NonNull EditorInfo editorInfo) {
            editorInfo.extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", this.f5434c.e());
            editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", this.f5436a.f5426g);
        }

        /* access modifiers changed from: package-private */
        public void d(@NonNull m mVar) {
            if (mVar == null) {
                this.f5436a.m(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.f5434c = mVar;
            m mVar2 = this.f5434c;
            i iVar = new i();
            d a10 = this.f5436a.f5432m;
            e eVar = this.f5436a;
            this.f5433b = new h(mVar2, iVar, a10, eVar.f5427h, eVar.f5428i);
            this.f5436a.n();
        }
    }

    private static class b {

        /* renamed from: a  reason: collision with root package name */
        final e f5436a;

        b(e eVar) {
            this.f5436a = eVar;
        }

        /* access modifiers changed from: package-private */
        public void a() {
            throw null;
        }

        /* access modifiers changed from: package-private */
        public CharSequence b(@NonNull CharSequence charSequence, int i10, int i11, int i12, boolean z10) {
            throw null;
        }

        /* access modifiers changed from: package-private */
        public void c(@NonNull EditorInfo editorInfo) {
            throw null;
        }
    }

    public static abstract class c {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        final g f5437a;

        /* renamed from: b  reason: collision with root package name */
        boolean f5438b;

        /* renamed from: c  reason: collision with root package name */
        boolean f5439c;

        /* renamed from: d  reason: collision with root package name */
        int[] f5440d;

        /* renamed from: e  reason: collision with root package name */
        Set<C0055e> f5441e;

        /* renamed from: f  reason: collision with root package name */
        boolean f5442f;

        /* renamed from: g  reason: collision with root package name */
        int f5443g = -16711936;

        /* renamed from: h  reason: collision with root package name */
        int f5444h = 0;
        @NonNull

        /* renamed from: i  reason: collision with root package name */
        d f5445i = new d();

        protected c(@NonNull g gVar) {
            androidx.core.util.h.h(gVar, "metadataLoader cannot be null.");
            this.f5437a = gVar;
        }

        /* access modifiers changed from: protected */
        @NonNull
        public final g a() {
            return this.f5437a;
        }

        @NonNull
        public c b(int i10) {
            this.f5444h = i10;
            return this;
        }
    }

    public interface d {
        boolean a(@NonNull CharSequence charSequence, int i10, int i11, int i12);
    }

    /* renamed from: androidx.emoji2.text.e$e  reason: collision with other inner class name */
    public static abstract class C0055e {
        public void a(Throwable th2) {
        }

        public void b() {
        }
    }

    private static class f implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final List<C0055e> f5446a;

        /* renamed from: b  reason: collision with root package name */
        private final Throwable f5447b;

        /* renamed from: c  reason: collision with root package name */
        private final int f5448c;

        f(@NonNull C0055e eVar, int i10) {
            this(Arrays.asList(new C0055e[]{(C0055e) androidx.core.util.h.h(eVar, "initCallback cannot be null")}), i10, (Throwable) null);
        }

        public void run() {
            int size = this.f5446a.size();
            int i10 = 0;
            if (this.f5448c != 1) {
                while (i10 < size) {
                    this.f5446a.get(i10).a(this.f5447b);
                    i10++;
                }
                return;
            }
            while (i10 < size) {
                this.f5446a.get(i10).b();
                i10++;
            }
        }

        f(@NonNull Collection<C0055e> collection, int i10) {
            this(collection, i10, (Throwable) null);
        }

        f(@NonNull Collection<C0055e> collection, int i10, Throwable th2) {
            androidx.core.util.h.h(collection, "initCallbacks cannot be null");
            this.f5446a = new ArrayList(collection);
            this.f5448c = i10;
            this.f5447b = th2;
        }
    }

    public interface g {
        void a(@NonNull h hVar);
    }

    public static abstract class h {
        public abstract void a(Throwable th2);

        public abstract void b(@NonNull m mVar);
    }

    static class i {
        i() {
        }

        /* access modifiers changed from: package-private */
        public i a(@NonNull g gVar) {
            return new o(gVar);
        }
    }

    private e(@NonNull c cVar) {
        this.f5426g = cVar.f5438b;
        this.f5427h = cVar.f5439c;
        this.f5428i = cVar.f5440d;
        this.f5429j = cVar.f5442f;
        this.f5430k = cVar.f5443g;
        this.f5425f = cVar.f5437a;
        this.f5431l = cVar.f5444h;
        this.f5432m = cVar.f5445i;
        this.f5423d = new Handler(Looper.getMainLooper());
        androidx.collection.b bVar = new androidx.collection.b();
        this.f5421b = bVar;
        Set<C0055e> set = cVar.f5441e;
        if (set != null && !set.isEmpty()) {
            bVar.addAll(cVar.f5441e);
        }
        this.f5424e = new a(this);
        l();
    }

    @NonNull
    public static e b() {
        e eVar;
        boolean z10;
        synchronized (f5417n) {
            eVar = f5419p;
            if (eVar != null) {
                z10 = true;
            } else {
                z10 = false;
            }
            androidx.core.util.h.j(z10, "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
        }
        return eVar;
    }

    public static boolean e(@NonNull InputConnection inputConnection, @NonNull Editable editable, int i10, int i11, boolean z10) {
        return h.c(inputConnection, editable, i10, i11, z10);
    }

    public static boolean f(@NonNull Editable editable, int i10, @NonNull KeyEvent keyEvent) {
        return h.d(editable, i10, keyEvent);
    }

    @NonNull
    public static e g(@NonNull c cVar) {
        e eVar = f5419p;
        if (eVar == null) {
            synchronized (f5417n) {
                eVar = f5419p;
                if (eVar == null) {
                    eVar = new e(cVar);
                    f5419p = eVar;
                }
            }
        }
        return eVar;
    }

    public static boolean h() {
        return f5419p != null;
    }

    private boolean j() {
        return d() == 1;
    }

    /* JADX INFO: finally extract failed */
    private void l() {
        this.f5420a.writeLock().lock();
        try {
            if (this.f5431l == 0) {
                this.f5422c = 0;
            }
            this.f5420a.writeLock().unlock();
            if (d() == 0) {
                this.f5424e.a();
            }
        } catch (Throwable th2) {
            this.f5420a.writeLock().unlock();
            throw th2;
        }
    }

    public int c() {
        return this.f5430k;
    }

    public int d() {
        this.f5420a.readLock().lock();
        try {
            return this.f5422c;
        } finally {
            this.f5420a.readLock().unlock();
        }
    }

    public boolean i() {
        return this.f5429j;
    }

    public void k() {
        boolean z10 = true;
        if (this.f5431l != 1) {
            z10 = false;
        }
        androidx.core.util.h.j(z10, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (!j()) {
            this.f5420a.writeLock().lock();
            try {
                if (this.f5422c != 0) {
                    this.f5422c = 0;
                    this.f5420a.writeLock().unlock();
                    this.f5424e.a();
                }
            } finally {
                this.f5420a.writeLock().unlock();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public void m(Throwable th2) {
        ArrayList arrayList = new ArrayList();
        this.f5420a.writeLock().lock();
        try {
            this.f5422c = 2;
            arrayList.addAll(this.f5421b);
            this.f5421b.clear();
            this.f5420a.writeLock().unlock();
            this.f5423d.post(new f(arrayList, this.f5422c, th2));
        } catch (Throwable th3) {
            this.f5420a.writeLock().unlock();
            throw th3;
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    public void n() {
        ArrayList arrayList = new ArrayList();
        this.f5420a.writeLock().lock();
        try {
            this.f5422c = 1;
            arrayList.addAll(this.f5421b);
            this.f5421b.clear();
            this.f5420a.writeLock().unlock();
            this.f5423d.post(new f((Collection<C0055e>) arrayList, this.f5422c));
        } catch (Throwable th2) {
            this.f5420a.writeLock().unlock();
            throw th2;
        }
    }

    public CharSequence o(CharSequence charSequence) {
        int i10;
        if (charSequence == null) {
            i10 = 0;
        } else {
            i10 = charSequence.length();
        }
        return p(charSequence, 0, i10);
    }

    public CharSequence p(CharSequence charSequence, int i10, int i11) {
        return q(charSequence, i10, i11, a.e.API_PRIORITY_OTHER);
    }

    public CharSequence q(CharSequence charSequence, int i10, int i11, int i12) {
        return r(charSequence, i10, i11, i12, 0);
    }

    public CharSequence r(CharSequence charSequence, int i10, int i11, int i12, int i13) {
        boolean z10;
        boolean z11;
        boolean z12;
        boolean z13;
        androidx.core.util.h.j(j(), "Not initialized yet");
        androidx.core.util.h.e(i10, "start cannot be negative");
        androidx.core.util.h.e(i11, "end cannot be negative");
        androidx.core.util.h.e(i12, "maxEmojiCount cannot be negative");
        boolean z14 = false;
        if (i10 <= i11) {
            z10 = true;
        } else {
            z10 = false;
        }
        androidx.core.util.h.b(z10, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        if (i10 <= charSequence.length()) {
            z11 = true;
        } else {
            z11 = false;
        }
        androidx.core.util.h.b(z11, "start should be < than charSequence length");
        if (i11 <= charSequence.length()) {
            z12 = true;
        } else {
            z12 = false;
        }
        androidx.core.util.h.b(z12, "end should be < than charSequence length");
        if (charSequence.length() == 0 || i10 == i11) {
            return charSequence;
        }
        if (i13 != 1) {
            if (i13 != 2) {
                z14 = this.f5426g;
            }
            z13 = z14;
        } else {
            z13 = true;
        }
        return this.f5424e.b(charSequence, i10, i11, i12, z13);
    }

    public void s(@NonNull C0055e eVar) {
        androidx.core.util.h.h(eVar, "initCallback cannot be null");
        this.f5420a.writeLock().lock();
        try {
            if (this.f5422c != 1) {
                if (this.f5422c != 2) {
                    this.f5421b.add(eVar);
                }
            }
            this.f5423d.post(new f(eVar, this.f5422c));
        } finally {
            this.f5420a.writeLock().unlock();
        }
    }

    public void t(@NonNull C0055e eVar) {
        androidx.core.util.h.h(eVar, "initCallback cannot be null");
        this.f5420a.writeLock().lock();
        try {
            this.f5421b.remove(eVar);
        } finally {
            this.f5420a.writeLock().unlock();
        }
    }

    public void u(@NonNull EditorInfo editorInfo) {
        if (j() && editorInfo != null) {
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            this.f5424e.c(editorInfo);
        }
    }
}
