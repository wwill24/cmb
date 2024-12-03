package com.clevertap.android.sdk.inbox;

import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.x;
import java.util.ArrayList;
import java.util.List;

public class i extends x {

    /* renamed from: h  reason: collision with root package name */
    private final Fragment[] f10562h;

    /* renamed from: i  reason: collision with root package name */
    private final List<String> f10563i = new ArrayList();

    public i(FragmentManager fragmentManager, int i10) {
        super(fragmentManager);
        this.f10562h = new Fragment[i10];
    }

    public int e() {
        return this.f10562h.length;
    }

    public CharSequence g(int i10) {
        return this.f10563i.get(i10);
    }

    @NonNull
    public Object i(@NonNull ViewGroup viewGroup, int i10) {
        Object i11 = super.i(viewGroup, i10);
        this.f10562h[i10] = (Fragment) i11;
        return i11;
    }

    @NonNull
    public Fragment u(int i10) {
        return this.f10562h[i10];
    }

    /* access modifiers changed from: package-private */
    public void x(Fragment fragment, String str, int i10) {
        this.f10562h[i10] = fragment;
        this.f10563i.add(str);
    }
}
