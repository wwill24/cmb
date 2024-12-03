package com.coffeemeetsbagel.dialogs.question_chips;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import androidx.core.view.ViewGroupKt;
import androidx.recyclerview.widget.RecyclerView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.dialogs.DialogPrimarySecondaryVertical;
import com.coffeemeetsbagel.models.dto.Answer;
import com.coffeemeetsbagel.models.dto.Option;
import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.jakewharton.rxrelay2.b;
import com.mparticle.identity.IdentityHttpResponse;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import k6.f;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.j;
import org.jivesoftware.smack.packet.Message;
import qj.q;

public final class QuestionGroupAdapter extends RecyclerView.Adapter<c> {

    /* renamed from: d  reason: collision with root package name */
    private final Context f12130d;

    /* renamed from: e  reason: collision with root package name */
    private final LayoutInflater f12131e;

    /* renamed from: f  reason: collision with root package name */
    private final ArrayList<QuestionWAnswers> f12132f = new ArrayList<>();

    /* renamed from: g  reason: collision with root package name */
    private Integer f12133g;

    /* renamed from: h  reason: collision with root package name */
    private QuestionGroupType f12134h;

    /* renamed from: j  reason: collision with root package name */
    private final Map<String, List<String>> f12135j = new LinkedHashMap();

    /* renamed from: k  reason: collision with root package name */
    private final b<Integer> f12136k;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f12137a;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                com.coffeemeetsbagel.models.enums.QuestionGroupType[] r0 = com.coffeemeetsbagel.models.enums.QuestionGroupType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.models.enums.QuestionGroupType r1 = com.coffeemeetsbagel.models.enums.QuestionGroupType.INTERESTS     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.coffeemeetsbagel.models.enums.QuestionGroupType r1 = com.coffeemeetsbagel.models.enums.QuestionGroupType.PERSONALITY     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.coffeemeetsbagel.models.enums.QuestionGroupType r1 = com.coffeemeetsbagel.models.enums.QuestionGroupType.VALUES     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.coffeemeetsbagel.models.enums.QuestionGroupType r1 = com.coffeemeetsbagel.models.enums.QuestionGroupType.DATING_STYLE     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                f12137a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.dialogs.question_chips.QuestionGroupAdapter.a.<clinit>():void");
        }
    }

    public QuestionGroupAdapter(Context context) {
        j.g(context, IdentityHttpResponse.CONTEXT);
        this.f12130d = context;
        LayoutInflater from = LayoutInflater.from(context);
        j.f(from, "from(context)");
        this.f12131e = from;
        b<Integer> C0 = b.C0();
        j.f(C0, "create()");
        this.f12136k = C0;
    }

    private final List<String> I(ChipGroup chipGroup) {
        return SequencesKt___SequencesKt.t(SequencesKt___SequencesKt.q(SequencesKt___SequencesKt.i(ViewGroupKt.a(chipGroup), QuestionGroupAdapter$checkedOptionIds$1.f12138a), QuestionGroupAdapter$checkedOptionIds$2.f12139a));
    }

    /* access modifiers changed from: private */
    public static final int L(Function2 function2, Object obj, Object obj2) {
        j.g(function2, "$tmp0");
        return ((Number) function2.invoke(obj, obj2)).intValue();
    }

    /* access modifiers changed from: private */
    public static final void M(QuestionGroupAdapter questionGroupAdapter, QuestionWAnswers questionWAnswers, c cVar, CompoundButton compoundButton, boolean z10) {
        Integer O;
        String[] strArr;
        QuestionGroupAdapter questionGroupAdapter2 = questionGroupAdapter;
        j.g(questionGroupAdapter2, "this$0");
        j.g(questionWAnswers, "$question");
        j.g(cVar, "$holder");
        if (compoundButton.isChecked() && (O = questionGroupAdapter.O()) != null && O.intValue() < 1) {
            compoundButton.setChecked(false);
            QuestionGroupType questionGroupType = questionGroupAdapter2.f12134h;
            if (questionGroupType == null) {
                j.y("group");
                questionGroupType = null;
            }
            int i10 = a.f12137a[questionGroupType.ordinal()];
            if (i10 == 1) {
                String string = questionGroupAdapter2.f12130d.getString(R.string.label_interests);
                j.f(string, "context.getString(R.string.label_interests)");
                String lowerCase = string.toLowerCase(Locale.ROOT);
                j.f(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                strArr = new String[]{questionGroupAdapter2.f12130d.getString(R.string.arg_interest), lowerCase};
            } else if (i10 == 2) {
                strArr = new String[]{questionGroupAdapter2.f12130d.getString(R.string.arg_personality), questionGroupAdapter2.f12130d.getString(R.string.arg_traits)};
            } else if (i10 == 3) {
                String string2 = questionGroupAdapter2.f12130d.getString(R.string.label_values);
                j.f(string2, "context.getString(R.string.label_values)");
                String lowerCase2 = string2.toLowerCase(Locale.ROOT);
                j.f(lowerCase2, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                strArr = new String[]{questionGroupAdapter2.f12130d.getString(R.string.arg_value), lowerCase2};
            } else if (i10 != 4) {
                strArr = new String[0];
            } else {
                String string3 = questionGroupAdapter2.f12130d.getString(R.string.label_dating_styles);
                j.f(string3, "context.getString(R.string.label_dating_styles)");
                String lowerCase3 = string3.toLowerCase(Locale.ROOT);
                j.f(lowerCase3, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                strArr = new String[]{questionGroupAdapter2.f12130d.getString(R.string.arg_dating), lowerCase3};
            }
            String str = strArr[0];
            String str2 = strArr[1];
            DialogPrimarySecondaryVertical.a aVar = DialogPrimarySecondaryVertical.f12065a;
            Context context = questionGroupAdapter2.f12130d;
            String string4 = context.getString(R.string.max_selection_reached_title, new Object[]{str});
            j.f(string4, "context.getString(\n     …                        )");
            String string5 = questionGroupAdapter2.f12130d.getString(R.string.max_selection_reached, new Object[]{questionGroupAdapter2.f12133g, str2});
            j.f(string5, "context.getString(\n     …                        )");
            String string6 = questionGroupAdapter2.f12130d.getString(R.string.got_it);
            j.f(string6, "context.getString(R.string.got_it)");
            DialogPrimarySecondaryVertical.a.d(aVar, context, (DialogPrimarySecondaryVertical.PrimaryCtaStyle) null, (Integer) null, string4, string5, string6, QuestionGroupAdapter$onBindViewHolder$2$1$1.f12140a, (String) null, (Function0) null, (Function0) null, 902, (Object) null);
        }
        questionGroupAdapter2.f12135j.put(questionWAnswers.e().getId(), questionGroupAdapter2.I(cVar.V()));
        Integer O2 = questionGroupAdapter.O();
        if (O2 != null) {
            questionGroupAdapter2.f12136k.accept(O2);
        }
    }

    private final Integer O() {
        Integer num = this.f12133g;
        if (num == null) {
            return null;
        }
        int intValue = num.intValue();
        Map<String, List<String>> map = this.f12135j;
        ArrayList arrayList = new ArrayList();
        for (Map.Entry<String, List<String>> value : map.entrySet()) {
            boolean unused = v.x(arrayList, (List) value.getValue());
        }
        return Integer.valueOf(intValue - arrayList.size());
    }

    public final Map<String, List<String>> J() {
        return h0.u(this.f12135j);
    }

    /* renamed from: K */
    public void v(c cVar, int i10) {
        j.g(cVar, "holder");
        QuestionWAnswers questionWAnswers = this.f12132f.get(i10);
        j.f(questionWAnswers, "questions[position]");
        QuestionWAnswers questionWAnswers2 = questionWAnswers;
        cVar.Y().setText(questionWAnswers2.e().getText());
        cVar.V().setSingleSelection(false);
        if (this.f12132f.size() == 1) {
            cVar.V().setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            cVar.W().setVisibility(4);
        }
        cVar.X().D();
        cVar.V().removeAllViews();
        List<Answer> d10 = questionWAnswers2.d();
        LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(r.t(d10, 10)), 16));
        for (T next : d10) {
            String optionId = ((Answer) next).getOptionId();
            j.d(optionId);
            linkedHashMap.put(optionId, next);
        }
        for (Option option : CollectionsKt___CollectionsKt.q0(questionWAnswers2.e().getOptions(), new a(new QuestionGroupAdapter$onBindViewHolder$1(linkedHashMap)))) {
            View inflate = this.f12131e.inflate(R.layout.selectable_chip, cVar.V(), false);
            j.e(inflate, "null cannot be cast to non-null type com.google.android.material.chip.Chip");
            Chip chip = (Chip) inflate;
            chip.setText(option.getTitle());
            if (linkedHashMap.containsKey(option.getId())) {
                chip.setChecked(true);
            }
            chip.getBackgroundDrawable();
            chip.setTag(option.getId());
            chip.setOnCheckedChangeListener(new b(this, questionWAnswers2, cVar));
            cVar.V().addView(chip);
        }
    }

    /* renamed from: N */
    public c x(ViewGroup viewGroup, int i10) {
        j.g(viewGroup, Message.Thread.PARENT_ATTRIBUTE_NAME);
        f c10 = f.c(this.f12131e);
        j.f(c10, "inflate(inflater)");
        return new c(c10);
    }

    public final q<Integer> P() {
        q<Integer> P = this.f12136k.P();
        j.f(P, "remainingOptionsRelay.hide()");
        return P;
    }

    public final void Q(List<QuestionWAnswers> list, Integer num, QuestionGroupType questionGroupType) {
        j.g(list, "newQuestions");
        j.g(questionGroupType, "questionGroupType");
        this.f12132f.clear();
        this.f12132f.addAll(list);
        this.f12133g = num;
        this.f12134h = questionGroupType;
        for (QuestionWAnswers questionWAnswers : this.f12132f) {
            Map<String, List<String>> map = this.f12135j;
            String id2 = questionWAnswers.e().getId();
            List<Answer> d10 = questionWAnswers.d();
            ArrayList arrayList = new ArrayList();
            for (Answer optionId : d10) {
                String optionId2 = optionId.getOptionId();
                if (optionId2 != null) {
                    arrayList.add(optionId2);
                }
            }
            map.put(id2, arrayList);
        }
        Integer O = O();
        if (O != null) {
            this.f12136k.accept(O);
        }
    }

    public int g() {
        return this.f12132f.size();
    }
}
