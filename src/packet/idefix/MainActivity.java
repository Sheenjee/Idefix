package packet.idefix;

import java.util.Random;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {
	String fina[] = new String[99];
	String vide[] = new String[0];
	String menu[] = new String[] {"Southpark", "Simpson", "St@r-W@r5"};
	String PersonagesSouth[] = new String[] {"casabonita_juif", "casabonitajew1", "casabonitajew10", "casabonitajew11", "casabonitajew12", "casabonitajew2", "casabonitajew3", "casabonitajew4", "casabonitajew5", "casabonitajew6", "casabonitajew7", "casabonitajew8", "casabonitajew9", "fait_le" ,"fait_ton_gr", "greuh", "il_est_rate", "jeanpierre" ,"jetmpapa", "jevsdemandedevsart", "papa_y_senva", "servietsky1", "servietsky10", "servietsky11", "servietsky12", "servietsky13", "servietsky14", "servietsky15", "servietsky16", "servietsky2", "servietsky3", "servietsky4", "servietsky5", "servietsky6", "servietsky7", "servietsky8", "servietsky9"};
	String PersonagesSimpson[] = new String[] {"cavapas", "hopital","salade","croquemitaine","idiot","singe","douche","isocele","sirop","endormi","krapabell","teloche","ensemble","puissant","tv","gym","radio","xfiles"};
	String PersonagesChewi[] = new String[] {"chewi", "chewi1", "chewi10", "chewi11", "chewi12", "chewi13", "chewi14", "chewi15", "chewi16", "chewi17", "chewi18", "chewi19", "chewi2", "chewi20", "chewi3", "chewi4", "chewi5", "chewi6", "chewi7", "chewi8" ,"chewi9"};
	LinearLayout llt;
	Button b1,b2,b3;
	MediaPlayer mp;
	TextView text;
	EditText choix;
	ScrollView sw;
	int free=1;
	ImageButton imageButton;
	int mllength=0;
	int returnId=500;
	
	String Southpark[] = new String[] {"casabonita_juif", "casabonitajew1", "casabonitajew10", "casabonitajew11", "casabonitajew12", "casabonitajew2", "casabonitajew3", "casabonitajew4", "casabonitajew5", "casabonitajew6", "casabonitajew7", "casabonitajew8", "casabonitajew9","fait_ton_gr", "greuh", "il_est_rate", "jeanpierre" ,"jetmpapa", "jevsdemandedevsart", "papa_y_senva", "servietsky1", "servietsky10", "servietsky11", "servietsky12", "servietsky13", "servietsky14", "servietsky15", "servietsky16", "servietsky2", "servietsky3", "servietsky4", "servietsky5", "servietsky6", "servietsky7", "servietsky8", "servietsky9"};
	
	
	
	

	@SuppressLint("NewApi")
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		sw = new ScrollView(this);
		llt = new LinearLayout(this);
		llt.setGravity(Gravity.BOTTOM);
		llt.setOrientation(LinearLayout.VERTICAL);
	
		genButton(vide,false,menu,false);
		


		text = new TextView(this);
		text.setText("Bienvenue sur IdeFix choisisez une serie pour commencer");
		llt.addView(text);
		
		sw.addView(llt);
		setContentView(sw);
		
	}
	
	
	
	@Override
	public void onClick(View v) {
		if(v.getId()<mllength){
		PlaySound(fina[v.getId()]);
		}else if(v.getId()==returnId){
			sw.removeAllViews();llt.removeAllViews();genButton(vide,true,menu,false);sw.addView(llt);
			
		}else if(v.getId()==mllength){
			sw.removeAllViews();llt.removeAllViews();genButton(PersonagesSouth,false,menu,true);sw.addView(llt);
			
		}else if(v.getId()==mllength+1){
			sw.removeAllViews();llt.removeAllViews();genButton(PersonagesSimpson,false,menu,true);sw.addView(llt);
			
		}else if(v.getId()==mllength+2){
			sw.removeAllViews();llt.removeAllViews();genButton(PersonagesChewi,false,menu,true);sw.addView(llt);
			
		}else{
			
			
		}
	}
	
	@SuppressWarnings("unused")
	public void PlaySound(String fileName){
		if(free==0){
			mp.stop();
		mp.release();}
		
	    int sound_id = this.getResources().getIdentifier(fileName, "raw",
	                                                 this.getPackageName());
	   // b3.setText("nom du file : "+fileName+" et sound id : "+sound_id);
	    if(sound_id != 0) {
	    	
	      mp = MediaPlayer.create(this, sound_id);
	     
	      mp.setVolume(100,100); 
	      mp.start();
	      free=0;
	      int i = 0;
	
	     if(mp.isPlaying()==true){ text.setText("true");}else{ text.setText("false");}
	      }

	}

public void genButton(String[] ml,boolean AffMenu,String[] menu,boolean affMbutton){
	AffMenu=true;
	mllength=ml.length;
	if(AffMenu){
		Button menubt[] = new Button[menu.length];
		for(int indexb=0;indexb<menu.length;indexb++){
			menubt[indexb] = new Button(this);
			menubt[indexb].setText(menu[indexb]);
			menubt[indexb].setId(indexb+mllength);
			menubt[indexb].setOnClickListener(this);
			
		
			llt.addView(menubt[indexb]);
		}
		
	}
	if(!AffMenu){
		returnId=menu.length+mllength;
		Button returnBt = new Button(this);
		returnBt.setText("Retour");
		returnBt.setId(returnId);
		returnBt.setOnClickListener(this);
		llt.addView(returnBt);
		
	}
	
	if(affMbutton){
	Button bml[] = new Button[mllength];
	for(int indexb=0;indexb<mllength;indexb++){
		bml[indexb] = new Button(this);
		bml[indexb].setText(ml[indexb]);
		bml[indexb].setId(indexb);
		bml[indexb].setOnClickListener(this);
		if(indexb%2==0){
			Random rnd = new Random(); 
			int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
		bml[indexb].setBackgroundColor(color);
		 // bml[indexb].setBackgroundResource(R.drawable.str);
		}else {
			Random rnd = new Random(); 
			int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
			bml[indexb].setBackgroundColor(color);
		 // bml[indexb].setBackgroundResource(R.drawable.stb);
		
		}
	
		llt.addView(bml[indexb]);
	}
	}
	fina=ml;
	
	
}


}
