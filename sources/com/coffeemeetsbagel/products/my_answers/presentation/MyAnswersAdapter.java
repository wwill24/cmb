package com.coffeemeetsbagel.products.my_answers.presentation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.models.dto.Answer;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import gk.f;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.jvm.internal.j;
import org.jivesoftware.smack.packet.Message;

public final class MyAnswersAdapter extends RecyclerView.Adapter<AnsweredPromptViewHolder> {

    /* renamed from: d  reason: collision with root package name */
    private final PublishSubject<Pair<QuestionWAnswers, Integer>> f35813d;

    /* renamed from: e  reason: collision with root package name */
    private final MyAnswersLocation f35814e;

    /* renamed from: f  reason: collision with root package name */
    private List<QuestionWAnswers> f35815f = new ArrayList();

    public static final class AnsweredPromptViewHolder extends RecyclerView.d0 {

        /* renamed from: u  reason: collision with root package name */
        private final PublishSubject<Pair<QuestionWAnswers, Integer>> f35816u;

        /* renamed from: v  reason: collision with root package name */
        private final f f35817v;

        /* renamed from: w  reason: collision with root package name */
        private final f f35818w;

        /* renamed from: x  reason: collision with root package name */
        private final f f35819x;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public AnsweredPromptViewHolder(View view, PublishSubject<Pair<QuestionWAnswers, Integer>> publishSubject) {
            super(view);
            j.g(view, "view");
            j.g(publishSubject, "editClickListener");
            this.f35816u = publishSubject;
            this.f35817v = b.b(new MyAnswersAdapter$AnsweredPromptViewHolder$question$2(view));
            this.f35818w = b.b(new MyAnswersAdapter$AnsweredPromptViewHolder$answer$2(view));
            this.f35819x = b.b(new MyAnswersAdapter$AnsweredPromptViewHolder$editCta$2(view));
        }

        /* access modifiers changed from: private */
        public static final void X(AnsweredPromptViewHolder answeredPromptViewHolder, QuestionWAnswers questionWAnswers, View view) {
            j.g(answeredPromptViewHolder, "this$0");
            j.g(questionWAnswers, "$questionWithAnswer");
            answeredPromptViewHolder.f35816u.d(new Pair(questionWAnswers, Integer.valueOf(answeredPromptViewHolder.q())));
        }

        private final TextView Y() {
            return (TextView) this.f35818w.getValue();
        }

        private final View Z() {
            return (View) this.f35819x.getValue();
        }

        private final TextView a0() {
            return (TextView) this.f35817v.getValue();
        }

        public final void W(QuestionWAnswers questionWAnswers) {
            String str;
            j.g(questionWAnswers, "questionWithAnswer");
            a0().setText(questionWAnswers.e().getText());
            TextView Y = Y();
            Answer answer = (Answer) CollectionsKt___CollectionsKt.P(questionWAnswers.d());
            if (answer != null) {
                str = answer.getTextValue();
            } else {
                str = null;
            }
            Y.setText(str);
            View Z = Z();
            if (Z != null) {
                Z.setOnClickListener(new l(this, questionWAnswers));
            }
        }
    }

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f35820a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                com.coffeemeetsbagel.products.my_answers.presentation.MyAnswersLocation[] r0 = com.coffeemeetsbagel.products.my_answers.presentation.MyAnswersLocation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.coffeemeetsbagel.products.my_answers.presentation.MyAnswersLocation r1 = com.coffeemeetsbagel.products.my_answers.presentation.MyAnswersLocation.PROFILE_READ_ONLY     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.coffeemeetsbagel.products.my_answers.presentation.MyAnswersLocation r1 = com.coffeemeetsbagel.products.my_answers.presentation.MyAnswersLocation.PROFILE_EDIT     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f35820a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.products.my_answers.presentation.MyAnswersAdapter.a.<clinit>():void");
        }
    }

    public MyAnswersAdapter(PublishSubject<Pair<QuestionWAnswers, Integer>> publishSubject, MyAnswersLocation myAnswersLocation) {
        j.g(publishSubject, "editClickListener");
        j.g(myAnswersLocation, "layoutType");
        this.f35813d = publishSubject;
        this.f35814e = myAnswersLocation;
    }

    public final void G(int i10) {
        this.f35815f.remove(i10);
        t(i10);
    }

    /* renamed from: H */
    public void v(AnsweredPromptViewHolder answeredPromptViewHolder, int i10) {
        j.g(answeredPromptViewHolder, "holder");
        answeredPromptViewHolder.W(this.f35815f.get(answeredPromptViewHolder.q()));
    }

    /* renamed from: I */
    public AnsweredPromptViewHolder x(ViewGroup viewGroup, int i10) {
        int i11;
        j.g(viewGroup, Message.Thread.PARENT_ATTRIBUTE_NAME);
        int i12 = a.f35820a[this.f35814e.ordinal()];
        if (i12 == 1) {
            i11 = R.layout.list_item_label_value_read_only;
        } else if (i12 == 2) {
            i11 = R.layout.list_item_prompt_answer;
        } else {
            throw new NoWhenBranchMatchedException();
        }
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(i11, viewGroup, false);
        j.f(inflate, "view1");
        return new AnsweredPromptViewHolder(inflate, this.f35813d);
    }

    public final void J(List<QuestionWAnswers> list) {
        j.g(list, "data");
        this.f35815f = CollectionsKt___CollectionsKt.z0(list);
        l();
    }

    public int g() {
        return this.f35815f.size();
    }
}
