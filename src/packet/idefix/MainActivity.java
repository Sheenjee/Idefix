package packet.idefix;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.app.Activity;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

	LinearLayout llt;
	Button b1,b2,b3;
	MediaPlayer mp;
	TextView text;
	EditText choix;
	ScrollView sw;
	int free=1;
	
	String ml[] = new String[] {"casabonita_juif", "casabonitajew1", "casabonitajew10", "casabonitajew11", "casabonitajew12", "casabonitajew2", "casabonitajew3", "casabonitajew4", "casabonitajew5", "casabonitajew6", "casabonitajew7", "casabonitajew8", "casabonitajew9", "chewi", "chewi1", "chewi10", "chewi11", "chewi12", "chewi13", "chewi14", "chewi15", "chewi16", "chewi17", "chewi18", "chewi19", "chewi2", "chewi20", "chewi3", "chewi4", "chewi5", "chewi6", "chewi7", "chewi8" , "chewi9", "fait_le", "fait_ton_gr", "greuh", "il_est_rate", "jeanpierre", "jetmpapa", "jevsdemandedevsart", "papa_y_senva", "servietsky1", "servietsky10", "servietsky11", "servietsky12", "servietsky13", "servietsky14", "servietsky15", "servietsky16", "servietsky2", "servietsky3", "servietsky4", "servietsky5", "servietsky6", "servietsky7", "servietsky8", "servietsky9"};
	int mllength=ml.length;
	Button bml[] = new Button[mllength];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		sw = new ScrollView(this);
		llt = new LinearLayout(this);
		llt.setGravity(Gravity.BOTTOM);
		llt.setOrientation(LinearLayout.VERTICAL);
		
		for(int indexb=0;indexb<mllength;indexb++){
			bml[indexb] = new Button(this, R.style.button_default);
			bml[indexb].setText(ml[indexb]);
			bml[indexb].setId(indexb);
			bml[indexb].setOnClickListener(this);
			llt.addView(bml[indexb]);
		}

		text = new TextView(this);
		text.setText("void");
		llt.addView(text);
		
		
		sw.addView(llt);
		setContentView(sw);
	}
	
	
	
	@Override
	public void onClick(View v) {
		
		PlaySound(ml[v.getId()]);
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
	
	     if(mp.isPlaying()==true){ text.setText("true");}else{ text.setText("false");}
	      }

	
	}
}