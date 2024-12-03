package s3;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import androidx.annotation.NonNull;
import f4.j;
import i3.e;
import i3.f;
import java.io.IOException;
import l3.c;

public class a<DataType> implements f<DataType, BitmapDrawable> {

    /* renamed from: a  reason: collision with root package name */
    private final f<DataType, Bitmap> f17440a;

    /* renamed from: b  reason: collision with root package name */
    private final Resources f17441b;

    public a(@NonNull Resources resources, @NonNull f<DataType, Bitmap> fVar) {
        this.f17441b = (Resources) j.d(resources);
        this.f17440a = (f) j.d(fVar);
    }

    public c<BitmapDrawable> a(@NonNull DataType datatype, int i10, int i11, @NonNull e eVar) throws IOException {
        return q.d(this.f17441b, this.f17440a.a(datatype, i10, i11, eVar));
    }

    public boolean b(@NonNull DataType datatype, @NonNull e eVar) throws IOException {
        return this.f17440a.b(datatype, eVar);
    }
}
