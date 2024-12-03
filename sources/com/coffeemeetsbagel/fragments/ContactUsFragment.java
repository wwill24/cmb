package com.coffeemeetsbagel.fragments;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.h;
import androidx.lifecycle.m;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.activities.ActivityContactUs;
import com.coffeemeetsbagel.cmb_views.CmbEditText;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.jvm.internal.j;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.s1;
import ma.d;

public final class ContactUsFragment extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    public d f13510a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final String f13511b;

    public static final class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ContactUsFragment f13512a;

        public a(ContactUsFragment contactUsFragment) {
            this.f13512a = contactUsFragment;
        }

        public void afterTextChanged(Editable editable) {
            int i10;
            String obj;
            String obj2;
            boolean z10 = false;
            if (editable == null || (obj = editable.toString()) == null || (obj2 = StringsKt__StringsKt.W0(obj).toString()) == null) {
                i10 = 0;
            } else {
                i10 = obj2.length();
            }
            h requireActivity = this.f13512a.requireActivity();
            j.e(requireActivity, "null cannot be cast to non-null type com.coffeemeetsbagel.activities.ActivityContactUs");
            ActivityContactUs activityContactUs = (ActivityContactUs) requireActivity;
            if (i10 > 0) {
                z10 = true;
            }
            activityContactUs.E1(z10);
        }

        public void beforeTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }

        public void onTextChanged(CharSequence charSequence, int i10, int i11, int i12) {
        }
    }

    public ContactUsFragment() {
        String simpleName = ContactUsFragment.class.getSimpleName();
        j.f(simpleName, "ContactUsFragment::class.java.simpleName");
        this.f13511b = simpleName;
    }

    public final d A0() {
        d dVar = this.f13510a;
        if (dVar != null) {
            return dVar;
        }
        j.y("feedbackService");
        return null;
    }

    public final void B0() {
        CmbEditText cmbEditText;
        String str;
        boolean z10;
        String str2;
        Editable text;
        CharSequence W0;
        View view = getView();
        if (view != null) {
            cmbEditText = (CmbEditText) view.findViewById(R.id.feedback_edit_text);
        } else {
            cmbEditText = null;
        }
        if (cmbEditText == null || (text = cmbEditText.getText()) == null || (W0 = StringsKt__StringsKt.W0(text)) == null) {
            str = null;
        } else {
            str = W0.toString();
        }
        if (str == null || str.length() == 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10) {
            Bundle arguments = getArguments();
            if (arguments != null) {
                str2 = arguments.getString("source");
            } else {
                str2 = null;
            }
            s1 unused = j.d(m.a(this), (CoroutineContext) null, (CoroutineStart) null, new ContactUsFragment$sendFeedback$1(str, str2, this, (c<? super ContactUsFragment$sendFeedback$1>) null), 3, (Object) null);
        }
        lc.c.a(getActivity());
        if (cmbEditText != null) {
            cmbEditText.setText((CharSequence) null);
        }
        if (isAdded()) {
            requireActivity().setResult(-1);
            requireActivity().finish();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.g(layoutInflater, "inflater");
        View inflate = getLayoutInflater().inflate(R.layout.fragment_contact_us_dls, viewGroup, false);
        ((CmbEditText) inflate.findViewById(R.id.feedback_edit_text)).requestFocus();
        return inflate;
    }

    public void onViewCreated(View view, Bundle bundle) {
        j.g(view, "view");
        super.onViewCreated(view, bundle);
        View findViewById = view.findViewById(R.id.feedback_edit_text);
        j.f(findViewById, "view.findViewById<CmbEdi…(R.id.feedback_edit_text)");
        ((TextView) findViewById).addTextChangedListener(new a(this));
    }
}
