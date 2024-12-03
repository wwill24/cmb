package com.coffeemeetsbagel.new_user_experience.relationship_goals;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public enum RelationshipGoalPage {
    MARRIAGE("GoodStuffQuestion 1Choice1", "Relationship Marriage Timing"),
    COMMITTED("GoodStuffQuestion 1Choice2", "Committed Relationship Screen"),
    CASUAL("GoodStuffQuestion 1Choice3", "Something Casual Screen"),
    NOT_SURE("GoodStuffQuestion 1Choice4", "Not Sure Screen"),
    PREFER_NOT_TO_SAY("GoodStuffQuestion 1Choice5", "Prefer Not To Say"),
    READY_NOW("GoodStuffQuestion 2Choice1", "Ready Now"),
    WITHIN_TWO_YEARS("GoodStuffQuestion 2Choice2", "Within Two Years"),
    AFTER_TWO_YEARS("GoodStuffQuestion 2Choice3", "After Two Years"),
    NOT_SURE_WHEN("GoodStuffQuestion 2Choice4", "Not Sure When"),
    FIRST_QUESTION("", "Relationship Goals Looking For"),
    DONE("", "");
    

    /* renamed from: a  reason: collision with root package name */
    public static final a f35582a = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, RelationshipGoalPage> f35583b = null;
    private final String choiceName;
    private final String trackingName;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final RelationshipGoalPage a(String str) {
            j.g(str, "choiceName");
            try {
                return (RelationshipGoalPage) h0.j(RelationshipGoalPage.f35583b, str);
            } catch (NoSuchElementException unused) {
                return RelationshipGoalPage.DONE;
            }
        }
    }

    static {
        int i10;
        f35582a = new a((DefaultConstructorMarker) null);
        RelationshipGoalPage[] values = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(values.length), 16));
        for (RelationshipGoalPage relationshipGoalPage : values) {
            linkedHashMap.put(relationshipGoalPage.choiceName, relationshipGoalPage);
        }
        f35583b = linkedHashMap;
    }

    private RelationshipGoalPage(String str, String str2) {
        this.choiceName = str;
        this.trackingName = str2;
    }

    public final String c() {
        return this.choiceName;
    }

    public final String d() {
        return this.trackingName;
    }
}
