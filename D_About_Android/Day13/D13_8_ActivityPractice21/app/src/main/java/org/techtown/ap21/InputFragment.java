package org.techtown.ap21;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
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

    OnDatabaseCallback callback;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        callback = (OnDatabaseCallback) getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_input, container, false);

        editText = rootView.findViewById(R.id.editText);
        editText2 = rootView.findViewById(R.id.editText2);
        editText3 = rootView.findViewById(R.id.editText3);

        Button button = rootView.findViewById(R.id.buttonOK);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (editText.getText().toString().equals("")) {
                    Toast.makeText(getActivity(), "저장 실패 :(\n제목을 입력해주세요 :/", Toast.LENGTH_SHORT).show();
                } else {
                    if (editText2.getText().toString().equals("")) {
                        Toast.makeText(getActivity(), "저장 실패 :(\n저자를 입력해주세요 :/", Toast.LENGTH_SHORT).show();
                    } else {
                        if (editText3.getText().toString().equals("")) {
                            Toast.makeText(getActivity(), "저장 실패 :(\n내용을 입력해주세요 :/", Toast.LENGTH_SHORT).show();
                        } else {
                            callback.insert(editText.getText().toString().trim(), editText2.getText().toString().trim(), editText3.getText().toString().trim());

                            editText.setText("");
                            editText2.setText("");
                            editText3.setText("");

                            Toast.makeText(getActivity(), "저장 성공 :)", Toast.LENGTH_SHORT).show();

                            try {
                                InputMethodManager inputMethodManager = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                                inputMethodManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), 0);

                                getActivity().getCurrentFocus().clearFocus();
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        });

        return rootView;
    }
}