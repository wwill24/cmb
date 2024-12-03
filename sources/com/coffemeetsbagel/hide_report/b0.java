package com.coffemeetsbagel.hide_report;

import com.coffeemeetsbagel.domain.repository.ProfileRepository;
import kotlin.jvm.internal.j;
import qj.w;

public final class b0 {

    /* renamed from: a  reason: collision with root package name */
    private final ProfileRepository f37667a;

    public b0(ProfileRepository profileRepository) {
        j.g(profileRepository, "profileRepository");
        this.f37667a = profileRepository;
    }

    public final w<String> a(String str, String str2, String str3) {
        j.g(str, "profileId");
        j.g(str2, "blockType");
        return this.f37667a.e(str, str2, str3);
    }
}
