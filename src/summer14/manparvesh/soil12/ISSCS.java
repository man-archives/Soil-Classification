package summer14.manparvesh.soil12;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ISSCS extends ActionBarActivity {

	Button Clear4,Classify4;
	static EditText S4,S200,pi;
	static EditText ll;
	static EditText d10;
	static EditText d30,d60;
	//TextView CC4,CdCd4;
	String C4,Cd4;//class,classDescription
	int cls;//class
	CheckBox CS2,O2,HO2;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_isscs);
		
		Clear4=(Button)findViewById(R.id.clear4);
        Classify4=(Button)findViewById(R.id.classify4);
        
        S4=(EditText)findViewById(R.id.T41);
        //S40=(EditText)findViewById(R.id.T42);
        S200=(EditText)findViewById(R.id.T43);
        ll=(EditText)findViewById(R.id.T44);
        d10=(EditText)findViewById(R.id.T45);//D10
        d30=(EditText)findViewById(R.id.T46);//D30
        pi=(EditText)findViewById(R.id.T47);
        d60=(EditText)findViewById(R.id.T48);
        
     //   CC4=(TextView)findViewById(R.id.CC4id);
    //    CdCd4=(TextView)findViewById(R.id.CdCd4id);
        
        //CS2=(CheckBox)findViewById(R.id.cgts2);
        O2=(CheckBox)findViewById(R.id.o2);
        HO2=(CheckBox)findViewById(R.id.ho2);
        
        Clear4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v43) {
            	S4.setText("");
            	//S40.setText("");
            	S200.setText("");
            	ll.setText("");
            	pi.setText("");
            	d10.setText("");
            	d30.setText("");
            	d60.setText("");
            //	CC4.setText("");
           }
        });
        
        Classify4.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v41) {
            	result();
           }
        });

	}
	
	private void result() {
		try{
			
			LayoutInflater inflater = getLayoutInflater();
			 
			View layout = inflater.inflate(R.layout.custom_toast,
			  (ViewGroup) findViewById(R.id.custom_toast_layout_id));

			// set a message
			TextView text101 = (TextView) layout.findViewById(R.id.ttext1);
			
			//TextView text201 = (TextView) layout.findViewById(R.id.ttext2);

			
		double s4 = Double.parseDouble(S4.getText().toString());
		//double s40 = Double.parseDouble(S40.getText().toString());
        double s200 = Double.parseDouble(S200.getText().toString());
        double D10 = Double.parseDouble(d10.getText().toString());
        double LL = Double.parseDouble(ll.getText().toString());
        double PI = LL-Double.parseDouble(pi.getText().toString());
        double D30 = Double.parseDouble(d30.getText().toString());
        double D60 = Double.parseDouble(d60.getText().toString());
        
        double Cu,Cc;
        Cu=D60/D10;
        Cc=(D30*D30)/(D10*D60);
        
        C4="Invalid Input.\nPlease enter valid entries or fill all the text boxes.";
        
        if (HO2.isChecked()){
        	C4="Peat";
        }else{
        	if(s200>50){//fine grained
        
        	if (LL<35){
        		if(belowALine(LL,PI)||underHatchedArea(LL,PI)){
        			if(O2.isChecked()){
        				C4="OL";
        				//Cd4="";
        			}else{
        				C4="ML";
        				//Cd4="";
        			}
        		}else if(inHatchedArea(LL,PI)){
        			C4="ML-CL";
    				//Cd4="";
        		}else{
        			C4="CL";
    				//Cd4="";
        		}
        	}else if(LL>=35 && LL<=50){
        		if(belowALine(LL,PI)){
        			if(O2.isChecked()){
        				C4="OI";
        			}else{
        				C4="MI";
        			}
        		}else{
        			C4="CI";
        		}
        	}else{//LL>50
        		if(belowALine(LL,PI)){
        			if(O2.isChecked()){
        				C4="OH";
        			}else{
        				C4="MH";
        			}
        		}else{
        			C4="CH";
        		}
        	}
        }else{//coarse grained
        	if(s4>50){//greater % of coarse fraction pass 4.75mm sieve
        		if(s200<5){
        			if(wellGraded(Cu,Cc)){
        				C4="SW";
        			}else{
        				C4="SP";
        			}
        		}else if(s200>=5 && s200<=12){
        			C4="SW-SM";
        		}else{
        			if(belowALine(LL,PI) || underHatchedArea(LL,PI)){
        				C4="SM";
        			}else if(inHatchedArea(LL,PI)){
        				C4="SM-SC";
        			}else{
        				C4="SC";
        			}
        		}
        	}else{//greater % of coarse fraction retained on 4.75mm sieve
        		if(s200<5){
        			if(wellGraded(Cu,Cc)){
        				C4="GW";
        			}else{
        				C4="GP";
        			}
        		}else if(s200>=5 && s200<=12){
        			C4="GW-GM";
        		}else{
        			if(belowALine(LL,PI) || underHatchedArea(LL,PI)){
        				C4="GM";
        			}else if(inHatchedArea(LL,PI)){
        				C4="GM-GC";
        			}else{
        				C4="GC";
        				}
        			}
        		}
        	}
        }
        
        text101.setText(C4);
        //text201.setText(Cd);

        Toast toast = new Toast(getApplicationContext());
		toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
		toast.setDuration(Toast.LENGTH_LONG);
		toast.setView(layout);
		toast.show();
        
		}catch(NumberFormatException e)
    {
    	System.out.println("");
        e.printStackTrace();
    }
       
		//CC4.setText(C4);
        //CdCd4.setText(Cd4);
        
	}
	
	private static boolean underHatchedArea(double ll, double pi){
		if(ll>=10 && ll<=25 && pi<=4){
			return true;
		}else{
			return false;
		}
	}
	
	private static boolean inHatchedArea(double ll, double pi){
		if(ll>=10 && ll<=25 && pi>=4 && pi<=7 && (pi-0.73*(ll-20))>0){
			return true;
		}else{
			return false;
		}
	}
	
	private static boolean wellGraded(double cu2,double cc2){
		if(cu2>=4 && cc2>=1 && cc2<=3){
			return true;
		}else{
			return false;
		}
	}
	
	private static boolean belowALine(double lL2,double pI2){
		if((pI2-0.73*(lL2-20))>0){
			return false;
		}else{
			return true;
		}
	}

}
