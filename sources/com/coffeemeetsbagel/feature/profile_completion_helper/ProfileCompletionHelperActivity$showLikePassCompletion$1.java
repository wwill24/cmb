package com.coffeemeetsbagel.feature.profile_completion_helper;

import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.dialogs.DialogPrimarySecondaryVertical;
import com.coffeemeetsbagel.models.entities.GenderType;
import com.coffeemeetsbagel.profile.l;
import ja.b;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.p;

final class ProfileCompletionHelperActivity$showLikePassCompletion$1 extends Lambda implements Function1<Pair<? extends b, ? extends l>, Unit> {
    final /* synthetic */ ProfileCompletionHelperActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ProfileCompletionHelperActivity$showLikePassCompletion$1(ProfileCompletionHelperActivity profileCompletionHelperActivity) {
        super(1);
        this.this$0 = profileCompletionHelperActivity;
    }

    public final void a(Pair<b, l> pair) {
        int i10;
        int i11;
        GenderType h10 = pair.d().h();
        GenderType genderType = GenderType.MALE;
        if (h10 == genderType) {
            i10 = R.string.profile_complete_title_id_normal;
        } else {
            i10 = R.string.profile_complete_title_new_modle_test_female;
        }
        int i12 = i10;
        if (pair.d().h() == genderType) {
            i11 = R.string.profile_complete_prompt_new_model_test_male;
        } else {
            i11 = R.string.profile_complete_prompt_new_model_test_female;
        }
        DialogPrimarySecondaryVertical.a aVar = DialogPrimarySecondaryVertical.f12065a;
        final ProfileCompletionHelperActivity profileCompletionHelperActivity = this.this$0;
        DialogPrimarySecondaryVertical.PrimaryCtaStyle primaryCtaStyle = DialogPrimarySecondaryVertical.PrimaryCtaStyle.NORMAL;
        Integer valueOf = Integer.valueOf(R.string.not_now);
        final ProfileCompletionHelperActivity profileCompletionHelperActivity2 = this.this$0;
        final ProfileCompletionHelperActivity profileCompletionHelperActivity3 = this.this$0;
        aVar.a(profileCompletionHelperActivity, primaryCtaStyle, (Integer) null, i12, i11, R.string.review_my_profile, (Function0) p.d(new Function0() {
            /* renamed from: a */
            public final Void invoke() {
                profileCompletionHelperActivity.setResult(-1);
                profileCompletionHelperActivity.finish();
                return null;
            }
        }, 0), valueOf, (Function0) p.d(new Function0() {
            /* renamed from: a */
            public final Void invoke() {
                profileCompletionHelperActivity2.finish();
                return null;
            }
        }, 0), (Function0) p.d(new Function0() {
            /* renamed from: a */
            public final Void invoke() {
                profileCompletionHelperActivity3.finish();
                return null;
            }
        }, 0));
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        a((Pair) obj);
        return Unit.f32013a;
    }
}
