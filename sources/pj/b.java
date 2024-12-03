package pj;

import android.content.Context;
import androidx.annotation.NonNull;

public class b {

    /* renamed from: a  reason: collision with root package name */
    private final float f33764a;

    public b(float f10) {
        this.f33764a = f10;
    }

    @NonNull
    public static b a(@NonNull Context context) {
        return new b(context.getResources().getDisplayMetrics().density);
    }

    public int b(int i10) {
        return (int) ((((float) i10) * this.f33764a) + 0.5f);
    }
}
