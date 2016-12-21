<?php
require "CONN.php";
$user_name = urldecode($_POST['myid']);
$table_name = urldecode($_POST['table']);
$user_pass = urldecode($_POST['password']);

if($table_name == "manager")
$mysql_qry = "select * from ".$table_name. " where ManagerID ='".$user_name."' and password='".$user_pass."' ";
else if($table_name == "doctor")
$mysql_qry = "select * from ".$table_name. " where DoctorID ='".$user_name."' ";
else
$mysql_qry = "select * from ".$table_name. " where PatientID ='".$user_name."' ";


$result = mysql_query($mysql_qry) ;

if(mysql_num_rows($result) > 0 && $table_name == "manager" ) {
  $row = mysql_fetch_array($result);  
  if($row['Password'] == $user_pass) echo "Logged in Successfully";
  else echo "Error: 2)UserID and Password Combination does not exist";
}

else if(mysql_num_rows($result) > 0 && $table_name == "doctor") {
  $row = mysql_fetch_array($result); 
  if($row['setPass'] == 1)
  {
    $sql = "UPDATE doctor SET Password = '".$user_pass."' WHERE DoctorID = '".$user_name."' ";
    $result = mysql_query($sql);
    $sql = "UPDATE doctor SET setPass = 0 WHERE DoctorID = '".$user_name."' ";
    $result = mysql_query($sql);
    echo "Logged in Successfully";  
  }
  else if($row['Password'] == $user_pass) echo "Logged in Successfully";  
  else echo "Error: 2)UserID and Password Combination does not exist";
}

else if(mysql_num_rows($result) > 0 && $table_name == "patient") {
  $row = mysql_fetch_array($result); 
  if($row['setPass'] == 1)
  {
    $sql = "UPDATE patient SET Password = '".$user_pass."' WHERE PatientID = '".$user_name."' ";
    $result = mysql_query($sql);
    $sql = "UPDATE patient SET setPass = 0 WHERE PatientID = '".$user_name."' ";
    $result = mysql_query($sql);
    echo "Logged in Successfully";
  }
  else if($row['Password'] == $user_pass) echo "Logged in Successfully";  
  else echo "Error: 2)UserID and Password Combination does not exist";
}

else echo "Error: 1)UserID and Password Combination does not exist";
?>		