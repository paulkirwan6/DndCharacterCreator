package paulk.dnd.charactercreator;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SubclassDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subclass_detail);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        
        String className = getIntent().getStringExtra("class");
        String subclass = getIntent().getStringExtra("subclass");
        boolean selectionMode = getIntent().getBooleanExtra("selectionMode", false);
        TextView tv = findViewById(R.id.tvSubclassDetail);
        Button btnSelect = findViewById(R.id.btnSelectSubclass);
        
        String filename = subclass.toLowerCase().replace(" ", "_").replace("'", "") + ".txt";
        String content = loadFromAssets(filename);
        
        if (content.isEmpty()) {
            content = subclass + "\n\nInformation coming soon...";
        }
        
        tv.setText(content);
        
        if (selectionMode) {
            btnSelect.setVisibility(View.VISIBLE);
            btnSelect.setOnClickListener(v -> {
                getIntent().putExtra("selectedClass", className + " - " + subclass);
                setResult(RESULT_OK, getIntent());
                finish();
            });
        }
    }
    
    private String loadFromAssets(String filename) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(getAssets().open("subclasses/" + filename)));
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
