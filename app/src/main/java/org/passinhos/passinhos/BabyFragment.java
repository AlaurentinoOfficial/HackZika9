package org.passinhos.passinhos;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.passinhos.passinhos.Adapters.TimelineAdapter;
import org.passinhos.passinhos.Models.Timeline;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


public class BabyFragment extends Fragment {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_baby, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<Timeline> ts = new ArrayList<>();

        ts.add(new Timeline("Nascimento"));
        ts.add(new Timeline("Alimentando-se"));
        ts.add(new Timeline("Explorando objetos"));
        ts.add(new Timeline("Desenvolvimento dos sentidos"));

        RecyclerView recycler = (RecyclerView) view.findViewById(R.id.timeline);
        recycler.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        recycler.setLayoutManager(layoutManager);

        TimelineAdapter mAdapter = new TimelineAdapter(ts);
        recycler.setAdapter(mAdapter);
    }
}
