package com.clevertap.android.sdk.inapp;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import androidx.fragment.app.Fragment;
import com.clevertap.android.sdk.CleverTapInstanceConfig;
import com.clevertap.android.sdk.customviews.CloseImageView;
import com.clevertap.android.sdk.p;
import i4.x;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

public abstract class a extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    CloseImageView f10381a = null;

    /* renamed from: b  reason: collision with root package name */
    CleverTapInstanceConfig f10382b;

    /* renamed from: c  reason: collision with root package name */
    Context f10383c;

    /* renamed from: d  reason: collision with root package name */
    int f10384d;

    /* renamed from: e  reason: collision with root package name */
    CTInAppNotification f10385e;

    /* renamed from: f  reason: collision with root package name */
    AtomicBoolean f10386f = new AtomicBoolean();

    /* renamed from: g  reason: collision with root package name */
    private WeakReference<x> f10387g;

    /* renamed from: com.clevertap.android.sdk.inapp.a$a  reason: collision with other inner class name */
    class C0118a implements View.OnClickListener {
        C0118a() {
        }

        public void onClick(View view) {
            a.this.H0(((Integer) view.getTag()).intValue());
        }
    }

    /* access modifiers changed from: package-private */
    public void A0(Bundle bundle, HashMap<String, String> hashMap) {
        x F0 = F0();
        if (F0 != null) {
            F0.y(this.f10385e, bundle, hashMap);
        }
    }

    /* access modifiers changed from: package-private */
    public void B0(Bundle bundle) {
        z0();
        x F0 = F0();
        if (F0 != null && getActivity() != null && getActivity().getBaseContext() != null) {
            F0.D(getActivity().getBaseContext(), this.f10385e, bundle);
        }
    }

    /* access modifiers changed from: package-private */
    public void C0(Bundle bundle) {
        x F0 = F0();
        if (F0 != null) {
            F0.R(this.f10385e, bundle);
        }
    }

    /* access modifiers changed from: package-private */
    public void D0(String str, Bundle bundle) {
        try {
            Uri parse = Uri.parse(str.replace("\n", "").replace("\r", ""));
            Set<String> queryParameterNames = parse.getQueryParameterNames();
            Bundle bundle2 = new Bundle();
            if (queryParameterNames != null && !queryParameterNames.isEmpty()) {
                for (String next : queryParameterNames) {
                    bundle2.putString(next, parse.getQueryParameter(next));
                }
            }
            Intent intent = new Intent("android.intent.action.VIEW", parse);
            if (!bundle2.isEmpty()) {
                intent.putExtras(bundle2);
            }
            x.w(getActivity(), intent);
            startActivity(intent);
        } catch (Throwable unused) {
        }
        B0(bundle);
    }

    /* access modifiers changed from: package-private */
    public abstract void E0();

    /* access modifiers changed from: package-private */
    public x F0() {
        x xVar;
        try {
            xVar = this.f10387g.get();
        } catch (Throwable unused) {
            xVar = null;
        }
        if (xVar == null) {
            p n10 = this.f10382b.n();
            String e10 = this.f10382b.e();
            n10.t(e10, "InAppListener is null for notification: " + this.f10385e.s());
        }
        return xVar;
    }

    /* access modifiers changed from: package-private */
    public int G0(int i10) {
        return (int) TypedValue.applyDimension(1, (float) i10, getResources().getDisplayMetrics());
    }

    /* access modifiers changed from: package-private */
    public void H0(int i10) {
        try {
            CTInAppNotificationButton cTInAppNotificationButton = this.f10385e.g().get(i10);
            Bundle bundle = new Bundle();
            bundle.putString("wzrk_id", this.f10385e.h());
            bundle.putString("wzrk_c2a", cTInAppNotificationButton.g());
            A0(bundle, cTInAppNotificationButton.f());
            String a10 = cTInAppNotificationButton.a();
            if (a10 != null) {
                D0(a10, bundle);
            } else {
                B0(bundle);
            }
        } catch (Throwable th2) {
            p n10 = this.f10382b.n();
            n10.e("Error handling notification button click: " + th2.getCause());
            B0((Bundle) null);
        }
    }

    /* access modifiers changed from: package-private */
    public void I0(x xVar) {
        this.f10387g = new WeakReference<>(xVar);
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        this.f10383c = context;
        Bundle arguments = getArguments();
        this.f10385e = (CTInAppNotification) arguments.getParcelable("inApp");
        this.f10382b = (CleverTapInstanceConfig) arguments.getParcelable("config");
        this.f10384d = getResources().getConfiguration().orientation;
        E0();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        C0((Bundle) null);
    }

    /* access modifiers changed from: package-private */
    public abstract void z0();
}
