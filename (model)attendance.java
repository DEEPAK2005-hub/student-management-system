package model;

public class Attendance {

private int studentId;
private String date;
private String status;
private String name;

public int getStudentId() {
return studentId;
}

public void setStudentId(int studentId) {
this.studentId = studentId;
}

public String getDate() {
return date;
}

public void setDate(String date) {
this.date = date;
}

public String getStatus() {
return status;
}

public void setStatus(String status) {
this.status = status;
}


public String getName(){
return name;
}

public void setName(String name){
this.name = name;
}

}