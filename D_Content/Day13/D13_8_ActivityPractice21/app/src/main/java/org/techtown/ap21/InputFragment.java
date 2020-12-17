package org.techtown.ap21;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class InputFragment extends Fragment {

    EditText editText;
    EditText editText2;
    EditText editText3;

    String str;
    String str2;
    String str3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_input, container, false);

        editText = rootView.findViewById(R.id.editText);
        editText2 = rootView.findViewById(R.id.editText2);
        editText3 = rootView.findViewById(R.id.editText3);

        str = editText.getText().toString();
        str2 = editText2.getText().toString();
        str3 = editText3.getText().toString();

        Button button = rootView.findViewById(R.id.buttonOK);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int num = R.drawable.book;

                MainActivity activity = (MainActivity) getActivity();
                activity.saveBookInformation(num, str, str2, str3);

                editText.setText("");
                editText2.setText("");
                editText3.setText("");

                Toast.makeText(getActivity(), "저장 성공 :)", Toast.LENGTH_SHORT).show();

                InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);

                activity.getCurrentFocus().clearFocus();
            }
        });

        return rootView;
    }
}