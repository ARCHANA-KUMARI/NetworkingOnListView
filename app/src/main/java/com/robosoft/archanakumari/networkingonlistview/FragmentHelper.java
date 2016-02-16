package com.robosoft.archanakumari.networkingonlistview;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;



/**
 * Created by archanakumari on 16/12/15.
 */
public class FragmentHelper {
    public static void replaceFragment(int containerId,Fragment fragment,FragmentActivity activity){
         FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.replace(containerId,fragment);

    }
    public static void replaceFragmentAndAddToBackstack(int containerId,Fragment fragment,FragmentActivity activity){
        FragmentTransaction transaction = activity.getSupportFragmentManager().beginTransaction();
        transaction.add(containerId,fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }

}
