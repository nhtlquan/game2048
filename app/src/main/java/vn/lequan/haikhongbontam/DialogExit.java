package vn.lequan.haikhongbontam;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


@SuppressLint("ValidFragment")
public class DialogExit extends DialogFragment {
    private View view;
    private Point point;
    private TextView txtxemsau, txtyeuthich, txtshare,textView23;
    public static SharedPreferences sharedpreferences;
    private static final String MyPREFERENCES = "DANHGIA";
    int PRIVATE_MODE = 0;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.MyDialog);
    }

    @Override
    public void onSaveInstanceState(Bundle arg0) {
        super.onSaveInstanceState(arg0);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.custom_popup, container, false);
            getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            sharedpreferences = getActivity().getSharedPreferences(MyPREFERENCES, PRIVATE_MODE);
            txtshare = (TextView) view.findViewById(R.id.txt_share);
            txtyeuthich = (TextView) view.findViewById(R.id.txt_yeuthich);
            txtxemsau = (TextView) view.findViewById(R.id.txt_xemsau);
            txtxemsau.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPreferences.Editor edit = sharedpreferences.edit();
                    edit.putBoolean("check", false);
                    edit.apply();
                    Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(AndroidUtils.gotoMaketStore(getActivity().getPackageName())));
                    startActivity(intent);
                }
            });
            txtyeuthich.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getActivity().finish();
                }
            });
            txtshare.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    SharedPreferences.Editor edit = sharedpreferences.edit();
                    edit.putBoolean("check", false);
                    edit.apply();
                    getActivity().finish();
                }
            });
        }
        return view;
    }
}
