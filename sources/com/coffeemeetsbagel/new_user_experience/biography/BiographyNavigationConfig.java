package com.coffeemeetsbagel.new_user_experience.biography;

import java.util.ArrayList;
import java.util.List;

public final class BiographyNavigationConfig {

    /* renamed from: a  reason: collision with root package name */
    private final List<Pages> f34830a;

    /* renamed from: b  reason: collision with root package name */
    private Pages f34831b;

    public enum Pages {
        HEADER("Personal Info Intro"),
        HEIGHT("Height"),
        ETHNICITY("Ethnicity"),
        RELIGION("Religion"),
        JOB_TITLE("Occupation"),
        DEGREE("Degree"),
        SCHOOL("School Name");
        
        private final String trackingName;

        private Pages(String str) {
            this.trackingName = str;
        }

        public final String b() {
            return this.trackingName;
        }
    }

    public BiographyNavigationConfig(boolean z10) {
        ArrayList arrayList = new ArrayList();
        this.f34830a = arrayList;
        Pages pages = Pages.HEADER;
        this.f34831b = pages;
        if (z10) {
            arrayList.add(pages);
            arrayList.add(Pages.DEGREE);
            arrayList.add(Pages.SCHOOL);
            arrayList.add(Pages.JOB_TITLE);
            arrayList.add(Pages.HEIGHT);
            arrayList.add(Pages.ETHNICITY);
            arrayList.add(Pages.RELIGION);
            return;
        }
        arrayList.add(pages);
        arrayList.add(Pages.HEIGHT);
        arrayList.add(Pages.ETHNICITY);
        arrayList.add(Pages.RELIGION);
        arrayList.add(Pages.JOB_TITLE);
        arrayList.add(Pages.DEGREE);
        arrayList.add(Pages.SCHOOL);
    }

    public final Pages a() {
        return this.f34831b;
    }

    public final Pages b() {
        Pages pages;
        int S = CollectionsKt___CollectionsKt.S(this.f34830a, this.f34831b) - 1;
        if (S >= 0) {
            pages = this.f34830a.get(S);
        } else {
            pages = null;
        }
        this.f34831b = pages;
        return pages;
    }

    public final Pages c() {
        Pages pages;
        int S = CollectionsKt___CollectionsKt.S(this.f34830a, this.f34831b) + 1;
        if (S < this.f34830a.size()) {
            pages = this.f34830a.get(S);
        } else {
            pages = null;
        }
        this.f34831b = pages;
        return pages;
    }
}
