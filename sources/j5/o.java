package j5;

import android.os.Bundle;
import b6.l;
import com.coffeemeetsbagel.bakery.Bakery;
import ga.e;
import lc.z;

public abstract class o extends l {

    /* renamed from: e  reason: collision with root package name */
    private int f15621e;

    public e F0() {
        return Bakery.w().L();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        this.f15621e = z.a();
        onApplyThemeResource(getTheme(), this.f15621e, false);
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (z.a() != this.f15621e) {
            recreate();
        }
    }
}
