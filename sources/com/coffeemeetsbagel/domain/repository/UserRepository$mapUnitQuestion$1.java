package com.coffeemeetsbagel.domain.repository;

import com.coffeemeetsbagel.models.enums.Units;
import j$.time.OffsetDateTime;
import ja.a;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import za.b;
import za.c;
import za.i;

final class UserRepository$mapUnitQuestion$1 extends Lambda implements Function1<Map<i, ? extends List<? extends b>>, ja.b> {
    final /* synthetic */ ja.b $user;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    UserRepository$mapUnitQuestion$1(ja.b bVar) {
        super(1);
        this.$user = bVar;
    }

    /* renamed from: a */
    public final ja.b invoke(Map<i, ? extends List<b>> map) {
        String str;
        i iVar;
        List<c> a10;
        T t10;
        List list;
        b bVar;
        j.g(map, "question");
        Map.Entry entry = (Map.Entry) CollectionsKt___CollectionsKt.O(map.entrySet());
        String str2 = null;
        if (entry == null || (list = (List) entry.getValue()) == null || (bVar = (b) CollectionsKt___CollectionsKt.P(list)) == null) {
            str = null;
        } else {
            str = bVar.h();
        }
        if (str != null) {
            ja.b bVar2 = this.$user;
            Map.Entry entry2 = (Map.Entry) CollectionsKt___CollectionsKt.O(map.entrySet());
            if (!(entry2 == null || (iVar = (i) entry2.getKey()) == null || (a10 = iVar.a()) == null)) {
                Iterator<T> it = a10.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        t10 = null;
                        break;
                    }
                    t10 = it.next();
                    if (j.b(((c) t10).a(), str)) {
                        break;
                    }
                }
                c cVar = (c) t10;
                if (cVar != null) {
                    str2 = cVar.b();
                }
            }
            ja.b b10 = ja.b.b(bVar2, (String) null, (String) null, (String) null, false, (OffsetDateTime) null, 0, (OffsetDateTime) null, (a) null, (String) null, false, (String) null, (OffsetDateTime) null, (String) null, (List) null, (String) null, (com.coffeemeetsbagel.profile.i) null, 0, 0, false, false, (String) null, 0, (String) null, (String) null, j.b(Units.METRIC.getApiKey(), str2), 16777215, (Object) null);
            if (b10 != null) {
                return b10;
            }
        }
        return this.$user;
    }
}
