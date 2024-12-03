package com.coffeemeetsbagel.models.responses;

import com.coffeemeetsbagel.qna.data.network.NetworkQuestionGroup;
import kotlin.jvm.internal.j;
import org.apache.commons.beanutils.PropertyUtils;

public final class ResponseQuestionGroup extends ResponseGeneric {
    private NetworkQuestionGroup data;

    public ResponseQuestionGroup(NetworkQuestionGroup networkQuestionGroup) {
        this.data = networkQuestionGroup;
    }

    public static /* synthetic */ ResponseQuestionGroup copy$default(ResponseQuestionGroup responseQuestionGroup, NetworkQuestionGroup networkQuestionGroup, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            networkQuestionGroup = responseQuestionGroup.data;
        }
        return responseQuestionGroup.copy(networkQuestionGroup);
    }

    public final NetworkQuestionGroup component1() {
        return this.data;
    }

    public final ResponseQuestionGroup copy(NetworkQuestionGroup networkQuestionGroup) {
        return new ResponseQuestionGroup(networkQuestionGroup);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof ResponseQuestionGroup) && j.b(this.data, ((ResponseQuestionGroup) obj).data);
    }

    public final NetworkQuestionGroup getData() {
        return this.data;
    }

    public int hashCode() {
        NetworkQuestionGroup networkQuestionGroup = this.data;
        if (networkQuestionGroup == null) {
            return 0;
        }
        return networkQuestionGroup.hashCode();
    }

    public final void setData(NetworkQuestionGroup networkQuestionGroup) {
        this.data = networkQuestionGroup;
    }

    public String toString() {
        return "ResponseQuestionGroup(data=" + this.data + PropertyUtils.MAPPED_DELIM2;
    }
}
