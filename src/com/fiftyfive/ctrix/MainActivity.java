package com.fiftyfive.ctrix;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuInflater;
import com.actionbarsherlock.view.MenuItem;
import com.actionbarsherlock.widget.ShareActionProvider;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends SherlockActivity {
	
	private ShareActionProvider mshareActionProvider;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub

		// menu.add("Share").setIcon(R.drawable.share).setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
		 //menu.add("Gallery").setIcon(R.drawable.gallery).setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		
		MenuInflater inflater = getSupportMenuInflater();
		   inflater.inflate(R.menu.menu, menu);
		   
		  
		   
		   return super.onCreateOptionsMenu(menu);
		
		//return true;
		
	}	


	  @Override
	  public boolean onOptionsItemSelected(MenuItem item) {
	            //Toast.makeText(this, "Got Click: " + item.toString(),Toast.LENGTH_SHORT).show(); 
		switch (item.getItemId()) {
		case R.id.share_item:
			Toast.makeText(this, "Ooops! Could not load at this time",Toast.LENGTH_SHORT).show(); 
//			 ShareActionProvider mShareActionProvider = (ShareActionProvider) item.getActionProvider();
//			  // Set the default share intent
//			    Intent shareIntent = new Intent(Intent.ACTION_SEND);
//			    shareIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);
//			    shareIntent.setType("text/plain");
//			   // shareIntent.putExtra(Intent.EXTRA_TEXT, getString(R.string.share_text));
//			    shareIntent.putExtra(Intent.EXTRA_SUBJECT, "MAitho is Awesome");
//			    mShareActionProvider.setShareIntent(shareIntent);
			break;
			
			case R.id.gallery_item:
				Intent i = new Intent(MainActivity.this,MapichaActivity.class);
				startActivity(i);
				

		default:
			break;
		}
		return false;  		
	  }

}
