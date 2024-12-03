package f8;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextPaint;
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
import com.coffeemeetsbagel.models.enums.Ethnicity;
import com.coffeemeetsbagel.models.util.StringUtils;
import com.mparticle.kits.AppsFlyerKit;
import j5.n;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import lc.c;

public class b0 extends n {

    /* renamed from: k  reason: collision with root package name */
    private ArrayList<String> f14871k;

    /* renamed from: l  reason: collision with root package name */
    private View f14872l;

    /* renamed from: m  reason: collision with root package name */
    private List<RowItemView> f14873m;

    /* renamed from: n  reason: collision with root package name */
    private DialogPrimarySecondaryVertical f14874n;

    /* renamed from: p  reason: collision with root package name */
    private tj.a f14875p;

    class a extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f14876a;

        a(int i10) {
            this.f14876a = i10;
        }

        public void onClick(@NonNull View view) {
            CmbLinks.Companion.launchTermsAndConditions(b0.this.getActivity());
        }

        public void updateDrawState(@NonNull TextPaint textPaint) {
            super.updateDrawState(textPaint);
            textPaint.setColor(this.f14876a);
        }
    }

    public static boolean Y0() {
        if (new ArrayList(Bakery.w().G().j().getEthnicityAsApiParamsList()).size() > 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Z0(Ethnicity ethnicity, View view) {
        c1(ethnicity);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Unit b1() {
        ((ActivityLikePassFlow) requireActivity()).next();
        return null;
    }

    private void c1(Ethnicity ethnicity) {
        String apiParam = ethnicity.getApiParam();
        if (this.f14871k.contains(apiParam)) {
            this.f14871k.remove(apiParam);
        } else {
            this.f14871k.add(apiParam);
        }
        for (RowItemView next : this.f14873m) {
            next.setChecked(this.f14871k.contains(next.getText()));
        }
        ((ActivityLikePassFlow) requireActivity()).Y().updateEthnicity(StringUtils.join(this.f14871k, AppsFlyerKit.COMMA));
        M0().j().setEthnicity(Ethnicity.assemble(this.f14871k));
    }

    /* access modifiers changed from: protected */
    public String Q0() {
        return "Ethnicity";
    }

    public void V0() {
        C0().f("Onboarding - Ethnicity");
    }

    public boolean b0(boolean z10) {
        ArrayList<String> arrayList = this.f14871k;
        if (arrayList != null && (arrayList.size() > 0 || !z10 || G0().a("Privacy.GdprCopy.Android"))) {
            return true;
        }
        sb.a.k(this.f14872l, R.string.error_ethnicity_required);
        return true;
    }

    public void d() {
        ArrayList<String> arrayList = this.f14871k;
        if (arrayList != null && arrayList.size() > 0) {
            S0();
        } else if (G0().a("Privacy.GdprCopy.Android")) {
            DialogPrimarySecondaryVertical.f12065a.a(requireContext(), DialogPrimarySecondaryVertical.PrimaryCtaStyle.NORMAL, (Integer) null, R.string.like_flow_ethnicity_empty_title, R.string.like_flow_ethnicity_empty_prompt, R.string.continue_lc, new a0(this), Integer.valueOf(R.string.go_back), (Function0<Unit>) null, (Function0<Unit>) null);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            this.f14871k = new ArrayList<>(M0().j().getEthnicityAsApiParamsList());
        } else {
            this.f14871k = (ArrayList) bundle.getSerializable("ethnicity_api_params");
        }
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_my_profile_list_dls, viewGroup, false);
        this.f14872l = inflate;
        LinearLayout linearLayout = (LinearLayout) inflate.findViewById(R.id.fragment_my_profile_disclaimer_list_holder);
        this.f14873m = new ArrayList();
        for (Ethnicity ethnicity : Ethnicity.values()) {
            RowItemView rowItemView = (RowItemView) layoutInflater.inflate(R.layout.row_view_cmb_dls, linearLayout, false);
            rowItemView.setText(ethnicity.getApiParam());
            rowItemView.setOnClickListener(new z(this, ethnicity));
            this.f14873m.add(rowItemView);
            linearLayout.addView(rowItemView);
        }
        ((CmbTextView) this.f14872l.findViewById(R.id.textView_title)).setText(R.string.onboarding_title_ethnicity_dls);
        if (G0().a("Privacy.GdprCopy.Android")) {
            TextView textView = (TextView) this.f14872l.findViewById(R.id.fragment_my_profile_disclaimer_textview);
            textView.setVisibility(0);
            String string = getString(R.string.privacy_policy);
            SpannableString spannableString = new SpannableString(getString(R.string.like_flow_ethnicity_disclaimer, string));
            int indexOf = spannableString.toString().indexOf(string);
            spannableString.setSpan(new a(getResources().getColor(R.color.main_color)), indexOf, string.length() + indexOf, 18);
            textView.setText(spannableString);
            textView.setClickable(true);
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        return this.f14872l;
    }

    public void onResume() {
        super.onResume();
        sb.a.k(this.f14872l, R.string.tip);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putSerializable("ethnicity_api_params", this.f14871k);
    }

    public void onStart() {
        super.onStart();
        this.f14875p = new tj.a();
    }

    public void onStop() {
        super.onStop();
        this.f14875p.dispose();
        c.h(this.f14874n);
    }
}
