package com.coffeemeetsbagel.qna.data.network;

import com.coffeemeetsbagel.models.entities.QuestionInteractionPolicy;
import java.io.Serializable;
import java.util.List;
import kotlin.jvm.internal.j;
import lg.c;
import org.apache.commons.beanutils.PropertyUtils;

public final class NetworkQuestion implements Serializable {

    /* renamed from: id  reason: collision with root package name */
    private final String f36268id;
    @c("interaction_policy")
    private final QuestionInteractionPolicy interactionPolicy;
    private final String label;
    private final String name;
    private final List<NetworkOption> options;
    private final String placeholder;
    private final String text;
    private final String title;
    private final String type;

    public NetworkQuestion(String str, List<NetworkOption> list, String str2, String str3, String str4, String str5, String str6, String str7, QuestionInteractionPolicy questionInteractionPolicy) {
        j.g(str, "id");
        j.g(str2, "title");
        j.g(str3, "type");
        j.g(str4, "placeholder");
        j.g(str5, "label");
        j.g(str6, "text");
        j.g(str7, "name");
        this.f36268id = str;
        this.options = list;
        this.title = str2;
        this.type = str3;
        this.placeholder = str4;
        this.label = str5;
        this.text = str6;
        this.name = str7;
        this.interactionPolicy = questionInteractionPolicy;
    }

    public static /* synthetic */ NetworkQuestion copy$default(NetworkQuestion networkQuestion, String str, List list, String str2, String str3, String str4, String str5, String str6, String str7, QuestionInteractionPolicy questionInteractionPolicy, int i10, Object obj) {
        NetworkQuestion networkQuestion2 = networkQuestion;
        int i11 = i10;
        return networkQuestion.copy((i11 & 1) != 0 ? networkQuestion2.f36268id : str, (i11 & 2) != 0 ? networkQuestion2.options : list, (i11 & 4) != 0 ? networkQuestion2.title : str2, (i11 & 8) != 0 ? networkQuestion2.type : str3, (i11 & 16) != 0 ? networkQuestion2.placeholder : str4, (i11 & 32) != 0 ? networkQuestion2.label : str5, (i11 & 64) != 0 ? networkQuestion2.text : str6, (i11 & 128) != 0 ? networkQuestion2.name : str7, (i11 & 256) != 0 ? networkQuestion2.interactionPolicy : questionInteractionPolicy);
    }

    public final String component1() {
        return this.f36268id;
    }

    public final List<NetworkOption> component2() {
        return this.options;
    }

    public final String component3() {
        return this.title;
    }

    public final String component4() {
        return this.type;
    }

    public final String component5() {
        return this.placeholder;
    }

    public final String component6() {
        return this.label;
    }

    public final String component7() {
        return this.text;
    }

    public final String component8() {
        return this.name;
    }

    public final QuestionInteractionPolicy component9() {
        return this.interactionPolicy;
    }

    public final NetworkQuestion copy(String str, List<NetworkOption> list, String str2, String str3, String str4, String str5, String str6, String str7, QuestionInteractionPolicy questionInteractionPolicy) {
        j.g(str, "id");
        j.g(str2, "title");
        j.g(str3, "type");
        String str8 = str4;
        j.g(str8, "placeholder");
        String str9 = str5;
        j.g(str9, "label");
        String str10 = str6;
        j.g(str10, "text");
        String str11 = str7;
        j.g(str11, "name");
        return new NetworkQuestion(str, list, str2, str3, str8, str9, str10, str11, questionInteractionPolicy);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof NetworkQuestion)) {
            return false;
        }
        NetworkQuestion networkQuestion = (NetworkQuestion) obj;
        return j.b(this.f36268id, networkQuestion.f36268id) && j.b(this.options, networkQuestion.options) && j.b(this.title, networkQuestion.title) && j.b(this.type, networkQuestion.type) && j.b(this.placeholder, networkQuestion.placeholder) && j.b(this.label, networkQuestion.label) && j.b(this.text, networkQuestion.text) && j.b(this.name, networkQuestion.name) && j.b(this.interactionPolicy, networkQuestion.interactionPolicy);
    }

    public final String getId() {
        return this.f36268id;
    }

    public final QuestionInteractionPolicy getInteractionPolicy() {
        return this.interactionPolicy;
    }

    public final String getLabel() {
        return this.label;
    }

    public final String getName() {
        return this.name;
    }

    public final List<NetworkOption> getOptions() {
        return this.options;
    }

    public final String getPlaceholder() {
        return this.placeholder;
    }

    public final String getText() {
        return this.text;
    }

    public final String getTitle() {
        return this.title;
    }

    public final String getType() {
        return this.type;
    }

    public int hashCode() {
        int hashCode = this.f36268id.hashCode() * 31;
        List<NetworkOption> list = this.options;
        int i10 = 0;
        int hashCode2 = (((((((((((((hashCode + (list == null ? 0 : list.hashCode())) * 31) + this.title.hashCode()) * 31) + this.type.hashCode()) * 31) + this.placeholder.hashCode()) * 31) + this.label.hashCode()) * 31) + this.text.hashCode()) * 31) + this.name.hashCode()) * 31;
        QuestionInteractionPolicy questionInteractionPolicy = this.interactionPolicy;
        if (questionInteractionPolicy != null) {
            i10 = questionInteractionPolicy.hashCode();
        }
        return hashCode2 + i10;
    }

    public String toString() {
        return "NetworkQuestion(id=" + this.f36268id + ", options=" + this.options + ", title=" + this.title + ", type=" + this.type + ", placeholder=" + this.placeholder + ", label=" + this.label + ", text=" + this.text + ", name=" + this.name + ", interactionPolicy=" + this.interactionPolicy + PropertyUtils.MAPPED_DELIM2;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ NetworkQuestion(java.lang.String r14, java.util.List r15, java.lang.String r16, java.lang.String r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, com.coffeemeetsbagel.models.entities.QuestionInteractionPolicy r22, int r23, kotlin.jvm.internal.DefaultConstructorMarker r24) {
        /*
            r13 = this;
            r0 = r23
            r1 = r0 & 2
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r5 = r2
            goto L_0x000a
        L_0x0009:
            r5 = r15
        L_0x000a:
            r0 = r0 & 256(0x100, float:3.59E-43)
            if (r0 == 0) goto L_0x0010
            r12 = r2
            goto L_0x0012
        L_0x0010:
            r12 = r22
        L_0x0012:
            r3 = r13
            r4 = r14
            r6 = r16
            r7 = r17
            r8 = r18
            r9 = r19
            r10 = r20
            r11 = r21
            r3.<init>(r4, r5, r6, r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.coffeemeetsbagel.qna.data.network.NetworkQuestion.<init>(java.lang.String, java.util.List, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, com.coffeemeetsbagel.models.entities.QuestionInteractionPolicy, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }
}
