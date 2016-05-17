package com.akioss.swippagedemo;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
public class SwipAdapter extends FragmentPagerAdapter {

    private List<Map<String, String>> datas;

    public SwipAdapter(FragmentManager fm, List<Map<String, String>> datas) {
        super(fm);
        if (datas != null) {
            this.datas = datas;
        } else {
            datas = new ArrayList<>();
        }
    }

    @Override
    public Fragment getItem(int position) {
        return SwipeFragment.newInstance(datas.get(position).get("title"));
    }

    @Override
    public int getCount() {
        return datas.size();
    }

}
