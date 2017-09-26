package com.guagua.hookactivity;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.UserHandle;
import android.util.Log;

import java.lang.reflect.Method;

/**
 * Created by android on 7/21/17.
 */

public class InstrumentationProxy extends Instrumentation {

    private final Instrumentation mInstrumentation;

    public InstrumentationProxy(Instrumentation instrumentation) {
        this.mInstrumentation = instrumentation;
    }

    public Activity startActivitySync(Intent intent){
        Log.d("tag","");
        return null;
    }

    public ActivityResult execStartActivity(Context who, IBinder contextThread, IBinder token, Activity target,
                                            Intent intent, int requestCode, Bundle options, UserHandle user) {

        Log.d("tag","who:"+who.toString()+",token:"+token+",target:"+target+",intent:"+intent+",requestCode:"+requestCode
        +",options:"+options+",user:"+user);

        try {
            Method execStartActivity = Instrumentation.class.getDeclaredMethod(
                    "execStartActivity",
                    Context.class, IBinder.class, IBinder.class, Activity.class,
                    Intent.class, int.class, Bundle.class);
            execStartActivity.setAccessible(true);
            return (ActivityResult) execStartActivity.invoke(mInstrumentation, who,
                    contextThread, token, target, intent, requestCode, options);
        } catch (Exception e) {
            //如果你在这个类的成员变量Instrumentation的实例写错mInstrument,代码讲会执行到这里来
            throw new RuntimeException("if Instrumentation paramerter is mInstrumentation, hook will fail");
        }
    }

}
