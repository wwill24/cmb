package com.coffeemeetsbagel.database.room_mappers;

import com.coffeemeetsbagel.database.CmbDatabase;
import com.coffeemeetsbagel.domain.repository.ProfileRepository;
import com.coffeemeetsbagel.models.Model;
import h6.a;
import h6.b;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.j;

public class d {

    /* renamed from: a  reason: collision with root package name */
    private final CmbDatabase f11980a;

    /* renamed from: b  reason: collision with root package name */
    private final ProfileRepository f11981b;

    /* renamed from: c  reason: collision with root package name */
    private final MatchRoomSaver f11982c;

    public d(CmbDatabase cmbDatabase, ProfileRepository profileRepository) {
        j.g(cmbDatabase, "cmbDatabase");
        j.g(profileRepository, "profileRepository");
        this.f11980a = cmbDatabase;
        this.f11981b = profileRepository;
        this.f11982c = new MatchRoomSaver(cmbDatabase);
    }

    public void a(List<? extends a<Model>> list) {
        j.g(list, "mappers");
        ArrayList<a> arrayList = new ArrayList<>();
        for (T next : list) {
            if (((a) next) instanceof b) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(r.t(arrayList, 10));
        for (a aVar : arrayList) {
            j.e(aVar, "null cannot be cast to non-null type com.coffeemeetsbagel.database.mappers.MapperBagel");
            arrayList2.add(((b) aVar).f15403a);
        }
        this.f11982c.a(CollectionsKt___CollectionsKt.x0(arrayList2));
    }
}
