package com.example.gaurk.xpd_office;

import android.app.AlertDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.gaurk.xpd_office.navigation_classes.Add_Employee;
import com.example.gaurk.xpd_office.navigation_classes.Employee_mgmt;
import com.example.gaurk.xpd_office.navigation_classes.Leave_management;
import com.example.gaurk.xpd_office.navigation_classes.Project_management;
import com.example.gaurk.xpd_office.navigation_classes.Reports;
import com.example.gaurk.xpd_office.navigation_classes.Settings_;
import com.example.gaurk.xpd_office.navigation_classes.System_Pref;
import com.example.gaurk.xpd_office.navigation_classes.Timesheet;

import java.util.ArrayList;
import java.util.List;

public class Main_Drawer_Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    SessionManager sessionManager;
    private ArrayAdapter<String> adapter;
    private Spinner create_dept_spinner;
    private Spinner timesheet_protype_spinner;
    private TextView dash_timesheet_goto;
    private TextView dash_dept_details_goto;
    private TextView dash_emp_details_goto;
    private AlertDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main__drawer_);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        sessionManager = new SessionManager(getApplicationContext());
        create_dept_spinner = (Spinner) findViewById(R.id.create_dept_sel_dept_spinner);
        timesheet_protype_spinner = (Spinner) findViewById(R.id.time_sheet_pro_type_spinner);
        dash_timesheet_goto = (TextView) findViewById(R.id.dash_goto_timesheet_details_tv);
        dash_emp_details_goto = (TextView) findViewById(R.id.dash_goto_employee_tv);
        dash_dept_details_goto = (TextView) findViewById(R.id.dash_goto_create_dept_tv);


        List<String> dept_list = new ArrayList<>();
        dept_list.add("G&A");
        dept_list.add(" Accounting");
        dept_list.add("     Test");
        dept_list.add(" Business Development");
        dept_list.add("Software Development");
        dept_list.add("--Select Parent Dept--");
        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_item, dept_list);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        create_dept_spinner.setAdapter(adapter);
        create_dept_spinner.setSelection(adapter.getCount() - 1);

        List<String> timesheet_proj_list = new ArrayList<>();
        timesheet_proj_list.add("All Project");
        timesheet_proj_list.add("Company Admin");
        timesheet_proj_list.add("XPD Development");
        adapter = new ArrayAdapter<String>(getApplicationContext(), R.layout.spinner_item, timesheet_proj_list);
        adapter.setDropDownViewResource(R.layout.spinner_dropdown_item);
        timesheet_protype_spinner.setAdapter(adapter);
        timesheet_protype_spinner.setSelection(adapter.getCount() - 1);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);


        dash_timesheet_goto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Project_management.class));

            }
        });
        dash_dept_details_goto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), System_Pref.class));
                System.out.print("IN dash_dept_details_goto LISTENER");

            }
        });
        dash_emp_details_goto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Add_Employee.class));
                System.out.print("IN dash_emp_details_goto LISTENER");

            }
        });


        DatabaseHandler databaseHandler = new DatabaseHandler(getApplicationContext());

        ArrayList<EmpItemListData> empList = databaseHandler.getEmpItemList();
        Cursor allEmpDataByCursor = databaseHandler.getAllEmpDataByCursor();

//        Toast.makeText(getApplicationContext(),""+empList.size(),Toast.LENGTH_LONG).show();

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main__drawer_, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        LayoutInflater flater = this.getLayoutInflater();
        AlertDialog.Builder builder = new AlertDialog.Builder(this);

        if (id == R.id.nav_admin) {
            // Handle the camera action


            View view = flater.inflate(R.layout.nav_admin_dialog, null);
            builder.setView(view);
            builder.setTitle("Admin");
            dialog = builder.create();
//            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();

            TextView sys_pref_tv = (TextView) view.findViewById(R.id.system_pref_tv);
            TextView leave_mgmt_tv = (TextView) view.findViewById(R.id.leave_mgmt_tv);
            leave_mgmt_tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.hide();
                    startActivity(new Intent(getApplicationContext(), Leave_management.class));
                }
            });
            sys_pref_tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.hide();
                    startActivity(new Intent(getApplicationContext(), System_Pref.class));
                }
            });


        } else if (id == R.id.nav_hr) {

            View view = flater.inflate(R.layout.nav_hr_dialog, null);
            builder.setView(view);
            builder.setTitle("HR");
            dialog = builder.create();
//            dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
//            dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            dialog.show();

            TextView emp_mgmt_tv = (TextView) view.findViewById(R.id.emp_mgmt_tv);
            TextView emp_grp_mgmt_tv = (TextView) view.findViewById(R.id.emp_grp_mgmt_tv);
            emp_mgmt_tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.hide();
                    startActivity(new Intent(getApplicationContext(), Employee_mgmt.class));
                }
            });
            emp_grp_mgmt_tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    dialog.hide();
                    startActivity(new Intent(getApplicationContext(), Add_Employee.class));
                }
            });


        }
//        else if (id == R.id.nav_cust_mgmt) {
//            startActivity(new Intent(getApplicationContext(), Customer_management.class));
//
//        }
        else if (id == R.id.nav_proj_mgmt) {
            startActivity(new Intent(getApplicationContext(), Project_management.class));

        } else if (id == R.id.nav_timesheet) {
            startActivity(new Intent(getApplicationContext(), Timesheet.class));

        } else if (id == R.id.nav_reports) {
            startActivity(new Intent(getApplicationContext(), Reports.class));
        } else if (id == R.id.action_settings) {
            startActivity(new Intent(getApplicationContext(), Settings_.class));

        } else if (id == R.id.nav_logout) {
            sessionManager.logoutUser();
            new DatabaseHandler(getApplicationContext()).deleteDatabaseTables();
            Intent login_intent = new Intent(getApplicationContext(), LoginActivity.class);
            startActivity(login_intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
