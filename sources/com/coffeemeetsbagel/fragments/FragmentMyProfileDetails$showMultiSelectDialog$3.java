package com.coffeemeetsbagel.fragments;

import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.dialogs.e;
import com.coffeemeetsbagel.models.enums.QuestionGroupType;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.j;
import lc.c;
import org.jivesoftware.smackx.mam.element.MamElements;
import xk.a;

final class FragmentMyProfileDetails$showMultiSelectDialog$3 extends Lambda implements Function1<List<? extends e>, Unit> {
    final /* synthetic */ QuestionGroupType $groupType;
    final /* synthetic */ String $questionId;
    final /* synthetic */ FragmentMyProfileDetails this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FragmentMyProfileDetails$showMultiSelectDialog$3(FragmentMyProfileDetails fragmentMyProfileDetails, String str, QuestionGroupType questionGroupType) {
        super(1);
        this.this$0 = fragmentMyProfileDetails;
        this.$questionId = str;
        this.$groupType = questionGroupType;
    }

    /* access modifiers changed from: private */
    public static final String e(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (String) function1.invoke(obj);
    }

    /* access modifiers changed from: private */
    public static final String f(Function1 function1, Object obj) {
        j.g(function1, "$tmp0");
        return (String) function1.invoke(obj);
    }

    public final void d(List<e> list) {
        j.g(list, MamElements.MamResultExtension.ELEMENT);
        Stream<R> map = list.stream().map(new i4(FragmentMyProfileDetails$showMultiSelectDialog$3$optionIds$1.f13590a));
        j.f(map, "result.stream()\n        …pterItem -> obj.apiText }");
        List<R> a10 = a.a(map);
        FragmentMyProfileDetails fragmentMyProfileDetails = this.this$0;
        j.e(a10, "null cannot be cast to non-null type kotlin.collections.List<kotlin.String>");
        FragmentMyProfileDetails.Z3(fragmentMyProfileDetails, a10, (String) null, this.$questionId, this.$groupType.getQuestionGroupApiString(), 2, (Object) null);
        List list2 = (List) list.stream().map(new j4(FragmentMyProfileDetails$showMultiSelectDialog$3$newSelectedList$1.f13589a)).collect(Collectors.toList());
        if (j.b(this.$questionId, this.this$0.f13548u0)) {
            this.this$0.f13534l0.clear();
            List x22 = this.this$0.f13534l0;
            j.f(list2, "newSelectedList");
            x22.addAll(list2);
            CmbTextView n22 = this.this$0.f13555z;
            j.d(n22);
            n22.setText((CharSequence) list2.stream().collect(Collectors.joining(", ")));
        }
        c.h(this.this$0.f13530j0);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        d((List) obj);
        return Unit.f32013a;
    }
}
