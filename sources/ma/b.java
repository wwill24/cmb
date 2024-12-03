package ma;

import com.coffeemeetsbagel.models.responses.ResponseAnswer;
import com.coffeemeetsbagel.qna.data.network.AnswerBody;
import com.coffeemeetsbagel.qna.data.network.DeleteAnswerRequest;
import qj.a;
import qj.w;
import retrofit2.r;
import vn.o;
import vn.s;

public interface b {
    @o("/v4/questiongroups/{group}/answers")
    a a(@s("group") String str, @vn.a DeleteAnswerRequest deleteAnswerRequest);

    @o("/v4/questiongroups/{group}/answers")
    w<r<ResponseAnswer>> b(@s("group") String str, @vn.a AnswerBody answerBody);
}
