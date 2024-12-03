package com.coffeemeetsbagel.qna.data;

import com.coffeemeetsbagel.qna.data.network.NetworkAnswer;
import java.util.List;
import vj.a;

public final /* synthetic */ class r implements a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NetworkAnswer f36274a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f36275b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ QuestionRepository f36276c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ List f36277d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f36278e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f36279f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ Integer f36280g;

    /* renamed from: h  reason: collision with root package name */
    public final /* synthetic */ Float f36281h;

    public /* synthetic */ r(NetworkAnswer networkAnswer, String str, QuestionRepository questionRepository, List list, String str2, String str3, Integer num, Float f10) {
        this.f36274a = networkAnswer;
        this.f36275b = str;
        this.f36276c = questionRepository;
        this.f36277d = list;
        this.f36278e = str2;
        this.f36279f = str3;
        this.f36280g = num;
        this.f36281h = f10;
    }

    public final void run() {
        QuestionRepository$postAnswer$1.d(this.f36274a, this.f36275b, this.f36276c, this.f36277d, this.f36278e, this.f36279f, this.f36280g, this.f36281h);
    }
}
