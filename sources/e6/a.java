package e6;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import java.util.ArrayList;
import java.util.List;

public class a extends androidx.viewpager.widget.a {

    /* renamed from: c  reason: collision with root package name */
    private final List<b> f14583c;

    public a(List<b> list) {
        ArrayList arrayList = new ArrayList();
        this.f14583c = arrayList;
        arrayList.addAll(list);
    }

    public int e() {
        return this.f14583c.size();
    }

    public CharSequence g(int i10) {
        return this.f14583c.get(i10).m();
    }

    @NonNull
    public Object i(@NonNull ViewGroup viewGroup, int i10) {
        View l10 = this.f14583c.get(i10).l();
        viewGroup.addView(l10);
        return l10;
    }

    public boolean j(@NonNull View view, @NonNull Object obj) {
        return view == obj;
    }
}
