package sedc.com.passdatabetweenfragments;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

public class FirstFragment extends Fragment {

    private OnFragmentInteractionListener mListener;
    private EditText userInput;
//    private LineColorPicker colorPicker;
    private static int seekBarValue = 10;
    private String userData;

    public FirstFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first, container, false);

        userInput = (EditText)view.findViewById(R.id.user_input);
        SeekBar seekBar = (SeekBar)view.findViewById(R.id.seekBar);
//        colorPicker =(LineColorPicker)view.findViewById(R.id.picker);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                seekBarValue = progress;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

/*        colorPicker.setColors(new int[] {Color.RED,Color.GREEN,Color.BLUE,Color.YELLOW});
        colorPicker.setSelectedColor(Color.RED);
        colorPicker.setOnColorChangedListener(new OnColorChangedListener() {
            @Override
            public void onColorChanged(int c) {
                Log.d("TAG ", "Selectede color " + Integer.toHexString(c));
            }
        });*/

        Button update = (Button)view.findViewById(R.id.button);
        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                mColor = colorPicker.getColor();
                if(userInput.getText().toString().equals("")){
                    Toast.makeText(getActivity(), "User input value must be filled", Toast.LENGTH_LONG).show();
                    return;
                }
                userData = userInput.getText().toString();
                onButtonPressed(userData, seekBarValue);
            }
        });
        return view;
    }

    public void onButtonPressed(String userContent, int size) {
        if (mListener != null) {
            mListener.onFragmentInteraction(userContent, size);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(String userContent, int size);
    }

}