package summer14.manparvesh.soil12;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainScreen extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_screen);
		
		Button aashtob = (Button) findViewById(R.id.aashto);
        System.out.println("aashto button assigned");
        aashtob.setOnClickListener(new View.OnClickListener() {
        	
            @Override
            public void onClick(View v10){
            	startActivity(new Intent(MainScreen.this,AASHTO.class));
            }
        });
        
        Button uscsb = (Button) findViewById(R.id.uscs);
        System.out.println("uscs button assigned");
        uscsb.setOnClickListener(new View.OnClickListener() {
             
            @Override
            public void onClick(View v20) {
                // TODO Auto-generated method stub
                startActivity(new Intent(MainScreen.this,USCS.class));
            }
        });
		
        Button isscsb = (Button) findViewById(R.id.isscs);
        System.out.println("isscs button assigned");
        isscsb.setOnClickListener(new View.OnClickListener() {
             
            @Override
            public void onClick(View v30) {
                // TODO Auto-generated method stub
                startActivity(new Intent(MainScreen.this,ISSCS.class));
            }
        });
       
        Button Exit=(Button)findViewById(R.id.exit);
        System.out.println("exit button set");
        Exit.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v40) {
                // TODO Auto-generated method stub
                finish();
                System.exit(0);
            }
        });
        
        Button about = (Button) findViewById(R.id.about);
        about.setOnClickListener(new View.OnClickListener() {
             
            @Override
            public void onClick(View v302) {
                // TODO Auto-generated method stub
                startActivity(new Intent(MainScreen.this,About.class));
            }
        });
        
	}
}
