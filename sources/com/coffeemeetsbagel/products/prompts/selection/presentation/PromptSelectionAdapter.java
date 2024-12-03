package com.coffeemeetsbagel.products.prompts.selection.presentation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import gk.f;
import io.reactivex.subjects.PublishSubject;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.j;
import org.jivesoftware.smack.packet.Message;

public final class PromptSelectionAdapter extends RecyclerView.Adapter<ViewHolder> {

    /* renamed from: d  reason: collision with root package name */
    private final PublishSubject<QuestionWAnswers> f35956d;

    /* renamed from: e  reason: collision with root package name */
    private List<QuestionWAnswers> f35957e = new ArrayList();

    public static final class ViewHolder extends RecyclerView.d0 {

        /* renamed from: u  reason: collision with root package name */
        private final PublishSubject<QuestionWAnswers> f35958u;

        /* renamed from: v  reason: collision with root package name */
        private final f f35959v;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public ViewHolder(View view, PublishSubject<QuestionWAnswers> publishSubject) {
            super(view);
            j.g(view, "view");
            j.g(publishSubject, "promptItemClickListener");
            this.f35958u = publishSubject;
            this.f35959v = b.b(new PromptSelectionAdapter$ViewHolder$subject$2(view));
        }

        /* access modifiers changed from: private */
        public static final void X(ViewHolder viewHolder, QuestionWAnswers questionWAnswers, View view) {
            j.g(viewHolder, "this$0");
            j.g(questionWAnswers, "$question");
            viewHolder.f35958u.d(questionWAnswers);
        }

        private final TextView Y() {
            return (TextView) this.f35959v.getValue();
        }

        public final void W(QuestionWAnswers questionWAnswers) {
            j.g(questionWAnswers, "question");
            Y().setText(questionWAnswers.e().getText());
            this.f6302a.setOnClickListener(new g(this, questionWAnswers));
        }
    }

    public PromptSelectionAdapter(PublishSubject<QuestionWAnswers> publishSubject) {
        j.g(publishSubject, "promptItemClickListener");
        this.f35956d = publishSubject;
    }

    /* renamed from: G */
    public void v(ViewHolder viewHolder, int i10) {
        j.g(viewHolder, "holder");
        viewHolder.W(this.f35957e.get(viewHolder.q()));
    }

    /* renamed from: H */
    public ViewHolder x(ViewGroup viewGroup, int i10) {
        j.g(viewGroup, Message.Thread.PARENT_ATTRIBUTE_NAME);
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.list_item_prompt_question_only, viewGroup, false);
        j.f(inflate, "view");
        return new ViewHolder(inflate, this.f35956d);
    }

    public final void I(List<QuestionWAnswers> list) {
        j.g(list, "data");
        this.f35957e = list;
        l();
    }

    public int g() {
        return this.f35957e.size();
    }
}
