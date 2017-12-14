package com.fabernovel.constraintanimations.utils;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;

import com.fabernovel.constraintanimations.R;

public class NavigatorUtils {

    public static Bundle getInBundle(Context context) {
        return ActivityOptionsCompat.makeCustomAnimation(
            context, R.anim.slide_in, android.R.anim.fade_out).toBundle();
    }

    public static Bundle getUpBundle(Context context) {
        return ActivityOptionsCompat.makeCustomAnimation(
            context, R.anim.slide_up, android.R.anim.fade_out).toBundle();
    }

    public static Bundle getFadeBundle(Context context) {
        return ActivityOptionsCompat.makeCustomAnimation(
            context, android.R.anim.fade_in, android.R.anim.fade_out).toBundle();
    }
}
