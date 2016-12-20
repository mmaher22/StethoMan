package com.example.youhanamikhaiel.stethoman;
import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

/**
 * Created by OmarMerghany on 12/16/2016.
 */

public class BackgroundDoctor extends AsyncTask<String,Void,String> {
    public AsyncResponse delegate = null;
    //public addmedication delegate = null;
    Context  context;
    AlertDialog alertDialog;
    BackgroundDoctor(Context ctx){
        context = ctx;
    }




    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String update_url = "http://stethoman.esy.es/DoctorEditInfo.php";
        String editpat_url = "http://stethoman.esy.es/editpat.php";
        String addmed_url = "http://stethoman.esy.es/AddMedication.php";
        String report_url= "http://stethoman.esy.es/report.php";
        if(type.equals("update")){
            try {
                String email = params[1];
                String mobile = params[2];
                String password = params[3];
                String awards = params[4];
                URL url = new URL(update_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                try{
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&"
                            + URLEncoder.encode("mobile", "UTF-8") + "=" + URLEncoder.encode(mobile, "UTF-8") + "&"
                            + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8") + "&"
                            + URLEncoder.encode("awards", "UTF-8") + "=" + URLEncoder.encode(awards, "UTF-8");

//System.out.println(post_data);
                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                }catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";
                String line="";
                while ((line = bufferedReader.readLine()) != null){
                    result += line;


                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            }  catch (IOException e) {
                e.printStackTrace();
            }


        }
        else if(type.equals("editpat")){
            try{
                String myid = params[1];
                System.out.println("shit 1 "+myid);
               // String table = params[2];
                //System.out.println("shit 2 "+table);
                URL url = new URL(editpat_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                System.out.println("the connection is  "+httpURLConnection);
                String result="";
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("myid", "UTF-8") + "=" + URLEncoder.encode(myid, "UTF-8");
System.out.println("shit before "+ post_data);
                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                    result += post_data;
                }catch (MalformedURLException e){
                    e.printStackTrace();
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String line="";
                System.out.println("shit 3 "+ result);

                while((line = bufferedReader.readLine())!= null) {
                    result += line;
                }
                System.out.println("shit 4 "+ result);
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(type.equals("medic")){
            try{
                String myid = params[1];
                String medication = params[2];
                String time =params[3];
                System.out.println("the iddddddd is "+myid);
//                String time =params[3];
                String period = params[4];
System.out.println(period);
                //  String period = params[4];
                String comment = params[5];
                //String comment = params[5];
                URL url = new URL(addmed_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
               // String result="";
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("myid", "UTF-8") + "=" + URLEncoder.encode(myid, "UTF-8") + "&"
                            +URLEncoder.encode("medication", "UTF-8") + "=" + URLEncoder.encode(medication, "UTF-8") + "&"
                            + URLEncoder.encode("time", "UTF-8") + "=" + URLEncoder.encode(time, "UTF-8") + "&"
                            + URLEncoder.encode("period", "UTF-8") + "=" + URLEncoder.encode(period, "UTF-8") + "&"
                            + URLEncoder.encode("comment", "UTF-8") + "=" + URLEncoder.encode(comment, "UTF-8");


System.out.println("Shoot 1  "+post_data);

                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                }catch (MalformedURLException e){
                    e.printStackTrace();
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";

                String line="";

                while((line = bufferedReader.readLine())!= null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        else if(type.equals("report")){
            try{
                String myid = params[1];
                String title = params[2];
                String specialization = params[3];
                System.out.println("fuck 1 "+ specialization);
                String content = params[4];
                System.out.println("fuck 2 "+content);

                URL url = new URL(report_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("myid", "UTF-8") + "=" + URLEncoder.encode(myid, "UTF-8") + "&"
                            +URLEncoder.encode("title", "UTF-8") + "=" + URLEncoder.encode(title, "UTF-8") + "&"
                            +URLEncoder.encode("specialization", "UTF-8") + "=" + URLEncoder.encode(specialization, "UTF-8") + "&"
                            +URLEncoder.encode("content", "UTF-8") + "=" + URLEncoder.encode(content, "UTF-8") ;

                    System.out.println("the entered data is "+post_data);

                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                }catch (MalformedURLException e){
                    e.printStackTrace();
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";

                String line="";
                while((line = bufferedReader.readLine())!= null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (IOException e) {
                e.printStackTrace();
            }

        }


        else if(type.equals("lab")){
            try{
                String myid = params[1];
                String medication = params[2];
                String time =params[3];
                System.out.println("the iddddddd is "+myid);
//                String time =params[3];
                String period = params[4];
                System.out.println(period);
                //  String period = params[4];
                String comment = params[5];
                //String comment = params[5];
                URL url = new URL(addmed_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                // String result="";
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("myid", "UTF-8") + "=" + URLEncoder.encode(myid, "UTF-8") + "&"
                            +URLEncoder.encode("medication", "UTF-8") + "=" + URLEncoder.encode(medication, "UTF-8") + "&"
                            + URLEncoder.encode("time", "UTF-8") + "=" + URLEncoder.encode(time, "UTF-8") + "&"
                            + URLEncoder.encode("period", "UTF-8") + "=" + URLEncoder.encode(period, "UTF-8") + "&"
                            + URLEncoder.encode("comment", "UTF-8") + "=" + URLEncoder.encode(comment, "UTF-8");


                    System.out.println(post_data);

                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                    //result += post_data;
                }catch (MalformedURLException e){
                    e.printStackTrace();
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                String result="";

                String line="";

                while((line = bufferedReader.readLine())!= null) {
                    result += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();
                return result;

            } catch (IOException e) {
                e.printStackTrace();
            }

        }







        return null;
    }


    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Lessa");
        //

    }

    @Override
    protected void onPostExecute(String result) {
        //if (result.contains("medic")){ result = "medication page";}
        //else if (result.contains("lab")) {result = "lab page";}
        System.out.println("the problem is here "+result);
        if (result.contains("Found ")){result = "Found";

            alertDialog.setMessage(result);
            alertDialog.show();
            delegate.Finish(result);
        }
       // else if(result.contains("lab")){result = "Found";}
        else if(result.contains("does Not")){result="Not";

            alertDialog.setMessage(result);
            alertDialog.show();
            delegate.Finish(result);}
        //else if(result.contains("added"){result = "added";}
        else{result = "Not";
            alertDialog.setMessage(result);
            alertDialog.show();
        }
        System.out.println("the  "+result);

       // alertDialog.setMessage(result);
        //alertDialog.show();
        //delegate.Finish(result);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

}
