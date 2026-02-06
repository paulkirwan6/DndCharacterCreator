package paulk.dnd.charactercreator;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ClassDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        String className = getIntent().getStringExtra("class");
        TextView tv = findViewById(R.id.tvClassDetail);
        
        String content = "";
        switch (className) {
            case "Barbarian":
                content = "BARBARIAN\nFierce warriors who channel rage in combat. High HP and damage output.\n\n" +
                         "SUBCLASSES:\n\n" +
                         "Path of the Berserker\nFrenzy ability for extra attacks. Intimidating presence.\n\n" +
                         "Path of the Totem Warrior\nSpirit animal guides grant various powers (Bear, Eagle, Wolf).";
                break;
            case "Bard":
                content = "BARD\nCharismatic performers who use music and magic to inspire allies and confound foes.\n\n" +
                         "SUBCLASSES:\n\n" +
                         "College of Lore\nAdditional skill proficiencies. Cutting Words to reduce enemy rolls.\n\n" +
                         "College of Valor\nCombat inspiration. Proficiency with medium armor and shields.";
                break;
            case "Cleric":
                content = "CLERIC\nDivine spellcasters who serve deities and can heal or harm.\n\n" +
                         "SUBCLASSES:\n\n" +
                         "Life Domain\nBest healing abilities. Heavy armor proficiency.\n\n" +
                         "War Domain\nMartial weapon proficiency. Bonus action attacks.";
                break;
            case "Druid":
                content = "DRUID\nNature-focused spellcasters who can shapeshift into animals.\n\n" +
                         "SUBCLASSES:\n\n" +
                         "Circle of the Land\nAdditional spells based on terrain. Natural recovery.\n\n" +
                         "Circle of the Moon\nEnhanced Wild Shape into more powerful beasts.";
                break;
            case "Fighter":
                content = "FIGHTER\nMaster of martial combat with proficiency in all weapons and armor.\n\n" +
                         "SUBCLASSES:\n\n" +
                         "Battle Master\nCombat maneuvers using superiority dice for tactical advantages.\n\n" +
                         "Champion\nImproved critical hits. Remarkable athlete.\n\n" +
                         "Eldritch Knight\nCombines martial prowess with wizard spellcasting.";
                break;
            case "Monk":
                content = "MONK\nMartial artists who harness ki energy for supernatural abilities.\n\n" +
                         "SUBCLASSES:\n\n" +
                         "Way of the Open Hand\nEnhanced unarmed strikes. Healing abilities.\n\n" +
                         "Way of Shadow\nStealth and teleportation abilities. Shadow magic.";
                break;
            case "Paladin":
                content = "PALADIN\nHoly warriors who combine combat prowess with divine magic.\n\n" +
                         "SUBCLASSES:\n\n" +
                         "Oath of Devotion\nSacred weapon. Turn the unholy.\n\n" +
                         "Oath of Vengeance\nHunter of evil. Vow of enmity for advantage against foes.";
                break;
            case "Ranger":
                content = "RANGER\nWilderness experts skilled in tracking, survival, and combat.\n\n" +
                         "SUBCLASSES:\n\n" +
                         "Hunter\nColossus Slayer or Horde Breaker for combat versatility.\n\n" +
                         "Beast Master\nAnimal companion that fights alongside you.";
                break;
            case "Rogue":
                content = "ROGUE\nStealthy specialists in stealth, deception, and precision strikes.\n\n" +
                         "SUBCLASSES:\n\n" +
                         "Thief\nFast hands. Second-story work for climbing.\n\n" +
                         "Assassin\nDeadly surprise attacks. Disguise and poison expertise.";
                break;
            case "Sorcerer":
                content = "SORCERER\nInnate spellcasters whose magic comes from their bloodline.\n\n" +
                         "SUBCLASSES:\n\n" +
                         "Draconic Bloodline\nDragon ancestor grants elemental affinity and AC bonus.\n\n" +
                         "Wild Magic\nUnpredictable magical surges with random effects.";
                break;
            case "Warlock":
                content = "WARLOCK\nGain magical powers through a pact with an otherworldly patron.\n\n" +
                         "SUBCLASSES:\n\n" +
                         "The Fiend\nDark powers from devils or demons. Temporary HP on kills.\n\n" +
                         "The Great Old One\nTelepathy. Mind-affecting abilities.";
                break;
            case "Wizard":
                content = "WIZARD\nScholarly spellcasters who learn magic through study and practice.\n\n" +
                         "SUBCLASSES:\n\n" +
                         "School of Evocation\nSculpt spells to protect allies. Empowered evocations.\n\n" +
                         "School of Abjuration\nProtective wards. Spell resistance.";
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
