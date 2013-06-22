package osss.hangman;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class HangmanActivity extends Activity implements OnClickListener {

	private EditText words[];
	private String str;
	private GameLogic game;
	private int wrongTimes = 0;
	private int correctTimes = 0;
	private static final int IMAGES[] = {
		R.drawable.i1, 
		R.drawable.i2,
		R.drawable.i3, 
		R.drawable.i4, 
		R.drawable.i5, 
		R.drawable.i6, 
		R.drawable.i7, 
		R.drawable.i8 };
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hangman_layout);
		Bundle extras = getIntent().getExtras();
		String value = extras.getString("word");
		str = value;
		game = new GameLogic(str);

		if (extras != null) {
			LinearLayout row = (LinearLayout) findViewById(R.id.row);
			words = new EditText[value.length()];

			for (int j = 0; j < value.length(); j++) {
				words[j] = new EditText(this);
				words[j].setLayoutParams(new LayoutParams(
						LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT));
				words[j].setText("-");
				words[j].setEnabled(false);
				row.addView(words[j]);
			}
		}
		Button checkButton = (Button) findViewById(R.id.check_letter);
		checkButton.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.insert, menu);
		return true;
	}

	@Override
	public void onClick(View v) {
		EditText letter = (EditText) findViewById(R.id.guess_letter);
		String toBeChecked = letter.getText().toString();
		letter.setText("");
		if (toBeChecked.length() == 1) {
			char c = toBeChecked.charAt(0);
			ArrayList<Integer> indexes = game.checkLetter(c);
			if (indexes.size() == 0) {
				Context context = getApplicationContext();
				CharSequence text = "You missed the letter. Try again! you douche";
				int duration = Toast.LENGTH_SHORT;

				Toast toast = Toast.makeText(context, text, duration);
				toast.show();
				if (wrongTimes == 6) {
					Context context1 = getApplicationContext();
					CharSequence text1 = "You died a horrible death! I'm so happy!";
					int duration1 = Toast.LENGTH_LONG;

					Toast toast1 = Toast.makeText(context1, text1, duration1);
					toast1.show();
					ImageView image = (ImageView) findViewById(R.id.image1);
					image.setImageResource(IMAGES[7]);	
					
					Button startButton = (Button) findViewById(R.id.check_letter);
					startButton.setText("Start!");					
					letter.setEnabled(false);
					this.finish();
				}
				else
				{
					ImageView image = (ImageView) findViewById(R.id.image1);
					image.setImageResource(IMAGES[++wrongTimes]);		
				}
				
			}
			for (int i = 0; i < indexes.size(); i++) {
				words[indexes.get(i)].setText(""+c);
				correctTimes += indexes.size();
				if (correctTimes == str.length()) {
					Context context2 = getApplicationContext();
					CharSequence text2 = "You were lucky!! I'm so angry!";
					int duration2 = Toast.LENGTH_LONG;

					Toast toast2 = Toast.makeText(context2, text2, duration2);
					toast2.show();
					this.finish();
				}
			}
			TextView usedLetters = (TextView) findViewById(R.id.used_letters);
			usedLetters.setText(game.getUsedLetters());
			
		} else {
			Context context = getApplicationContext();
			CharSequence text = "Please insert only one letter!!! You moron";
			int duration = Toast.LENGTH_SHORT;

			Toast toast = Toast.makeText(context, text, duration);
			toast.show();
		}

	}

}
