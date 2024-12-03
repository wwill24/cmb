package s3;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import androidx.annotation.NonNull;
import i3.e;
import i3.f;
import l3.c;
import u3.d;

public class s implements f<Uri, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final d f17462a;

    /* renamed from: b  reason: collision with root package name */
    private final m3.d f17463b;

    public s(d dVar, m3.d dVar2) {
        this.f17462a = dVar;
        this.f17463b = dVar2;
    }

    /* renamed from: c */
    public c<Bitmap> a(@NonNull Uri uri, int i10, int i11, @NonNull e eVar) {
        c<Drawable> c10 = this.f17462a.a(uri, i10, i11, eVar);
        if (c10 == null) {
            return null;
        }
        return l.a(this.f17463b, c10.get(), i10, i11);
    }

    /* renamed from: d */
    public boolean b(@NonNull Uri uri, @NonNull e eVar) {
        return "android.resource".equals(uri.getScheme());
    }
}
