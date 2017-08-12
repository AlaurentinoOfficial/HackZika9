package org.passinhos.passinhos;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import org.passinhos.passinhos.Adapters.IncomeAdapter;
import org.passinhos.passinhos.Models.Income;

import java.util.ArrayList;
import java.util.List;

public class IncomeFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_income, container, false);
    }

    @Override
    public void onViewCreated(View v, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(v, savedInstanceState);

        ListView listView = (ListView) v.findViewById(R.id.income_list);

        Income i = new Income();
        i.setTitle("Bolos para venda");
        i.setDescription("Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos");

        Income i2 = new Income();
        i2.setTitle("Fabricação de bijoterias");
        i2.setDescription("Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos");

        Income i3 = new Income();
        i3.setTitle("Fabricação de bonecas de pano");
        i3.setDescription("Lorem Ipsum é simplesmente uma simulação de texto da indústria tipográfica e de impressos");

        List<Income> is = new ArrayList<>();
        is.add(i);
        is.add(i2);
        is.add(i3);

        is.add(i);
        is.add(i2);
        is.add(i3);

        IncomeAdapter adapter = new IncomeAdapter((ArrayList<Income>) is, v.getContext());

        listView.setAdapter(adapter);
    }
}
