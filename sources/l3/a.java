package l3;

import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.EncodeStrategy;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f15994a = new C0167a();

    /* renamed from: b  reason: collision with root package name */
    public static final a f15995b = new b();

    /* renamed from: c  reason: collision with root package name */
    public static final a f15996c = new c();

    /* renamed from: d  reason: collision with root package name */
    public static final a f15997d = new d();

    /* renamed from: e  reason: collision with root package name */
    public static final a f15998e = new e();

    /* renamed from: l3.a$a  reason: collision with other inner class name */
    class C0167a extends a {
        C0167a() {
        }

        public boolean a() {
            return true;
        }

        public boolean b() {
            return true;
        }

        public boolean c(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        public boolean d(boolean z10, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    }

    class b extends a {
        b() {
        }

        public boolean a() {
            return false;
        }

        public boolean b() {
            return false;
        }

        public boolean c(DataSource dataSource) {
            return false;
        }

        public boolean d(boolean z10, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }
    }

    class c extends a {
        c() {
        }

        public boolean a() {
            return true;
        }

        public boolean b() {
            return false;
        }

        public boolean c(DataSource dataSource) {
            return (dataSource == DataSource.DATA_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }

        public boolean d(boolean z10, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return false;
        }
    }

    class d extends a {
        d() {
        }

        public boolean a() {
            return false;
        }

        public boolean b() {
            return true;
        }

        public boolean c(DataSource dataSource) {
            return false;
        }

        public boolean d(boolean z10, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return (dataSource == DataSource.RESOURCE_DISK_CACHE || dataSource == DataSource.MEMORY_CACHE) ? false : true;
        }
    }

    class e extends a {
        e() {
        }

        public boolean a() {
            return true;
        }

        public boolean b() {
            return true;
        }

        public boolean c(DataSource dataSource) {
            return dataSource == DataSource.REMOTE;
        }

        public boolean d(boolean z10, DataSource dataSource, EncodeStrategy encodeStrategy) {
            return ((z10 && dataSource == DataSource.DATA_DISK_CACHE) || dataSource == DataSource.LOCAL) && encodeStrategy == EncodeStrategy.TRANSFORMED;
        }
    }

    public abstract boolean a();

    public abstract boolean b();

    public abstract boolean c(DataSource dataSource);

    public abstract boolean d(boolean z10, DataSource dataSource, EncodeStrategy encodeStrategy);
}
