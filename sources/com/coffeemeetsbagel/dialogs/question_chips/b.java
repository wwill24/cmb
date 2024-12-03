package com.coffeemeetsbagel.dialogs.question_chips;

import android.widget.CompoundButton;
import com.coffeemeetsbagel.qna.QuestionWAnswers;

public final /* synthetic */ class b implements CompoundButton.OnCheckedChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ QuestionGroupAdapter f12142a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuestionWAnswers f12143b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f12144c;

    public /* synthetic */ b(QuestionGroupAdapter questionGroupAdapter, QuestionWAnswers questionWAnswers, c cVar) {
        this.f12142a = questionGroupAdapter;
        this.f12143b = questionWAnswers;
        this.f12144c = cVar;
    }

    public final void onCheckedChanged(CompoundButton compoundButton, boolean z10) {
        QuestionGroupAdapter.M(this.f12142a, this.f12143b, this.f12144c, compoundButton, z10);
    }
}
