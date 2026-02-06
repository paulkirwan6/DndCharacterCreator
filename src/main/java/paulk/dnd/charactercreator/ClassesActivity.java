package paulk.dnd.charactercreator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ClassesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        LinearLayout container = findViewById(R.id.classesContainer);
        String[] classes = {"Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger", "Rogue", "Sorcerer", "Warlock", "Wizard"};
        String[] descriptions = {
            "Fierce warriors who channel rage in combat. High HP and damage output.",
            "Charismatic performers who use music and magic to inspire allies and confound foes.",
            "Divine spellcasters who serve deities and can heal or harm.",
            "Nature-focused spellcasters who can shapeshift into animals.",
            "Master of martial combat with proficiency in all weapons and armor.",
            "Martial artists who harness ki energy for supernatural abilities.",
            "Holy warriors who combine combat prowess with divine magic.",
            "Wilderness experts skilled in tracking, survival, and combat.",
            "Stealthy specialists in stealth, deception, and precision strikes.",
            "Innate spellcasters whose magic comes from their bloodline.",
            "Gain magical powers through a pact with an otherworldly patron.",
            "Scholarly spellcasters who learn magic through study and practice."
        };
        
        for (int i = 0; i < classes.length; i++) {
            TextView tv = new TextView(this);
            tv.setText(classes[i] + "\n" + descriptions[i]);
            tv.setTextSize(16);
            tv.setPadding(0, 0, 0, 32);
            tv.setTextColor(0xFF2196F3);
            tv.setClickable(true);
            String className = classes[i];
            tv.setOnClickListener(v -> {
                Intent intent = new Intent(this, ClassDetailActivity.class);
                intent.putExtra("class", className);
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
