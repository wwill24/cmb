package com.coffeemeetsbagel.dialogs;

import com.coffeemeetsbagel.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

final class ChipSelectQuestionDialog$show$loadDisposable$1 extends Lambda implements Function1<ab.a, Unit> {
    final /* synthetic */ ChipSelectQuestionDialog this$0;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f12048a;

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
                com.coffeemeetsbagel.models.enums.QuestionGroupType r1 = com.coffeemeetsbagel.models.enums.QuestionGroupType.VALUES     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.coffeemeetsbagel.models.enums.QuestionGroupType r1 = com.coffeemeetsbagel.models.enums.QuestionGroupType.PERSONALITY     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.coffeemeetsbagel.models.enums.QuestionGroupType r1 = com.coffeemeetsbagel.models.enums.QuestionGroupType.DATING_STYLE     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                f12048a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.dialogs.ChipSelectQuestionDialog$show$loadDisposable$1.a.<clinit>():void");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ChipSelectQuestionDialog$show$loadDisposable$1(ChipSelectQuestionDialog chipSelectQuestionDialog) {
        super(1);
        this.this$0 = chipSelectQuestionDialog;
    }

    public final void a(ab.a aVar) {
        int i10 = a.f12048a[this.this$0.f12040e.ordinal()];
        if (i10 == 1) {
            ChipSelectQuestionDialog chipSelectQuestionDialog = this.this$0;
            chipSelectQuestionDialog.e(chipSelectQuestionDialog.getContext().getString(R.string.interests_edit_title));
            ChipSelectQuestionDialog chipSelectQuestionDialog2 = this.this$0;
            chipSelectQuestionDialog2.d(chipSelectQuestionDialog2.getContext().getString(R.string.pick_up_to_interests, new Object[]{aVar.a()}));
        } else if (i10 == 2) {
            ChipSelectQuestionDialog chipSelectQuestionDialog3 = this.this$0;
            chipSelectQuestionDialog3.e(chipSelectQuestionDialog3.getContext().getString(R.string.values_edit_title));
            ChipSelectQuestionDialog chipSelectQuestionDialog4 = this.this$0;
            chipSelectQuestionDialog4.d(chipSelectQuestionDialog4.getContext().getString(R.string.pick_up_to_values, new Object[]{aVar.a()}));
        } else if (i10 == 3) {
            ChipSelectQuestionDialog chipSelectQuestionDialog5 = this.this$0;
            chipSelectQuestionDialog5.e(chipSelectQuestionDialog5.getContext().getString(R.string.personality_edit_title));
            ChipSelectQuestionDialog chipSelectQuestionDialog6 = this.this$0;
            chipSelectQuestionDialog6.d(chipSelectQuestionDialog6.getContext().getString(R.string.pick_up_to_personality, new Object[]{aVar.a()}));
        } else if (i10 == 4) {
            ChipSelectQuestionDialog chipSelectQuestionDialog7 = this.this$0;
            chipSelectQuestionDialog7.e(chipSelectQuestionDialog7.getContext().getString(R.string.dating_style_edit_title));
            ChipSelectQuestionDialog chipSelectQuestionDialog8 = this.this$0;
            chipSelectQuestionDialog8.d(chipSelectQuestionDialog8.getContext().getString(R.string.dating_style_edit_subtitle, new Object[]{aVar.a()}));
        }
        this.this$0.p().Q(aVar.b(), aVar.a(), this.this$0.f12040e);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((ab.a) obj);
        return Unit.f32013a;
    }
}
