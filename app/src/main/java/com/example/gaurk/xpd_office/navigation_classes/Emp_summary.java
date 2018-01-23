package com.example.gaurk.xpd_office.navigation_classes;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.gaurk.xpd_office.DatabaseHandler;
import com.example.gaurk.xpd_office.EmpItemListData;
import com.example.gaurk.xpd_office.R;

/**
 * Created by gaurk on 12/21/2017.
 */

public class Emp_summary extends Fragment {

    String profile_Pic_url;
    ImageView profile_Pic_IV;
    ImageView profile_Pic_add_IV;

    EditText f_n_EText;
    EditText m_n_EText;
    EditText l_n_EText;
    EditText add_emp_hire_dt_EditText;
    EditText add_emp_rel_dt_EditText;
    EditText add_emp_retir_dt_EditText;
    EditText add_emp_id_EditText;
    EditText add_emp_off_email_EditText;
    EditText add_emp_position_EditText;
    EditText add_emp_rep_mgr_EditText;
    EditText add_emp_off_phone_EditText;
    EditText add_emp_dept_EditText;
    EditText add_emp_grp_EditText;
    Button add_emp_save_button;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.emp_summary_xml,
                container, false);


        f_n_EText = (EditText)rootView.findViewById(R.id.add_emp_f_name_EditText);
        m_n_EText = (EditText)rootView.findViewById(R.id.add_emp_m_name_EditText);
        l_n_EText = (EditText)rootView.findViewById(R.id.add_emp_l_name_EditText);
        profile_Pic_IV = (ImageView)rootView.findViewById(R.id.add_emp_profile_pic);
        profile_Pic_add_IV = (ImageView)rootView.findViewById(R.id.imageView7);

        add_emp_hire_dt_EditText = (EditText)rootView.findViewById(R.id.add_emp_hire_dt_EditText);
        add_emp_rel_dt_EditText = (EditText)rootView.findViewById(R.id.add_emp_rel_dt_EditText);
        add_emp_retir_dt_EditText = (EditText)rootView.findViewById(R.id.add_emp_retir_dt_EditText);
        add_emp_id_EditText = (EditText)rootView.findViewById(R.id.add_emp_id_EditText);
        add_emp_off_email_EditText = (EditText)rootView.findViewById(R.id.add_emp_off_email_EditText);
        add_emp_position_EditText = (EditText)rootView.findViewById(R.id.add_emp_position_EditText);
        add_emp_rep_mgr_EditText = (EditText)rootView.findViewById(R.id.add_emp_rep_mgr_EditText);
        add_emp_off_phone_EditText = (EditText)rootView.findViewById(R.id.add_emp_off_phone_EditText);
        add_emp_dept_EditText = (EditText)rootView.findViewById(R.id.add_emp_dept_EditText);
        add_emp_grp_EditText = (EditText)rootView.findViewById(R.id.add_emp_grp_EditText);
        add_emp_save_button = (Button)rootView.findViewById(R.id.add_emp_save_button);

        add_emp_save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatabaseHandler databaseHandler =  new DatabaseHandler(getActivity());
                databaseHandler.addEmpItem(new EmpItemListData(
                        add_emp_id_EditText.getText().toString(),
                        f_n_EText.getText().toString(),
                        l_n_EText.getText().toString(),
                        m_n_EText.getText().toString(),
                        add_emp_hire_dt_EditText.getText().toString(),
                        add_emp_rel_dt_EditText.getText().toString(),
                        add_emp_retir_dt_EditText.getText().toString(),
                        add_emp_position_EditText.getText().toString(),
                        add_emp_dept_EditText.getText().toString(),
                        add_emp_off_email_EditText.getText().toString(),
                        add_emp_rep_mgr_EditText.getText().toString()

                ));
            }
        });

        return rootView;

    }
}
