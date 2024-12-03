package com.coffeemeetsbagel.feature.bagelprofile;

import com.coffeemeetsbagel.models.constants.ProfileConstants;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public enum ProfileCategory {
    HEIGHT(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY),
    EDUCATION("education"),
    RELIGION(ProfileConstants.Field.RELIGION),
    ETHNICITY("ethnicity"),
    OCCUPATION(ProfileConstants.Field.USER_OCCUPATION),
    EMPLOYER(ProfileConstants.Field.USER_EMPLOYER),
    PHOTO("photo"),
    ACTIVITY_REPORT("activity_report"),
    ICE_BREAKERS("ice_breakers"),
    DATING_STYLE("dating_style"),
    PERSONALITY("personality"),
    VALUES("values"),
    INTERESTS("interests"),
    HOMETOWN("hometown"),
    LANGUAGES("languages"),
    UNKNOWN("");
    

    /* renamed from: a  reason: collision with root package name */
    public static final a f12802a = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, ProfileCategory> f12803b = null;
    private final String tag;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final ProfileCategory a(String str) {
            j.g(str, SDKConstants.PARAM_KEY);
            return ProfileCategory.f12803b.containsKey(str) ? (ProfileCategory) ProfileCategory.f12803b.get(str) : ProfileCategory.UNKNOWN;
        }
    }

    static {
        int i10;
        f12802a = new a((DefaultConstructorMarker) null);
        ProfileCategory[] values = values();
        LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(values.length), 16));
        for (ProfileCategory profileCategory : values) {
            linkedHashMap.put(profileCategory.tag, profileCategory);
        }
        f12803b = linkedHashMap;
    }

    private ProfileCategory(String str) {
        this.tag = str;
    }
}
