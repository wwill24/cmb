package com.facebook.share.internal;

import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.share.internal.CameraEffectJSONUtility;
import com.facebook.share.model.CameraEffectArguments;
import kotlin.Metadata;
import kotlin.jvm.internal.j;
import org.jivesoftware.smackx.json.packet.JsonPacketExtension;
import org.json.JSONException;
import org.json.b;

@Metadata(bv = {}, d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016J\"\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\r"}, d2 = {"com/facebook/share/internal/CameraEffectJSONUtility$SETTERS$1", "Lcom/facebook/share/internal/CameraEffectJSONUtility$Setter;", "Lcom/facebook/share/model/CameraEffectArguments$Builder;", "builder", "", "key", "", "value", "", "setOnArgumentsBuilder", "Lorg/json/b;", "json", "setOnJSON", "facebook-common_release"}, k = 1, mv = {1, 5, 1})
public final class CameraEffectJSONUtility$SETTERS$1 implements CameraEffectJSONUtility.Setter {
    CameraEffectJSONUtility$SETTERS$1() {
    }

    public void setOnArgumentsBuilder(CameraEffectArguments.Builder builder, String str, Object obj) throws JSONException {
        j.g(builder, "builder");
        j.g(str, SDKConstants.PARAM_KEY);
        if (obj != null) {
            builder.putArgument(str, (String) obj);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
    }

    public void setOnJSON(b bVar, String str, Object obj) throws JSONException {
        j.g(bVar, JsonPacketExtension.ELEMENT);
        j.g(str, SDKConstants.PARAM_KEY);
        bVar.put(str, obj);
    }
}
