package android.support.v4.media;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.a;
import android.support.v4.media.b;

public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator<MediaDescriptionCompat> CREATOR = new a();

    /* renamed from: a  reason: collision with root package name */
    private final String f222a;

    /* renamed from: b  reason: collision with root package name */
    private final CharSequence f223b;

    /* renamed from: c  reason: collision with root package name */
    private final CharSequence f224c;

    /* renamed from: d  reason: collision with root package name */
    private final CharSequence f225d;

    /* renamed from: e  reason: collision with root package name */
    private final Bitmap f226e;

    /* renamed from: f  reason: collision with root package name */
    private final Uri f227f;

    /* renamed from: g  reason: collision with root package name */
    private final Bundle f228g;

    /* renamed from: h  reason: collision with root package name */
    private final Uri f229h;

    /* renamed from: j  reason: collision with root package name */
    private Object f230j;

    static class a implements Parcelable.Creator<MediaDescriptionCompat> {
        a() {
        }

        /* renamed from: a */
        public MediaDescriptionCompat createFromParcel(Parcel parcel) {
            return MediaDescriptionCompat.a(a.a(parcel));
        }

        /* renamed from: b */
        public MediaDescriptionCompat[] newArray(int i10) {
            return new MediaDescriptionCompat[i10];
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private String f231a;

        /* renamed from: b  reason: collision with root package name */
        private CharSequence f232b;

        /* renamed from: c  reason: collision with root package name */
        private CharSequence f233c;

        /* renamed from: d  reason: collision with root package name */
        private CharSequence f234d;

        /* renamed from: e  reason: collision with root package name */
        private Bitmap f235e;

        /* renamed from: f  reason: collision with root package name */
        private Uri f236f;

        /* renamed from: g  reason: collision with root package name */
        private Bundle f237g;

        /* renamed from: h  reason: collision with root package name */
        private Uri f238h;

        public MediaDescriptionCompat a() {
            return new MediaDescriptionCompat(this.f231a, this.f232b, this.f233c, this.f234d, this.f235e, this.f236f, this.f237g, this.f238h);
        }

        public b b(CharSequence charSequence) {
            this.f234d = charSequence;
            return this;
        }

        public b c(Bundle bundle) {
            this.f237g = bundle;
            return this;
        }

        public b d(Bitmap bitmap) {
            this.f235e = bitmap;
            return this;
        }

        public b e(Uri uri) {
            this.f236f = uri;
            return this;
        }

        public b f(String str) {
            this.f231a = str;
            return this;
        }

        public b g(Uri uri) {
            this.f238h = uri;
            return this;
        }

        public b h(CharSequence charSequence) {
            this.f233c = charSequence;
            return this;
        }

        public b i(CharSequence charSequence) {
            this.f232b = charSequence;
            return this;
        }
    }

    MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.f222a = str;
        this.f223b = charSequence;
        this.f224c = charSequence2;
        this.f225d = charSequence3;
        this.f226e = bitmap;
        this.f227f = uri;
        this.f228g = bundle;
        this.f229h = uri2;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0067  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.support.v4.media.MediaDescriptionCompat a(java.lang.Object r8) {
        /*
            r0 = 0
            if (r8 == 0) goto L_0x0074
            android.support.v4.media.MediaDescriptionCompat$b r1 = new android.support.v4.media.MediaDescriptionCompat$b
            r1.<init>()
            java.lang.String r2 = android.support.v4.media.a.f(r8)
            r1.f(r2)
            java.lang.CharSequence r2 = android.support.v4.media.a.h(r8)
            r1.i(r2)
            java.lang.CharSequence r2 = android.support.v4.media.a.g(r8)
            r1.h(r2)
            java.lang.CharSequence r2 = android.support.v4.media.a.b(r8)
            r1.b(r2)
            android.graphics.Bitmap r2 = android.support.v4.media.a.d(r8)
            r1.d(r2)
            android.net.Uri r2 = android.support.v4.media.a.e(r8)
            r1.e(r2)
            android.os.Bundle r2 = android.support.v4.media.a.c(r8)
            java.lang.String r3 = "android.support.v4.media.description.MEDIA_URI"
            if (r2 == 0) goto L_0x0044
            android.support.v4.media.session.MediaSessionCompat.a(r2)
            android.os.Parcelable r4 = r2.getParcelable(r3)
            android.net.Uri r4 = (android.net.Uri) r4
            goto L_0x0045
        L_0x0044:
            r4 = r0
        L_0x0045:
            if (r4 == 0) goto L_0x005d
            java.lang.String r5 = "android.support.v4.media.description.NULL_BUNDLE_FLAG"
            boolean r6 = r2.containsKey(r5)
            if (r6 == 0) goto L_0x0057
            int r6 = r2.size()
            r7 = 2
            if (r6 != r7) goto L_0x0057
            goto L_0x005e
        L_0x0057:
            r2.remove(r3)
            r2.remove(r5)
        L_0x005d:
            r0 = r2
        L_0x005e:
            r1.c(r0)
            if (r4 == 0) goto L_0x0067
            r1.g(r4)
            goto L_0x006e
        L_0x0067:
            android.net.Uri r0 = android.support.v4.media.b.a(r8)
            r1.g(r0)
        L_0x006e:
            android.support.v4.media.MediaDescriptionCompat r0 = r1.a()
            r0.f230j = r8
        L_0x0074:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v4.media.MediaDescriptionCompat.a(java.lang.Object):android.support.v4.media.MediaDescriptionCompat");
    }

    public Object c() {
        Object obj = this.f230j;
        if (obj != null) {
            return obj;
        }
        Object b10 = a.C0005a.b();
        a.C0005a.g(b10, this.f222a);
        a.C0005a.i(b10, this.f223b);
        a.C0005a.h(b10, this.f224c);
        a.C0005a.c(b10, this.f225d);
        a.C0005a.e(b10, this.f226e);
        a.C0005a.f(b10, this.f227f);
        a.C0005a.d(b10, this.f228g);
        b.a.a(b10, this.f229h);
        Object a10 = a.C0005a.a(b10);
        this.f230j = a10;
        return a10;
    }

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return this.f223b + ", " + this.f224c + ", " + this.f225d;
    }

    public void writeToParcel(Parcel parcel, int i10) {
        a.i(c(), parcel, i10);
    }
}
