package g6;

import com.coffeemeetsbagel.models.entities.EthnicityType;
import com.google.gson.d;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.j;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final d f15192a = new d();

    public static final class a extends qg.a<List<? extends String>> {
        a() {
        }
    }

    public final String a(List<? extends EthnicityType> list) {
        j.g(list, "ethnicities");
        ArrayList arrayList = new ArrayList();
        for (EthnicityType apiKey : list) {
            String apiKey2 = apiKey.getApiKey();
            if (apiKey2 != null) {
                arrayList.add(apiKey2);
            }
        }
        String u10 = this.f15192a.u(arrayList);
        j.f(u10, "gson.toJson(ethnicityKeys)");
        return u10;
    }

    public final List<EthnicityType> b(String str) {
        List<String> F;
        j.g(str, "serializedEthnicities");
        if (r.w(str)) {
            return q.j();
        }
        List list = (List) this.f15192a.l(str, new a().d());
        if (list == null || (F = CollectionsKt___CollectionsKt.F(list)) == null) {
            return q.j();
        }
        ArrayList arrayList = new ArrayList();
        for (String fromApiKey : F) {
            EthnicityType fromApiKey2 = EthnicityType.Companion.fromApiKey(fromApiKey);
            if (fromApiKey2 != null) {
                arrayList.add(fromApiKey2);
            }
        }
        return arrayList;
    }
}
