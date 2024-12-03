package s7;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.coffeemeetsbagel.R;
import com.coffeemeetsbagel.cmb_views.CmbTextView;
import com.coffeemeetsbagel.models.dto.Option;
import com.coffeemeetsbagel.qna.QuestionWAnswers;
import io.reactivex.BackpressureStrategy;
import io.reactivex.subjects.PublishSubject;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.jvm.internal.j;
import org.jivesoftware.smack.packet.Message;
import qj.h;

public final class b extends RecyclerView.Adapter<RecyclerView.d0> {

    /* renamed from: d  reason: collision with root package name */
    private List<QuestionWAnswers> f17520d;

    /* renamed from: e  reason: collision with root package name */
    private final PublishSubject<QuestionWAnswers> f17521e;

    public static final class a extends RecyclerView.d0 {

        /* renamed from: u  reason: collision with root package name */
        private final View f17522u;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(View view) {
            super(view);
            j.g(view, "view");
            this.f17522u = view;
        }

        /* access modifiers changed from: private */
        public static final void X(PublishSubject publishSubject, QuestionWAnswers questionWAnswers, View view) {
            j.g(publishSubject, "$clicksStream");
            j.g(questionWAnswers, "$questionToShow");
            publishSubject.d(questionWAnswers);
        }

        public final void W(QuestionWAnswers questionWAnswers, PublishSubject<QuestionWAnswers> publishSubject) {
            String str;
            j.g(questionWAnswers, "questionToShow");
            j.g(publishSubject, "clicksStream");
            CmbTextView cmbTextView = (CmbTextView) this.f17522u.findViewById(R.id.core_profile_data_answer);
            ((CmbTextView) this.f17522u.findViewById(R.id.core_profile_data_question)).setText(questionWAnswers.e().getLabel());
            if (!questionWAnswers.d().isEmpty()) {
                List<Option> options = questionWAnswers.e().getOptions();
                LinkedHashMap linkedHashMap = new LinkedHashMap(j.c(g0.e(r.t(options, 10)), 16));
                for (T next : options) {
                    linkedHashMap.put(((Option) next).getId(), next);
                }
                Option option = (Option) linkedHashMap.get(questionWAnswers.d().get(0).getOptionId());
                if (option != null) {
                    str = option.getTitle();
                } else {
                    str = null;
                }
                cmbTextView.setText(str);
            } else {
                cmbTextView.setText("");
            }
            cmbTextView.setOnClickListener(new a(publishSubject, questionWAnswers));
        }
    }

    public b() {
        PublishSubject<QuestionWAnswers> C0 = PublishSubject.C0();
        j.f(C0, "create()");
        this.f17521e = C0;
    }

    public final h<QuestionWAnswers> G() {
        h<QuestionWAnswers> v02 = this.f17521e.v0(BackpressureStrategy.BUFFER);
        j.f(v02, "clicksStream.toFlowable(…kpressureStrategy.BUFFER)");
        return v02;
    }

    public final void H(List<QuestionWAnswers> list) {
        j.g(list, "coreProfileAnswersWithQuestionAndOptions");
        this.f17520d = list;
    }

    public int g() {
        List<QuestionWAnswers> list = this.f17520d;
        if (list != null) {
            return list.size();
        }
        return 0;
    }

    public void v(RecyclerView.d0 d0Var, int i10) {
        List<QuestionWAnswers> list;
        j.g(d0Var, "holder");
        if ((d0Var instanceof a) && (list = this.f17520d) != null) {
            ((a) d0Var).W(list.get(i10), this.f17521e);
        }
    }

    public RecyclerView.d0 x(ViewGroup viewGroup, int i10) {
        j.g(viewGroup, Message.Thread.PARENT_ATTRIBUTE_NAME);
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.core_profile_data_item, viewGroup, false);
        j.f(inflate, "inflater.inflate(R.layou…data_item, parent, false)");
        return new a(inflate);
    }
}
