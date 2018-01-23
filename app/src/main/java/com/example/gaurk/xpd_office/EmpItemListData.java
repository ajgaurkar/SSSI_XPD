package com.example.gaurk.xpd_office;

/**
 * Created by gaurk on 12/24/2017.
 */

public class EmpItemListData {

    String empId;
    String empFName;
    String empLName;
    String empMName;
    String empHireDt;
    String empRelDt;
    String empRetrDt;
    String empPos;
    String empDept;
    String empOffEmail;
    String empRepMgr;

    public EmpItemListData(String empId, String empFName, String empLName, String empMName, String empHireDt, String empRelDt, String empRetrDt, String empPos, String empDept, String empOffEmail, String empRepMgr) {
        this.empId = empId;
        this.empFName = empFName;
        this.empLName = empLName;
        this.empMName = empMName;
        this.empHireDt = empHireDt;
        this.empRelDt = empRelDt;
        this.empRetrDt = empRetrDt;
        this.empPos = empPos;
        this.empDept = empDept;
        this.empOffEmail = empOffEmail;
        this.empRepMgr = empRepMgr;
    }

    public String getEmpId() {
        return empId;
    }

    public void setEmpId(String empId) {
        this.empId = empId;
    }

    public String getEmpFName() {
        return empFName;
    }

    public void setEmpFName(String empFName) {
        this.empFName = empFName;
    }

    public String getEmpLName() {
        return empLName;
    }

    public void setEmpLName(String empLName) {
        this.empLName = empLName;
    }

    public String getEmpMName() {
        return empMName;
    }

    public void setEmpMName(String empMName) {
        this.empMName = empMName;
    }

    public String getEmpHireDt() {
        return empHireDt;
    }

    public void setEmpHireDt(String empHireDt) {
        this.empHireDt = empHireDt;
    }

    public String getEmpRelDt() {
        return empRelDt;
    }

    public void setEmpRelDt(String empRelDt) {
        this.empRelDt = empRelDt;
    }

    public String getEmpRetrDt() {
        return empRetrDt;
    }

    public void setEmpRetrDt(String empRetrDt) {
        this.empRetrDt = empRetrDt;
    }

    public String getEmpPos() {
        return empPos;
    }

    public void setEmpPos(String empPos) {
        this.empPos = empPos;
    }

    public String getEmpDept() {
        return empDept;
    }

    public void setEmpDept(String empDept) {
        this.empDept = empDept;
    }

    public String getEmpOffEmail() {
        return empOffEmail;
    }

    public void setEmpOffEmail(String empOffEmail) {
        this.empOffEmail = empOffEmail;
    }

    public String getEmpRepMgr() {
        return empRepMgr;
    }

    public void setEmpRepMgr(String empRepMgr) {
        this.empRepMgr = empRepMgr;
    }
}
