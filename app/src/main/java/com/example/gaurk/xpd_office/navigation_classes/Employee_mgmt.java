package com.example.gaurk.xpd_office.navigation_classes;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AutoCompleteTextView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.gaurk.xpd_office.DatabaseHandler;
import com.example.gaurk.xpd_office.EmpItemListData;
import com.example.gaurk.xpd_office.R;
import com.example.gaurk.xpd_office.SessionManager;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by gaurk on 12/24/2017.
 */

public class Employee_mgmt extends AppCompatActivity {

    private ItemListAdapter itemListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.employee_mgmt);

        ListView empListView = (ListView) findViewById(R.id.emp_mgmt_list_view);

        DatabaseHandler databaseHandler = new DatabaseHandler(getApplicationContext());

        ArrayList<EmpItemListData> empList = databaseHandler.getEmpItemList();
        Cursor allEmpDataByCursor = databaseHandler.getAllEmpDataByCursor();

        System.out.println("empList.size() : " + empList.size());
//        Toast.makeText(getApplicationContext(), "" + empList.size(), Toast.LENGTH_LONG).show();


        itemListAdapter = new ItemListAdapter(getApplicationContext(), empList);
        empListView.setAdapter(itemListAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.

        //condition to enable/disable options depending on current page
        getMenuInflater().inflate(R.menu.emp_mgmt_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
//                finish();
                return true;
            case R.id.tab_add_new_emp:
                System.out.println("add pressed");
                startActivity(new Intent(getApplicationContext(), Add_Employee.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }


}