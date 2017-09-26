package com.guagua.hookactivity;

import android.app.Application;
import android.app.Instrumentation;
import android.content.Context;
import android.util.Log;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by android on 7/21/17.
 */

public class AppApplication extends Application {


    private Class<?> activityThreadClass;
    private Object o;


    @Override
    public void onCreate() {
        super.onCreate();
        hook();
    }

    private void hook() {
        HookUtils hookUtils=new HookUtils(getBaseContext());
        hookUtils.hookAms();
        hookUtils.hookSystemHandler();
//        hookUtils.hookNavUtils();
//        getActivityThread();


    }
//
//    private void getActivityThread() {
//        try {
//            activityThreadClass = Class.forName("android.app.ActivityThread");
//
//            Method currentActivityThread = activityThreadClass.getDeclaredMethod("currentActivityThread");
//            if (!currentActivityThread.isAccessible()){
//                currentActivityThread.setAccessible(true);
//            }
//            Object sCurrentActivityThread = currentActivityThread.invoke(null);
//            Field mInstrumentationField = sCurrentActivityThread.getClass().getDeclaredField("mInstrumentation");
//            if (!mInstrumentationField.isAccessible()){
//                mInstrumentationField.setAccessible(true);
//            }
//            Instrumentation mInstrumentation= (Instrumentation) mInstrumentationField.get(sCurrentActivityThread);
//            InstrumentationProxy instrumentationProxy = new InstrumentationProxy(mInstrumentation);
//            mInstrumentationField.set(sCurrentActivityThread,instrumentationProxy);
//
//            Log.d("tag",mInstrumentation.toString());
//
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        } catch (InvocationTargetException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (NoSuchFieldException e) {
//            e.printStackTrace();
//        }
//    }
}
