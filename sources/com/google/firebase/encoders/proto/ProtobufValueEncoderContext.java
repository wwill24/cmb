package com.google.firebase.encoders.proto;

import androidx.annotation.NonNull;
import com.google.firebase.encoders.EncodingException;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ValueEncoderContext;
import java.io.IOException;

class ProtobufValueEncoderContext implements ValueEncoderContext {
    private boolean encoded = false;
    private FieldDescriptor field;
    private final ProtobufDataEncoderContext objEncoderCtx;
    private boolean skipDefault = false;

    ProtobufValueEncoderContext(ProtobufDataEncoderContext protobufDataEncoderContext) {
        this.objEncoderCtx = protobufDataEncoderContext;
    }

    private void checkNotUsed() {
        if (!this.encoded) {
            this.encoded = true;
            return;
        }
        throw new EncodingException("Cannot encode a second value in the ValueEncoderContext");
    }

    @NonNull
    public ValueEncoderContext add(String str) throws IOException {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, (Object) str, this.skipDefault);
        return this;
    }

    /* access modifiers changed from: package-private */
    public void resetContext(FieldDescriptor fieldDescriptor, boolean z10) {
        this.encoded = false;
        this.field = fieldDescriptor;
        this.skipDefault = z10;
    }

    @NonNull
    public ValueEncoderContext add(float f10) throws IOException {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, f10, this.skipDefault);
        return this;
    }

    @NonNull
    public ValueEncoderContext add(double d10) throws IOException {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, d10, this.skipDefault);
        return this;
    }

    @NonNull
    public ValueEncoderContext add(int i10) throws IOException {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, i10, this.skipDefault);
        return this;
    }

    @NonNull
    public ValueEncoderContext add(long j10) throws IOException {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, j10, this.skipDefault);
        return this;
    }

    @NonNull
    public ValueEncoderContext add(boolean z10) throws IOException {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, z10, this.skipDefault);
        return this;
    }

    @NonNull
    public ValueEncoderContext add(@NonNull byte[] bArr) throws IOException {
        checkNotUsed();
        this.objEncoderCtx.add(this.field, (Object) bArr, this.skipDefault);
        return this;
    }
}
