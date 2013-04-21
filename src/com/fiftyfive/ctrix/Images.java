package com.fiftyfive.ctrix;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.IBinder;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.Gallery.LayoutParams;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher.ViewFactory;

import com.actionbarsherlock.app.SherlockActivity;

public class Images extends SherlockActivity implements ViewFactory {
	
	Integer pics[] = {R.drawable.cancri_e,R.drawable.image_one,R.drawable.image_two,R.drawable.image_three,R.drawable.images_four,R.drawable.image_five,R.drawable.images_six,R.drawable.image_seven,R.drawable.image_nine};
	
	ImageSwitcher iSwitcher;
	
	
	/** Called when activity is first created*/
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.switcher);
        
        iSwitcher = (ImageSwitcher) findViewById(R.id.imageSwitcher01);
        iSwitcher.setFactory(this);
        iSwitcher.setInAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_in));
        iSwitcher.setOutAnimation(AnimationUtils.loadAnimation(this, android.R.anim.fade_out));
        
        Gallery gallery = (Gallery) findViewById(R.id.gallery01);
        gallery.setAdapter(new ImageAdapter(this));
        gallery.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				iSwitcher.setImageResource(pics[arg2]);				
			}    	
        	
		});
	}
	public class ImageAdapter extends BaseAdapter{

		private Context ctx;
		
		public ImageAdapter(Context c) {
			ctx = c;
		}

		@Override
		public int getCount() {
		
			return pics.length;
		}

		@Override
		public Object getItem(int arg0) {
			
			return arg0;
		}

		@Override
		public long getItemId(int arg0) {
			
			return arg0;
		}

		@Override
		public View getView(int arg0, View arg1, ViewGroup arg2) {
			
			ImageView iView = new ImageView(ctx);
			iView.setImageResource(pics[arg0]);
			iView.setScaleType(ImageView.ScaleType.FIT_XY);			
			iView.setLayoutParams(new Gallery.LayoutParams(150, 150));
			return iView;
		}
		
		
	}

	@Override
	public View makeView() {
		ImageView iView = new ImageView(this);
		iView.setScaleType(ImageView.ScaleType.FIT_CENTER);
		iView.setLayoutParams(new ImageSwitcher.LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
		iView.setBackgroundColor(Color.BLACK);
		return null;
	}

}
