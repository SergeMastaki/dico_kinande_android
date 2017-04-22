package io.github.sergemastaki.dicokinande;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.view.*;
import io.github.sergemastaki.dicokinande.database.*;
import android.support.v7.app.*;

public class MainActivity extends AppCompatActivity 
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		
		// Add spinner for choosing translation language
		Spinner spinner = (Spinner) findViewById(R.id.mainSpinner);
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
												R.array.trans_lang,
												android.R.layout.simple_spinner_item);									
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spinner.setAdapter(adapter);
		
		MyHelper helper = new MyHelper(this);
    }

	@Override
	public boolean onCreateOptionsMenu(Menu menu)
	{
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main_activity_menu,menu);
		return true;
	}
	
	
}
