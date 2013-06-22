package osss.hangman;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;

public class HangmanActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hangman_layout);
		
		Bundle extras = getIntent().getExtras();
		if (extras != null) {
		    String value = extras.getString("word");
		    
		    // remove this during integration
		    Toast t = Toast.makeText(getApplicationContext(), value, Toast.LENGTH_SHORT);
		    t.show();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.insert, menu);
		return true;
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub

	}

}
