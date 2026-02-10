package paulk.dnd.charactercreator;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class CreateCharacterActivity extends AppCompatActivity {
    private static final int REQUEST_RACE = 1;
    private static final int REQUEST_CLASS = 2;
    
    private EditText etCharacterName;
    private TextView tvSelectedRace;
    private TextView tvSelectedClass;
    private String originalName;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_character);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        etCharacterName = findViewById(R.id.etCharacterName);
        tvSelectedRace = findViewById(R.id.tvSelectedRace);
        tvSelectedClass = findViewById(R.id.tvSelectedClass);
        Button btnSelectRace = findViewById(R.id.btnSelectRace);
        Button btnSelectClass = findViewById(R.id.btnSelectClass);
        Button btnSaveCharacter = findViewById(R.id.btnSaveCharacter);
        
        boolean editMode = getIntent().getBooleanExtra("editMode", false);
        if (editMode) {
            originalName = getIntent().getStringExtra("characterName");
            SharedPreferences prefs = getSharedPreferences("characters", MODE_PRIVATE);
            String data = prefs.getString(originalName, "");
            etCharacterName.setText(originalName);
            String[] parts = data.split("\\n");
            if (parts.length >= 2) {
                tvSelectedRace.setText(parts[0].replace("Race: ", ""));
                tvSelectedClass.setText(parts[1].replace("Class: ", ""));
            }
        }
        
        btnSelectRace.setOnClickListener(v -> {
            Intent intent = new Intent(this, RacesActivity.class);
            intent.putExtra("selectionMode", true);
            startActivityForResult(intent, REQUEST_RACE);
        });
        
        btnSelectClass.setOnClickListener(v -> {
            Intent intent = new Intent(this, ClassesActivity.class);
            intent.putExtra("selectionMode", true);
            startActivityForResult(intent, REQUEST_CLASS);
        });
        
        btnSaveCharacter.setOnClickListener(v -> {
            String name = etCharacterName.getText().toString().trim();
            String race = tvSelectedRace.getText().toString();
            String className = tvSelectedClass.getText().toString();
            
            if (name.isEmpty()) {
                Toast.makeText(this, "Please enter a character name", Toast.LENGTH_SHORT).show();
                return;
            }
            if (race.equals("None")) {
                Toast.makeText(this, "Please select a race", Toast.LENGTH_SHORT).show();
                return;
            }
            if (className.equals("None")) {
                Toast.makeText(this, "Please select a class", Toast.LENGTH_SHORT).show();
                return;
            }
            
            SharedPreferences prefs = getSharedPreferences("characters", MODE_PRIVATE);
            SharedPreferences.Editor editor = prefs.edit();
            if (originalName != null && !originalName.equals(name)) {
                editor.remove(originalName);
            }
            editor.putString(name, "Race: " + race + "\nClass: " + className);
            editor.apply();
            
            Toast.makeText(this, "Character saved: " + name, Toast.LENGTH_LONG).show();
            
            if (originalName != null) {
                finish();
            } else {
                etCharacterName.setText("");
                tvSelectedRace.setText("None");
                tvSelectedClass.setText("None");
            }
        });
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        
        if (resultCode == RESULT_OK && data != null) {
            if (requestCode == REQUEST_RACE) {
                String race = data.getStringExtra("selectedRace");
                tvSelectedRace.setText(race);
            } else if (requestCode == REQUEST_CLASS) {
                String className = data.getStringExtra("selectedClass");
                tvSelectedClass.setText(className);
            }
        }
    }
    
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
