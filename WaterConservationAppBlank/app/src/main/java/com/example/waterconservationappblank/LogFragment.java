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

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    private CalendarView calendarView;

    private TextView textUsage, textTotalPayment, textDatePaid, textAverageDay, textAverageHour, textAverageMinute, textAverageWeek;

    private final HashMap<String, String[]> mockData = new HashMap<>();

    public LogFragment() {
        // Required empty public constructor
    }

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
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_log, container, false);

        // Initialize views
        textUsage = view.findViewById(R.id.textUsage);
        textTotalPayment = view.findViewById(R.id.textTotalPayment);
        textDatePaid = view.findViewById(R.id.textDatePaid);
        textAverageDay = view.findViewById(R.id.textAverageDay);
        textAverageHour = view.findViewById(R.id.textAverageHour);
        textAverageMinute = view.findViewById(R.id.textAverageMinute);
        textAverageWeek = view.findViewById(R.id.textAverageWeek);
        calendarView = view.findViewById(R.id.calendarView);

        // Setup mock data for demonstration
        setupMockData();

        // Set up calendar listener
        calendarView.setOnDateChangeListener((view1, year, month, dayOfMonth) -> {
            String date = String.format("%02d/%02d/%d", dayOfMonth, month + 1, year);
            textDatePaid.setText(date);

            // Change dummy values based on the selected day
            int usage = 100 + (dayOfMonth * 5);
            double total = usage * 0.03;
            textUsage.setText(usage + " L");
            textTotalPayment.setText(String.format("RM %.2f", total));
            textAverageDay.setText((usage / 30) + " L");
            textAverageHour.setText(String.format("%.2f L", usage / 720.0));
            textAverageMinute.setText(String.format("%.3f L", usage / 43200.0));
            textAverageWeek.setText((usage / 4) + " L");
        });

        return view;
    }

    private void setupMockData() {
        // Mock data by date string "yyyy-MM-dd"
        mockData.put("2025-04-10", new String[]{
                "1450", "12.35", "2025-04-10", "48.3", "2.01", "0.03", "338.1"
        });
        mockData.put("2025-04-11", new String[]{
                "1620", "14.10", "2025-04-11", "54.0", "2.25", "0.037", "378.0"
        });
    }

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
            // Clear fields if no data
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
