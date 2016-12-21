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
 * Created by MohamedMaher on 12/15/2016.
 */

public class BackgroundPatient extends AsyncTask<String,Void,String> {
    public AsyncResponse delegate = null;
    Context context;
    AlertDialog alertDialog;
    BackgroundPatient(Context ctx) {
        context = ctx;
    }
    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String addreview_url = "http://stethoman.esy.es/ADDReview.php";
        String finddocreview_url = "http://stethoman.esy.es/FINDDocreview.php";
        String findmydoc_url = "http://stethoman.esy.es/FINDMYDoc.php";
        String sendsms_url = "http://stethoman.esy.es/SENDSmsp.php";
        String findatslot_url = "http://stethoman.esy.es/FINDATSlot.php";
        String setappointment_url = "http://stethoman.esy.es/REGISTERSlot.php";
        String getdocdata_url = "http://stethoman.esy.es/GETDoctor.php";
        String getalarm_url = "http://stethoman.esy.es/GETAlarm.php";
        String getmsgp_url = "http://stethoman.esy.es/GETMsgp.php";
        String findreport_url = "http://stethoman.esy.es/FINDReport.php";
        String editpat_url = "http://stethoman.esy.es/FINDReport.php";
        String repf_url = "http://stethoman.esy.es/repp.php";

        if(type.equals("addreview")) {
            try {
                String myid = params[3];
                String docid = params[1];
                String review = params[2];
                URL url = new URL(addreview_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                String result="";
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("myid", "UTF-8") + "=" + URLEncoder.encode(myid, "UTF-8") + "&" +
                            URLEncoder.encode("docid", "UTF-8") + "=" + URLEncoder.encode(docid, "UTF-8") + "&" +
                            URLEncoder.encode("review", "UTF-8") + "=" + URLEncoder.encode(review, "UTF-8");
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
                result = "addreview";
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
        else if(type.equals("findatslot")) {
            try {
                String time = params[1];
                String spec = params[2];
                URL url = new URL(findatslot_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                String result="";
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("time", "UTF-8") + "=" + URLEncoder.encode(time, "UTF-8") + "&" +
                            URLEncoder.encode("spec", "UTF-8") + "=" + URLEncoder.encode(spec, "UTF-8");
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
                result = "findatslot";
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
        else if(type.equals("finddocreview")) {
            try {
                String myid = params[1];
                URL url = new URL(finddocreview_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                String result="";
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("myid", "UTF-8") + "=" + URLEncoder.encode(myid, "UTF-8");
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
                result = "finddocreview";
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
        else if(type.equals("findmydoc")) {
            try {
                String myid = params[1];
                URL url = new URL(findmydoc_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                String result="";
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("myid", "UTF-8") + "=" + URLEncoder.encode(myid, "UTF-8");
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
                result = "findmydoc";
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
        else if(type.equals("setappointment")) {
            try {
                String docid = params[1];
                String slotid = params[2];
                String patid = params[3];
                URL url = new URL(setappointment_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                String result="setappointment";
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("docid", "UTF-8") + "=" + URLEncoder.encode(docid, "UTF-8")+ "&"
                            + URLEncoder.encode("slotid", "UTF-8") + "=" + URLEncoder.encode(slotid, "UTF-8") + "&"
                            + URLEncoder.encode("patid", "UTF-8") + "=" + URLEncoder.encode(patid, "UTF-8");
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
        else if(type.equals("getdocdata")) {
            try {
                String docid = params[1];
                URL url = new URL(getdocdata_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                String result="getdocdata";
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("docid", "UTF-8") + "=" + URLEncoder.encode(docid, "UTF-8");
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
        else if(type.equals("getalarm")) {
            try {
                String myid = params[1];
                URL url = new URL(getalarm_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                String result="getalarm";
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("myid", "UTF-8") + "=" + URLEncoder.encode(myid, "UTF-8");
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
                String fromid = params[4];
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
                            + URLEncoder.encode("fromid", "UTF-8") + "=" + URLEncoder.encode(fromid, "UTF-8") + "&"
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
                String myid = params[1];
                URL url = new URL(getmsgp_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                String result="getmsg";
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("myid", "UTF-8") + "=" + URLEncoder.encode(myid, "UTF-8");
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

        else if (type.equals("rep")) {
            try {
                String myid = params[1];
                URL url = new URL(repf_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                String result = "";
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("myid", "UTF-8") + "=" + URLEncoder.encode(myid, "UTF-8");
                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                    result += post_data;
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String line = "";
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


        else if(type.equals("myreports")) {
            try {
                String myid = params[1];
                URL url = new URL(findreport_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                String result = "myreports";
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("myid", "UTF-8") + "=" + URLEncoder.encode(myid, "UTF-8");
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
            return null;
    }

    @Override
    protected void onPreExecute() {
        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Status");
    }

    @Override
    protected void onPostExecute(String result) {
        //add review
        if(result.contains("addreview") && !result.contains("Error"))result = result.substring(result.indexOf("Review"));
            //find list of doctors to review
        else if(result.contains("finddocreview") && !result.contains("Error"))result = result.substring(result.indexOf("DOC"));
            //find list of doctors to send msg
        else if(result.contains("findmydoc") && !result.contains("Error"))result = result.substring(result.indexOf("MYDOC"));
            //Send Message
        else if(result.contains("sendsms") && !result.contains("Error")) result = "Message has been sent";
            //Find Available Slots
        else if(result.contains("findatslot") && !result.contains("Error")) result = result.substring(result.indexOf("SLOT"));
            //Register at time slot
        else if(result.contains("setappointment") && !result.contains("Error")) result = "You have Registered Successfully";
            //Get Doctor Data
        else if(result.contains("getdocdata") && !result.contains("Error")) result = result.substring(result.indexOf("Dr:"));
            //Get Alarm Data
        else if(result.contains("getalarm") && !result.contains("Error")) result = result.substring(result.indexOf("Alarm:"));
            //Get Msg
        else if(result.contains("getmsg") && !result.contains("Error")) result = result.substring(result.indexOf("MSG:"));
            //Get reports
        else if(result.contains("myreports") && !result.contains("Error")) result = result.substring(result.indexOf("REPORT:"));
            // patient has reports
        else if(result.contains("ReportFoundSuccessfully")&& !result.contains("Error")) result ="Found";

            //Error Exists
        else result = result.substring(result.indexOf("Error:"));
        alertDialog.setMessage(result);
        delegate.processFinish(result);

        if( !result.contains("DOC") &&!result.contains("SLOT") &&!result.contains("Dr:") &&!result.contains("MSG:") &&!result.contains("REPORT:") )
            alertDialog.show();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}
