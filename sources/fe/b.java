package fe;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.NonNull;
import com.google.android.gms.common.internal.p;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import me.c;

public final class b {
    @NonNull
    public static <T extends SafeParcelable> T a(@NonNull byte[] bArr, @NonNull Parcelable.Creator<T> creator) {
        p.k(creator);
        Parcel obtain = Parcel.obtain();
        obtain.unmarshall(bArr, 0, bArr.length);
        obtain.setDataPosition(0);
        T t10 = (SafeParcelable) creator.createFromParcel(obtain);
        obtain.recycle();
        return t10;
    }

    public static <T extends SafeParcelable> T b(@NonNull Intent intent, @NonNull String str, @NonNull Parcelable.Creator<T> creator) {
        byte[] byteArrayExtra = intent.getByteArrayExtra(str);
        if (byteArrayExtra == null) {
            return null;
        }
        return a(byteArrayExtra, creator);
    }

    @NonNull
    public static <T extends SafeParcelable> T c(@NonNull String str, @NonNull Parcelable.Creator<T> creator) {
        return a(c.a(str), creator);
    }

    @NonNull
    public static <T extends SafeParcelable> byte[] d(@NonNull T t10) {
        Parcel obtain = Parcel.obtain();
        t10.writeToParcel(obtain, 0);
        byte[] marshall = obtain.marshall();
        obtain.recycle();
        return marshall;
    }

    public static <T extends SafeParcelable> void e(@NonNull T t10, @NonNull Intent intent, @NonNull String str) {
        intent.putExtra(str, d(t10));
    }

    @NonNull
    public static <T extends SafeParcelable> String f(@NonNull T t10) {
        return c.d(d(t10));
    }
}
