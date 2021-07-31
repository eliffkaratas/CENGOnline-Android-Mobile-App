package com.example.cengonline;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;

public class Databasehelper extends SQLiteOpenHelper {
    public static final String STUDENT_TABLE = "STUDENT_TABLE";
    public static final String COLOUMN_STUDENT_ID = "STUDENT_ID";
    public static final String COLOUMN_NAME = "NAME";
    public static final String COLOUMN_STUDENT_NAME = "STUDENT_" + COLOUMN_NAME;
    public static final String COLOUMN_STUDENT_SURNAME = "STUDENT_SUR" + COLOUMN_NAME;
    
    public static final String TEACHER_TABLE = "TEACHER_TABLE";
    public static final String TEACHER_ID = "TEACHER_ID";
    public static final String TEACHER_NAME = "TEACHER_" + COLOUMN_NAME;
    public static final String TEACHER_SURNAME = "TEACHER_SUR" + COLOUMN_NAME;

    public static final String COURSE_TABLE = "COURSE_TABLE";
    public static final String COLOUMN_COURSE_ID = "COURSE_ID";
    public static final String COLOUMN_COURSE_NAME = "COURSE_" + COLOUMN_NAME;
    public static final String COLOUMN_STUDENT_1 = "STUDENT1";
    public static final String COLOUMN_STUDENT_2 = "STUDENT2";
    public static final String COLOUMN_STUDENT_3 = "STUDENT3";

    public static final String POST_TABLE = "POST_TABLE";
    public static final String POST_ID = "POST_ID";
    public static final String COURSEID = "COURSEID";
    public static final String COLOUMN_POST_NAME = "POST_" + COLOUMN_NAME;
    public static final String COLOUMN_POST_CONTENT = "POST_CONTENT";

    public static final String ANNOUNCMENT_TABLE = "ANNOUNCMENT_TABLE";
    public static final String COLOUMN_ANNOUNCMENT_ID = "ANNOUNCMENT_ID";
    public static final String COURSEID_2 = "COURSEID2";
    public static final String COLOUMN_ANNOUNCMENT_NAME = "ANNOUNCMENT_" + COLOUMN_NAME;
    public static final String COLOUMN_ANNOUNCMENT_CONTENT = "ANNOUNCMENT_CONTENT";

    public static final String ASSINGMENT_TABLE = "ASSINGMENT_TABLE";
    public static final String COLOUMN_ASSINGMENT_ID = "ASSINGMENT_ID";
    public static final String COLOUMN_COURSEID_3 = "COURSEID_3";
    public static final String COLOUMN_ASSINGMENT_NAME = "ASSINGMENT_" + COLOUMN_NAME;
    public static final String COLOUMN_ASSINGMENT_CONTENT = "ASSINGMENT_CONTENT";
    public static final String COLOUMN_DUE_DATE = "DUE_DATE";

    public static final String MESSAGE_TABLE = "MESSAGE_TABLE";
    public static final String COLOUMN_MESSAGE_ID = "MESSAGE_ID";
    public static final String COLOUMN_RECEIVER_ID = "RECEIVER_ID";
    public static final String COLOUMN_SENDER_NAME = "SENDER_" + COLOUMN_NAME;
    public static final String COLOUMN_SENDER_SURNAME = "SENDER_SUR" + COLOUMN_NAME;
    public static final String COLOUMN_RECEIVER_NAME = "RECEIVER_" + COLOUMN_NAME;
    public static final String RECEIVER_SURNAME = "RECEIVER_SUR" + COLOUMN_NAME;
    public static final String COLOUMN_MESSAGE_CONTENT = "MESSAGE_CONTENT";

    public static final String SUBMITTED_WORK_TABLE = "SUBMITTED_WORK_TABLE";
    public static final String COLOUMN_SUBMITTED_ID = "SUBMITTED_ID";
    public static final String COLOUMN_COURSEID_4 = "COURSEID_4";
    public static final String COLOUMN_ASSINGMENTID_2 = "ASSINGMENTID_2";
    public static final String COLOUMN_UPLOAD_FILE = "UPLOAD_FILE";

    public static final String POSTCOMMENT_TABLE = "POSTCOMMENT_TABLE";
    public static final String COLOUMN_POST_COMMENT_ID = "POST_COMMENT_ID";
    public static final String COLOUMN_COURSEID_5 = "COURSEID_5";
    public static final String COLOUMN_POSTID_2 = "POSTID_2";
    public static final String COLOUMN_COMMENTCONTENT = "COMMENTCONTENT";
    public static final String COLOUMN_SURNAME = "SURNAME";

    public Databasehelper(@Nullable Context context) {
        super(context, "ceng.db", null, 1);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        String table1= "CREATE TABLE " + STUDENT_TABLE + " (" + COLOUMN_STUDENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLOUMN_STUDENT_NAME + " TEXT, " + COLOUMN_STUDENT_SURNAME + " TEXT)";
        db.execSQL(table1);
        String table2= "CREATE TABLE " + TEACHER_TABLE + " (" + TEACHER_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TEACHER_NAME + " TEXT, " + TEACHER_SURNAME + " TEXT)";
        db.execSQL(table2);
        String table3= "CREATE TABLE " + COURSE_TABLE + " (" + COLOUMN_COURSE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLOUMN_COURSE_NAME + " TEXT, " + COLOUMN_STUDENT_1 + " INT, " + COLOUMN_STUDENT_2 + " INT, " + COLOUMN_STUDENT_3 + " INT)";
        db.execSQL(table3);
        String table4= "CREATE TABLE " + POST_TABLE + " (" + POST_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COURSEID + " INT, " + COLOUMN_POST_NAME + " TEXT, " + COLOUMN_POST_CONTENT + " TEXT)";
        db.execSQL(table4);
        String table5= "CREATE TABLE " + ANNOUNCMENT_TABLE + " (" + COLOUMN_ANNOUNCMENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COURSEID_2 + " INT, " + COLOUMN_ANNOUNCMENT_NAME + " TEXT, " + COLOUMN_ANNOUNCMENT_CONTENT + " TEXT)";
        db.execSQL(table5);
        String table6= "CREATE TABLE " + ASSINGMENT_TABLE + " (" + COLOUMN_ASSINGMENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLOUMN_COURSEID_3 + " INT, " + COLOUMN_ASSINGMENT_NAME + " TEXT, " + COLOUMN_ASSINGMENT_CONTENT + " TEXT, " + COLOUMN_DUE_DATE + " TEXT) ";
        db.execSQL(table6);
        String table7= "CREATE TABLE " + MESSAGE_TABLE + " (" + COLOUMN_MESSAGE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLOUMN_RECEIVER_ID + " INT, " + COLOUMN_SENDER_NAME + " TEXT, " + COLOUMN_SENDER_SURNAME + " TEXT, " + COLOUMN_RECEIVER_NAME + " TEXT, " + RECEIVER_SURNAME + " TEXT, " + COLOUMN_MESSAGE_CONTENT + " TEXT) ";
        db.execSQL(table7);
        String table8= "CREATE TABLE " + SUBMITTED_WORK_TABLE + " (" + COLOUMN_SUBMITTED_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLOUMN_COURSEID_4 + " INT, " + COLOUMN_ASSINGMENTID_2 + " INT, " + COLOUMN_UPLOAD_FILE + " TEXT)";
        db.execSQL(table8);
        String table9= "CREATE TABLE " + POSTCOMMENT_TABLE + " (" + COLOUMN_POST_COMMENT_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COLOUMN_COURSEID_5 + " INT, " + COLOUMN_POSTID_2 + " INT, " + COLOUMN_COMMENTCONTENT + " TEXT, " + COLOUMN_NAME + " TEXT, " + COLOUMN_SURNAME + " TEXT)";
        db.execSQL(table9);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public boolean addStudent(Student student) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLOUMN_STUDENT_NAME,student.getName());
        cv.put(COLOUMN_STUDENT_SURNAME,student.getSurname());
        long insert = db.insert(STUDENT_TABLE,null,cv);
        if (insert == -1){
            return false;
        }
        else{
            return true;
        }
    }
    public List<Student> geteveryone(){
        List<Student>returnlist=new ArrayList<>();
        List<Integer>student_number_list = new ArrayList<>();

        String queryString = "SELECT * FROM " + STUDENT_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);
        if (cursor.moveToFirst()){
            do {
                int studentID = cursor.getInt(0);
                String student_name = cursor.getString(1);
                String student_surname = cursor.getString(2);
                Student student=new Student(studentID,student_name,student_surname);
                returnlist.add(student);
            }while (cursor.moveToNext());
        }else
        {

        }
        cursor.close();
        db.close();
        return returnlist;
    }
    public boolean addTeacher(Teacher teacher) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(TEACHER_NAME,teacher.getName());
        cv.put(TEACHER_SURNAME,teacher.getSurname());
        long insert = db.insert(TEACHER_TABLE,null,cv);
        if (insert == -1){
            return false;
        }
        else{
            return true;
        }
    }
    public List<Teacher>geteveryone2(){
        List<Teacher>returnlist=new ArrayList<>();

        String queryString = "SELECT * FROM " + TEACHER_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);
        if (cursor.moveToFirst()){
            do {
                int teacherID = cursor.getInt(0);
                String teacher_name = cursor.getString(1);
                String teacher_surname = cursor.getString(2);
                Teacher teacher=new Teacher(teacherID,teacher_name,teacher_surname);
                returnlist.add(teacher);
            }while (cursor.moveToNext());
        }else
        {

        }
        cursor.close();
        db.close();
        return returnlist;
    }
    public boolean searchlogteacher(String y){
        List<Integer>teacherıd_list = new ArrayList<>();
        String queryString = "SELECT * FROM " + TEACHER_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);
        if (cursor.moveToFirst()){
            do {
                int teacherıd = cursor.getInt(0);
                teacherıd_list.add(teacherıd);
            }while (cursor.moveToNext());
        }else
        {

        }
        cursor.close();
        db.close();

        boolean flag = true;
        for (int i=0;i<teacherıd_list.size();i++){
            if (teacherıd_list.get(i)== Integer.parseInt (y)){
                flag = false;
                break;
            }
            else{
                flag=true;
            }
        }
        return flag;
    }
    public boolean searchlogStudent(String y){
        List<Integer>studentıd_list = new ArrayList<>();
        String queryString = "SELECT * FROM " + STUDENT_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(queryString,null);
        if (cursor.moveToFirst()){
            do {
                int studentıd = cursor.getInt(0);
                studentıd_list.add(studentıd);
            }while (cursor.moveToNext());
        }else
        {

        }
        cursor.close();
        db.close();

        boolean flag = true;
        for (int i=0;i<studentıd_list.size();i++){
            if (studentıd_list.get(i)==Integer.parseInt (y)){
                flag = false;
                break;
            }
            else{
                flag=true;
            }
        }
        return flag;
    }
    public boolean addCourse(String  x,String y,String z,String w) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLOUMN_COURSE_NAME,x);
        cv.put( COLOUMN_STUDENT_1,y);
        cv.put( COLOUMN_STUDENT_2,z);
        cv.put(COLOUMN_STUDENT_3,w);
        long insert = db.insert(COURSE_TABLE,null,cv);
        if (insert == -1){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean addPost(String  x,String y,String z) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COURSEID,x);
        cv.put(COLOUMN_POST_NAME ,y);
        cv.put(COLOUMN_POST_CONTENT,z);
        long insert = db.insert(POST_TABLE,null,cv);
        if (insert == -1){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean addAnnoucment(String  x,String y,String z) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COURSEID_2,x);
        cv.put(COLOUMN_ANNOUNCMENT_NAME ,y);
        cv.put(COLOUMN_ANNOUNCMENT_CONTENT,z);
        long insert = db.insert(ANNOUNCMENT_TABLE,null,cv);
        if (insert == -1){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean addAssignment(String x,String y,String z,String w){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLOUMN_COURSEID_3,x);
        cv.put(COLOUMN_ASSINGMENT_NAME ,y);
        cv.put(COLOUMN_ASSINGMENT_CONTENT,z);
        cv.put(COLOUMN_DUE_DATE,w);
        long insert = db.insert(ASSINGMENT_TABLE,null,cv);
        if (insert == -1){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean addPostComment(String x,String y,String z,String w,String a){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLOUMN_COURSEID_5,x);
        cv.put(COLOUMN_POSTID_2 ,y);
        cv.put(COLOUMN_COMMENTCONTENT,z);
        cv.put(COLOUMN_NAME ,w);
        cv.put(COLOUMN_SURNAME,a);
        long insert = db.insert(POSTCOMMENT_TABLE,null,cv);
        if (insert == -1){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean addFile(String x,String y,String z){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLOUMN_COURSEID_4 ,x);
        cv.put(COLOUMN_ASSINGMENTID_2,y);
        cv.put(COLOUMN_UPLOAD_FILE,z);
        long insert = db.insert(SUBMITTED_WORK_TABLE,null,cv);
        if (insert == -1){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean addStudentMessage(String x,String y,String z,String w,String a,String b){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put( COLOUMN_RECEIVER_ID ,x);
        cv.put(COLOUMN_SENDER_NAME,y);
        cv.put( COLOUMN_SENDER_SURNAME,z);
        cv.put( COLOUMN_RECEIVER_NAME,w);
        cv.put( RECEIVER_SURNAME,a);
        cv.put( COLOUMN_MESSAGE_CONTENT,b);
        long insert = db.insert(MESSAGE_TABLE,null,cv);
        if (insert == -1){
            return false;
        }
        else{
            return true;
        }
    }
    public boolean addTeacherMessage(String x,String y,String z,String w,String a,String b){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put( COLOUMN_RECEIVER_ID ,x);
        cv.put(COLOUMN_SENDER_NAME,y);
        cv.put( COLOUMN_SENDER_SURNAME,z);
        cv.put( COLOUMN_RECEIVER_NAME,w);
        cv.put( RECEIVER_SURNAME,a);
        cv.put( COLOUMN_MESSAGE_CONTENT,b);
        long insert = db.insert(MESSAGE_TABLE,null,cv);
        if (insert == -1){
            return false;
        }
        else{
            return true;
        }
    }




    public boolean updateAssingment(String ıd,String  x,String y,String z,String w){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLOUMN_COURSEID_3,x);
        cv.put(COLOUMN_ASSINGMENT_NAME ,y);
        cv.put(COLOUMN_ASSINGMENT_CONTENT,z);
        cv.put(COLOUMN_DUE_DATE,w);
        return db.update(ASSINGMENT_TABLE,cv,COLOUMN_ASSINGMENT_ID + "=?",new String[]{ıd})>0;
    }
    public boolean updateAnnoucment(String ıd,String  x,String y,String z){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COURSEID_2,x);
        cv.put(COLOUMN_ANNOUNCMENT_NAME ,y);
        cv.put(COLOUMN_ANNOUNCMENT_CONTENT,z);
        return db.update(ANNOUNCMENT_TABLE,cv,COLOUMN_ANNOUNCMENT_ID + "=?",new String[]{ıd})>0;
    }
    public boolean updatePost(String ıd,String  x,String y,String z){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COURSEID,x);
        cv.put(COLOUMN_POST_NAME ,y);
        cv.put(COLOUMN_POST_CONTENT,z);
        return db.update(POST_TABLE,cv,POST_ID + "=?",new String[]{ıd})>0;
    }
    public boolean updatecourse(String ıd,String  x,String y,String z,String w){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLOUMN_COURSE_NAME,x);
        cv.put( COLOUMN_STUDENT_1,y);
        cv.put( COLOUMN_STUDENT_2,z);
        cv.put(COLOUMN_STUDENT_3,w);
        return db.update(COURSE_TABLE,cv,COLOUMN_COURSE_ID + "=?",new String[]{ıd})>0;
    }
    public boolean deletePost(int x){

        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + POST_TABLE + " WHERE " + POST_ID + " = " + x;
        Cursor cursor = db.rawQuery(queryString,null);
        if (cursor.moveToFirst()){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean deleteCourse(int x){

        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + COURSE_TABLE + " WHERE " + COLOUMN_COURSE_ID + " = " + x;
        Cursor cursor = db.rawQuery(queryString,null);
        if (cursor.moveToFirst()){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean deleteAnnouncment(int x){

        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + ANNOUNCMENT_TABLE + " WHERE " + COLOUMN_ANNOUNCMENT_ID + " = " + x;
        Cursor cursor = db.rawQuery(queryString,null);
        if (cursor.moveToFirst()){
            return true;
        }
        else {
            return false;
        }
    }
    public boolean deleteAssingment(int x){

        SQLiteDatabase db = this.getWritableDatabase();
        String queryString = "DELETE FROM " + ASSINGMENT_TABLE + " WHERE " + COLOUMN_ASSINGMENT_ID + " = " + x;
        Cursor cursor = db.rawQuery(queryString,null);
        if (cursor.moveToFirst()){
            return true;
        }
        else {
            return false;
        }
    }
    public List<String>PostListele(String x){
        List<String>veriler=new ArrayList<String>();
        SQLiteDatabase db = this.getWritableDatabase();
        String[]stun={POST_ID,COLOUMN_POST_NAME,COLOUMN_POST_CONTENT};
        Cursor cursor = db.query(POST_TABLE,stun,COURSEID+" = '"+x+"'",null,null,null,null);
        while (cursor.moveToNext()){
            veriler.add("Post ID: " + cursor.getString(0) + "\nPost Name: " + cursor.getString(1)+ "\nPost Content: " + cursor.getString(2));
        }
        return veriler;
    }
    public List<String>AnnoucmentListele(String x){
        List<String>veriler=new ArrayList<String>();
        SQLiteDatabase db = this.getWritableDatabase();
        String[]stun={COLOUMN_ANNOUNCMENT_ID,COLOUMN_ANNOUNCMENT_NAME,COLOUMN_ANNOUNCMENT_CONTENT};
        Cursor cursor = db.query(ANNOUNCMENT_TABLE,stun,COURSEID_2+" = '"+x+"'",null,null,null,null);
        while (cursor.moveToNext()){
            veriler.add("Announcement ID: " + cursor.getString(0) + "\nAnnouncement Name: " + cursor.getString(1)+ "\nAnnouncement Content: " + cursor.getString(2));
        }
        return veriler;
    }
    public List<String>AssingmentListele(String x){
        List<String>veriler=new ArrayList<String>();
        SQLiteDatabase db = this.getWritableDatabase();
        String[]stun={COLOUMN_ASSINGMENT_ID,COLOUMN_ASSINGMENT_NAME,COLOUMN_ASSINGMENT_CONTENT,COLOUMN_DUE_DATE};
        Cursor cursor = db.query(ASSINGMENT_TABLE,stun,COLOUMN_COURSEID_3+" = '"+x+"'",null,null,null,null);
        while (cursor.moveToNext()){
            veriler.add("Assignment ID: " + cursor.getString(0) +  "\nAssignment Name: " + cursor.getString(1)+ "\nAssignment Content: " + cursor.getString(2)+ "\nDue Date: "+ cursor.getString(3));
        }
        return veriler;
    }
    public List<String>StudentCourseListele1(String x){
        List<String>veriler=new ArrayList<String>();
        SQLiteDatabase db = this.getWritableDatabase();

        String[]stun={COLOUMN_COURSE_ID,COLOUMN_COURSE_NAME};
        Cursor cursor = db.query(COURSE_TABLE,stun,COLOUMN_STUDENT_1+" = '"+x+"'",null,null,null,null);
        while (cursor.moveToNext()){
            veriler.add("Course ID: " + cursor.getString(0) + "\nCourse Name: " + cursor.getString(1));
        }
        return veriler;
    }
    public List<String>StudentCourseListele2(String x){
        List<String>veriler=new ArrayList<String>();
        SQLiteDatabase db = this.getWritableDatabase();

        String[]stun={COLOUMN_COURSE_ID,COLOUMN_COURSE_NAME};
        Cursor cursor = db.query(COURSE_TABLE,stun,COLOUMN_STUDENT_2+" = '"+x+"'",null,null,null,null);
        while (cursor.moveToNext()){
            veriler.add("Course ID: " + cursor.getString(0) + "\nCourse Name: " + cursor.getString(1));
        }
        return veriler;
    }
    public List<String>StudentCourseListele3(String x){
        List<String>veriler=new ArrayList<String>();
        SQLiteDatabase db = this.getWritableDatabase();

        String[]stun={COLOUMN_COURSE_ID,COLOUMN_COURSE_NAME};
        Cursor cursor = db.query(COURSE_TABLE,stun,COLOUMN_STUDENT_3+" = '"+x+"'",null,null,null,null);
        while (cursor.moveToNext()){
            veriler.add("Course ID: " + cursor.getString(0) + "\nCourse Name: " + cursor.getString(1));
        }
        return veriler;
    }
    public List<String>PostCommentListele3(String x){
        List<String>veriler=new ArrayList<String>();
        SQLiteDatabase db = this.getWritableDatabase();
        String[]stun={COLOUMN_NAME,COLOUMN_SURNAME,COLOUMN_COMMENTCONTENT};
        Cursor cursor = db.query(POSTCOMMENT_TABLE,stun,COLOUMN_POSTID_2 +" = '"+x+"'",null,null,null,null);
        while (cursor.moveToNext()){
            veriler.add("Name: " + cursor.getString(0) + " Surname: " + cursor.getString(1) + "\nPost Comment: " + cursor.getString(2));
        }
        return veriler;
    }
    public List<String>CourseListele(){
        List<String>veriler=new ArrayList<String>();
        SQLiteDatabase db = this.getWritableDatabase();
        String[]stun={COLOUMN_COURSE_ID,COLOUMN_COURSE_NAME};
        Cursor cursor = db.query(COURSE_TABLE,stun,null,null,null,null,null);
        while (cursor.moveToNext()){
            veriler.add("Course ID: " + cursor.getString(0) + "\nCourse Name: " + cursor.getString(1));
        }
        return veriler;
    }
    public List<String>SubmitListele(){
        List<String>veriler=new ArrayList<String>();
        SQLiteDatabase db = this.getWritableDatabase();
        String[]stun={COLOUMN_SUBMITTED_ID,COLOUMN_COURSEID_4, COLOUMN_ASSINGMENTID_2,COLOUMN_UPLOAD_FILE };
        Cursor cursor = db.query(SUBMITTED_WORK_TABLE,stun,null,null,null,null,null);
        while (cursor.moveToNext()){
            veriler.add("Submitted Work ID: " + cursor.getString(0) + "\nCourse ID: " + cursor.getString(1)+ "\nAssignment ID: " + cursor.getString(2) + "\nUploaded File: " +cursor.getString(3));
        }
        return veriler;
    }

    public List<String>SurnameSearch1(String x){
        List<String>veriler=new ArrayList<String>();
        SQLiteDatabase db = this.getWritableDatabase();
        String[]stun={COLOUMN_SENDER_NAME ,COLOUMN_SENDER_SURNAME,COLOUMN_MESSAGE_CONTENT};
        Cursor cursor = db.query(MESSAGE_TABLE,stun,RECEIVER_SURNAME +" = '"+x+"'",null,null,null,null);
        while (cursor.moveToNext()){
            veriler.add( "Sender Name: " + cursor.getString(0)+ "\nSender Surname: " + cursor.getString(1)+ "\nMessage Content: " + cursor.getString(2));
        }
        return veriler;
    }

    ///////////////method Overloading
    public List<String>SurnameSearch1(String x,String y){
        List<String>veriler=new ArrayList<String>();
        SQLiteDatabase db = this.getWritableDatabase();
        String[]stun={COLOUMN_MESSAGE_ID,COLOUMN_SENDER_NAME ,COLOUMN_SENDER_SURNAME,COLOUMN_MESSAGE_CONTENT,};
        Cursor cursor = db.query(MESSAGE_TABLE,stun,RECEIVER_SURNAME +" = '"+x+"'",null,null,null,null);
        while (cursor.moveToNext()){
            veriler.add( "Sender Name: " + cursor.getString(1)+ "\nSender Surname: " + cursor.getString(2)+ "\nMessage Content: " + cursor.getString(3));
        }
        return veriler;
    }





}
