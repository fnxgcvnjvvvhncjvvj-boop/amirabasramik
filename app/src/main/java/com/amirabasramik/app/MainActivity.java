package com.amirabasramik.app;

import android.app.Activity;
import android.os.Bundle;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.*;

public class MainActivity extends Activity {
    LinearLayout messages;
    EditText input;

    @Override
    public void onCreate(Bundle b) {
        super.onCreate(b);

        LinearLayout root = new LinearLayout(this);
        root.setOrientation(1);
        root.setPadding(18, 24, 18, 18);
        root.setBackgroundColor(Color.rgb(15, 20, 35));

        TextView title = new TextView(this);
        title.setText("𝒶𝓂𝒾𝓇𝒶𝒷𝒶𝓈𝓇𝒶𝓂𝒾𝓀");
        title.setTextSize(23);
        title.setTextColor(Color.WHITE);
        title.setGravity(Gravity.CENTER);
        root.addView(title);

        TextView info = new TextView(this);
        info.setText("نسخه آزمایشی برنامه");
        info.setTextColor(Color.LTGRAY);
        info.setGravity(Gravity.CENTER);
        root.addView(info);

        ScrollView scroll = new ScrollView(this);
        messages = new LinearLayout(this);
        messages.setOrientation(1);
        scroll.addView(messages);
        root.addView(scroll, new LinearLayout.LayoutParams(-1, 0, 1));

        addMessage("سلام! به برنامه خوش آمدی.", false);

        LinearLayout bar = new LinearLayout(this);
        input = new EditText(this);
        input.setHint("پیامت را بنویس");
        input.setTextColor(Color.WHITE);
        input.setHintTextColor(Color.GRAY);
        bar.addView(input, new LinearLayout.LayoutParams(0, -2, 1));

        Button send = new Button(this);
        send.setText("ارسال");
        send.setOnClickListener(v -> {
            String s = input.getText().toString().trim();
            if (!s.isEmpty()) {
                addMessage(s, true);
                addMessage("پیامت ثبت شد. اتصال هوش مصنوعی در نسخه بعدی اضافه می‌شود.", false);
                input.setText("");
            }
        });
        bar.addView(send);
        root.addView(bar);

        setContentView(root);
    }

    void addMessage(String s, boolean mine) {
        TextView t = new TextView(this);
        t.setText(s);
        t.setTextColor(Color.WHITE);
        t.setTextSize(16);
        t.setPadding(14, 12, 14, 12);
        t.setBackgroundColor(mine ? 0xff245b96 : 0xff303b50);
        LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(-2, -2);
        p.gravity = mine ? Gravity.RIGHT : Gravity.LEFT;
        p.setMargins(4, 8, 4, 8);
        messages.addView(t, p);
    }
}
