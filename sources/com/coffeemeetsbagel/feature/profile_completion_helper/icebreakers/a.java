package com.coffeemeetsbagel.feature.profile_completion_helper.icebreakers;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.h;
import androidx.lifecycle.i0;
import androidx.lifecycle.l0;
import androidx.lifecycle.m;
import androidx.lifecycle.u;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.cmb_views.CmbEditText;
import com.coffeemeetsbagel.feature.profile_completion_helper.ProfileCompletionHelperActivity;
import com.coffeemeetsbagel.feature.profile_completion_helper.f;
import com.coffeemeetsbagel.models.dto.Answer;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import java.util.Iterator;
import java.util.List;
import k6.k;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.j;

public final class a extends Fragment implements f {

    /* renamed from: d  reason: collision with root package name */
    public static final C0140a f13263d = new C0140a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public c f13264a;

    /* renamed from: b  reason: collision with root package name */
    public IcebreakersViewModel f13265b;

    /* renamed from: c  reason: collision with root package name */
    public k f13266c;

    /* renamed from: com.coffeemeetsbagel.feature.profile_completion_helper.icebreakers.a$a  reason: collision with other inner class name */
    public static final class C0140a {
        private C0140a() {
        }

        public /* synthetic */ C0140a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final a a() {
            return new a();
        }
    }

    public static final class b implements u<List<? extends QuestionWAnswers>> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f13267a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f13268b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ a f13269c;

        b(TextView textView, int i10, a aVar) {
            this.f13267a = textView;
            this.f13268b = i10;
            this.f13269c = aVar;
        }

        /* renamed from: a */
        public void b(List<QuestionWAnswers> list) {
            boolean z10;
            String str;
            j.g(list, "value");
            CharSequence text = this.f13267a.getText();
            if (text == null || text.length() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (z10) {
                TextView textView = this.f13267a;
                QuestionWAnswers questionWAnswers = (QuestionWAnswers) CollectionsKt___CollectionsKt.Q(list, this.f13268b);
                if (questionWAnswers != null) {
                    str = this.f13269c.B0(questionWAnswers);
                } else {
                    str = null;
                }
                textView.setText(str);
                return;
            }
            this.f13269c.C0().h().n(this);
        }
    }

    /* access modifiers changed from: private */
    public final String B0(QuestionWAnswers questionWAnswers) {
        List<Answer> d10;
        Answer answer;
        if (questionWAnswers == null || (d10 = questionWAnswers.d()) == null || (answer = (Answer) CollectionsKt___CollectionsKt.P(d10)) == null) {
            return null;
        }
        return answer.getTextValue();
    }

    private final void G0(TextView textView, int i10) {
        C0().h().i(getViewLifecycleOwner(), new b(textView, i10, this));
    }

    public final k A0() {
        k kVar = this.f13266c;
        if (kVar != null) {
            return kVar;
        }
        j.y("binding");
        return null;
    }

    public final IcebreakersViewModel C0() {
        IcebreakersViewModel icebreakersViewModel = this.f13265b;
        if (icebreakersViewModel != null) {
            return icebreakersViewModel;
        }
        j.y("viewModel");
        return null;
    }

    public final c D0() {
        c cVar = this.f13264a;
        if (cVar != null) {
            return cVar;
        }
        j.y("viewModelFactory");
        return null;
    }

    public final void E0(k kVar) {
        j.g(kVar, "<set-?>");
        this.f13266c = kVar;
    }

    public final void F0(IcebreakersViewModel icebreakersViewModel) {
        j.g(icebreakersViewModel, "<set-?>");
        this.f13265b = icebreakersViewModel;
    }

    public void d() {
        String str;
        String str2;
        String str3;
        boolean z10;
        String[] strArr = new String[3];
        Editable text = A0().f15774b.getText();
        Object obj = null;
        if (text != null) {
            str = text.toString();
        } else {
            str = null;
        }
        boolean z11 = false;
        strArr[0] = str;
        Editable text2 = A0().f15775c.getText();
        if (text2 != null) {
            str2 = text2.toString();
        } else {
            str2 = null;
        }
        strArr[1] = str2;
        Editable text3 = A0().f15776d.getText();
        if (text3 != null) {
            str3 = text3.toString();
        } else {
            str3 = null;
        }
        strArr[2] = str3;
        List m10 = q.m(strArr);
        Iterator it = m10.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            String str4 = (String) next;
            if (str4 == null || str4.length() == 0) {
                z10 = true;
            } else {
                z10 = false;
            }
            if (!z10) {
                obj = next;
                break;
            }
        }
        if (obj != null) {
            z11 = true;
        }
        if (z11) {
            IcebreakersViewModel C0 = C0();
            h requireActivity = requireActivity();
            j.f(requireActivity, "requireActivity()");
            C0.j(m.a(requireActivity), m10);
            h requireActivity2 = requireActivity();
            j.e(requireActivity2, "null cannot be cast to non-null type com.coffeemeetsbagel.feature.profile_completion_helper.ProfileCompletionHelperActivity");
            ((ProfileCompletionHelperActivity) requireActivity2).next();
            return;
        }
        View requireView = requireView();
        j.f(requireView, "requireView()");
        sb.a.k(requireView, R.string.error_icebreaker_required);
    }

    public void onCreate(Bundle bundle) {
        Bakery.j().Y1(this);
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.g(layoutInflater, "inflater");
        F0((IcebreakersViewModel) new i0((l0) this, (i0.b) D0()).a(IcebreakersViewModel.class));
        k c10 = k.c(layoutInflater, viewGroup, false);
        j.f(c10, "inflate(inflater, container, false)");
        E0(c10);
        A0().f15777e.setVisibility(0);
        A0().f15781j.setText(getString(R.string.onboarding_title_icebreakers));
        A0().f15780h.setText(getString(R.string.onboarding_prompt_icebreakers));
        CmbEditText cmbEditText = A0().f15774b;
        j.f(cmbEditText, "binding.editText0");
        G0(cmbEditText, 0);
        CmbEditText cmbEditText2 = A0().f15775c;
        j.f(cmbEditText2, "binding.editText1");
        G0(cmbEditText2, 1);
        CmbEditText cmbEditText3 = A0().f15776d;
        j.f(cmbEditText3, "binding.editText2");
        G0(cmbEditText3, 2);
        ScrollView b10 = A0().getRoot();
        j.f(b10, "binding.root");
        return b10;
    }
}
