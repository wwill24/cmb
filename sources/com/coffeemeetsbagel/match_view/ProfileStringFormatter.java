package com.coffeemeetsbagel.match_view;

import bb.a;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.models.Height;
import com.coffeemeetsbagel.models.Resource;
import com.coffeemeetsbagel.models.entities.EthnicityType;
import com.coffeemeetsbagel.models.util.StringUtils;
import com.coffeemeetsbagel.profile.l;
import com.coffeemeetsbagel.profile.n;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.j;

public final class ProfileStringFormatter {

    /* renamed from: a  reason: collision with root package name */
    private final a f34652a;

    public ProfileStringFormatter(a aVar) {
        j.g(aVar, "stringProvider");
        this.f34652a = aVar;
    }

    public final String a(l lVar, List<Resource> list) {
        j.g(lVar, "profile");
        j.g(list, "resources");
        LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(r.t(list, 10)), 16));
        for (Resource resource : list) {
            Pair pair = new Pair(resource.getKey(), resource.getValue());
            linkedHashMap.put(pair.c(), pair.d());
        }
        if (!(!linkedHashMap.isEmpty())) {
            return this.f34652a.a(R.string.not_applicable, new Object[0]);
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        n d10 = lVar.d();
        if (d10 != null) {
            arrayList2.add(d10.b());
            String str = (String) linkedHashMap.get(d10.a());
            if (str != null) {
                arrayList2.add(str);
                String join = StringUtils.join(arrayList2, this.f34652a.a(R.string.education_school_degree_separator, new Object[0]));
                j.f(join, "join(educationLine1, str…school_degree_separator))");
                arrayList.add(join);
            }
        }
        ArrayList arrayList3 = new ArrayList();
        n n10 = lVar.n();
        if (n10 != null) {
            arrayList3.add(n10.b());
            String str2 = (String) linkedHashMap.get(n10.a());
            if (str2 != null) {
                arrayList3.add(str2);
                String join2 = StringUtils.join(arrayList3, this.f34652a.a(R.string.education_school_degree_separator, new Object[0]));
                j.f(join2, "join(educationLine2, str…school_degree_separator))");
                arrayList.add(join2);
            }
        }
        String join3 = StringUtils.join(arrayList, this.f34652a.a(R.string.new_line, new Object[0]));
        j.f(join3, "{\n            val educat…ring.new_line))\n        }");
        return join3;
    }

    public final String b(l lVar) {
        j.g(lVar, "profile");
        String[] b10 = this.f34652a.b(R.array.ethnicity);
        List<EthnicityType> f10 = lVar.f();
        ArrayList arrayList = new ArrayList(r.t(f10, 10));
        for (EthnicityType ordinal : f10) {
            arrayList.add(Integer.valueOf(ordinal.ordinal()));
        }
        return CollectionsKt___CollectionsKt.W(arrayList, ", ", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, new ProfileStringFormatter$getPrettyPrintedEthnicity$prettyPrintedEthnicity$2(b10), 30, (Object) null);
    }

    public final String c(boolean z10, Height height) {
        j.g(height, ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
        if (z10) {
            return this.f34652a.a(R.string.height_formatted_metric, Integer.valueOf(height.getHeightCentimetres()));
        }
        return this.f34652a.a(R.string.height_formatted_imperial, Integer.valueOf(height.getHeightFeet()), Integer.valueOf(height.getHeightInches()));
    }
}
