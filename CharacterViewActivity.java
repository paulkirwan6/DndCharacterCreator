package paulk.dnd.charactercreator;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class CharacterViewActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_character_view);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        String name = getIntent().getStringExtra("characterName");
        String race = getIntent().getStringExtra("race");
        String className = getIntent().getStringExtra("class");
        
        TextView tvName = findViewById(R.id.tvCharacterName);
        TextView tvRaceInfo = findViewById(R.id.tvRaceInfo);
        TextView tvClassInfo = findViewById(R.id.tvClassInfo);
        
        tvName.setText(name);
        tvRaceInfo.setText(loadRaceInfo(race));
        tvClassInfo.setText(loadClassAndSubclassInfo(className));
    }
    
    private String loadRaceInfo(String race) {
        String[] parts = race.split(" - ");
        String mainRace = parts[0].toLowerCase().replace("-", "");
        
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("races/" + mainRace + ".txt")));
            StringBuilder content = new StringBuilder("RACE: " + race + "\n\n");
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            reader.close();
            return content.toString();
        } catch (Exception e) {
            return "RACE: " + race + "\n\nInformation not available.";
        }
    }
    
    private String loadClassAndSubclassInfo(String className) {
        String[] parts = className.split(" - ");
        String mainClass = parts[0];
        
        StringBuilder content = new StringBuilder("CLASS: " + mainClass + "\n\n");
        content.append(loadClassDescription(mainClass)).append("\n\n");
        
        if (parts.length > 1) {
            content.append("SUBCLASS: ").append(parts[1]).append("\n\n");
            String subclass = parts[1].toLowerCase().replace(" ", "_");
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("subclasses/" + subclass + ".txt")));
                String line;
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\n");
                }
                reader.close();
            } catch (Exception e) {
                content.append("Subclass information not available.");
            }
        } else {
            content.append("No subclass selected.");
        }
        
        return content.toString();
    }
    
    private String loadClassDescription(String className) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("classes/" + className.toLowerCase() + ".txt")));
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line);
            }
            reader.close();
            return content.toString();
        } catch (Exception e) {
            return "Description not available.";
        }
    }
    
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
