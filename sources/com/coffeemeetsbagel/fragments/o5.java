package com.coffeemeetsbagel.fragments;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Telephony;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.models.constants.Extra;
import f5.l;
import h5.m;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.jivesoftware.smackx.mam.element.MamElements;

public class o5 extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    protected RecyclerView f13790a;

    /* renamed from: b  reason: collision with root package name */
    protected PackageManager f13791b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f13792c = true;

    /* renamed from: d  reason: collision with root package name */
    private int f13793d;

    /* renamed from: e  reason: collision with root package name */
    private int f13794e;

    /* renamed from: f  reason: collision with root package name */
    private int f13795f;

    /* renamed from: g  reason: collision with root package name */
    private int f13796g;

    /* renamed from: h  reason: collision with root package name */
    private String f13797h;

    /* renamed from: j  reason: collision with root package name */
    private String f13798j;

    /* renamed from: k  reason: collision with root package name */
    private CharSequence f13799k;

    /* renamed from: l  reason: collision with root package name */
    private String f13800l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f13801m;

    class a extends GridLayoutManager.c {

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ l f13802e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ GridLayoutManager f13803f;

        a(l lVar, GridLayoutManager gridLayoutManager) {
            this.f13802e = lVar;
            this.f13803f = gridLayoutManager;
        }

        public int f(int i10) {
            if (this.f13802e.J(i10)) {
                return this.f13803f.W2();
            }
            return 1;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ boolean I0(Map map, String str) {
        return !map.containsKey(str);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int J0(ResolveInfo resolveInfo, ResolveInfo resolveInfo2) {
        int i10 = resolveInfo.preferredOrder - resolveInfo2.preferredOrder;
        if (i10 == 0) {
            return resolveInfo.priority - resolveInfo2.priority;
        }
        return i10;
    }

    public static o5 L0(Bundle bundle) {
        o5 o5Var = new o5();
        o5Var.setArguments(bundle);
        return o5Var;
    }

    private void M0(Map<String, ResolveInfo> map, List<String> list) {
        int i10 = 0;
        while (i10 < map.keySet().size()) {
            String str = map.get((String) map.keySet().toArray()[i10]).activityInfo.taskAffinity;
            i10++;
            for (int i11 = i10; i11 < map.keySet().size(); i11++) {
                String str2 = (String) map.keySet().toArray()[i11];
                String str3 = map.get(str2).activityInfo.taskAffinity;
                if (str != null && str.equals(str3)) {
                    map.remove(str2);
                    list.remove(str2);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void B0(Map<String, ResolveInfo> map) {
        ResolveInfo H0 = H0();
        if (H0 != null) {
            map.put("sms", H0);
        }
    }

    /* access modifiers changed from: protected */
    public List<String> C0(List<String> list, int i10, List<String> list2) {
        while (list2.size() > i10) {
            int size = list2.size() - 1;
            while (true) {
                if (size < 0) {
                    break;
                } else if (!list.contains(list2.get(size))) {
                    list2.remove(size);
                    break;
                } else {
                    size--;
                }
            }
        }
        return list2;
    }

    /* access modifiers changed from: protected */
    public Map<String, ResolveInfo> D0(List<ResolveInfo> list, List<String> list2, Map<String, String> map, List<String> list3) {
        HashMap hashMap = new HashMap();
        for (ResolveInfo next : list) {
            String lowerCase = String.valueOf(next.loadLabel(this.f13791b)).toLowerCase();
            if (list2.contains(lowerCase)) {
                hashMap.put(lowerCase, next);
            } else if (map != null && map.containsKey(lowerCase)) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(" : activityInfo : ");
                sb2.append(next.activityInfo.packageName);
                if (next.activityInfo.packageName.startsWith(map.get(lowerCase))) {
                    hashMap.put(lowerCase, next);
                }
            }
        }
        B0(hashMap);
        E0(hashMap, list3);
        M0(hashMap, list3);
        return hashMap;
    }

    /* access modifiers changed from: protected */
    public void E0(Map<String, ResolveInfo> map, List<String> list) {
        list.removeIf(new m5(map));
    }

    /* access modifiers changed from: protected */
    public List<ResolveInfo> F0(Intent... intentArr) {
        ArrayList arrayList = new ArrayList();
        for (Intent queryIntentActivities : intentArr) {
            arrayList.addAll(this.f13791b.queryIntentActivities(queryIntentActivities, 65536));
        }
        return arrayList;
    }

    /* access modifiers changed from: protected */
    public ResolveInfo G0() {
        List<ResolveInfo> queryIntentActivities = requireContext().getPackageManager().queryIntentActivities(new Intent("android.intent.action.SENDTO", Uri.parse("smsto:")), 65536);
        if (queryIntentActivities != null && queryIntentActivities.size() > 2) {
            queryIntentActivities.sort(new n5());
            return null;
        } else if (queryIntentActivities == null || queryIntentActivities.size() != 1) {
            return null;
        } else {
            return queryIntentActivities.get(0);
        }
    }

    /* access modifiers changed from: protected */
    public ResolveInfo H0() {
        String defaultSmsPackage = Telephony.Sms.getDefaultSmsPackage(getContext());
        if (TextUtils.isEmpty(defaultSmsPackage)) {
            return G0();
        }
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setPackage(defaultSmsPackage);
        intent.setType("text/plain");
        return this.f13791b.resolveActivity(intent, 65536);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f13791b = requireActivity().getPackageManager();
        if (getArguments() != null) {
            this.f13793d = getArguments().getInt(Extra.ID_TITLE, 0);
            this.f13794e = getArguments().getInt(Extra.ID_TEXT, 0);
            this.f13799k = getArguments().getCharSequence(Extra.EMAIL_HTML_TEXT);
            this.f13798j = getArguments().getString("message");
            this.f13792c = getArguments().getBoolean(Extra.SHOULD_SHOW_ICON, true);
            this.f13797h = getArguments().getString("source");
            this.f13795f = getArguments().getInt(Extra.EMAIL_SUBJECT_ID);
            this.f13796g = getArguments().getInt("request_code");
            this.f13800l = getArguments().getString(Extra.REDEEM_DEEPLINK, (String) null);
            this.f13801m = getArguments().getBoolean(Extra.IS_GIVE, false);
        }
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(R.layout.fragment_share_grid_dls, viewGroup, false);
    }

    public void onResume() {
        super.onResume();
        Bakery.w().z().f("Invite Composer");
    }

    public void onViewCreated(@NonNull View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        ImageView imageView = (ImageView) view.findViewById(R.id.imageView_bean);
        if (this.f13792c) {
            imageView.setVisibility(0);
        } else {
            imageView.setVisibility(4);
        }
        if (this.f13793d > 0) {
            ((TextView) view.findViewById(R.id.textView_title)).setText(this.f13793d);
        }
        if (this.f13794e > 0) {
            ((TextView) view.findViewById(R.id.textView_text)).setText(this.f13794e);
        }
        if (this.f13801m) {
            ((TextView) view.findViewById(R.id.text_with)).setText(R.string.give_with);
        }
        this.f13790a = (RecyclerView) view.findViewById(R.id.share_recycler);
        List<ResolveInfo> F0 = F0(m.e());
        List<String> c10 = m.c();
        Map<String, ResolveInfo> D0 = D0(F0, m.f15375c, m.f15376d, c10);
        List<String> C0 = C0(m.f15377e, 9, c10);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext(), 3);
        this.f13790a.setLayoutManager(gridLayoutManager);
        l lVar = new l(getActivity(), D0, C0, this.f13797h, this.f13799k, this.f13795f, this.f13798j, this.f13796g, this.f13800l);
        this.f13790a.setAdapter(lVar);
        gridLayoutManager.e3(new a(lVar, gridLayoutManager));
        HashMap hashMap = new HashMap();
        hashMap.put("source", this.f13797h);
        hashMap.put(MamElements.MamResultExtension.ELEMENT, "clicked");
        Bakery.w().z().j("Invite Composer", hashMap);
    }
}
