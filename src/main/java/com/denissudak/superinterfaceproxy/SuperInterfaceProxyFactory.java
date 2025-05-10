package com.denissudak.superinterfaceproxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static com.google.common.base.Preconditions.checkNotNull;
import static java.util.Objects.requireNonNull;

public class SuperInterfaceProxyFactory<Super, T extends Super> {
    private final Class<Super> superClass;

    public SuperInterfaceProxyFactory(Class<Super> superClass) {
        this.superClass = requireNonNull(superClass);
    }

    @SuppressWarnings("unchecked")
    public Super newProxy(T obj) {
        checkNotNull(obj);
        return (Super) Proxy.newProxyInstance(
                superClass.getClassLoader(),
                new Class[]{superClass},
                new PassThroughInvocationHandler(obj)
        );
    }

    private static class PassThroughInvocationHandler implements InvocationHandler {
        private final Object target;

        private PassThroughInvocationHandler(Object target) {
            this.target = requireNonNull(target);
        }

        @Override
        public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
            return method.invoke(target, args);
        }
    }
}
