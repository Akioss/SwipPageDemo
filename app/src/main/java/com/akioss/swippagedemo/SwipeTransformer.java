package com.akioss.swippagedemo;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;

/*****************************************************************************************************************
 * Author: liyi
 * Create Date: 16/5/12.
 * Package: com.akioss.swippagedemo
 * Discription:
 * Version: 1.0
 * ---------------------------------------------------------------------------------------------------------------
 * Modified By:
 * Modified Date:
 * Why & What is modified :
 *****************************************************************************************************************/
public class SwipeTransformer implements ViewPager.PageTransformer {

    private static final float MIN_SCALE = 0.75f;

    @Override
    public void transformPage(View view, float position) {
        int pageWidth = view.getWidth();
        ImageView mShowView = (ImageView) view.findViewById(R.id.show_iv);
        View line = view.findViewById(R.id.line_view);

        if (position < -1) { // [-Infinity,-1)
            // This page is way off-screen to the left.
            view.setAlpha(0);

        } else if (position <= 0) { // [-1,0]
            // Use the default slide transition when moving to the left page
            view.setAlpha(1);
            view.setTranslationX(0);
            view.setScaleX(1);
            view.setScaleY(1);
            mShowView.setTranslationY(0);

        } else if (position <= 1) { // (0,1]
            // Fade the page out.
            view.setAlpha(1 - position);

            // Counteract the default slide transition
            view.setTranslationX(pageWidth * -position);
            mShowView.setTranslationY((float) (-mShowView.getHeight() * 0.2) * -position);

            // Scale the page down (between MIN_SCALE and 1)
            float scaleFactor = MIN_SCALE
                    + (1 - MIN_SCALE) * (1 - Math.abs(position));
            line.setScaleX(1 - Math.abs(position));
            view.setScaleX(scaleFactor);
            view.setScaleY(scaleFactor);

        } else { // (1,+Infinity]
            // This page is way off-screen to the right.
            view.setAlpha(0);
        }
    }

}
