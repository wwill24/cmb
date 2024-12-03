package t4;

import android.content.Context;
import android.content.SharedPreferences;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.p;
import com.clevertap.android.sdk.product_config.CTProductConfigController;
import com.clevertap.android.sdk.s;
import com.clevertap.android.sdk.validation.Validator;
import i4.i;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import q4.b;

public class a extends d {

    /* renamed from: a  reason: collision with root package name */
    private final CTProductConfigController f17798a;

    /* renamed from: b  reason: collision with root package name */
    private final c f17799b;

    /* renamed from: c  reason: collision with root package name */
    private final CleverTapInstanceConfig f17800c;

    /* renamed from: d  reason: collision with root package name */
    private final p f17801d;

    /* renamed from: e  reason: collision with root package name */
    private final b f17802e;

    /* renamed from: f  reason: collision with root package name */
    private final Validator f17803f;

    public a(c cVar, CleverTapInstanceConfig cleverTapInstanceConfig, b bVar, Validator validator, i iVar) {
        this.f17799b = cVar;
        this.f17800c = cleverTapInstanceConfig;
        this.f17798a = iVar.f();
        this.f17801d = cleverTapInstanceConfig.n();
        this.f17802e = bVar;
        this.f17803f = validator;
    }

    private void b(Context context, org.json.b bVar) {
        String r10;
        if (bVar != null && bVar.length() != 0 && (r10 = this.f17802e.r()) != null) {
            SharedPreferences.Editor edit = s.h(context, r10).edit();
            Iterator<String> keys = bVar.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                try {
                    Object obj = bVar.get(next);
                    if (obj instanceof Number) {
                        edit.putInt(next, ((Number) obj).intValue());
                    } else if (obj instanceof String) {
                        if (((String) obj).length() < 100) {
                            edit.putString(next, (String) obj);
                        } else {
                            p pVar = this.f17801d;
                            String e10 = this.f17800c.e();
                            pVar.t(e10, "ARP update for key " + next + " rejected (string value too long)");
                        }
                    } else if (obj instanceof Boolean) {
                        edit.putBoolean(next, ((Boolean) obj).booleanValue());
                    } else {
                        p pVar2 = this.f17801d;
                        String e11 = this.f17800c.e();
                        pVar2.t(e11, "ARP update for key " + next + " rejected (invalid data type)");
                    }
                } catch (JSONException unused) {
                }
            }
            p pVar3 = this.f17801d;
            String e12 = this.f17800c.e();
            pVar3.t(e12, "Stored ARP for namespace key: " + r10 + " values: " + bVar.toString());
            s.l(edit);
        }
    }

    private void c(org.json.b bVar) {
        if (!bVar.has("d_e")) {
            this.f17801d.t(this.f17800c.e(), "ARP doesn't contain the Discarded Events key");
            return;
        }
        try {
            ArrayList arrayList = new ArrayList();
            org.json.a jSONArray = bVar.getJSONArray("d_e");
            if (jSONArray != null) {
                for (int i10 = 0; i10 < jSONArray.o(); i10++) {
                    arrayList.add(jSONArray.n(i10));
                }
            }
            Validator validator = this.f17803f;
            if (validator != null) {
                validator.l(arrayList);
            } else {
                this.f17801d.t(this.f17800c.e(), "Validator object is NULL");
            }
        } catch (JSONException e10) {
            p pVar = this.f17801d;
            String e11 = this.f17800c.e();
            pVar.t(e11, "Error parsing discarded events list" + e10.getLocalizedMessage());
        }
    }

    public void a(org.json.b bVar, String str, Context context) {
        try {
            if (bVar.has("arp")) {
                org.json.b bVar2 = (org.json.b) bVar.get("arp");
                if (bVar2.length() > 0) {
                    CTProductConfigController cTProductConfigController = this.f17798a;
                    if (cTProductConfigController != null) {
                        cTProductConfigController.v(bVar2);
                    }
                    c(bVar2);
                    b(context, bVar2);
                }
            }
        } catch (Throwable th2) {
            this.f17801d.u(this.f17800c.e(), "Failed to process ARP", th2);
        }
        this.f17799b.a(bVar, str, context);
    }
}
