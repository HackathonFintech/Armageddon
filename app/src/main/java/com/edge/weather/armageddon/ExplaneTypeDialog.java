package com.edge.weather.armageddon;

/**
 * Created by c2619 on 2018-03-21.
 */


import android.app.Activity;
import android.content.DialogInterface;

public class ExplaneTypeDialog extends CreateRoomActivity{
    public ExplaneTypeDialog(Activity activity){
        System.out.println(this);
        new android.app.AlertDialog.Builder( activity).
                setTitle( "계 종류" ).
                setIcon( android.R.drawable.ic_dialog_alert ).
                setMessage( "일반계 : 어쩌구저쩌구"+"\n"+
                        "낙찰계 : 어쩌구저쩌구"+"\n"+
                        "번호계 : 어쩌구저쩌구"+"\n"
                ).
                setPositiveButton( "예", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        System.out.println( "------> 예 clicked" );
                    }
                } ).show();
    }
}