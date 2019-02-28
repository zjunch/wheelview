package com.example.zjc.wheelview;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import com.example.zjc.wheelview.wheelview.adapter.ArrayWheelAdapter;
import com.example.zjc.wheelview.wheelview.widget.WheelView;
import java.util.ArrayList;
import java.util.List;

/**
 * 自定义控件-自定义对话框
 */
public class ClassCustomDialog extends Dialog {
	private int type = -1;
	private TextView tosave,cancel;
	private String[] dataCourseNum = new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14",
			"15", "16", "17", "18", "19", "20","24","48","96" };
	private String[] dataCourseTimes = new String[] { "30","40", "45", "50","60","80", "90" ,"120","150","180" };
	private List<String> ListCourseTimes;
	private List<String> ListCourseNums ;
	private WheelView wheelView;

	public TextView getTosave() {
		return tosave;
	}

	public TextView getCancle() {
		return cancel;
	}
	/**
	 * @param context
	 */
	public ClassCustomDialog(Context context, String type) {
		super(context, R.style.CustomDialog);
		this.setCancelable(true);
		this.type=Integer.valueOf(type);
		setCustomView(context, Integer.valueOf(type));
	}

	public String getCurrentWheelItem(){
		String result ="";
		if(wheelView!=null){
			if(type==1){		//课时数
				result= ListCourseNums.get(wheelView.getCurrentPosition());
			}else if(type==2){	//课时时长
				result= ListCourseTimes.get(wheelView.getCurrentPosition());
			}else if(type==5){
				result=String.valueOf(wheelView.getCurrentPosition());
			}
		}
		return  result;
	}
	/**
	 * 设置整个弹出框的视图
	 */
	private void setCustomView(final Context context, int type) {
		View mView = null;
		mView =  LayoutInflater.from(context).inflate(R.layout.tea_dialog_teacher_year, null);
		cancel= (TextView) mView.findViewById(R.id.cancel);
		tosave= (TextView) mView.findViewById(R.id.comfirm);
		wheelView= (WheelView) mView.findViewById(R.id.wheelView);
		wheelView.setWheelAdapter(new ArrayWheelAdapter(context)); // 文本数据源
		wheelView.setSkin(WheelView.Skin.Common); // common 皮肤
		switch (type) {
			case 1:			//课时数
				ListCourseNums=new ArrayList<>();
				for (String aDataCourseNum : dataCourseNum) {
					ListCourseNums.add(aDataCourseNum);
				}
				wheelView.setWheelData(ListCourseNums);
				break;

			case 2:			//课时时长
//				mView =  LayoutInflater.from(context).inflate(R.layout.tea_dialog_teacher_year, null);
//				cancel= (TextView) mView.findViewById(R.id.cancel);
//				tosave= (TextView) mView.findViewById(R.id.comfirm);
//				wheelView= (WheelView) mView.findViewById(R.id.wheelView);
//				wheelView.setWheelAdapter(new ArrayWheelAdapter(context)); // 文本数据源
//				wheelView.setSkin(WheelView.Skin.Common); // common 皮肤
				ListCourseTimes= new ArrayList<>();
				for (int i = 0; i < dataCourseTimes.length; i++) {
					ListCourseTimes.add(dataCourseTimes[i]);
				}
				wheelView.setWheelData(ListCourseTimes);
				break;
			default:
				break;
		}
		super.setContentView(mView);
	}

	@Override
	public void setContentView(View view) {
		// 重写本方法，使外部调用时不可破坏控件的视图。
		// 也可以使用本方法改变CustomDialog的内容部分视图，比如让用户把内容视图变成复选框列表，图片等。这需要获取mView视图里的其它控件
	}


}
