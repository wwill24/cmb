package com.clevertap.android.sdk.inbox;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.clevertap.android.sdk.CTInboxStyleConfig;
import com.clevertap.android.sdk.CleverTapAPI;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.p;
import i4.u;
import i4.v;
import i4.x;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class g extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    CleverTapInstanceConfig f10547a;

    /* renamed from: b  reason: collision with root package name */
    boolean f10548b = x.f15508a;

    /* renamed from: c  reason: collision with root package name */
    ArrayList<CTInboxMessage> f10549c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    LinearLayout f10550d;

    /* renamed from: e  reason: collision with root package name */
    j4.a f10551e;

    /* renamed from: f  reason: collision with root package name */
    RecyclerView f10552f;

    /* renamed from: g  reason: collision with root package name */
    private h f10553g;

    /* renamed from: h  reason: collision with root package name */
    CTInboxStyleConfig f10554h;

    /* renamed from: j  reason: collision with root package name */
    private boolean f10555j = true;

    /* renamed from: k  reason: collision with root package name */
    private WeakReference<b> f10556k;

    /* renamed from: l  reason: collision with root package name */
    private int f10557l;

    class a implements Runnable {
        a() {
        }

        public void run() {
            g.this.f10551e.P1();
        }
    }

    interface b {
        void E(Context context, CTInboxMessage cTInboxMessage, Bundle bundle, HashMap<String, String> hashMap, boolean z10);

        void r(Context context, CTInboxMessage cTInboxMessage, Bundle bundle);
    }

    private ArrayList<CTInboxMessage> B0(ArrayList<CTInboxMessage> arrayList, String str) {
        ArrayList<CTInboxMessage> arrayList2 = new ArrayList<>();
        Iterator<CTInboxMessage> it = arrayList.iterator();
        while (it.hasNext()) {
            CTInboxMessage next = it.next();
            if (next.h() != null && next.h().size() > 0) {
                for (String equalsIgnoreCase : next.h()) {
                    if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                        arrayList2.add(next);
                    }
                }
            }
        }
        return arrayList2;
    }

    private boolean J0() {
        return this.f10557l <= 0;
    }

    private void L0() {
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("filter", (String) null);
            CleverTapAPI F = CleverTapAPI.F(getActivity(), this.f10547a);
            if (F != null) {
                p.o("CTInboxListViewFragment:onAttach() called with: tabPosition = [" + this.f10557l + "], filter = [" + string + "]");
                ArrayList<CTInboxMessage> n10 = F.n();
                if (string != null) {
                    n10 = B0(n10, string);
                }
                this.f10549c = n10;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void A0(Bundle bundle, int i10) {
        b D0 = D0();
        if (D0 != null) {
            p.o("CTInboxListViewFragment:didShow() called with: data = [" + bundle + "], position = [" + i10 + "]");
            D0.r(getActivity().getBaseContext(), this.f10549c.get(i10), bundle);
        }
    }

    /* access modifiers changed from: package-private */
    public void C0(String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str.replace("\n", "").replace("\r", "")));
            if (getActivity() != null) {
                x.w(getActivity(), intent);
            }
            startActivity(intent);
        } catch (Throwable unused) {
        }
    }

    /* access modifiers changed from: package-private */
    public b D0() {
        b bVar;
        try {
            bVar = this.f10556k.get();
        } catch (Throwable unused) {
            bVar = null;
        }
        if (bVar == null) {
            p.o("InboxListener is null for messages");
        }
        return bVar;
    }

    /* access modifiers changed from: package-private */
    public j4.a E0() {
        return this.f10551e;
    }

    /* access modifiers changed from: package-private */
    public void F0(int i10, String str, org.json.b bVar, HashMap<String, String> hashMap, boolean z10) {
        boolean z11;
        try {
            Bundle bundle = new Bundle();
            org.json.b j10 = this.f10549c.get(i10).j();
            Iterator<String> keys = j10.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next.startsWith("wzrk_")) {
                    bundle.putString(next, j10.getString(next));
                }
            }
            if (str != null && !str.isEmpty()) {
                bundle.putString("wzrk_c2a", str);
            }
            z0(bundle, i10, hashMap, z10);
            if (hashMap == null || hashMap.isEmpty()) {
                z11 = false;
            } else {
                z11 = true;
            }
            if (bVar == null) {
                String a10 = this.f10549c.get(i10).e().get(0).a();
                if (a10 != null) {
                    C0(a10);
                }
            } else if (z11) {
            } else {
                if (!this.f10549c.get(i10).e().get(0).l(bVar).equalsIgnoreCase("copy")) {
                    String j11 = this.f10549c.get(i10).e().get(0).j(bVar);
                    if (j11 != null) {
                        C0(j11);
                    }
                }
            }
        } catch (Throwable th2) {
            p.a("Error handling notification button click: " + th2.getCause());
        }
    }

    /* access modifiers changed from: package-private */
    public void G0(int i10, int i11, boolean z10) {
        try {
            Bundle bundle = new Bundle();
            org.json.b j10 = this.f10549c.get(i10).j();
            Iterator<String> keys = j10.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                if (next.startsWith("wzrk_")) {
                    bundle.putString(next, j10.getString(next));
                }
            }
            z0(bundle, i10, (HashMap<String, String>) null, z10);
            C0(this.f10549c.get(i10).e().get(i11).a());
        } catch (Throwable th2) {
            p.a("Error handling notification button click: " + th2.getCause());
        }
    }

    /* access modifiers changed from: package-private */
    public void H0(b bVar) {
        this.f10556k = new WeakReference<>(bVar);
    }

    /* access modifiers changed from: package-private */
    public void I0(j4.a aVar) {
        this.f10551e = aVar;
    }

    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Bundle arguments = getArguments();
        if (arguments != null) {
            this.f10547a = (CleverTapInstanceConfig) arguments.getParcelable("config");
            this.f10554h = (CTInboxStyleConfig) arguments.getParcelable("styleConfig");
            this.f10557l = arguments.getInt("position", -1);
            L0();
            if (context instanceof CTInboxActivity) {
                H0((b) getActivity());
            }
        }
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(v.inbox_list_view, viewGroup, false);
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(u.list_view_linear_layout);
        this.f10550d = linearLayout;
        linearLayout.setBackgroundColor(Color.parseColor(this.f10554h.d()));
        TextView textView = (TextView) inflate.findViewById(u.list_view_no_message_view);
        if (this.f10549c.size() <= 0) {
            textView.setVisibility(0);
            textView.setText(this.f10554h.h());
            textView.setTextColor(Color.parseColor(this.f10554h.i()));
            return inflate;
        }
        textView.setVisibility(8);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        this.f10553g = new h(this.f10549c, this);
        if (this.f10548b) {
            j4.a aVar = new j4.a(getActivity());
            this.f10551e = aVar;
            I0(aVar);
            this.f10551e.setVisibility(0);
            this.f10551e.setLayoutManager(linearLayoutManager);
            this.f10551e.h(new j4.b(18));
            this.f10551e.setItemAnimator(new androidx.recyclerview.widget.g());
            this.f10551e.setAdapter(this.f10553g);
            this.f10553g.l();
            this.f10550d.addView(this.f10551e);
            if (this.f10555j && J0()) {
                new Handler(Looper.getMainLooper()).postDelayed(new a(), 1000);
                this.f10555j = false;
            }
        } else {
            RecyclerView recyclerView = (RecyclerView) inflate.findViewById(u.list_view_recycler_view);
            this.f10552f = recyclerView;
            recyclerView.setVisibility(0);
            this.f10552f.setLayoutManager(linearLayoutManager);
            this.f10552f.h(new j4.b(18));
            this.f10552f.setItemAnimator(new androidx.recyclerview.widget.g());
            this.f10552f.setAdapter(this.f10553g);
            this.f10553g.l();
        }
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
        j4.a aVar = this.f10551e;
        if (aVar != null) {
            aVar.Q1();
        }
    }

    public void onPause() {
        super.onPause();
        j4.a aVar = this.f10551e;
        if (aVar != null) {
            aVar.N1();
        }
    }

    public void onResume() {
        super.onResume();
        j4.a aVar = this.f10551e;
        if (aVar != null) {
            aVar.O1();
        }
    }

    public void onSaveInstanceState(@NonNull Bundle bundle) {
        super.onSaveInstanceState(bundle);
        j4.a aVar = this.f10551e;
        if (!(aVar == null || aVar.getLayoutManager() == null)) {
            bundle.putParcelable("recyclerLayoutState", this.f10551e.getLayoutManager().e1());
        }
        RecyclerView recyclerView = this.f10552f;
        if (recyclerView != null && recyclerView.getLayoutManager() != null) {
            bundle.putParcelable("recyclerLayoutState", this.f10552f.getLayoutManager().e1());
        }
    }

    public void onViewStateRestored(Bundle bundle) {
        super.onViewStateRestored(bundle);
        if (bundle != null) {
            Parcelable parcelable = bundle.getParcelable("recyclerLayoutState");
            j4.a aVar = this.f10551e;
            if (!(aVar == null || aVar.getLayoutManager() == null)) {
                this.f10551e.getLayoutManager().d1(parcelable);
            }
            RecyclerView recyclerView = this.f10552f;
            if (recyclerView != null && recyclerView.getLayoutManager() != null) {
                this.f10552f.getLayoutManager().d1(parcelable);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void z0(Bundle bundle, int i10, HashMap<String, String> hashMap, boolean z10) {
        b D0 = D0();
        if (D0 != null) {
            D0.E(getActivity().getBaseContext(), this.f10549c.get(i10), bundle, hashMap, z10);
        }
    }
}
