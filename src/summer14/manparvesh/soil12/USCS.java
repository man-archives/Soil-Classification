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

public class USCS extends ActionBarActivity {

	EditText S4,S200,ll,d10,d30,d60;
	int c;
	String C,Cd;
	//TextView CC2,CdCd2;
	CheckBox CS,O,HO;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_uscs);
       // System.out.println("");
        
        
        Button classify2 = (Button)findViewById(R.id.classify2);
        Button clear2 = (Button)findViewById(R.id.clear2);
      //  System.out.println("");
        
        
        CS=(CheckBox)findViewById(R.id.cgts);
        O=(CheckBox)findViewById(R.id.o);
        HO=(CheckBox)findViewById(R.id.ho);
     //   System.out.println("");
        
        S4   = (EditText)findViewById(R.id.T21);
        S200   = (EditText)findViewById(R.id.T22);
        ll   = (EditText)findViewById(R.id.T23);
        //pi   = (EditText)findViewById(R.id.T24);
        d10   = (EditText)findViewById(R.id.T25);
        d30   = (EditText)findViewById(R.id.T26);
        d60   = (EditText)findViewById(R.id.T270);
        //     System.out.println("");
        
     //   CC2=(TextView)findViewById(R.id.CC2id);
     //   CdCd2=(TextView)findViewById(R.id.CdCd2id);
     //   System.out.println("");
        
        
        
        classify2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v21) {
            	res2();
            }
        });//System.out.println("");
        
        clear2.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v22) {
            	S4.setText("");
            	S200.setText("");
            	ll.setText("");
            //	pi.setText("");
            	d10.setText("");
            	d30.setText("");
            	d60.setText("");
          //  	CC2.setText("");
            //	CdCd2.setText("");
            }
        });//ystem.out.println("");
        
        
    }
	private void res2(){
	    try{
	    	
	    	LayoutInflater inflater = getLayoutInflater();
			 
			View layout = inflater.inflate(R.layout.custom_toast,
			  (ViewGroup) findViewById(R.id.custom_toast_layout_id));

			// set a message
			TextView text101 = (TextView) layout.findViewById(R.id.ttext1);
			
			TextView text201 = (TextView) layout.findViewById(R.id.ttext2);

	    	
	        double s4 = Double.parseDouble(S4.getText().toString());
	        double s200 = Double.parseDouble(S200.getText().toString());
	        double LL = Double.parseDouble(ll.getText().toString());
	        double D10 = Double.parseDouble(d10.getText().toString());
	        double D30 = Double.parseDouble(d30.getText().toString());
	        double D60 = Double.parseDouble(d60.getText().toString());
		       // System.out.println("");
	        double Cu,Cc;
	        Cu=D60/D10;
	        Cc=(D30*D30)/(D10*D60);
	        
            C="Invalid Input";
            Cd="Please enter valid entries or fill all the text boxes.";
            if(HO.isChecked()){
        		c=17;
        	}else{
	        if (s200<50){//coarse
	        	if (s4<50){
	        		if (s200<5){
	        			if (Cu>=4 && 1<=Cc && Cc<=3){
	        				c=1;
	        			}else{
	        				c=2;
	        			}
	        		}else if(s200>12){
	        			if (CS.isChecked()){
	        				c=3;
	        			}else{
	        				c=4;
	        			}
	        		}else{
	        			if(CS.isChecked()){
	        				if(Cu>=4 && 1<=Cc && Cc<=3){
	        					c=5;
	        				}else{
	        					c=6;
	        				}
	        			}else{
	        				if(Cu>=4 && 1<=Cc && Cc<=3){
	        					c=7;
	        				}else{
	        					c=8;
	        				}
	        			}
	        		}
	        	}else{
	        		if(s200<5){
	        			if(Cu>=6 && 1<=Cc && Cc<=3){
	        				c=9;
	        			}else{
	        				c=10;
	        			}
	        		}else if(s200>12){
	        			if (CS.isChecked()){
	        				c=11;
	        			}else{
	        				c=12;
	        			}
	        		}else{
	        			if (CS.isChecked()){
	        				if(Cu>=6 && 1<=Cc && Cc<=3){
	        					c=13;
	        				}else{
	        					c=14;
	        				}
	        			}else{
	        				if(Cu>=6 && 1<=Cc && Cc<=3){
	        					c=15;
	        				}else{
	        					c=16;
	        				}
	        			}
	        		}
	        	}
	        }else{//fine
	        	
	        		if (LL<50){
	        			if (O.isChecked()){
	        				c=18;
	        			}else if(CS.isChecked()){
	        				c=19;
	        			}else{
	        				c=20;
	        			}
	        		}else{
	        			if(O.isChecked()){
	        				c=21;
	        			}else if (CS.isChecked()){
	        				c=22;
	        			}else{
	        				c=23;
	        			}
	        		}
	        	}
	        }
	        
	        switch(c){
	        case 1:
	        	C="GW";
	        	Cd="well-graded gravel, fine to coarse gravel";
	        	break;
	        case 2:
	        	C="GP";
	        	Cd="poorly graded gravel";
	        	break;
	        case 3:
	        	C="GC";
	        	Cd="clayey gravel";
	        	break;
	        case 4:
	        	C="GM";
	        	Cd="silty gravel";
	        	break;
	        case 5:
	        	C="GW-GC";
	        	Cd="";
	        	break;
	        case 6:
	        	C="GP-GC";
	        	Cd="";
	        	break;
	        case 7:
	        	C="GW-GM";
	        	Cd="";
	        	break;
	        case 8:
	        	C="GP-GM";
	        	Cd="";
	        	break;
	        case 9:
	        	C="SW";
	        	Cd="well-graded sand, fine to coarse sand";
	        	break;
	        case 10:
	        	C="SP";
	        	Cd="poorly graded sand";
	        	break;
	        case 11:
	        	C="SC";
	        	Cd="clayey sand";
	        	break;
	        case 12:
	        	C="SM";
	        	Cd="silty sand";
	        	break;
	        case 13:
	        	C="SW-SC";
	        	Cd="";
	        	break;
	        case 14:
	        	C="SP-SC";
	        	Cd="";
	        	break;
	        case 15:
	        	C="SW-SM";
	        	Cd="";
	        	break;
	        case 16:
	        	C="SP-SM";
	        	Cd="";
	        	break;
	        case 17:
	        	C="Pt";
	        	Cd="peat";
	        	break;
	        case 18:
	        	C="OL";
	        	Cd="organic silt, organic clay";
	        	break;
	        case 19:
	        	C="CL";
	        	Cd="clay of low plasticity, lean clay";
	        	break;
	        case 20:
	        	C="ML";
	        	Cd="silt";
	        	break;
	        case 21:
	        	C="OH";
	        	Cd="organic clay, organic silt";
	        	break;
	        case 22:
	        	C="CH";
	        	Cd="clay of high plasticity, fat clay";
	        	break;
	        case 23:
	        	C="MH";
	        	Cd="silt of high plasticity, elastic silt";
	        	break;
	        }

	        
	        text101.setText(C+": ");
            text201.setText(Cd);

            Toast toast = new Toast(getApplicationContext());
    		toast.setGravity(Gravity.CENTER_VERTICAL, 0, 0);
    		toast.setDuration(Toast.LENGTH_LONG);
    		toast.setView(layout);
    		toast.show();
	        
	    }
	    catch(NumberFormatException e)
	    {
	    	//System.out.println("");
	        e.printStackTrace();
	    }
	  //  System.out.println("");
        //        System.out.println("");
      //  CC2.setText(C);
     //       CdCd2.setText(Cd);


	}
	
}
