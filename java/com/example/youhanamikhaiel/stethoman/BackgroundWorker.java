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
        String addman_url = "http://stethoman.esy.es/ADDManager.php";
        String delsel_url = "http://stethoman.esy.es/DELSELUser.php";
        String deldel_url = "http://stethoman.esy.es/DELDELUser.php";
        String finddoc_url = "http://stethoman.esy.es/FINDDoctor.php";
        String addslot_url = "http://stethoman.esy.es/ADDSlot.php";
        String findslot_url = "http://stethoman.esy.es/FINDSlot.php";
        String delslot_url = "http://stethoman.esy.es/DELSlot.php";
        String forget_url = "http://stethoman.esy.es/FORGETUser.php";
        String finduser_url = "http://stethoman.esy.es/FINDUser.php";
        String sendsms_url = "http://stethoman.esy.es/SENDSms.php";
        String getmsgm_url = "http://stethoman.esy.es/GETMsgm.php";
        String resetpass_url = "http://stethoman.esy.es/RESETPass.php";
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
        if(type.equals("resetpass")) {
            try {
                String myid = params[1];
                String table = params[2];
                URL url = new URL(resetpass_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                String result;
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("userid", "UTF-8") + "=" + URLEncoder.encode(myid, "UTF-8") + "&" +
                            URLEncoder.encode("table", "UTF-8") + "=" + URLEncoder.encode(table, "UTF-8");
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
                result = "resetpass";
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
        else if(type.equals("forget")) {
            try {
                String myid = params[1];
                String mob = params[2];
                String name = params[3];
                String table = params[4];
                URL url = new URL(forget_url);
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
                            + URLEncoder.encode("name", "UTF-8") + "=" + URLEncoder.encode(name, "UTF-8") + "&"
                            + URLEncoder.encode("mob", "UTF-8") + "=" + URLEncoder.encode(mob, "UTF-8");
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
                result = "forget";
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
        else if(type.equals("finddoc")) {
            try {

                URL url = new URL(finddoc_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                String result = "";
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String line = "";
                result += "finddoc";
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
        else if(type.equals("finduser")) {
            try {

                URL url = new URL(finduser_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                String result = "";
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String line = "";
                result += "finduser";
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
        else if(type.equals("findslot")) {
            try {
                String docid = params[1];
                URL url = new URL(findslot_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                String result = "";
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("docid", "UTF-8") + "=" + URLEncoder.encode(docid, "UTF-8");
                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                    result += post_data;
                }catch (MalformedURLException e){
                    e.printStackTrace();
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String line = "";
                result += "findslot";
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
        else if(type.equals("addman")) {
            try {
                String name = params[1];
                String mobile = params[2];
                String mail = params[3];
                String pass = params[4];

                URL url = new URL(addman_url);
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
                            + URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8");
                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String line = "";
                result += "zwedman";
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
                                + URLEncoder.encode("pass", "UTF-8") + "=" + URLEncoder.encode(pass, "UTF-8") + "&"
                                + URLEncoder.encode("mail", "UTF-8") + "=" + URLEncoder.encode(mail, "UTF-8") + "&"
                                + URLEncoder.encode("address", "UTF-8") + "=" + URLEncoder.encode(address, "UTF-8") + "&"
                                + URLEncoder.encode("blood", "UTF-8") + "=" + URLEncoder.encode(blood, "UTF-8") + "&"
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
        else if(type.equals("delsel")) {
            try {
                String myid = params[1];
                String table = params[2];
                URL url = new URL(delsel_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                String result="delsel";
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("table", "UTF-8") + "=" + URLEncoder.encode(table, "UTF-8") + "&"
                            + URLEncoder.encode("myid", "UTF-8") + "=" + URLEncoder.encode(myid, "UTF-8");
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
        else if(type.equals("deldel")) {
            try {
                String myid = params[1];
                String table = params[2];
                URL url = new URL(deldel_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                String result="deldel";
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("table", "UTF-8") + "=" + URLEncoder.encode(table, "UTF-8") + "&"
                            + URLEncoder.encode("myid", "UTF-8") + "=" + URLEncoder.encode(myid, "UTF-8");
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
        else if(type.equals("addslot")) {
            try {
                String maxpat = params[1];
                String timestamp = params[2];
                String docid = params[3];
                URL url = new URL(addslot_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                String result="addslot";
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("maxpat", "UTF-8") + "=" + URLEncoder.encode(maxpat, "UTF-8") + "&"
                            + URLEncoder.encode("docid", "UTF-8") + "=" + URLEncoder.encode(docid, "UTF-8") + "&"
                            + URLEncoder.encode("timestamp", "UTF-8") + "=" + URLEncoder.encode(timestamp, "UTF-8");
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
        else if(type.equals("delslot")) {
            try {
                String slotid = params[1];
                URL url = new URL(delslot_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                String result="delslot";
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("slotid", "UTF-8") + "=" + URLEncoder.encode(slotid, "UTF-8");
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
        else if(type.equals("sendsms")) {
            try {
                String msg = params[1];
                String userid1 = params[2];
                String table = params[3];
                URL url = new URL(sendsms_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                String result="sendsms";
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("msg", "UTF-8") + "=" + URLEncoder.encode(msg, "UTF-8")+ "&"
                            + URLEncoder.encode("table", "UTF-8") + "=" + URLEncoder.encode(table, "UTF-8") + "&"
                            + URLEncoder.encode("userid", "UTF-8") + "=" + URLEncoder.encode(userid1, "UTF-8");
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
        else if(type.equals("getmsg")) {
            try {
                URL url = new URL(getmsgm_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                String result="getmsg";
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("myid", "UTF-8") + "=" + URLEncoder.encode("0", "UTF-8");
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
            //Login succ
        if(result.contains("ed5ol") && result.contains("Logged"))result = "Logged in Successfully";
            //Add Doctor succ
        else if(result.contains("zweddoc") && !result.contains("Error"))result = result.substring(result.indexOf("Added"));
            //Add Patient succ
        else if(result.contains("zwedpat") && !result.contains("Error"))result = result.substring(result.indexOf("Added"));
            //Add Manager succ
        else if(result.contains("zwedman") && !result.contains("Error"))result = "Manager Added Successfully";
            //Select User on Delete
        else if(result.contains("delsel") && !result.contains("Error")) result = result.substring(result.indexOf("User Name:"));
            //Delete User on Delete
        else if(result.contains("deldel") && !result.contains("Error")) result = "User Deleted Successfully";
            //Doctor Names List
        else if(result.contains("finddoc") && !result.contains("Error")) result = result.substring(result.indexOf("DOC"));
            //Slots List
        else if(result.contains("findslot") && !result.contains("Error")) result = result.substring(result.indexOf("SLOT"));
            //Add Time Slot
        else if(result.contains("addslot") && !result.contains("Error")) result = "Time Slot Added Successfully";
            //Time Slot Delete
        else if(result.contains("delslot") && !result.contains("Error")) result = "Time Slot Deleted Successfully";
            //Forget Password
        else if(result.contains("forget") && !result.contains("Error")) result = "Request Sent Successfully";
            //Find User
        else if(result.contains("finduser") && !result.contains("Error")) result = result.substring(result.indexOf("USER"));
            //Send Message
        else if(result.contains("sendsms") && !result.contains("Error")) result = "Message has been sent";
            //Get Msg
        else if(result.contains("getmsg") && !result.contains("Error")) result = result.substring(result.indexOf("MSG:"));
            //Reset Pass
        else if(result.contains("resetpass") && !result.contains("Error")) result = "Password has been reset";
            //Error Exists
        else result = result.substring(result.indexOf("Error:"));

        alertDialog.setMessage(result);
        if(!result.contains("DOC") && !result.contains("SLOT") && !result.contains("USER") && !result.contains("MSG:") )
            alertDialog.show();

        delegate.processFinish(result);
    }


    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
