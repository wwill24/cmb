package com.coffeemeetsbagel.models.responses;

import com.coffeemeetsbagel.qna.data.network.NetworkAnswer;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class ResponseAnswer extends ResponseGeneric {
    private NetworkAnswer data;

    public ResponseAnswer(NetworkAnswer networkAnswer) {
        j.g(networkAnswer, "data");
        this.data = networkAnswer;
    }

    public static /* synthetic */ ResponseAnswer copy$default(ResponseAnswer responseAnswer, NetworkAnswer networkAnswer, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            networkAnswer = responseAnswer.data;
        }
        return responseAnswer.copy(networkAnswer);
    }

    public final NetworkAnswer component1() {
        return this.data;
    }

    public final ResponseAnswer copy(NetworkAnswer networkAnswer) {
        j.g(networkAnswer, "data");
        return new ResponseAnswer(networkAnswer);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ResponseAnswer) && j.b(this.data, ((ResponseAnswer) obj).data);
    }

    public final NetworkAnswer getData() {
        return this.data;
    }

    public int hashCode() {
        return this.data.hashCode();
    }

    public final void setData(NetworkAnswer networkAnswer) {
        j.g(networkAnswer, "<set-?>");
        this.data = networkAnswer;
    }

    public String toString() {
        return "ResponseAnswer(data=" + this.data + PropertyUtils.MAPPED_DELIM2;
    }
}
