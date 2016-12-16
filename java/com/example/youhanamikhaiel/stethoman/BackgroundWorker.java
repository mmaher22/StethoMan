package com.example.youhanamikhaiel.stethoman;

import android.app.AlertDialog;
import android.content.Context;
import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
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
 * Created by MohamedMaher on 12/15/2016.
 */

public class BackgroundWorker extends AsyncTask<String,Void,String> {
    public AsyncResponse delegate = null;
    Context context;
    AlertDialog alertDialog;
    BackgroundWorker (Context ctx) {
        context = ctx;
    }
    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String login_url = "http://stethoman.esy.es/LOGIN.php";
        String adddoc_url = "http://stethoman.esy.es/ADDDoctor.php";
        String addpat_url = "http://stethoman.esy.es/ADDPatient.php";
        if(type.equals("login")) {
            try {
                String myid = params[1];
                String password = params[2];
                String table = params[3];
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                String result="";
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("table", "UTF-8") + "=" + URLEncoder.encode(table, "UTF-8") + "&"
                            + URLEncoder.encode("myid", "UTF-8") + "=" + URLEncoder.encode(myid, "UTF-8") + "&"
                            + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8");
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
                result = "ed5ol";
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
        else if(type.equals("adddoc")) {
            try {
                String name = params[1];
                String mobile = params[2];
                String mail = params[3];
                String pass = params[4];
                String fees = params[5];
                String edu = params[6];
                String spec = params[7];

                URL url = new URL(adddoc_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                String result = "";
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&"
                            + URLEncoder.encode("mobile", "UTF-8") + "=" + URLEncoder.encode(mobile, "UTF-8") + "&"
                            + URLEncoder.encode("mail", "UTF-8") + "=" + URLEncoder.encode(mail, "UTF-8") + "&"
                            + URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8") + "&"
                            + URLEncoder.encode("fees", "UTF-8") + "=" + URLEncoder.encode(fees, "UTF-8") + "&"
                            + URLEncoder.encode("edu", "UTF-8") + "=" + URLEncoder.encode(edu, "UTF-8") + "&"
                            + URLEncoder.encode("imgurl", "UTF-8") + "=" + URLEncoder.encode("http://google.com", "UTF-8") + "&"
                            + URLEncoder.encode("spec", "UTF-8") + "=" + URLEncoder.encode(spec, "UTF-8");
                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                    //result += post_data;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String line = "";
                result += "zweddoc";
                while ((line = bufferedReader.readLine()) != null) {
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
                else if(type.equals("addpat"))
                {
                    try {
                        String name = params[1];
                        String mobile = params[2];
                        String mail = params[3];
                        String pass = params[4];
                        String address = params[5];
                        String blood = params[6];
                        String notes = params[7];

                        URL url = new URL(addpat_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        String result="";
                        try {
                            OutputStream outputStream = httpURLConnection.getOutputStream();
                            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                                String post_data = URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&"
                                + URLEncoder.encode("mobile", "UTF-8") + "=" + URLEncoder.encode(mobile, "UTF-8") + "&"
                                + URLEncoder.encode("mail", "UTF-8") + "=" + URLEncoder.encode(mail, "UTF-8") + "&"
                                + URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8") + "&"
                                + URLEncoder.encode("address", "UTF-8") + "=" + URLEncoder.encode(address, "UTF-8") + "&"
                                + URLEncoder.encode("blood", "UTF-8") + "=" + URLEncoder.encode(blood, "UTF-8") + "&"
                                + URLEncoder.encode("imgurl", "UTF-8") + "=" + URLEncoder.encode("http://google.com", "UTF-8") + "&"
                                + URLEncoder.encode("notes", "UTF-8") + "=" + URLEncoder.encode(notes, "UTF-8");
                            bufferedWriter.write(post_data);
                            bufferedWriter.flush();
                            bufferedWriter.close();
                            outputStream.close();

                        }catch (MalformedURLException e){
                            e.printStackTrace();
                        }
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"iso-8859-1"));
                        String line="";
                        result += "zwedpat";
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
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Status");
    }

    @Override
    protected void onPostExecute(String result) {

        if(result.contains("ed5ol") && result.contains("Logged"))result = "Logged in Successfully";
        else if(result.contains("ed5ol") ) result = "UserID and Password Combination doesn't match";

        else if(result.contains("zweddoc") && !result.contains("Error"))result = "Doctor Added Successfully";
        else if(result.contains("zwedpat") && !result.contains("Error"))result = "Patient Added Successfully";

        else result = result.substring(result.indexOf("Error:"));

        alertDialog.setMessage(result);
        alertDialog.show();
        delegate.processFinish(result);
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
