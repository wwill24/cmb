package com.coffeemeetsbagel.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.text.TextUtils;
import android.view.Window;
import android.widget.ImageView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import j5.x;
import qj.q;

@Deprecated
public class s extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    private CmbTextView f12150a;

    /* renamed from: b  reason: collision with root package name */
    private CmbTextView f12151b;

    /* renamed from: c  reason: collision with root package name */
    private CmbTextView f12152c;

    /* renamed from: d  reason: collision with root package name */
    private CmbTextView f12153d;

    /* renamed from: e  reason: collision with root package name */
    private CmbTextView f12154e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f12155f;

    /* renamed from: g  reason: collision with root package name */
    private final boolean f12156g;

    public s(Context context, int i10, int i11, int i12, int i13, boolean z10) {
        this(context, context.getString(i10), context.getString(i11), i12, i13, z10);
    }

    private void e() {
        Window window = getWindow();
        if (window != null) {
            window.requestFeature(1);
            getWindow().setBackgroundDrawableResource(17170445);
        }
        setContentView(R.layout.dialog_stacked_buttons_dls);
    }

    public q<x> a() {
        return (this.f12156g ? this.f12152c : this.f12153d).s();
    }

    public q<x> b() {
        return this.f12154e.s();
    }

    public void c(String str) {
        int i10;
        CmbTextView cmbTextView = this.f12151b;
        if (TextUtils.isEmpty(str)) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        cmbTextView.setVisibility(i10);
        this.f12151b.setText(str);
    }

    public void d(String str) {
        int i10;
        CmbTextView cmbTextView = this.f12150a;
        if (TextUtils.isEmpty(str)) {
            i10 = 8;
        } else {
            i10 = 0;
        }
        cmbTextView.setVisibility(i10);
        this.f12150a.setText(str);
    }

    public s(Context context, String str, String str2, int i10, int i11, boolean z10) {
        super(context);
        this.f12156g = z10;
        e();
        this.f12151b = (CmbTextView) findViewById(R.id.dialog_stacked_buttons_text);
        this.f12150a = (CmbTextView) findViewById(R.id.dialog_stacked_buttons_title);
        this.f12153d = (CmbTextView) findViewById(R.id.primary_button);
        this.f12154e = (CmbTextView) findViewById(R.id.secondary_button);
        this.f12152c = (CmbTextView) findViewById(R.id.destructive_button);
        this.f12155f = (ImageView) findViewById(R.id.image);
        d(str);
        c(str2);
        this.f12152c.setText(i10);
        int i12 = 0;
        this.f12152c.setVisibility(z10 ? 0 : 8);
        this.f12153d.setText(i10);
        this.f12153d.setVisibility(z10 ? 8 : i12);
        this.f12154e.setText(i11);
    }
}
