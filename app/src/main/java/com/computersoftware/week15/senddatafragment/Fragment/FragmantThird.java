package com.computersoftware.week15.senddatafragment.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.computersoftware.week15.senddatafragment.R;

public class FragmantThird extends Fragment implements View.OnClickListener {

    FragmentManager manager;
    FragmentTransaction transaction;
    TextView tv_result,tv_name,tv_email,tv_phone;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.third_fragment,container,false);
            init(view);
        return view;
    }

    private void init(View view) {

        tv_result = view.findViewById(R.id.tv_result);
        tv_name = view.findViewById(R.id.tv_name);
        tv_email = view.findViewById(R.id.tv_email);
        tv_phone = view.findViewById(R.id.tv_phone);

        tv_result.setText(getArguments().getString("result"));
        tv_name.setText(getArguments().getString("name"));
        tv_email.setText(getArguments().getString("email"));
        tv_phone.setText(getArguments().getString("phone"));

        view.findViewById(R.id.btn_back).setOnClickListener(this);
        view.findViewById(R.id.btn_end).setOnClickListener(this);
        manager = getActivity().getSupportFragmentManager();
        transaction = manager.beginTransaction();


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_back:

                    Bundle bundle = new Bundle();
                    bundle.putString("result",tv_result.getText().toString());

                    FragmentSecond second = new FragmentSecond();
                    second.setArguments(bundle);
                    transaction.replace(R.id.contentFragment,second)
                                .addToBackStack(null)
                                .commit();


                break;
            case R.id.btn_end:
                    manager.popBackStack();
                    transaction.replace(R.id.contentFragment,new FragmentFirst()).commit();
                break;

        }

    }
}
