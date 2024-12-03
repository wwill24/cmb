package com.coffeemeetsbagel.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import j5.x;
import q5.l;
import q5.m;
import qj.q;

public class b0 extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private CmbTextView f12084a;

    /* renamed from: b  reason: collision with root package name */
    private CmbTextView f12085b;

    /* renamed from: c  reason: collision with root package name */
    private CmbTextView f12086c;

    /* renamed from: d  reason: collision with root package name */
    private CmbTextView f12087d;

    /* renamed from: e  reason: collision with root package name */
    private final boolean f12088e;

    public b0(Context context, int i10, int i11, int i12) {
        this(context, i10, i11, i12, false);
    }

    private void e() {
        Window window = getWindow();
        if (window != null) {
            window.requestFeature(1);
            getWindow().setBackgroundDrawableResource(17170445);
        }
        setContentView(m.dialog_single_button_dls);
    }

    public q<x> a() {
        return (this.f12088e ? this.f12086c : this.f12087d).s();
    }

    public void b(View.OnClickListener onClickListener) {
        if (this.f12088e) {
            this.f12086c.setOnClickListener(onClickListener);
        } else {
            this.f12087d.setOnClickListener(onClickListener);
        }
    }

    public void c(String str) {
        int i10;
        CmbTextView cmbTextView = this.f12085b;
        if (TextUtils.isEmpty(str)) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        cmbTextView.setVisibility(i10);
        this.f12085b.setText(str);
    }

    public void d(String str) {
        int i10;
        CmbTextView cmbTextView = this.f12084a;
        if (TextUtils.isEmpty(str)) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        cmbTextView.setVisibility(i10);
        this.f12084a.setText(str);
    }

    public b0(Context context, int i10, int i11, int i12, boolean z10) {
        super(context);
        this.f12088e = z10;
        e();
        this.f12085b = (CmbTextView) findViewById(l.dialog_stacked_buttons_text);
        this.f12084a = (CmbTextView) findViewById(l.dialog_stacked_buttons_title);
        this.f12087d = (CmbTextView) findViewById(l.primary_button);
        this.f12086c = (CmbTextView) findViewById(l.destructive_button);
        d(context.getString(i10));
        c(context.getString(i11));
        this.f12086c.setText(i12);
        int i13 = 0;
        this.f12086c.setVisibility(z10 ? 0 : 8);
        this.f12087d.setText(i12);
        this.f12087d.setVisibility(z10 ? 8 : i13);
    }
}
