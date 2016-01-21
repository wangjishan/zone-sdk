package com.example.mylib_test.activity.touch.view;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.widget.ListView;

public class ListView_InnerConfict1 extends ListView{

	private static final String TAG = "ListView_InnerConfict1";
	public ListView_InnerConfict1(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
	}

	public ListView_InnerConfict1(Context context, AttributeSet attrs) {
		this(context, attrs,0);
	}

	public ListView_InnerConfict1(Context context) {
		this(context,null);
	}
	private int downx,downy;
	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		switch (ev.getAction()) {
		case MotionEvent.ACTION_DOWN :
			getParent().requestDisallowInterceptTouchEvent(true);
			Log.i(TAG, "dispatchTouchEvent ACTION_DOWN");
			downx=(int) ev.getX();
			downy=(int) ev.getY();
			break;
		case MotionEvent.ACTION_MOVE:
			Log.i(TAG, "dispatchTouchEvent ACTION_MOVE");
			int deltaX=(int)ev.getX()-downx;
			int deltaY=(int)ev.getY()-downy;
			if(Math.abs(deltaX)>Math.abs(deltaY)){
				getParent().requestDisallowInterceptTouchEvent(false);
			}
			break;
		case MotionEvent.ACTION_UP:
			break;

		default:
			break;
		}
		return super.dispatchTouchEvent(ev);
	}
	@Override
	public boolean onInterceptTouchEvent(MotionEvent ev) {
		switch (ev.getAction()) {
		case MotionEvent.ACTION_DOWN :
			Log.i(TAG, "onInterceptTouchEvent ACTION_DOWN");
			break;
		case MotionEvent.ACTION_MOVE:
			Log.i(TAG, "onInterceptTouchEvent ACTION_MOVE");
			break;
		case MotionEvent.ACTION_UP:
			break;

		default:
			break;
		}
		return super.onInterceptTouchEvent(ev);
	}
	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		switch (ev.getAction()) {
		case MotionEvent.ACTION_DOWN :
			Log.i(TAG, "onTouchEvent ACTION_DOWN");
			break;
		case MotionEvent.ACTION_MOVE:
			Log.i(TAG, "onTouchEvent ACTION_MOVE");
			break;
		case MotionEvent.ACTION_UP:
			break;

		default:
			break;
		}
		return super.onTouchEvent(ev);
	}
	

}
