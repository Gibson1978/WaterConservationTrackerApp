package com.example.waterconservationappblank;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CalendarView;
import android.widget.TextView;
import java.util.HashMap;
import java.util.Locale;

public class LogFragment extends Fragment {

    // Keys used for passing data when fragment is instantiated
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // Variables to hold argument values (currently unused in logic)
    private String mParam1;
    private String mParam2;

    // UI Components
    private CalendarView calendarView;

    private TextView textUsage, textTotalPayment, textDatePaid;
    private TextView textAverageDay, textAverageHour, textAverageMinute, textAverageWeek;

    // Dummy water bill data based on date strings
    private final HashMap<String, String[]> mockData = new HashMap<>();

    public LogFragment() {
        // Required empty public constructor
    }

    // Factory method to create a new instance of this fragment using arguments
    public static LogFragment newInstance(String param1, String param2) {
        LogFragment fragment = new LogFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Retrieve any arguments passed when creating the fragment
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment from XML
        View view = inflater.inflate(R.layout.fragment_log, container, false);

        // Connect XML views to Java variables
        textUsage = view.findViewById(R.id.textUsage);
        textTotalPayment = view.findViewById(R.id.textTotalPayment);
        textDatePaid = view.findViewById(R.id.textDatePaid);
        textAverageDay = view.findViewById(R.id.textAverageDay);
        textAverageHour = view.findViewById(R.id.textAverageHour);
        textAverageMinute = view.findViewById(R.id.textAverageMinute);
        textAverageWeek = view.findViewById(R.id.textAverageWeek);
        calendarView = view.findViewById(R.id.calendarView);

        // Fill mockData map with dummy water bill data
        setupMockData();

        // Set a listener for date changes in the calendar view
        calendarView.setOnDateChangeListener((view1, year, month, dayOfMonth) -> {
            // Format selected date as dd/MM/yyyy
            String date = String.format(Locale.getDefault(), "%02d/%02d/%d", dayOfMonth, month + 1, year);
            textDatePaid.setText(date); // Display selected date

            // Generate dummy data based on selected day (for non-mock entries)
            int usage = 100 + (dayOfMonth * 5); // Example: base 100L + 5L per day
            double total = usage * 0.03;        // Assume cost per liter is RM0.03

            // Display generated values
            textUsage.setText(usage + " L");
            textTotalPayment.setText(String.format(Locale.getDefault(), "RM %.2f", total));
            textAverageDay.setText((usage / 30) + " L");
            textAverageHour.setText(String.format(Locale.getDefault(), "%.2f L", usage / 720.0));
            textAverageMinute.setText(String.format(Locale.getDefault(), "%.3f L", usage / 43200.0));
            textAverageWeek.setText((usage / 4) + " L");

            // You could also call updateReceiptFields() here if you want to use fixed mock data instead
        });

        return view;
    }

    // Add some mock water bill records for specific dates
    private void setupMockData() {
        // Format: { usage (L), total (RM), date, avg/day, avg/hour, avg/min, avg/week }
        mockData.put("2025-04-10", new String[]{
                "1450", "12.35", "2025-04-10", "48.3", "2.01", "0.03", "338.1"
        });
        mockData.put("2025-04-11", new String[]{
                "1620", "14.10", "2025-04-11", "54.0", "2.25", "0.037", "378.0"
        });
    }

    // Optional method to show mock data for specific dates (not currently called)
    private void updateReceiptFields(String dateKey) {
        if (mockData.containsKey(dateKey)) {
            String[] data = mockData.get(dateKey);
            textUsage.setText(data[0] + " L");
            textTotalPayment.setText("RM " + data[1]);
            textDatePaid.setText(data[2]);
            textAverageDay.setText(data[3] + " L");
            textAverageHour.setText(data[4] + " L");
            textAverageMinute.setText(data[5] + " L");
            textAverageWeek.setText(data[6] + " L");
        } else {
            // If no data found for that date, clear all fields
            textUsage.setText("");
            textTotalPayment.setText("");
            textDatePaid.setText("");
            textAverageDay.setText("");
            textAverageHour.setText("");
            textAverageMinute.setText("");
            textAverageWeek.setText("");
        }
    }
}
