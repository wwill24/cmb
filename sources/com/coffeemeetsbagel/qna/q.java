package com.coffeemeetsbagel.qna;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.j;
import za.b;
import za.c;
import za.i;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    public static final q f36305a = new q();

    private q() {
    }

    public final List<QuestionWAnswers> a(List<b> list, List<i> list2) {
        List list3;
        j.g(list, "answerEntities");
        j.g(list2, "questionRooms");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T next : list) {
            String j10 = ((b) next).j();
            Object obj = linkedHashMap.get(j10);
            if (obj == null) {
                obj = new ArrayList();
                linkedHashMap.put(j10, obj);
            }
            ((List) obj).add(next);
        }
        ArrayList arrayList = new ArrayList(r.t(list2, 10));
        for (i iVar : list2) {
            List<b> list4 = (List) linkedHashMap.get(iVar.b().b());
            if (list4 != null) {
                list3 = new ArrayList(r.t(list4, 10));
                for (b e10 : list4) {
                    list3.add(r.e(e10));
                }
            } else {
                list3 = q.j();
            }
            List<c> a10 = iVar.a();
            ArrayList arrayList2 = new ArrayList(r.t(a10, 10));
            for (c g10 : a10) {
                arrayList2.add(r.g(g10, iVar.b().b()));
            }
            arrayList.add(new QuestionWAnswers(r.i(iVar.b(), arrayList2), list3));
        }
        return arrayList;
    }
}
