package com.coffeemeetsbagel.database.room_mappers;

import com.coffeemeetsbagel.database.CmbDatabase;
import com.coffeemeetsbagel.models.Bagel;
import com.coffeemeetsbagel.models.MatchContext;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.j;

public final class MatchRoomSaver {

    /* renamed from: a  reason: collision with root package name */
    private final CmbDatabase f11974a;

    public MatchRoomSaver(CmbDatabase cmbDatabase) {
        j.g(cmbDatabase, "cmbDatabase");
        this.f11974a = cmbDatabase;
    }

    public final int a(List<? extends Bagel> list) {
        MatchRoomSaver$save$matchContexts$1$1$1 matchRoomSaver$save$matchContexts$1$1$1;
        j.g(list, "bagels");
        ArrayList arrayList = new ArrayList();
        for (Bagel bagel : list) {
            MatchContext matchContext = bagel.getMatchContext();
            if (matchContext != null) {
                String id2 = bagel.getId();
                if (id2 == null) {
                    id2 = "";
                } else {
                    j.f(id2, "bagel.id ?: \"\"");
                }
                matchRoomSaver$save$matchContexts$1$1$1 = new MatchRoomSaver$save$matchContexts$1$1$1(id2, matchContext);
            } else {
                matchRoomSaver$save$matchContexts$1$1$1 = null;
            }
            if (matchRoomSaver$save$matchContexts$1$1$1 != null) {
                arrayList.add(matchRoomSaver$save$matchContexts$1$1$1);
            }
        }
        return this.f11974a.P().i(arrayList);
    }
}
