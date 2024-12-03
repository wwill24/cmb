package androidx.core.view;

import android.content.ClipData;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.ContentInfo;
import androidx.annotation.NonNull;
import androidx.core.util.h;
import java.util.Objects;

public final class c {
    @NonNull

    /* renamed from: a  reason: collision with root package name */
    private final f f4793a;

    public static final class a {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final C0048c f4794a;

        public a(@NonNull ClipData clipData, int i10) {
            if (Build.VERSION.SDK_INT >= 31) {
                this.f4794a = new b(clipData, i10);
            } else {
                this.f4794a = new d(clipData, i10);
            }
        }

        @NonNull
        public c a() {
            return this.f4794a.build();
        }

        @NonNull
        public a b(Bundle bundle) {
            this.f4794a.setExtras(bundle);
            return this;
        }

        @NonNull
        public a c(int i10) {
            this.f4794a.b(i10);
            return this;
        }

        @NonNull
        public a d(Uri uri) {
            this.f4794a.a(uri);
            return this;
        }
    }

    private static final class b implements C0048c {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final ContentInfo.Builder f4795a;

        b(@NonNull ClipData clipData, int i10) {
            this.f4795a = new ContentInfo.Builder(clipData, i10);
        }

        public void a(Uri uri) {
            this.f4795a.setLinkUri(uri);
        }

        public void b(int i10) {
            this.f4795a.setFlags(i10);
        }

        @NonNull
        public c build() {
            return new c(new e(this.f4795a.build()));
        }

        public void setExtras(Bundle bundle) {
            this.f4795a.setExtras(bundle);
        }
    }

    /* renamed from: androidx.core.view.c$c  reason: collision with other inner class name */
    private interface C0048c {
        void a(Uri uri);

        void b(int i10);

        @NonNull
        c build();

        void setExtras(Bundle bundle);
    }

    private static final class d implements C0048c {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        ClipData f4796a;

        /* renamed from: b  reason: collision with root package name */
        int f4797b;

        /* renamed from: c  reason: collision with root package name */
        int f4798c;

        /* renamed from: d  reason: collision with root package name */
        Uri f4799d;

        /* renamed from: e  reason: collision with root package name */
        Bundle f4800e;

        d(@NonNull ClipData clipData, int i10) {
            this.f4796a = clipData;
            this.f4797b = i10;
        }

        public void a(Uri uri) {
            this.f4799d = uri;
        }

        public void b(int i10) {
            this.f4798c = i10;
        }

        @NonNull
        public c build() {
            return new c(new g(this));
        }

        public void setExtras(Bundle bundle) {
            this.f4800e = bundle;
        }
    }

    private static final class e implements f {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final ContentInfo f4801a;

        e(@NonNull ContentInfo contentInfo) {
            this.f4801a = (ContentInfo) h.g(contentInfo);
        }

        @NonNull
        public ContentInfo a() {
            return this.f4801a;
        }

        @NonNull
        public ClipData b() {
            return this.f4801a.getClip();
        }

        public int c() {
            return this.f4801a.getFlags();
        }

        public int getSource() {
            return this.f4801a.getSource();
        }

        @NonNull
        public String toString() {
            return "ContentInfoCompat{" + this.f4801a + "}";
        }
    }

    private interface f {
        ContentInfo a();

        @NonNull
        ClipData b();

        int c();

        int getSource();
    }

    private static final class g implements f {
        @NonNull

        /* renamed from: a  reason: collision with root package name */
        private final ClipData f4802a;

        /* renamed from: b  reason: collision with root package name */
        private final int f4803b;

        /* renamed from: c  reason: collision with root package name */
        private final int f4804c;

        /* renamed from: d  reason: collision with root package name */
        private final Uri f4805d;

        /* renamed from: e  reason: collision with root package name */
        private final Bundle f4806e;

        g(d dVar) {
            this.f4802a = (ClipData) h.g(dVar.f4796a);
            this.f4803b = h.c(dVar.f4797b, 0, 5, "source");
            this.f4804c = h.f(dVar.f4798c, 1);
            this.f4805d = dVar.f4799d;
            this.f4806e = dVar.f4800e;
        }

        public ContentInfo a() {
            return null;
        }

        @NonNull
        public ClipData b() {
            return this.f4802a;
        }

        public int c() {
            return this.f4804c;
        }

        public int getSource() {
            return this.f4803b;
        }

        @NonNull
        public String toString() {
            String str;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("ContentInfoCompat{clip=");
            sb2.append(this.f4802a.getDescription());
            sb2.append(", source=");
            sb2.append(c.e(this.f4803b));
            sb2.append(", flags=");
            sb2.append(c.a(this.f4804c));
            String str2 = "";
            if (this.f4805d == null) {
                str = str2;
            } else {
                str = ", hasLinkUri(" + this.f4805d.toString().length() + ")";
            }
            sb2.append(str);
            if (this.f4806e != null) {
                str2 = ", hasExtras";
            }
            sb2.append(str2);
            sb2.append("}");
            return sb2.toString();
        }
    }

    c(@NonNull f fVar) {
        this.f4793a = fVar;
    }

    @NonNull
    static String a(int i10) {
        return (i10 & 1) != 0 ? "FLAG_CONVERT_TO_PLAIN_TEXT" : String.valueOf(i10);
    }

    @NonNull
    static String e(int i10) {
        return i10 != 0 ? i10 != 1 ? i10 != 2 ? i10 != 3 ? i10 != 4 ? i10 != 5 ? String.valueOf(i10) : "SOURCE_PROCESS_TEXT" : "SOURCE_AUTOFILL" : "SOURCE_DRAG_AND_DROP" : "SOURCE_INPUT_METHOD" : "SOURCE_CLIPBOARD" : "SOURCE_APP";
    }

    @NonNull
    public static c g(@NonNull ContentInfo contentInfo) {
        return new c(new e(contentInfo));
    }

    @NonNull
    public ClipData b() {
        return this.f4793a.b();
    }

    public int c() {
        return this.f4793a.c();
    }

    public int d() {
        return this.f4793a.getSource();
    }

    @NonNull
    public ContentInfo f() {
        ContentInfo a10 = this.f4793a.a();
        Objects.requireNonNull(a10);
        ContentInfo contentInfo = a10;
        return a10;
    }

    @NonNull
    public String toString() {
        return this.f4793a.toString();
    }
}
