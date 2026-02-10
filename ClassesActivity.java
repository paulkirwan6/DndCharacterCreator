package paulk.dnd.charactercreator;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

public class ClassesActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classes);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        LinearLayout container = findViewById(R.id.classesContainer);
        String[] classes = {"Barbarian", "Bard", "Cleric", "Druid", "Fighter", "Monk", "Paladin", "Ranger", "Rogue", "Sorcerer", "Warlock", "Wizard"};
        
        for (int i = 0; i < classes.length; i++) {
            LinearLayout row = new LinearLayout(this);
            row.setOrientation(LinearLayout.HORIZONTAL);
            row.setPadding(0, 0, 0, 32);
            row.setClickable(true);
            String className = classes[i];
            row.setOnClickListener(v -> {
                Intent intent = new Intent(this, ClassDetailActivity.class);
                intent.putExtra("class", className);
                intent.putExtra("selectionMode", getIntent().getBooleanExtra("selectionMode", false));
                startActivityForResult(intent, 0);
            });
            
            TextView tv = new TextView(this);
            tv.setText(classes[i] + "\n" + loadClassDescription(className));
            tv.setTextSize(16);
            tv.setTextColor(0xFF2196F3);
            LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(0, LinearLayout.LayoutParams.WRAP_CONTENT, 1);
            tv.setLayoutParams(textParams);
            
            ImageView img = new ImageView(this);
            LinearLayout.LayoutParams imgParams = new LinearLayout.LayoutParams(150, 150);
            imgParams.setMargins(16, 0, 0, 0);
            img.setLayoutParams(imgParams);
            img.setScaleType(ImageView.ScaleType.CENTER_CROP);
            
            String imageName = className.toLowerCase() + ".png";
            try {
                InputStream is = getAssets().open("class_images/" + imageName);
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
}
