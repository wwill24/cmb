package z6;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.feature.activityreports.getpremium.PremiumPageType;
import java.util.ArrayList;
import java.util.List;

public class a extends androidx.viewpager.widget.a {

    /* renamed from: c  reason: collision with root package name */
    private final LayoutInflater f18834c;

    /* renamed from: d  reason: collision with root package name */
    private final Context f18835d;

    /* renamed from: e  reason: collision with root package name */
    private List<PremiumPageType> f18836e = new ArrayList();

    public a(Context context) {
        this.f18834c = LayoutInflater.from(context);
        this.f18835d = context;
    }

    public void b(ViewGroup viewGroup, int i10, Object obj) {
        viewGroup.removeView((View) obj);
    }

    public int e() {
        return this.f18836e.size();
    }

    public Object i(ViewGroup viewGroup, int i10) {
        PremiumPageType premiumPageType = this.f18836e.get(i10);
        View inflate = this.f18834c.inflate(R.layout.page_cmb_premium, viewGroup, false);
        ((ImageView) inflate.findViewById(R.id.image)).setImageResource(premiumPageType.imageResId);
        ((TextView) inflate.findViewById(R.id.title)).setText(this.f18835d.getString(premiumPageType.titleResId));
        ((TextView) inflate.findViewById(R.id.explanation)).setText(premiumPageType.descriptionResId);
        viewGroup.addView(inflate);
        return inflate;
    }

    public boolean j(View view, Object obj) {
        return view == obj;
    }

    public void u(List<PremiumPageType> list) {
        this.f18836e = list;
    }
}
