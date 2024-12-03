package com.coffeemeetsbagel.new_user_experience.new_to_online_dating;

import com.coffeemeetsbagel.models.entities.GenderType;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public enum NewToOnlineDatingPage {
    FEMALE_NOT_NEW("New To Online Dating Female No", "New To Online Dating - No Screen", r5),
    FEMALE_NEW("New To Online Dating Female yes", "New To Online Dating - Yes Screen", r5),
    MALE_NOT_NEW("New To Online Dating Male No", "New To Online Dating - No Screen", r6),
    MALE_NEW("New To Online Dating Male Yes", "New To Online Dating - Yes Screen", r6),
    QUESTION("New To Online Dating", "New To Online Dating", (String) null),
    DONE("", "", (String) null);
    

    /* renamed from: a  reason: collision with root package name */
    public static final a f35497a = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, NewToOnlineDatingPage> f35498b = null;
    private final String choiceName;
    private final GenderType gender;
    private final String trackingName;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final NewToOnlineDatingPage a(String str) {
            j.g(str, "choiceName");
            try {
                return (NewToOnlineDatingPage) h0.j(NewToOnlineDatingPage.f35498b, str);
            } catch (NoSuchElementException unused) {
                return NewToOnlineDatingPage.DONE;
            }
        }
    }

    static {
        f35497a = new a((DefaultConstructorMarker) null);
        NewToOnlineDatingPage[] values = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(values.length), 16));
        for (NewToOnlineDatingPage newToOnlineDatingPage : values) {
            linkedHashMap.put(newToOnlineDatingPage.choiceName, newToOnlineDatingPage);
        }
        f35498b = linkedHashMap;
    }

    private NewToOnlineDatingPage(String str, String str2, GenderType genderType) {
        this.choiceName = str;
        this.trackingName = str2;
        this.gender = genderType;
    }

    public final String c() {
        return this.choiceName;
    }

    public final GenderType d() {
        return this.gender;
    }

    public final String e() {
        return this.trackingName;
    }
}
