package s3;

import android.graphics.Bitmap;
import android.os.ParcelFileDescriptor;
import androidx.annotation.NonNull;
import com.bumptech.glide.load.resource.bitmap.a;
import i3.e;
import i3.f;
import java.io.IOException;
import l3.c;

public final class r implements f<ParcelFileDescriptor, Bitmap> {

    /* renamed from: a  reason: collision with root package name */
    private final a f17461a;

    public r(a aVar) {
        this.f17461a = aVar;
    }

    /* renamed from: c */
    public c<Bitmap> a(@NonNull ParcelFileDescriptor parcelFileDescriptor, int i10, int i11, @NonNull e eVar) throws IOException {
        return this.f17461a.d(parcelFileDescriptor, i10, i11, eVar);
    }

    /* renamed from: d */
    public boolean b(@NonNull ParcelFileDescriptor parcelFileDescriptor, @NonNull e eVar) {
        return this.f17461a.o(parcelFileDescriptor);
    }
}
