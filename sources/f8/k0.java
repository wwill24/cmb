package f8;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.dialogs.DialogPrimarySecondaryVertical;
import com.coffeemeetsbagel.external_links.CmbLinks;
import com.coffeemeetsbagel.feature.likepassflow.ActivityLikePassFlow;
import com.coffeemeetsbagel.feature.likepassflow.RowItemView;
import com.coffeemeetsbagel.models.enums.Religion;
import j5.n;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import lc.c;

public class k0 extends n {

    /* renamed from: k  reason: collision with root package name */
    private String f14909k;

    /* renamed from: l  reason: collision with root package name */
    private View f14910l;

    /* renamed from: m  reason: collision with root package name */
    private List<RowItemView> f14911m;

    /* renamed from: n  reason: collision with root package name */
    private DialogPrimarySecondaryVertical f14912n;

    /* renamed from: p  reason: collision with root package name */
    private tj.a f14913p;

    class a extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f14914a;

        a(int i10) {
            this.f14914a = i10;
        }

        public void onClick(@NonNull View view) {
            CmbLinks.Companion.launchTermsAndConditions(k0.this.getActivity());
        }

        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(this.f14914a);
        }
    }

    public static boolean Y0() {
        return !TextUtils.isEmpty(Bakery.w().G().j().getReligionApiParam());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Z0(Religion religion, View view) {
        c1(religion);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit b1() {
        ((ActivityLikePassFlow) requireActivity()).next();
        return null;
    }

    private void c1(Religion religion) {
        if (religion.getApiParam().equals(this.f14909k)) {
            this.f14909k = "";
        } else {
            this.f14909k = religion.getApiParam();
        }
        for (RowItemView next : this.f14911m) {
            next.setChecked(this.f14909k.equals(next.getText()));
        }
        M0().j().setReligion(this.f14909k);
        this.f15616e.updateReligion(this.f14909k);
    }

    /* access modifiers changed from: protected */
    public String Q0() {
        return "Religion";
    }

    public void V0() {
        C0().f("Onboarding - Religion");
    }

    public boolean b0(boolean z10) {
        if (!TextUtils.isEmpty(this.f14909k) || !z10 || G0().a("Privacy.GdprCopy.Android")) {
            return true;
        }
        sb.a.k(this.f14910l, R.string.error_religion_required);
        return true;
    }

    public void d() {
        if (!TextUtils.isEmpty(this.f14909k)) {
            S0();
        } else if (G0().a("Privacy.GdprCopy.Android")) {
            DialogPrimarySecondaryVertical.f12065a.a(requireContext(), DialogPrimarySecondaryVertical.PrimaryCtaStyle.NORMAL, (Integer) null, R.string.like_flow_religion_empty_title, R.string.like_flow_religion_empty_prompt, R.string.continue_lc, new j0(this), Integer.valueOf(R.string.go_back), (Function0<Unit>) null, (Function0<Unit>) null);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.f14909k = M0().j().getReligionApiParam();
        } else {
            this.f14909k = bundle.getString("religion_api_param");
        }
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_my_profile_list_dls, viewGroup, false);
        this.f14910l = inflate;
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.fragment_my_profile_disclaimer_list_holder);
        this.f14911m = new ArrayList();
        for (Religion religion : Religion.values()) {
            RowItemView rowItemView = (RowItemView) layoutInflater.inflate(R.layout.row_view_cmb_dls, linearLayout, false);
            rowItemView.setText(religion.getApiParam());
            rowItemView.setOnClickListener(new i0(this, religion));
            this.f14911m.add(rowItemView);
            linearLayout.addView(rowItemView);
        }
        ((CmbTextView) this.f14910l.findViewById(R.id.textView_title)).setText(R.string.onboarding_title_religion_dls);
        if (G0().a("Privacy.GdprCopy.Android")) {
            TextView textView = (TextView) this.f14910l.findViewById(R.id.fragment_my_profile_disclaimer_textview);
            String string = getString(R.string.privacy_policy);
            SpannableString spannableString = new SpannableString(getString(R.string.like_flow_religion_disclaimer, string));
            int indexOf = spannableString.toString().indexOf(string);
            spannableString.setSpan(new a(getResources().getColor(R.color.main_color)), indexOf, string.length() + indexOf, 18);
            textView.setText(spannableString);
            textView.setClickable(true);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
            textView.setVisibility(0);
        }
        return this.f14910l;
    }

    public void onResume() {
        super.onResume();
        if (isAdded() && !isHidden()) {
            c.a(getActivity());
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("religion_api_param", this.f14909k);
    }

    public void onStart() {
        super.onStart();
        this.f14913p = new tj.a();
    }

    public void onStop() {
        super.onStop();
        this.f14913p.dispose();
        c.h(this.f14912n);
    }
}
