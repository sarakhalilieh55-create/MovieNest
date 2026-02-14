package com.example.movienest;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import java.util.Locale;

public class SettingsActivity extends AppCompatActivity {

        private Switch switchDarkMode;
        private EditText editUsername;
        private Spinner spinnerLanguage;
        private SharedPreferences prefs;

        private Button btnLogout, btnAddAccount, btnContactUs;

        @SuppressLint({"MissingInflatedId", "WrongViewCast"})
        @Override
        protected void onCreate(Bundle savedInstanceState) {

            // تحميل SharedPreferences
            prefs = getSharedPreferences("app_settings", MODE_PRIVATE);

            // تطبيق الوضع الليلي المخزن قبل إنشاء الواجهة
            boolean isDark = prefs.getBoolean("dark_mode", false);
            if (isDark) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }

            // تحميل اللغة المخزنة قبل إنشاء الواجهة
            String lang = prefs.getString("language", "ar");
            setLocale(lang);

            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_settings);

            // ربط العناصر من XML
            switchDarkMode = findViewById(R.id.switchDarkMode);
            editUsername = findViewById(R.id.editUsername);
            spinnerLanguage = findViewById(R.id.editUsername);

            btnLogout = findViewById(R.id.btnLogout);
            btnAddAccount = findViewById(R.id.btnAddAccount);
            btnContactUs = findViewById(R.id.btnContactUs);

            // إعداد Spinner للغة
            ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                    R.array.languages, android.R.layout.simple_spinner_item);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerLanguage.setAdapter(adapter);

            // تحميل البيانات المخزنة
            switchDarkMode.setChecked(isDark);
            editUsername.setText(prefs.getString("username", ""));
            spinnerLanguage.setSelection(lang.equals("ar") ? 0 : 1);

            // الوضع الليلي مباشرة
            switchDarkMode.setOnCheckedChangeListener((buttonView, isChecked) -> {
                prefs.edit().putBoolean("dark_mode", isChecked).apply();
                if (isChecked) {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                } else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                }
                recreate();
            });

            // حفظ اسم المستخدم عند فقدان التركيز
            editUsername.setOnFocusChangeListener((v, hasFocus) -> {
                if (!hasFocus) {
                    prefs.edit().putString("username", editUsername.getText().toString()).apply();
                }
            });

            // تغيير اللغة فورًا
            spinnerLanguage.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                    String selected = position == 0 ? "ar" : "en";
                    prefs.edit().putString("language", selected).apply();
                    setLocale(selected);
                    recreate();
                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {}
            });

            // زر تسجيل الخروج
            btnLogout.setOnClickListener(v -> {
                prefs.edit().clear().apply();
                // مثال: إعادة التوجيه لصفحة تسجيل الدخول
                // Intent intent = new Intent(SettingsActivity.this, LoginActivity.class);
                // startActivity(intent);
                // finish();
            });

            // زر إضافة حساب آخر
            btnAddAccount.setOnClickListener(v -> {
                // مثال: فتح LoginActivity لإضافة حساب
                // Intent intent = new Intent(SettingsActivity.this, LoginActivity.class);
                // startActivity(intent);
            });

            // زر التواصل معنا
            btnContactUs.setOnClickListener(v -> {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("message/rfc822");
                intent.putExtra(Intent.EXTRA_EMAIL, new String[]{"support@example.com"});
                intent.putExtra(Intent.EXTRA_SUBJECT, "مراسلة من التطبيق");
                intent.putExtra(Intent.EXTRA_TEXT, "");
                startActivity(Intent.createChooser(intent, "اختر تطبيق المراسلة"));
            });
        }

        // دالة لتغيير لغة التطبيق
        private void setLocale(String langCode) {
            Locale locale = new Locale(langCode);
            Locale.setDefault(locale);
            Configuration config = new Configuration();
            config.setLocale(locale);
            getResources().updateConfiguration(config, getResources().getDisplayMetrics());
        }
    }
