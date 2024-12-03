package f8;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.feature.likepassflow.ActivityLikePassFlow;
import com.coffeemeetsbagel.fragments.d;
import com.coffeemeetsbagel.models.enums.EventType;
import com.google.firebase.analytics.FirebaseAnalytics;
import h5.i;
import java.util.ArrayList;
import sb.a;

public class g0 extends d {
    public static boolean e1() {
        ArrayList<String> icebreakers = Bakery.w().G().j().getIcebreakers();
        if ((icebreakers.size() < 1 || TextUtils.isEmpty(icebreakers.get(0))) && ((icebreakers.size() < 2 || TextUtils.isEmpty(icebreakers.get(1))) && (icebreakers.size() < 3 || TextUtils.isEmpty(icebreakers.get(2))))) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public String Q0() {
        return "Ice Breaker";
    }

    public void V0() {
        C0().f("Onboarding - Ice Breaker");
    }

    public boolean b0(boolean z10) {
        if (!TextUtils.isEmpty(this.f13628t) || !TextUtils.isEmpty(this.f13629w) || !TextUtils.isEmpty(this.f13630x)) {
            M0().j().setIcebreakers(this.f13628t, this.f13629w, this.f13630x);
            i.b(EventType.PROFILE_UPDATE);
            ((ActivityLikePassFlow) requireActivity()).Y().updateIcebreakers(this.f13628t, this.f13629w, this.f13630x);
            return true;
        } else if (!z10) {
            return false;
        } else {
            a.k(this.f13631y, R.string.error_icebreaker_required);
            return false;
        }
    }

    public void onCreate(Bundle bundle) {
        if (bundle == null) {
            this.f13627q = M0().j().getIcebreakers();
        } else {
            this.f13627q = (ArrayList) bundle.getSerializable(FirebaseAnalytics.Param.ITEMS);
        }
        super.onCreate(bundle);
    }

    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.f13631y.findViewById(R.id.imageView_private).setVisibility(0);
        this.f13622k.setHint(R.string.icebreaker_hint0);
        this.f13623l.setHint(R.string.icebreaker_hint1);
        this.f13624m.setHint(R.string.icebreaker_hint2);
        this.f13625n.setText(R.string.onboarding_title_icebreakers);
        this.f13626p.setText(R.string.onboarding_prompt_icebreakers);
        return this.f13631y;
    }
}
