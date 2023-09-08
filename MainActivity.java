import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class MainActivity extends AppCompatActivity {
    private TextView resultTextView;
    private StringBuilder input = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        resultTextView = findViewById(R.id.resultTextView);
    }

    // Add click handlers for digit buttons (0-9) and operator buttons (+, -, *, /)
    // Implement calculation logic here

    // Handle the "=" button click to perform the calculation and display the result
    public void onEqualClick(View view) {
        // Perform calculation and update the resultTextView
    }

    // Handle the "C" (Clear) button click to clear the input
    public void onClearClick(View view) {
        input.setLength(0);
        resultTextView.setText("");
    }

    // Show a notification with the result
    private void showNotification(String result) {
        String channelId = "CalculatorNotificationChannel";
        String channelName = "Calculator Notification Channel";
        int notificationId = 1;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_DEFAULT
            );
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(channel);
        }

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, channelId)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle("Calculator Result")
            .setContentText("Result: " + result)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(this);
        notificationManagerCompat.notify(notificationId, builder.build());
    }
}
