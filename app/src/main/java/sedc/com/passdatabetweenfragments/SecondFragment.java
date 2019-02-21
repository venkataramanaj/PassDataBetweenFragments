package sedc.com.passdatabetweenfragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class SecondFragment extends Fragment {

    private TextView updateText;

    public SecondFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_second, container, false);
        updateText = (TextView)view.findViewById(R.id.text_update);
        return view;
    }

    public void updateTextField(String newText, int size){
        updateText.setText(newText);
        updateText.setTextSize(size);
//        updateText.setTextColor(color);
    }
}

