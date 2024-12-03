package com.squareup.moshi;

import java.io.IOException;
import okio.Buffer;
import okio.BufferedSource;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

final class o implements Source {

    /* renamed from: h  reason: collision with root package name */
    static final ByteString f22985h = ByteString.e("[]{}\"'/#");

    /* renamed from: j  reason: collision with root package name */
    static final ByteString f22986j = ByteString.e("'\\");

    /* renamed from: k  reason: collision with root package name */
    static final ByteString f22987k = ByteString.e("\"\\");

    /* renamed from: l  reason: collision with root package name */
    static final ByteString f22988l = ByteString.e("\r\n");

    /* renamed from: m  reason: collision with root package name */
    static final ByteString f22989m = ByteString.e("*");

    /* renamed from: n  reason: collision with root package name */
    static final ByteString f22990n = ByteString.f33309d;

    /* renamed from: a  reason: collision with root package name */
    private final BufferedSource f22991a;

    /* renamed from: b  reason: collision with root package name */
    private final Buffer f22992b;

    /* renamed from: c  reason: collision with root package name */
    private final Buffer f22993c;

    /* renamed from: d  reason: collision with root package name */
    private ByteString f22994d;

    /* renamed from: e  reason: collision with root package name */
    private int f22995e;

    /* renamed from: f  reason: collision with root package name */
    private long f22996f = 0;

    /* renamed from: g  reason: collision with root package name */
    private boolean f22997g = false;

    o(BufferedSource bufferedSource, Buffer buffer, ByteString byteString, int i10) {
        this.f22991a = bufferedSource;
        this.f22992b = bufferedSource.d();
        this.f22993c = buffer;
        this.f22994d = byteString;
        this.f22995e = i10;
    }

    private void a(long j10) throws IOException {
        ByteString byteString;
        while (true) {
            long j11 = this.f22996f;
            if (j11 < j10 && this.f22994d != (byteString = f22990n)) {
                if (j11 == this.f22992b.size()) {
                    if (this.f22996f <= 0) {
                        this.f22991a.G0(1);
                    } else {
                        return;
                    }
                }
                long v10 = this.f22992b.v(this.f22994d, this.f22996f);
                if (v10 == -1) {
                    this.f22996f = this.f22992b.size();
                } else {
                    byte l10 = this.f22992b.l(v10);
                    ByteString byteString2 = this.f22994d;
                    ByteString byteString3 = f22985h;
                    if (byteString2 == byteString3) {
                        if (l10 == 34) {
                            this.f22994d = f22987k;
                            this.f22996f = v10 + 1;
                        } else if (l10 == 35) {
                            this.f22994d = f22988l;
                            this.f22996f = v10 + 1;
                        } else if (l10 == 39) {
                            this.f22994d = f22986j;
                            this.f22996f = v10 + 1;
                        } else if (l10 != 47) {
                            if (l10 != 91) {
                                if (l10 != 93) {
                                    if (l10 != 123) {
                                        if (l10 != 125) {
                                        }
                                    }
                                }
                                int i10 = this.f22995e - 1;
                                this.f22995e = i10;
                                if (i10 == 0) {
                                    this.f22994d = byteString;
                                }
                                this.f22996f = v10 + 1;
                            }
                            this.f22995e++;
                            this.f22996f = v10 + 1;
                        } else {
                            long j12 = 2 + v10;
                            this.f22991a.G0(j12);
                            long j13 = v10 + 1;
                            byte l11 = this.f22992b.l(j13);
                            if (l11 == 47) {
                                this.f22994d = f22988l;
                                this.f22996f = j12;
                            } else if (l11 == 42) {
                                this.f22994d = f22989m;
                                this.f22996f = j12;
                            } else {
                                this.f22996f = j13;
                            }
                        }
                    } else if (byteString2 == f22986j || byteString2 == f22987k) {
                        if (l10 == 92) {
                            long j14 = v10 + 2;
                            this.f22991a.G0(j14);
                            this.f22996f = j14;
                        } else {
                            if (this.f22995e > 0) {
                                byteString = byteString3;
                            }
                            this.f22994d = byteString;
                            this.f22996f = v10 + 1;
                        }
                    } else if (byteString2 == f22989m) {
                        long j15 = 2 + v10;
                        this.f22991a.G0(j15);
                        long j16 = v10 + 1;
                        if (this.f22992b.l(j16) == 47) {
                            this.f22996f = j15;
                            this.f22994d = byteString3;
                        } else {
                            this.f22996f = j16;
                        }
                    } else if (byteString2 == f22988l) {
                        this.f22996f = v10 + 1;
                        this.f22994d = byteString3;
                    } else {
                        throw new AssertionError();
                    }
                }
            } else {
                return;
            }
        }
    }

    public long N1(Buffer buffer, long j10) throws IOException {
        if (this.f22997g) {
            throw new IllegalStateException("closed");
        } else if (j10 == 0) {
            return 0;
        } else {
            if (!this.f22993c.Y0()) {
                long N1 = this.f22993c.N1(buffer, j10);
                long j11 = j10 - N1;
                if (this.f22992b.Y0()) {
                    return N1;
                }
                long N12 = N1(buffer, j11);
                if (N12 != -1) {
                    return N1 + N12;
                }
                return N1;
            }
            a(j10);
            long j12 = this.f22996f;
            if (j12 != 0) {
                long min = Math.min(j10, j12);
                buffer.k0(this.f22992b, min);
                this.f22996f -= min;
                return min;
            } else if (this.f22994d == f22990n) {
                return -1;
            } else {
                throw new AssertionError();
            }
        }
    }

    public void b() throws IOException {
        this.f22997g = true;
        while (this.f22994d != f22990n) {
            a(8192);
            this.f22991a.skip(this.f22996f);
        }
    }

    public void close() throws IOException {
        this.f22997g = true;
    }

    public Timeout p() {
        return this.f22991a.p();
    }
}
