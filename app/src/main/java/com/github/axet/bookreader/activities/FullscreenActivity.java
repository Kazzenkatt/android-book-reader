package com.github.axet.bookreader.activities;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import com.google.android.material.navigation.NavigationView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;

import com.github.axet.androidlibrary.activities.AppCompatFullscreenThemeActivity;
import com.github.axet.bookreader2.R;
import com.github.axet.bookreader.app.BookApplication;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

public class FullscreenActivity extends AppCompatFullscreenThemeActivity {
    public Toolbar toolbar;

    public interface FullscreenListener {
        void onFullscreenChanged(boolean f);

        void onUserInteraction();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    public int getAppTheme() {
        return BookApplication.getTheme(this, R.style.AppThemeLight_NoActionBar, R.style.AppThemeDark_NoActionBar);
    }

    @Override
    public int getAppThemePopup() {
        return BookApplication.getTheme(this, R.style.AppThemeLight_PopupOverlay, R.style.AppThemeDark_PopupOverlay);
    }

    @SuppressLint({"InlinedApi", "RestrictedApi"})
    @Override
    public void setFullscreen(boolean b) {
        super.setFullscreen(b);
        FragmentManager fm = getSupportFragmentManager();
        List<Fragment> ff = fm.getFragments();
        if (ff != null) {
            for (Fragment f : ff) {
                if (f instanceof FullscreenActivity.FullscreenListener)
                    ((FullscreenActivity.FullscreenListener) f).onFullscreenChanged(b);
            }
        }
    }

    @Override
    public void hideSystemUI() {
        super.hideSystemUI();
        setFitsSystemWindows(this, false);
    }

    @Override
    public void showSystemUI() {
        super.showSystemUI();
        setFitsSystemWindows(this, true);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void onUserInteraction() {
        super.onUserInteraction();
        FragmentManager fm = getSupportFragmentManager();
        List<Fragment> ff = fm.getFragments();
        if (ff != null) {
            for (Fragment f : ff) {
                if (f instanceof FullscreenListener)
                    ((FullscreenListener) f).onUserInteraction();
            }
        }
    }
}
