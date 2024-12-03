package com.coffeemeetsbagel.feature.profile_completion_helper.education;

import android.os.Bundle;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ScrollView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.h;
import androidx.lifecycle.g;
import androidx.lifecycle.i0;
import androidx.lifecycle.l0;
import androidx.lifecycle.m;
import androidx.lifecycle.u;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.dialogs.b;
import com.coffeemeetsbagel.dialogs.g0;
import com.coffeemeetsbagel.dialogs.h0;
import com.coffeemeetsbagel.dialogs.k;
import com.coffeemeetsbagel.feature.profile_completion_helper.ProfileCompletionHelperActivity;
import com.coffeemeetsbagel.feature.profile_completion_helper.f;
import com.coffeemeetsbagel.models.School;
import com.coffeemeetsbagel.models.dto.Answer;
import com.coffeemeetsbagel.models.dto.Option;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import f5.i;
import java.util.ArrayList;
import java.util.List;
import k6.s;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.j;

public final class EducationFragment extends Fragment implements f {

    /* renamed from: g  reason: collision with root package name */
    public static final a f13199g = new a((DefaultConstructorMarker) null);

    /* renamed from: a  reason: collision with root package name */
    public k f13200a;

    /* renamed from: b  reason: collision with root package name */
    public EducationViewModel f13201b;

    /* renamed from: c  reason: collision with root package name */
    public s f13202c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public h0<k> f13203d;

    /* renamed from: e  reason: collision with root package name */
    private k f13204e;

    /* renamed from: f  reason: collision with root package name */
    private k f13205f;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final EducationFragment a() {
            return new EducationFragment();
        }
    }

    static final class b implements u, kotlin.jvm.internal.f {

        /* renamed from: a  reason: collision with root package name */
        private final /* synthetic */ Function1 f13206a;

        b(Function1 function1) {
            j.g(function1, "function");
            this.f13206a = function1;
        }

        public final gk.c<?> a() {
            return this.f13206a;
        }

        public final /* synthetic */ void b(Object obj) {
            this.f13206a.invoke(obj);
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof u) || !(obj instanceof kotlin.jvm.internal.f)) {
                return false;
            }
            return j.b(a(), ((kotlin.jvm.internal.f) obj).a());
        }

        public final int hashCode() {
            return a().hashCode();
        }
    }

    public static final class c extends g0<k> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditText f13207a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EducationFragment f13208b;

        c(EditText editText, EducationFragment educationFragment) {
            this.f13207a = editText;
            this.f13208b = educationFragment;
        }

        /* renamed from: c */
        public void a(k kVar) {
            this.f13207a.setText("");
            this.f13208b.N0((k) null);
            lc.c.h(this.f13208b.f13203d);
        }

        /* renamed from: d */
        public void b(k kVar) {
            String str;
            EditText editText = this.f13207a;
            if (kVar != null) {
                str = kVar.a();
            } else {
                str = null;
            }
            editText.setText(str);
            this.f13208b.N0(kVar);
            lc.c.h(this.f13208b.f13203d);
        }
    }

    public static final class d extends g0<k> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ EditText f13209a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EducationFragment f13210b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Ref$ObjectRef<k> f13211c;

        d(EditText editText, EducationFragment educationFragment, Ref$ObjectRef<k> ref$ObjectRef) {
            this.f13209a = editText;
            this.f13210b = educationFragment;
            this.f13211c = ref$ObjectRef;
        }

        /* renamed from: c */
        public void a(k kVar) {
            this.f13209a.setText("");
            this.f13210b.O0((k) null);
            lc.c.h(this.f13210b.f13203d);
        }

        /* renamed from: d */
        public void b(k kVar) {
            EditText editText = this.f13209a;
            j.d(kVar);
            editText.setText(kVar.a());
            h0 B0 = this.f13210b.f13203d;
            j.d(B0);
            B0.h((b.a) this.f13211c.element);
            this.f13210b.O0(kVar);
            lc.c.h(this.f13210b.f13203d);
        }
    }

    /* access modifiers changed from: private */
    public static final void J0(EducationFragment educationFragment, AdapterView adapterView, View view, int i10, long j10) {
        j.g(educationFragment, "this$0");
        Object itemAtPosition = adapterView.getItemAtPosition(i10);
        j.e(itemAtPosition, "null cannot be cast to non-null type com.coffeemeetsbagel.models.School");
        educationFragment.F0().f15807d.setText(((School) itemAtPosition).getName());
    }

    /* access modifiers changed from: private */
    public static final void L0(EducationFragment educationFragment, AdapterView adapterView, View view, int i10, long j10) {
        j.g(educationFragment, "this$0");
        Object itemAtPosition = adapterView.getItemAtPosition(i10);
        j.e(itemAtPosition, "null cannot be cast to non-null type com.coffeemeetsbagel.models.School");
        educationFragment.F0().f15808e.setText(((School) itemAtPosition).getName());
    }

    /* access modifiers changed from: private */
    public final void Q0(List<QuestionWAnswers> list, List<QuestionWAnswers> list2) {
        List<Answer> d10;
        Answer answer;
        List<Answer> d11;
        Answer answer2;
        QuestionWAnswers questionWAnswers = (QuestionWAnswers) CollectionsKt___CollectionsKt.Q(list, 0);
        if (!(questionWAnswers == null || (d11 = questionWAnswers.d()) == null || (answer2 = (Answer) CollectionsKt___CollectionsKt.Q(d11, 0)) == null)) {
            F0().f15807d.setText(answer2.getTextValue());
        }
        QuestionWAnswers questionWAnswers2 = (QuestionWAnswers) CollectionsKt___CollectionsKt.Q(list, 1);
        if (!(questionWAnswers2 == null || (d10 = questionWAnswers2.d()) == null || (answer = (Answer) CollectionsKt___CollectionsKt.Q(d10, 0)) == null)) {
            F0().f15808e.setText(answer.getTextValue());
        }
        QuestionWAnswers questionWAnswers3 = (QuestionWAnswers) CollectionsKt___CollectionsKt.Q(list2, 0);
        if (questionWAnswers3 != null && (!questionWAnswers3.d().isEmpty())) {
            for (Option next : questionWAnswers3.e().getOptions()) {
                if (j.b(questionWAnswers3.d().get(0).getOptionId(), next.getId())) {
                    F0().f15805b.setText(next.getTitle());
                    this.f13204e = new k(next);
                }
            }
        }
        QuestionWAnswers questionWAnswers4 = (QuestionWAnswers) CollectionsKt___CollectionsKt.Q(list2, 1);
        if (questionWAnswers4 != null && (!questionWAnswers4.d().isEmpty())) {
            for (Option next2 : questionWAnswers4.e().getOptions()) {
                if (j.b(questionWAnswers4.d().get(0).getOptionId(), next2.getId())) {
                    F0().f15805b.setText(next2.getTitle());
                    this.f13205f = new k(next2);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void R0(EditText editText, QuestionWAnswers questionWAnswers) {
        lc.c.a(getActivity());
        ArrayList arrayList = new ArrayList(questionWAnswers.e().getOptions().size());
        k kVar = null;
        for (Option kVar2 : questionWAnswers.e().getOptions()) {
            k kVar3 = new k(kVar2);
            k kVar4 = this.f13204e;
            if (kVar4 != null) {
                j.d(kVar4);
                if (j.b(kVar4.a(), kVar3.a())) {
                    kVar = kVar3;
                }
            }
            arrayList.add(kVar3);
        }
        h0 h0Var = new h0(requireContext(), questionWAnswers.e().getText(), (String) null, new c(editText, this), arrayList);
        this.f13203d = h0Var;
        j.d(h0Var);
        h0Var.show();
        h0<k> h0Var2 = this.f13203d;
        j.d(h0Var2);
        if (h0Var2.getWindow() != null) {
            h0<k> h0Var3 = this.f13203d;
            j.d(h0Var3);
            Window window = h0Var3.getWindow();
            j.d(window);
            window.setLayout(-1, -2);
        }
        if (kVar != null) {
            h0<k> h0Var4 = this.f13203d;
            j.d(h0Var4);
            h0Var4.h(kVar);
        }
    }

    /* access modifiers changed from: private */
    public final void S0(EditText editText, QuestionWAnswers questionWAnswers) {
        lc.c.a(getActivity());
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ArrayList arrayList = new ArrayList(questionWAnswers.e().getOptions().size());
        for (Option kVar : questionWAnswers.e().getOptions()) {
            T kVar2 = new k(kVar);
            k kVar3 = this.f13205f;
            if (kVar3 != null) {
                j.d(kVar3);
                if (j.b(kVar3.a(), kVar2.a())) {
                    ref$ObjectRef.element = kVar2;
                }
            }
            arrayList.add(kVar2);
        }
        h0 h0Var = new h0(requireContext(), questionWAnswers.e().getText(), (String) null, new d(editText, this, ref$ObjectRef), arrayList);
        this.f13203d = h0Var;
        j.d(h0Var);
        h0Var.show();
        h0<k> h0Var2 = this.f13203d;
        j.d(h0Var2);
        if (h0Var2.getWindow() != null) {
            h0<k> h0Var3 = this.f13203d;
            j.d(h0Var3);
            Window window = h0Var3.getWindow();
            j.d(window);
            window.setLayout(-1, -2);
        }
    }

    public final s F0() {
        s sVar = this.f13202c;
        if (sVar != null) {
            return sVar;
        }
        j.y("binding");
        return null;
    }

    public final EducationViewModel G0() {
        EducationViewModel educationViewModel = this.f13201b;
        if (educationViewModel != null) {
            return educationViewModel;
        }
        j.y("viewModel");
        return null;
    }

    public final k H0() {
        k kVar = this.f13200a;
        if (kVar != null) {
            return kVar;
        }
        j.y("viewModelFactory");
        return null;
    }

    public final boolean I0() {
        boolean z10;
        boolean z11;
        Editable text = F0().f15807d.getText();
        j.f(text, "binding.editTextSchool1.text");
        if (text.length() > 0) {
            z10 = true;
        } else {
            z10 = false;
        }
        if (!z10 || this.f13204e == null) {
            Editable text2 = F0().f15808e.getText();
            j.f(text2, "binding.editTextSchool2.text");
            if (text2.length() > 0) {
                z11 = true;
            } else {
                z11 = false;
            }
            if (!z11 || this.f13205f == null) {
                return false;
            }
        }
        return true;
    }

    public final void M0(s sVar) {
        j.g(sVar, "<set-?>");
        this.f13202c = sVar;
    }

    public final void N0(k kVar) {
        this.f13204e = kVar;
    }

    public final void O0(k kVar) {
        this.f13205f = kVar;
    }

    public final void P0(EducationViewModel educationViewModel) {
        j.g(educationViewModel, "<set-?>");
        this.f13201b = educationViewModel;
    }

    public void d() {
        String str;
        if (I0()) {
            EducationViewModel G0 = G0();
            h requireActivity = requireActivity();
            j.f(requireActivity, "requireActivity()");
            g a10 = m.a(requireActivity);
            String obj = F0().f15807d.getText().toString();
            String obj2 = F0().f15808e.getText().toString();
            k kVar = this.f13204e;
            String str2 = null;
            if (kVar != null) {
                str = kVar.b();
            } else {
                str = null;
            }
            k kVar2 = this.f13205f;
            if (kVar2 != null) {
                str2 = kVar2.b();
            }
            G0.q(a10, obj, obj2, str, str2);
            h requireActivity2 = requireActivity();
            j.e(requireActivity2, "null cannot be cast to non-null type com.coffeemeetsbagel.feature.profile_completion_helper.ProfileCompletionHelperActivity");
            ((ProfileCompletionHelperActivity) requireActivity2).next();
            return;
        }
        View requireView = requireView();
        j.f(requireView, "requireView()");
        sb.a.k(requireView, R.string.error_education_required);
    }

    public void onCreate(Bundle bundle) {
        Bakery.j().Y0(this);
        super.onCreate(bundle);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        j.g(layoutInflater, "inflater");
        s c10 = s.c(layoutInflater, viewGroup, false);
        j.f(c10, "inflate(inflater, container, false)");
        M0(c10);
        P0((EducationViewModel) new i0((l0) this, (i0.b) H0()).a(EducationViewModel.class));
        i iVar = new i();
        i iVar2 = new i();
        G0().o().i(getViewLifecycleOwner(), new b(new EducationFragment$onCreateView$1(iVar, iVar2)));
        F0().f15807d.setAdapter(iVar);
        F0().f15807d.setLoadingIndicator(F0().f15810g);
        F0().f15807d.setOnItemClickListener(new a(this));
        F0().f15808e.setAdapter(iVar2);
        F0().f15808e.setLoadingIndicator(F0().f15810g);
        F0().f15808e.setOnItemClickListener(new b(this));
        G0().n().i(getViewLifecycleOwner(), new b(new EducationFragment$onCreateView$4(this)));
        ScrollView b10 = F0().getRoot();
        j.f(b10, "binding.root");
        return b10;
    }
}
