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
    Context context;
    AlertDialog alertDialog;

    BackgroundDoctor(Context ctx) {
        context = ctx;
    }

    @Override
    protected String doInBackground(String... params) {
        String type = params[0];
        String update_url = "http://stethoman.esy.es/DoctorEditInfo.php";
        String editpat_url = "http://stethoman.esy.es/editpat.php";
        String sendsms_url = "http://stethoman.esy.es/SENDSmsd.php";
        String addmed_url = "http://stethoman.esy.es/AddMedication.php";
        String report_url = "http://stethoman.esy.es/report.php";
        String update2_url = "http://stethoman.esy.es/Patienteditinfo.php";
        String findmypat_url = "http://stethoman.esy.es/FINDMYPat.php";
        String findpatreport_url = "http://stethoman.esy.es/FINDMYPatreport.php";
        String getmsgd_url = "http://stethoman.esy.es/GETMsgd.php";
        if (type.equals("update")) {
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
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&"
                            + URLEncoder.encode("mobile", "UTF-8") + "=" + URLEncoder.encode(mobile, "UTF-8") + "&"
                            + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8") + "&"
                            + URLEncoder.encode("awards", "UTF-8") + "=" + URLEncoder.encode(awards, "UTF-8");

                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
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
        else if(type.equals("findmypat")) {
            try {
                String myid = params[1];
                URL url = new URL(findmypat_url);
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
                result = "findmypat";
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
        else if (type.equals("update2")) {
            try {
                String email = params[1];
                String mobile = params[2];
                String password = params[3];
                String address = params[4];
                URL url = new URL(update2_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("email", "UTF-8") + "=" + URLEncoder.encode(email, "UTF-8") + "&"
                            + URLEncoder.encode("mobile", "UTF-8") + "=" + URLEncoder.encode(mobile, "UTF-8") + "&"
                            + URLEncoder.encode("password", "UTF-8") + "=" + URLEncoder.encode(password, "UTF-8") + "&"
                            + URLEncoder.encode("address", "UTF-8") + "=" + URLEncoder.encode(address, "UTF-8");

                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
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
        } else if (type.equals("editpat")) {
            try {
                String myid = params[1];
                URL url = new URL(editpat_url);
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
        } else if (type.equals("medic")) {
            try {
                String myid = params[1];
                String medication = params[2];
                String time = params[3];
                String period = params[4];
                String comment = params[5];
                URL url = new URL(addmed_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("myid", "UTF-8") + "=" + URLEncoder.encode(myid, "UTF-8") + "&"
                            + URLEncoder.encode("medication", "UTF-8") + "=" + URLEncoder.encode(medication, "UTF-8") + "&"
                            + URLEncoder.encode("time", "UTF-8") + "=" + URLEncoder.encode(time, "UTF-8") + "&"
                            + URLEncoder.encode("period", "UTF-8") + "=" + URLEncoder.encode(period, "UTF-8") + "&"
                            + URLEncoder.encode("comment", "UTF-8") + "=" + URLEncoder.encode(comment, "UTF-8");

                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
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

        } else if (type.equals("report")) {
            try {
                String myid = params[1];
                String title = params[2];
                String specialization = params[3];
                String content = params[4];
                String doctid = params[5];
                URL url = new URL(report_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("myid", "UTF-8") + "=" + URLEncoder.encode(myid, "UTF-8") + "&"
                            + URLEncoder.encode("title", "UTF-8") + "=" + URLEncoder.encode(title, "UTF-8") + "&"
                            + URLEncoder.encode("specialization", "UTF-8") + "=" + URLEncoder.encode(specialization, "UTF-8") + "&"
                            + URLEncoder.encode("doctid", "UTF-8") + "=" + URLEncoder.encode(doctid, "UTF-8") + "&"
                            + URLEncoder.encode("content", "UTF-8") + "=" + URLEncoder.encode(content, "UTF-8");
                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";

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

        } else if (type.equals("lab")) {
            try {
                String myid = params[1];
                String medication = params[2];
                String time = params[3];
                String period = params[4];
                String comment = params[5];
                URL url = new URL(addmed_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("myid", "UTF-8") + "=" + URLEncoder.encode(myid, "UTF-8") + "&"
                            + URLEncoder.encode("medication", "UTF-8") + "=" + URLEncoder.encode(medication, "UTF-8") + "&"
                            + URLEncoder.encode("time", "UTF-8") + "=" + URLEncoder.encode(time, "UTF-8") + "&"
                            + URLEncoder.encode("period", "UTF-8") + "=" + URLEncoder.encode(period, "UTF-8") + "&"
                            + URLEncoder.encode("comment", "UTF-8") + "=" + URLEncoder.encode(comment, "UTF-8");
                    bufferedWriter.write(post_data);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "iso-8859-1"));
                String result = "";
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
                URL url = new URL(getmsgd_url);
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
        else if(type.equals("mypatreports")) {
            try {
                String patid = params[1];
                String docid = params[2];
                URL url = new URL(findpatreport_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                String result = "mypatreports";
                try {
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    String post_data = URLEncoder.encode("patid", "UTF-8") + "=" + URLEncoder.encode(patid, "UTF-8") + "&" +
                            URLEncoder.encode("docid", "UTF-8") + "=" + URLEncoder.encode(docid, "UTF-8");
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
        super.onPreExecute();

        alertDialog = new AlertDialog.Builder(context).create();
        alertDialog.setTitle("Status");
    }

    @Override
    protected void onPostExecute(String result) {

        if(result.contains("sendsms") && !result.contains("Error")){
            result = "Message has been sent";
            alertDialog.setMessage(result);
            alertDialog.show();
            delegate.processFinish(result);
        }
            //find list of patients to send msg
        else if(result.contains("findmypat") && !result.contains("Error")) {
            result = result.substring(result.indexOf("MYPAT"));
            delegate.processFinish(result);
        }
        else if (result.contains("Found ")) {
            result = "Found";
            alertDialog.setMessage(result);
            alertDialog.show();
            delegate.processFinish(result);
        }
        else if (result.contains("does Not")) {
            result = "Not";
            alertDialog.setMessage(result);
            alertDialog.show();
            delegate.processFinish(result);
        }
        else if(result.contains("getmsg") && !result.contains("Error")){
            result = result.substring(result.indexOf("MSG:"));
            delegate.processFinish(result);
        }
        //Get reports
        else if(result.contains("mypatreports") && !result.contains("Error")){
            result = result.substring(result.indexOf("REPORT:"));
            delegate.processFinish(result);
        }
        else if(result.contains("mypatreports") && result.contains("Error:")){
            result = result.substring(result.indexOf("Error:"));
            alertDialog.setMessage(result);
            delegate.processFinish(result);
            alertDialog.show();
        }
        else if(result.contains("successfully")) {
            result = "Added successfully";
            alertDialog.setMessage(result);
            alertDialog.show();
        }
        else {
            result = "Error exists";
            alertDialog.setMessage(result);
            alertDialog.show();
        }

    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
}