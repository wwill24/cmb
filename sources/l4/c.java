package l4;

import android.content.Context;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.j;
import com.clevertap.android.sdk.p;
import com.clevertap.android.sdk.s;
import i4.h;
import java.util.Arrays;
import org.json.JSONException;
import org.json.b;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private final j f16003a;

    /* renamed from: b  reason: collision with root package name */
    private final CleverTapInstanceConfig f16004b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f16005c;

    public c(Context context, CleverTapInstanceConfig cleverTapInstanceConfig, j jVar) {
        this.f16005c = context;
        this.f16004b = cleverTapInstanceConfig;
        this.f16003a = jVar;
    }

    private boolean a() {
        if (((int) (System.currentTimeMillis() / 1000)) - s.d(this.f16005c, this.f16004b, "comms_mtd", 0) < 86400) {
            return true;
        }
        return false;
    }

    public boolean b(b bVar, int i10) {
        if (this.f16004b.s()) {
            return false;
        }
        if (bVar.has("evtName")) {
            try {
                if (Arrays.asList(h.f15489b).contains(bVar.getString("evtName"))) {
                    return false;
                }
            } catch (JSONException unused) {
            }
        }
        if (i10 != 4 || this.f16003a.y()) {
            return false;
        }
        return true;
    }

    public boolean c(b bVar, int i10) {
        String str;
        if (i10 == 7) {
            return false;
        }
        if (this.f16003a.A()) {
            if (bVar == null) {
                str = "null";
            } else {
                str = bVar.toString();
            }
            p n10 = this.f16004b.n();
            String e10 = this.f16004b.e();
            n10.f(e10, "Current user is opted out dropping event: " + str);
            return true;
        } else if (!a()) {
            return false;
        } else {
            p n11 = this.f16004b.n();
            String e11 = this.f16004b.e();
            n11.t(e11, "CleverTap is muted, dropping event - " + bVar.toString());
            return true;
        }
    }
}
