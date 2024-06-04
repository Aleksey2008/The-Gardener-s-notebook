package com.example.thegardenersnotebook;

import android.app.IntentService;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class NotificationService1 extends IntentService {

    private static final String CHANNEL_ID = "my_channel_id"; // Используйте одинаковый идентификатор канала

    public NotificationService1() {
        super("NotificationService1");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        createNotificationChannel();

        // Извлечение параметров уведомления из Intent
        String title = intent.getStringExtra("TITLE");
        String contentText = intent.getStringExtra("CONTENT_TEXT");
        int notificationId = intent.getIntExtra("NOTIFICATION_ID", 0); // Получение уникального ID уведомления

        // Получение ресурсов идентификаторов для иконок
        int smallIconResId = R.drawable.fon;
        int largeIconResId = R.drawable.fon;

        // Создание Bitmap из ресурсов идентификаторов для большой иконки
        Bitmap largeIconBitmap = BitmapFactory.decodeResource(getResources(), largeIconResId);

        // Создание уведомления с переданными параметрами
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(smallIconResId)
                .setContentTitle(title)
                .setContentText(contentText)
                .setLargeIcon(largeIconBitmap)
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        // Отправка уведомления
        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);
        notificationManager.notify(notificationId, builder.build());

        // Освобождение ресурсов Bitmap
        largeIconBitmap.recycle();
    }

    private void createNotificationChannel() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            CharSequence name = "My Channel";
            String description = "Channel description";
            int importance = NotificationManager.IMPORTANCE_DEFAULT;
            NotificationChannel channel = new NotificationChannel(CHANNEL_ID, name, importance);
            channel.setDescription(description);

            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }
    }
}
