package w7;

import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.models.Height;
import com.coffeemeetsbagel.models.constants.ProfileConstants;
import com.facebook.internal.AnalyticsEvents;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jivesoftware.smack.sm.packet.StreamManagement;
import org.jivesoftware.smackx.mam.element.MamElements;
import v7.b;
import v7.c;
import v7.d;

public class k implements b {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final d f18287a;

    /* renamed from: b  reason: collision with root package name */
    private final a7.a f18288b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public c f18289c;

    /* renamed from: d  reason: collision with root package name */
    private j f18290d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f18291e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public boolean f18292f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public boolean f18293g;

    class a implements d.a {
        a() {
        }

        public void onFailure() {
            k.this.f18293g = true;
            if (k.this.f18289c != null) {
                k.this.f18289c.k();
                k.this.f18289c.l(R.string.failed_to_filter);
            }
        }

        public void onSuccess() {
            k.this.f18293g = false;
            k.this.f18292f = true;
            if (k.this.f18289c != null) {
                k.this.f18289c.k();
                if (k.this.f18287a.a().isEmpty()) {
                    k.this.f18289c.A(52);
                } else {
                    k.this.f18289c.exit();
                }
            }
        }
    }

    public k(d dVar, a7.a aVar, c cVar) {
        this.f18287a = dVar;
        this.f18289c = cVar;
        this.f18288b = aVar;
        this.f18290d = dVar.b();
    }

    private void X() {
        Map map;
        if (this.f18292f) {
            map = Y();
            map.put(MamElements.MamResultExtension.ELEMENT, "applied");
        } else if (this.f18293g) {
            map = Y();
            map.put(MamElements.MamResultExtension.ELEMENT, StreamManagement.Failed.ELEMENT);
        } else {
            map = new HashMap();
            map.put(MamElements.MamResultExtension.ELEMENT, AnalyticsEvents.PARAMETER_SHARE_OUTCOME_CANCELLED);
        }
        this.f18288b.trackEvent("Discover Filters", map);
    }

    private Map<String, String> Y() {
        HashMap hashMap = new HashMap();
        if (this.f18290d.h() != null) {
            int intValue = this.f18290d.h().intValue();
            int i10 = -1;
            int i11 = 0;
            while (true) {
                int[] iArr = ProfileConstants.POSSIBLE_DISTANCE_VALUES_KM;
                if (i11 >= iArr.length) {
                    break;
                } else if (iArr[i11] == intValue) {
                    i10 = i11;
                    break;
                } else {
                    i11++;
                }
            }
            hashMap.put("distance", String.valueOf(ProfileConstants.POSSIBLE_DISTANCE_VALUES_MILES[i10]));
        }
        if (this.f18290d.b() != null) {
            hashMap.put("age range min", String.valueOf(this.f18290d.b()));
        }
        if (this.f18290d.c() != null) {
            hashMap.put("age range max", String.valueOf(this.f18290d.c()));
        }
        if (this.f18290d.i() != null) {
            hashMap.put("recently active", String.valueOf(this.f18290d.i()));
        }
        if (this.f18290d.e() == null || this.f18290d.e().isEmpty()) {
            hashMap.put("ethnicity", "no");
        } else {
            hashMap.put("ethnicity", "yes");
        }
        if (this.f18290d.f() != null) {
            hashMap.put("height range min", String.valueOf(Height.convertToInches(this.f18290d.f().intValue())));
        }
        if (this.f18290d.g() != null) {
            hashMap.put("height range max", String.valueOf(Height.convertToInches(this.f18290d.g().intValue())));
        }
        if (this.f18290d.d() == null || this.f18290d.d().isEmpty()) {
            hashMap.put("degree", "no");
        } else {
            hashMap.put("degree", "yes");
        }
        if (this.f18291e) {
            hashMap.put("reset filters", "yes");
        } else {
            hashMap.put("reset filters", "no");
        }
        return hashMap;
    }

    public void H() {
        this.f18289c.j();
        if (this.f18290d.j()) {
            this.f18287a.o(this.f18290d, new a());
            return;
        }
        this.f18287a.g();
        this.f18290d = this.f18287a.b();
        this.f18289c.exit();
    }

    public void J(List<String> list) {
        if (list.isEmpty()) {
            this.f18290d.m((List<String>) null);
        } else {
            this.f18290d.m(list);
        }
    }

    public void L() {
        this.f18291e = true;
        this.f18287a.g();
        j b10 = this.f18287a.b();
        this.f18290d = b10;
        this.f18289c.a0(b10, true);
    }

    public void N(int i10, int i11) {
        this.f18290d.n(i10, i11);
    }

    public void b() {
        this.f18289c.b();
    }

    public void j(int i10) {
        this.f18290d.o(i10);
    }

    public void k() {
        this.f18289c.z();
    }

    public void l(int i10, int i11) {
        this.f18290d.k(i10, i11);
    }

    public void start() {
        this.f18288b.f("discover filters");
        this.f18289c.a0(this.f18290d, false);
    }

    public void stop() {
        this.f18289c = null;
        X();
    }

    public void t(boolean z10) {
        this.f18290d.p(z10);
    }

    public void u() {
        this.f18289c.w();
    }

    public void y(List<String> list) {
        if (list.isEmpty()) {
            this.f18290d.l((List<String>) null);
        } else {
            this.f18290d.l(list);
        }
    }
}
