package j5;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import b6.e;
import com.coffeemeetsbagel.R;

public abstract class p extends e {
    /* access modifiers changed from: protected */
    public int A0() {
        return R.id.main_content;
    }

    /* renamed from: C0 */
    public FrameLayout onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return (FrameLayout) layoutInflater.inflate(R.layout.component_fragment, viewGroup, false);
    }
}
