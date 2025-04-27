package com.example.waterconservationappblank;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class SettingFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_setting, container, false);

        Switch airSelangorSwitch = view.findViewById(R.id.switchAirSelangor);
        airSelangorSwitch.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                Toast.makeText(getContext(), "Connected to Air Selangor", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getContext(), "Disconnected from Air Selangor", Toast.LENGTH_SHORT).show();
            }
        });

        TextView termsText = view.findViewById(R.id.termsTextView);
        termsText.setOnClickListener(v -> {
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.example.com/terms"));
            startActivity(browserIntent);
        });

        return view;
    }
}