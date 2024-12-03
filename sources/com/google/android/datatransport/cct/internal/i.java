package com.google.android.datatransport.cct.internal;

import androidx.annotation.NonNull;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.annotations.Encodable;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import java.util.List;

@Encodable
public abstract class i {
    @NonNull
    public static i a(@NonNull List<k> list) {
        return new d(list);
    }

    @NonNull
    public static DataEncoder b() {
        return new JsonDataEncoderBuilder().configureWith(b.f38033a).ignoreNullValues(true).build();
    }

    @NonNull
    @Encodable.Field(name = "logRequest")
    public abstract List<k> c();
}
