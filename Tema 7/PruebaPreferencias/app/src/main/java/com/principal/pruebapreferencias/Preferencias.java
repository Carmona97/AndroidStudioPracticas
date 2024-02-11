package com.principal.pruebapreferencias;

import android.os.Bundle;
import android.preference.PreferenceActivity;

import androidx.annotation.Nullable;

import java.util.prefs.Preferences;

public class Preferencias extends PreferenceActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferencias);
    }
}
