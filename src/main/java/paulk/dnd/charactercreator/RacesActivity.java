package paulk.dnd.charactercreator;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.InputStream;

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
        
        for (int i = 0; i < races.length; i++) {
            LinearLayout row = new LinearLayout(this);
            row.setOrientation(LinearLayout.HORIZONTAL);
            row.setPadding(0, 0, 0, 32);
            row.setClickable(true);
            String race = races[i];
            row.setOnClickListener(v -> {
                Intent intent = new Intent(this, RaceDetailActivity.class);
                intent.putExtra("race", race);
                intent.putExtra("selectionMode", getIntent().getBooleanExtra("selectionMode", false));
                startActivityForResult(intent, 0);
            });
            
            TextView tv = new TextView(this);
            tv.setText(races[i] + "\n" + descriptions[i]);
            tv.setTextSize(16);
            tv.setTextColor(0xFF2196F3);
            LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1);
            tv.setLayoutParams(textParams);
            
            ImageView img = new ImageView(this);
            LinearLayout.LayoutParams imgParams = new LinearLayout.LayoutParams(150, 150);
            imgParams.setMargins(16, 0, 0, 0);
            img.setLayoutParams(imgParams);
            img.setScaleType(ImageView.ScaleType.CENTER_CROP);
            
            String imageName = race.toLowerCase().replace("-", "") + ".png";
            try {
                InputStream is = getAssets().open("race_images/" + imageName);
                img.setImageDrawable(Drawable.createFromStream(is, null));
                is.close();
            } catch (Exception e) {
                img.setImageResource(android.R.drawable.ic_menu_gallery);
            }
            
            row.addView(tv);
            row.addView(img);
            container.addView(row);
        }
    }
    
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && data != null) {
            setResult(RESULT_OK, data);
            finish();
        }
    }
    
    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}
