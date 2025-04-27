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

/**
 * This fragment represents the Settings screen.
 * It includes a switch for connecting to Air Selangor and a link to the Terms & Conditions.
 */
public class SettingFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment using the fragment_setting.xml file
        View view = inflater.inflate(R.layout.fragment_setting, container, false);


        // Find the TextView that acts as a clickable Terms & Conditions link
        TextView termsText = view.findViewById(R.id.termsTextView);

        // Set an onClickListener to open a browser and load the Terms & Conditions URL
        termsText.setOnClickListener(v -> {
            // Create an Intent to open a web browser with the given URL
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.example.com/terms"));
            startActivity(browserIntent); // Start the activity to open the URL
        });

        // Return the completed view for the fragment
        return view;
    }
}
