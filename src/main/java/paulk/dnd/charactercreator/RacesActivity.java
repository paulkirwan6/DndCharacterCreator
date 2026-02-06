package paulk.dnd.charactercreator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class RacesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_races);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        LinearLayout container = findViewById(R.id.racesContainer);
        String[] races = {"Human", "Elf", "Dwarf", "Halfling", "Dragonborn", "Gnome", "Half-Elf", "Half-Orc", "Tiefling"};
        String[] descriptions = {
            "Versatile and adaptable, humans gain +1 to all ability scores.",
            "Graceful and long-lived, elves have keen senses and a natural affinity for magic. +2 Dexterity.",
            "Hardy and resilient, dwarves are known for their craftsmanship and combat prowess. +2 Constitution.",
            "Small and nimble, halflings are naturally lucky and brave. +2 Dexterity.",
            "Proud dragon-like humanoids with breath weapons. +2 Strength, +1 Charisma.",
            "Small, intelligent, and curious inventors. +2 Intelligence.",
            "Combining human versatility with elven grace. +2 Charisma, +1 to two other abilities.",
            "Strong and tough with orcish heritage. +2 Strength, +1 Constitution.",
            "Infernal heritage grants them resistance to fire and innate spellcasting. +2 Charisma, +1 Intelligence."
        };
        boolean[] hasSubraces = {false, true, true, true, false, true, false, false, false};
        
        for (int i = 0; i < races.length; i++) {
            TextView tv = new TextView(this);
            tv.setText(races[i] + "\n" + descriptions[i]);
            tv.setTextSize(16);
            tv.setPadding(0, 0, 0, 32);
            tv.setTextColor(0xFF2196F3);
            tv.setClickable(true);
            String race = races[i];
            tv.setOnClickListener(v -> {
                Intent intent = new Intent(this, RaceDetailActivity.class);
                intent.putExtra("race", race);
                startActivity(intent);
            });
            
            container.addView(tv);
        }
    }
    
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
