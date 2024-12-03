package com.coffeemeetsbagel.feature.profile_completion_helper;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.h;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import com.coffeemeetsbagel.feature.profile_completion_helper.ProfileCompletionHelperViewModel;
import java.util.List;
import kotlin.jvm.internal.j;

public final class d extends FragmentStateAdapter {

    /* renamed from: m  reason: collision with root package name */
    private final List<ProfileCompletionHelperViewModel.a> f13195m;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(h hVar, List<ProfileCompletionHelperViewModel.a> list) {
        super(hVar);
        j.g(hVar, "fa");
        j.g(list, "fragmentList");
        this.f13195m = list;
    }

    public Fragment I(int i10) {
        return this.f13195m.get(i10).a();
    }

    public final Fragment a0(int i10) {
        return this.f13195m.get(i10).a();
    }

    public int g() {
        return this.f13195m.size();
    }
}
