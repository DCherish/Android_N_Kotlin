package org.techtown.activitypractice10;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class InfoFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_info, container, false);

        Bundle bundle = getArguments();

        if (bundle != null)
        {
            Button button = rootView.findViewById(R.id.button_date);
            String str = bundle.getString("date");

            if (str.length() != 0)
            {
                button.setText(bundle.getString("date"));
            }
            else
            {
                Date currentTime = Calendar.getInstance().getTime();
                SimpleDateFormat dayFormat = new SimpleDateFormat("dd", Locale.KOREA);
                SimpleDateFormat monthFormat = new SimpleDateFormat("MM", Locale.KOREA); // mm은 minute
                SimpleDateFormat yearFormat = new SimpleDateFormat("yyyy", Locale.KOREA);

                String year = yearFormat.format(currentTime);
                String month = monthFormat.format(currentTime);
                String day = dayFormat.format(currentTime);

                button.setText(year + month + day);
            }
        }

        MainActivity activity = (MainActivity) getActivity();
        activity.onChangeState(0);

        Button button = rootView.findViewById(R.id.button_date);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.onFragmentChanged(0);
            }
        });

        Button button2 = rootView.findViewById(R.id.button_save);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Save Success", Toast.LENGTH_LONG).show();
            }
        });

        return rootView;
    }
}