package com.coffeemeetsbagel.fragments;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.ActivityProfileEdit;
import com.coffeemeetsbagel.activities.main.ActivityMain;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.models.constants.Extra;
import com.coffeemeetsbagel.models.enums.EventType;
import com.coffeemeetsbagel.products.my_answers.presentation.g;
import com.google.android.material.tabs.TabLayout;
import f5.h;
import fa.a;
import h5.i;
import j5.w;
import java.util.List;
import java.util.Locale;
import lc.c;
import org.bouncycastle.i18n.ErrorBundle;

public class FragmentProfileEdit extends w implements ViewPager.j {

    /* renamed from: e  reason: collision with root package name */
    private h f13591e;

    /* renamed from: f  reason: collision with root package name */
    private ViewPager f13592f;

    enum TabIntentData {
        Prompts("prompts", "FRAGMENT_INDEX_PHOTOS"),
        Photos("photos", "FRAGMENT_INDEX_PHOTOS"),
        Details(ErrorBundle.DETAIL_ENTRY, "FRAGMENT_INDEX_DETAILS"),
        None("unknown", "unknown");
        
        final String segmentName;
        final String tabIntentName;

        private TabIntentData(String str, String str2) {
            this.segmentName = str;
            this.tabIntentName = str2;
        }

        public static TabIntentData a(String str) {
            for (TabIntentData tabIntentData : values()) {
                if (TextUtils.equals(str, tabIntentData.segmentName) || TextUtils.equals(str, tabIntentData.tabIntentName)) {
                    return tabIntentData;
                }
            }
            return None;
        }
    }

    private TabIntentData V0(Bundle bundle) {
        if (bundle == null) {
            return TabIntentData.None;
        }
        Uri uri = (Uri) bundle.getParcelable(Extra.DEEP_LINK);
        if (uri != null) {
            return d1(uri);
        }
        return TabIntentData.a(bundle.getString(Extra.TAB_NAME));
    }

    private void W0() {
        if (this.f13591e.x().B3()) {
            this.f13591e.x().v5(false, this.f13592f);
            Bundle bundle = new Bundle();
            bundle.putBoolean(Extra.WAS_PROFILED_EDITED, true);
            i.c(EventType.PROFILE_SAVED, bundle);
        }
        ((z9.i) requireActivity()).V(this.f13592f.getCurrentItem());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void X0() {
        TabLayout.g B = ((ActivityProfileEdit) requireActivity()).D.B(this.f15627d);
        if (B != null) {
            B.m();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Y0() {
        if (this.f15627d == -1) {
            return;
        }
        if (this.f13592f.getAdapter() == null || this.f15627d >= this.f13592f.getAdapter().e()) {
            a.i(new IndexOutOfBoundsException("Trying to set viewpager to an index beyond its size"));
            return;
        }
        ((ActivityProfileEdit) requireActivity()).D.setupWithViewPager(this.f13592f);
        this.f13592f.setCurrentItem(this.f15627d);
        new Handler().postDelayed(new k5(this), 200);
    }

    public static FragmentProfileEdit Z0(Intent intent) {
        FragmentProfileEdit fragmentProfileEdit = new FragmentProfileEdit();
        if (intent != null) {
            intent.putExtra(Extra.DEEP_LINK, intent.getData());
            fragmentProfileEdit.setArguments(intent.getExtras());
        }
        return fragmentProfileEdit;
    }

    private void e1() {
        new Handler().post(new j5(this));
    }

    public void Q0() {
    }

    public void S(int i10, float f10, int i11) {
        c.a(getActivity());
    }

    public void b1() {
        int currentItem = this.f13592f.getCurrentItem();
        if (currentItem == 0 || currentItem == 1) {
            ((z9.i) requireActivity()).V(this.f13592f.getCurrentItem());
        } else if (currentItem == 2) {
            W0();
        }
    }

    public void c1(Intent intent) {
        TabIntentData tabIntentData;
        if (intent != null) {
            if (intent.getData() != null) {
                intent.putExtra(Extra.DEEP_LINK, intent.getData());
            }
            if (intent.getExtras() != null) {
                tabIntentData = V0(intent.getExtras());
            } else {
                tabIntentData = TabIntentData.None;
            }
            if (tabIntentData != TabIntentData.None) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Changing tabs to ");
                sb2.append(tabIntentData);
                R0(tabIntentData.ordinal());
                this.f13592f.N(tabIntentData.ordinal(), true);
                if (tabIntentData == TabIntentData.Details) {
                    this.f13591e.x().z3(intent.getExtras());
                }
            }
            intent.removeExtra(Extra.DEEP_LINK);
        }
    }

    /* access modifiers changed from: package-private */
    public TabIntentData d1(Uri uri) {
        if (uri == null || uri.getHost() == null) {
            return TabIntentData.None;
        }
        if (!TextUtils.equals("me", uri.getHost())) {
            return TabIntentData.a(uri.getHost().toLowerCase(Locale.getDefault()));
        }
        List<String> pathSegments = uri.getPathSegments();
        if (pathSegments.size() < 1 || !TextUtils.equals("edit", pathSegments.get(0))) {
            return TabIntentData.None;
        }
        if (uri.getPathSegments().size() >= 2) {
            return TabIntentData.a(uri.getPathSegments().get(1));
        }
        return TabIntentData.Prompts;
    }

    public void f1(View view) {
        if (this.f13591e.x().v5(true, view) && this.f15627d != 2) {
            this.f13591e.x().h4(false);
        }
    }

    public void m0(int i10) {
    }

    public void onActivityResult(int i10, int i11, Intent intent) {
        super.onActivityResult(i10, i11, intent);
        if (i10 == 9302 || i10 == 9303) {
            androidx.viewpager.widget.a adapter = this.f13592f.getAdapter();
            ViewPager viewPager = this.f13592f;
            Fragment fragment = (Fragment) adapter.i(viewPager, viewPager.getCurrentItem());
            if (fragment instanceof g) {
                fragment.onActivityResult(i10, i11, intent);
            }
        } else if (getActivity() instanceof ActivityMain) {
            ((ActivityMain) getActivity()).onActivityResult(i10, i11, intent);
        }
    }

    public void onCreate(Bundle bundle) {
        Bakery.j().d1(this);
        super.onCreate(bundle);
        this.f13591e = new h(requireActivity(), getChildFragmentManager(), getArguments().getBoolean(Extra.IS_FROM_NUX, false));
        e1();
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_my_profile, viewGroup, false);
        ViewPager viewPager = (ViewPager) inflate.findViewById(R.id.viewPager_profile);
        this.f13592f = viewPager;
        viewPager.setAdapter(this.f13591e);
        this.f13592f.c(this);
        return inflate;
    }

    public void onPause() {
        super.onPause();
        c.a(getActivity());
    }

    public void onResume() {
        super.onResume();
    }

    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (getArguments() != null) {
            Bundle arguments = getArguments();
            TabIntentData V0 = V0(arguments);
            if (V0 == TabIntentData.None) {
                V0 = TabIntentData.Photos;
            }
            int ordinal = V0.ordinal();
            R0(ordinal);
            this.f13591e.x().setArguments(arguments);
            this.f13592f.setCurrentItem(ordinal);
        }
    }

    public void q(int i10) {
        R0(i10);
        if (i10 == 1) {
            f1(this.f13592f);
        }
    }
}
