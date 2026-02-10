package paulk.dnd.charactercreator;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ClassDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_class_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        String className = getIntent().getStringExtra("class");
        boolean selectionMode = getIntent().getBooleanExtra("selectionMode", false);
        LinearLayout container = findViewById(R.id.classDetailContainer);
        
        TextView header = new TextView(this);
        header.setTextSize(18);
        header.setPadding(0, 0, 0, 32);
        
        String baseInfo = "";
        String[] subclasses = {};
        
        switch (className) {
            case "Barbarian":
                baseInfo = "BARBARIAN\n\nHit Die: d12\nPrimary Ability: Strength\nSaves: Strength, Constitution\nArmor: Light, medium, shields\nWeapons: Simple, martial\n\nClass Features:\n• Rage: Bonus damage, advantage on Strength checks/saves, resistance to physical damage\n• Unarmored Defense: AC = 10 + Dex + Con when not wearing armor\n• Reckless Attack: Advantage on attacks, enemies have advantage against you\n• Danger Sense: Advantage on Dex saves against visible effects\n• Extra Attack: Attack twice per action\n• Fast Movement: +10 feet speed\n• Feral Instinct: Advantage on initiative\n• Brutal Critical: Roll additional damage dice on crits\n• Relentless Rage: Stay conscious at 0 HP while raging\n• Persistent Rage: Rage only ends if you choose\n• Indomitable Might: Minimum Strength check = Strength score\n• Primal Champion: +4 Strength and Constitution (max 24)\n\nSUBCLASSES:";
                subclasses = new String[]{"Path of the Berserker", "Path of the Totem Warrior"};
                break;
            case "Bard":
                baseInfo = "BARD\n\nHit Die: d8\nPrimary Ability: Charisma\nSaves: Dexterity, Charisma\nArmor: Light\nWeapons: Simple, hand crossbows, longswords, rapiers, shortswords\n\nClass Features:\n• Spellcasting: Full caster using Charisma\n• Bardic Inspiration: Give allies bonus die to rolls\n• Jack of All Trades: Add half proficiency to non-proficient checks\n• Song of Rest: Extra healing during short rests\n• Expertise: Double proficiency bonus on two skills\n• Font of Inspiration: Regain Bardic Inspiration on short rest\n• Countercharm: Advantage against being frightened or charmed\n• Magical Secrets: Learn spells from any class\n• Superior Inspiration: Regain inspiration at initiative if none remain\n\nSUBCLASSES:";
                subclasses = new String[]{"College of Lore", "College of Valor"};
                break;
            case "Cleric":
                baseInfo = "CLERIC\n\nHit Die: d8\nPrimary Ability: Wisdom\nSaves: Wisdom, Charisma\nArmor: Light, medium, shields\nWeapons: Simple\n\nClass Features:\n• Spellcasting: Full caster using Wisdom\n• Divine Domain: Choose at 1st level, grants domain spells and features\n• Channel Divinity: Use divine energy for various effects\n• Destroy Undead: Channel Divinity to destroy low CR undead\n• Divine Intervention: Ask deity for help (success chance = cleric level %)\n\nSUBCLASSES:";
                subclasses = new String[]{"Life Domain", "War Domain"};
                break;
            case "Druid":
                baseInfo = "DRUID\n\nHit Die: d8\nPrimary Ability: Wisdom\nSaves: Intelligence, Wisdom\nArmor: Light, medium, shields (no metal)\nWeapons: Clubs, daggers, darts, javelins, maces, quarterstaffs, scimitars, sickles, slings, spears\n\nClass Features:\n• Spellcasting: Full caster using Wisdom\n• Druidic: Secret language of druids\n• Wild Shape: Transform into beasts\n• Timeless Body: Age slower\n• Beast Spells: Cast spells while in Wild Shape\n• Archdruid: Unlimited Wild Shape, ignore verbal/somatic components\n\nSUBCLASSES:";
                subclasses = new String[]{"Circle of the Land", "Circle of the Moon"};
                break;
            case "Fighter":
                baseInfo = "FIGHTER\n\nHit Die: d10\nPrimary Ability: Strength or Dexterity\nSaves: Strength, Constitution\nArmor: All armor, shields\nWeapons: Simple, martial\n\nClass Features:\n• Fighting Style: Choose combat specialization\n• Second Wind: Heal yourself as bonus action\n• Action Surge: Take additional action\n• Extra Attack: Attack multiple times per action (up to 4)\n• Indomitable: Reroll failed save\n\nSUBCLASSES:";
                subclasses = new String[]{"Battle Master", "Champion", "Eldritch Knight"};
                break;
            case "Monk":
                baseInfo = "MONK\n\nHit Die: d8\nPrimary Ability: Dexterity and Wisdom\nSaves: Strength, Dexterity\nArmor: None\nWeapons: Simple, shortswords\n\nClass Features:\n• Unarmored Defense: AC = 10 + Dex + Wis\n• Martial Arts: Use Dex for unarmed strikes, bonus unarmed strike\n• Ki: Spend ki points for special abilities\n• Unarmored Movement: Bonus to speed, wall/water running\n• Deflect Missiles: Reduce ranged damage, catch and throw back\n• Slow Fall: Reduce falling damage\n• Extra Attack: Attack twice per action\n• Stunning Strike: Stun enemies with ki\n• Evasion: Take no damage on successful Dex saves\n• Stillness of Mind: End charm/frighten on yourself\n• Purity of Body: Immune to disease and poison\n• Diamond Soul: Proficiency in all saves, reroll with ki\n• Timeless Body: No aging penalties\n• Empty Body: Invisibility and resistance\n• Perfect Self: Regain ki if none remain\n\nSUBCLASSES:";
                subclasses = new String[]{"Way of the Open Hand", "Way of Shadow"};
                break;
            case "Paladin":
                baseInfo = "PALADIN\n\nHit Die: d10\nPrimary Ability: Strength and Charisma\nSaves: Wisdom, Charisma\nArmor: All armor, shields\nWeapons: Simple, martial\n\nClass Features:\n• Divine Sense: Detect celestials, fiends, undead\n• Lay on Hands: Heal with touch\n• Fighting Style: Choose combat specialization\n• Spellcasting: Half caster using Charisma\n• Divine Smite: Expend spell slots for extra radiant damage\n• Divine Health: Immune to disease\n• Sacred Oath: Choose at 3rd level\n• Extra Attack: Attack twice per action\n• Aura of Protection: You and allies add Cha to saves\n• Aura of Courage: Immune to being frightened\n• Improved Divine Smite: All melee attacks deal +1d8 radiant\n• Cleansing Touch: End spells on yourself or others\n\nSUBCLASSES:";
                subclasses = new String[]{"Oath of Devotion", "Oath of Vengeance"};
                break;
            case "Ranger":
                baseInfo = "RANGER\n\nHit Die: d10\nPrimary Ability: Dexterity and Wisdom\nSaves: Strength, Dexterity\nArmor: Light, medium, shields\nWeapons: Simple, martial\n\nClass Features:\n• Favored Enemy: Bonus to track and recall info about creature types\n• Natural Explorer: Benefits in favored terrain\n• Fighting Style: Choose combat specialization\n• Spellcasting: Half caster using Wisdom\n• Primeval Awareness: Detect creature types\n• Extra Attack: Attack twice per action\n• Land's Stride: Move through difficult terrain\n• Hide in Plain Sight: +10 to Stealth when motionless\n• Vanish: Hide as bonus action, can't be tracked\n• Feral Senses: Detect invisible creatures\n• Foe Slayer: Add Wisdom to attack or damage once per turn\n\nSUBCLASSES:";
                subclasses = new String[]{"Hunter", "Beast Master"};
                break;
            case "Rogue":
                baseInfo = "ROGUE\n\nHit Die: d8\nPrimary Ability: Dexterity\nSaves: Dexterity, Intelligence\nArmor: Light\nWeapons: Simple, hand crossbows, longswords, rapiers, shortswords\n\nClass Features:\n• Expertise: Double proficiency on two skills\n• Sneak Attack: Extra damage when you have advantage\n• Thieves' Cant: Secret language\n• Cunning Action: Dash, Disengage, or Hide as bonus action\n• Uncanny Dodge: Halve damage from one attack\n• Evasion: Take no damage on successful Dex saves\n• Reliable Talent: Minimum 10 on proficient ability checks\n• Blindsense: Detect hidden creatures within 10 feet\n• Slippery Mind: Proficiency in Wisdom saves\n• Elusive: No advantage against you\n• Stroke of Luck: Turn miss into hit or fail into success\n\nSUBCLASSES:";
                subclasses = new String[]{"Thief", "Assassin"};
                break;
            case "Sorcerer":
                baseInfo = "SORCERER\n\nHit Die: d6\nPrimary Ability: Charisma\nSaves: Constitution, Charisma\nArmor: None\nWeapons: Daggers, darts, slings, quarterstaffs, light crossbows\n\nClass Features:\n• Spellcasting: Full caster using Charisma\n• Sorcerous Origin: Choose at 1st level\n• Font of Magic: Convert spell slots to sorcery points and vice versa\n• Metamagic: Modify spells with sorcery points\n  - Careful, Distant, Empowered, Extended, Heightened, Quickened, Subtle, Twinned\n• Sorcerous Restoration: Regain sorcery points on short rest\n\nSUBCLASSES:";
                subclasses = new String[]{"Draconic Bloodline", "Wild Magic"};
                break;
            case "Warlock":
                baseInfo = "WARLOCK\n\nHit Die: d8\nPrimary Ability: Charisma\nSaves: Wisdom, Charisma\nArmor: Light\nWeapons: Simple\n\nClass Features:\n• Otherworldly Patron: Choose at 1st level\n• Pact Magic: Spell slots recharge on short rest\n• Eldritch Invocations: Customize with magical abilities\n• Pact Boon: Choose Pact of the Chain, Blade, or Tome at 3rd level\n• Mystic Arcanum: Learn high-level spells (6th-9th)\n• Eldritch Master: Regain spell slots once per long rest\n\nSUBCLASSES:";
                subclasses = new String[]{"The Fiend", "The Great Old One"};
                break;
            case "Wizard":
                baseInfo = "WIZARD\n\nHit Die: d6\nPrimary Ability: Intelligence\nSaves: Intelligence, Wisdom\nArmor: None\nWeapons: Daggers, darts, slings, quarterstaffs, light crossbows\n\nClass Features:\n• Spellcasting: Full caster using Intelligence\n• Arcane Recovery: Regain spell slots on short rest\n• Arcane Tradition: Choose at 2nd level\n• Spell Mastery: Cast 1st and 2nd level spells at will\n• Signature Spells: Cast two 3rd level spells without expending slots\n\nSUBCLASSES:";
                subclasses = new String[]{"School of Evocation", "School of Abjuration"};
                break;
        }
        
        header.setText(baseInfo);
        container.addView(header);
        
        for (String subclass : subclasses) {
            TextView tv = new TextView(this);
            tv.setText("\n" + subclass);
            tv.setTextSize(16);
            tv.setPadding(0, 16, 0, 16);
            tv.setTextColor(0xFF2196F3);
            tv.setClickable(true);
            tv.setOnClickListener(v -> {
                Intent intent = new Intent(this, SubclassDetailActivity.class);
                intent.putExtra("class", className);
                intent.putExtra("subclass", subclass);
                intent.putExtra("selectionMode", selectionMode);
                startActivityForResult(intent, 0);
            });
            container.addView(tv);
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
