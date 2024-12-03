package ma;

import com.coffeemeetsbagel.models.body.QuestionGroupSkipBody;
import com.coffeemeetsbagel.models.responses.ResponseGeneric;
import com.coffeemeetsbagel.models.responses.ResponseQuestionGroup;
import qj.w;
import vn.a;
import vn.f;
import vn.o;
import vn.s;

public interface h {
    @f("/v4/questiongroups/{group}")
    w<ResponseQuestionGroup> a(@s("group") String str);

    @o("/v4/questiongroups/{group}/skip")
    w<ResponseGeneric> b(@s("group") String str, @a QuestionGroupSkipBody questionGroupSkipBody);
}
