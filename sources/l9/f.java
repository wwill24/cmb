package l9;

import a7.a;
import android.content.Context;
import android.content.res.Resources;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.experiment.t;
import com.coffeemeetsbagel.models.Price;
import com.coffeemeetsbagel.models.entities.GenderType;
import com.coffeemeetsbagel.store.alc.PurchaseType;
import com.coffeemeetsbagel.store.k0;
import com.facebook.internal.AnalyticsEvents;
import java.util.HashMap;
import org.jivesoftware.smackx.mam.element.MamElements;

public class f implements b {

    /* renamed from: a  reason: collision with root package name */
    private final c f16270a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f16271b;

    /* renamed from: c  reason: collision with root package name */
    private final k0 f16272c;

    /* renamed from: d  reason: collision with root package name */
    private final a f16273d;

    /* renamed from: e  reason: collision with root package name */
    private final a f16274e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f16275f;

    /* renamed from: g  reason: collision with root package name */
    private int f16276g;

    /* renamed from: h  reason: collision with root package name */
    private final int f16277h;

    f(c cVar, int i10, GenderType genderType, Context context, k0 k0Var, a aVar, a aVar2, t tVar, int i11) {
        this.f16270a = cVar;
        this.f16271b = context;
        this.f16277h = i10;
        this.f16272c = k0Var;
        this.f16274e = aVar;
        this.f16273d = aVar2;
        i11 = i11 == 0 ? (int) tVar.m() : i11;
        if (i11 > 999 || i11 <= 0) {
            this.f16276g = 2;
        } else {
            this.f16276g = i11;
        }
    }

    private int f() {
        Price price = this.f16272c.getPrice(PurchaseType.WOO);
        return price.getBeanCost(Math.max(0, this.f16276g - price.getFreeItemCount()));
    }

    private Integer g() {
        return Integer.valueOf(Math.min((int) Math.ceil(((double) this.f16277h) / 6.0d), 10));
    }

    private String h() {
        String str;
        String str2;
        Integer g10 = g();
        if (g10.intValue() > 1) {
            str = this.f16271b.getResources().getString(R.string.days);
        } else {
            str = this.f16271b.getResources().getString(R.string.hours);
        }
        Resources resources = this.f16271b.getResources();
        Object[] objArr = new Object[2];
        if (g10.intValue() > 1) {
            str2 = Integer.toString(g10.intValue());
        } else {
            str2 = "24";
        }
        objArr[0] = str2;
        objArr[1] = str;
        return resources.getString(R.string.wow_this_bagel_is_popular_dls, objArr);
    }

    private void i() {
        this.f16270a.c(h());
    }

    public void a() {
        this.f16274e.j(this.f16276g);
    }

    public void b() {
        this.f16275f = true;
    }

    public void c() {
        int i10 = this.f16276g + 1;
        this.f16276g = i10;
        this.f16270a.a(i10);
        this.f16270a.b(f());
        i();
    }

    public void d(int i10) {
        this.f16274e.b(i10, this.f16276g);
    }

    public void e() {
        int i10 = this.f16276g;
        if (i10 > 1) {
            int i11 = i10 - 1;
            this.f16276g = i11;
            this.f16270a.a(i11);
            this.f16270a.b(f());
        }
        i();
    }

    public void start() {
        this.f16270a.c(h());
        this.f16270a.b(f());
        this.f16270a.a(this.f16276g);
        this.f16273d.g("Skip the Line");
    }

    public void stop() {
        HashMap hashMap = new HashMap();
        hashMap.put("Rising Count", Integer.toString(this.f16277h));
        hashMap.put("Woos Sent", Integer.toString(this.f16276g));
        if (this.f16275f) {
            hashMap.put(MamElements.MamResultExtension.ELEMENT, "purchased");
        } else {
            hashMap.put(MamElements.MamResultExtension.ELEMENT, AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED);
        }
        this.f16273d.trackEvent("Skip the Line", hashMap);
    }
}
