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
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.computersoftware.week15.senddatafragment.R;

public class FragmentSecond  extends Fragment {

    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;
    TextView tv_result;
    EditText et_name,et_email,et_phone;
    Button btn_back , btn_submit;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.second_fragment,container,false);
            init(view);
        return view;
    }

    private void init(View view) {

        tv_result = view.findViewById(R.id.tv_result);
        et_name = view.findViewById(R.id.et_name);
        et_email = view.findViewById(R.id.et_email);
        et_phone = view.findViewById(R.id.et_phone);

        tv_result.setText(getArguments().getString("result"));

        fragmentManager = getActivity().getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();

        view.findViewById(R.id.btn_submit).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Bundle bundle = new Bundle();
                bundle.putString("result",tv_result.getText().toString());
                bundle.putString("name",et_name.getText().toString());
                bundle.putString("email",et_email.getText().toString());
                bundle.putString("phone",et_phone.getText().toString());

                FragmantThird third = new FragmantThird();
                third.setArguments(bundle);

                fragmentManager.popBackStack();
                fragmentTransaction.replace(R.id.contentFragment,third)
                        .addToBackStack(null).commit();


            }
        });

        btn_back = view.findViewById(R.id.btn_back);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentManager.popBackStack();
                fragmentTransaction.replace(R.id.contentFragment,new FragmentFirst())
                        .addToBackStack(null).commit();

            }
        });


    }
}
