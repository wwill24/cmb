package j5;

import android.app.Activity;
import android.os.Bundle;
import lc.z;

public abstract class r extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private int f15622a;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        this.f15622a = z.a();
        onApplyThemeResource(getTheme(), this.f15622a, false);
        super.onCreate(bundle);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (z.a() != this.f15622a) {
            recreate();
        }
    }
}
