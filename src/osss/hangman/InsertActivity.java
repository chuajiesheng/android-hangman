package osss.hangman;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class InsertActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.insert_activity_layout);

		Button startButton = (Button) findViewById(R.id.next);
		startButton.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.insert, menu);
		return true;
	}

	@Override
	public void onClick(View arg0) {
		EditText text = (EditText) findViewById(R.id.insert_guess);
		String word = text.getText().toString();
		
		if (word != null && word.length() > 0) {
			Intent i = new Intent(getApplicationContext(), HangmanActivity.class);
			i.putExtra("word", word);
			startActivity(i);
		}

	}

}
