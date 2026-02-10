package paulk.dnd.charactercreator;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.io.InputStream;

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

        Button btnRaces = findViewById(R.id.btnRaces);
        Button btnClasses = findViewById(R.id.btnClasses);
        Button btnCreateCharacter = findViewById(R.id.btnCreateCharacter);
        Button btnSavedCharacters = findViewById(R.id.btnSavedCharacters);
        
        try {
            InputStream is = getAssets().open("dnd-5e-races.jpg");
            Drawable d = Drawable.createFromStream(is, null);
            d.setAlpha(230);
            btnRaces.setBackground(d);
            is.close();
        } catch (Exception e) {
            // Keep default background if image not found
        }
        
        try {
            InputStream is = getAssets().open("dnd-5e-classes.jpg");
            Drawable d = Drawable.createFromStream(is, null);
            d.setAlpha(230);
            btnClasses.setBackground(d);
            is.close();
        } catch (Exception e) {
            // Keep default background if image not found
        }
        
        btnRaces.setOnClickListener(v -> 
            startActivity(new Intent(this, RacesActivity.class)));
        
        btnClasses.setOnClickListener(v -> 
            startActivity(new Intent(this, ClassesActivity.class)));
        
        btnCreateCharacter.setOnClickListener(v -> 
            startActivity(new Intent(this, CreateCharacterActivity.class)));
        
        btnSavedCharacters.setOnClickListener(v -> 
            startActivity(new Intent(this, SavedCharactersActivity.class)));
    }
}