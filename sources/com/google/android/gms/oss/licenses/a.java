package com.google.android.gms.oss.licenses;

import android.widget.ScrollView;
import android.widget.TextView;

final class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ int f40529a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ ScrollView f40530b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ OssLicensesActivity f40531c;

    a(OssLicensesActivity ossLicensesActivity, int i10, ScrollView scrollView) {
        this.f40531c = ossLicensesActivity;
        this.f40529a = i10;
        this.f40530b = scrollView;
    }

    public final void run() {
        TextView textView = (TextView) this.f40531c.findViewById(xe.a.license_activity_textview);
        this.f40530b.scrollTo(0, textView.getLayout().getLineTop(textView.getLayout().getLineForOffset(this.f40529a)));
    }
}
