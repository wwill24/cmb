package e4;

import android.content.Context;
import androidx.annotation.NonNull;
import f4.k;
import i3.b;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public final class a implements b {

    /* renamed from: b  reason: collision with root package name */
    private final int f14573b;

    /* renamed from: c  reason: collision with root package name */
    private final b f14574c;

    private a(int i10, b bVar) {
        this.f14573b = i10;
        this.f14574c = bVar;
    }

    @NonNull
    public static b a(@NonNull Context context) {
        return new a(context.getResources().getConfiguration().uiMode & 48, b.c(context));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (this.f14573b != aVar.f14573b || !this.f14574c.equals(aVar.f14574c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return k.m(this.f14574c, this.f14573b);
    }

    public void updateDiskCacheKey(@NonNull MessageDigest messageDigest) {
        this.f14574c.updateDiskCacheKey(messageDigest);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f14573b).array());
    }
}
