package com.example.gaurk.xpd_office.navigation_classes;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.gaurk.xpd_office.EmpItemListData;
import com.example.gaurk.xpd_office.EmpItemListVIEWData;
import com.example.gaurk.xpd_office.R;
import com.example.gaurk.xpd_office.SessionManager;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by gaurk on 12/24/2017.
 */

class ItemListAdapter extends BaseAdapter {

    LayoutInflater inflater;
    Context context;
    List<EmpItemListData> itemsList;

    public ItemListAdapter(Context context, List<EmpItemListData> itemsList) {
        this.context = context;
        this.itemsList = itemsList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return itemsList.size();
    }

    @Override
    public Object getItem(int position) {
        return itemsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder viewHolder;
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = this.inflater.inflate(R.layout.emp_mgmt_list_item, parent, false);

            viewHolder.empNameTextView = (TextView) convertView.findViewById(R.id.emp_mgmt_list_full_name_tv);
            viewHolder.empPositionTextView = (TextView) convertView.findViewById(R.id.emp_mgmt_list_position_tv);
            viewHolder.empGrpNameTextView = (TextView) convertView.findViewById(R.id.emp_mgmt_list_group_name_tv);
            viewHolder.empRepMgrTextView = (TextView) convertView.findViewById(R.id.emp_mgmt_list_rep_mgr_tv);
            viewHolder.empHireDtTextView = (TextView) convertView.findViewById(R.id.emp_mgmt_list_hire_dt_tv);

            viewHolder.top_rel_layout = (RelativeLayout) convertView.findViewById(R.id.emp_mgmt_list_layout_1);
//            viewHolder.bottom_rel_layout = (RelativeLayout) convertView.findViewById(R.id.emp_mgmt_list_layout_2);

            convertView.setTag(viewHolder);
        } else {

            viewHolder = (ViewHolder) convertView.getTag();

        }

        EmpItemListData emp_ListData = itemsList.get(position);

        viewHolder.empNameTextView = (TextView) convertView.findViewById(R.id.emp_mgmt_list_full_name_tv);
        viewHolder.empPositionTextView = (TextView) convertView.findViewById(R.id.emp_mgmt_list_position_tv);
        viewHolder.empGrpNameTextView = (TextView) convertView.findViewById(R.id.emp_mgmt_list_group_name_tv);
        viewHolder.empRepMgrTextView = (TextView) convertView.findViewById(R.id.emp_mgmt_list_rep_mgr_tv);
        viewHolder.empHireDtTextView = (TextView) convertView.findViewById(R.id.emp_mgmt_list_hire_dt_tv);

        viewHolder.empNameTextView.setText(emp_ListData.getEmpFName()+" "+emp_ListData.getEmpLName());
        viewHolder.empPositionTextView.setText("Position : "+emp_ListData.getEmpPos());
        viewHolder.empGrpNameTextView.setText("Department : "+emp_ListData.getEmpDept());
        viewHolder.empRepMgrTextView.setText("Reporting manger : "+emp_ListData.getEmpRepMgr());
        viewHolder.empHireDtTextView.setText("Hire Dt: "+emp_ListData.getEmpHireDt());

        //condition for separator : FALSE
//        if (!emp_ListData.getCategory().equals("SEPARATOR")) {
//
//            viewHolder.itemNameTextView.setVisibility(View.VISIBLE);
//            viewHolder.priorityTextView.setVisibility(View.VISIBLE);
//            viewHolder.statusCheckBox.setVisibility(View.VISIBLE);
//            viewHolder.rel_layout.setBackgroundColor(Color.parseColor("#00ffffff"));
//
//            viewHolder.itemNameTextView.setText(emp_ListData.getItemName());
//
//            System.out.println("sessionManager.getSpecificBooleanValue(SessionManager.SHOW_PRIORITY) : " + sessionManager.getSpecificBooleanValue(SessionManager.SHOW_PRIORITY));
//
//            //show prioroty condition : TRUE
//            if (sessionManager.getSpecificBooleanValue(SessionManager.SHOW_PRIORITY)) {
////                System.out.println("inside SHOW_PRIORITY TRUE");
//
//
//                viewHolder.priorityTextView.setVisibility(View.VISIBLE);
//                viewHolder.priorityTextView.setText(emp_ListData.getPriority());
//
//                if (emp_ListData.getPriority().equals("M")) {
//                    viewHolder.priorityTextView.setBackgroundResource(R.drawable.priority_high_text_bg);
//                    viewHolder.priorityTextView.setTextColor(Color.parseColor("#ff7b59"));
////                    System.out.println("inside M");
//                }
////            if (emp_ListData.getPriority().equals("M")) {
////                viewHolder.priorityTextView.setBackgroundResource(R.drawable.priority_medium_text_bg);
////                viewHolder.priorityTextView.setTextColor(Color.parseColor("#636bff"));
////            }
//                if (emp_ListData.getPriority().equals("O")) {
//                    viewHolder.priorityTextView.setBackgroundResource(R.drawable.priority_low_text_bg);
//                    viewHolder.priorityTextView.setTextColor(Color.parseColor("#24999A"));
////                    System.out.println("inside O");
//                }
//                if (emp_ListData.getPriority().equals("0")) {
//                    System.out.println("inside zero");
//                }
//            }
//
//        }

        return convertView;
    }

    public class ViewHolder {
        private TextView empNameTextView;
        private TextView empPositionTextView;
        private TextView empGrpNameTextView;
        private TextView empRepMgrTextView;
        private TextView empHireDtTextView;
        private RelativeLayout top_rel_layout;
        private RelativeLayout bottom_rel_layout;

    }
}
