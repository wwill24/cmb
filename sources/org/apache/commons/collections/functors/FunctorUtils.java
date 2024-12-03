package org.apache.commons.collections.functors;

import com.facebook.internal.ServerProtocol;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.collections.Closure;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.Transformer;

class FunctorUtils {
    static final String UNSAFE_SERIALIZABLE_PROPERTY = "org.apache.commons.collections.enableUnsafeSerialization";

    private FunctorUtils() {
    }

    static void checkUnsafeSerialization(Class cls) {
        String str;
        try {
            str = (String) AccessController.doPrivileged(new PrivilegedAction() {
                public Object run() {
                    return System.getProperty(FunctorUtils.UNSAFE_SERIALIZABLE_PROPERTY);
                }
            });
        } catch (SecurityException unused) {
            str = null;
        }
        if (!ServerProtocol.DIALOG_RETURN_SCOPES_TRUE.equalsIgnoreCase(str)) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("Serialization support for ");
            stringBuffer.append(cls.getName());
            stringBuffer.append(" is disabled for security reasons. ");
            stringBuffer.append("To enable it set system property '");
            stringBuffer.append(UNSAFE_SERIALIZABLE_PROPERTY);
            stringBuffer.append("' to 'true', ");
            stringBuffer.append("but you must ensure that your application does not de-serialize objects from untrusted sources.");
            throw new UnsupportedOperationException(stringBuffer.toString());
        }
    }

    static Predicate[] copy(Predicate[] predicateArr) {
        if (predicateArr == null) {
            return null;
        }
        return (Predicate[]) predicateArr.clone();
    }

    static void validate(Predicate[] predicateArr) {
        if (predicateArr != null) {
            int i10 = 0;
            while (i10 < predicateArr.length) {
                if (predicateArr[i10] != null) {
                    i10++;
                } else {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("The predicate array must not contain a null predicate, index ");
                    stringBuffer.append(i10);
                    stringBuffer.append(" was null");
                    throw new IllegalArgumentException(stringBuffer.toString());
                }
            }
            return;
        }
        throw new IllegalArgumentException("The predicate array must not be null");
    }

    static Closure[] copy(Closure[] closureArr) {
        if (closureArr == null) {
            return null;
        }
        return (Closure[]) closureArr.clone();
    }

    static Transformer[] copy(Transformer[] transformerArr) {
        if (transformerArr == null) {
            return null;
        }
        return (Transformer[]) transformerArr.clone();
    }

    static Predicate[] validate(Collection collection) {
        if (collection != null) {
            Predicate[] predicateArr = new Predicate[collection.size()];
            int i10 = 0;
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                Predicate predicate = (Predicate) it.next();
                predicateArr[i10] = predicate;
                if (predicate != null) {
                    i10++;
                } else {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("The predicate collection must not contain a null predicate, index ");
                    stringBuffer.append(i10);
                    stringBuffer.append(" was null");
                    throw new IllegalArgumentException(stringBuffer.toString());
                }
            }
            return predicateArr;
        }
        throw new IllegalArgumentException("The predicate collection must not be null");
    }

    static void validate(Closure[] closureArr) {
        if (closureArr != null) {
            int i10 = 0;
            while (i10 < closureArr.length) {
                if (closureArr[i10] != null) {
                    i10++;
                } else {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("The closure array must not contain a null closure, index ");
                    stringBuffer.append(i10);
                    stringBuffer.append(" was null");
                    throw new IllegalArgumentException(stringBuffer.toString());
                }
            }
            return;
        }
        throw new IllegalArgumentException("The closure array must not be null");
    }

    static void validate(Transformer[] transformerArr) {
        if (transformerArr != null) {
            int i10 = 0;
            while (i10 < transformerArr.length) {
                if (transformerArr[i10] != null) {
                    i10++;
                } else {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("The transformer array must not contain a null transformer, index ");
                    stringBuffer.append(i10);
                    stringBuffer.append(" was null");
                    throw new IllegalArgumentException(stringBuffer.toString());
                }
            }
            return;
        }
        throw new IllegalArgumentException("The transformer array must not be null");
    }
}
