package com.coffeemeetsbagel.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import androidx.annotation.NonNull;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbEditText;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.feature.likepassflow.ActivityLikePassFlow;
import com.coffeemeetsbagel.models.util.CollectionUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import j5.n;
import java.util.ArrayList;
import java.util.List;
import lc.c;

public abstract class d extends n {

    /* renamed from: k  reason: collision with root package name */
    public CmbEditText f13622k;

    /* renamed from: l  reason: collision with root package name */
    public CmbEditText f13623l;

    /* renamed from: m  reason: collision with root package name */
    public CmbEditText f13624m;

    /* renamed from: n  reason: collision with root package name */
    public CmbTextView f13625n;

    /* renamed from: p  reason: collision with root package name */
    public CmbTextView f13626p;

    /* renamed from: q  reason: collision with root package name */
    public ArrayList<String> f13627q;

    /* renamed from: t  reason: collision with root package name */
    public String f13628t;

    /* renamed from: w  reason: collision with root package name */
    public String f13629w;

    /* renamed from: x  reason: collision with root package name */
    public String f13630x;

    /* renamed from: y  reason: collision with root package name */
    protected View f13631y;

    private static class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        private final EditText f13632a;

        /* renamed from: b  reason: collision with root package name */
        private final C0146a f13633b;

        /* renamed from: com.coffeemeetsbagel.fragments.d$a$a  reason: collision with other inner class name */
        interface C0146a {
            void a(String str);
        }

        a(EditText editText, C0146a aVar) {
            this.f13632a = editText;
            this.f13633b = aVar;
        }

        public void afterTextChanged(Editable editable) {
            this.f13633b.a(this.f13632a.getText().toString());
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Z0(String str) {
        this.f13628t = str;
        d1();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b1(String str) {
        this.f13629w = str;
        d1();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c1(String str) {
        this.f13630x = str;
        d1();
    }

    private void d1() {
        ((ActivityLikePassFlow) requireActivity()).X(b0(false), this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (!CollectionUtils.isEmpty((List) this.f13627q)) {
            if (this.f13627q.size() > 0) {
                this.f13628t = this.f13627q.get(0);
            }
            if (this.f13627q.size() > 1) {
                this.f13629w = this.f13627q.get(1);
            }
            if (this.f13627q.size() > 2) {
                this.f13630x = this.f13627q.get(2);
            }
        }
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_icebreakers, viewGroup, false);
        this.f13631y = inflate;
        this.f13625n = (CmbTextView) inflate.findViewById(R.id.textView_title);
        this.f13626p = (CmbTextView) this.f13631y.findViewById(R.id.textView_prompt);
        this.f13622k = (CmbEditText) this.f13631y.findViewById(R.id.editText0);
        this.f13623l = (CmbEditText) this.f13631y.findViewById(R.id.editText1);
        this.f13624m = (CmbEditText) this.f13631y.findViewById(R.id.editText2);
        CmbEditText cmbEditText = this.f13622k;
        cmbEditText.addTextChangedListener(new a(cmbEditText, new a(this)));
        CmbEditText cmbEditText2 = this.f13623l;
        cmbEditText2.addTextChangedListener(new a(cmbEditText2, new b(this)));
        CmbEditText cmbEditText3 = this.f13624m;
        cmbEditText3.addTextChangedListener(new a(cmbEditText3, new c(this)));
        return this.f13631y;
    }

    public void onResume() {
        super.onResume();
        if (isAdded()) {
            c.e(requireActivity());
        }
        if (!TextUtils.isEmpty(this.f13628t)) {
            this.f13622k.setText(this.f13628t);
        }
        if (!TextUtils.isEmpty(this.f13629w)) {
            this.f13623l.setText(this.f13629w);
        }
        if (!TextUtils.isEmpty(this.f13630x)) {
            this.f13624m.setText(this.f13630x);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable(FirebaseAnalytics.Param.ITEMS, this.f13627q);
    }
}
