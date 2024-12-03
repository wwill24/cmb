package com.coffeemeetsbagel.fragments;

import com.coffeemeetsbagel.dialogs.e;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;

final class FragmentMyProfileDetails$showEthnicityPicker$2 extends Lambda implements Function1<List<? extends e>, List<? extends String>> {

    /* renamed from: a  reason: collision with root package name */
    public static final FragmentMyProfileDetails$showEthnicityPicker$2 f13588a = new FragmentMyProfileDetails$showEthnicityPicker$2();

    FragmentMyProfileDetails$showEthnicityPicker$2() {
        super(1);
    }

    /* renamed from: a */
    public final List<String> invoke(List<e> list) {
        j.g(list, "selectedBasicItems");
        ArrayList arrayList = new ArrayList(list.size());
        for (e b10 : list) {
            arrayList.add(b10.b());
        }
        return arrayList;
    }
}
