package com.computersoftware.week15.senddatafragment.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.computersoftware.week15.senddatafragment.R;

public class FragmentFirst extends Fragment {
    Context context;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.first_fragment,container,false);

            init(view);

        return view;
    }

    private void init(View view){
        context = getContext();
        final String [] dataList =  {"Core I3","Core I5","Core I7","Core I9"};
        ListView listView = view.findViewById(R.id.list_data);
        ArrayAdapter<String> mAdapter = new ArrayAdapter<String>(context,
                                                android.R.layout.simple_list_item_1,
                                                       dataList);
        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                Bundle bundle = new Bundle();
                FragmentSecond fragmentSecond = new FragmentSecond();

                bundle.putString("result",dataList[position]);
                fragmentSecond.setArguments(bundle);

                FragmentManager manager = getActivity().getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();

                transaction.replace(R.id.contentFragment,fragmentSecond)
                        .addToBackStack(null)
                        .commit();


            }
        });

    }



}
