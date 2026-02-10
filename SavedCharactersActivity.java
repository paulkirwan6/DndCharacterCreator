package paulk.dnd.charactercreator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Map;

public class SavedCharactersActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_characters);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        loadCharacters();
    }
    
    private void loadCharacters() {
        LinearLayout container = findViewById(R.id.savedCharactersContainer);
        container.removeAllViews();
        
        SharedPreferences prefs = getSharedPreferences("characters", MODE_PRIVATE);
        Map<String, ?> allCharacters = prefs.getAll();
        
        if (allCharacters.isEmpty()) {
            TextView tv = new TextView(this);
            tv.setText("No saved characters yet.");
            tv.setTextSize(16);
            tv.setPadding(0, 16, 0, 16);
            container.addView(tv);
        } else {
            for (Map.Entry<String, ?> entry : allCharacters.entrySet()) {
                LinearLayout charLayout = new LinearLayout(this);
                charLayout.setOrientation(LinearLayout.VERTICAL);
                charLayout.setPadding(0, 16, 0, 16);
                
                TextView tv = new TextView(this);
                tv.setText(entry.getKey() + "\n" + entry.getValue().toString());
                tv.setTextSize(16);
                tv.setClickable(true);
                tv.setOnClickListener(v -> {
                    String data = entry.getValue().toString();
                    String[] parts = data.split("\\n");
                    String race = parts[0].replace("Race: ", "");
                    String className = parts[1].replace("Class: ", "");
                    
                    Intent intent = new Intent(this, CharacterViewActivity.class);
                    intent.putExtra("characterName", entry.getKey());
                    intent.putExtra("race", race);
                    intent.putExtra("class", className);
                    startActivity(intent);
                });
                charLayout.addView(tv);
                
                LinearLayout btnLayout = new LinearLayout(this);
                btnLayout.setOrientation(LinearLayout.HORIZONTAL);
                
                Button btnEdit = new Button(this);
                btnEdit.setText("Edit");
                btnEdit.setOnClickListener(v -> {
                    Intent intent = new Intent(this, CreateCharacterActivity.class);
                    intent.putExtra("editMode", true);
                    intent.putExtra("characterName", entry.getKey());
                    startActivity(intent);
                    finish();
                });
                btnLayout.addView(btnEdit);
                
                Button btnDelete = new Button(this);
                btnDelete.setText("Delete");
                btnDelete.setOnClickListener(v -> {
                    new AlertDialog.Builder(this)
                        .setTitle("Delete Character")
                        .setMessage("Delete " + entry.getKey() + "?")
                        .setPositiveButton("Delete", (dialog, which) -> {
                            SharedPreferences.Editor editor = prefs.edit();
                            editor.remove(entry.getKey());
                            editor.apply();
                            loadCharacters();
                        })
                        .setNegativeButton("Cancel", null)
                        .show();
                });
                btnLayout.addView(btnDelete);
                
                charLayout.addView(btnLayout);
                container.addView(charLayout);
            }
        }
    }
    
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
