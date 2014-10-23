package summer14.manparvesh.soil12;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AASHTO extends ActionBarActivity {
	
	Button classify1,clear1;
    EditText S10,S40,S200,ll,pi;
    //TextView CC1,CdCd1;
    //int c;
    String C,Cd;
    double s10=0,s40=0,s200=0,LL=0,PI=0,PL=0;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_aashto);
		
		classify1=(Button)findViewById(R.id.classify1);
        clear1=(Button)findViewById(R.id.clear1);
        
        S10   = (EditText)findViewById(R.id.T11);
        S40   = (EditText)findViewById(R.id.T12);
        S200   = (EditText)findViewById(R.id.T13);
        ll   = (EditText)findViewById(R.id.T14);
        pi   = (EditText)findViewById(R.id.T15);
        
//        CC1=(TextView)findViewById(R.id.CC1id);
  //      CdCd1=(TextView)findViewById(R.id.CdCd1id);
        
        classify1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v11) {
            	
				
            	
            	result();
            	
           }
            
			
        });
       // System.out.println("onClickListener for classify set");
        
        
        clear1.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v13) {
            	S10.setText("");
            	S40.setText("");
            	S200.setText("");
            	ll.setText("");
            	pi.setText("");
            //	CC1.setText("");
            //	CdCd1.setText("");
           }
        });
        //System.out.println("clear set");
             
    }
	
	private void result() {
        try{
        	
			LayoutInflater inflater = getLayoutInflater();
			 
			View layout = inflater.inflate(R.layout.custom_toast,
			  (ViewGroup) findViewById(R.id.custom_toast_layout_id));

			// set a message
			TextView text101 = (TextView) layout.findViewById(R.id.ttext1);
			
			TextView text201 = (TextView) layout.findViewById(R.id.ttext2);

        	
        	s10  = Double.parseDouble(S10.getText().toString());
            s40  = Double.parseDouble(S40.getText().toString());
            s200 = Double.parseDouble(S200.getText().toString());
            LL   = Double.parseDouble(ll.getText().toString());
            PL   = Double.parseDouble(pi.getText().toString());
            PI=LL-PL;
            //System.out.println("inside result method, parsing ints");
            
            //System.out.println("starting if-else nests");
            
            //initializing 
            C="Invalid Input";
            Cd="Please enter valid entries or fill all the text boxes.";
            
            if (s10<=50){
            	if (s40<=30){
            		if (s200<=15 && PI<=6){
            			C="A-1-a";
                    	Cd="stone fragments, gravel and sand";
            		}
            	}else if(s40<=50){
            		if (s200<=25){
            			C="A-1-b";
                    	Cd="stone fragments, gravel and sand";
                    	
            		}
            	}else{
            		if (s200<=10){
            			C="A-3";
                    	Cd="fine sand";
            		}else if (s200<=35){
            			if (LL<=40){
            				if (PI<=10){
            					C="A-2-4";
            		        	Cd="silty or clayey gravel and sand";
            				}else{
            					C="A-2-6";
            		        	Cd="silty or clayey gravel and sand";
            				}
            			}else{
            				if (PI<=10){
            					C="A-2-5";
            		        	Cd="silty or clayey gravel and sand";
            				}else{
            					C="A-2-7";
            		        	Cd="silty or clayey gravel and sand";
            				}
            			}
            		}else{
            			if (LL<=40){
            				if (PI<=10){
            					C="A-4";
            		        	Cd="silty soils";
                			}else{
                				C="A-6";
                	        	Cd="clayey soils";
                			}
            			}else{
            				if (PI<=10){
            					C="A-5";
            		        	Cd="silty soils";
                			}else{
                				C="A-7";
                	        	Cd="clayey soils";
                			}
            			}
            		}
            	}
            }
            
            text101.setText(C+": ");
            text201.setText(Cd);
//toast maaro be!
            Toast toast = new Toast(getApplicationContext());
    		toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
    		toast.setDuration(Toast.LENGTH_LONG);
    		toast.setView(layout);
    		toast.show();
            
        }
        catch(NumberFormatException e)
        {
          e.printStackTrace();
       //   System.out.println("exception");
          
        }

     //   System.out.println("setting texts!");
        
        
		
	//	CC1.setText(C);
    	//CdCd1.setText(Cd);

		
	}

	
}