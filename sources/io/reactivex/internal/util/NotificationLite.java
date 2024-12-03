package io.reactivex.internal.util;

import java.io.Serializable;
import qj.u;
import rn.c;
import tj.b;

public enum NotificationLite {
    COMPLETE;

    static final class DisposableNotification implements Serializable {
        private static final long serialVersionUID = -7482590109178395495L;
        final b upstream;

        DisposableNotification(b bVar) {
            this.upstream = bVar;
        }

        public String toString() {
            return "NotificationLite.Disposable[" + this.upstream + "]";
        }
    }

    static final class ErrorNotification implements Serializable {
        private static final long serialVersionUID = -8759979445933046293L;

        /* renamed from: e  reason: collision with root package name */
        final Throwable f30715e;

        ErrorNotification(Throwable th2) {
            this.f30715e = th2;
        }

        public boolean equals(Object obj) {
            if (obj instanceof ErrorNotification) {
                return xj.b.c(this.f30715e, ((ErrorNotification) obj).f30715e);
            }
            return false;
        }

        public int hashCode() {
            return this.f30715e.hashCode();
        }

        public String toString() {
            return "NotificationLite.Error[" + this.f30715e + "]";
        }
    }

    static final class SubscriptionNotification implements Serializable {
        private static final long serialVersionUID = -1322257508628817540L;
        final c upstream;

        SubscriptionNotification(c cVar) {
            this.upstream = cVar;
        }

        public String toString() {
            return "NotificationLite.Subscription[" + this.upstream + "]";
        }
    }

    public static <T> boolean a(Object obj, u<? super T> uVar) {
        if (obj == COMPLETE) {
            uVar.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            uVar.onError(((ErrorNotification) obj).f30715e);
            return true;
        } else {
            uVar.d(obj);
            return false;
        }
    }

    public static <T> boolean b(Object obj, u<? super T> uVar) {
        if (obj == COMPLETE) {
            uVar.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            uVar.onError(((ErrorNotification) obj).f30715e);
            return true;
        } else if (obj instanceof DisposableNotification) {
            uVar.a(((DisposableNotification) obj).upstream);
            return false;
        } else {
            uVar.d(obj);
            return false;
        }
    }

    public static <T> boolean c(Object obj, rn.b<? super T> bVar) {
        if (obj == COMPLETE) {
            bVar.onComplete();
            return true;
        } else if (obj instanceof ErrorNotification) {
            bVar.onError(((ErrorNotification) obj).f30715e);
            return true;
        } else if (obj instanceof SubscriptionNotification) {
            bVar.e(((SubscriptionNotification) obj).upstream);
            return false;
        } else {
            bVar.d(obj);
            return false;
        }
    }

    public static Object d() {
        return COMPLETE;
    }

    public static Object e(b bVar) {
        return new DisposableNotification(bVar);
    }

    public static Object h(Throwable th2) {
        return new ErrorNotification(th2);
    }

    public static Throwable i(Object obj) {
        return ((ErrorNotification) obj).f30715e;
    }

    public static <T> T j(Object obj) {
        return obj;
    }

    public static boolean k(Object obj) {
        return obj == COMPLETE;
    }

    public static boolean l(Object obj) {
        return obj instanceof ErrorNotification;
    }

    public static <T> Object o(T t10) {
        return t10;
    }

    public static Object p(c cVar) {
        return new SubscriptionNotification(cVar);
    }

    public String toString() {
        return "NotificationLite.Complete";
    }
}
