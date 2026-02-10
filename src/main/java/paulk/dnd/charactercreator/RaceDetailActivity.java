package paulk.dnd.charactercreator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RaceDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        String race = getIntent().getStringExtra("race");
        boolean selectionMode = getIntent().getBooleanExtra("selectionMode", false);
        TextView tv = findViewById(R.id.tvRaceDetail);
        Button btnSelect = findViewById(R.id.btnSelectRace);
        
        String filename = race.toLowerCase().replace("-", "") + ".txt";
        String content = loadFromAssets(filename);
        
        if (content.isEmpty()) {
            content = race + "\n\nInformation coming soon...";
        }
        
        tv.setText(content);
        
        if (selectionMode) {
            // Check if race has subraces
            if (content.contains("SUBRACES:")) {
                // Parse subraces from content
                String[] lines = content.split("\n");
                boolean inSubraces = false;
                String currentSubrace = null;
                
                LinearLayout parent = (LinearLayout) tv.getParent();
                
                for (String line : lines) {
                    if (line.equals("SUBRACES:")) {
                        inSubraces = true;
                        continue;
                    }
                    if (inSubraces && !line.trim().isEmpty() && !line.startsWith("•") && !line.startsWith("  ")) {
                        // This is a subrace name
                        currentSubrace = line.trim();
                        Button subBtn = new Button(this);
                        subBtn.setText("Select " + currentSubrace);
                        String finalCurrentSubrace = currentSubrace;
                        subBtn.setOnClickListener(v -> {
                            getIntent().putExtra("selectedRace", race + " - " + finalCurrentSubrace);
                            setResult(RESULT_OK, getIntent());
                            finish();
                        });
                        parent.addView(subBtn);
                    }
                }
            } else {
                // No subraces, just select the base race
                btnSelect.setVisibility(View.VISIBLE);
                btnSelect.setOnClickListener(v -> {
                    getIntent().putExtra("selectedRace", race);
                    setResult(RESULT_OK, getIntent());
                    finish();
                });
            }
        }
    }
    
    private String loadFromAssets(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("races/" + filename)));
            StringBuilder sb = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                sb.append(line).append("\n");
            }
            reader.close();
            return sb.toString();
        } catch (Exception e) {
            return "";
        }
    }
    
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
