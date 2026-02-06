package paulk.dnd.charactercreator;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class RaceDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_race_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        String race = getIntent().getStringExtra("race");
        TextView tv = findViewById(R.id.tvRaceDetail);
        
        String content = "";
        switch (race) {
            case "Elf":
                content = "ELF\nGraceful and long-lived, elves have keen senses and a natural affinity for magic. +2 Dexterity.\n\n" +
                         "SUBRACES:\n\n" +
                         "High Elf\n+1 Intelligence. Proficient with longsword, shortsword, shortbow, and longbow. Know one wizard cantrip.\n\n" +
                         "Wood Elf\n+1 Wisdom. Proficient with longsword, shortsword, shortbow, and longbow. Increased movement speed.\n\n" +
                         "Drow (Dark Elf)\n+1 Charisma. Superior darkvision. Innate spellcasting with dancing lights, faerie fire, and darkness.";
                break;
            case "Dwarf":
                content = "DWARF\nHardy and resilient, dwarves are known for their craftsmanship and combat prowess. +2 Constitution.\n\n" +
                         "SUBRACES:\n\n" +
                         "Hill Dwarf\n+1 Wisdom. Additional hit point per level. Increased resilience.\n\n" +
                         "Mountain Dwarf\n+2 Strength. Proficient with light and medium armor.";
                break;
            case "Halfling":
                content = "HALFLING\nSmall and nimble, halflings are naturally lucky and brave. +2 Dexterity.\n\n" +
                         "SUBRACES:\n\n" +
                         "Lightfoot Halfling\n+1 Charisma. Can hide behind larger creatures.\n\n" +
                         "Stout Halfling\n+1 Constitution. Resistance to poison damage and advantage on saving throws against poison.";
                break;
            case "Gnome":
                content = "GNOME\nSmall, intelligent, and curious inventors. +2 Intelligence.\n\n" +
                         "SUBRACES:\n\n" +
                         "Forest Gnome\n+1 Dexterity. Can speak with small animals. Know the minor illusion cantrip.\n\n" +
                         "Rock Gnome\n+1 Constitution. Proficient with artisan's tools. Can create small clockwork devices.";
                break;
        }
        
        tv.setText(content);
    }
    
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
