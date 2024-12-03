package net.bytebuddy.utility;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import net.bytebuddy.utility.nullability.MaybeNull;

public interface Invoker {
    @MaybeNull
    Object invoke(Method method, @MaybeNull Object obj, @MaybeNull Object[] objArr) throws IllegalAccessException, InvocationTargetException;

    Object newInstance(Constructor<?> constructor, Object[] objArr) throws InstantiationException, IllegalAccessException, InvocationTargetException;
}
