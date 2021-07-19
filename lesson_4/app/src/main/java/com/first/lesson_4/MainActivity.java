package com.first.lesson_4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;

import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        // Вывод ресурсов в строки программно
        initSomeTexts();

        ImageView image = findViewById(R.id.imageView);
        loadImageFromAsset(image, "B.png");

        initList();
    }

    private void initSomeTexts() {

        Typeface tf = Typeface.createFromAsset(getAssets(), "fonts/19659.ttf");

        TextView descriptionLanguage = findViewById(R.id.textVLang);
        descriptionLanguage.setText(getResources().getString(R.string.descriptionLanguage));
        descriptionLanguage.setTypeface(tf); // вставили шрифт

        TextView textLanguage = findViewById(R.id.textLang);
        textLanguage.setText(getResources().getString(R.string.language));
    }

    public void loadImageFromAsset(ImageView image, String fileName) {
        try {
            InputStream ims = getAssets().open(fileName);
            // загружаем как Drawable
            Drawable d = Drawable.createFromStream(ims, null);
            // выводим картинку в ImageView
            image.setImageDrawable(d);
        } catch (IOException ex) {
            return;
        }
    }

    private void initList() {
        LinearLayout layoutList = findViewById(R.id.layoutList);

        String[] versions = getResources().getStringArray(R.array.version_names);

        // При помощи этого объекта будем надувать элементы, спрятанные в android_item.xml
        LayoutInflater ltInflater = getLayoutInflater();

        for (int i = 0; i < versions.length; i++) {
            String version = versions[i];

            // Достаём элемент из android_item.xml
            View item = ltInflater.inflate(R.layout.android_item, layoutList, false);

            // Находим в этом элементе TextView
            TextView tv = item.findViewById(R.id.textAndroid);
            tv.setText(version);

            // Получить из ресурсов массив указателей на изображения
            TypedArray imgs = getResources().obtainTypedArray(R.array.version_logos);

            // Выбрать по индексу подходящее изображение
            AppCompatImageView imgLogo = item.findViewById(R.id.imageAndroid);
            imgLogo.setImageResource(imgs.getResourceId(i, -1));

            layoutList.addView(item);


        }
    }
}