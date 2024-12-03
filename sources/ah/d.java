package ah;

import android.graphics.Bitmap;
import android.media.Image;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.h;
import com.google.android.gms.common.internal.p;
import com.google.mlkit.common.MlKitException;
import java.nio.ByteBuffer;
import pe.a;
import pe.b;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private static final h f18848a = new h("MLKitImageUtils", "");

    /* renamed from: b  reason: collision with root package name */
    private static final d f18849b = new d();

    private d() {
    }

    @NonNull
    public static d b() {
        return f18849b;
    }

    @NonNull
    public a a(@NonNull zg.a aVar) throws MlKitException {
        int g10 = aVar.g();
        if (g10 == -1) {
            return b.g((Bitmap) p.k(aVar.d()));
        }
        if (g10 != 17) {
            if (g10 == 35) {
                return b.g(aVar.i());
            }
            if (g10 != 842094169) {
                int g11 = aVar.g();
                throw new MlKitException("Unsupported image format: " + g11, 3);
            }
        }
        return b.g((ByteBuffer) p.k(aVar.e()));
    }

    public int c(@NonNull zg.a aVar) {
        return aVar.g();
    }

    public int d(@NonNull zg.a aVar) {
        if (aVar.g() == -1) {
            return ((Bitmap) p.k(aVar.d())).getAllocationByteCount();
        }
        if (aVar.g() == 17 || aVar.g() == 842094169) {
            return ((ByteBuffer) p.k(aVar.e())).limit();
        }
        if (aVar.g() != 35) {
            return 0;
        }
        return (((Image.Plane[]) p.k(aVar.j()))[0].getBuffer().limit() * 3) / 2;
    }
}
