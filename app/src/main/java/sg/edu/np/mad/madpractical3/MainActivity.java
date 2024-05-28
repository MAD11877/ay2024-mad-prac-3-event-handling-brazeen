package sg.edu.np.mad.madpractical3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //assign user object
        User user1 = new User("Brandon Koh", "I am Brandon Koh from IT07, taking the Software Engineering specialisation.", 1, true);

        //use data from user1
        TextView nameview = findViewById(R.id.TextView2);
        TextView descview = findViewById(R.id.TextView3);
        Button followbtn = findViewById(R.id.Button1);
        nameview.setText(user1.name);
        descview.setText(user1.description);
        followbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (user1.followed){
                    followbtn.setText("UNFOLLOW");
                    user1.followed = false;
                    Toast.makeText(MainActivity.this, "Unfollowed", Toast.LENGTH_SHORT).show();
                }
                else{
                    followbtn.setText("FOLLOW");
                    user1.followed = true;
                    Toast.makeText(MainActivity.this, "Followed", Toast.LENGTH_SHORT).show();
                }
            }
        });

        Intent receivingEnd = getIntent();
        String message = receivingEnd.getStringExtra("rand");
        nameview.setText("MAD " + message);
        descview.setText("MAD Developer");

        //message btn
        Button messagebtn = findViewById(R.id.Button2);
        messagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent MessageGroup = new Intent(MainActivity.this, sg.edu.np.mad.madpractical3.MessageGroup.class);
                startActivity(MessageGroup);
            }
        });





    }
}