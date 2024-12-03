package f8;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ProgressBar;
import androidx.annotation.NonNull;
import c9.d;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.bakery.Bakery;
import com.coffeemeetsbagel.cmb_views.CmbEditText;
import com.coffeemeetsbagel.cmb_views.DelayAutoCompleteTextView;
import com.coffeemeetsbagel.dialogs.e;
import com.coffeemeetsbagel.dialogs.g0;
import com.coffeemeetsbagel.dialogs.h0;
import com.coffeemeetsbagel.models.ModelProfileUpdateDelta;
import com.coffeemeetsbagel.models.NetworkProfile;
import com.coffeemeetsbagel.models.Resource;
import com.coffeemeetsbagel.models.School;
import com.coffeemeetsbagel.models.enums.ResourceType;
import com.coffeemeetsbagel.models.util.CollectionUtils;
import com.coffeemeetsbagel.school.domain.GetSingleSchoolsUseCase;
import com.facebook.internal.ServerProtocol;
import com.uber.autodispose.t;
import f5.i;
import j5.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lc.c;
import x7.b;
import z9.h;

public class x extends n implements d.a {
    private Map<String, String> B;
    private View C;
    c9.a D;
    GetSingleSchoolsUseCase E;

    /* renamed from: k  reason: collision with root package name */
    private final tj.a f14944k = new tj.a();
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public CmbEditText f14945l;

    /* renamed from: m  reason: collision with root package name */
    private CmbEditText f14946m;

    /* renamed from: n  reason: collision with root package name */
    private DelayAutoCompleteTextView f14947n;

    /* renamed from: p  reason: collision with root package name */
    private DelayAutoCompleteTextView f14948p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public h0<e> f14949q;

    /* renamed from: t  reason: collision with root package name */
    private String f14950t;

    /* renamed from: w  reason: collision with root package name */
    private String f14951w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public String f14952x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public String f14953y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public List<Resource> f14954z;

    class a extends g0<e> {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ List f14955a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ EditText f14956b;

        a(List list, EditText editText) {
            this.f14955a = list;
            this.f14956b = editText;
        }

        /* renamed from: c */
        public void b(e eVar) {
            Resource resource = (Resource) x.this.f14954z.get(this.f14955a.indexOf(eVar));
            if (this.f14956b == x.this.f14945l) {
                x.this.f14952x = resource.getKey();
                if (x.this.o1()) {
                    ((b) x.this.requireActivity()).t(x.this.f14952x);
                }
            } else {
                x.this.f14953y = resource.getKey();
                if (x.this.o1()) {
                    ((b) x.this.requireActivity()).m(x.this.f14953y);
                }
            }
            x.this.M0().j().setDegrees(x.this.f14952x, x.this.f14953y);
            x.this.C0().c("Has Education", ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
            this.f14956b.setText(resource.getValue());
            x xVar = x.this;
            h hVar = xVar.f15615d;
            if (hVar != null) {
                hVar.X(xVar.b0(false), x.this);
            }
            c.h(x.this.f14949q);
        }
    }

    private void n1(Map<String, String> map) {
        if (!CollectionUtils.isEmpty(map)) {
            if (!TextUtils.isEmpty(this.f14952x)) {
                this.f14945l.setText(map.get(this.f14952x));
            }
            if (!TextUtils.isEmpty(this.f14953y)) {
                this.f14946m.setText(map.get(this.f14953y));
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean o1() {
        return getActivity() instanceof b;
    }

    public static boolean p1() {
        String str;
        NetworkProfile j10 = Bakery.w().G().j();
        String str2 = null;
        if (j10.getListSchools().size() > 0) {
            str = j10.getListSchools().get(0);
        } else {
            str = null;
        }
        if (j10.getListDegrees().size() > 0) {
            str2 = j10.getListDegrees().get(0);
        }
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q1(AdapterView adapterView, View view, int i10, long j10) {
        School school = (School) adapterView.getItemAtPosition(i10);
        this.f14947n.setText(school.getName());
        if (o1()) {
            ((b) requireActivity()).M(school.getName());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r1(AdapterView adapterView, View view, int i10, long j10) {
        School school = (School) adapterView.getItemAtPosition(i10);
        this.f14948p.setText(school.getName());
        if (o1()) {
            ((b) requireActivity()).J(school.getName());
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void s1(i iVar, i iVar2, List list) throws Exception {
        iVar.c(list);
        iVar2.c(list);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u1(View view) {
        z1(this.f14945l);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v1(View view) {
        z1(this.f14946m);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w1(List list) throws Exception {
        this.f14954z = list;
        Map<String, String> e10 = O0().e(list);
        this.B = e10;
        n1(e10);
        O0().b(this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x1(List list) throws Exception {
        if (list.isEmpty()) {
            O0().d(this);
            O0().c();
            return;
        }
        this.f14954z = list;
        Map<String, String> e10 = O0().e(list);
        this.B = e10;
        n1(e10);
    }

    private void y1() {
        HashMap hashMap = new HashMap();
        hashMap.put("School Name", this.f14950t);
        hashMap.put("degree", this.f14952x);
        hashMap.put("source", "Like Pass Flow");
        C0().trackEvent("Education Updated", hashMap);
    }

    private void z1(EditText editText) {
        String str;
        c.a(getActivity());
        if (!TextUtils.isEmpty(editText.getText())) {
            str = editText.getText().toString();
        } else {
            str = null;
        }
        ArrayList arrayList = new ArrayList(this.f14954z.size());
        e eVar = null;
        for (Resource next : this.f14954z) {
            e eVar2 = new e(next.getValue(), (String) null);
            if (next.getValue().equals(str)) {
                eVar = eVar2;
            }
            arrayList.add(eVar2);
        }
        h0 h0Var = new h0(requireContext(), getString(R.string.label_degree), (String) null, new a(arrayList, editText), arrayList);
        this.f14949q = h0Var;
        h0Var.show();
        if (this.f14949q.getWindow() != null) {
            this.f14949q.getWindow().setLayout(-1, -2);
        }
        if (eVar != null) {
            this.f14949q.h(eVar);
        }
    }

    public void L() {
        ((t) this.D.a(ResourceType.DEGREES).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new w(this));
    }

    /* access modifiers changed from: protected */
    public String Q0() {
        return "School";
    }

    public void V0() {
        C0().f("Onboarding - School");
    }

    public boolean b0(boolean z10) {
        h hVar;
        String str;
        String str2;
        if ((getActivity() instanceof h) && (hVar = this.f15615d) != null) {
            ModelProfileUpdateDelta Y = hVar.Y();
            DelayAutoCompleteTextView delayAutoCompleteTextView = this.f14947n;
            if (delayAutoCompleteTextView == null) {
                str = this.f14950t;
            } else {
                str = delayAutoCompleteTextView.getText().toString();
            }
            DelayAutoCompleteTextView delayAutoCompleteTextView2 = this.f14948p;
            if (delayAutoCompleteTextView2 == null) {
                str2 = this.f14951w;
            } else {
                str2 = delayAutoCompleteTextView2.getText().toString();
            }
            if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f14952x)) {
                y1();
                Y.updateEducation(str, this.f14952x, str2, this.f14953y);
                return true;
            } else if (z10) {
                sb.a.k(this.C, R.string.error_education_required);
            }
        }
        return false;
    }

    public void onCreate(Bundle bundle) {
        ((Bakery) getActivity().getApplication()).u().Z0(this);
        super.onCreate(bundle);
        NetworkProfile j10 = M0().j();
        if (j10.getListSchools().size() > 0) {
            this.f14950t = j10.getListSchools().get(0);
        }
        if (j10.getListSchools().size() > 1) {
            this.f14951w = j10.getListSchools().get(1);
        }
        if (j10.getListDegrees().size() > 0) {
            this.f14952x = j10.getListDegrees().get(0);
        }
        if (j10.getListDegrees().size() > 1) {
            this.f14953y = j10.getListDegrees().get(1);
        }
    }

    @SuppressLint({"AutoDispose", "CheckResult"})
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_my_profile_education_dls, viewGroup, false);
        this.C = inflate;
        this.f14947n = (DelayAutoCompleteTextView) inflate.findViewById(R.id.editText_school1);
        this.f14948p = (DelayAutoCompleteTextView) this.C.findViewById(R.id.editText_school2);
        this.f14945l = (CmbEditText) this.C.findViewById(R.id.degree1_text_view);
        this.f14946m = (CmbEditText) this.C.findViewById(R.id.degree2_text_view);
        i iVar = new i();
        this.f14947n.setAdapter(iVar);
        this.f14947n.setLoadingIndicator((ProgressBar) this.C.findViewById(R.id.educationfragment_schools_autocomplete_loading_indicator1));
        this.f14947n.setOnItemClickListener(new p(this));
        i iVar2 = new i();
        this.f14948p.setAdapter(iVar2);
        this.f14948p.setLoadingIndicator((ProgressBar) this.C.findViewById(R.id.educationfragment_schools_autocomplete_loading_indicator2));
        this.f14948p.setOnItemClickListener(new q(this));
        this.f14944k.a(this.E.b().E(sj.a.a()).b(new r(iVar, iVar2), new s()));
        this.f14945l.setOnClickListener(new t(this));
        this.f14946m.setOnClickListener(new u(this));
        return this.C;
    }

    public void onDestroyView() {
        this.f14944k.dispose();
        super.onDestroyView();
    }

    public void onPause() {
        super.onPause();
        O0().b(this);
    }

    public void onResume() {
        super.onResume();
        DelayAutoCompleteTextView delayAutoCompleteTextView = this.f14947n;
        if (delayAutoCompleteTextView != null) {
            delayAutoCompleteTextView.requestFocus();
        }
        if (isAdded()) {
            c.g(requireActivity(), this.f14947n);
        }
        Bakery.w().M().A();
        NetworkProfile j10 = M0().j();
        if (j10.getListSchools().size() > 0) {
            this.f14950t = j10.getListSchools().get(0);
            if (o1()) {
                ((b) requireActivity()).M(this.f14950t);
            }
        }
        if (j10.getListSchools().size() > 1) {
            this.f14951w = j10.getListSchools().get(1);
            if (o1()) {
                ((b) requireActivity()).J(this.f14951w);
            }
        }
        if (j10.getListDegrees().size() > 0) {
            this.f14952x = j10.getListDegrees().get(0);
            if (o1()) {
                ((b) requireActivity()).t(this.f14952x);
            }
        }
        if (j10.getListDegrees().size() > 1) {
            this.f14953y = j10.getListDegrees().get(1);
            if (o1()) {
                ((b) requireActivity()).m(this.f14953y);
            }
        }
        if (!TextUtils.isEmpty(this.f14950t)) {
            this.f14947n.setText(this.f14950t);
        }
        if (!TextUtils.isEmpty(this.f14951w)) {
            this.f14948p.setText(this.f14951w);
        }
        if (this.f14954z == null) {
            ((t) this.D.a(ResourceType.DEGREES).E(sj.a.a()).g(com.uber.autodispose.a.a(this))).c(new v(this));
        }
    }
}
