package s7;

import android.view.View;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import io.reactivex.subjects.PublishSubject;
import s7.b;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PublishSubject f17518a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ QuestionWAnswers f17519b;

    public /* synthetic */ a(PublishSubject publishSubject, QuestionWAnswers questionWAnswers) {
        this.f17518a = publishSubject;
        this.f17519b = questionWAnswers;
    }

    public final void onClick(View view) {
        b.a.X(this.f17518a, this.f17519b, view);
    }
}
