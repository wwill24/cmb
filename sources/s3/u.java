package s3;

import android.graphics.Bitmap;
import androidx.annotation.NonNull;
import f4.k;
import i3.e;
import i3.f;
import l3.c;

public final class u implements f<Bitmap, Bitmap> {

    private static final class a implements c<Bitmap> {

        /* renamed from: a  reason: collision with root package name */
        private final Bitmap f17469a;

        a(@NonNull Bitmap bitmap) {
            this.f17469a = bitmap;
        }

        public void a() {
        }

        @NonNull
        public Class<Bitmap> b() {
            return Bitmap.class;
        }

        @NonNull
        /* renamed from: c */
        public Bitmap get() {
            return this.f17469a;
        }

        public int getSize() {
            return k.g(this.f17469a);
        }
    }

    /* renamed from: c */
    public c<Bitmap> a(@NonNull Bitmap bitmap, int i10, int i11, @NonNull e eVar) {
        return new a(bitmap);
    }

    /* renamed from: d */
    public boolean b(@NonNull Bitmap bitmap, @NonNull e eVar) {
        return true;
    }
}
