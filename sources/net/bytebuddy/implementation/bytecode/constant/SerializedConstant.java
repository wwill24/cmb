package net.bytebuddy.implementation.bytecode.constant;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.implementation.Implementation;
import net.bytebuddy.implementation.bytecode.Duplication;
import net.bytebuddy.implementation.bytecode.StackManipulation;
import net.bytebuddy.implementation.bytecode.TypeCreation;
import net.bytebuddy.implementation.bytecode.member.MethodInvocation;
import net.bytebuddy.jar.asm.MethodVisitor;
import net.bytebuddy.utility.nullability.MaybeNull;

@HashCodeAndEqualsPlugin.Enhance
public class SerializedConstant extends StackManipulation.AbstractBase {
    private static final String CHARSET = "ISO-8859-1";
    private final String serialization;

    protected SerializedConstant(String str) {
        this.serialization = str;
    }

    public static StackManipulation of(@MaybeNull Serializable serializable) {
        ObjectOutputStream objectOutputStream;
        if (serializable == null) {
            return NullConstant.INSTANCE;
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
            objectOutputStream.writeObject(serializable);
            objectOutputStream.close();
            return new SerializedConstant(byteArrayOutputStream.toString("ISO-8859-1"));
        } catch (IOException e10) {
            throw new IllegalStateException("Cannot serialize " + serializable, e10);
        } catch (Throwable th2) {
            objectOutputStream.close();
            throw th2;
        }
    }

    public StackManipulation.Size apply(MethodVisitor methodVisitor, Implementation.Context context) {
        Class<String> cls = String.class;
        try {
            Duplication duplication = Duplication.SINGLE;
            return new StackManipulation.Compound(TypeCreation.of(TypeDescription.ForLoadedType.of(ObjectInputStream.class)), duplication, TypeCreation.of(TypeDescription.ForLoadedType.of(ByteArrayInputStream.class)), duplication, new TextConstant(this.serialization), new TextConstant("ISO-8859-1"), MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(cls.getMethod("getBytes", new Class[]{cls}))), MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedConstructor(ByteArrayInputStream.class.getConstructor(new Class[]{byte[].class}))), MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedConstructor(ObjectInputStream.class.getConstructor(new Class[]{InputStream.class}))), MethodInvocation.invoke((MethodDescription.InDefinedShape) new MethodDescription.ForLoadedMethod(ObjectInputStream.class.getMethod("readObject", new Class[0])))).apply(methodVisitor, context);
        } catch (NoSuchMethodException e10) {
            throw new IllegalStateException("Could not locate Java API method", e10);
        }
    }

    public boolean equals(@MaybeNull Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.serialization.equals(((SerializedConstant) obj).serialization);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.serialization.hashCode();
    }
}
